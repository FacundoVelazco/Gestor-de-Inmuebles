package GUI.Panels;

import DAO.Util.InmuebleDTO;
import Domain.Inmueble;
import GUI.Panels.AMInmueblePanels.PanelCaracteristicas;
import GUI.Panels.AMInmueblePanels.PanelExtras;
import GUI.Panels.AMInmueblePanels.PanelFotosAndObservaciones;
import GUI.Panels.AMInmueblePanels.PanelUbicacion;
import GUI.Util.Pantalla;
import GUI.Util.TipoPanelAMInmueble;
import Services.GestorGUI;
import Services.GestorInmuebles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PantallaAMInmueble {
    private JPanel panelPrincipal;
    private JPanel panelTitulos;
    private JLabel tituloLabel;
    private JPanel panelRotativo;
    private JPanel panelNoModificables;
    private JLabel codigoLabel;
    private JLabel estadoLabel;
    private JLabel fechaDeCargaLabel;
    private JPanel panelBotonesInferiores;
    private JButton botonCancelar;
    private JButton botonAnterior;
    private JButton botonSiguiente;
    private PanelUbicacion panelUbicacionClase;
    private PanelCaracteristicas panelCaracteristicasClase;
    private PanelExtras panelExtrasClase;
    private PanelFotosAndObservaciones panelFotosAndObservacionesClase;
    private JPanel panelUbicacion;
    private JPanel panelCaracteristicas;
    private JPanel panelExtras;
    private JPanel panelFotosAndObservaciones;
    private GestorInmuebles gestorInmuebles;
    private Boolean esModificar;
    private String propietario;


    //Creamos el Data Transfer Object para el manejo de la información del inmueble
    private InmuebleDTO inmuebleDTO;

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


    public PantallaAMInmueble(String usernamePropietario) {

        //Creo el inmuebleDTO para el manejo de datos
        inmuebleDTO = new InmuebleDTO();

        //Definimos el gestor de inmuebles
        gestorInmuebles = new GestorInmuebles();

        esModificar = false;

        propietario = usernamePropietario;

        //Creamos todas las clases asociadas a los paneles a utilizar
        panelUbicacionClase = new PanelUbicacion();
        panelCaracteristicasClase = new PanelCaracteristicas();
        panelExtrasClase = new PanelExtras();
        panelFotosAndObservacionesClase = new PanelFotosAndObservaciones();

        //Seteamos todos los paneles que vamos a utilizar
        panelUbicacion = panelUbicacionClase.getPanelUbicacion();
        panelCaracteristicas = panelCaracteristicasClase.getPanelCaracteristicas();
        panelExtras = panelExtrasClase.getPanelExtras();
        panelFotosAndObservaciones = panelFotosAndObservacionesClase.getPanelFotosAndObservaciones();

        //Añadimos el panel de ubicación, que es el que aparece en primer instancia
        panelRotativo.add(panelUbicacion);

        //Refrescamos el panel rotativo para que aparezca el panel Ubicación
        refrescarPanelRotativo();


        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambioPanelSiguiente(getPanelInternoActivo());
                refrescarPanelRotativo();
            }
        });

        botonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambioPanelAtras(getPanelInternoActivo());
                refrescarPanelRotativo();
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.popModificar(usernamePropietario);
            }
        });
    }

    //Constructor en caso de que se ingrese al panel por la opción de modificar
    public PantallaAMInmueble(InmuebleDTO idto) {
        this(idto.getUsernamePropietario());
        esModificar = true;

        codigoLabel.setText("Código: " + idto.getId().toString());
        estadoLabel.setText("Estado: " + idto.getEstado());
        fechaDeCargaLabel.setText("Fecha de carga: " + idto.getFechaCarga().toString());
        inmuebleDTO = idto;
        cargarDatosPaneles(idto);
    }

    private void cargarDatosPaneles(InmuebleDTO idto) {
        panelUbicacionClase.setDatos(idto);
        panelCaracteristicasClase.setDatos(idto);
        panelExtrasClase.setDatos(idto);
        panelFotosAndObservacionesClase.setDatos(idto);
    }

    private void refrescarPanelRotativo(){
        panelRotativo.revalidate();
        panelRotativo.repaint();
    }

    //Obtenemos que panel interno esta activo
    private TipoPanelAMInmueble getPanelInternoActivo(){
        String nombrePanel = panelRotativo.getComponent(0).getName();
        switch (nombrePanel){
            case "UBICACION":
                return TipoPanelAMInmueble.UBICACION;
            case "CARACTERISTICAS":
                return TipoPanelAMInmueble.CARACTERISTICAS;
            case "EXTRAS":
                return TipoPanelAMInmueble.EXTRAS;
        }
        //En caso de que no haya retornado antes
        return TipoPanelAMInmueble.FOTOS_Y_OBSERVACIONES;
    }

    private void cambioPanelSiguiente(TipoPanelAMInmueble panelActual){

        Boolean perimtidoCambiarPantalla = true;

        switch (panelActual){
            case UBICACION:
                perimtidoCambiarPantalla = panelUbicacionClase.validarDatos();
                if(perimtidoCambiarPantalla) {
                    obtenerDatosPanel(panelActual);
                    panelRotativo.remove(0);
                    panelRotativo.add(panelCaracteristicas);
                    botonAnterior.setEnabled(true);

                }
                break;
            case CARACTERISTICAS:
                perimtidoCambiarPantalla = panelCaracteristicasClase.validarDatos();
                if(perimtidoCambiarPantalla){
                    obtenerDatosPanel(panelActual);
                    panelRotativo.remove(0);
                    panelRotativo.add(panelExtras);
                }
                break;
            case EXTRAS:
                obtenerDatosPanel(panelActual);
                panelRotativo.remove(0);
                panelRotativo.add(panelFotosAndObservaciones);
                botonSiguiente.setText("Finalizar");
                break;
            case FOTOS_Y_OBSERVACIONES:
                perimtidoCambiarPantalla = panelFotosAndObservacionesClase.validarDatos();
                if(perimtidoCambiarPantalla){
                    obtenerDatosPanel(panelActual);
                    inmuebleDTO.setUsernamePropietario(propietario);
                    gestorInmuebles.guardarInmueble(inmuebleDTO);
                    if(esModificar){
                        GestorGUI.popUpExito("Éxito", "El inmueble ha sido modificado exitosamente");
                    }else{
                        GestorGUI.popUpExito("Éxito", "El inmueble ha sido creado exitosamente");
                    }
                    GestorGUI.popModificar(propietario);
                }
                break;
        }


    }

    private void cambioPanelAtras(TipoPanelAMInmueble panelActual){
        switch (panelActual){

            case CARACTERISTICAS:
                panelRotativo.remove(0);
                panelRotativo.add(panelUbicacion);
                botonAnterior.setEnabled(false);
                break;
            case EXTRAS:
                panelRotativo.remove(0);
                panelRotativo.add(panelCaracteristicas);
                break;
            case FOTOS_Y_OBSERVACIONES:
                panelRotativo.remove(0);
                panelRotativo.add(panelExtras);
                botonSiguiente.setText("Siguiente");
                break;
        }
    }

    private void obtenerDatosPanel(TipoPanelAMInmueble panelActual){
        switch (panelActual){
            case UBICACION:
                actualizarDatosUbicacionDTO(panelUbicacionClase.obtenerDatos());
                break;
            case CARACTERISTICAS:
                actualizarDatosCaracteristicasDTO(panelCaracteristicasClase.obtenerDatos());
                break;
            case EXTRAS:
                actualizarDatosExtrasDTO(panelExtrasClase.obtenerDatos());
                break;
            case FOTOS_Y_OBSERVACIONES:
                actualizarDatosFotosDTO(panelFotosAndObservacionesClase.obtenerDatos());
                break;
        }
    }



    private void actualizarDatosUbicacionDTO(InmuebleDTO aux){
        inmuebleDTO.setProvincia(aux.getProvincia());
        inmuebleDTO.setLocalidad(aux.getLocalidad());
        inmuebleDTO.setBarrio(aux.getBarrio());
        inmuebleDTO.setCalle(aux.getCalle());
        inmuebleDTO.setNumeroCalle(aux.getNumeroCalle());
        inmuebleDTO.setLatitud(aux.getLatitud());
        inmuebleDTO.setLongitud(aux.getLongitud());
        inmuebleDTO.setPiso(aux.getPiso());
        inmuebleDTO.setDepartamento(aux.getDepartamento());
    }

    private void actualizarDatosCaracteristicasDTO(InmuebleDTO aux){
        inmuebleDTO.setTipoInmueble(aux.getTipoInmueble());
        inmuebleDTO.setOrientacion(aux.getOrientacion());
        inmuebleDTO.setLongitudFrente(aux.getLongitudFrente());
        inmuebleDTO.setLongitudFondo(aux.getLongitudFondo());
        inmuebleDTO.setTamanioInmueble(aux.getTamanioInmueble());
        inmuebleDTO.setPrecio(aux.getPrecio());
        inmuebleDTO.setPrecioReserva(aux.getPrecioReserva());
        inmuebleDTO.setCantidadBanios(aux.getCantidadBanios());
        inmuebleDTO.setCantidadDormitorios(aux.getCantidadDormitorios());
        inmuebleDTO.setAntiguedad(aux.getAntiguedad());
        inmuebleDTO.setEsPropiedadHorizontal(aux.getEsPropiedadHorizontal());
    }

    private void actualizarDatosExtrasDTO(InmuebleDTO aux){
        inmuebleDTO.setTieneCochera(aux.getTieneCochera());
        inmuebleDTO.setTienePatio(aux.getTienePatio());
        inmuebleDTO.setTienePiscina(aux.getTienePiscina());
        inmuebleDTO.setTieneAguaCorriente(aux.getTieneAguaCorriente());
        inmuebleDTO.setTieneCloacas(aux.getTieneCloacas());
        inmuebleDTO.setTieneGasNatural(aux.getTieneGasNatural());
        inmuebleDTO.setTieneAguaCaliente(aux.getTieneAguaCaliente());
        inmuebleDTO.setTieneTelefono(aux.getTieneTelefono());
        inmuebleDTO.setTieneLavadero(aux.getTieneLavadero());
        inmuebleDTO.setTienePavimento(aux.getTienePavimento());
    }

    private void actualizarDatosFotosDTO(InmuebleDTO aux){
        inmuebleDTO.setFotoPrincipal(aux.getFotoPrincipal());
        inmuebleDTO.setNombreArchivoFotoPrincipal(aux.getNombreArchivoFotoPrincipal());
        inmuebleDTO.setFotosInmueble(aux.getFotosInmueble());
        inmuebleDTO.setNombresArchivosFotos(aux.getNombresArchivosFotos());
        inmuebleDTO.setObservaciones(aux.getObservaciones());
    }

}
