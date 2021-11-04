package GUI.Panels;

import GUI.GestorGUI;
import GUI.Pantalla;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaModificarVendedorPopup {
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JPanel panelCampos;
    private JPanel panelBotones;
    private JLabel labelTitulo;
    private JLabel labelContraseña;
    private JTextField textFieldContraseña;
    private JLabel labelConfirmarContraseña;
    private JTextField textFieldConfirmarContraseña;
    private JButton buttonAceptar;
    private JButton buttonCancelar;
    private JLabel labelContraseñaIncorrecta;



    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public PantallaModificarVendedorPopup(JDialog framePopUp, String nombreUsuario){

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePopUp.dispose();
                // Se deberia cerrar el PopUp
            }
        });
        buttonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Aca vendria la logica de comparar las 2 contraseñas entre si y con la antigua contraseña
                if(textFieldConfirmarContraseña.getText().equals(textFieldContraseña.getText())) { // verificar las contraseñas con la base de datos
                    framePopUp.dispose();
                    GestorGUI.getFrame().setContentPane(new PantallaModificarVendedor(nombreUsuario).getPanelPrincipal()); // Quedo horrible pero por falta de tiempo lo hicimos asi
                    GestorGUI.getFrame().revalidate();
                    GestorGUI.getHistoria().push(Pantalla.MODIFICAR_VENDEDOR);                                             // Las ventanas estan tomando atribuciones que no deberian
                }
                else{
                    labelContraseñaIncorrecta.setVisible(true);
                }
            }
        });
    }
}
