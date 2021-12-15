package GUI.Panels;

import DAO.Util.ClienteDTO;
import DAO.Util.InmuebleDTO;
import Services.GestorGUI;
import Services.GestorInmuebles;

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
import java.time.LocalDate;

public class PantallaVenta {
    private JPanel panelPrincipal;
    private JPanel PanelTitulo;
    private JPanel panelBotones;
    private JLabel labelTitulo;
    private JButton guardarDocumentoButton;
    private JButton salirButton;
    private JLabel labelSubtitulo;
    private JLabel labelNombreCliente;
    private JLabel imagenPropLabel;
    private JPanel panelDatosProp;
    private JLabel codigoPropLabel;
    private JLabel localidadPropLabel;
    private JLabel pvDireccionPropLabel;
    private JLabel svDireccionPropLabel;
    private JPanel panelInformacion;
    private JButton imprimirButton;
    private JPanel panelDatosInmueble;
    private JButton comprarButton;
    private JLabel labelPrecio;
    private JLabel tituloInmueble;
    private JFrame framePadre;
    private Integer idCompra;

    public PantallaVenta(ClienteDTO cliente, InmuebleDTO inmueble, JFrame framePadre) {
        this.framePadre = framePadre;

        //Init inmueble y cliente
        labelNombreCliente.setText(cliente.getNombre()+ " "+ cliente.getApellido());
        codigoPropLabel.setText("Código: " + inmueble.getId().toString());
        localidadPropLabel.setText("Localidad: " + inmueble.getLocalidad());
        pvDireccionPropLabel.setText("Calle: " + inmueble.getCalle());
        svDireccionPropLabel.setText("Número: " + inmueble.getNumeroCalle().toString());
        imagenPropLabel.setIcon(new ImageIcon(inmueble.getFotoPrincipal().getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        labelPrecio.setText("Precio: $" + inmueble.getPrecio());

        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Imprimir comprobante de venta no implementado.
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePadre.dispose();
                GestorGUI.enableFramePrincipal();
            }
        });

        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorInmuebles gestorInmuebles = new GestorInmuebles();
                idCompra = gestorInmuebles.generarCompra(cliente,inmueble);
                GestorGUI.popUpExito("Compra realizada", "Se generó la compra satisfactoriamente a nombre de " + cliente.getNombre() + " " + cliente.getApellido()
                        + " por un monto total de: $" + inmueble.getPrecio() + ".\nTambién se ha generado el comprobante que puede guardarlo y/o imprimirlo");


                labelSubtitulo.setText("Usted ha comprado a nombre de: ");
                labelTitulo.setText("¡Compra Exitosa!");
                comprarButton.setVisible(false);
                imprimirButton.setVisible(true);
                guardarDocumentoButton.setVisible(true);
                salirButton.setText("Salir"); //La noche es joven
                framePadre.toFront();
                GestorGUI.pop();
                GestorGUI.enableFramePrincipal();
            }
        });


        guardarDocumentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    File ruta = seleccionarPath();
                    generarArchivoCompra(cliente, inmueble, idCompra,ruta);
                    GestorGUI.popUpExito("Compra generada", "Se genero correctamente la compra a nombre de " + cliente.getNombre() + " " + cliente.getApellido());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(framePadre,"Ha sucedido un error al guardar: "
                            + ex.getMessage(),"Ha ocurrido un error en compra", JOptionPane.ERROR_MESSAGE);
                }
            };

            private File seleccionarPath() throws IOException {

                JFileChooser seleccionPath = new JFileChooser();
                seleccionPath.setCurrentDirectory(new File("."));
                seleccionPath.setDialogTitle("Seleccione el archivo donde se guardará la reserva");
                seleccionPath.setFileSelectionMode(JFileChooser.FILES_ONLY);
                seleccionPath.setMultiSelectionEnabled(false);
                seleccionPath.setSelectedFile(new File("Comprobante_Compra_"+idCompra));
                seleccionPath.setFileFilter(new FileNameExtensionFilter(".txt", ".txt"));
                seleccionPath.setAcceptAllFileFilterUsed(false);
                if(seleccionPath.showSaveDialog(framePadre)==JFileChooser.APPROVE_OPTION){
                    File ruta = new File(seleccionPath.getSelectedFile() + ".txt");
                    return ruta;
                }else{
                    throw new IOException("No se ha seleccionado un archivo para guardar la reserva.");
                }
            }

            private void generarArchivoCompra(ClienteDTO cliente, InmuebleDTO inmueble, Integer idCompra,File ruta) throws IOException {
                // Escribir el documento
                FileWriter fw = new FileWriter(ruta);
                PrintWriter pw = new PrintWriter(fw);
                pw.println("##################################################################");
                pw.println("VENTA CÓDIGO " + idCompra);
                pw.println();
                pw.println("Inmueble comprado a nombre de " + cliente.getNombre() + " " + cliente.getApellido());
                pw.println("Código del inmueble: " + inmueble.getId());
                pw.println("Provincia: " + inmueble.getProvincia());
                pw.println("Localidad: " + inmueble.getLocalidad());
                pw.println("Calle: " + inmueble.getCalle());
                pw.println("Número de Calle: " + inmueble.getNumeroCalle());
                pw.println();
                pw.println();
                pw.println("Precio: $" + inmueble.getPrecio());
                pw.println("##################################################################");

                pw.close();
            }
        });
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
