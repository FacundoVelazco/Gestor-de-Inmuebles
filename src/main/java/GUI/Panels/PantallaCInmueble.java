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
    private JComboBox<String> localidadCombo;
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
    private JButton buttonLimpiar;
    private JLabel labelError;
    private PantallaMisInmuebles pantallaMisInmuebles;

    public PantallaCInmueble() {

        pantallaMisInmuebles = new PantallaMisInmuebles(null);

        panelInmuebles.add(pantallaMisInmuebles.getPanelPrincipal());

        AutoCompletion.enable(provinciaCombo);
        AutoCompletion.enable(localidadCombo);
        AutoCompletion.enable(tipoCombo);

        provinciaCombo.addItemListener(new ItemListenerProvincia());

        provinciaCombo.addItem("Santa Fe");

        localidadCombo.addItem("Cualquiera");
        localidadCombo.addItem("Santa Fe");
        //TODO AGREGAR LOCALIDADESn't

        tipoCombo.addItem("Cualquiera");
        for (TipoInmueble t: TipoInmueble.values()){
            tipoCombo.addItem(TipoInmueble.obtenerStringParaComboBox(t));
        }

        buscarButton.addActionListener(new ActionListenerBotonAceptar());

        buttonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                provinciaCombo.setSelectedIndex(0);
                localidadCombo.setSelectedIndex(0);
                dormitoriosTextField.setText("");
                barrioTextField.setText("");
                tipoCombo.setSelectedIndex(0);
                precioMaxTextField.setText("");
                validarCampos();
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private Boolean validarCampos(){

        if(!dormitoriosTextField.getText().isEmpty()){
            try {
                Integer.parseInt(dormitoriosTextField.getText());
            }catch (NumberFormatException nfe){
                labelError.setText("La cantidad de dormitorios es inválida");
                labelError.setVisible(true);
                return false;
            }
        }
        if(!precioMaxTextField.getText().isEmpty()){
            try {
                Float.parseFloat(precioMaxTextField.getText());
            }catch (NumberFormatException nfe){
                labelError.setText("El precio es inválido");
                labelError.setVisible(true);
                return false;
            }
        }
        if(localidadCombo.getSelectedItem()==null){
            labelError.setText("Seleccione una localidad");
            labelError.setVisible(true);
            return false;
        }
        labelError.setVisible(false);
        return true;

    }

    private class ItemListenerProvincia implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(provinciaCombo.getSelectedItem() != null){
                localidadCombo.removeAllItems();
                GestorLocalidades gestorLocalidades = new GestorLocalidades();
                List<LocalidadDTO> localidadesDTO = gestorLocalidades.listarLocalidadesDTO();
                for(LocalidadDTO localidadDTO: localidadesDTO){localidadCombo.addItem(localidadDTO.getNombre());}
                getPanelPrincipal().revalidate();
            }
        }
    }
    private class ActionListenerBotonAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(validarCampos()){

                PreferenciaDTO preferencias = new PreferenciaDTO();
                if(localidadCombo.getSelectedItem().toString().equals("Cualquiera")){
                    preferencias.setLocalidad(null);
                }else{
                    preferencias.setLocalidad(localidadCombo.getSelectedItem().toString());
                }
                if(tipoCombo.getSelectedItem().toString().equals("Cualquiera")){
                    preferencias.setTipoInmueble(null);
                }else{
                    preferencias.setTipoInmueble(tipoCombo.getSelectedItem().toString());
                }


                if(!dormitoriosTextField.getText().isEmpty()){
                    preferencias.setCantidadDormitorios(Integer.parseInt(dormitoriosTextField.getText()));
                }else{
                    preferencias.setCantidadDormitorios(null);
                }
                if(!precioMaxTextField.getText().isEmpty()){
                    preferencias.setMontoDisponible(Float.parseFloat(precioMaxTextField.getText()));
                }else {
                    preferencias.setMontoDisponible(null); //*comprar*
                }
                preferencias.setBarrio(barrioTextField.getText()); //Se le puede pasar un string vacio (y no debería filtrar por barrio)


                //Se quita el panel con inmuebles
                panelInmuebles.remove(0);
                panelInmuebles.repaint();
                panelInmuebles.revalidate();

                //Se pone un nuevo panel con inmuebles que coincidan con los filtros
                panelInmuebles.add(new PantallaMisInmuebles(preferencias).getPanelPrincipal());
                panelInmuebles.repaint();
                panelInmuebles.revalidate();

            }

        }
    }
}


