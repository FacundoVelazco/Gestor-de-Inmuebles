package DAO;

import DAO.Util.PreferenciaDTO;
import Domain.Inmueble;

import java.util.List;

public interface InmuebleDAO {



    public Integer save (Inmueble i);

    public Inmueble getById(int id);

    public List<Inmueble> listAllByPropietario(long idPropietario);

    public List<Inmueble> listAllByPropietario(long idPropietario, int inicio, int fin);

    public List<Inmueble> listAll();

    public List<Inmueble> listAll(int inicio, int fin);


}
