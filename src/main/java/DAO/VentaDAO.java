package DAO;


import Domain.Venta;

public interface VentaDAO {
    public void save(Venta venta);
    public void deleteById(Long id);
}
