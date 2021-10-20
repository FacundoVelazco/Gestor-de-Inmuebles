package TestGUI;

import GUI.GestorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelTest3 extends JPanel {

    public panelTest3(){

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
