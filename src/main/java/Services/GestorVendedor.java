package Services;

import DAO.DAOBdPropietario;
import DAO.DAOBdVendedor;
import DAO.Util.PropietarioDTO;
import DAO.Util.VendedorDTO;
import Domain.*;

import java.util.ArrayList;
import java.util.List;

public class GestorVendedor {

    public GestorVendedor(){
    }

    public Integer guardarVendedor(VendedorDTO vDTO){

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


        return vDao.save(v);
    }

    public Integer borrarVendedor(VendedorDTO vDTO){
        DAOBdVendedor vDao = new DAOBdVendedor();
        return vDao.delete(vDTO.getId());
    }

    public Integer cargarVendedor(VendedorDTO vDTO){
        return null;
    }

    public Integer listarVendedores(){
        DAOBdVendedor vDao = new DAOBdVendedor();
        //   vDao.listAll();
        return null;
    }


}
