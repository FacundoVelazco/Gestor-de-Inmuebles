package GUI.Panels;

import Domain.Cliente;
import Domain.Util.TipoUser;
import GUI.Util.Pantalla;
import Services.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaMenuPrincipal {
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
    private JLabel labelImagen;
    private JButton buttonCerrarSesion;
    private JLabel labelOpciones;
    private JButton catalogoInmueblesButton;
    private JButton modificarDatosUsuarioButton;
    private TipoUser tipoUsuarioLogueado;

    public PantallaMenuPrincipal() {

        labelImagen.setIcon(new ImageIcon("src/main/java/Materials/GestorDeInmueblesrecortado.png"));



        //TODO REMOVER, SOLO PARA PRUEBAS
        if(GestorUsuarios.getUsuarioLogueado() != null){
            tipoUsuarioLogueado =GestorUsuarios.getUsuarioLogueado().getTipo();
            switch (tipoUsuarioLogueado){
                case ADMIN:
                    labelDescripcion.setText("Usted se ha logueado como Administrador");
                    setFuncionalidades(GestorUsuarios.getUsuarioLogueado().getTipo());
                    break;
                case CLIENTE:
                    labelDescripcion.setText("Usted se ha logueado como Cliente");
                    setFuncionalidades(GestorUsuarios.getUsuarioLogueado().getTipo());
                    break;
                case VENDEDOR:
                    labelDescripcion.setText("Usted se ha logueado como Vendedor");
                    setFuncionalidades(GestorUsuarios.getUsuarioLogueado().getTipo());
                    break;
                case PROPIETARIO:
                    labelDescripcion.setText("Usted se ha logueado como Propietario");
                    setFuncionalidades(GestorUsuarios.getUsuarioLogueado().getTipo());
                    break;
            }
        }


        modificarDatosUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (tipoUsuarioLogueado){
                    case CLIENTE:
                        GestorClientes gestorClientes = new GestorClientes();
                        GestorGUI.pushModificar(Pantalla.CREAR_CLIENTE,gestorClientes.getClienteByUsername(GestorUsuarios.getUsuarioLogueado().getUsername()));
                        break;
                    case VENDEDOR:
                        //TODO MOSTRAR MODIFICAR VENDERDOR
                        break;
                    case PROPIETARIO:
                        GestorPropietario gestorPropietario = new GestorPropietario();
                        GestorGUI.pushModificar(Pantalla.CREAR_PROPIETARIO,gestorPropietario.getPropietarioByUsername(GestorUsuarios.getUsuarioLogueado().getUsername()));
                        break;
                }
            }
        });

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
                GestorGUI.pushModificar(Pantalla.MIS_INMUEBLES,GestorUsuarios.getUsuarioLogueado().getUsername());
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

        catalogoInmueblesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorClientes gestorClientes = new GestorClientes();
                GestorGUI.pushModificar(Pantalla.CATALOGO,gestorClientes.getClienteByUsername(GestorUsuarios.getUsuarioLogueado().getUsername()).getPreferencias());
            }
        });

        buttonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.abrirLogin();
                GestorUsuarios.setUsuarioLogueado(null);


            }
        });
        altaBajaYModificarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.ABM_VENDEDOR);
            }
        });
        altaBajaYModificarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.ABM_PROPIETARIO);
            }
        });
    }

    private void setFuncionalidades(TipoUser tipo) {
        switch (tipo){
            case ADMIN:
                modificarDatosUsuarioButton.setVisible(false);
                misInmueblesButton.setVisible(false);
                consultarInmuebleButton.setVisible(false);
                buttonReserva.setVisible(false);
                catalogoInmueblesButton.setVisible(false);
                break;
            case CLIENTE:
                altaBajaYModificarButton.setVisible(false);
                altaBajaYModificarButton2.setVisible(false);
                altaBajaYModificarButton3.setVisible(false);
                misInmueblesButton.setVisible(false);
                buttonReserva.setVisible(false);
                break;
            case VENDEDOR:
                altaBajaYModificarButton2.setVisible(false);
                misInmueblesButton.setVisible(false);
                buttonReserva.setVisible(false);
                catalogoInmueblesButton.setVisible(false);
                break;
            case PROPIETARIO:
                altaBajaYModificarButton.setVisible(false);
                altaBajaYModificarButton2.setVisible(false);
                altaBajaYModificarButton3.setVisible(false);
                buttonReserva.setVisible(false);
                catalogoInmueblesButton.setVisible(false);
                break;
        }

    }

    public JPanel getPanelPrincipal(){
        return this.panelPrincipal;
    }


}
