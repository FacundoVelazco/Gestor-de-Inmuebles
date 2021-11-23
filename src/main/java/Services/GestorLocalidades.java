package Services;

import DAO.LocalidadDAO;
import DAO.LocalidadSqlDAO;
import DAO.ProvinciaDAO;
import DAO.ProvinciaSqlDAO;
import DAO.Util.LocalidadDTO;
import DAO.Util.ProvinciaDTO;
import Domain.Localidad;
import Domain.Provincia;

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
        LocalidadDTO localidadDTO = new LocalidadDTO(localidad.getId(),localidad.getNombre(),localidad.getProvincia().getId(),Localidad.class);
        dao.close();
        return localidadDTO;
    }

    public List listarLocalidades(Provincia provincia) {
        ProvinciaDAO dao = new ProvinciaSqlDAO();
        dao.merge(provincia);
        List list = provincia.getLocalidades();
        dao.close();
        return list;
    }
    public List listarLocalidades() {
        LocalidadDAO dao = new LocalidadSqlDAO();
        List list = dao.list();
        dao.close();
        return list;
    }
    public List listarLocalidadesDTO(ProvinciaDTO provinciaDto) {
        ProvinciaDAO dao = new ProvinciaSqlDAO();
        Provincia provincia = dao.getById(provinciaDto.id);
        dao.merge(provincia);
        List<Localidad> list = provincia.getLocalidades();
        List<LocalidadDTO> dtoList = new ArrayList<>();
        dao.close();
        for(Localidad localidad : list){
            dtoList.add(new LocalidadDTO(localidad.getId(),localidad.getNombre(),localidad.getProvincia().getId(),Localidad.class));
        }
        return dtoList;
    }
}
