package GUI.Panels;

import DAO.Util.ClienteDTO;
import DAO.Util.InmuebleDTO;
import Services.GestorGUI;
import Services.GestorInmuebles;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

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

        //TODO poner precio de la reserva real
        inmueble.setPrecioReserva(167.5f);
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
            }
        });
        buttonGenerarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorInmuebles gi = new GestorInmuebles();

                if(gi.generarReserva(cliente,inmueble,(Integer) spinner1.getValue())){
                    GestorGUI.popUpExito("Reserva generada","Se generó la reserva satisfactoriamente por "
                            +spinner1.getValue()+" día/s a nombre de "+cliente.getNombre() + " " + cliente.getApellido()
                            +".\nTambién se ha generado el comprobante y guardado en la ruta especificada.");
                }else{
                    GestorGUI.popUpExito("Error en reserva","Ha sucedido un error al generar la reserva.");
                }
                framePadre.dispose();
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private void actualizarInfoReserva(){
        labelDiasReserva.setText("La reserva será válida por " + spinner1.getValue() + " día/s");
        labelPrecio.setText("Precio de la reserva: $" + (((Integer) spinner1.getValue()).floatValue())*precioReservaInmueble);
    }
}
