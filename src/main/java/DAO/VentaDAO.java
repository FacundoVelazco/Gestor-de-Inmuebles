package DAO;


import Domain.Venta;

public interface VentaDAO {
    public Integer save(Venta venta);
    public void deleteById(Long id);
}
