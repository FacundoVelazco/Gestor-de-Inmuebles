package DAO;

import Domain.Barrio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BarrioSqlDAO implements BarrioDAO{
    EntityManagerFactory entityManagerFactory;
    EntityManager manager;

    public BarrioSqlDAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        manager = entityManagerFactory.createEntityManager();
    }
    @Override
    public void persist(Barrio barrio) {
        manager.getTransaction().begin();
        manager.persist(barrio);
        manager.getTransaction().commit();
    }

    @Override
    public Barrio getByName(String name) {
        Query query = manager.createQuery("SELECT b FROM Barrio b where :nombre = (b.nombre)", Barrio.class);
        query.setParameter("nombre",name);
        return (Barrio) query.getSingleResult();
    }

    @Override
    public Barrio getById(Integer id) {
        return manager.find(Barrio.class,id);
    }

    @Override
    public List list() {
        Query query = manager.createQuery("FROM Barrio",Barrio.class);
        return query.getResultList();
    }

    @Override
    public void merge(Barrio barrio) {
        manager.merge(barrio);
    }

    @Override
    public void close() {
        manager.close();
    }
}
