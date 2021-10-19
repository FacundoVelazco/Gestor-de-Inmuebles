package Gestores.GestoreGUI.GestorGUITest;

import GUI.Panel;
import Gestores.GestoreGUI.GestorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelTest2 extends Panel {
    public panelTest2(String titulo) {
        super(titulo);
    }
    public panelTest2(){
        this("Panel 2");
        JButton panel2 = new JButton("volver");
        panel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
        add(panel2);
    }
}
