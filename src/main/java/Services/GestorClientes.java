package Services;

import DAO.DAOBdCliente;
import DAO.Util.ClienteDTO;
import DAO.Util.PreferenciaDTO;
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

    public ClienteDTO getClienteByUsername(String username){
        DAOBdCliente clienteDao = new DAOBdCliente();
        Cliente cliente = clienteDao.getByUsername(username);
        PreferenciaDTO preferenciaDTO = new PreferenciaDTO();
        preferenciaDTO.setTieneCochera(cliente.getPreferencia().getTieneCochera());
        preferenciaDTO.setTienePatio(cliente.getPreferencia().getTienePatio());
        preferenciaDTO.setTienePiscina(cliente.getPreferencia().getTienePiscina());
        preferenciaDTO.setTieneAguaCorriente(cliente.getPreferencia().getTieneAguaCorriente());
        preferenciaDTO.setTieneCloacas(cliente.getPreferencia().getTieneCloacas());
        preferenciaDTO.setTieneGasNatural(cliente.getPreferencia().getTieneGasNatural());
        preferenciaDTO.setTieneAguaCaliente(cliente.getPreferencia().getTieneAguaCaliente());
        preferenciaDTO.setTieneTelefono(cliente.getPreferencia().getTieneTelefono());
        preferenciaDTO.setTieneLavadero(cliente.getPreferencia().getTieneLavadero());
        preferenciaDTO.setTienePavimento(cliente.getPreferencia().getTienePavimento());
        preferenciaDTO.setTipoInmueble(cliente.getPreferencia().getTipoInmueble());
        preferenciaDTO.setBarrio(cliente.getPreferencia().getBarrio());
        preferenciaDTO.setMontoDisponible(cliente.getPreferencia().getMontoDisponible());
        preferenciaDTO.setLocalidad(cliente.getPreferencia().getLocalidad());

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setPreferencias(preferenciaDTO);
        clienteDTO.setUsername(cliente.getUsername());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setTelefono(cliente.getTelefono());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setPassword(cliente.getPassword());


        return clienteDTO;
    }

}
