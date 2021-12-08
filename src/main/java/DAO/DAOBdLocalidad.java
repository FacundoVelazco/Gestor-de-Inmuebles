package DAO;

import DAO.Util.Conexion;
import Domain.Localidad;
import javax.persistence.EntityManager;
import java.util.List;

public class DAOBdLocalidad implements LocalidadDAO {
    @Override
    public void persist(Localidad localidad) {

    }

    @Override
    public Localidad getByName(String name) {

        EntityManager manager = Conexion.emf.createEntityManager();
        Localidad l = (Localidad) manager.createQuery("From Localidad as l Where l.nombre='"+name+"'").getResultList().get(0);
        manager.close();
        return l;
    }

    @Override
    public Localidad getById(Integer id) {
        return null;
    }

    @Override
    public List list() {
        return null;
    }

    @Override
    public void merge(Localidad localidad) {

    }

    @Override
    public void close() {

    }
}
