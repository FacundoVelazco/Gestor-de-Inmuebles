package GUI.Panels;

import DAO.Util.InmuebleDTO;
import DAO.Util.LocalidadDTO;
import Domain.Util.TipoInmueble;
import GUI.AutoCompletion;
import Services.GestorInmuebles;
import Services.GestorLocalidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    private JTextField PrecioMaxTextField;
    private JLabel dormitoriosLabel;
    private JLabel precioMaxLabel;
    private JButton buscarButton;
    private JPanel panelInmuebles;
    private PantallaMisInmuebles pantallaMisInmuebles;

    public PantallaCInmueble() {

        pantallaMisInmuebles = new PantallaMisInmuebles(null,"",null,"","");

        panelInmuebles.add(pantallaMisInmuebles.getPanelPrincipal());

        AutoCompletion.enable(provinciaCombo);
        AutoCompletion.enable(localidadCombo);
        AutoCompletion.enable(tipoCombo);

        provinciaCombo.addItemListener(new ItemListenerProvincia());

        provinciaCombo.addItem("SANTA FE");

        tipoCombo.addItem(TipoInmueble.LOCAL_OFICINA);tipoCombo.addItem(TipoInmueble.CASA);
        tipoCombo.addItem(TipoInmueble.DEPARTAMENTO);tipoCombo.addItem(TipoInmueble.GALPON);
        tipoCombo.addItem(TipoInmueble.QUINTA);tipoCombo.addItem(TipoInmueble.TERRENO);

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
            List<InmuebleDTO> inmueblesDTO = gestorInmuebles.buscarInmueble((LocalidadDTO) localidadCombo.getSelectedItem(), barrioTextField.getText() ,(TipoInmueble) tipoCombo.getSelectedItem(),dormitoriosTextField.getText(),PrecioMaxTextField.getText());

            //TODO cargar la info a la tabla
        }
    }
}


