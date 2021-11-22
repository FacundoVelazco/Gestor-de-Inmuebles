package Services;

import DAO.DAOBdCliente;
import DAO.Util.ClienteDTO;
import Domain.Cliente;
import Domain.Preferencia;

import java.util.ArrayList;
import java.util.List;

public class GestorClientes {

    public List<ClienteDTO> listarClientes(){
        DAOBdCliente clienteDao = new DAOBdCliente();
        ArrayList<ClienteDTO> listaDto=new ArrayList<>();
        for(Cliente c : clienteDao.listAll()){
            listaDto.add(new ClienteDTO(c.getId(),c.getUsername(),c.getNombre(),c.getApellido()));
        }

        return listaDto;
    }

    public void borrarClienteByUsername(String username){
        DAOBdCliente clienteDao = new DAOBdCliente();
        clienteDao.deleteByUsername(username);
    }

    public void guardarCliente(ClienteDTO cliente){

        Cliente clienteAGuardar = new Cliente();
        Preferencia preferenciaClienteAGuardar = new Preferencia();
        preferenciaClienteAGuardar.setTieneCochera(cliente.getPreferencias().getTieneCochera());
        preferenciaClienteAGuardar.setTienePatio(cliente.getPreferencias().getTienePatio());
        preferenciaClienteAGuardar.setTienePiscina(cliente.getPreferencias().getTienePiscina());
        preferenciaClienteAGuardar.setTieneAguaCorriente(cliente.getPreferencias().getTieneAguaCorriente());
        preferenciaClienteAGuardar.setTieneCloacas(cliente.getPreferencias().getTieneCloacas());
        preferenciaClienteAGuardar.setTieneGasNatural(cliente.getPreferencias().getTieneGasNatural());
        preferenciaClienteAGuardar.setTieneAguaCaliente(cliente.getPreferencias().getTieneAguaCaliente());
        preferenciaClienteAGuardar.setTieneTelefono(cliente.getPreferencias().getTieneTelefono());
        preferenciaClienteAGuardar.setTieneLavadero(cliente.getPreferencias().getTieneLavadero());
        preferenciaClienteAGuardar.setTienePavimento(cliente.getPreferencias().getTienePavimento());
        preferenciaClienteAGuardar.setMontoDisponible(cliente.getPreferencias().getMontoDisponible());
        preferenciaClienteAGuardar.setTipoInmueble(cliente.getPreferencias().getTipoInmueble());
        preferenciaClienteAGuardar.setBarrio(cliente.getPreferencias().getBarrio());
        preferenciaClienteAGuardar.setLocalidad(cliente.getPreferencias().getLocalidad());

        clienteAGuardar.setPreferencia(preferenciaClienteAGuardar);
        clienteAGuardar.setUsername(cliente.getUsername());
        clienteAGuardar.setNombre(cliente.getNombre());
        clienteAGuardar.setTelefono(cliente.getTelefono());
        clienteAGuardar.setApellido(cliente.getApellido());

        DAOBdCliente clienteDao = new DAOBdCliente();
        clienteDao.save(clienteAGuardar);
    }

}
