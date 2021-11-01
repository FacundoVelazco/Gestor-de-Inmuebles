package GUI.Panels;

import GUI.Panels.AMInmueblePanels.PanelCaracteristicas;
import GUI.Panels.AMInmueblePanels.PanelExtras;
import GUI.Panels.AMInmueblePanels.PanelFotosAndObservaciones;
import GUI.Panels.AMInmueblePanels.PanelUbicacion;
import GUI.Util.TipoPanelAMInmueble;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel panelUbicacion;
    private JPanel panelCaracteristicas;
    private JPanel panelExtras;
    private JPanel panelFotosAndObservaciones;




    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


    public PantallaAMInmueble() {
        //Definimos todos los paneles que vamos a utilizar
        panelUbicacion = new PanelUbicacion().getPanelUbicacion();
        panelCaracteristicas = new PanelCaracteristicas().getPanelCaracteristicas();
        panelExtras = new PanelExtras().getPanelExtras();
        panelFotosAndObservaciones = new PanelFotosAndObservaciones().getPanelFotosAndObservaciones();

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
        switch (panelActual){
            case UBICACION:
                panelRotativo.remove(0);
                panelRotativo.add(panelCaracteristicas);
                botonAnterior.setEnabled(true);
                break;
            case CARACTERISTICAS:
                panelRotativo.remove(0);
                panelRotativo.add(panelExtras);
                break;
            case EXTRAS:
                panelRotativo.remove(0);
                panelRotativo.add(panelFotosAndObservaciones);
                botonSiguiente.setEnabled(false);
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
                botonSiguiente.setEnabled(true);
                break;
        }


    }


}
