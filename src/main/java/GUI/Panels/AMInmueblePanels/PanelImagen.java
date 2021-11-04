package GUI.Panels.AMInmueblePanels;

import javax.swing.*;
import java.awt.*;

public class PanelImagen {
    private JPanel panelPrincipal;
    private JLabel labelFoto;


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


    public void setImagenVisible(ImageIcon fotoAMostrar){

        labelFoto.setIcon(fotoAMostrar);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    public ImageIcon obtenerImagen(String ruta){
        ImageIcon imagen = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(497, 497, Image.SCALE_AREA_AVERAGING));
        return imagen;
    }

}
