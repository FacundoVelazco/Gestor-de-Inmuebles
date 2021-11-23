package App;

import DAO.LocalidadDAO;
import DAO.LocalidadSqlDAO;
import DAO.ProvinciaDAO;
import DAO.ProvinciaSqlDAO;
import Domain.Barrio;
import Domain.Localidad;
import Domain.Provincia;
import Services.GestorGUI;
import GUI.Util.Pantalla;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        GestorGUI.init(Pantalla.C_INMUEBLE);
    }
}
