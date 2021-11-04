package GUI.Panels;

import GUI.AutoCompletion;
import GUI.GestorGUI;

import javax.swing.*;
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
    private JTextField textFieldNombreUsuario;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;

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
                GestorGUI.pop();
            }
        });
    }



    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

}
