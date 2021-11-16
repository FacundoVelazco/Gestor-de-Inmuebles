package TestGUI;

import Domain.Imagen;
import GUI.Util.Pantalla;
import Services.GestorGUI;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;

public class BufferImageTest {
    public static void main(String[] args) throws Exception {
        ImageIcon imagenExterna = new ImageIcon("C:\\Users\\Facundo\\IdeaProjects\\Gestor-de-Inmuebles\\src\\main\\java\\TestGUI\\Imagen1.jpg");
        Imagen imagen = new Imagen();
        imagen.setImagen(imagenExterna);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        imagen = manager.find(Imagen.class,2);
        manager.getTransaction().commit();
        manager.close();

        ImageIcon imagenFinal = imagen.getImagen();
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        label.setIcon(imagenFinal);
        frame.add(label);
        frame.setVisible(true);
        frame.pack();
    }
}
