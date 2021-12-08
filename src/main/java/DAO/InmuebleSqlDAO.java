package DAO;

import Domain.Inmueble;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class InmuebleSqlDAO implements InmuebleDAO{
    EntityManagerFactory entityManagerFactory;
    EntityManager manager;

    public InmuebleSqlDAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        manager = entityManagerFactory.createEntityManager();
    }
    @Override
    public Integer persist(Inmueble inmueble) {
        manager.getTransaction().begin();
        manager.persist(inmueble);
        manager.getTransaction().commit();
        return inmueble.getId();
    }

    @Override
    public Inmueble getByName(String name) {
        return null;
    }

    @Override
    public Inmueble getById(Integer id) {
        return manager.find(Inmueble.class,id);
    }

    @Override
    public List list() {
        Query query = manager.createQuery("FROM Inmueble",Inmueble.class);
        return query.getResultList();
    }

    @Override
    public void merge(Inmueble inmueble) {
        manager.merge(inmueble);
    }

    @Override
    public void close() {
       manager.close();
    }

    @Override
    public Integer save(Inmueble i) {
        return null;
    }

    @Override
    public Inmueble getById(int id) {
        return null;
    }

    @Override
    public List<Inmueble> listAllByPropietario(int idPropietario) {
        return null;
    }

    @Override
    public List<Inmueble> listAllByPropietario(int idPropietario, int inicio, int fin) {
        return null;
    }
}
