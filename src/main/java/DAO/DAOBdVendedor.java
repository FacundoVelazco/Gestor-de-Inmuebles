package DAO;

import Domain.Vendedor;

import java.util.List;

public class DAOBdVendedor implements VendedorDAO{
    @Override
    public List<Vendedor> listAll() {
        return null;
    }

    @Override
    public Integer save(Vendedor p) {
        return null;
    }

    @Override
    public Integer delete(Integer idVendedor) {
        return idVendedor;
    }

    @Override
    public Vendedor getById(int id) {
        return null;
    }
}
