package GUI.Panels;

import GUI.GestorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PantallaCrearVendedor {
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JPanel panelCampos1;
    private JPanel panelCampos2;
    private JPanel panelBotones;
    private JLabel labelNombreUsuario;
    private JTextField textFieldNombreUsuario;
    private JLabel labelContraseña;
    private JTextField textFieldContraseña;
    private JLabel labelConfirmarContraseña;
    private JTextField textField1;
    private JLabel labelNombre;
    private JTextField textFieldNombre;
    private JLabel labelApellido;
    private JTextField textFieldApellido;
    private JLabel labelDNI;
    private JTextField textField2;
    private JLabel labelLegajo;
    private JTextField textFieldLegajo;
    private JButton cancelarButton;
    private JButton crearVendedorButton;




    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public PantallaCrearVendedor(){
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
        crearVendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
    }


}
