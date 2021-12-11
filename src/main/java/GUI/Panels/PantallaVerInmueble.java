package GUI.Panels;

import DAO.Util.ClienteDTO;
import DAO.Util.InmuebleDTO;
import Domain.Cliente;
import GUI.Panels.AMInmueblePanels.PanelImagen;
import Services.GestorClientes;
import Services.GestorGUI;
import Services.GestorUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PantallaVerInmueble{
    private JPanel panelPrincipal;
    private JLabel tituloLabel;
    private JPanel panelTitulo;
    private JPanel panelFotos;
    private JPanel panelInferior;
    private JPanel panelDatosInmueble;
    private JPanel panelVisualizadorImagenes;
    private JLabel tituloDatosInmuebleLabel;
    private JButton buttonAnteriorImagen;
    private JButton buttonSiguienteImagen;
    private JLabel tituloObservacionLabel;
    private JPanel panelBotonesImagenes;
    private JPanel panelImagen;
    private JLabel observacionesLabel;
    private JLabel codigoLabel;
    private JLabel estadoLabel;
    private JLabel fechaDeCargaLabel;
    private JLabel provinciaLabel;
    private JLabel localidadLabel;
    private JLabel pvDireccionLabel;
    private JLabel svDireccionLabel;
    private JLabel pisoLabel;
    private JLabel departamentoLabel;
    private JLabel barrioLabel;
    private JLabel tipoLabel;
    private JLabel precioReservaLabel;
    private JLabel precioVentaLabel;
    private JLabel orientacionLabel;
    private JLabel longFrenteLabel;
    private JLabel longFondoLabel;
    private JLabel superficieLabel;
    private JLabel propHorizontalLabel;
    private JLabel antigueldadLabel;
    private JPanel datosIzqPanel;
    private JPanel datosDerPanel;
    private JLabel dormitoriosLabel;
    private JLabel baniosLabel;
    private JLabel garageLabel;
    private JLabel patioLabel;
    private JLabel piscinaLabel;
    private JLabel aguaCorrienteLabel;
    private JLabel cloacasLabel;
    private JLabel gasNaturalLabel;
    private JLabel aguaCalienteLabel;
    private JLabel telefonoLabel;
    private JLabel lavaderoLabel;
    private JLabel pavimentoLabel;
    private JPanel panelBotonesAccionamiento;
    private JButton volverButton;
    private JButton reservaButton;
    private JButton ventaButton;
    private JLabel imagenLabel;
    private PanelImagen panelImagenExternoClase;
    private JPanel panelImagenExterno;
    private List<ImageIcon> fotosSeleccionadas;
    private Integer imagenSeleccionada;
    private ImageIcon imagenPorDefecto;

    public PantallaVerInmueble(InmuebleDTO idto) {

        //Seteo el cliente logueado para luego crear el dto Nota: tal vez esto delega demasiada responsabilidad a la GUI, no deberia conocer las clases de dominio
        Cliente cliente = (Cliente) GestorUsuarios.getUsuarioLogueado();
        GestorClientes gestorClientes = new GestorClientes();
        ClienteDTO clienteDTO = gestorClientes.getClienteByUsername(cliente.getUsername());

        //Creamos el panel externo que va a mostrar nuestras imagenes
        panelImagenExternoClase = new PanelImagen();
        //Seteamos imagen por defecto
        imagenPorDefecto = panelImagenExternoClase.obtenerImagen("src/main/java/Materials/casitadefault.png");
        panelImagenExternoClase.setImagenVisible(imagenPorDefecto);
        panelImagenExterno = panelImagenExternoClase.getPanelPrincipal();

        //Creo la lista donde se van a guardar todas las fotos seleccionadas, la primera siempre es la de portada
        fotosSeleccionadas = new ArrayList<>();

        panelImagen.add(panelImagenExterno);

        setDatos(idto);

        buttonSiguienteImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagenSeleccionada++;
                panelImagenExternoClase.setImagenVisible(fotosSeleccionadas.get(imagenSeleccionada));
                manejoBotones();
            }
        });

        buttonAnteriorImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagenSeleccionada--;
                panelImagenExternoClase.setImagenVisible(fotosSeleccionadas.get(imagenSeleccionada));
                manejoBotones();
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.popModificar(idto.getPreferenciasClienteDTO());
            }
        });


        reservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GestorGUI.disableFramePrincipal();
                GestorGUI.popUpReserva(clienteDTO,idto);

            }
        });
        ventaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GestorGUI.disableFramePrincipal();
                GestorGUI.popUpCompra(clienteDTO,idto);

            }
        });
    }


    private void manejoBotones() {
        //Si es la imagen por defecto, todos los botones deshabilitados
        if(imagenSeleccionada == -1){
            buttonAnteriorImagen.setEnabled(false);
            buttonSiguienteImagen.setEnabled(false);
        } else {
            //Si no es la imagen por defecto, habilito todos
            buttonAnteriorImagen.setEnabled(true);
            buttonSiguienteImagen.setEnabled(true);
            //Pero si es la primera, el de anterior no se activa
            if(imagenSeleccionada == 0) {
                buttonAnteriorImagen.setEnabled(false);
            }
            //Pero si es la ultima, el de siguiente no se activa
            if(imagenSeleccionada == fotosSeleccionadas.size()-1){
                buttonSiguienteImagen.setEnabled(false);
            }
        }
    }



    public void setDatos(InmuebleDTO idto) {


        fotosSeleccionadas.add(idto.getFotoPrincipal());

        fotosSeleccionadas.addAll(idto.getFotosInmueble());

        imagenSeleccionada = 0;

        codigoLabel.setText(codigoLabel.getText()+ idto.getId());
        estadoLabel.setText(estadoLabel.getText() + idto.getEstado());
        fechaDeCargaLabel.setText(fechaDeCargaLabel.getText() + idto.getFechaCarga());
        localidadLabel.setText(localidadLabel.getText() + idto.getLocalidad());

        if(idto.getBarrio() == null){
            barrioLabel.setText(barrioLabel.getText() + " No determinado");
        }else{
            barrioLabel.setText(barrioLabel.getText() + idto.getBarrio());
        }

        if(idto.getLatitud() == null){
            pvDireccionLabel.setText(pvDireccionLabel.getText() + idto.getCalle());
            svDireccionLabel.setText(svDireccionLabel.getText() + idto.getNumeroCalle());
        }else{
            pvDireccionLabel.setText("Latitud: " + idto.getLatitud());
            svDireccionLabel.setText("Longitud: " + idto.getLongitud());
        }

        if(idto.getPiso() == null){
            pisoLabel.setText(pisoLabel.getText() + " N/A");
        }else{
            pisoLabel.setText(pisoLabel.getText() + idto.getPiso());
        }

        if(idto.getDepartamento() == null){
            departamentoLabel.setText(departamentoLabel.getText() + " N/A");
        }else{
            departamentoLabel.setText(departamentoLabel.getText() + idto.getDepartamento());
        }

        tipoLabel.setText(tipoLabel.getText() + idto.getTipoInmueble());
        orientacionLabel.setText(orientacionLabel.getText() + idto.getOrientacion());
        longFrenteLabel.setText(longFrenteLabel.getText() + idto.getLongitudFrente());
        longFondoLabel.setText(longFondoLabel.getText() + idto.getLongitudFondo());
        superficieLabel.setText(superficieLabel.getText() + idto.getTamanioInmueble());
        antigueldadLabel.setText(antigueldadLabel.getText() + idto.getAntiguedad());
        dormitoriosLabel.setText(dormitoriosLabel.getText() + idto.getAntiguedad());
        baniosLabel.setText(baniosLabel.getText() + idto.getCantidadBanios());

        if(idto.getEsPropiedadHorizontal()){
            propHorizontalLabel.setText(propHorizontalLabel.getText()+ " Si");
        }else{
            propHorizontalLabel.setText(propHorizontalLabel.getText()+ " No");
        }

        if(idto.getTieneAguaCorriente()){
            aguaCorrienteLabel.setText(aguaCorrienteLabel.getText()+ " Si");
        }else{
            aguaCorrienteLabel.setText(aguaCorrienteLabel.getText()+ " No");
        }

        if(idto.getTienePatio()){
            patioLabel.setText(patioLabel.getText()+ " Si");
        }else{
            patioLabel.setText(patioLabel.getText()+ " No");
        }

        if(idto.getTieneCochera()){
            garageLabel.setText(garageLabel.getText()+ " Si");
        }else{
            garageLabel.setText(garageLabel.getText()+ " No");
        }

        if(idto.getTieneGasNatural()){
            gasNaturalLabel.setText(gasNaturalLabel.getText()+ " Si");
        }else{
            gasNaturalLabel.setText(gasNaturalLabel.getText()+ " No");
        }

        if(idto.getTieneAguaCaliente()){
            aguaCalienteLabel.setText(aguaCalienteLabel.getText()+ " Si");
        }else{
            aguaCalienteLabel.setText(aguaCalienteLabel.getText()+ " No");
        }

        if(idto.getTienePiscina()){
            piscinaLabel.setText(piscinaLabel.getText()+ " Si");
        }else{
            piscinaLabel.setText(piscinaLabel.getText()+ " No");
        }

        if(idto.getTieneTelefono()){
            telefonoLabel.setText(telefonoLabel.getText()+ " Si");
        }else{
            telefonoLabel.setText(telefonoLabel.getText()+ " No");
        }


        if(idto.getTieneCloacas()){
            cloacasLabel.setText(cloacasLabel.getText()+ " Si");
        }else{
            cloacasLabel.setText(cloacasLabel.getText()+ " No");
        }


        if(idto.getTieneLavadero()){
            lavaderoLabel.setText(lavaderoLabel.getText()+ " Si");
        }else{
            lavaderoLabel.setText(lavaderoLabel.getText()+ " No");
        }

        if(idto.getTienePavimento()){
            pavimentoLabel.setText(pavimentoLabel.getText()+ " Si");
        }else{
            pavimentoLabel.setText(pavimentoLabel.getText()+ " No");
        }

        if(idto.getObservaciones() != null){
            observacionesLabel.setText(idto.getObservaciones());
        }

        precioReservaLabel.setText(precioReservaLabel.getText() + " $ " + idto.getPrecioReserva() + " (día)");
        precioVentaLabel.setText(precioVentaLabel.getText() + " $ " + idto.getPrecio());

        //Habilito o deshabilito los botones según corresponda
        manejoBotones();
        panelImagenExternoClase.setImagenVisible(fotosSeleccionadas.get(0));

        //Deshabilito los botones si esta comprado o reservado
        if(idto.getEstado().equals("RESERVADO") || idto.getEstado().equals("BAJA") || idto.getEstado().equals("VENDIDO")){
            reservaButton.setEnabled(false);
            ventaButton.setEnabled(false);
        }
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
