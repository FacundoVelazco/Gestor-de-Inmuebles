package Services;

import DAO.*;
import DAO.Util.InmuebleDTO;
import DAO.Util.LocalidadDTO;
import Domain.Direccion;
import Domain.Inmueble;
import Domain.Localidad;
import Domain.Util.TipoInmueble;
import Domain.*;
import Domain.Util.EstadoInmueble;
import Domain.Util.Orientacion;
import javax.swing.*;
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
        Inmueble inmueble = new Inmueble();
        try {
            inmueble = generarInmuebleDesdeDTO(iDTO);
        }catch (Exception e){
            //TODO MOSTRAR MENSAJE ERROR
        }


        //Si la competencia es recien creada (aun no tiene ID asignado)
        if (iDTO.getId() == null) {
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

        for (Inmueble i : listaInmueblesDominio) {
            InmuebleDTO idto = generarDTODesdeInmueble(i);
            listaInmueblesDTO.add(idto);
        }

        return listaInmueblesDTO;
    }

    public List<InmuebleDTO> listarInmueblesPorPropietario(Integer idPropietario, Integer inicio, Integer fin) {
        ArrayList<InmuebleDTO> listaInmueblesDTO = new ArrayList<>();
        DAOBdInmueble daoInmueble = new DAOBdInmueble();
        ArrayList<Inmueble> listaInmueblesDominio = new ArrayList<>();
        listaInmueblesDominio.addAll(daoInmueble.listAllByPropietario(idPropietario, inicio, fin));

        for (Inmueble i : listaInmueblesDominio) {
            InmuebleDTO idto = generarDTODesdeInmueble(i);
            listaInmueblesDTO.add(idto);
        }

        return listaInmueblesDTO;
    }

    private Inmueble generarInmuebleDesdeDTO(InmuebleDTO iDTO) throws Exception {
        Inmueble inmueble = new Inmueble();

        inmueble.setId(iDTO.getId());

        //Si estamos modificando el inmueble, seteamos el valor de estado actual
        if (iDTO.getEstado() != null) {
            EstadoInmueble.valueOf(iDTO.getEstado());
        }

        //Si estamos modificando el inmueble, seteamos el valor de fecha de carga que ya tenia el inmueble
        if (iDTO.getFechaCarga() != null) {
            inmueble.setFechaCarga(iDTO.getFechaCarga());
        }

        //Si estamos modificando el inmueble, seteamos el valor de prop destacada que ya tenia el inmueble
        if (iDTO.getPropiedadDestacada() != null) {
            inmueble.setPropiedadDestacada(iDTO.getPropiedadDestacada());
        }

        //LA PROVINCIA POR EL MOMENTO ES INNECESARIO
        //inmueble.setProvincia(iDTO.getProvincia());

        DAOBdLocalidad daoLocalidad = new DAOBdLocalidad();
        Localidad localidad = daoLocalidad.getByName(iDTO.getLocalidad());
        inmueble.setLocalidad(localidad);

        Direccion direccion = new Direccion();

        direccion.setCalle(iDTO.getCalle());
        direccion.setNumero(iDTO.getNumeroCalle());
        direccion.setLongitud(iDTO.getLongitud());
        direccion.setLatitud(iDTO.getLatitud());
        direccion.setPiso(iDTO.getPiso());
        direccion.setDepartamento(iDTO.getDepartamento());
        direccion.setBarrio(iDTO.getBarrio());

        inmueble.setDireccion(direccion);

        Preferencia datosInmueble = new Preferencia();

        datosInmueble.setTipoInmueble(TipoInmueble.obtenerByString(iDTO.getTipoInmueble()));

        datosInmueble.setOrientacion(Orientacion.obtenerByString(iDTO.getOrientacion()));
        datosInmueble.setLongitudFrente(iDTO.getLongitudFrente());
        datosInmueble.setLongitudFondo(iDTO.getLongitudFondo());
        datosInmueble.setTamanioInmueble(iDTO.getTamanioInmueble());
        datosInmueble.setPropiedadHorizontal(iDTO.getEsPropiedadHorizontal());
        datosInmueble.setAntiguedad(iDTO.getAntiguedad());
        datosInmueble.setCantidadDormitorios(iDTO.getCantidadDormitorios());
        datosInmueble.setCantidadBanios(iDTO.getCantidadBanios());
        datosInmueble.setTieneCochera(iDTO.getTieneCochera());
        datosInmueble.setTienePatio(iDTO.getTienePatio());
        datosInmueble.setTienePiscina(iDTO.getTienePiscina());
        datosInmueble.setTieneAguaCaliente(iDTO.getTieneAguaCaliente());
        datosInmueble.setTieneCloacas(iDTO.getTieneCloacas());
        datosInmueble.setTieneGasNatural(iDTO.getTieneGasNatural());
        datosInmueble.setTieneAguaCaliente(iDTO.getTieneAguaCaliente());
        datosInmueble.setTieneTelefono(iDTO.getTieneTelefono());
        datosInmueble.setTieneLavadero(iDTO.getTieneLavadero());
        datosInmueble.setTienePavimento(iDTO.getTienePavimento());

        inmueble.setPrecio(iDTO.getPrecio());

        Imagen fotoPrincipal = new Imagen();
        fotoPrincipal.setImagen(iDTO.getFotoPrincipal());
        fotoPrincipal.setNombreArchivo(iDTO.getNombreArchivoFotoPrincipal());
        fotoPrincipal.setInmuebleAsociado(inmueble);
        inmueble.setFotoPrincipal(fotoPrincipal);

        ArrayList<Imagen> listaFotos = new ArrayList<>();
        for (int i = 0; i < iDTO.getFotosInmueble().size(); i++) {
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

    public List<InmuebleDTO> buscarInmueble(LocalidadDTO localidadDTO,String barrio, TipoInmueble tipo, String dormitorios, String precioMax) {
        LocalidadDAO localidadDAO = new LocalidadSqlDAO();
        DireccionDAO direccionDAO = new DireccionSqlDAO();
        List<Direccion> direcciones = direccionDAO.list();
        List<InmuebleDTO> inmueblesDTO = new ArrayList();

        if(!barrio.isEmpty()){
            for (Direccion direccion: direcciones){
                if(direccion.getBarrio().contains(barrio)){
                    inmueblesDTO.add(generarDTODesdeInmueble(direccion.getInmueble()));
                }
            }
        }else{
            for (Direccion direccion: direcciones){
                inmueblesDTO.add(generarDTODesdeInmueble(direccion.getInmueble()));
            }
        }

        if(localidadDTO != null){
            for(InmuebleDTO inmuebleDTO: inmueblesDTO){
                if(!localidadDTO.nombre.equals(inmuebleDTO.getLocalidad())){
                    inmueblesDTO.remove(inmuebleDTO);
                }
            }
        }
        if(tipo != null){
            for(InmuebleDTO inmuebleDTO: inmueblesDTO){
                if(!inmuebleDTO.getTipoInmueble().equals(tipo.toString())){
                    inmueblesDTO.remove(inmuebleDTO);
                }
            }
        }
        if(dormitorios != null){
            for(InmuebleDTO inmuebleDTO: inmueblesDTO){
                if(inmuebleDTO.getCantidadDormitorios() < Integer.parseInt(dormitorios)){
                    inmueblesDTO.remove(inmuebleDTO);
                }
            }
        }
        if(precioMax != null){
            for(InmuebleDTO inmuebleDTO: inmueblesDTO){
                if(inmuebleDTO.getPrecio() > Integer.parseInt(precioMax)){
                    inmueblesDTO.remove(inmuebleDTO);
                }
            }
        }

        return inmueblesDTO;
    }
    private InmuebleDTO generarDTODesdeInmueble(Inmueble inmueble) {
        InmuebleDTO idto = new InmuebleDTO();
        idto.setId(inmueble.getId());
        idto.setEstado(inmueble.getEstado().toString());
        idto.setFechaCarga(inmueble.getFechaCarga());
        idto.setPropiedadDestacada(inmueble.getPropiedadDestacada());
        idto.setProvincia(inmueble.getLocalidad().getProvincia());
        idto.setLocalidad(inmueble.getLocalidad().getNombre());

        Direccion direccion = inmueble.getDireccion();
        idto.setCalle(direccion.getCalle());
        idto.setNumeroCalle(direccion.getNumero());
        idto.setLongitud(direccion.getLongitud());
        idto.setLatitud(direccion.getLatitud());
        idto.setPiso(direccion.getPiso());
        idto.setDepartamento(direccion.getDepartamento());
        idto.setBarrio(direccion.getBarrio());

        Preferencia caracteristicas = inmueble.getCaracteristicasInmueble();
        idto.setTipoInmueble(TipoInmueble.obtenerStringParaComboBox(caracteristicas.getTipoInmueble()));

        idto.setOrientacion(Orientacion.obtenerStringParaComboBox(caracteristicas.getOrientacion()));
        idto.setTienePavimento(caracteristicas.getTienePavimento());
        idto.setTieneLavadero(caracteristicas.getTieneLavadero());
        idto.setTieneTelefono(caracteristicas.getTieneTelefono());
        idto.setTieneAguaCaliente(caracteristicas.getTieneAguaCaliente());
        idto.setTieneGasNatural(caracteristicas.getTieneGasNatural());
        idto.setTieneCloacas(caracteristicas.getTieneCloacas());
        idto.setTieneAguaCorriente(caracteristicas.getTieneAguaCorriente());
        idto.setTienePiscina(caracteristicas.getTienePiscina());
        idto.setTienePatio(caracteristicas.getTienePatio());
        idto.setTieneCochera(caracteristicas.getTieneCochera());
        idto.setCantidadBanios(caracteristicas.getCantidadBanios());
        idto.setCantidadDormitorios(caracteristicas.getCantidadDormitorios());
        idto.setAntiguedad(caracteristicas.getAntiguedad());
        idto.setEsPropiedadHorizontal(caracteristicas.getPropiedadHorizontal());
        idto.setTamanioInmueble(caracteristicas.getTamanioInmueble());
        idto.setLongitudFondo(caracteristicas.getLongitudFondo());
        idto.setLongitudFrente(caracteristicas.getLongitudFrente());

        idto.setPrecio(inmueble.getPrecio());

        idto.setFotoPrincipal(inmueble.getFotoPrincipal().getImagen());
        idto.setNombreArchivoFotoPrincipal(inmueble.getFotoPrincipal().getNombreArchivo());

        ArrayList<ImageIcon> listaImagenes = new ArrayList<>();
        ArrayList<String> listaNombreArchivos = new ArrayList<>();

        for (Imagen i : inmueble.getFotosInmueble()) {
            listaImagenes.add(i.getImagen());
            listaNombreArchivos.add(i.getNombreArchivo());
        }

        idto.setFotosInmueble(listaImagenes);
        idto.setNombresArchivosFotos(listaNombreArchivos);

        return idto;
    }

    public List<InmuebleDTO> listarInmuebles(Integer idPropietario, Integer inicio, Integer fin){
        //TODO RECORDAR QUITAR INMUEBLES DE PRUEBA
        ArrayList<InmuebleDTO> lista = new ArrayList<>();

        InmuebleDTO i1 = new InmuebleDTO();
        InmuebleDTO i2 = new InmuebleDTO();
        InmuebleDTO i3 = new InmuebleDTO();
        InmuebleDTO i4 = new InmuebleDTO();
        InmuebleDTO i5 = new InmuebleDTO();
        InmuebleDTO i6 = new InmuebleDTO();

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


        if (lista.size() < fin - 1) {
            fin = lista.size();
        }
        return lista.subList(inicio - 1, fin);
    }
}
