package App;

import DAO.InmuebleDAO;
import DAO.InmuebleSqlDAO;
import DAO.LocalidadDAO;
import DAO.LocalidadSqlDAO;
import Domain.*;
import Services.GestorGUI;
import GUI.Util.Pantalla;
import Services.GestorInmuebles;
import Services.GestorLocalidades;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        GestorInmuebles gestorInmuebles = new GestorInmuebles();
//        GestorLocalidades gestorLocalidades = new GestorLocalidades();
//        LocalidadDAO localidadDAO = new LocalidadSqlDAO();
//        InmuebleDAO inmuebleDAO = new InmuebleSqlDAO();
//        List<Inmueble> list = new ArrayList();
//        Inmueble inmueble = new Inmueble();
//        inmueble.setLocalidad(new Localidad("Colombia3"));
//        Direccion direccion = new Direccion("barranquitas");
//        direccion.setInmueble(inmueble);
//        inmueble.setDireccion(direccion);
//        inmueble.setPropietarioInmueble(new Propietario());
//        Imagen imagen = new Imagen(); imagen.setImagen(new ImageIcon(new ImageIcon("src/main/java/Materials/casitadefault.png").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
//        inmueble.setFotoPrincipal(imagen);
//        inmuebleDAO.persist(inmueble);
        GestorGUI.init(Pantalla.MENU_PRINCIPAL);
    }
}
