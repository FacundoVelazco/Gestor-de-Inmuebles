package GUI.Panels.AMInmueblePanels;

import DAO.Util.InmuebleDTO;
import GUI.AutoCompletion;
import GUI.Util.TipoPanelAMInmueble;
import Services.GestorLocalidades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUbicacion {
    private JPanel panelUbicacion;
    private JLabel tituloLabel;
    private JPanel panelIzquierdo;
    private JLabel tituloProvinciaLabel;
    private JComboBox provinciaComboBox;
    private JLabel tituloLocalidadLabel;
    private JComboBox comboBoxLocalidad;
    private JLabel tituloBarrio;
    private JTextField textFieldBarrio;
    private JCheckBox checkBoxActivador;
    private JTextField textFieldPVDireccion;
    private JTextField textFieldSVDireccion;
    private JTextField textFieldPiso;
    private JTextField textFieldDepartamento;
    private JLabel tituloActivadorLabel;
    private JLabel tituloPVDireccionLabel;
    private JLabel tituloSVDireccionLabel;
    private JLabel tituloPisoLabel;
    private JLabel errorPVDireccionLabel;
    private JLabel errorSVDireccionLabel;
    private JLabel labelDepartamento;
    private TipoPanelAMInmueble tipo;
    private InmuebleDTO inmuebleDTO;
    private String calleSeteada="";
    private String numeroSeteado="";
    private String latitudSeteada="";
    private String longitudSeteada="";

    public PanelUbicacion() {


        //Combo box de la prov
        provinciaComboBox.addItem("Santa Fe");
        provinciaComboBox.setSelectedItem("Santa Fe");

        //Rellenado del combobox con las localidades de la provincia
        AutoCompletion.enable(comboBoxLocalidad);
        GestorLocalidades gestorLocalidades = new GestorLocalidades();
        for(String loc : gestorLocalidades.listarLocalidades()){
            comboBoxLocalidad.addItem(loc);
        }
        comboBoxLocalidad.setSelectedItem("Santa Fe");

        //Creo el inmuebleDTO para el manejo de datos
        inmuebleDTO = new InmuebleDTO();

        //Seteo listener checkbox
        checkBoxActivador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                limpiarLabelErrores();
                limpiarCamposDireccion();

                if(checkBoxActivador.isSelected()){
                    tituloPVDireccionLabel.setText("Latitud:");
                    tituloSVDireccionLabel.setText("Longitud:");
                }else{
                    tituloPVDireccionLabel.setText("Calle:");
                    tituloSVDireccionLabel.setText("Número:");
                }
            }
        });


    }

    public JPanel getPanelUbicacion() {
        return panelUbicacion;
    }

    public Boolean validarDatos(){
        Boolean primerValorDireccion = true;
        Boolean segundoValorDireccion =true;
        Boolean datosValidadosCorrectamente;

        limpiarLabelErrores();

        if(checkBoxActivador.isSelected()){
            try{
                Double.parseDouble(textFieldPVDireccion.getText());
            }catch(Exception e){
                primerValorDireccion = false;
                errorPVDireccionLabel.setText("Inserte un valor de latitud válido");
            }
            try{
                Double.parseDouble(textFieldSVDireccion.getText());
            }catch(Exception e){
                segundoValorDireccion = false;
                errorSVDireccionLabel.setText("Inserte un valor de longitud válido");
            }
        }else{
            primerValorDireccion = !textFieldPVDireccion.getText().equals("");

            if(!primerValorDireccion){
                errorPVDireccionLabel.setText("Este campo es obligatorio");
            }

            try{
                if(Integer.parseInt(textFieldSVDireccion.getText()) <= 0){
                    throw new Exception();
                }
            }catch(Exception e){
                segundoValorDireccion = false;
                errorSVDireccionLabel.setText("Inserte un valor de número válido");
            }
        }

        datosValidadosCorrectamente = primerValorDireccion && segundoValorDireccion;

        return datosValidadosCorrectamente;
    }

    private void limpiarLabelErrores(){
        errorPVDireccionLabel.setText(" ");
        errorSVDireccionLabel.setText(" ");
    }

    private void limpiarCamposDireccion(){

        if(checkBoxActivador.isSelected()){
            calleSeteada = textFieldPVDireccion.getText();
            numeroSeteado = textFieldSVDireccion.getText();

            textFieldPVDireccion.setText(latitudSeteada);
            textFieldSVDireccion.setText(longitudSeteada);

        }else{
            latitudSeteada = textFieldPVDireccion.getText();
            longitudSeteada = textFieldSVDireccion.getText();

            textFieldPVDireccion.setText(calleSeteada);
            textFieldSVDireccion.setText(numeroSeteado);
        }


    }

    //Solo ingreso al obtener datos si previamente valide los mismos
    public InmuebleDTO obtenerDatos() {

        inmuebleDTO.setProvincia("Santa Fe");
        inmuebleDTO.setLocalidad(comboBoxLocalidad.getSelectedItem().toString());

        String barrio = textFieldBarrio.getText();
        String pvDireccion = textFieldPVDireccion.getText();
        String svDireccion = textFieldSVDireccion.getText();
        String piso = textFieldPiso.getText();
        String departamento = textFieldDepartamento.getText();

        if(!barrio.equals("")){
            inmuebleDTO.setBarrio(barrio);
        }

        if(!piso.equals("")){
            inmuebleDTO.setPiso(piso);
        }

        if(!piso.equals("")){
            inmuebleDTO.setDepartamento(departamento);
        }

        if(checkBoxActivador.isSelected()){
            inmuebleDTO.setLatitud(Double.parseDouble(pvDireccion));
            inmuebleDTO.setLongitud(Double.parseDouble(svDireccion));
        }else{
            inmuebleDTO.setCalle(pvDireccion);
            inmuebleDTO.setNumeroCalle(Integer.parseInt(svDireccion));
        }

        return inmuebleDTO;
    }

    public void setDatos(InmuebleDTO idto) {
        comboBoxLocalidad.setSelectedItem(idto.getLocalidad());
        textFieldBarrio.setText(idto.getBarrio());
        if(idto.getLatitud() == null){
            textFieldPVDireccion.setText(idto.getCalle());
            textFieldSVDireccion.setText(idto.getNumeroCalle().toString());
        }else{
            textFieldPVDireccion.setText(idto.getLatitud().toString());
            textFieldSVDireccion.setText(idto.getLongitud().toString());
            tituloPVDireccionLabel.setText("Latitud:");
            tituloSVDireccionLabel.setText("Longitud:");
            checkBoxActivador.setSelected(true);
        }
        textFieldPiso.setText(idto.getPiso());
        textFieldDepartamento.setText(idto.getDepartamento());
    }





}
