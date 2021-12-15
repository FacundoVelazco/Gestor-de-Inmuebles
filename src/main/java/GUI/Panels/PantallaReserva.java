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
import java.awt.event.ComponentAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class PantallaReserva {
    private JLabel labelTitulo;
    private JLabel labelTituloDatosCliente;
    private JLabel labelNombreCliente;
    private JPanel panelPrincipal;
    private JLabel labelTituloInmueble;
    private JLabel imagenPropLabel;
    private JPanel panelDatosProp;
    private JLabel codigoPropLabel;
    private JLabel localidadPropLabel;
    private JLabel pvDireccionPropLabel;
    private JLabel svDireccionPropLabel;
    private JLabel labelTituloTiempo;
    private JLabel labelDiasReserva;
    private JLabel labelPrecio;
    private JSpinner spinner1;
    private JPanel panelDatosReserva;
    private JButton buttonCancelar;
    private JButton buttonGenerarReserva;
    private Float precioReservaInmueble;
    private JFrame framePadre;

    public PantallaReserva(ClienteDTO cliente, InmuebleDTO inmueble, JFrame framePadre) {
        this.framePadre=framePadre;

        precioReservaInmueble= inmueble.getPrecioReserva();

        //Init inmueble y cliente
        labelNombreCliente.setText(cliente.getNombre()+ " "+ cliente.getApellido());
        codigoPropLabel.setText("Código: " + inmueble.getId().toString());
        localidadPropLabel.setText("Localidad: " + inmueble.getLocalidad());
        pvDireccionPropLabel.setText("Calle: " + inmueble.getCalle());
        svDireccionPropLabel.setText("Número: " + inmueble.getNumeroCalle().toString());
        imagenPropLabel.setIcon(new ImageIcon(inmueble.getFotoPrincipal().getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));

        //Init spinner
        spinner1.setModel(new SpinnerNumberModel(1,1,365,1));
        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                actualizarInfoReserva();
            }
        });
        actualizarInfoReserva();
        panelDatosReserva.setToolTipText("El precio diario de la reserva para este inmueble es de $"+ precioReservaInmueble);


        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePadre.dispose();
                GestorGUI.enableFramePrincipal();
            }
        });
        buttonGenerarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorInmuebles gi = new GestorInmuebles();
                Integer dias = (Integer) spinner1.getValue();
                try {
                    Integer idReserva = gi.generarReserva(cliente,inmueble,dias);
                    generarArchivoReserva(cliente,inmueble,dias,idReserva,seleccionarPath());
                    GestorGUI.popUpExito("Reserva generada","Se generó la reserva satisfactoriamente por "
                            +spinner1.getValue()+" día/s a nombre de "+cliente.getNombre() + " " + cliente.getApellido()
                            +".\nTambién se ha generado el comprobante y guardado en la ruta especificada.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(framePadre,"Ha sucedido un error al generar la reserva: "
                            + ex.getMessage(),"Ha ocurrido un error en reserva", JOptionPane.ERROR_MESSAGE);
                }
                GestorGUI.enableFramePrincipal();
                framePadre.dispose();
                GestorGUI.pop();
            }
        });
    }

    private void actualizarInfoReserva(){
        labelDiasReserva.setText("La reserva será válida por " + spinner1.getValue() + " día/s");
        labelPrecio.setText("Precio de la reserva: $" + (((Integer) spinner1.getValue()).floatValue())*precioReservaInmueble);
    }

    private File seleccionarPath() throws IOException {

        JFileChooser seleccionPath = new JFileChooser();
        seleccionPath.setCurrentDirectory(new File("."));
        seleccionPath.setDialogTitle("Seleccione el archivo donde se guardará la reserva");
        seleccionPath.setFileSelectionMode(JFileChooser.FILES_ONLY);
        seleccionPath.setMultiSelectionEnabled(false);
        seleccionPath.setSelectedFile(new File("Comprobante_Reserva"));
        seleccionPath.setFileFilter(new FileNameExtensionFilter(".txt",".txt"));
        seleccionPath.setAcceptAllFileFilterUsed(false);
        if(seleccionPath.showSaveDialog(framePadre)==JFileChooser.APPROVE_OPTION){
            File ruta = new File(seleccionPath.getSelectedFile() + ".txt");
            return ruta;
        }else{
            throw new IOException("No se ha seleccionado un archivo para guardar la reserva.");
        }

    }
    private void generarArchivoReserva(ClienteDTO cliente, InmuebleDTO inmueble, Integer dias,Integer idReserva,File ruta) throws IOException {

        FileWriter fw = new FileWriter(ruta);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("##################################################################");
        pw.println("RESERVA CÓDIGO " + idReserva);
        pw.println();
        pw.println("Inmueble reservado a nombre de " + cliente.getNombre() + " " + cliente.getApellido());
        pw.println("Código del inmueble: " + inmueble.getId());
        pw.println("Provincia: " + inmueble.getProvincia());
        pw.println("Localidad: " + inmueble.getLocalidad());
        pw.println("Calle: " + inmueble.getCalle());
        pw.println("Número de Calle: " + inmueble.getNumeroCalle());
        pw.println();
        pw.println();
        pw.println("Vigencia de la reserva: hasta el " + LocalDate.now().plusDays(dias));
        pw.println("Precio total: $" + inmueble.getPrecioReserva()*dias);
        pw.println("##################################################################");

        pw.close();
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

}
