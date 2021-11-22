package DAO;

import DAO.Util.ClienteDTO;
import DAO.Util.Conexion;
import Domain.Cliente;
import Domain.Preferencia;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DAOBdCliente implements ClienteDAO{

    @Override
    public void save(Cliente cliente) {
        EntityManager manager = Conexion.emf.createEntityManager();


        manager.getTransaction().begin();

        manager.persist(cliente);

        manager.getTransaction().commit();
        manager.close();

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




}
