package TestGUI;

import GUI.GestorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelTest1 extends JPanel {

    public panelTest1(){

        JButton panel2 = new JButton("ir panel 2");
        JButton panel3 = new JButton("ir panel 3");

        panel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push("panel2");
            }
        });
        panel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push("panel3");
            }
        });
        add(panel2);
        add(panel3);

    }
}
