package DAO;

import DAO.Util.ClienteDTO;
import Domain.Cliente;

import java.util.List;

public interface ClienteDAO {

    public void save(Cliente cliente);
    public void update(Cliente cliente);
    public Boolean existsUsername(String username);
    public List<Cliente> listAll();
    public void deleteByUsername(String username);
    public Cliente getByUsername(String username);
}
