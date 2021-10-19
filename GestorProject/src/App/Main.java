package App;

import GUI.FrameTest;
import GUI.GUI_ABM_Cliente;

import javax.swing.*;

public class Main {
    public static void main(String args[]){
        FrameTest frame = new FrameTest("Test");
        frame.setSize(1280,720);
        GUI_ABM_Cliente panel = new GUI_ABM_Cliente();
        frame.setTitle("Gestor de inmuebles: " + panel.getNombrePanel());
        frame.setContentPane(panel.getPanelPrincipalGuiCliente());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
