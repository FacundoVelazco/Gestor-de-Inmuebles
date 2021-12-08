package DAO;

import Domain.Vendedor;

import java.util.List;

public interface VendedorDAO {
    public List<Vendedor> listAll();
    public void save(Vendedor v);
    public void update(Vendedor v);
    public void deleteByUsername(String username);
    public Vendedor getByUsername(String username);
}
