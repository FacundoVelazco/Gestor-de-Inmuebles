package DAO;

import Domain.Inmueble;

import java.util.List;

public interface InmuebleDAO {

    public Integer persist(Inmueble inmueble);
    public Inmueble getByName(String name);
    public Inmueble getById(Integer id);
    public List list();
    public void merge(Inmueble inmueble);
    public void close();
    public Integer save (Inmueble i);

    public Inmueble getById(int id);

    public List<Inmueble> listAllByPropietario(int idPropietario);

    public List<Inmueble> listAllByPropietario(int idPropietario, int inicio, int fin);

}
