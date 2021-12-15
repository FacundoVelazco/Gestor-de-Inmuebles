package DAO;

import DAO.Util.Conexion;
import Domain.Imagen;
import Domain.Inmueble;
import Domain.Localidad;
import Domain.Reserva;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public class DAOBdReserva implements ReservaDAO {

    @Override
    public Integer save(Reserva reserva) {
        EntityManager manager = Conexion.emf.createEntityManager();
        Integer id;

        manager.getTransaction().begin();
        Inmueble inmueble = manager.merge(reserva.getInmueble());
        reserva.setInmueble(inmueble);
        manager.persist(reserva);
        id = reserva.getId();
        manager.getTransaction().commit();
        manager.close();

        return id;
    }

    @Override
    public Reserva getById(int id) {
        EntityManager manager = Conexion.emf.createEntityManager();
        Reserva reserva = manager.find(Reserva.class, id);
        manager.close();
        return reserva;
    }

}
