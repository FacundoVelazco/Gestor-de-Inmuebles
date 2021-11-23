package GUI.Panels;

import DAO.Util.InmuebleDTO;
import GUI.Util.Pantalla;
import Services.GestorGUI;
import Services.GestorInmuebles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class PantallaMisInmuebles {
    private JPanel panelPrincipal;
    private JPanel panelTitulos;
    private JPanel panelInmuebles;
    private JPanel panelBotonesInferiores;
    private JPanel panelInmueble1;
    private JPanel panelInmueble2;
    private JPanel panelInmueble4;
    private JPanel panelInmueble3;
    private JPanel panelInmueble5;
    private JPanel panelBotonesPaginador;
    private JLabel tituloLabel;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JButton crearInmuebleButton;
    private JButton atrasButton;
    private JButton buttonModificarProp1;
    private JButton buttonEliminarProp1;
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
    private JPanel panelDatosProp4;
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
    private JPanel panelBotonesProp4;
    private JPanel panelBotonesProp5;
    private JButton buttonModificarProp2;
    private JButton buttonModificarProp3;
    private JButton buttonModificarProp4;
    private JButton buttonModificarProp5;
    private JButton buttonEliminarProp2;
    private JButton buttonEliminarProp3;
    private JButton buttonEliminarProp4;
    private JButton buttonEliminarProp5;
    private JLabel numeroDePaginaLabel;
    private GestorInmuebles gestorInmuebles;
    private ArrayList<InmuebleDTO> inmueblesActuales;
    private InmuebleDTO inmueblePorDefecto;
    private Integer idPropietario;
    private Integer paginaActual;


    public PantallaMisInmuebles() {
        //Seteamos parámetros del inmueble por defecto
        crearInmueblePorDefecto();

        //Defino el gestor
        gestorInmuebles = new GestorInmuebles();

        //Definimos que es la primer pagina
        paginaActual = 1;


        //Obtengo los primeros 6 inmuebles del propietario (el ultimo solo para determinar si se habilita o no el boton de siguiente)
        inmueblesActuales = new ArrayList<>();
        inmueblesActuales.addAll(gestorInmuebles.listarInmuebles(idPropietario,1,6));

        actualizarTablitaInmuebles(inmueblesActuales);
        actualizarBotones();

        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //Calculamos los inmuebles a mostrar segun el numero de pagina
                Integer inicio = paginaActual * 5 + 2;
                //Sumamos 4 porque siempre nos sobra 1 inmueble de la primer solicitud a la base
                Integer fin = inicio + 4;
                paginaActual ++;

                //Si aun no pedimos estos inmuebles a la base de datos, los pedimos
                if(inmueblesActuales.size() <= (inicio-1)){
                    inmueblesActuales.addAll(gestorInmuebles.listarInmuebles(idPropietario,  inicio ,fin));
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
        });

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

        crearInmuebleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.AM_INMUEBLE);
            }
        });

        //Logica botones modificar
        cargarLogicaBotonesModificar();

        //Logica botones eliminar
        cargarLogicaBotonesEliminar();


    }

    private void cargarLogicaBotonesEliminar() {


        buttonEliminarProp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5 + 1).getId());
                idto.setEstado("BAJA");
                gestorInmuebles.guardarInmueble(idto);
            }
        });

    }

    private void cargarLogicaBotonesModificar() {

        buttonModificarProp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO MODIFICAR POR USO PARA PRUEBAS
                //gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5).getId());

                InmuebleDTO idto = new InmuebleDTO();
                idto.setId(123);
                idto.setEstado("ALTA");
                idto.setFechaCarga(LocalDate.now());
                idto.setLocalidad("Toba");
                idto.setBarrio("Los hornos");
//                idto.setCalle("Urquiza");
//                idto.setNumeroCalle(5952);
                idto.setLatitud(5664.45);
                idto.setLongitud(654.2);

                idto.setTipoInmueble("Local-Oficina");
                idto.setOrientacion("Sur");
                idto.setLongitudFrente(565.0);
                idto.setLongitudFondo(5646.12);
                idto.setTamanioInmueble(64556.2);
                idto.setAntiguedad(6);
                idto.setCantidadDormitorios(41);
                idto.setCantidadBanios(263);
                idto.setPrecio(654.24f);
                idto.setEsPropiedadHorizontal(true);

                idto.setTieneLavadero(true);
                idto.setTieneTelefono(true);
                idto.setTienePavimento(false);
                idto.setTieneCochera(true);
                idto.setTienePatio(true);
                idto.setTienePiscina(false);
                idto.setTieneAguaCaliente(false);
                idto.setTieneAguaCorriente(true);
                idto.setTieneCloacas(false);
                idto.setTieneGasNatural(true);

                idto.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test1.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
                idto.setNombreArchivoFotoPrincipal("Fotito principal.png");

                ArrayList<ImageIcon> listaImagenes = new ArrayList<>();
                ArrayList<String> nombresArchivos = new ArrayList<>();

//                listaImagenes.add(new ImageIcon(new ImageIcon("src/main/java/Materials/test2.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
//                nombresArchivos.add("Pepito.jpg");

                idto.setFotosInmueble(listaImagenes);
                idto.setNombresArchivosFotos(nombresArchivos);

                GestorGUI.pushModificar(Pantalla.AM_INMUEBLE,idto);
            }
        });

        buttonModificarProp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5 + 1).getId());
                GestorGUI.pushModificar(Pantalla.AM_INMUEBLE,idto);
            }
        });

        buttonModificarProp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5 + 2).getId());
                GestorGUI.pushModificar(Pantalla.AM_INMUEBLE,idto);
            }
        });

        buttonModificarProp4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5 + 3).getId());
                GestorGUI.pushModificar(Pantalla.AM_INMUEBLE,idto);
            }
        });

        buttonModificarProp5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InmuebleDTO idto = gestorInmuebles.cargarInmueble(inmueblesActuales.get((paginaActual-1) * 5 + 4).getId());
                GestorGUI.pushModificar(Pantalla.AM_INMUEBLE,idto);
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

    private void crearInmueblePorDefecto() {
        inmueblePorDefecto = new InmuebleDTO();
        inmueblePorDefecto.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/casitadefault.png").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        inmueblePorDefecto.setId(-1);
        inmueblePorDefecto.setLocalidad("Localidad de Prueba");
        inmueblePorDefecto.setCalle("Calle de Prueba");
        inmueblePorDefecto.setNumeroCalle(-1111);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

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

        if(inmuebleDTO.getLatitud()==null){
            pvDireccion = "Calle: " + inmuebleDTO.getCalle();
            svDireccion = "Número: " + inmuebleDTO.getNumeroCalle().toString();
        }else{
            pvDireccion = "Latitud: " + inmuebleDTO.getLatitud().toString();
            svDireccion = "Longitud: " + inmuebleDTO.getLongitud().toString();
        }

        switch (i){
            case 1:
                imagenProp1Label.setIcon(foto);
                codigoProp1Label.setText(codigo);
                localidadProp1Label.setText(localidad);
                pvDireccionProp1Label.setText(pvDireccion);
                svDireccionProp1Label.setText(svDireccion);

                //Seteo en true por defecto
                buttonModificarProp1.setEnabled(true);
                buttonEliminarProp1.setEnabled(true);
                //Si es el inmueble por defecto (es decir, no hay inmueble) desactivo los botones
                if(inmuebleDTO.getId().equals(-1)){
                    buttonModificarProp1.setEnabled(false);
                    buttonEliminarProp1.setEnabled(false);
                }
                break;
            case 2:
                imagenProp2Label.setIcon(foto);
                codigoProp2Label.setText(codigo);
                localidadProp2Label.setText(localidad);
                pvDireccionProp2Label.setText(pvDireccion);
                svDireccionProp2Label.setText(svDireccion);

                //Seteo en true por defecto
                buttonModificarProp2.setEnabled(true);
                buttonEliminarProp2.setEnabled(true);
                //Si es el inmueble por defecto (es decir, no hay inmueble) desactivo los botones
                if(inmuebleDTO.getId().equals(-1)){
                    buttonModificarProp2.setEnabled(false);
                    buttonEliminarProp2.setEnabled(false);
                }

                break;
            case 3:
                imagenProp3Label.setIcon(foto);
                codigoProp3Label.setText(codigo);
                localidadProp3Label.setText(localidad);
                pvDireccionProp3Label.setText(pvDireccion);
                svDireccionProp3Label.setText(svDireccion);
                //Seteo en true por defecto
                buttonModificarProp3.setEnabled(true);
                buttonEliminarProp3.setEnabled(true);
                //Si es el inmueble por defecto (es decir, no hay inmueble) desactivo los botones
                if(inmuebleDTO.getId().equals(-1)){
                    buttonModificarProp3.setEnabled(false);
                    buttonEliminarProp3.setEnabled(false);
                }
                break;
            case 4:
                imagenProp4Label.setIcon(foto);
                codigoProp4Label.setText(codigo);
                localidadProp4Label.setText(localidad);
                pvDireccionProp4Label.setText(pvDireccion);
                svDireccionProp4Label.setText(svDireccion);
                //Seteo en true por defecto
                buttonModificarProp4.setEnabled(true);
                buttonEliminarProp4.setEnabled(true);
                //Si es el inmueble por defecto (es decir, no hay inmueble) desactivo los botones
                if(inmuebleDTO.getId().equals(-1)){
                    buttonModificarProp4.setEnabled(false);
                    buttonEliminarProp4.setEnabled(false);
                }
                break;
            case 5:
                imagenProp5Label.setIcon(foto);
                codigoProp5Label.setText(codigo);
                localidadProp5Label.setText(localidad);
                pvDireccionProp5Label.setText(pvDireccion);
                svDireccionProp5Label.setText(svDireccion);
                //Seteo en true por defecto
                buttonModificarProp5.setEnabled(true);
                buttonEliminarProp5.setEnabled(true);
                //Si es el inmueble por defecto (es decir, no hay inmueble) desactivo los botones
                if(inmuebleDTO.getId().equals(-1)){
                    buttonModificarProp5.setEnabled(false);
                    buttonEliminarProp5.setEnabled(false);
                }
                break;
        }

    }
}
