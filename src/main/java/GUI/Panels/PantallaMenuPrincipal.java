package GUI.Panels;

import GUI.Util.Pantalla;
import Services.GestorClientes;
import Services.GestorGUI;
import Services.GestorInmuebles;

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
    private JButton buttonReserva;

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
        buttonReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Estos clientes e inmuebles son de prueba
                GestorClientes gestorClientes=new GestorClientes();
                GestorInmuebles gestorInmuebles=new GestorInmuebles();
                GestorGUI.popUpReserva(gestorClientes.listarClientes().get(0),gestorInmuebles.listarInmuebles(1,2).get(0));
            }
        });
    }

    public JPanel getPanelPrincipal(){
        return this.panelPrincipal;
    }
}
