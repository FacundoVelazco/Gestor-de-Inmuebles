package GUI.Panels;

import GUI.Util.Pantalla;
import Services.GestorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaMenuPrincipal {
    private JPanel panelTitulo;
    private JLabel textoTitulo;
    private JPanel panelPrincipal;
    private JButton altaBajaYModificarButton;
    private JButton altaBajaYModificarButton2;
    private JButton altaBajaYModificarButton3;
    private JButton consultarInmuebleButton;
    private JButton buttonSalir;
    private JLabel labelDescripcion;
    private JButton misInmueblesButton;

    public PantallaMenuPrincipal() {
        buttonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.exit();
            }
        });
        altaBajaYModificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.ABM_CLIENTE);
            }
        });
        altaBajaYModificarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO ABRIR ABM VENDEDOR
            }
        });
        altaBajaYModificarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO ABRIR ABM PROPIETARIO
            }
        });
        consultarInmuebleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.C_INMUEBLE);
            }
        });
        misInmueblesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.MIS_INMUEBLES);
            }
        });
    }

    public JPanel getPanelPrincipal(){
        return this.panelPrincipal;
    }
}
