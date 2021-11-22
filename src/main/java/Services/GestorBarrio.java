package Services;

import DAO.BarrioDAO;
import DAO.BarrioSqlDAO;
import DAO.LocalidadDAO;
import DAO.LocalidadSqlDAO;
import DAO.Util.BarrioDTO;
import Domain.Barrio;
import Domain.Localidad;
import java.util.List;

public class GestorBarrio {
    public GestorBarrio() {
    }

    public Integer guardarBarrio(BarrioDTO barrioDTO) {
        BarrioDAO dao = new BarrioSqlDAO();
        Barrio barrio = new Barrio(barrioDTO);
        dao.persist(barrio);
        dao.close();
        return barrio.getId();
    }
    public Barrio getBarrio(Integer id){
        BarrioDAO dao = new BarrioSqlDAO();
        Barrio barrio = dao.getById(id);
        dao.close();
        return barrio;
    }

    public BarrioDTO cargarBarrio(Integer id) {
        BarrioDAO dao = new BarrioSqlDAO();
        Barrio barrio = dao.getById(id);
        BarrioDTO barrioDTO = new BarrioDTO(barrio.getId(),barrio.getNombre(),barrio.getLocalidad().getId(),Barrio.class);
        dao.close();
        return barrioDTO;
    }

        public List listarBarrios(Localidad localidad) {
        LocalidadDAO dao = new LocalidadSqlDAO();
        dao.merge(localidad);
        List list = localidad.getBarrios();
        dao.close();
        return list;
    }
    public List listarBarrios() {
        BarrioDAO dao = new BarrioSqlDAO();
        List list = dao.list();
        dao.close();
        return list;
    }
}
