package DAO;

import Domain.Provincia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DAO implements DAOInterface{
    EntityManagerFactory entityManagerFactory;
    EntityManager manager;
    public DAO(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        manager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Object> getObjects(Class objectClass) {
        String className = String.valueOf(objectClass).substring(13);
        Query query = manager.createQuery("SELECT o FROM "+className+" o",objectClass);
        return query.getResultList();
    }

    @Override
    public Object getObject(String nombre,Class objectClass) {
        String className = String.valueOf(objectClass).substring(13);
        Query query = manager.createQuery("SELECT o FROM "+className+" o where :nombre = (o.nombre)",objectClass);
        query.setParameter("nombre",nombre);
        return query.getSingleResult();
    }

    @Override
    public void setObject(Object object) {
        manager.getTransaction().begin();
        manager.persist(object);
        manager.getTransaction().commit();

    }
    @Override
    public void refresh(Object object) {
        manager.refresh(object);
    }
    @Override
    public void close(){
        manager.close();
    }
}
