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
    private JTextField textFieldConfirmarContraseña;
    private JLabel labelNombre;
    private JTextField textFieldNombre;
    private JLabel labelApellido;
    private JTextField textFieldApellido;
    private JLabel labelDNI;
    private JTextField textFieldDNI;
    private JLabel labelLegajo;
    private JTextField textFieldLegajo;
    private JButton cancelarButton;
    private JButton crearVendedorButton;
    private JLabel labelErrorUsuario;
    private JLabel labelErrorContraseña;
    private JLabel labelErrorConfirmarContraseña;
    private JLabel labelErrorNombre;
    private JLabel labelErrorApellido;
    private JLabel labelErrorDNI;
    private JLabel labelErrorLegajo;

    /*Método que retorna true si un string es un numero entero escrito como string*/

    public boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public PantallaCrearVendedor(){
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
                GestorGUI.updateFramePrincipal();
            }
        });
        crearVendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean bandera = true;

                if (textFieldNombreUsuario.getText().length() > 20 || textFieldNombreUsuario.getText().length() < 5){
                    labelErrorUsuario.setVisible(true);
                    bandera = false;
                }
                else labelErrorUsuario.setVisible(false);

                if ((textFieldContraseña.getText().length() < 6) || (textFieldContraseña.getText().length() > 25)){
                    labelErrorContraseña.setVisible(true);
                    bandera = false;
                }
                else labelErrorContraseña.setVisible(false);

                if (!textFieldConfirmarContraseña.getText().equals(textFieldContraseña.getText())){
                    labelErrorConfirmarContraseña.setVisible(true);
                    bandera = false;
                }
                else labelErrorConfirmarContraseña.setVisible(false);

                if (textFieldNombre.getText().length() > 30 || textFieldNombre.getText().length() < 3){
                    labelErrorNombre.setVisible(true);
                    bandera = false;
                }
                else labelErrorNombre.setVisible(false);

                if (textFieldApellido.getText().length() > 30 || textFieldApellido.getText().length() < 2){
                    labelErrorApellido.setVisible(true);
                    bandera = false;
                }
                else labelErrorApellido.setVisible(false);

                if (!(isInteger(textFieldDNI.getText())) || textFieldDNI.getText().length() < 7 || textFieldDNI.getText().length() > 9){
                    labelErrorDNI.setVisible(true);
                    bandera = false;
                }
                else labelErrorDNI.setVisible(false);

                if (!(isInteger(textFieldLegajo.getText())) || textFieldLegajo.getText().length() != 6){
                    labelErrorLegajo.setVisible(true);
                    bandera = false;
                }
                else labelErrorLegajo.setVisible(false);

                GestorGUI.updateFramePrincipal();

                if(bandera){
                    GestorGUI.pop();
                }
            }
        });
    }


}
