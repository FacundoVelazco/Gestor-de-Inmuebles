package DAO;

import Domain.Inmueble;

import java.util.List;

public interface InmuebleDAO {

    public Integer save (Inmueble i);

    public Inmueble getById(int id);

    public List<Inmueble> listAllByPropietario(int idPropietario);


}
