package GUI.Panels;

import DAO.Util.ClienteDTO;
import DAO.Util.InmuebleDTO;
import Services.GestorGUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.framePadre=framePadre;

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
                GestorGUI.popUpExito("Compra realizada","Se generó la compra satisfactoriamente a nombre de "+cliente.getNombre() + " " + cliente.getApellido()
                +".\nTambién se ha generado el comprobante que puede guardarlo y/o imprimirlo");

                comprarButton.setVisible(false);
                imprimirButton.setVisible(true);
                guardarDocumentoButton.setVisible(true);
                salirButton.setText("Salir");
            }
        });

        guardarDocumentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO logica guardar un archivo y ver como armarlo
                
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

}
