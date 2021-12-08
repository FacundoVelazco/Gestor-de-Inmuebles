package GUI.Panels;

import DAO.Util.InmuebleDTO;
import DAO.Util.LocalidadDTO;
import DAO.Util.PreferenciaDTO;
import Domain.Util.TipoInmueble;
import GUI.AutoCompletion;
import Services.GestorInmuebles;
import Services.GestorLocalidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;

public class PantallaCInmueble {
    private JPanel panelPrincipal;
    private JLabel consultaInmuebleLabel;
    private JPanel panelDerecho;
    private JPanel panelIzquierdo;
    private JPanel panelProvincia;
    private JLabel provinciaLabel;
    private JComboBox<String> provinciaCombo;
    private JPanel panelLocalidad;
    private JLabel localidadLabel;
    private JComboBox<LocalidadDTO> localidadCombo;
    private JPanel panelBarrio;
    private JPanel panelTipo;
    private JLabel barrioLabel;
    private JTextField barrioTextField;
    private JLabel tipoLabel;
    private JComboBox tipoCombo;
    private JTextField dormitoriosTextField;
    private JTextField precioMaxTextField;
    private JLabel dormitoriosLabel;
    private JLabel precioMaxLabel;
    private JButton buscarButton;
    private JPanel panelInmuebles;
    private JPanel panelBuscar;
    private PantallaMisInmuebles pantallaMisInmuebles;
    private static final String[] TIPOS_INMUEBLE = {"Local-Oficina", "Casa", "Departamento", "Terreno", "Quinta", "Galpón"};

    public PantallaCInmueble() {

        pantallaMisInmuebles = new PantallaMisInmuebles(null);

        panelInmuebles.add(pantallaMisInmuebles.getPanelPrincipal());

        AutoCompletion.enable(provinciaCombo);
        AutoCompletion.enable(localidadCombo);
        AutoCompletion.enable(tipoCombo);

        provinciaCombo.addItemListener(new ItemListenerProvincia());

        provinciaCombo.addItem("SANTA FE");

        for (String s: TIPOS_INMUEBLE){
            tipoCombo.addItem(s);
        }

        buscarButton.addActionListener(new ActionListenerBotonAceptar());

    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private class ItemListenerProvincia implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(provinciaCombo.getSelectedItem() != null){
                localidadCombo.removeAllItems();
                GestorLocalidades gestorLocalidades = new GestorLocalidades();
                List<LocalidadDTO> localidadesDTO = gestorLocalidades.listarLocalidadesDTO();
                localidadCombo.addItem(null);
                for(LocalidadDTO localidadDTO: localidadesDTO){localidadCombo.addItem(localidadDTO);}
                getPanelPrincipal().revalidate();
            }
        }
    }
    private class ActionListenerBotonAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GestorInmuebles gestorInmuebles = new GestorInmuebles();

            //TODO agregar validaciones
            PreferenciaDTO preferencias = new PreferenciaDTO();
            preferencias.setLocalidad(localidadCombo.getSelectedItem().toString());
            preferencias.setCantidadDormitorios(Integer.parseInt(dormitoriosTextField.getText()));
            preferencias.setBarrio(barrioTextField.getText());
            preferencias.setTipoInmueble(tipoCombo.getSelectedItem().toString());
            preferencias.setMontoDisponible(Float.parseFloat(precioMaxTextField.getText()));


            panelInmuebles.remove(0);
            panelInmuebles.add(new PantallaMisInmuebles(preferencias).getPanelPrincipal());
            panelInmuebles.revalidate();
        }
    }
}


