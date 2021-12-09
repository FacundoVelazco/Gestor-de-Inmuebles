package GUI.Panels.AMInmueblePanels;

import DAO.Util.InmuebleDTO;
import GUI.AutoCompletion;

import javax.swing.*;

public class PanelCaracteristicas {
    private JPanel panelCaracteristicas;
    private JLabel tituloLabel;
    private JPanel panelTitulo;
    private JPanel panelIzquierda;
    private JPanel panelDerecha;
    private JPanel panelTipoInmueble;
    private JPanel panelOrientacion;
    private JPanel panelLongitudes;
    private JPanel panelCantidades;
    private JPanel panelTamanio;
    private JPanel panelPropiedadHorizontal;
    private JPanel panelAntiguedad;
    private JPanel panelPrecioDeVenta;
    private JComboBox comboBoxTipoInmueble;
    private JComboBox comboBoxOrientacion;
    private JTextField textFieldLongFrente;
    private JTextField textFieldLongFondo;
    private JTextField textFieldCantidadDormitorios;
    private JTextField textFieldCantidadBanios;
    private JTextField textFieldTamanio;
    private JTextField textFieldAntiguedad;
    private JTextField textFieldPrecioDeVenta;
    private JLabel tituloTipoLabel;
    private JLabel tituloOrientacionLabel;
    private JLabel tituloLongFrenteLabel;
    private JLabel tituloLongFondoLabel;
    private JLabel tituloTamanioLabel;
    private JLabel tituloPropiedadHorizontalLabel;
    private JCheckBox checkBoxPropiedadHorizontal;
    private JLabel tituloAntiguedadLabel;
    private JLabel tituloPrecioLabel;
    private JLabel errorLongFrenteLabel;
    private JLabel errorLongFondoLabel;
    private JLabel errorTamanioLabel;
    private JLabel errorAntiguedadLabel;
    private JLabel errorCantDormitoriosLabel;
    private JLabel errorCantidadBaniosLabel;
    private JLabel errorPrecioLabel;
    private JLabel precioDeReservaPorLabel;
    private JTextField textFieldPrecioReserva;
    private JLabel errorPrecioReservaLabel;
    private JPanel panelPrecioDeReserva;
    private InmuebleDTO inmuebleDTO;

    public PanelCaracteristicas() {

        //Creo el inmuebleDTO para el manejo de datos
        inmuebleDTO = new InmuebleDTO();

        //Rellenado de los combobox
        AutoCompletion.enable(comboBoxTipoInmueble);
        AutoCompletion.enable(comboBoxOrientacion);
        for(String s : TIPOS_INMUEBLE){
            comboBoxTipoInmueble.addItem(s);
        }
        comboBoxTipoInmueble.setSelectedItem("Casa");

        for(String s : ORIENTACION){
            comboBoxOrientacion.addItem(s);
        }
    }

    public JPanel getPanelCaracteristicas() {

        return panelCaracteristicas;
    }

    public Boolean validarDatos(){

        Boolean longitudesCompletadas = true;
        Boolean cantidadesCompletadas = true;
        Boolean tamanioCompletado = true;
        Boolean antiguedadCompletada = true;
        Boolean precioDeVentaCompletado = true;
        Boolean precioDeReservaCompletado = true;
        Boolean datosValidadosCorrectamente;

        limpiarLabelErrores();

        try{
            if (Float.parseFloat(textFieldLongFrente.getText()) < 0){
                    throw new Exception();
                }
            }catch(Exception e){
                longitudesCompletadas = false;
                errorLongFrenteLabel.setText("<html>Este campo debe ser un número<br>no negativo.</html>");
            }

        try{
            if (Float.parseFloat(textFieldLongFondo.getText()) < 0){
                throw new Exception();
            }
        }catch(Exception e){
            longitudesCompletadas = false;
            errorLongFondoLabel.setText("<html>Este campo debe ser un número<br>no negativo.</html>");
        }

        try{
            if (Integer.parseInt(textFieldCantidadDormitorios.getText()) < 0){
                throw new Exception();
            }
        }catch(Exception e){
            cantidadesCompletadas = false;
            errorCantDormitoriosLabel.setText("<html>Este campo debe ser un número<br>entero no negativo.</html>");
        }

        try{
            if (Integer.parseInt(textFieldCantidadBanios.getText()) < 0){
                throw new Exception();
            }
        }catch(Exception e){
            cantidadesCompletadas = false;
            errorCantidadBaniosLabel.setText("<html>Este campo debe ser un número<br>entero no negativo.</html>");
        }

        try{
            if (Float.parseFloat(textFieldTamanio.getText()) < 0){
                throw new Exception();
            }
        }catch(Exception e){
            tamanioCompletado = false;
            errorTamanioLabel.setText("<html>Este campo debe ser un número no negativo.</html>");
        }

        try{
            if (Integer.parseInt(textFieldAntiguedad.getText()) < 0){
                throw new Exception();
            }
        }catch(Exception e){
            antiguedadCompletada = false;
            errorAntiguedadLabel.setText("<html>Este campo debe ser un número entero no negativo.</html>");
        }

        try{
            if (Float.parseFloat(textFieldPrecioDeVenta.getText()) < 0){
                throw new Exception();
            }
        }catch(Exception e){
            precioDeVentaCompletado = false;
            errorPrecioLabel.setText("<html>Este campo debe ser un número no negativo.</html>");
        }

        try{
            if (Float.parseFloat(textFieldPrecioReserva.getText()) < 0){
                throw new Exception();
            }
        }catch(Exception e){
            precioDeReservaCompletado = false;
            errorPrecioReservaLabel.setText("<html>Este campo debe ser un número no negativo.</html>");
        }


        datosValidadosCorrectamente = longitudesCompletadas && cantidadesCompletadas && tamanioCompletado && antiguedadCompletada && precioDeVentaCompletado && precioDeReservaCompletado;

        return datosValidadosCorrectamente;
    }

