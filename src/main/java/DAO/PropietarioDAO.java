package DAO;

import Domain.Propietario;


import java.util.List;

public interface PropietarioDAO {

    public List<Propietario> listAll();
    public void update(Propietario p);
    public void deleteByUsername(String username);
    public void save(Propietario p);
    public Propietario getByUsername(String username); // creo que no es necesario este metodo


}
