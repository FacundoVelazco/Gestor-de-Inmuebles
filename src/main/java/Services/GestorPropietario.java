package Services;

import DAO.DAOBdCliente;
import DAO.DAOBdInmueble;
import DAO.DAOBdPropietario;
import DAO.Util.ClienteDTO;
import DAO.Util.PropietarioDTO;
import Domain.*;

import java.util.ArrayList;
import java.util.List;

public class GestorPropietario {

    public GestorPropietario(){
    }

    public void guardarPropietario(PropietarioDTO pDTO){

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

        List<Inmueble> inmuebles =  iDao.listAllByPropietario(pDTO.getId());
        p.setInmuebles(inmuebles);

        Localidad localidad = new Localidad();
        localidad.setNombre(pDTO.getLocalidad());
        localidad.setId(pDTO.getIdLocalidad());
        p.setLocalidad(localidad);

        String provincia;

        provincia = (pDTO.getProvincia());
        p.setProvincia(provincia);

        Direccion direccion = new Direccion();
        direccion.setCalle(pDTO.getCalle());
        direccion.setNumero(pDTO.getNumeroDeCalle());
        direccion.setId(pDTO.getIdDireccion());
        p.setDireccion(direccion);


       // -> deberiamos colocar los atributos de c/Clase en el DTO de propietario
       pDao.update(p);
    }

    public void borrarPropietarioByUsername(String username){
        DAOBdPropietario pDao = new DAOBdPropietario();
        pDao.deleteByUsername(username);
    }

    public List<PropietarioDTO> listarPropietarios(){
        DAOBdPropietario pDao = new DAOBdPropietario();
        ArrayList<PropietarioDTO> listaDto=new ArrayList<>();
        for(Propietario p : pDao.listAll()){
            PropietarioDTO pDTO = new PropietarioDTO();
            pDTO.setId(p.getId());
            pDTO.setUsername(p.getUsername());
            pDTO.setNombre(p.getNombre());
            pDTO.setApellido(p.getApellido());
            listaDto.add(pDTO);
        }

        return listaDto;
    }

}
