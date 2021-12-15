package DAO;

import Domain.Inmueble;
import Domain.Reserva;

public interface ReservaDAO {
    public Integer save(Reserva reserva);
    public Reserva getById(int id);

}
