package DAO;

import DAO.Util.Conexion;

import DAO.Util.PreferenciaDTO;
import Domain.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        //No logro que las imagenes se muestren bien, por lo tanto solo muestro por el momento la imagen principal
        System.out.println(i.getFotosInmueble().size());
        ArrayList<Imagen> listaAux = new ArrayList<>();
        listaAux.addAll(i.getFotosInmueble());
        i.setFotosInmueble(Imagen.limpiezaDeDuplicados(i.getFotoPrincipal(), listaAux));
        manager.close();
        return i;
    }

    @Override
    public List<Inmueble> listAllByPropietario(long idPropietario) {
        EntityManager manager = Conexion.emf.createEntityManager();
        @SuppressWarnings("unchecked")
        List<Inmueble> lista = (List<Inmueble>) manager.createQuery("From Inmueble as i Where i.estado!='BAJA' AND i.propietarioInmueble.id= :idprop").setParameter("idprop",idPropietario).getResultList();
        manager.close();
        return lista;
    }

    @Override
    public List<Inmueble> listAllByPropietario(long idPropietario, int inicio, int fin) {
        EntityManager manager = Conexion.emf.createEntityManager();
        @SuppressWarnings("unchecked")
        List<Inmueble> lista = (List<Inmueble>) manager.createQuery("From Inmueble as i Where i.estado!='BAJA' AND i.propietarioInmueble.id= :idprop").setParameter("idprop",idPropietario).setMaxResults(fin - inicio + 1).setFirstResult(inicio - 1).getResultList();
        manager.close();
        return lista;
    }

    @Override
    public List<Inmueble> listAll() {
        EntityManager manager = Conexion.emf.createEntityManager();
        @SuppressWarnings("unchecked")
        List<Inmueble> lista = (List<Inmueble>) manager.createQuery("From Inmueble as i Where i.estado!='BAJA'").getResultList();
        manager.close();
        return lista;
    }


    @Override
    public List<Inmueble> listAll(int inicio, int fin) {
        EntityManager manager = Conexion.emf.createEntityManager();
        @SuppressWarnings("unchecked")
        List<Inmueble> lista = (List<Inmueble>) manager.createQuery("From Inmueble as i Where i.estado!='BAJA'").setMaxResults(fin - inicio + 1).setFirstResult(inicio - 1).getResultList();
        manager.close();
        return lista;
    }


}
