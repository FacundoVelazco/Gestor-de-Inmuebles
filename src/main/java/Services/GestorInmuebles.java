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

import java.awt.*;

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

    public List<InmuebleDTO> listarInmuebles(Integer idPropietario, Integer inicio, Integer fin) {
        //TODO RECORDAR QUITAR INMUEBLES DE PRUEBA
        ArrayList<InmuebleDTO> lista = new ArrayList<>();

        InmuebleDTO i1 = new InmuebleDTO();
        InmuebleDTO i2 = new InmuebleDTO();
        InmuebleDTO i3 = new InmuebleDTO();
        InmuebleDTO i4 = new InmuebleDTO();
        InmuebleDTO i5 = new InmuebleDTO();
        InmuebleDTO i6 = new InmuebleDTO();
        InmuebleDTO i7 = new InmuebleDTO();
        InmuebleDTO i8 = new InmuebleDTO();

        i1 = new InmuebleDTO();
        i1.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test1.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i1.setId(123);
        i1.setLocalidad("Sauce Viejo");
        i1.setCalle("Francia");
        i1.setNumeroCalle(123);

        i2 = new InmuebleDTO();
        i2.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test2.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i2.setId(15656);
        i2.setLocalidad("Sauce Nuevo");
        i2.setCalle("Italia");
        i2.setNumeroCalle(6969);

        i3 = new InmuebleDTO();
        i3.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test3.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i3.setId(1456);
        i3.setLocalidad("Sauce adsfafd");
        i3.setCalle("asfasdfasfasf");
        i3.setNumeroCalle(9784);

        i4 = new InmuebleDTO();
        i4.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test4.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i4.setId(123456);
        i4.setLocalidad("Basta de sauces porfa");
        i4.setCalle("Random");
        i4.setNumeroCalle(13213);

        i5 = new InmuebleDTO();
        i5.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test5.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i5.setId(78997);
        i5.setLocalidad("Rincon de tu casa");
        i5.setLongitud(64556.2);
        i5.setLatitud(4633.2556465);

        i6 = new InmuebleDTO();
        i6.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test2.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i6.setId(15656);
        i6.setLocalidad("Sauce Repetido");
        i6.setCalle("aliateaas");
        i6.setNumeroCalle(4566598);


        lista.add(i1);
        lista.add(i2);
        lista.add(i3);
        lista.add(i4);
        lista.add(i5);
        lista.add(i6);
        lista.add(i4);
        lista.add(i5);
        

        if( lista.size() < fin - 1){
            fin = lista.size();
        }
        return lista.subList(inicio - 1, fin);
    }

        for(Imagen i : inmueble.getFotosInmueble()){
            listaImagenes.add(i.getImagen());
            listaNombreArchivos.add(i.getNombreArchivo());
        }

        idto.setFotosInmueble(listaImagenes);
        idto.setNombresArchivosFotos(listaNombreArchivos);

        return idto;
    }
}
