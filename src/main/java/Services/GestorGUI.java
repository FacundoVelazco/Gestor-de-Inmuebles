package Services;

import DAO.Util.ClienteDTO;
import DAO.Util.InmuebleDTO;
import GUI.Panels.*;
import GUI.Panels.AMInmueblePanels.PanelImagen;
import GUI.Util.Pantalla;
import TestGUI.PanelTest2;
import TestGUI.PanelTest3;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Stack;

public class GestorGUI {

    static JFrame framePrincipal = new JFrame();
    static Stack<Pantalla> historia = new Stack<>();

    //Variables para obtener tamaño de pantalla
    static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    static Point centerPoint = ge.getCenterPoint();

    private static void setPantalla(Pantalla pantalla, Object elemento){
        switch (pantalla){

            case MENU_PRINCIPAL:
                framePrincipal.setContentPane(new PantallaMenuPrincipal().getPanelPrincipal());
                break;

            case ABM_CLIENTE:
                framePrincipal.setContentPane(new PantallaABMCliente().getPanelPrincipal());
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
                if (elemento == null){
                     p = new PantallaAMInmueble();
                }else{
                    p = new PantallaAMInmueble((InmuebleDTO) elemento);
                }
                framePrincipal.setContentPane(p.getPanelPrincipal());
                break;
            
            case MIS_INMUEBLES:
                framePrincipal.setContentPane(new PantallaMisInmuebles().getPanelPrincipal());
                framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                break;

            case C_INMUEBLE:
                framePrincipal.setContentPane(new PantallaCInmueble().getPanelPrincipal());
                framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                break;
            case COMPRA_INMUEBLE:
                framePrincipal.setContentPane(new PantallaVenta(new ClienteDTO(),new InmuebleDTO(),framePrincipal).getPanelPrincipal());
                break;

            //TODO insertar creación de pantallas en cada case
            case panelTest1:
                framePrincipal.setContentPane(new PanelImagen().getPanelPrincipal()); //TODO remover paneles de testeo
                break;
            case panelTest2:
                framePrincipal.setContentPane(new PanelTest2());
                break;
            case panelTest3:
                framePrincipal.setContentPane(new PanelTest3());
                break;
        }
        framePrincipal.revalidate();
        framePrincipal.pack();
    }

    public static void init(Pantalla pantalla) {
        framePrincipal.setIconImage(new ImageIcon("src/main/java/Materials/casitadefault.png")
                .getImage());
        push(pantalla);
        framePrincipal.pack();
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setTitle("Gestor de inmuebles");
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);
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
            framePrincipal.setLocationRelativeTo(null);
            setPantalla(historia.lastElement(), null);
        } else {
            System.out.println("El stack del gestor de pantallas ya está en la base de la pila.");
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

    public static void popUpReserva(ClienteDTO cliente, InmuebleDTO inmuebleDTO){
        JFrame framePopUp = new JFrame();
        framePopUp.setIconImage(new ImageIcon("src/main/java/Materials/casitadefault.png")
                .getImage());
        framePopUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePopUp.setTitle("Generar reserva");
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setVisible(true);
        framePopUp.setContentPane(new PantallaReserva(cliente, inmuebleDTO, framePopUp).getPanelPrincipal());
        framePopUp.pack();

    }
    public static void popUpCompra(ClienteDTO cliente, InmuebleDTO inmuebleDTO){
        JFrame framePopUp = new JFrame();
        framePopUp.setIconImage(new ImageIcon("src/main/java/Materials/casitadefault.png")
                .getImage());
        framePopUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePopUp.setTitle("Comprar inmueble");
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setVisible(true);
        framePopUp.setContentPane(new PantallaVenta(cliente, inmuebleDTO, framePopUp).getPanelPrincipal());
        framePopUp.pack();

    }

    public static void exit(){
        framePrincipal.dispatchEvent(new WindowEvent(framePrincipal, WindowEvent.WINDOW_CLOSING));
    }

}
