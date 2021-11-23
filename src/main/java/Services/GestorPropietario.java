package Services;

import DAO.DAOBdInmueble;
import DAO.DAOBdPropietario;
import DAO.Util.PropietarioDTO;
import Domain.*;

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

        List<Inmueble> inmuebles = new ArrayList<Inmueble>(); // iDao.listAllByPropietario(pDTO.get) -> necesitamos un metodo en el DAO de Inmueble para traer todos los inmuebles asociados al Id del Propietario
        p.setInmuebles(inmuebles);

        Localidad localidad = new Localidad();
        localidad.setNombre(pDTO.getLocalidad());
        localidad.setId(pDTO.getIdLocalidad());
        p.setLocalidad(localidad);

        Provincia provincia = new Provincia();
        provincia.setNombre(pDTO.getProvincia());
        provincia.setId(pDTO.getIdProvincia());
        p.setProvincia(provincia);

        Direccion direccion = new Direccion();
        direccion.setCalle(pDTO.getCalle());
        direccion.setNumero(pDTO.getNumeroDeCalle());
        direccion.setId(pDTO.getIdDireccion());
        p.setDireccion(direccion);


       // -> deberiamos colocar los atributos de c/Clase en el DTO de propietario

        return pDao.save(p);
    }

    public Integer borrarPropietario(PropietarioDTO pDTO){

        DAOBdPropietario pDao = new DAOBdPropietario();
        return pDao.delete(pDTO.getId());
    }

    public Integer cargarPropietario(PropietarioDTO pDTO){
        DAOBdPropietario pDao = new DAOBdPropietario();
        //return pDao.getById(pDTO.getId());  -> seria de esta forma como hay que realizar el cargar propietario?

        return null;
    }

    public Integer listarPropietarios(){
        DAOBdPropietario pDao = new DAOBdPropietario();
        //return pDao.listAll();  -> seria de esta forma como hay que realizar listarPropietarios?

        return null;
    }

}
