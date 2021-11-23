package Services;

import DAO.ProvinciaDAO;
import DAO.ProvinciaSqlDAO;
import DAO.Util.ProvinciaDTO;
import Domain.Provincia;

import java.util.ArrayList;
import java.util.List;

public class GestorProvincias {
    public GestorProvincias() {
    }

    public Integer guardarProvincia(ProvinciaDTO provinciaDTO) {
        ProvinciaDAO dao = new ProvinciaSqlDAO();
        Provincia provincia = new Provincia(provinciaDTO);
        dao.persist(provincia);
        dao.close();
        return provincia.getId();
    }
    public Provincia getProvincia(Integer id){
        ProvinciaDAO dao = new ProvinciaSqlDAO();
        Provincia provincia = (Provincia) dao.getById(id);
        dao.close();
        return provincia;
    }

    public ProvinciaDTO cargarProvincia(Integer id) {
        ProvinciaDAO dao = new ProvinciaSqlDAO();
        Provincia provincia = (Provincia) dao.getById(id);
        ProvinciaDTO provinciaDTO = new ProvinciaDTO(provincia.getId(),provincia.getNombre(),Provincia.class);
        dao.close();
        return provinciaDTO;
    }

    public List<Provincia> listarProvincias() {
        ProvinciaDAO dao = new ProvinciaSqlDAO();
        List<Provincia> list = dao.list();
        dao.close();
        return list;
    }
    public List<ProvinciaDTO> listarProvinciaDTO(){
        List<Provincia> list = listarProvincias();
        List<ProvinciaDTO> dtoList = new ArrayList<>();
        for(Provincia provincia: list){
            dtoList.add(new ProvinciaDTO(provincia.getId(),provincia.getNombre(),Provincia.class));
        }
        return dtoList;
    }
}
