package Services;

import DAO.DAOBdInmueble;
import DAO.DAOBdPropietario;
import DAO.Util.PropietarioDTO;
import Domain.Inmueble;
import Domain.Propietario;

import java.util.ArrayList;
import java.util.List;

public class GestorPropietario {

    public GestorPropietario(){
    }

    public Integer guardarPropietario(PropietarioDTO pDTO){

        DAOBdPropietario pDao = new DAOBdPropietario();
        DAOBdInmueble iDao = new DAOBdInmueble();

        Propietario p = new Propietario();
        p.setEmail(pDTO.getEmail());
        p.setDni(pDTO.getDni());
        p.setTipoDNI(pDTO.getTipoDNI());
        p.setApellido(pDTO.getApellido());
        p.setNombre(pDTO.getNombre());
        p.setUsername(pDTO.getUsername());
        p.setPassword(pDTO.getPassword());

        List<Inmueble> inmuebles = new ArrayList<Inmueble>(); // iDao.getListById() -> necesitamos un metodo en el DAO de Inmueble para traer todos los inmuebles asociados al Id del Propietario
        p.setInmuebles(inmuebles);


//        p.setLocalidad(pDTO.getLocalidad());
//        p.setProvincia(pDTO.getProvincia()); -> deberiamos colocar los atributos de c/Clase en el DTO de propietario
//        p.setDireccion(pDTO.setDireccion());

        return null;
    }

    public Integer borrarPropietario(PropietarioDTO pDTO){
        return null;
    }

}