    private void limpiarLabelErrores(){
        errorLongFondoLabel.setText("<html> <br> </html>");
        errorLongFrenteLabel.setText("<html> <br> </html>");
        errorCantDormitoriosLabel.setText("<html> <br> </html>");
        errorCantidadBaniosLabel.setText("<html> <br> </html>");
        errorTamanioLabel.setText(" ");
        errorAntiguedadLabel.setText(" ");
        errorPrecioLabel.setText(" ");
        errorPrecioReservaLabel.setText(" ");
    }

    //Se asume la correctitud de los datos ya que previamente se hace la validacion antes de utilizar este metodo
    public InmuebleDTO obtenerDatos() {

        inmuebleDTO.setTipoInmueble(comboBoxTipoInmueble.getSelectedItem().toString());
        inmuebleDTO.setOrientacion(comboBoxOrientacion.getSelectedItem().toString());

        String longFrente = textFieldLongFrente.getText();
        String longFondo = textFieldLongFondo.getText();
        String tamanio = textFieldTamanio.getText();
        String antiguedad = textFieldAntiguedad.getText();
        String cantDormitorios = textFieldCantidadDormitorios.getText();
        String cantBanios = textFieldCantidadBanios.getText();
        String precioVenta = textFieldPrecioDeVenta.getText();
        String precioReserva = textFieldPrecioReserva.getText();

        inmuebleDTO.setLongitudFrente(Double.parseDouble(longFrente));
        inmuebleDTO.setLongitudFondo(Double.parseDouble(longFondo));
        inmuebleDTO.setTamanioInmueble(Double.parseDouble(tamanio));
        inmuebleDTO.setPrecio(Float.parseFloat(precioVenta));
        inmuebleDTO.setCantidadBanios(Integer.parseInt(cantBanios));
        inmuebleDTO.setCantidadDormitorios(Integer.parseInt(cantDormitorios));
        inmuebleDTO.setAntiguedad(Integer.parseInt(antiguedad));
        inmuebleDTO.setPrecioReserva(Float.parseFloat(precioReserva));

        inmuebleDTO.setEsPropiedadHorizontal(checkBoxPropiedadHorizontal.isSelected());

        return inmuebleDTO;
    }

    private static final String[] TIPOS_INMUEBLE = {"Local-Oficina", "Casa", "Departamento", "Terreno", "Quinta", "Galpón"};
    private static final String[] ORIENTACION = {"Norte", "Sur", "Este", "Oeste", "Noreste", "Noroeste", "Sureste", "Suroeste"};


    public void setDatos(InmuebleDTO idto) {
        comboBoxTipoInmueble.setSelectedItem(idto.getTipoInmueble());
        comboBoxOrientacion.setSelectedItem(idto.getOrientacion());
        textFieldLongFrente.setText(idto.getLongitudFrente().toString());
        textFieldLongFondo.setText(idto.getLongitudFondo().toString());
        textFieldTamanio.setText(idto.getTamanioInmueble().toString());
        textFieldAntiguedad.setText(idto.getAntiguedad().toString());
        textFieldCantidadDormitorios.setText(idto.getCantidadDormitorios().toString());
        textFieldCantidadBanios.setText(idto.getCantidadBanios().toString());
        checkBoxPropiedadHorizontal.setSelected(idto.getEsPropiedadHorizontal());
        textFieldPrecioDeVenta.setText(idto.getPrecio().toString());
        textFieldPrecioReserva.setText(idto.getPrecioReserva().toString());
    }
}
