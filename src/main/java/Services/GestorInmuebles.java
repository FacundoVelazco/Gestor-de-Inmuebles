package Services;

import DAO.DAOBdInmueble;
import DAO.DAOBdPropietario;
import DAO.Util.InmuebleDTO;
import Domain.Imagen;
import Domain.Inmueble;
import Domain.Propietario;
import Domain.Util.EstadoInmueble;
import Domain.Util.Orientacion;
import Domain.Util.TipoInmueble;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorInmuebles {

    public GestorInmuebles() {
    }

    public Integer guardarInmueble(InmuebleDTO iDTO) {

        //Defino los DAOS a utilizar
        DAOBdInmueble inmuebleDAO = new DAOBdInmueble();
        DAOBdPropietario propietarioDAO = new DAOBdPropietario();

        Inmueble inmueble = generarInmuebleDesdeDTO(iDTO);

        //Si la competencia es recien creada (aun no tiene ID asignado)
        if(iDTO.getId()==null){
            //Obtengo de la BD el propietario
            //Propietario propietarioInmueble = propietarioDAO.getById(iDTO.getPropietarioInmuebleID());
            //TODO SACAR, ES SOLO PARA PRUEBA
            Propietario propietarioInmueble = new Propietario();
            //Se lo asigno al inmueble
            inmueble.setPropietarioInmueble(propietarioInmueble);
        }
        
        //Devuelvo el ID generado
        return inmuebleDAO.save(inmueble);
    }

    public InmuebleDTO cargarInmueble(Integer id) {

        //TODO hacerXD
        return null;
    }

    public List<InmuebleDTO> listarInmuebles(Integer idPropietario) {

        //TODO hacerXD
        return null;
    }

    private Inmueble generarInmuebleDesdeDTO(InmuebleDTO iDTO){
        Inmueble inmueble = new Inmueble();

        inmueble.setId(iDTO.getId());

        //Si estamos modificando el inmueble, seteamos el valor de estado actual
        if(iDTO.getEstado()!=null){
            EstadoInmueble.valueOf(iDTO.getEstado());
        }

        //Si estamos modificando el inmueble, seteamos el valor de fecha de carga que ya tenia el inmueble
        if(iDTO.getFechaCarga()!=null){
            inmueble.setFechaCarga(iDTO.getFechaCarga());
        }

        //Si estamos modificando el inmueble, seteamos el valor de prop destacada que ya tenia el inmueble
        if(iDTO.getPropiedadDestacada()!=null){
            inmueble.setPropiedadDestacada(iDTO.getPropiedadDestacada());
        }

        //LA PROVINCIA POR EL MOMENTO ES INNECESARIO
        //inmueble.setProvincia(iDTO.getProvincia());

        inmueble.setLocalidad(iDTO.getLocalidad());
        inmueble.setCalle(iDTO.getCalle());
        inmueble.setNumeroCalle(iDTO.getNumeroCalle());
        inmueble.setLongitud(iDTO.getLongitud());
        inmueble.setLatitud(iDTO.getLatitud());
        inmueble.setPiso(iDTO.getPiso());
        inmueble.setDepartamento(iDTO.getDepartamento());
        inmueble.setBarrio(iDTO.getBarrio());
        inmueble.setTipoInmueble(TipoInmueble.obtenerByString(iDTO.getTipoInmueble()));
        inmueble.setPrecio(iDTO.getPrecio());
        inmueble.setOrientacion(Orientacion.obtenerByString(iDTO.getOrientacion()));
        inmueble.setLongitudFrente(iDTO.getLongitudFrente());
        inmueble.setLongitudFondo(iDTO.getLongitudFondo());
        inmueble.setTamanioInmueble(iDTO.getTamanioInmueble());
        inmueble.setEsPropiedadHorizontal(iDTO.getEsPropiedadHorizontal());
        inmueble.setAntiguedad(iDTO.getAntiguedad());
        inmueble.setCantidadDormitorios(iDTO.getCantidadDormitorios());
        inmueble.setCantidadBanios(iDTO.getCantidadBanios());
        inmueble.setTieneCochera(iDTO.getTieneCochera());
        inmueble.setTienePatio(iDTO.getTienePatio());
        inmueble.setTienePiscina(iDTO.getTienePiscina());
        inmueble.setTieneAguaCaliente(iDTO.getTieneAguaCaliente());
        inmueble.setTieneCloacas(iDTO.getTieneCloacas());
        inmueble.setTieneGasNatural(iDTO.getTieneGasNatural());
        inmueble.setTieneAguaCaliente(iDTO.getTieneAguaCaliente());
        inmueble.setTieneTelefono(iDTO.getTieneTelefono());
        inmueble.setTieneLavadero(iDTO.getTieneLavadero());
        inmueble.setTienePavimento(iDTO.getTienePavimento());

        Imagen fotoPrincipal = new Imagen();
        fotoPrincipal.setImagen(iDTO.getFotoPrincipal());
        fotoPrincipal.setNombreArchivo(iDTO.getNombreArchivoFotoPrincipal());
        inmueble.setFotoPrincipal(fotoPrincipal);

        ArrayList<Imagen> listaFotos = new ArrayList<>();
        for(int i = 0; i < iDTO.getFotosInmueble().size() ; i++){
            Imagen aux = new Imagen();
            aux.setImagen(iDTO.getFotosInmueble().get(i));
            aux.setNombreArchivo(iDTO.getNombresArchivosFotos().get(i));
            listaFotos.add(aux);
        }
        inmueble.setFotosInmueble(listaFotos);
        inmueble.setObservaciones(iDTO.getObservaciones());

        return inmueble;
    }

}
