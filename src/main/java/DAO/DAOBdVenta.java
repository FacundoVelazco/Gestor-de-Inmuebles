package DAO;

import DAO.Util.Conexion;
import Domain.Venta;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOBdVenta implements VentaDAO{

    @Override
    public void save(Venta venta) {
        EntityManager manager = Conexion.emf.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(venta);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void deleteById(Long id) {
        EntityManager manager = Conexion.emf.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("delete from Venta v where v.id = :id");
        query.setParameter("id",id).executeUpdate();

        manager.getTransaction().commit();
        manager.close();
    }
}
