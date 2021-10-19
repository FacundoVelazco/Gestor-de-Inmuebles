package Gestores.GestoreGUI;

import GUI.Panel;
import Gestores.GestoreGUI.GestorGUITest.panelTest1;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Stack;

public class GestorGUI {
    public static JFrame framePrincipal = new JFrame();
    static ArrayList<PanelWrap> paneles = new ArrayList<PanelWrap>();
    static Stack<Panel> historia = new Stack<Panel>();

    public static void add(PanelWrap nuevoPanel) {
        paneles.add(nuevoPanel);
    }

    public static void init(String nombrePanel) {
        push(nombrePanel);
        framePrincipal.pack();
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setVisible(true);
    }
    private void cambiarTitulo(String newTitulo){framePrincipal.setTitle(newTitulo);}

    public static void push(String nombrePanel) {
        PanelWrap proximoPanel = PanelWrap.find(nombrePanel,paneles);
        try {
            Constructor constructorPanel = proximoPanel.clase.getConstructor();
            Panel nuevoPanel = (Panel) constructorPanel.newInstance();
            framePrincipal.setContentPane(nuevoPanel);
            framePrincipal.setTitle("Gestor de inmuebles: " + nombrePanel);
            framePrincipal.revalidate();
            historia.push(nuevoPanel);
        } catch (NoSuchMethodException e) {
            System.out.format("La pantalla %s no tiene una clase con un constructor válido",nombrePanel);
            e.printStackTrace();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void pop() {
        if (historia.size() > 1) {
            JPanel panelActual = historia.pop();
            framePrincipal.setContentPane(historia.lastElement());
            framePrincipal.setTitle("Gestor de inmuebles: " + (historia.lastElement().getTitulo()));
            framePrincipal.revalidate();
        } else {
            System.out.println("El stack del gestor de pantallas ya está en la base de la pila.");
        }
    }

    public static void popToTop() {
        while (historia.size() > 1) {
            pop();
        };
    };

    public static JPanel peek(){
        return historia.peek();
    }
}
