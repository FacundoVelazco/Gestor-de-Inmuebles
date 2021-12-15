package GUI.Panels.AMInmueblePanels;

import DAO.Util.InmuebleDTO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PanelFotosAndObservaciones{
    private JPanel panelFotosAndObservaciones;
    private JLabel tituloLabel;
    private JPanel panelTitulo;
    private JPanel panelFotos;
    private JPanel panelObservaciones;
    private JPanel panelBotones;
    private JPanel panelVisualizadorImagenes;
    private JButton buttonAgregarFotos;
    private JLabel tituloFotosLabel;
    private JButton buttonAnteriorImagen;
    private JButton buttonEliminarImagen;
    private JButton buttonSiguienteImagen;
    private JLabel tituloObservacionLabel;
    private JTextArea textAreaObservaciones;
    private JPanel panelBotonesImagenes;
    private JPanel panelImagen;
    private JCheckBox checkBoxFotoPortada;
    private JLabel archivosAbiertosLabel;
    private JLabel errorImagenLabel;
    private JLabel imagenLabel;
    private PanelImagen panelImagenExternoClase;
    private JPanel panelImagenExterno;
    private JFileChooser selectorDeArchivosFotos;
    private List<ImageIcon> fotosSeleccionadas;
    private List<String> nombresArchivosFotos;
    private Integer imagenSeleccionada;
    private ImageIcon imagenPorDefecto;
    private Integer imagenSeleccionadaParaPortada;
    private InmuebleDTO inmuebleDTO;

    public PanelFotosAndObservaciones() {

        //Creo el inmuebleDTO para el manejo de datos
        inmuebleDTO = new InmuebleDTO();

        //Creamos el panel externo que va a mostrar nuestras imagenes
        panelImagenExternoClase = new PanelImagen();
        //Seteamos imagen por defecto
        imagenPorDefecto = panelImagenExternoClase.obtenerImagen(getClass().getClassLoader().getResource("casitadefault.png").getFile());
        panelImagenExternoClase.setImagenVisible(imagenPorDefecto);
        panelImagenExterno = panelImagenExternoClase.getPanelPrincipal();

        //Creamos el multiselector para las fotos, generando un filtro predeterminado con los formatos de imagen aceptados
        FileNameExtensionFilter filtro;
        filtro = new FileNameExtensionFilter(".jpg .png", "jpg","png");
        selectorDeArchivosFotos = new JFileChooser();
        selectorDeArchivosFotos.setMultiSelectionEnabled(true);
        selectorDeArchivosFotos.setFileFilter(filtro);

        //Creo la lista donde se van a guardar todas las fotos seleccionadas, la primera siempre es la de portada
        fotosSeleccionadas = new ArrayList<>();
        nombresArchivosFotos = new ArrayList<>();

        //Indico que la imagen seleccionada es la por defecto
        imagenSeleccionada = -1;
        imagenSeleccionadaParaPortada = -2;

        panelImagen.add(panelImagenExterno);

        buttonSiguienteImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarLabelErrores();
                imagenSeleccionada++;
                panelImagenExternoClase.setImagenVisible(fotosSeleccionadas.get(imagenSeleccionada));
                manejoBotones();
                actualizarLabelArchivos();
                manejoCheckBoxFotoPortada(false);
            }
        });

        buttonAnteriorImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarLabelErrores();
                imagenSeleccionada--;
                panelImagenExternoClase.setImagenVisible(fotosSeleccionadas.get(imagenSeleccionada));
                manejoBotones();
                actualizarLabelArchivos();
                manejoCheckBoxFotoPortada(false);
            }
        });

        buttonEliminarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                limpiarLabelErrores();

                int borrado;
                borrado = imagenSeleccionada;

                //Si es la única foto, entonces debo poner la imagen por defecto
                if(imagenSeleccionada == 0 && fotosSeleccionadas.size() == 1){
                    panelImagenExternoClase.setImagenVisible(imagenPorDefecto);
                    imagenSeleccionada = -1;
                    //Si es la ultima, habiendo mas de una imagen en la lista, entonces borro y me pongo en la imagen anterior
                }else if(imagenSeleccionada == fotosSeleccionadas.size() - 1){
                    imagenSeleccionada--;
                    panelImagenExternoClase.setImagenVisible(fotosSeleccionadas.get(imagenSeleccionada));
                    //Si no es ninguno de los casos anteriores, entonces me paro en la siguiente imagen
                }else{
                    panelImagenExternoClase.setImagenVisible(fotosSeleccionadas.get(imagenSeleccionada+1));
                }

                fotosSeleccionadas.remove(borrado);
                nombresArchivosFotos.remove(borrado);

                manejoBotones();
                manejoCheckBoxFotoPortada(true);
                actualizarLabelArchivos();
            }
        });

        buttonAgregarFotos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccion = selectorDeArchivosFotos.showOpenDialog(panelFotosAndObservaciones);
                limpiarLabelErrores();
                // Si el usuario presiona Seleccionar
                if(seleccion == JFileChooser.APPROVE_OPTION) {

                    // Seleccionamos los ficheros
                    File[] arrayFileFotos = selectorDeArchivosFotos.getSelectedFiles();
                    Integer contador = 0;

                    //Chequeamos que la cantidad de fotos subidas no exceda las 20 imagenes
                    if(arrayFileFotos.length + fotosSeleccionadas.size() > 20){
                        errorImagenLabel.setText("No puede ingresar más de 20 imágenes");
                    }else{
                        //Por cada file seleccionado, convierto a imagen, primero chequeando que respete el formato.
                        for(File f : arrayFileFotos){
                            String pathRegSeleccionado = f.getAbsolutePath();
                            System.out.println(pathRegSeleccionado);
                            if(f.getName().contains((CharSequence)".jpg") || f.getName().contains((CharSequence)".png")) {
                                fotosSeleccionadas.add(panelImagenExternoClase.obtenerImagen(pathRegSeleccionado));
                                nombresArchivosFotos.add(f.getName());
                                contador++;
                            }else{
                                errorImagenLabel.setText("Algunos archivos ingresados no eran imágenes");
                            }
                        }
                        //Mostramos la primer imagen subida en esta tanda
                        try{
                            Integer primerFotoSubidaEnEsteClick = fotosSeleccionadas.size() - contador;
                            panelImagenExternoClase.setImagenVisible(fotosSeleccionadas.get(primerFotoSubidaEnEsteClick));
                            imagenSeleccionada = primerFotoSubidaEnEsteClick;
                            //Habilito o deshabilito los botones según corresponda
                            manejoBotones();
                            actualizarLabelArchivos();
                            manejoCheckBoxFotoPortada(false);
                        }catch (Exception ex){
                            errorImagenLabel.setText("No se ingresó ninguna imagen");
                        }


                    }
                }
            }
        });

        checkBoxFotoPortada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                limpiarLabelErrores();

                if(checkBoxFotoPortada.isSelected()){
                    imagenSeleccionadaParaPortada = imagenSeleccionada;
                }else{
                    imagenSeleccionadaParaPortada = -2;
                }
                actualizarLabelArchivos();
            }
        });
    }


    private void manejoBotones() {
        //Si es la imagen por defecto, todos los botones deshabilitados
        if(imagenSeleccionada == -1){
            buttonAnteriorImagen.setEnabled(false);
            buttonSiguienteImagen.setEnabled(false);
            buttonEliminarImagen.setEnabled(false);
        } else {
            //Si no es la imagen por defecto, habilito todos
            buttonAnteriorImagen.setEnabled(true);
            buttonSiguienteImagen.setEnabled(true);
            buttonEliminarImagen.setEnabled(true);
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

    private void actualizarLabelArchivos(){
        String texto = "<html>";
        Integer contador = 0;
        for(String s : nombresArchivosFotos){

            if(contador == imagenSeleccionadaParaPortada){
                s = "➜" + s;
            }

            if(contador == imagenSeleccionada){
                s = "<b>"  + s + "</b>";
            }

            texto =  texto + s + "<br>";
            contador++;
        }
        texto = texto + "</html>";
        archivosAbiertosLabel.setText(texto);
}

    private void manejoCheckBoxFotoPortada(boolean isEliminar){

        if(isEliminar){
            imagenSeleccionadaParaPortada = -2;
        }

        if(imagenSeleccionada == -1){
            checkBoxFotoPortada.setEnabled(false);
        }else{
            checkBoxFotoPortada.setEnabled(true);
        }

        if(imagenSeleccionadaParaPortada == imagenSeleccionada){
            checkBoxFotoPortada.setSelected(true);
        }else{
            checkBoxFotoPortada.setSelected(false);
        }
    }

    public Boolean validarDatos(){
        Boolean datosValidadosCorrectamente = true;

        limpiarLabelErrores();

        if(imagenSeleccionada == -1){
            datosValidadosCorrectamente = false;
            errorImagenLabel.setText("Debe ingresar al menos una imagen");
        }else{
            if(imagenSeleccionadaParaPortada == -2){
                datosValidadosCorrectamente = false;
                errorImagenLabel.setText("Debe seleccionar una imagen como portada");
            }
        }
        return datosValidadosCorrectamente;
    }

    private void limpiarLabelErrores(){
        errorImagenLabel.setText(" ");
    }

    public JPanel getPanelFotosAndObservaciones() {
        return panelFotosAndObservaciones;
    }


    //Se asume la correctitud de los datos dada la validacion previa
    public InmuebleDTO obtenerDatos() {

        inmuebleDTO.setFotoPrincipal(fotosSeleccionadas.get(imagenSeleccionadaParaPortada));
        inmuebleDTO.setNombreArchivoFotoPrincipal(nombresArchivosFotos.get(imagenSeleccionadaParaPortada));

        ArrayList<ImageIcon> auxListaImagenes = new ArrayList<>();
        auxListaImagenes.addAll(fotosSeleccionadas);
        auxListaImagenes.remove(inmuebleDTO.getFotoPrincipal());
        inmuebleDTO.setFotosInmueble(auxListaImagenes);

        List<String> auxListaNombres = new ArrayList<>();
        auxListaNombres.addAll(nombresArchivosFotos);
        auxListaNombres.remove(inmuebleDTO.getNombreArchivoFotoPrincipal());
        inmuebleDTO.setNombresArchivosFotos(auxListaNombres);


        String observaciones = textAreaObservaciones.getText();

        if(!observaciones.equals("")){
            inmuebleDTO.setObservaciones(observaciones);
        }

        return inmuebleDTO;
    }

    public void setDatos(InmuebleDTO idto) {
        fotosSeleccionadas.add(idto.getFotoPrincipal());
        nombresArchivosFotos.add(idto.getNombreArchivoFotoPrincipal());

        fotosSeleccionadas.addAll(idto.getFotosInmueble());
        nombresArchivosFotos.addAll(idto.getNombresArchivosFotos());

        imagenSeleccionada = 0;
        imagenSeleccionadaParaPortada = 0;

        //Habilito o deshabilito los botones según corresponda
        manejoBotones();
        actualizarLabelArchivos();
        manejoCheckBoxFotoPortada(false);
        panelImagenExternoClase.setImagenVisible(fotosSeleccionadas.get(0));
        checkBoxFotoPortada.setSelected(true);
    }
}
