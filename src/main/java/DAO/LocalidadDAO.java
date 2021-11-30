package DAO;

import Domain.Localidad;
import java.util.List;

public interface LocalidadDAO {
    public void persist(Localidad localidad);
    public Localidad getByName(String name);
    public Localidad getById(Integer id);
    public List list();
    public void merge(Localidad localidad);
    public void close();
}
