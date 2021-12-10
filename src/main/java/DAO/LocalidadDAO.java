package DAO;

import Domain.Localidad;
import java.util.List;

public interface LocalidadDAO {
    public Localidad getByName(String name);
    public List<Localidad> listAll();
}
