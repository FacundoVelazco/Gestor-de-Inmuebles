package DAO;

import DAO.Util.Conexion;
import Domain.Cliente;
import Domain.Inmueble;
import Domain.Localidad;
import Domain.Propietario;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DAOBdPropietario implements PropietarioDAO{

    @Override
    public List<Propietario> listAll() {
        EntityManager manager = Conexion.emf.createEntityManager();
        List<Propietario> lista = (List<Propietario>) manager.createQuery("From Propietario").getResultList();
        manager.close();
        return lista;
    }

    @Override
    public void save(Propietario p) {
        EntityManager manager = Conexion.emf.createEntityManager();


        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(Propietario propietario) {
        EntityManager manager = Conexion.emf.createEntityManager();

//        String username = propietario.getUsername();
//        manager.getTransaction().begin();
//        Query query = manager.createQuery("from Propietario p where p.username = :username");
//        query.setParameter("username",username);
//        if(!query.getResultList().isEmpty()){
//            Query query2 = manager.createQuery("delete from Propietario p where p.username = :username");
//            query2.setParameter("username",username).executeUpdate();
//        }
//        manager.persist(propietario);
//        manager.getTransaction().commit();
//        manager.close();

        manager.getTransaction().begin();

        Localidad locAux = manager.merge(propietario.getLocalidad());
        propietario.setLocalidad(locAux);

        if(propietario.getId() != null) {
            Propietario aux = manager.merge(propietario);
            manager.persist(aux);
        }else{
            manager.persist(propietario);
        }
        manager.getTransaction().commit();
        manager.close();


    }

    @Override
    public void deleteByUsername(String username) {
        EntityManager manager = Conexion.emf.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("delete from Propietario c where c.username = :username");
        query.setParameter("username",username).executeUpdate();

        manager.getTransaction().commit();
        manager.close();
    }


    @Override
    public Propietario getByUsername(String username) {
        EntityManager manager = Conexion.emf.createEntityManager();
        Query query = manager.createQuery("from Propietario c where c.username = :username");
        Propietario propietario = (Propietario) query.setParameter("username",username).getSingleResult();
        manager.close();
        return propietario;
    }
}
