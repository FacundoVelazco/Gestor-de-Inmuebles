package DAO;

import Domain.Provincia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DAOProvincia {
    EntityManagerFactory entityManagerFactory;
    EntityManager manager;

    public DAOProvincia(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        manager = entityManagerFactory.createEntityManager();
    }
    public List<Provincia> getProvincias(){
        Query query = manager.createQuery("FROM Provincia",Provincia.class);
        return query.getResultList();
    }
    public Provincia getProvincia(Integer id_provincia){
        return manager.find(Provincia.class,id_provincia);
    }
    public Provincia getProvincia(String nombre){
        Query query = manager.createQuery("SELECT p FROM Provincia p where :nombre = (p.nombre)",Provincia.class);
        query.setParameter("nombre",nombre);
        return (Provincia) query.getSingleResult();
    }
    public void setProvincia(Provincia provincia){
        manager.getTransaction().begin();
        manager.persist(provincia);
        manager.getTransaction().commit();
    }
    public void refresh(Object object) {
        manager.refresh(object);
    }
    public void close(){
        manager.close();
    }

}
