package DAO;

import Domain.Barrio;

import java.util.List;

public interface BarrioDAO {
    public void persist(Barrio barrio);
    public Barrio getByName(String name);
    public Barrio getById(Integer id);
    public List list();
    public void merge(Barrio barrio);
    public void close();
}
