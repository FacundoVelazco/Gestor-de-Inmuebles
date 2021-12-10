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

        List<Propietario> propietarios = new ArrayList<Propietario>();     // pDao.listAllByVendedor(vDTO.get)
        v.setPropietarios(propietarios);

        Localidad localidad = new Localidad();
        localidad.setNombre(vDTO.getLocalidad());
        localidad.setId(vDTO.getIdLocalidad());
        v.setLocalidad(localidad);

        Provincia provincia = new Provincia();
        provincia.setNombre(vDTO.getProvincia());
        provincia.setId(vDTO.getIdProvincia());
        v.setProvincia(provincia);

        Direccion direccion = new Direccion();
        direccion.setCalle(vDTO.getCalle());
        direccion.setNumero(vDTO.getNumeroDeCalle());
        direccion.setId(vDTO.getIdDireccion());
        v.setDireccion(direccion);


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


}
