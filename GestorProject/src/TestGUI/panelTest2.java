package TestGUI;

import GUI.GestorGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelTest2 extends JPanel {

    public panelTest2(){

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
