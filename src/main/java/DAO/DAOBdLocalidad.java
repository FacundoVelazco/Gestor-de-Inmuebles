package DAO;

import DAO.Util.Conexion;
import Domain.Inmueble;
import Domain.Localidad;

import javax.persistence.EntityManager;

public class DAOBdLocalidad implements LocalidadDAO {
    @Override
    public Localidad getByName(String name) {

        EntityManager manager = Conexion.emf.createEntityManager();
        Localidad l = (Localidad) manager.createQuery("From Localidad as l Where l.nombre='"+name+"'").getResultList().get(0);
        manager.close();
        return l;
    }
}
