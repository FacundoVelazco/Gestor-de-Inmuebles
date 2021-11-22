package DAO.Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
}
