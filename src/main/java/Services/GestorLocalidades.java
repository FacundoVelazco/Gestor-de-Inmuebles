package Services;

import DAO.DAO;
import DAO.Util.LocalidadDTO;
import Domain.Localidad;
import Domain.Provincia;

import java.util.List;

public class GestorLocalidades {
    public GestorLocalidades() {
    }

    public Integer guardarLocalidad(LocalidadDTO localidadDTO) {
        DAO dao = new DAO();
        Localidad localidad = new Localidad(localidadDTO);
        dao.setObject(localidad);
        dao.close();
        return localidad.getId();
    }
    public Localidad getLocalidad(Integer id){
        DAO dao = new DAO();
        Localidad localidad = (Localidad) dao.getObject(id,Localidad.class);
        dao.close();
        return localidad;
    }

    public LocalidadDTO cargarLocalidad(Integer id) {
        DAO dao = new DAO();
        Localidad localidad = (Localidad) dao.getObject(id,Localidad.class);
        LocalidadDTO localidadDTO = new LocalidadDTO(localidad.getId(),localidad.getNombre(),localidad.getProvincia().getId(),Localidad.class);
        dao.close();
        return localidadDTO;
    }

    public List<Object> listarLocalidades(Provincia provincia) {
        DAO dao = new DAO();
        dao.merge(provincia);
        List list = provincia.getLocalidades();
        dao.close();
        return list;
    }
}
