package DAO;


import DAO.Util.Conexion;
import Domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DAOBdCliente implements ClienteDAO{

    @Override
    public void save(Cliente cliente) {
        EntityManager manager = Conexion.emf.createEntityManager();


        manager.getTransaction().begin();

        if(cliente.getId()!=null){
            Cliente c = manager.merge(cliente);
            manager.persist(c);
        }else {
            manager.persist(cliente);
        }
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void update(Cliente cliente) {
        EntityManager manager = Conexion.emf.createEntityManager();

        String username = cliente.getUsername();
        manager.getTransaction().begin();
        Query query = manager.createQuery("from Cliente c where c.username = :username");
        query.setParameter("username",username);
        if(!query.getResultList().isEmpty()){
            Query query2 = manager.createQuery("delete from Cliente c where c.username = :username");
            query2.setParameter("username",username).executeUpdate();
        }
        manager.persist(cliente);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public Boolean existsUsername(String username) {
        EntityManager manager = Conexion.emf.createEntityManager();
        Query query = manager.createQuery("from Cliente c where c.username = :username");
        query.setParameter("username",username);
        if(!query.getResultList().isEmpty()){
            return true;
        }
        return false;
    }


    @Override
    public List<Cliente> listAll() {

        EntityManager manager = Conexion.emf.createEntityManager();
        List<Cliente> lista = (List<Cliente>) manager.createQuery("From Cliente").getResultList();
        manager.close();

        return lista;

    }

    @Override
    public void deleteByUsername(String username) {
        EntityManager manager = Conexion.emf.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("delete from Cliente c where c.username = :username");
        query.setParameter("username",username).executeUpdate();

        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public Cliente getByUsername(String username) {
        EntityManager manager = Conexion.emf.createEntityManager();
        Query query = manager.createQuery("from Cliente c where c.username = :username");
        Cliente cliente = (Cliente) query.setParameter("username",username).getSingleResult();
        manager.close();
        return cliente;
    }


}
