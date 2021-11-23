package Services;

import DAO.Util.InmuebleDTO;
import GUI.Panels.PantallaABMCliente;
import GUI.Panels.PantallaAMInmueble;
import GUI.Panels.PantallaCInmueble;
import GUI.Panels.PantallaCrearCliente;
import GUI.Panels.AMInmueblePanels.PanelImagen;
import GUI.Panels.PantallaMisInmuebles;
import GUI.Util.Pantalla;
import TestGUI.PanelTest2;
import TestGUI.PanelTest3;
import javax.swing.*;
import java.util.Stack;

public class GestorGUI {

    static JFrame framePrincipal = new JFrame();
    static Stack<Pantalla> historia = new Stack<>();

    private static void setPantalla(Pantalla pantalla, Object elemento){
        switch (pantalla){

            case ABM_CLIENTE:
                framePrincipal.setContentPane(new PantallaABMCliente().getPanelPrincipal());
                break;
            case CREAR_CLIENTE:
                framePrincipal.setContentPane(new PantallaCrearCliente().getPanelPrincipal());
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
                break;

            case C_INMUEBLE:
                framePrincipal.setContentPane(new PantallaCInmueble().getPanelPrincipal());
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

    public static void popUpExito(String titulo, String mensaje){
        JOptionPane.showMessageDialog(framePrincipal,mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
    }

}
