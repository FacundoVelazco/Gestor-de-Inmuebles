package DAO;

import Domain.Localidad;
import Domain.Provincia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LocalidadSqlDAO implements LocalidadDAO{
    EntityManagerFactory entityManagerFactory;
    EntityManager manager;

    public LocalidadSqlDAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        manager = entityManagerFactory.createEntityManager();
    }
    @Override
    public void persist(Localidad localidad) {
        manager.getTransaction().begin();
        manager.persist(localidad);
        manager.getTransaction().commit();
    }

    @Override
    public Localidad getByName(String name) {
        Query query = manager.createQuery("SELECT l FROM Localidad l where :nombre = (l.nombre)", Localidad.class);
        query.setParameter("nombre",name);
        return (Localidad) query.getSingleResult();
    }

    @Override
    public Localidad getById(Integer id) {
        return manager.find(Localidad.class,id);
    }

    @Override
    public List list() {
        Query query = manager.createQuery("FROM Localidad",Localidad.class);
        return query.getResultList();
    }

    @Override
    public void merge(Localidad localidad) {
        manager.merge(localidad);
    }

    @Override
    public void close() {
        manager.close();
    }
}
