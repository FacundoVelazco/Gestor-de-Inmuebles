package DAO;

import DAO.Util.Conexion;
import Domain.Cliente;
import Domain.Inmueble;
import Domain.Localidad;
import Domain.Vendedor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DAOBdVendedor implements VendedorDAO{

    @Override
    public List<Vendedor> listAll() {
        EntityManager manager = Conexion.emf.createEntityManager();
        List<Vendedor> lista = (List<Vendedor>) manager.createQuery("From Vendedor").getResultList();
        manager.close();

        return lista;
    }

    @Override
    public void save(Vendedor v) {
        EntityManager manager = Conexion.emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(v);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(Vendedor v) {
        EntityManager manager = Conexion.emf.createEntityManager();

        manager.getTransaction().begin();

        if(v.getId() != null) {
            Vendedor aux = manager.merge(v);
            manager.persist(aux);
        }else{
            manager.persist(v);
        }
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void deleteByUsername(String username) {
        EntityManager manager = Conexion.emf.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createQuery("delete from Vendedor c where c.username = :username");
        query.setParameter("username",username).executeUpdate();

        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public Vendedor getByUsername(String username) {
        EntityManager manager = Conexion.emf.createEntityManager();
        Query query = manager.createQuery("from Vendedor c where c.username = :username");
        Vendedor vendedor = (Vendedor) query.setParameter("username",username).getSingleResult();
        manager.close();
        return vendedor;
    }
}
