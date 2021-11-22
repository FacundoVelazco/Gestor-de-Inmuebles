package DAO;

import Domain.Provincia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ProvinciaSqlDAO implements ProvinciaDAO{
    EntityManagerFactory entityManagerFactory;
    EntityManager manager;

    public ProvinciaSqlDAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        manager = entityManagerFactory.createEntityManager();
    }
    @Override
    public void persist(Provincia provincia) {
        manager.getTransaction().begin();
        manager.persist(provincia);
        manager.getTransaction().commit();
    }

    @Override
    public Provincia getByName(String name) {
        Query query = manager.createQuery("SELECT p FROM Provincia p where :nombre = (p.nombre)",Provincia.class);
        query.setParameter("nombre",name);
        return (Provincia) query.getSingleResult();

    }

    @Override
    public Provincia getById(Integer id) {

        return manager.find(Provincia.class,id);

    }

    @Override
    public List list() {
        Query query = manager.createQuery("FROM Provincia",Provincia.class);
        return query.getResultList();
    }

    @Override
    public void merge(Provincia provincia) {
        manager.merge(provincia);
    }

    @Override
    public void close() {
        manager.close();
    }
}
