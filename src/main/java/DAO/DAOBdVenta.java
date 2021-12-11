package DAO;

import DAO.Util.Conexion;
import Domain.Venta;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOBdVenta implements VentaDAO{

    @Override
    public Integer save(Venta venta) {
        EntityManager manager = Conexion.emf.createEntityManager();


        manager.getTransaction().begin();
        manager.persist(venta);
        manager.getTransaction().commit();
        manager.close();

        return venta.getId();
    }

}
