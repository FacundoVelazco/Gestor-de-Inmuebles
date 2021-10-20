package GUI;

import GUI.Panels.PanelABMCliente;
import TestGUI.panelTest1;
import TestGUI.panelTest2;
import TestGUI.panelTest3;
import jdk.jshell.spi.ExecutionControl;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Stack;

public class GestorGUI {

    static JFrame framePrincipal = new JFrame();
    static Stack<Pantalla> historia = new Stack<>();

    private static void setPantalla(Pantalla pantalla){
        switch (pantalla){
            case ABM_CLIENTE:
                framePrincipal.setContentPane(new PanelABMCliente().getPanelPrincipal());
                break;
            case CREAR_CLIENTE:
                //TODO insertar creación pantalla de crear cliente aqui
                break;
            case panelTest1:
                framePrincipal.setContentPane(new panelTest1()); //TODO remover paneles de testeo
                break;
            case panelTest2:
                framePrincipal.setContentPane(new panelTest2());
                break;
            case panelTest3:
                framePrincipal.setContentPane(new panelTest3());
                break;
        }
        framePrincipal.revalidate();
    }

    public static void init(Pantalla pantalla) {
        push(pantalla);
        framePrincipal.pack();
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setTitle("Gestor de inmuebles");
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
}
