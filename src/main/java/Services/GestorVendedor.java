package Services;

import DAO.DAOBdCliente;
import DAO.DAOBdPropietario;
import DAO.DAOBdVendedor;
import DAO.Util.ClienteDTO;
import DAO.Util.PropietarioDTO;
import DAO.Util.VendedorDTO;
import Domain.*;

import java.util.ArrayList;
import java.util.List;

public class GestorVendedor {

    public GestorVendedor(){
    }

    public void guardarVendedor(VendedorDTO vDTO){

        DAOBdVendedor vDao = new DAOBdVendedor();

        Vendedor v = new Vendedor();
        v.setNroLegajo(vDTO.getNroLegajo());
        v.setDni(vDTO.getDni());
        v.setNombre(vDTO.getNombre());
        v.setApellido(vDTO.getApellido());
        v.setPassword(vDTO.getPassword());
        v.setUsername(vDTO.getUsername());
        v.setId(vDTO.getId());

        vDao.update(v);
    }

    public void borrarVendedorByUsername(String username){
        DAOBdVendedor vDao = new DAOBdVendedor();
        vDao.deleteByUsername(username);
    }

    public List<VendedorDTO> listarVendedores(){
        DAOBdVendedor vDao = new DAOBdVendedor();
        ArrayList<VendedorDTO> listaDto=new ArrayList<>();
        for(Vendedor v : vDao.listAll()){
            VendedorDTO vDTO = new VendedorDTO();
            vDTO.setId(v.getId());
            vDTO.setUsername(v.getUsername());
            vDTO.setNombre(v.getNombre());
            vDTO.setApellido(v.getApellido());
            listaDto.add(vDTO);
        }

        return listaDto;
    }

    public VendedorDTO getVendedorByUsername(String username){
        DAOBdVendedor vDao = new DAOBdVendedor();
        Vendedor v = vDao.getByUsername(username);
        VendedorDTO vDTO = new VendedorDTO();
        vDTO.setUsername(v.getUsername());
        vDTO.setNombre(v.getNombre());
        vDTO.setApellido(v.getApellido());
        vDTO.setPassword(v.getPassword());
        vDTO.setDni(v.getDni());
        vDTO.setNroLegajo(v.getNroLegajo());
        vDTO.setId(v.getId());

        return vDTO;
    }
}
