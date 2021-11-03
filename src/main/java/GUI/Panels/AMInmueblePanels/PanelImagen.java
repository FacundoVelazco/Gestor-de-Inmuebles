package GUI.Panels.AMInmueblePanels;

import javax.swing.*;
import java.awt.*;

public class PanelImagen {
    private JPanel panelPrincipal;
    private JLabel labelFoto;


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


    public void setImagen(String ruta){
        labelFoto.setIcon(new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(497, 497, Image.SCALE_AREA_AVERAGING)));
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
}
