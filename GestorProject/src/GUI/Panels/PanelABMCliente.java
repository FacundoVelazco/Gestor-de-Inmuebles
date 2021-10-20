package GUI.Panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelABMCliente {

    private JPanel panelPrincipal;
    private JLabel titulo;
    private JTable tablaClientes;
    private JButton botonEliminar;
    private JButton botonModificar;
    private JButton botonAgregar;

    public PanelABMCliente() {

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
