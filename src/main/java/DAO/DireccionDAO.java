package DAO;

import Domain.Direccion;
import Domain.Inmueble;

import java.util.List;

public interface DireccionDAO {
    public void persist(Direccion direccion);
    public Direccion getById(Integer id);
    public List list();
    public void merge(Direccion direccion);
    public void close();
}
