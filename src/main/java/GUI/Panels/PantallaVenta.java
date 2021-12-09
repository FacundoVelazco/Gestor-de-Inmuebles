package GUI.Panels;

import DAO.Util.ClienteDTO;
import DAO.Util.InmuebleDTO;
import Services.GestorGUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PantallaVenta {
    private JPanel panelPrincipal;
    private JPanel PanelTitulo;
    private JPanel panelBotones;
    private JLabel labelTitulo;
    private JButton guardarDocumentoButton;
    private JButton salirButton;
    private JLabel labelSubtitulo;
    private JLabel labelNombreCliente;
    private JLabel labelTituloInmueble;
    private JLabel imagenPropLabel;
    private JPanel panelDatosProp;
    private JLabel codigoPropLabel;
    private JLabel localidadPropLabel;
    private JLabel pvDireccionPropLabel;
    private JLabel svDireccionPropLabel;
    private JPanel panelInformacion;
    private JLabel labelInmuebleComprado;
    private JButton imprimirButton;
    private JPanel panelDatosInmueble;
    private JButton comprarButton;
    private JFrame framePadre;

    public PantallaVenta(ClienteDTO cliente, InmuebleDTO inmueble, JFrame framePadre) {
        this.framePadre = framePadre;

        //Init inmueble y cliente
        labelNombreCliente.setText(cliente.getNombre()+ " "+ cliente.getApellido());
        codigoPropLabel.setText("Código: " + inmueble.getId().toString());
        localidadPropLabel.setText("Localidad: " + inmueble.getLocalidad());
        pvDireccionPropLabel.setText("Calle: " + inmueble.getCalle());
        svDireccionPropLabel.setText("Número: " + inmueble.getNumeroCalle().toString());
        imagenPropLabel.setIcon(new ImageIcon(inmueble.getFotoPrincipal().getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));

        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO buscar como imprimir un documento
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePadre.dispose();
            }
        });

        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO agregar lógica de la compra
                GestorGUI.popUpExito("Compra realizada", "Se generó la compra satisfactoriamente a nombre de " + cliente.getNombre() + " " + cliente.getApellido()
                        + ".\nTambién se ha generado el comprobante que puede guardarlo y/o imprimirlo");

                comprarButton.setVisible(false);
                imprimirButton.setVisible(true);
                guardarDocumentoButton.setVisible(true);
                salirButton.setText("Salir");
            }
        });


        guardarDocumentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // TODO logica guardar un archivo y ver como armarlo
                    File ruta = seleccionarPath();
                    generarArchivoCompra(cliente, inmueble, ruta);
                    GestorGUI.popUpExito("Compra generada", "Se genero correctamente la compra a nombre de " + cliente.getNombre() + " " + cliente.getApellido());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(framePadre,"Ha sucedido un error al generar la compra: "
                            + ex.getMessage(),"Ha ocurrido un error en compra", JOptionPane.ERROR_MESSAGE);
                }
            };

            private File seleccionarPath() throws IOException {

                JFileChooser seleccionPath = new JFileChooser();
                seleccionPath.setCurrentDirectory(new File("."));
                seleccionPath.setDialogTitle("Seleccione el archivo donde se guardará la reserva");
                seleccionPath.setFileSelectionMode(JFileChooser.FILES_ONLY);
                seleccionPath.setMultiSelectionEnabled(false);
                seleccionPath.setSelectedFile(new File("Reserva"));
                seleccionPath.setFileFilter(new FileNameExtensionFilter(".txt", ".txt"));
                seleccionPath.setAcceptAllFileFilterUsed(false);
                if(seleccionPath.showSaveDialog(framePadre)==JFileChooser.APPROVE_OPTION){
                    File ruta = new File(seleccionPath.getSelectedFile() + ".txt");
                    return ruta;
                }else{
                    throw new IOException("No se ha seleccionado un archivo para guardar la reserva.");
                }
            }

            private void generarArchivoCompra(ClienteDTO cliente, InmuebleDTO inmueble, File ruta) throws IOException {
                // Escribir el documento
                FileWriter fw = new FileWriter(ruta);
                PrintWriter pw = new PrintWriter(fw);
                pw.println("##################################################################");
                pw.println("Inmueble comprado a nombre de " + cliente.getNombre() + " " + cliente.getApellido());
                pw.println("Código del inmueble: " + inmueble.getId());
                pw.println("Provincia: " + inmueble.getProvincia());
                pw.println("Localidad: " + inmueble.getLocalidad());
                pw.println("Calle: " + inmueble.getCalle());
                pw.println("Nro de Calle: " + inmueble.getNumeroCalle());
                pw.println("##################################################################");

                pw.close();
            }
        });
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
