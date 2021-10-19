package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_ABM_Cliente {

    private JLabel campoNombre;
    private JTextField textField1;
    private JButton button1;
    private JPanel panelPrincipalGuiCliente;
    private String nombrePanel;

    public String getNombrePanel() {
        return nombrePanel;
    }

    public JPanel getPanelPrincipalGuiCliente() {
        return panelPrincipalGuiCliente;
    }

    public GUI_ABM_Cliente() {
        nombrePanel="Menú de Clientes";

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoNombre.setText("Boton clickeado");
            }
        });
    }



}
