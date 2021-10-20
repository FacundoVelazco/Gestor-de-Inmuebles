package GUI;

import java.util.ArrayList;

public class PanelWrap {
    public String nombre;
    public Class clase;

    public PanelWrap(String nombre, Class clase) {
        this.nombre = nombre;
        this.clase = clase;
    }
    public static PanelWrap find(String nombre, ArrayList<PanelWrap> paneles) {
        for (PanelWrap panel : paneles) {
            if (panel.nombre.equals(nombre)) return panel;
        }
        return paneles.get(0);
    }
}
