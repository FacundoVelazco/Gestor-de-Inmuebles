package Services;

import DAO.LocalidadDAO;
import DAO.LocalidadSqlDAO;
import DAO.Util.LocalidadDTO;
import Domain.Localidad;

import java.util.ArrayList;
import java.util.List;

public class GestorLocalidades {
    public GestorLocalidades() {
    }

    public Integer guardarLocalidad(LocalidadDTO localidadDTO) {
        LocalidadDAO dao = new LocalidadSqlDAO();
        Localidad localidad = new Localidad(localidadDTO);
        dao.persist(localidad);
        dao.close();
        return localidad.getId();
    }
    public Localidad getLocalidad(Integer id){
        LocalidadDAO dao = new LocalidadSqlDAO();
        Localidad localidad = (Localidad) dao.getById(id);
        dao.close();
        return localidad;
    }

    public LocalidadDTO cargarLocalidad(Integer id) {
        LocalidadDAO dao = new LocalidadSqlDAO();
        Localidad localidad = (Localidad) dao.getById(id);
        LocalidadDTO localidadDTO = new LocalidadDTO(localidad.getId(),localidad.getNombre(),localidad.getProvincia());
        dao.close();
        return localidadDTO;
    }
    public List listarLocalidades() {
        LocalidadDAO dao = new LocalidadSqlDAO();
        List list = dao.list();
        dao.close();
        return list;
    }
    public List<LocalidadDTO> listarLocalidadesDTO(){
        List<Localidad> localidades = listarLocalidades();
        List<LocalidadDTO> localidadesDTO = new ArrayList();
        for(Localidad l: localidades){
            localidadesDTO.add(new LocalidadDTO(l.getId(),l.getNombre(),l.getProvincia()));
        }
        return localidadesDTO;
    }
}
