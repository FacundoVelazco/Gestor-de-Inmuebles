package GUI.Panels;

import DAO.Util.PropietarioDTO;
import Domain.Util.TipoDNI;
import GUI.AutoCompletion;
import Services.GestorGUI;
import Services.GestorPropietario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PantallaCrearPropietario {
    private JPanel panelBotones;
    private JLabel textoTitulo;
    private JLabel textoUser;
    private JLabel textoContrasena;
    private JButton buttonCrear;
    private JButton buttonCancelar;
    private JPanel panelPrincipal;
    private JComboBox comboBoxLocalidad;
    private JComboBox comboBoxProvincia;

    private static final int CHECK_COL = 1;

    private JComboBox comboBoxTipoDocumento;
    private JLabel labelTipoDocumento;
    private JTextField textFieldCalle;
    private JLabel labelLocalidad;
    private JLabel labelProvincia;
    private JTextField textFieldTelefono;
    private JTextField textFieldEmail;
    private JLabel labelEmail;
    private JLabel labelTelefono;
    private JTextField textFieldNumeroDocumento;
    private JPasswordField textFieldContraseña;
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
    private JLabel labelCalle;
    private JTextField textFieldNroDeCalle;
    private JLabel labelNroDeCalle;
    private JLabel labelErrorNroCalle;
    private ActionListener actionListenerCrear;


    private GestorPropietario gestorPropietario = new GestorPropietario();

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
    private  boolean emailValido(String email) {

        boolean valido = false;

        Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mEmail = patronEmail.matcher(email.toLowerCase());
        if (mEmail.matches()){
            valido = true;
        }
        return valido;
    }

    public PantallaCrearPropietario() {

        //Autocompletado de los comboboxes
        AutoCompletion.enable(comboBoxTipoDocumento);
        AutoCompletion.enable(comboBoxLocalidad);
        AutoCompletion.enable(comboBoxProvincia);

        for(TipoDNI t:TipoDNI.values()){
            comboBoxTipoDocumento.addItem(TipoDNI.obtenerStringParaComboBox(t));
        }

        comboBoxProvincia.addItem("Santa Fe");      // TODO Completar las localidades con el metodo que hizo AGUS

        comboBoxLocalidad.addItem("Santa Fe");
        comboBoxLocalidad.addItem("Santo Tome");
        comboBoxLocalidad.addItem("Sauce viejo");
        comboBoxLocalidad.addItem("Rincon");
        comboBoxLocalidad.addItem("Colastine Norte");
        comboBoxLocalidad.addItem("Colastine Sur");

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });

        actionListenerCrear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (verificacion()) { // Si los datos cumplen con las verificaciones = TRUE
                    PropietarioDTO propietarioDTO = collectDataPropietario();
                    gestorPropietario.guardarPropietario(propietarioDTO);
                    GestorGUI.pop();
                }
            }
        };
        buttonCrear.addActionListener(actionListenerCrear);

    }

    public PantallaCrearPropietario(PropietarioDTO pDTO) {
        this();
        buttonCrear.setText("Modificar");
        textoTitulo.setText("Modificar propietario");
        textFieldNombreUsuario.setText(pDTO.getUsername());
        textFieldNombreUsuario.setEnabled(false);
        textFieldNombre.setText(pDTO.getNombre());
        textFieldApellido.setText(pDTO.getApellido());
        textFieldContraseña.setText(pDTO.getPassword());
        textFieldCalle.setText(pDTO.getCalle());
        textFieldNroDeCalle.setText(pDTO.getNroDeCalle());
        textFieldEmail.setText(pDTO.getEmail());
        textFieldTelefono.setText(pDTO.getTelefono());
        textFieldNumeroDocumento.setText(pDTO.getDni());



        //Autocompletado de los comboboxes
        AutoCompletion.enable(comboBoxTipoDocumento);
        AutoCompletion.enable(comboBoxLocalidad);
        AutoCompletion.enable(comboBoxProvincia);

    }



    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private boolean verificacion(){
        boolean bandera = true;

        if (textFieldNombreUsuario.getText().length() > 20 || textFieldNombreUsuario.getText().length() < 5){
            labelErrorUsuario.setVisible(true);
            bandera = false;
        }
        else labelErrorUsuario.setVisible(false);

        if ((textFieldContraseña.getText().length() < 6) || (textFieldContraseña.getText().length() > 20)){
            labelErrorContraseña.setVisible(true);
            bandera = false;
        }
        else labelErrorContraseña.setVisible(false);

        if (textFieldNombre.getText().length() > 20 || textFieldNombre.getText().length() < 3){
            labelErrorNombre.setVisible(true);
            bandera = false;
        }
        else labelErrorNombre.setVisible(false);

        if (textFieldApellido.getText().length() > 20 || textFieldApellido.getText().length() < 2){
            labelErrorApellido.setVisible(true);
            bandera = false;
        }
        else labelErrorApellido.setVisible(false);

        if (!(isInteger(textFieldNumeroDocumento.getText()))){
            labelErrorDocumento.setVisible(true);
            bandera = false;
        }
        else labelErrorDocumento.setVisible(false);


        if (textFieldCalle.getText().length() > 40 || (textFieldApellido.getText().length() < 2)){
            labelErrorCalleNumero.setVisible(true);
            bandera = false;
        }
        else labelErrorCalleNumero.setVisible(false);

        if (!(isInteger(textFieldTelefono.getText()))) {
            labelErrorTelefono.setVisible(true);
            bandera = false;
        }
        if (!(isInteger(textFieldNroDeCalle.getText()))) {
            labelErrorNroCalle.setVisible(true);
            bandera = false;
        }

        else labelErrorTelefono.setVisible(false);

        if ((textFieldEmail.getText().length() > 60) || !(emailValido(textFieldEmail.getText()))){
            labelErrorEmail.setVisible(true);

            bandera = false;
        }
        else labelErrorEmail.setVisible(false);
        GestorGUI.pack();

        return bandera;
    }

    private PropietarioDTO collectDataPropietario() {

        PropietarioDTO propietario = new PropietarioDTO();
        propietario.setUsername(textFieldNombreUsuario.getText());
        propietario.setPassword(textFieldContraseña.getText());
        propietario.setNombre(textFieldNombre.getText());
        propietario.setApellido(textFieldApellido.getText());
        propietario.setTelefono(textFieldTelefono.getText());
        propietario.setLocalidad(comboBoxLocalidad.getSelectedItem().toString());
        return propietario;

    }
}
