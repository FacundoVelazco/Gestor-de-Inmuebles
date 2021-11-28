package DAO;

import DAO.Util.Conexion;
import Domain.Inmueble;
import Domain.Localidad;

import javax.persistence.EntityManager;
import java.util.List;

public class DAOBdInmueble implements InmuebleDAO{
    @Override
    public Integer save(Inmueble i) {
        EntityManager manager = Conexion.emf.createEntityManager();
        Integer id;

        manager.getTransaction().begin();
        Localidad locAux = manager.merge(i.getLocalidad());
        i.setLocalidad(locAux);

        if(i.getId() != null) {
            Inmueble aux = manager.merge(i);
            manager.persist(aux);
            id = aux.getId();
        }else{
            manager.persist(i);
            id = i.getId();
        }

        manager.getTransaction().commit();
        manager.close();

        return id;
    }

    @Override
    public Inmueble getById(int id) {
        EntityManager manager = Conexion.emf.createEntityManager();
        Inmueble i = manager.find(Inmueble.class, id);
        i.getFotosInmueble();
        System.out.println(i.getFotosInmueble());
        manager.close();
        return i;
    }

    @Override
    public List<Inmueble> listAllByPropietario(int idPropietario) {
        EntityManager manager = Conexion.emf.createEntityManager();
        @SuppressWarnings("unchecked")
        List<Inmueble> lista = (List<Inmueble>) manager.createQuery("From Inmueble as i Where i.estado!='BAJA'").getResultList();
        manager.close();
        return lista;
    }

    @Override
    public List<Inmueble> listAllByPropietario(int idPropietario, int inicio, int fin) {
        EntityManager manager = Conexion.emf.createEntityManager();
        @SuppressWarnings("unchecked")
        List<Inmueble> lista = (List<Inmueble>) manager.createQuery("From Inmueble as i Where i.estado!='BAJA'").setMaxResults(fin - inicio + 1).setFirstResult(inicio - 1).getResultList();
        manager.close();
        return lista;
    }
}
