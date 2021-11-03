package GUI;

import GUI.Panels.*;
import TestGUI.PanelTest1;
import TestGUI.PanelTest2;
import TestGUI.PanelTest3;
import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class GestorGUI {

    static JFrame framePrincipal = new JFrame();
    static Stack<Pantalla> historia = new Stack<>();

    private static void setPantalla(Pantalla pantalla){
        switch (pantalla){

            case ABM_CLIENTE:
                framePrincipal.setContentPane(new PantallaABMCliente().getPanelPrincipal());
                break;
            case ABM_VENDEDOR:
                framePrincipal.setContentPane(new PantallaABMVendedor().getPanelPrincipal());
                break;
            case CREAR_CLIENTE:
                framePrincipal.setContentPane(new PantallaCrearCliente().getPanelPrincipal());
                break;
            case CREAR_VENDEDOR:
                framePrincipal.setContentPane(new PantallaCrearVendedor().getPanelPrincipal());
                break;
            case MODIFICAR_VENDEDOR:
                framePrincipal.setContentPane(new PantallaModificarVendedor().getPanelPrincipal());
                break;
            case MODIFICAR_VENDEDOR_POPUP:
                framePrincipal.setContentPane(new PantallaModificarVendedorPopup().getPanelPrincipal());
                break;
            case LOGIN:
                framePrincipal.setContentPane(new PantallaLogIn().getPanelPrincipal());
                break;
            //TODO insertar creación de pantallas en cada case
            case panelTest1:
                framePrincipal.setContentPane(new PanelTest1()); //TODO remover paneles de testeo
                break;
            case panelTest2:
                framePrincipal.setContentPane(new PanelTest2());
                break;
            case panelTest3:
                framePrincipal.setContentPane(new PanelTest3());
                break;
        }
        framePrincipal.revalidate();
    }

    public static void init(Pantalla pantalla) {
        push(pantalla);
        framePrincipal.pack();
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setTitle("Gestor de inmuebles");
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);
    }

    public static void push(Pantalla pantalla) {
        setPantalla(pantalla);
        historia.push(pantalla);
    }

    public static void pop() {
        if (historia.size() > 1) {
            historia.pop();
            setPantalla(historia.lastElement());
        } else {
            System.out.println("El stack del gestor de pantallas ya está en la base de la pila.");
        }
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

    public static Frame getFrame() {
        return framePrincipal;
    }
}
