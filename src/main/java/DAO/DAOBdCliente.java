package DAO;

import DAO.Util.ClienteDTO;
import Domain.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DAOBdCliente {


    public List<Cliente> listAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia"); //TODO Crear clase conexion donde hacer el emf
        EntityManager manager = emf.createEntityManager();
        List<Cliente> lista = (List<Cliente>) manager.createQuery("From Cliente").getResultList();
        manager.close();


        return lista;

    }

}
