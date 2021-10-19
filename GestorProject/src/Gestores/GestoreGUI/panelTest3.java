package Gestores.GestoreGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelTest3 extends JPanel {
    String tituloPanel = "PanelTest 3";
    public panelTest3() {
        JButton panel2 = new JButton("volver");
        add(panel2);
        panel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
    }
    public String getTituloPanel() {
        return tituloPanel;
    }
}
