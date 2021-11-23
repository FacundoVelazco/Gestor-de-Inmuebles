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

        DAOBdInmueble daoInmueble = new DAOBdInmueble();
        Inmueble inmueble = daoInmueble.getById(id);
        InmuebleDTO idto = generarDTODesdeInmueble(inmueble);

        return idto;
    }


    public List<InmuebleDTO> listarInmueblesPorPropietario(Integer idPropietario) {
        ArrayList<InmuebleDTO> listaInmueblesDTO = new ArrayList<>();
        DAOBdInmueble daoInmueble = new DAOBdInmueble();
        ArrayList<Inmueble> listaInmueblesDominio = new ArrayList<>();
        listaInmueblesDominio.addAll(daoInmueble.listAllByPropietario(idPropietario));

        for(Inmueble i : listaInmueblesDominio){
            InmuebleDTO idto = generarDTODesdeInmueble(i);
            listaInmueblesDTO.add(idto);
        }

        return listaInmueblesDTO;
    }

    public List<InmuebleDTO> listarInmueblesPorPropietario(Integer idPropietario, Integer inicio, Integer fin) {
        ArrayList<InmuebleDTO> listaInmueblesDTO = new ArrayList<>();
        DAOBdInmueble daoInmueble = new DAOBdInmueble();
        ArrayList<Inmueble> listaInmueblesDominio = new ArrayList<>();
        listaInmueblesDominio.addAll(daoInmueble.listAllByPropietario(idPropietario,inicio,fin));

        for(Inmueble i : listaInmueblesDominio){
            InmuebleDTO idto = generarDTODesdeInmueble(i);
            listaInmueblesDTO.add(idto);
        }

        return listaInmueblesDTO;
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
        fotoPrincipal.setInmuebleAsociado(inmueble);
        inmueble.setFotoPrincipal(fotoPrincipal);

        ArrayList<Imagen> listaFotos = new ArrayList<>();
        for(int i = 0; i < iDTO.getFotosInmueble().size() ; i++){
            Imagen aux = new Imagen();
            aux.setImagen(iDTO.getFotosInmueble().get(i));
            aux.setNombreArchivo(iDTO.getNombresArchivosFotos().get(i));
            aux.setInmuebleAsociado(inmueble);
            listaFotos.add(aux);
        }
        inmueble.setFotosInmueble(listaFotos);
        inmueble.setObservaciones(iDTO.getObservaciones());

        return inmueble;
    }

    private InmuebleDTO generarDTODesdeInmueble(Inmueble inmueble) {
        InmuebleDTO idto = new InmuebleDTO();
        idto.setId(inmueble.getId());
        idto.setEstado(inmueble.getEstado().toString());
        idto.setFechaCarga(inmueble.getFechaCarga());
        idto.setPropiedadDestacada(inmueble.getPropiedadDestacada());
        idto.setProvincia(inmueble.getProvincia());
        idto.setLocalidad(inmueble.getLocalidad());
        idto.setCalle(inmueble.getCalle());
        idto.setNumeroCalle(inmueble.getNumeroCalle());
        idto.setLongitud(inmueble.getLongitud());
        idto.setLatitud(inmueble.getLatitud());
        idto.setPiso(inmueble.getPiso());
        idto.setDepartamento(inmueble.getDepartamento());
        idto.setBarrio(inmueble.getBarrio());
        idto.setTipoInmueble(TipoInmueble.obtenerStringParaComboBox(inmueble.getTipoInmueble()));
        idto.setPrecio(inmueble.getPrecio());
        idto.setOrientacion(Orientacion.obtenerStringParaComboBox(inmueble.getOrientacion()));
        idto.setTienePavimento(inmueble.getTienePavimento());
        idto.setTieneLavadero(inmueble.getTieneLavadero());
        idto.setTieneTelefono(inmueble.getTieneTelefono());
        idto.setTieneAguaCaliente(inmueble.getTieneAguaCaliente());
        idto.setTieneGasNatural(inmueble.getTieneGasNatural());
        idto.setTieneCloacas(inmueble.getTieneCloacas());
        idto.setTieneAguaCorriente(inmueble.getTieneAguaCorriente());
        idto.setTienePiscina(inmueble.getTienePiscina());
        idto.setTienePatio(inmueble.getTienePatio());
        idto.setTieneCochera(inmueble.getTieneCochera());
        idto.setCantidadBanios(inmueble.getCantidadBanios());
        idto.setCantidadDormitorios(inmueble.getCantidadDormitorios());
        idto.setAntiguedad(inmueble.getAntiguedad());
        idto.setEsPropiedadHorizontal(inmueble.getEsPropiedadHorizontal());
        idto.setTamanioInmueble(inmueble.getTamanioInmueble());
        idto.setLongitudFondo(inmueble.getLongitudFondo());
        idto.setLongitudFrente(inmueble.getLongitudFrente());

        idto.setFotoPrincipal(inmueble.getFotoPrincipal().getImagen());
        idto.setNombreArchivoFotoPrincipal(inmueble.getFotoPrincipal().getNombreArchivo());

        ArrayList<ImageIcon> listaImagenes = new ArrayList<>();
        ArrayList<String> listaNombreArchivos = new ArrayList<>();

        for(Imagen i : inmueble.getFotosInmueble()){
            listaImagenes.add(i.getImagen());
            listaNombreArchivos.add(i.getNombreArchivo());
        }

        idto.setFotosInmueble(listaImagenes);
        idto.setNombresArchivosFotos(listaNombreArchivos);

        return idto;
    }
}
