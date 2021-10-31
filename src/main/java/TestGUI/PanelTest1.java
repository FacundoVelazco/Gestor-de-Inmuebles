package TestGUI;

import Services.GestorGUI;
import GUI.Util.Pantalla;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTest1 extends JPanel {

    public PanelTest1(){

        JButton panel2 = new JButton("ir panel 2");
        JButton panel3 = new JButton("ir panel 3");

        panel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.panelTest2);
            }
        });
        panel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.panelTest3);
            }
        });
        add(panel2);
        add(panel3);

    }
}
