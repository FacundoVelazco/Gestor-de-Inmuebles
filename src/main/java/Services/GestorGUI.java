package Services;

import DAO.Util.ClienteDTO;
import DAO.Util.InmuebleDTO;
import DAO.Util.PreferenciaDTO;
import DAO.Util.VendedorDTO;
import DAO.Util.PropietarioDTO;
import GUI.Panels.*;
import GUI.Util.Pantalla;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.Stack;

public class GestorGUI {

    static JFrame framePrincipal = new JFrame();

    static Stack<Pantalla> historia = new Stack<>();


    private static void setPantalla(Pantalla pantalla, Object elemento){
        switch (pantalla){

            case MENU_PRINCIPAL:
                framePrincipal.setContentPane(new PantallaMenuPrincipal().getPanelPrincipal());
                break;

            case ABM_CLIENTE:
                framePrincipal.setContentPane(new PantallaABMCliente().getPanelPrincipal());
                break;

            case ABM_PROPIETARIO:
                framePrincipal.setContentPane(new PantallaABMPropietario().getPanelPrincipal());
                break;

            case CREAR_CLIENTE:
                PantallaCrearCliente pantallaCrearCliente;
                if(elemento == null){
                    pantallaCrearCliente = new PantallaCrearCliente();
                }else{
                    pantallaCrearCliente = new PantallaCrearCliente((ClienteDTO) elemento);
                }
                framePrincipal.setContentPane(pantallaCrearCliente.getPanelPrincipal());
                break;

            case AM_INMUEBLE:
                PantallaAMInmueble p;
                if (elemento instanceof String){
                     p = new PantallaAMInmueble((String) elemento);
                }else{
                    p = new PantallaAMInmueble((InmuebleDTO) elemento);
                }
                framePrincipal.setContentPane(p.getPanelPrincipal());
                break;
            
            case MIS_INMUEBLES:
                framePrincipal.setContentPane(new PantallaMisInmuebles((String) elemento).getPanelPrincipal());
                framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                break;

            case C_INMUEBLE:
                framePrincipal.setContentPane(new PantallaCInmueble().getPanelPrincipal());
                framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
             break;

            case CATALOGO:
                framePrincipal.setContentPane(new PantallaCatalogoInmuebles((PreferenciaDTO) elemento).getPanelPrincipal());
                framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                break;

            case VER_INMUEBLE:
                framePrincipal.setContentPane(new PantallaVerInmueble((InmuebleDTO) elemento).getPanelPrincipal());
                break;

            case CREAR_PROPIETARIO:
                PantallaCrearPropietario pantallaCrearPropietario;
                if(elemento == null){
                    pantallaCrearPropietario = new PantallaCrearPropietario();
                }else{
                    pantallaCrearPropietario = new PantallaCrearPropietario((PropietarioDTO) elemento);
                }
                framePrincipal.setContentPane(pantallaCrearPropietario.getPanelPrincipal());
                break;
            case ABM_VENDEDOR:
                framePrincipal.setContentPane(new PantallaABMVendedor().getPanelPrincipal());
                break;
            case CREAR_VENDEDOR:
                PantallaCrearVendedor pantallaCrearVendedor;
                if(elemento == null){
                    pantallaCrearVendedor = new PantallaCrearVendedor();
                }else{
                    pantallaCrearVendedor = new PantallaCrearVendedor((VendedorDTO) elemento);
                }
                framePrincipal.setContentPane(pantallaCrearVendedor.getPanelPrincipal());
                break;
        }
        framePrincipal.pack();
        framePrincipal.setLocationRelativeTo(null);
    }

