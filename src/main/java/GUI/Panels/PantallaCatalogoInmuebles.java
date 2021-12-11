package GUI.Panels;

import DAO.Util.InmuebleDTO;
import DAO.Util.PreferenciaDTO;
import GUI.Util.Pantalla;
import Services.GestorGUI;
import Services.GestorInmuebles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PantallaCatalogoInmuebles{
    private JPanel panelPrincipal;
    private JPanel panelTitulos;
    private JPanel panelInmuebles;
    private JPanel panelBotonesInferiores;
    private JPanel panelInmueble1;
    private JPanel panelInmueble2;
    private JPanel panelInmueble3;
    private JPanel panelInmueble5;
    private JPanel panelBotonesPaginador;
    private JLabel tituloLabel;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JButton crearInmuebleButton;
    private JLabel imagenProp1Label;
    private JLabel codigoProp1Label;
    private JLabel localidadProp1Label;
    private JLabel pvDireccionProp1Label;
    private JLabel svDireccionProp1Label;
    private JPanel panelDatosProp1;
    private JPanel panelBotonesProp1;
    private JLabel imagenProp2Label;
    private JLabel imagenProp3Label;
    private JLabel imagenProp4Label;
    private JLabel imagenProp5Label;
    private JPanel panelDatosProp2;
    private JPanel panelDatosProp3;
    private JPanel panelDatosProp5;
    private JLabel codigoProp2Label;
    private JLabel codigoProp3Label;
    private JLabel codigoProp4Label;
    private JLabel codigoProp5Label;
    private JLabel localidadProp2Label;
    private JLabel localidadProp3Label;
    private JLabel localidadProp4Label;
    private JLabel localidadProp5Label;
    private JLabel pvDireccionProp2Label;
    private JLabel pvDireccionProp3Label;
    private JLabel pvDireccionProp4Label;
    private JLabel pvDireccionProp5Label;
    private JLabel svDireccionProp2Label;
    private JLabel svDireccionProp3Label;
    private JLabel svDireccionProp4Label;
    private JLabel svDireccionProp5Label;
    private JPanel panelBotonesProp2;
    private JPanel panelBotonesProp3;
    private JPanel panelBotonesProp5;
    private JLabel numeroDePaginaLabel;
    private JButton atrasAuxButton;
    private JButton buttonVerMasProp1;
    private JButton buttonVerMasProp2;
    private JButton buttonVerMasProp3;
    private JButton buttonVerMasProp5;
    private JPanel panelDatosExtrasProp1;
    private JPanel panelDatosExtrasProp2;
    private JPanel panelDatosExtrasProp3;
    private JPanel panelDatosExtrasProp4;
    private JPanel panelDatosExtrasProp5;
    private JPanel panelDatosExtras2Prop1;
    private JPanel panelDatosExtras2Prop2;
    private JPanel panelDatosExtras2Prop3;
    private JPanel panelDatosExtras2Prop4;
    private JPanel panelDatosExtras2Prop5;
    private JLabel barrioProp1Label;
    private JLabel barrioProp2Label;
    private JLabel barrioProp3Label;
    private JLabel barrioProp4Label;
    private JLabel barrioProp5Label;
    private JLabel tipoProp1Label;
    private JLabel tipoProp2Label;
    private JLabel tipoProp3Label;
    private JLabel tipoProp4Label;
    private JLabel tipoProp5Label;
    private JLabel dormitoriosProp1Label;
    private JLabel dormitoriosProp2Label;
    private JLabel dormitoriosProp3Label;
    private JLabel dormitoriosProp4Label;
    private JLabel dormitoriosProp5Label;
    private JLabel baniosProp1Label;
    private JLabel baniosProp2Label;
    private JLabel baniosProp3Label;
    private JLabel baniosProp4Label;
    private JLabel baniosProp5Label;
    private JLabel garagePatioProp1Label;
    private JLabel garagePatioProp2Label;
    private JLabel garagePatioProp3Label;
    private JLabel garagePatioProp4Label;
    private JLabel garagePatioProp5Label;
    private JLabel superficieProp1Label;
    private JLabel superficieProp2Label;
    private JLabel superficieProp3Label;
    private JLabel superficieProp4Label;
    private JLabel superficieProp5Label;
    private JLabel precioVentaProp1Label;
    private JLabel precioVentaProp2Label;
    private JLabel precioVentaProp3Label;
    private JLabel precioVentaProp4Label;
    private JLabel precioVentaProp5Label;
    private JLabel precioReservaProp1Label;
    private JLabel precioReservaProp2Label;
    private JLabel precioReservaProp3Label;
    private JLabel precioReservaProp4Label;
    private JLabel precioReservaProp5Label;
    private JPanel panelDatosProp4;
    private JPanel panelInmueble4;
    private JButton buttonVerMasProp4;
    private GestorInmuebles gestorInmuebles;
    private ArrayList<InmuebleDTO> inmueblesActuales;
    private InmuebleDTO inmueblePorDefecto;
    private Integer idPropietario;
    private Integer paginaActual;
    private ActionListener actionListenerBotonSiguiente;
    private PreferenciaDTO preferenciasCliente;

    public PantallaCatalogoInmuebles(PreferenciaDTO preferencias){
        //Seteamos parámetros del inmueble por defecto
        crearInmueblePorDefecto();

        preferenciasCliente=preferencias;

        //Defino el gestor
        gestorInmuebles = new GestorInmuebles();

        //Definimos que es la primer pagina
        paginaActual = 1;

        //Obtengo los primeros 6 inmuebles del propietario (el ultimo solo para determinar si se habilita o no el boton de siguiente)
        inmueblesActuales = new ArrayList<>();
        inmueblesActuales.addAll(gestorInmuebles.filtrarInmuebles(preferencias));

        actualizarTablitaInmuebles(inmueblesActuales);
        actualizarBotones();

        actionListenerBotonSiguiente = crearActionListenerSiguiente(false);

        siguienteButton.addActionListener(actionListenerBotonSiguiente);


        anteriorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginaActual--;
                Integer fin = paginaActual * 5;
                Integer inicio = fin - 5;

                //Actualizamos la lista de inmuebles
                ArrayList<InmuebleDTO> inmueblesAMostrar = new ArrayList<>();
                inmueblesAMostrar.addAll(inmueblesActuales.subList(inicio,fin));
                actualizarTablitaInmuebles(inmueblesAMostrar);
                actualizarBotones();
                numeroDePaginaLabel.setText(paginaActual.toString());

            }
        });

        atrasAuxButton.setVisible(true);

        atrasAuxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });

        setearListenersVerMas();

        actualizarTablitaInmuebles(inmueblesActuales);
        actualizarBotones();
    }

    private void setearListenersVerMas() {
        buttonVerMasProp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5).getId());
                idto.setPreferenciasClienteDTO(preferenciasCliente);
                GestorGUI.pushModificar(Pantalla.VER_INMUEBLE,idto);
            }
        });


        buttonVerMasProp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5 +1).getId());
                idto.setPreferenciasClienteDTO(preferenciasCliente);
                GestorGUI.pushModificar(Pantalla.VER_INMUEBLE,idto);
            }
        });

        buttonVerMasProp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5+ 2).getId());
                idto.setPreferenciasClienteDTO(preferenciasCliente);
                GestorGUI.pushModificar(Pantalla.VER_INMUEBLE,idto);
            }
        });

        buttonVerMasProp4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5+3).getId());
                idto.setPreferenciasClienteDTO(preferenciasCliente);
                GestorGUI.pushModificar(Pantalla.VER_INMUEBLE,idto);
            }
        });

        buttonVerMasProp5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5+4).getId());
                idto.setPreferenciasClienteDTO(preferenciasCliente);
                GestorGUI.pushModificar(Pantalla.VER_INMUEBLE,idto);
            }
        });

    }


    private void actualizarBotones() {
        if(inmueblesActuales.size() < paginaActual * 5 + 1){
            siguienteButton.setEnabled(false);
        }else{
            siguienteButton.setEnabled(true);
        }

        if(paginaActual == 1){
            anteriorButton.setEnabled(false);
        }else{
            anteriorButton.setEnabled(true);
        }
    }

    private InmuebleDTO crearInmueblePorDefecto() {
        inmueblePorDefecto = new InmuebleDTO();
        inmueblePorDefecto.setFotoPrincipal(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("casitadefault.png")).getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        inmueblePorDefecto.setId(-1);
        inmueblePorDefecto.setLocalidad("Localidad de Prueba");
        inmueblePorDefecto.setCalle("Calle de Prueba");
        inmueblePorDefecto.setNumeroCalle(-1111);
        inmueblePorDefecto.setBarrio("Barrio de prueba");
        inmueblePorDefecto.setTipoInmueble("No es inmueble");
        inmueblePorDefecto.setCantidadDormitorios(-1);
        inmueblePorDefecto.setCantidadBanios(-1);
        inmueblePorDefecto.setTieneCochera(false);
        inmueblePorDefecto.setTienePatio(false);
        inmueblePorDefecto.setTamanioInmueble(-1.0);
        inmueblePorDefecto.setPrecio(-1111111f);
        inmueblePorDefecto.setPrecioReserva(-1111f);
        return inmueblePorDefecto;
    }

    private ActionListener crearActionListenerSiguiente(Boolean conPropietario){
         return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //Calculamos los inmuebles a mostrar segun el numero de pagina
                Integer inicio = paginaActual * 5 + 2;
                //Sumamos 4 porque siempre nos sobra 1 inmueble de la primer solicitud a la base
                Integer fin = inicio + 4;
                paginaActual ++;

                //Si aun no pedimos estos inmuebles a la base de datos, los pedimos
                if(inmueblesActuales.size() <= (inicio-1)){
                    if(conPropietario){
                        inmueblesActuales.addAll(gestorInmuebles.listarInmueblesPorPropietario(idPropietario,  inicio ,fin));
                    }else{
                        //Solucion provisoria de bug
                        inmueblesActuales.addAll(new ArrayList<>());
                    }
                }

                //Una vez tenemos todos los inmuebles, nos fijamos el tamanio de la lista, de no ser lo suficientemente grande como para ocupar los 5
                //lugares de inmuebles, achicamos el margen a mostrar
                if(inmueblesActuales.size() < fin - 1){
                    fin = inmueblesActuales.size() + 1;
                }

                //Actualizamos la lista de inmuebles
                ArrayList<InmuebleDTO> inmueblesAMostrar = new ArrayList<>();
                inmueblesAMostrar.addAll(inmueblesActuales.subList(inicio-2,fin-1));

                actualizarTablitaInmuebles(inmueblesAMostrar);
                actualizarBotones();
                numeroDePaginaLabel.setText(paginaActual.toString());
            }
        };
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public JLabel getTituloLabel(){return tituloLabel;}
    public void setTituloLabel(String tituloLabel){this.tituloLabel.setText(tituloLabel);}
    public JButton getCrearInmuebleButton(){return crearInmuebleButton;}

    private void actualizarTablitaInmuebles(ArrayList<InmuebleDTO> listaInmuebles){

        Integer totalImagenes = listaInmuebles.size();

        //Solo mostramos 5, el 6to es para manejar logica de siguiente
        if(totalImagenes >= 6){
            totalImagenes = 5;
        }

        for(int i = 1 ; i <= totalImagenes ; i++){
            mostrarInmueble(listaInmuebles.get(i-1),i);
        }

        for(int i = totalImagenes + 1 ; i<= 5 ; i++){
            mostrarInmueble(inmueblePorDefecto,i);
        }

    }

    private void mostrarInmueble(InmuebleDTO inmuebleDTO, int i) {

        ImageIcon foto = new ImageIcon(inmuebleDTO.getFotoPrincipal().getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING));
        String codigo = "Código: " + inmuebleDTO.getId().toString();
        String localidad = "Localidad: " + inmuebleDTO.getLocalidad();
        String pvDireccion;
        String svDireccion;
        String barrio = inmuebleDTO.getBarrio();
        String tipo = "Tipo: " + inmuebleDTO.getTipoInmueble();
        String dormitorios = "Dormitorios: " + inmuebleDTO.getCantidadDormitorios();
        String banios = "Baños: " + inmuebleDTO.getCantidadBanios();
        String garageYPatio = "Garage: ";
        String superficie =  "Superficie: " + inmuebleDTO.getTamanioInmueble() + " (m2)";
        String precioVenta = "Precio venta: $" + inmuebleDTO.getPrecio();
        String precioReserva = "Precio reserva: $" + inmuebleDTO.getPrecioReserva() + " (día)";


        if(inmuebleDTO.getLatitud()==null){
            pvDireccion = "Calle: " + inmuebleDTO.getCalle();
            svDireccion = "Número: " + inmuebleDTO.getNumeroCalle().toString();
        }else{
            pvDireccion = "Latitud: " + inmuebleDTO.getLatitud().toString();
            svDireccion = "Longitud: " + inmuebleDTO.getLongitud().toString();
        }

        if(barrio == null){
            barrio = "Barrio: No definido";
        }else{
            barrio = "Barrio: " + barrio;
        }

        if(inmuebleDTO.getTieneCochera()){
            garageYPatio = garageYPatio + "Si / Patio: ";
        }else{
            garageYPatio = garageYPatio + "No / Patio: ";
        }

        if(inmuebleDTO.getTienePatio()){
            garageYPatio = garageYPatio + "Si";
        }else{
            garageYPatio = garageYPatio + "No";
        }


        switch (i){
            case 1:
                imagenProp1Label.setIcon(foto);
                codigoProp1Label.setText(codigo);
                localidadProp1Label.setText(localidad);
                pvDireccionProp1Label.setText(pvDireccion);
                svDireccionProp1Label.setText(svDireccion);

                barrioProp1Label.setText(barrio);
                tipoProp1Label.setText(tipo);
                dormitoriosProp1Label.setText(dormitorios);
                baniosProp1Label.setText(banios);
                garagePatioProp1Label.setText(garageYPatio);
                superficieProp1Label.setText(superficie);
                precioVentaProp1Label.setText(precioVenta);
                precioReservaProp1Label.setText(precioReserva);

                buttonVerMasProp1.setEnabled(true);
                if(inmuebleDTO.getId()==-1) {
                    buttonVerMasProp1.setEnabled(false);
                }

                break;
            case 2:
                imagenProp2Label.setIcon(foto);
                codigoProp2Label.setText(codigo);
                localidadProp2Label.setText(localidad);
                pvDireccionProp2Label.setText(pvDireccion);
                svDireccionProp2Label.setText(svDireccion);

                barrioProp2Label.setText(barrio);
                tipoProp2Label.setText(tipo);
                dormitoriosProp2Label.setText(dormitorios);
                baniosProp2Label.setText(banios);
                garagePatioProp2Label.setText(garageYPatio);
                superficieProp2Label.setText(superficie);
                precioVentaProp2Label.setText(precioVenta);
                precioReservaProp2Label.setText(precioReserva);

                buttonVerMasProp2.setEnabled(true);
                if(inmuebleDTO.getId()==-1) {
                    buttonVerMasProp2.setEnabled(false);
                }

                break;
            case 3:
                imagenProp3Label.setIcon(foto);
                codigoProp3Label.setText(codigo);
                localidadProp3Label.setText(localidad);
                pvDireccionProp3Label.setText(pvDireccion);
                svDireccionProp3Label.setText(svDireccion);

                barrioProp3Label.setText(barrio);
                tipoProp3Label.setText(tipo);
                dormitoriosProp3Label.setText(dormitorios);
                baniosProp3Label.setText(banios);
                garagePatioProp3Label.setText(garageYPatio);
                superficieProp3Label.setText(superficie);
                precioVentaProp3Label.setText(precioVenta);
                precioReservaProp3Label.setText(precioReserva);

                buttonVerMasProp3.setEnabled(true);
                if(inmuebleDTO.getId()==-1) {
                    buttonVerMasProp3.setEnabled(false);
                }
                break;
            case 4:
                imagenProp4Label.setIcon(foto);
                codigoProp4Label.setText(codigo);
                localidadProp4Label.setText(localidad);
                pvDireccionProp4Label.setText(pvDireccion);
                svDireccionProp4Label.setText(svDireccion);


                barrioProp4Label.setText(barrio);
                tipoProp4Label.setText(tipo);
                dormitoriosProp4Label.setText(dormitorios);
                baniosProp4Label.setText(banios);
                garagePatioProp4Label.setText(garageYPatio);
                superficieProp4Label.setText(superficie);
                precioVentaProp4Label.setText(precioVenta);
                precioReservaProp4Label.setText(precioReserva);

                buttonVerMasProp4.setEnabled(true);
                if(inmuebleDTO.getId()==-1) {
                    buttonVerMasProp4.setEnabled(false);
                }
                break;
            case 5:
                imagenProp5Label.setIcon(foto);
                codigoProp5Label.setText(codigo);
                localidadProp5Label.setText(localidad);
                pvDireccionProp5Label.setText(pvDireccion);
                svDireccionProp5Label.setText(svDireccion);

                barrioProp5Label.setText(barrio);
                tipoProp5Label.setText(tipo);
                dormitoriosProp5Label.setText(dormitorios);
                baniosProp5Label.setText(banios);
                garagePatioProp5Label.setText(garageYPatio);
                superficieProp5Label.setText(superficie);
                precioVentaProp5Label.setText(precioVenta);
                precioReservaProp5Label.setText(precioReserva);

                buttonVerMasProp5.setEnabled(true);
                if(inmuebleDTO.getId()==-1) {
                    buttonVerMasProp5.setEnabled(false);
                }
                break;
        }

    }
}