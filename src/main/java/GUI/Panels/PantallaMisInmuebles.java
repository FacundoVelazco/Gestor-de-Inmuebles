package GUI.Panels;

import javax.swing.*;
import java.awt.*;

public class PantallaMisInmuebles {
    private JPanel panelPrincipal;
    private JPanel panelTitulos;
    private JPanel panelInmuebles;
    private JPanel panelBotonesInferiores;
    private JPanel panelInmueble1;
    private JPanel panelInmueble2;
    private JPanel panelInmueble4;
    private JPanel panelInmueble3;
    private JPanel panelInmueble5;
    private JPanel panelBotonesPaginador;
    private JLabel tituloLabel;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JButton crearInmuebleButton;
    private JButton atrasButton;
    private JButton buttonModificarProp1;
    private JButton buttonEliminarProp1;
    private JLabel imagenProp1Label;
    private JLabel codigoProp1Label;
    private JLabel localidadProp1Label;
    private JLabel pvDireccionProp1Label;
    private JLabel svDireccionProp1Label;
    private JPanel panelDatosProp1;
    private JPanel panelBotonesProp1;
    private JLabel imagenProp2Label;
    private JLabel imagenProp3Label;
    private JLabel imagenProp4Label;
    private JLabel imagenProp5Label;
    private JPanel panelDatosProp2;
    private JPanel panelDatosProp3;
    private JPanel panelDatosProp4;
    private JPanel panelDatosProp5;
    private JLabel codigoProp2Label;
    private JLabel codigoProp3Label;
    private JLabel codigoProp4Label;
    private JLabel codigoProp5Label;
    private JLabel localidadProp2Label;
    private JLabel localidadProp3Label;
    private JLabel localidadProp4Label;
    private JLabel localidadProp5Label;
    private JLabel pvDireccionProp2Label;
    private JLabel pvDireccionProp3Label;
    private JLabel pvDireccionProp4Label;
    private JLabel pvDireccionProp5Label;
    private JLabel svDireccionProp2Label;
    private JLabel svDireccionProp3Label;
    private JLabel svDireccionProp4Label;
    private JLabel svDireccionProp5Label;
    private JPanel panelBotonesProp2;
    private JPanel panelBotonesProp3;
    private JPanel panelBotonesProp4;
    private JPanel panelBotonesProp5;
    private JButton buttonModificarProp2;
    private JButton buttonModificarProp3;
    private JButton buttonModificarProp4;
    private JButton buttonModificarProp5;
    private JButton buttonEliminarProp2;
    private JButton buttonEliminarProp3;
    private JButton buttonEliminarProp4;
    private JButton buttonEliminarProp5;
    private ImageIcon imagenPorDefecto;


    public PantallaMisInmuebles() {
        //Seteamos la imagen por defecto
        imagenPorDefecto = new ImageIcon(new ImageIcon("src/main/java/Materials/casitadefault.png").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING));
        imagenProp1Label.setIcon(imagenPorDefecto);
        imagenProp2Label.setIcon(imagenPorDefecto);
        imagenProp3Label.setIcon(imagenPorDefecto);
        imagenProp4Label.setIcon(imagenPorDefecto);
        imagenProp5Label.setIcon(imagenPorDefecto);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
