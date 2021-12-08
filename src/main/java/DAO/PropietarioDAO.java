package DAO;

import Domain.Propietario;


import java.util.List;

public interface PropietarioDAO {

    public List<Propietario> listAll();
    public Integer save(Propietario p);
    public Integer delete(Integer idPropietario);

    public Propietario getById(int id); // creo que no es necesario este metodo


}
