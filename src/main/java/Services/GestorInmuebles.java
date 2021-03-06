package Services;

import DAO.*;
import DAO.Util.ClienteDTO;
import DAO.Util.InmuebleDTO;
import DAO.Util.PreferenciaDTO;
import Domain.Direccion;
import Domain.Inmueble;
import Domain.Localidad;
import Domain.Util.TipoInmueble;
import Domain.*;
import Domain.Util.EstadoInmueble;
import Domain.Util.Orientacion;

import javax.swing.*;
import java.awt.*;
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
        Inmueble inmueble = new Inmueble();
        try {
            inmueble = generarInmuebleDesdeDTO(iDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Devuelvo el ID generado
        return inmuebleDAO.save(inmueble);
    }

    public InmuebleDTO cargarInmueble(Integer id) {

        DAOBdInmueble daoInmueble = new DAOBdInmueble();
        Inmueble inmueble = daoInmueble.getById(id);
        InmuebleDTO idto = generarDTODesdeInmueble(inmueble,true);

        return idto;
    }


    public List<InmuebleDTO> listarInmueblesPorPropietario(Integer idPropietario) {
        ArrayList<InmuebleDTO> listaInmueblesDTO = new ArrayList<>();
        DAOBdInmueble daoInmueble = new DAOBdInmueble();
        ArrayList<Inmueble> listaInmueblesDominio = new ArrayList<>();
        listaInmueblesDominio.addAll(daoInmueble.listAllByPropietario(idPropietario));

        for (Inmueble i : listaInmueblesDominio) {
            InmuebleDTO idto = generarDTODesdeInmueble(i, false);
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
            InmuebleDTO idto = generarDTODesdeInmueble(i, false);
            listaInmueblesDTO.add(idto);
        }

        return listaInmueblesDTO;
    }

    public List<InmuebleDTO> listarInmuebles(Integer inicio, Integer fin) {
        ArrayList<InmuebleDTO> listaInmueblesDTO = new ArrayList<>();
        DAOBdInmueble daoInmueble = new DAOBdInmueble();
        ArrayList<Inmueble> listaInmueblesDominio = new ArrayList<>();
        listaInmueblesDominio.addAll(daoInmueble.listAll(inicio, fin));

        for (Inmueble i : listaInmueblesDominio) {
            InmuebleDTO idto = generarDTODesdeInmueble(i, false);
            listaInmueblesDTO.add(idto);
        }

        return listaInmueblesDTO;
    }

    public List<InmuebleDTO> filtrarInmuebles(PreferenciaDTO filtro) {

        ArrayList<InmuebleDTO> listaInmueblesDTO = new ArrayList<>();
        DAOBdInmueble daoInmueble = new DAOBdInmueble();
        ArrayList<Inmueble> listaInmueblesDominio = new ArrayList<>();
        listaInmueblesDominio.addAll(daoInmueble.listAll());

        if(filtro!=null){
            listaInmueblesDominio = aplicarFiltros(filtro, listaInmueblesDominio);
        }



        for (Inmueble i : listaInmueblesDominio) {
            InmuebleDTO idto = generarDTODesdeInmueble(i, false);
            listaInmueblesDTO.add(idto);
        }
        return listaInmueblesDTO;
    }

    public Integer generarCompra(ClienteDTO clienteDTO, InmuebleDTO inmuebleDTO){
        DAOBdCliente daoBdCliente= new DAOBdCliente();
        DAOBdInmueble daoBdInmueble= new DAOBdInmueble();
        DAOBdVenta daoBdVenta = new DAOBdVenta();

        Inmueble inmueble = daoBdInmueble.getById(inmuebleDTO.getId());
        Cliente cliente = daoBdCliente.getByUsername(clienteDTO.getUsername());

        inmuebleDTO.setEstado("VENDIDO");
        guardarInmueble(inmuebleDTO);

        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setInmueble(inmueble);

        return daoBdVenta.save(venta);
    }

    private ArrayList<Inmueble> aplicarFiltros(PreferenciaDTO filtro, ArrayList<Inmueble> listaInmuebles){

        ArrayList<Inmueble> listaAux = new ArrayList<>();
        listaAux.addAll(listaInmuebles);

        //System.out.println("1: " + listaAux.size());
        //Filtrar por localidad, barrio, tipo, precio, dormitorios
        for(Inmueble i: listaInmuebles){
            if(filtro.getLocalidad() != null) {
                if (!i.getLocalidad().getNombre().equals(filtro.getLocalidad())) {
                    listaAux.remove(i);
                }
            }

            //System.out.println("2: " + listaAux.size());

            //Si el barrio no es ""
            if(filtro.getBarrio() == null || !filtro.getBarrio().isEmpty()){
                // Primero chequeamos que el barrio no sea nulo
                if(i.getDireccion().getBarrio() == null){
                    listaAux.remove(i);
                }
                //Si no es nulo comparamos que existan coincidencias en los nombres de barrio
                else if(!i.getDireccion().getBarrio().toLowerCase().contains(filtro.getBarrio().toLowerCase())){
                    listaAux.remove(i);
                }
            }

            //System.out.println("3: " + listaAux.size());
            if(filtro.getTipoInmueble() != null && filtro.getTipoInmueble() != "Cualquiera"){
                if(!i.getCaracteristicasInmueble().getTipoInmueble().equals(TipoInmueble.obtenerByString(filtro.getTipoInmueble()))){
                    listaAux.remove(i);
                }
            }

            //System.out.println("4: " + listaAux.size());
            if(filtro.getMontoDisponible() != null){
                if(!(i.getPrecio()<=filtro.getMontoDisponible())){
                    listaAux.remove(i);
                }
            }

            //System.out.println("5: " + listaAux.size());
            if(filtro.getCantidadDormitorios() != null){
                if(!(i.getCaracteristicasInmueble().getCantidadDormitorios()>=filtro.getCantidadDormitorios())){
                    listaAux.remove(i);
                }
            }

            //System.out.println("6: " + listaAux.size());
            //Si le interesa que tenga cochera, igual para las otras caracter??sticas
            if(filtro.getTieneCochera()!=null && filtro.getTieneCochera()) {
                if (!i.getCaracteristicasInmueble().getTieneCochera()) {
                    listaAux.remove(i);
                }
            }

            //System.out.println("7: " + listaAux.size());

            if(filtro.getTienePatio()!=null && filtro.getTienePatio()) {
                if (!i.getCaracteristicasInmueble().getTienePatio()) {
                    listaAux.remove(i);
                }
            }
            //System.out.println("8: " + listaAux.size());
            if(filtro.getTienePiscina()!=null && filtro.getTienePiscina()) {
                if (!i.getCaracteristicasInmueble().getTienePiscina()) {
                    listaAux.remove(i);
                }
            }
            //System.out.println("9: " + listaAux.size());
            if(filtro.getTieneAguaCorriente()!=null && filtro.getTieneAguaCorriente()) {
                if (!i.getCaracteristicasInmueble().getTieneAguaCorriente()) {
                    listaAux.remove(i);
                }
            }
            //System.out.println("10: " + listaAux.size());
            if(filtro.getTieneCloacas()!=null && filtro.getTieneCloacas()) {
                if (!i.getCaracteristicasInmueble().getTieneCloacas()) {
                    listaAux.remove(i);
                }
            }
            //System.out.println("11: " + listaAux.size());
            if(filtro.getTieneGasNatural()!=null && filtro.getTieneGasNatural()) {
                if (!i.getCaracteristicasInmueble().getTieneGasNatural()) {
                    listaAux.remove(i);
                }
            }

            if(filtro.getTieneAguaCaliente()!=null && filtro.getTieneAguaCaliente()) {
                if (!i.getCaracteristicasInmueble().getTieneAguaCaliente()) {
                    listaAux.remove(i);
                }
            }

            if(filtro.getTieneTelefono()!=null && filtro.getTieneTelefono()) {
                if (!i.getCaracteristicasInmueble().getTieneTelefono()) {
                    listaAux.remove(i);
                }
            }

            if(filtro.getTieneLavadero()!=null && filtro.getTieneLavadero()) {
                if (!i.getCaracteristicasInmueble().getTieneLavadero()) {
                    listaAux.remove(i);
                }
            }

            if(filtro.getTienePavimento()!=null && filtro.getTienePavimento()) {
                if (!i.getCaracteristicasInmueble().getTienePavimento()) {
                    listaAux.remove(i);
                }
            }

        }

        return listaAux;
    }

    public Integer generarReserva(ClienteDTO clienteDTO, InmuebleDTO inmuebleDTO, Integer duracion){
        DAOBdCliente daoBdCliente= new DAOBdCliente();
        DAOBdInmueble daoBdInmueble= new DAOBdInmueble();
        DAOBdReserva daoBdReserva = new DAOBdReserva();

        Inmueble inmueble = daoBdInmueble.getById(inmuebleDTO.getId());
        Cliente cliente = daoBdCliente.getByUsername(clienteDTO.getUsername());


        inmueble.setEstado(EstadoInmueble.RESERVADO);

        Reserva reserva = new Reserva();
        reserva.setClienteReserva(cliente);
        reserva.setFechaCreacionReserva(LocalDate.now());
        reserva.setFechaFinReserva(LocalDate.now().plusDays(duracion));
        reserva.setInmueble(inmueble);
        reserva.setMonto(inmuebleDTO.getPrecioReserva()*duracion);

        return daoBdReserva.save(reserva);
    }

    private Inmueble generarInmuebleDesdeDTO(InmuebleDTO iDTO) throws Exception {
        Inmueble inmueble = new Inmueble();

        DAOBdPropietario daoBdPropietario = new DAOBdPropietario();
        Propietario p = daoBdPropietario.getByUsername(iDTO.getUsernamePropietario());
        p.getInmuebles().add(inmueble);
        inmueble.setPropietarioInmueble(p);

        if(iDTO.getId()!=null) {
            inmueble.setId(iDTO.getId());
        }

        if(iDTO.getEstado()!=null){
            inmueble.setEstado(EstadoInmueble.valueOf(iDTO.getEstado()));
        }
        if(iDTO.getFechaCarga()!=null) {
            inmueble.setFechaCarga(iDTO.getFechaCarga());
        }


        inmueble.setPropiedadDestacada(iDTO.getPropiedadDestacada());

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
        direccion.setInmueble(inmueble);

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
        datosInmueble.setTieneAguaCorriente(iDTO.getTieneAguaCaliente());
        datosInmueble.setTieneTelefono(iDTO.getTieneTelefono());
        datosInmueble.setTieneLavadero(iDTO.getTieneLavadero());
        datosInmueble.setTienePavimento(iDTO.getTienePavimento());

        datosInmueble.setInmuebleAsociado(inmueble);
        inmueble.setCaracteristicasInmueble(datosInmueble);

        inmueble.setPrecio(iDTO.getPrecio());
        inmueble.setPrecioReserva(iDTO.getPrecioReserva());

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

    private InmuebleDTO generarDTODesdeInmueble(Inmueble inmueble, boolean desdeModificar) {
        InmuebleDTO idto = new InmuebleDTO();
        idto.setId(inmueble.getId());
        idto.setEstado(inmueble.getEstado().toString());
        idto.setUsernamePropietario(inmueble.getPropietarioInmueble().getUsername());
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
        idto.setPrecioReserva(inmueble.getPrecioReserva());

        idto.setFotoPrincipal(inmueble.getFotoPrincipal().getImagen());
        idto.setNombreArchivoFotoPrincipal(inmueble.getFotoPrincipal().getNombreArchivo());

        ArrayList<ImageIcon> listaImagenes = new ArrayList<>();
        ArrayList<String> listaNombreArchivos = new ArrayList<>();

        if(desdeModificar) {
            for (Imagen i : inmueble.getFotosInmueble()) {
                ImageIcon ii = i.getImagen();
                String s = i.getNombreArchivo();
                listaImagenes.add(ii);
                listaNombreArchivos.add(s);
            }
        }

        idto.setFotosInmueble(listaImagenes);
        idto.setNombresArchivosFotos(listaNombreArchivos);

        return idto;
    }

    public List<InmuebleDTO> listarInmueblesPrueba(Integer idPropietario, Integer inicio, Integer fin){
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
