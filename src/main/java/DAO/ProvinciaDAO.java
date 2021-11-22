package DAO;

import Domain.Provincia;

import java.util.List;

public interface ProvinciaDAO {
    public void persist(Provincia provincia);
    public Provincia getByName(String name);
    public Provincia getById(Integer id);
    public List list();
    public void merge(Provincia provincia);
    public void close();
}
