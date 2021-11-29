package DAO;

import Domain.Direccion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DireccionSqlDAO implements DireccionDAO{
    EntityManagerFactory entityManagerFactory;
    EntityManager manager;

    public DireccionSqlDAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        manager = entityManagerFactory.createEntityManager();
    }
    @Override
    public void persist(Direccion direccion) {
        manager.getTransaction().begin();
        manager.persist(direccion);
        manager.getTransaction().commit();
    }

    @Override
    public Direccion getById(Integer id) {
        return manager.find(Direccion.class,id);
    }

    @Override
    public List list() {
        Query query = manager.createQuery("FROM Direccion",Direccion.class);
        return query.getResultList();
    }

    @Override
    public void merge(Direccion direccion) {
        manager.merge(direccion);
    }

    @Override
    public void close() {
        manager.close();
    }
}
