package GUI.Panels;

import GUI.GestorGUI;
import GUI.Pantalla;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaModificarVendedor {
    private JPanel panelPrincipal;
    private JPanel panelTItulo;
    private JPanel panelCampos1;
    private JPanel panelCampos2;
    private JPanel panelBotones;
    private JLabel labelTitulo;
    private JLabel labelNombreUsuario;
    private JTextField textFieldNombreUsuario;
    private JLabel labelContraseña;
    private JTextField textFieldContraseña;
    private JLabel labelNombre;
    private JTextField textFieldNombre;
    private JLabel labelApellido;
    private JTextField textFieldApellido;
    private JLabel labelDNI;
    private JTextField textFieldDNI;
    private JLabel labelLegajo;
    private JTextField textFieldLegajo;
    private JButton cancelarButton;
    private JButton modificarButton;

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public PantallaModificarVendedor(String nombreUsuario){
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { GestorGUI.pop();
            }
        });
        textFieldNombreUsuario.setText(nombreUsuario);
        textFieldNombreUsuario.setEnabled(false);
    }
}
