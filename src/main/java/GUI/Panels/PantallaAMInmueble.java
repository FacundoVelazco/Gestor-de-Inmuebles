package GUI.Panels;

import GUI.Panels.AMInmueblePanels.PanelUbicacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaAMInmueble {
    private JPanel panelPrincipal;
    private JPanel panelTitulos;
    private JLabel tituloLabel;
    private JPanel panelRotativo;
    private JPanel panelNoModificables;
    private JLabel codigoLabel;
    private JLabel estadoLabel;
    private JLabel fechaDeCargaLabel;
    private JPanel panelBotonesInferiores;
    private JButton botonCancelar;
    private JButton botonAnterior;
    private JButton botonSiguiente;

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


    public PantallaAMInmueble() {

        panelRotativo = new PanelUbicacion().getPanelUbicacion();

        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelRotativo = new PanelUbicacion().getPanelUbicacion();
               // panelRotativo.set
                System.out.println("Hice algo xd");
            }
        });
    }
}
