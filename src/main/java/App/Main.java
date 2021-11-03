package App;

import GUI.GestorGUI;
import GUI.Pantalla;

import javax.swing.*;

public class Main {
    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        GestorGUI.init(Pantalla.ABM_VENDEDOR);
    }
}