    public static void init(Pantalla pantalla) {
        framePrincipal.setIconImage(new ImageIcon(GestorGUI.class.getClassLoader().getResource("G.png"))
                .getImage());
        push(pantalla);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setTitle("Gestor de inmuebles");
        framePrincipal.pack();
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);
        framePrincipal.setResizable(false);
    }

    public static void push(Pantalla pantalla) {
        setPantalla(pantalla, null);
        historia.push(pantalla);
    }

    public static void pushModificar(Pantalla pantalla, Object elemento){
        setPantalla(pantalla, elemento);
        historia.push(pantalla);
    }

    public static void pop() {
        if (historia.size() > 1) {
            historia.pop();
            setPantalla(historia.lastElement(), null);
        } else {
            System.out.println("El stack del gestor de pantallas ya est?? en la base de la pila.");
        }
    }

    public static void popModificar(Object elemento) {
        if (historia.size() > 1) {
            historia.pop();
            framePrincipal.setLocationRelativeTo(null);
            setPantalla(historia.lastElement(), elemento);
        } else {
            System.out.println("El stack del gestor de pantallas ya est?? en la base de la pila.");
        }
    }

    /** Recarga la pantalla actual completamente */
    public static void refreshCurrent(){
        Pantalla pantallaActual = peek();
        pop();
        push(pantallaActual);
    }

    public static void cambiarTitulo(String newTitulo){
        framePrincipal.setTitle(newTitulo);
    }

    public static void popToTop() {
        while (historia.size() > 1) {
            pop();
        }
    }

    public static Pantalla peek(){
        return historia.peek();
    }

    public static void popUpExito(String titulo, String mensaje){
        JOptionPane.showMessageDialog(framePrincipal,mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static Boolean popUpConfirmacion(String titulo, String mensaje){
        Integer confirmacion = JOptionPane.showConfirmDialog(framePrincipal,mensaje,titulo,JOptionPane.YES_NO_OPTION);
        return confirmacion==JOptionPane.YES_OPTION;
    }

    public static void popUpError(String titulo, String mensaje){
        JOptionPane.showMessageDialog(framePrincipal,mensaje,titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void popUpReserva(ClienteDTO cliente, InmuebleDTO inmuebleDTO){
        JFrame framePopUp = new JFrame();
        framePopUp.setIconImage(new ImageIcon(GestorGUI.class.getClassLoader().getResource("G.png"))
                .getImage());
        framePopUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePopUp.setTitle("Generar reserva");
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setVisible(true);
        framePopUp.setContentPane(new PantallaReserva(cliente, inmuebleDTO, framePopUp).getPanelPrincipal());
        framePopUp.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                GestorGUI.enableFramePrincipal();
            }
        });
        framePopUp.pack();
        framePopUp.setResizable(false);
    }

    public static void popUpCompra(ClienteDTO cliente, InmuebleDTO inmuebleDTO){
        JFrame framePopUp = new JFrame();
        framePopUp.setIconImage(new ImageIcon(GestorGUI.class.getClassLoader().getResource("G.png"))
                .getImage());
        framePopUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePopUp.setTitle("Comprar inmueble");
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setVisible(true);
        framePopUp.setContentPane(new PantallaVenta(cliente, inmuebleDTO, framePopUp).getPanelPrincipal());
        framePopUp.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                GestorGUI.enableFramePrincipal();
            }
        });
        framePopUp.pack();
        framePopUp.setResizable(false);

    }


    public static void abrirLogin(){

        if(framePrincipal!=null){
            framePrincipal.dispose();
        }

        JFrame frameLogin = new JFrame();
        frameLogin.setIconImage(new ImageIcon(GestorGUI.class.getClassLoader().getResource("G.png"))
                .getImage());
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setTitle("Gestor de inmuebles");

        frameLogin.setVisible(true);
        frameLogin.setContentPane(new PantallaLogin(frameLogin).getPanelPrincipal());


        frameLogin.setSize(350, 230);
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setResizable(false);
    }

    public static void pack(){
        framePrincipal.pack();
    }

    public static void disableFramePrincipal(){
        framePrincipal.setEnabled(false);
    }

    public static void enableFramePrincipal(){
        framePrincipal.setEnabled(true);
        framePrincipal.toFront();
    }


    public static void exit(){
        framePrincipal.dispatchEvent(new WindowEvent(framePrincipal, WindowEvent.WINDOW_CLOSING));
    }

}
