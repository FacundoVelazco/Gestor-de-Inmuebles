package DAO;

import Domain.Localidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DAOLocalidad {
    EntityManagerFactory entityManagerFactory;
    EntityManager manager;

    public DAOLocalidad(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        manager = entityManagerFactory.createEntityManager();
    }
    public List<Localidad> getLocalidades(){
        Query query = manager.createQuery("FROM Localidad",Localidad.class);
        return query.getResultList();
    }
    public Localidad getLocalidad(Integer id_localidad){
        return manager.find(Localidad.class,id_localidad);
    }
    public Localidad getLocalidad(String nombre){
        Query query = manager.createQuery("SELECT l FROM Localidad l where :nombre = (l.nombre)",Localidad.class);
        query.setParameter("nombre",nombre);
        return (Localidad) query.getSingleResult();
    }
    public void setLocalidad(Localidad localidad){
        manager.getTransaction().begin();
        manager.persist(localidad);
        manager.getTransaction().commit();
    }
    public void refresh(Object object) {
        manager.refresh(object);
    }
    public void close(){
        manager.close();
    }
}
