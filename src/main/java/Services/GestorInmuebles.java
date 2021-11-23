package Services;

import DAO.*;
import DAO.Util.BarrioDTO;
import DAO.Util.InmuebleDTO;
import DAO.Util.LocalidadDTO;
import DAO.Util.ProvinciaDTO;
import Domain.Barrio;
import Domain.Direccion;
import Domain.Inmueble;
import Domain.Localidad;
import Domain.Util.TipoInmueble;

import java.util.ArrayList;
import java.util.List;

public class GestorInmuebles {

    public GestorInmuebles() {
    }

    public Integer guardarInmueble(InmuebleDTO iDTO) {

        return null;
    }

    public InmuebleDTO cargarInmueble(Integer id) {
        InmuebleSqlDAO dao = new InmuebleSqlDAO();
        Inmueble inmueble = dao.getById(id);
        dao.close();
        return new InmuebleDTO(inmueble);
    }

    public List<InmuebleDTO> listarInmuebles(Integer idPropietario) {

        return null;
    }
    public List<InmuebleDTO> buscarInmueble(ProvinciaDTO provinciaDTO, LocalidadDTO localidadDTO, BarrioDTO barrioDTO, TipoInmueble tipo, String dormitorios, String precioMax){
        ProvinciaDAO provinciaDAO = new ProvinciaSqlDAO();
        LocalidadDAO localidadDAO = new LocalidadSqlDAO();
        DireccionDAO direccionDAO = new DireccionSqlDAO();
        List<Direccion> direccionesSeleccionadas = new ArrayList<>();
        List<InmuebleDTO> inmueblesDTO = new ArrayList();
        if (provinciaDTO != null){
            List<Direccion> direcciones = direccionDAO.list();
            if(localidadDTO != null){
                //TODO ver otros casos
            }else{
                List<Localidad> localidades = provinciaDAO.getById(provinciaDTO.id).getLocalidades();
                List<Barrio> barrios = new ArrayList<>();
                for (Localidad localidad: localidades){barrios.addAll(localidad.getBarrios());}
                for(Barrio barrio: barrios){
                    for (Direccion direccion: direcciones){
                        if(direccion.getBarrio().equals(barrio)) direccionesSeleccionadas.add(direccion);
                    }
                }
            }

            for(Direccion direccion: direccionesSeleccionadas){
                inmueblesDTO.add(cargarInmueble(direccion.getInmueble().getId()));
            }
            return inmueblesDTO;
        }
        return null;
    }


}
