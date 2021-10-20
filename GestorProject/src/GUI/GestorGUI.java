package GUI;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Stack;


/**
 * Para añadir paneles a la interfaz debemos pasarle al método GestorGUI.add() un
 * PanelWrap con el nombre y la clase del panel.
 * Una vez añadidos los paneles, para iniciar la interfaz llamaremos al método
 * GestorGUI.init(String nombrePanel) donde nombrePanel es el nombre del panel de
 * alguno de los panelWraps que hayamos agregado al gestor con el que querramos inicializar.
 */
public class GestorGUI {
    static JFrame framePrincipal = new JFrame();
    static ArrayList<PanelWrap> paneles = new ArrayList<PanelWrap>();
    static Stack<JPanel> historia = new Stack<>();

    public static void add(PanelWrap nuevoPanel) {
        paneles.add(nuevoPanel);
    }

    public static void init(String nombrePanel) {
        push(nombrePanel);
        framePrincipal.pack();
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setTitle("Gestor de inmuebles");
        framePrincipal.setVisible(true);
    }

    public static void push(String nombrePanel) {
        PanelWrap proximoPanel = PanelWrap.find(nombrePanel,paneles);
        try {
            Constructor constructorPanel = proximoPanel.clase.getConstructor();
            JPanel nuevoPanel = (JPanel) constructorPanel.newInstance();
            framePrincipal.setContentPane(nuevoPanel);
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
            framePrincipal.revalidate();
        } else {
            System.out.println("El stack del gestor de pantallas ya está en la base de la pila.");
        }
    }

    public static void cambiarTitulo(String newTitulo){framePrincipal.setTitle(newTitulo);}

    public static void popToTop() {
        while (historia.size() > 1) {
            pop();
        };
    };

    public static JPanel peek(){
        return historia.peek();
    }
}
