package GUI.Panels;

import DAO.Util.CredencialesInexistentesException;
import Domain.Util.TipoInmueble;
import Domain.Util.TipoUser;
import Domain.Util.Usuario;
import GUI.Util.Pantalla;
import Services.GestorGUI;
import Services.GestorUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaLogin {
    private JLabel tituloLogin;
    private JButton buttonIniciar;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JLabel labelContraseña;
    private JLabel labelUsername;
    private JLabel labelSoy;
    private JComboBox comboBoxTipoUsuario;
    private JPanel panelPrincipal;
    private JLabel labelError;
    private JFrame framePadre;

    public PantallaLogin(JFrame framePadre) {
    this.framePadre=framePadre;
    GestorUsuarios gestorUsuarios = new GestorUsuarios();

    for (TipoUser tipo:TipoUser.values()){
        comboBoxTipoUsuario.addItem(tipo);
    }



        buttonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    labelError.setVisible(false);
                    Usuario usuarioLogueandose = gestorUsuarios.getUsuario(textFieldUsername.getText(),new String(passwordField.getPassword()),
                            (TipoUser) comboBoxTipoUsuario.getSelectedItem());
                    GestorUsuarios.setUsuarioLogueado(usuarioLogueandose);
                    GestorGUI.init(Pantalla.MENU_PRINCIPAL);
                    framePadre.dispose();
                } catch (CredencialesInexistentesException ex) {
                    labelError.setText(ex.getMessage());
                    labelError.setVisible(true);
                }
            }
        });
        comboBoxTipoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setVisible(false);
            }
        });
        textFieldUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setVisible(false);
            }
        });
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setVisible(false);
            }
        });
    }

    public JPanel getPanelPrincipal(){
        return panelPrincipal;
    }
}
