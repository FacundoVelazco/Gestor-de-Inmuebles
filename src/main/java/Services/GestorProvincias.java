package Services;

import DAO.DAO;
import DAO.Util.ProvinciaDTO;
import Domain.Provincia;

import java.util.List;

public class GestorProvincias {
    public GestorProvincias() {
    }

    public Integer guardarProvincia(ProvinciaDTO provinciaDTO) {
        DAO dao = new DAO();
        Provincia provincia = new Provincia(provinciaDTO);
        dao.setObject(provincia);
        dao.close();
        return provincia.getId();
    }
    public Provincia getProvincia(Integer id){
        DAO dao = new DAO();
        Provincia provincia = (Provincia) dao.getObject(id,Provincia.class);
        dao.close();
        return provincia;
    }

    public ProvinciaDTO cargarProvincia(Integer id) {
        DAO dao = new DAO();
        Provincia provincia = (Provincia) dao.getObject(id,Provincia.class);
        ProvinciaDTO provinciaDTO = new ProvinciaDTO(provincia.getId(),provincia.getNombre(),Provincia.class);
        dao.close();
        return provinciaDTO;
    }

    public List<Object> listarProvincias() {
        DAO dao = new DAO();
        List list = dao.getObjects(Provincia.class);
        dao.close();
        return list;
    }
}
