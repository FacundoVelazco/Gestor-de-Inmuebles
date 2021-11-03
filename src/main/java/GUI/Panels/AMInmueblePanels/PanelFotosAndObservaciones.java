package GUI.Panels.AMInmueblePanels;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PanelFotosAndObservaciones{
    private JPanel panelFotosAndObservaciones;
    private JLabel tituloLabel;
    private JPanel panelTitulo;
    private JPanel panelFotos;
    private JPanel panelObservaciones;
    private JPanel panelBotones;
    private JPanel panelVisualizadorImagenes;
    private JLabel tituloFotoPortadaLabel;
    private JButton buttonFotoPortada;
    private JButton cargarFotosAdicionalesButton;
    private JLabel tituloFotosExtrasLabel;
    private JButton buttonAnteriorImagen;
    private JButton buttonEliminarImagen;
    private JButton buttonSiguienteImagen;
    private JLabel tituloObservacionLabel;
    private JTextArea textAreaObservaciones;
    private JPanel panelBotonesImagenes;
    private JPanel panelImagen;
    private JLabel imagenLabel;
    private PanelImagen panelImagenExternoClase;
    private JPanel panelImagenExterno;
    private JFileChooser selectorDeArchivosPortada;

    public PanelFotosAndObservaciones() {

        //Creamos el panel externo que va a mostrar nuestras imagenes
        panelImagenExternoClase = new PanelImagen();
        //Seteamos imagen por defecto
        panelImagenExternoClase.setImagen("src/main/java/Materials/test1.jpg");
        panelImagenExterno = panelImagenExternoClase.getPanelPrincipal();

        //Creamos los selectores de archivos, generando un filtro predeterminado con los formatos de imagen aceptados
        selectorDeArchivosPortada = new JFileChooser();
        FileNameExtensionFilter filtro;
        filtro = new FileNameExtensionFilter(".jpg .png", "jpg","png");
        selectorDeArchivosPortada.setFileFilter(filtro);



        panelImagen.add(panelImagenExterno);


        buttonSiguienteImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelImagenExternoClase.setImagen("src/main/java/Materials/test2.png");
            }
        });


        buttonFotoPortada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccion = selectorDeArchivosPortada.showOpenDialog(panelFotosAndObservaciones);
                // Si el usuario presiona Seleccionar
                if(seleccion == JFileChooser.APPROVE_OPTION) {
                    // Seleccionamos el fichero
                    File fotoPortada = selectorDeArchivosPortada.getSelectedFile();
                    String pathRegSeleccionado = fotoPortada.getAbsolutePath();

                    if(fotoPortada.getName().contains((CharSequence)".jpg") || fotoPortada.getName().contains((CharSequence)".png")) {
                        panelImagenExternoClase.setImagen(pathRegSeleccionado);
                    }else{
                        System.out.println("ETO NO E UNA IMAGEN");
                    }
                }
            }
        });





    }

    public JPanel getPanelFotosAndObservaciones() {
        return panelFotosAndObservaciones;
    }

}
