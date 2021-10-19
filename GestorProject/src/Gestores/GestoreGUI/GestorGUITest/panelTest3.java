package Gestores.GestoreGUI.GestorGUITest;

import GUI.Panel;
import Gestores.GestoreGUI.GestorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelTest3 extends Panel {
    public panelTest3(String titulo) {
        super(titulo);
    }
    public panelTest3(){
        this("Panel 3");
        JButton panel2 = new JButton("volver");
        add(panel2);
        panel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
    }
}
