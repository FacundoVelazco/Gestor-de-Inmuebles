package Services;

import DAO.DAOBdCliente;
import DAO.DAOBdInmueble;
import DAO.DAOBdPropietario;
import DAO.Util.ClienteDTO;
import DAO.Util.PreferenciaDTO;
import DAO.Util.PropietarioDTO;
import Domain.*;
import Domain.Util.TipoInmueble;

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
        //direccion.setCalle(pDTO.getCalle());         TODO ver como dejar CAllE y  -> si juntos o separados
        //direccion.setNumero(pDTO.getNumeroDeCalle());
        direccion.setId(pDTO.getIdDireccion());
        p.setDireccion(direccion);

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
    public PropietarioDTO getPropietarioByUsername(String username){
        DAOBdPropietario pDao = new DAOBdPropietario();
        Propietario p = pDao.getByUsername(username);
        PropietarioDTO pDTO = new PropietarioDTO();
        pDTO.setId(p.getId());
        pDTO.setUsername(p.getUsername());
        pDTO.setNombre(p.getNombre());
        pDTO.setApellido(p.getApellido());
        pDTO.setPassword(p.getPassword());
        pDTO.setTipoDNI(p.getTipoDNI());
        pDTO.setDni(p.getDni());
        pDTO.setCalle(p.getCalle());
        pDTO.setNroDeCalle(p.getNroDeCalle());
        pDTO.setProvincia(p.getProvincia());
        //pDTO.setLocalidad(p.getLocalidad());
        pDTO.setTelefono(p.getTelefono());
        pDTO.setEmail(p.getEmail());

        return pDTO;
    }

}
