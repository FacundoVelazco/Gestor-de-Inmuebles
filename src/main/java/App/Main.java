package App;

import DAO.Util.Conexion;
import DAO.Util.InmuebleDTO;
import Services.GestorGUI;
import GUI.Util.Pantalla;
import Services.GestorInmuebles;


import javax.persistence.EntityManager;
import javax.swing.*;


public class Main {
    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        EntityManager manager = Conexion.emf.createEntityManager();
        manager.close();
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
        GestorGUI.init(Pantalla.panelTest1);
    }
}
