package GUI.Panels.AMInmueblePanels;

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
    private JCheckBox CheckBoxPropiedadHorizontal;
    private JLabel tituloAntiguedadLabel;
    private JLabel tittuloPrecioLabel;
    private JLabel errorLongFrenteLabel;
    private JLabel errorLongFondoLabel;
    private JLabel errorTamanioLabel;
    private JLabel errorAntiguedadLabel;
    private JLabel errorCantDormitoriosLabel;
    private JLabel errorCantidadBaniosLabel;
    private JLabel errorPrecioLabel;


    public PanelCaracteristicas() {
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

        datosValidadosCorrectamente = longitudesCompletadas && cantidadesCompletadas && tamanioCompletado && antiguedadCompletada && precioDeVentaCompletado;

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
    }

    private static final String[] TIPOS_INMUEBLE = {"Local-Oficina", "Casa", "Departamento", "Terreno", "Quinta", "Galpón"};
    private static final String[] ORIENTACION = {"Norte", "Sur", "Este", "Oeste", "Noreste", "Noroeste", "Sureste", "Suroeste"};

}
