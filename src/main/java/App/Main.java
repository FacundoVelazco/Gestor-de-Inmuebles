package App;

import DAO.DAOBdUsuario;
import DAO.Util.Conexion;
import Domain.Admin;
import Domain.Cliente;
import Domain.Util.TipoUser;
import Domain.Util.Usuario;
import Services.GestorGUI;
import GUI.Util.Pantalla;
import Services.GestorUsuarios;
import org.hibernate.mapping.UnionSubclass;


import javax.persistence.EntityManager;
import javax.swing.*;


public class Main {
    public static void main(String args[]) throws Exception {
        //Look and feel para el GUI
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        //Preinicialización de la BD
        EntityManager manager = Conexion.emf.createEntityManager();
        manager.close();

        //Pantalla de login
        GestorGUI.abrirLogin();
//        GestorUsuarios gu = new GestorUsuarios();
//        GestorUsuarios.setUsuarioLogueado(gu.getUsuario("bruno","1234",TipoUser.ADMIN));
//        GestorGUI.init(Pantalla.MENU_PRINCIPAL);
    }
}
