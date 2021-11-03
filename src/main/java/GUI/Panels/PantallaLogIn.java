package GUI.Panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaLogIn {
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JPanel panelAccesoDatos;
    private JPanel panelBotones;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JLabel labelTitulo;
    private JLabel labelUsuario;
    private JLabel labelContrasenia;
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldContraseña;

    public PantallaLogIn() { // Falta toda la logica

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(passwordFieldContraseña.getPassword());
            }
        });
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
