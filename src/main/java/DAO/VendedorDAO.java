package DAO;

import Domain.Vendedor;

import java.util.List;

public interface VendedorDAO {
    public List<Vendedor> listAll();
    public void save(Vendedor p);
    public void delete(Integer idVendedor);

    public Vendedor getById(int id); // creo que no es necesario este metodo
}
