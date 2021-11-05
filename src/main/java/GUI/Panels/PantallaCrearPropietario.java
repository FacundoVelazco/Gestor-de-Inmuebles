package GUI.Panels;

import GUI.AutoCompletion;
import GUI.GestorGUI;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaCrearPropietario {
    private JPanel panelTitulo;
    private JPanel panelCampos1;
    private JPanel panelBotones;
    private JLabel textoTitulo;
    private JPanel panelCampos2;
    private JLabel textoUser;
    private JLabel textoContrasena;
    private JButton buttonCrear;
    private JButton buttonCancelar;
    private JPanel panelPrincipal;
    private JPanel panelTituloUbicacionYEmail;
    private JLabel labelSubtitulo;
    private JPanel panelCampos3;
    private JPanel panelCampos4;
    private JComboBox comboBoxLocalidad;
    private JComboBox comboBoxProvincia;

    private static final int CHECK_COL = 1;

    private JComboBox comboBoxTipoDocumento;
    private JLabel labelTipoDocumento;
    private JTextField textFieldCalleNumero;
    private JLabel labelLocalidad;
    private JLabel labelProvincia;
    private JTextField textFieldTelefono;
    private JTextField textFieldEmail;
    private JLabel labelEmail;
    private JLabel labelTelefono;
    private JTextField textFieldNumeroDocumento;
    private JTextField textFieldContraseña;
    private JFormattedTextField textFieldNombreUsuario;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JLabel labelErrorUsuario;
    private JLabel labelErrorNombre;
    private JLabel labelErrorApellido;
    private JLabel labelErrorDocumento;
    private JLabel labelErrorCalleNumero;
    private JLabel labelErrorTelefono;
    private JLabel labelErrorEmail;
    private JLabel labelErrorContraseña;

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

    public PantallaCrearPropietario() {

        //Autocompletado de los comboboxes
        AutoCompletion.enable(comboBoxTipoDocumento);
        AutoCompletion.enable(comboBoxLocalidad);
        AutoCompletion.enable(comboBoxProvincia);

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
        buttonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean bandera = true;

                if (textFieldNombreUsuario.getText().length() > 20){
                    labelErrorUsuario.setVisible(true);
                    bandera = false;
                }

                if ((textFieldContraseña.getText().length() < 6) || (textFieldContraseña.getText().length() > 20)){
                    labelErrorContraseña.setVisible(true);
                    bandera = false;
                }

                if (textFieldNombre.getText().length() > 20){
                    labelErrorNombre.setVisible(true);
                    bandera = false;
                }

                if (textFieldApellido.getText().length() > 20){
                    labelErrorApellido.setVisible(true);
                    bandera = false;
                }

                if (!(isInteger(textFieldNumeroDocumento.getText()))){
                    labelErrorDocumento.setVisible(true);
                    bandera = false;
                }

                if (textFieldCalleNumero.getText().length() > 40){
                    labelErrorCalleNumero.setVisible(true);
                    bandera = false;
                }

                if (!(isInteger(textFieldTelefono.getText()))){
                    labelErrorTelefono.setVisible(true);
                    bandera = false;
                }

                if (textFieldEmail.getText().length() > 60){
                    labelErrorEmail.setVisible(true);
                    bandera = false;
                }

                if (bandera) {
                    GestorGUI.pop();
                }
            }


        });
    }



    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
