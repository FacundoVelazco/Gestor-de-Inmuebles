package DAO;

import DAO.Util.Conexion;
import Domain.Propietario;


import javax.persistence.EntityManager;
import java.util.List;

public class DAOBdPropietario implements PropietarioDAO{

    @Override
    public List<Propietario> listAll() {
        EntityManager manager = Conexion.emf.createEntityManager();
        return null;
    }

    @Override
    public Integer save(Propietario p) {
        return null;
    }

    @Override

    public Integer delete(Integer idPropietario) {

        return idPropietario;
    }

    @Override
    public Propietario getById(int id) {
        return null;
    }
}
