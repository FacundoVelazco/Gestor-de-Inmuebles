package DAO;

import Domain.Propietario;

public interface PropietarioDAO {

    public Integer save (Propietario p);

    public Propietario getById(int id);
}
