package Services;

import DAO.DAO;
import DAO.Util.BarrioDTO;
import Domain.Barrio;
import Domain.Localidad;
import java.util.List;

public class GestorBarrio {
    public GestorBarrio() {
    }

    public Integer guardarBarrio(BarrioDTO barrioDTO) {
        DAO dao = new DAO();
        Barrio barrio = new Barrio(barrioDTO);
        dao.setObject(barrio);
        dao.close();
        return barrio.getId();
    }
    public Barrio getBarrio(Integer id){
        DAO dao = new DAO();
        Barrio barrio = (Barrio) dao.getObject(id,Barrio.class);
        dao.close();
        return barrio;
    }

    public BarrioDTO cargarBarrio(Integer id) {
        DAO dao = new DAO();
        Barrio barrio = (Barrio) dao.getObject(id,Barrio.class);
        BarrioDTO barrioDTO = new BarrioDTO(barrio.getId(),barrio.getNombre(),barrio.getLocalidad().getId(),Barrio.class);
        dao.close();
        return barrioDTO;
    }

    public List<Object> listarBarrios(Localidad localidad) {
        DAO dao = new DAO();
        dao.merge(localidad);
        List list = localidad.getBarrios();
        dao.close();
        return list;
    }
}
