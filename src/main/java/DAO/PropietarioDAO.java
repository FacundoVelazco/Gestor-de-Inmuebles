package DAO;

import Domain.Propietario;

import java.util.List;

public interface PropietarioDAO {

    public List<Propietario> listAll();
    public void save(Propietario p);
    public void delete(Integer idPropietario);

    public Propietario getById(int id); // creo que no es necesario este metodo

}
