package GUI.Panels;

import DAO.Util.ClienteDTO;
import DAO.Util.PreferenciaDTO;
import Domain.Localidad;
import Domain.Util.TipoInmueble;
import GUI.AutoCompletion;
import Services.GestorClientes;
import Services.GestorGUI;
import Services.GestorLocalidades;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PantallaCrearCliente {
    private JPanel panelTitulo;
    private JPanel panelCampos1;
    private JPanel panelBotones;
    private JLabel textoTitulo;
    private JPanel panelCampos2;
    private JLabel textoUser;
    private JTextField textFieldUsername;
    private JLabel textoContrasena;
    private JPasswordField passwordFieldContrasenia;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JFormattedTextField formattedTextFieldTelefono;
    private JButton buttonCrear;
    private JButton buttonCancelar;
    private JPanel panelPrincipal;
    private JPanel panelTituloPreferencias;
    private JLabel textoIntereses;
    private JPanel panelPreferencias1;
    private JPanel panelPreferencias2;
    private JComboBox comboBoxTipo;
    private JComboBox comboBoxLocalidad;
    private JFormattedTextField formattedTextFieldMonto;
    private static String regexNumeroTelefonoValido ="[0-9]+";

    GestorClientes gestorClientes = new GestorClientes();

    //Datos para la tabla de características
    private static final int CHECK_COL = 1;
    private static final Object[][] DATA = {
            {"Cochera", Boolean.FALSE},{"Patio", Boolean.FALSE},
            {"Piscina", Boolean.FALSE},{"Agua corriente", Boolean.FALSE},
            {"Cloaca", Boolean.FALSE},{"Gas natural", Boolean.FALSE},
            {"Agua caliente", Boolean.FALSE},{"Teléfono", Boolean.FALSE},
            {"Lavadero", Boolean.FALSE},{"Pavimento", Boolean.FALSE}
    };
    private static final String[] COLUMNS = {"Característica", "Presente"};

    private DataModel dataModel = new DataModel(DATA, COLUMNS);
    private DefaultListSelectionModel selectionModel;
    private JTable tablaCaracteristicas = new JTable(dataModel);
    private JScrollPane scrollPaneCaracteristicas;
    private JTextField textFieldBarrio;
    private JLabel labelNombreBarrio;
    private JLabel labelErrorUsername;
    private JLabel labelErrorNombre;
    private JLabel labelErrorApellido;
    private JLabel labelErrorTelefono;
    private JLabel labelErrorContrasenia;

    private ActionListener actionListenerCrear;
    private ActionListener actionListenerModificar;

    //Se setea en true cuando se entra a la pantalla en modo modificar
    private Boolean flagModificando = false;

    public PantallaCrearCliente() {

        //Configuración de la tabla
        tablaCaracteristicas = new JTable(dataModel);
        scrollPaneCaracteristicas.setViewportView(tablaCaracteristicas);
        tablaCaracteristicas.setPreferredScrollableViewportSize(new Dimension(150, 175));
        tablaCaracteristicas.getColumnModel().getColumn(CHECK_COL).setMaxWidth(60);
        tablaCaracteristicas.getTableHeader().setReorderingAllowed(false);
        tablaCaracteristicas.getTableHeader().setResizingAllowed(false);
        tablaCaracteristicas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel = (DefaultListSelectionModel) tablaCaracteristicas.getSelectionModel();


        //Autocompletado de los comboboxes
        AutoCompletion.enable(comboBoxTipo);
        AutoCompletion.enable(comboBoxLocalidad);

        //Inicializado del combo box
        comboBoxTipo.addItem("Cualquiera"); //Agrego opción de cualquiera (para no pedir in tipo de inmueble en especifico)
        for(TipoInmueble tipo : TipoInmueble.values()){
            comboBoxTipo.addItem(TipoInmueble.obtenerStringParaComboBox(tipo));
        }

        //init de combo box localidades
        comboBoxLocalidad.addItem("Cualquiera");
        GestorLocalidades gestorLocalidades = new GestorLocalidades();
        for(String loc : gestorLocalidades.listarLocalidades()){
            comboBoxLocalidad.addItem(loc);
        }

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });

        //innit de los action listener
        actionListenerCrear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarUsername() & validarContrasenia() & validarNombre() & validarApellido() & validarTelefono()){
                    ClienteDTO clienteDTO = collectDataCliente();
                    PreferenciaDTO preferenciaDTO = collectDataPreferencias();
                    clienteDTO.setPreferencias(preferenciaDTO);
                    gestorClientes.guardarCliente(clienteDTO);

                    GestorGUI.pop();
                }
            }
        };

        buttonCrear.addActionListener(actionListenerCrear);

    }

    /** Se utiliza este constructor para entrar a la pantalla en
     * modo Modificar para modificar el cliente que se le pasa como parámetro */
    public PantallaCrearCliente(ClienteDTO elemento) {
        //Constructor default
        this();

        flagModificando=true;

        //Relleno de campos para modificar cliente
        textoTitulo.setText("Modificar cliente");
        textFieldUsername.setText(elemento.getUsername());
        textFieldUsername.setEnabled(false);
        textFieldNombre.setText(elemento.getNombre());
        textFieldApellido.setText(elemento.getApellido());
        formattedTextFieldTelefono.setText(elemento.getTelefono());
        passwordFieldContrasenia.setText(elemento.getPassword());

        //Relleno de campos de las preferencias
        comboBoxTipo.setSelectedItem(elemento.getPreferencias().getTipoInmueble());
        //Aqui se setearía la localidad
        if(elemento.getPreferencias().getLocalidad() == null){
            comboBoxLocalidad.setSelectedItem("Cualquiera");
        }else{
            comboBoxLocalidad.setSelectedItem(elemento.getPreferencias().getLocalidad());
        }
        textFieldBarrio.setText(elemento.getPreferencias().getBarrio());
        if(elemento.getPreferencias().getMontoDisponible()!=null) formattedTextFieldMonto.setText(elemento.getPreferencias().getMontoDisponible().toString());
        dataModel.setValueAt(elemento.getPreferencias().getTieneCochera(),0,1);
        dataModel.setValueAt(elemento.getPreferencias().getTienePatio(),1,1);
        dataModel.setValueAt(elemento.getPreferencias().getTienePiscina(),2,1);
        dataModel.setValueAt(elemento.getPreferencias().getTieneAguaCorriente(),3,1);
        dataModel.setValueAt(elemento.getPreferencias().getTieneCloacas(),4,1);
        dataModel.setValueAt(elemento.getPreferencias().getTieneGasNatural(),5,1);
        dataModel.setValueAt(elemento.getPreferencias().getTieneAguaCaliente(),6,1);
        dataModel.setValueAt(elemento.getPreferencias().getTieneTelefono(),7,1);
        dataModel.setValueAt(elemento.getPreferencias().getTieneLavadero(),8,1);
        dataModel.setValueAt(elemento.getPreferencias().getTienePavimento(),9,1);

        //Botón "crear" ahora es "modificar"
        buttonCrear.setText("Modificar");
        //Se le cambia el action listener, ahora utiliza otro metodo del gestor
        buttonCrear.removeActionListener(actionListenerCrear);
        actionListenerModificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validarUsername() & validarContrasenia() & validarNombre() & validarApellido() & validarTelefono()){
                    ClienteDTO clienteDTO = collectDataCliente();
                    PreferenciaDTO preferenciaDTO = collectDataPreferencias();
                    clienteDTO.setId(elemento.getId());
                    clienteDTO.setPreferencias(preferenciaDTO);
                    gestorClientes.guardarCliente(clienteDTO);
                    GestorGUI.pop();
                }
            }
        };
        buttonCrear.addActionListener(actionListenerModificar);
    }

    private PreferenciaDTO collectDataPreferencias() {
    PreferenciaDTO preferencias = new PreferenciaDTO();

    if(comboBoxTipo.getSelectedItem().toString().equals("Cualquiera")){
        preferencias.setTipoInmueble(null);
    }else{
        preferencias.setTipoInmueble(comboBoxTipo.getSelectedItem().toString());
    }
    if(comboBoxLocalidad.getSelectedItem().toString().equals("Cualquiera")){
        preferencias.setLocalidad(null);
    }else{
        preferencias.setLocalidad(comboBoxLocalidad.getSelectedItem().toString());
    }

    //nos fijamos que ingresen numeros
    if (formattedTextFieldMonto.getText().replaceAll("[^0-9]", "").length()>0) {
        preferencias.setMontoDisponible(Float.parseFloat(formattedTextFieldMonto.getText().replaceAll("[^0-9]", "")));
    }

    preferencias.setBarrio(textFieldBarrio.getText());
    preferencias.setTieneCochera((Boolean) dataModel.getValueAt(0,1));
    preferencias.setTienePatio((Boolean) dataModel.getValueAt(1,1));
    preferencias.setTienePiscina((Boolean) dataModel.getValueAt(2,1));
    preferencias.setTieneAguaCorriente((Boolean) dataModel.getValueAt(3,1));
    preferencias.setTieneCloacas((Boolean) dataModel.getValueAt(4,1));
    preferencias.setTieneGasNatural((Boolean) dataModel.getValueAt(5,1));
    preferencias.setTieneAguaCaliente((Boolean) dataModel.getValueAt(6,1));
    preferencias.setTieneTelefono((Boolean) dataModel.getValueAt(7,1));
    preferencias.setTieneLavadero((Boolean) dataModel.getValueAt(8,1));
    preferencias.setTienePavimento((Boolean) dataModel.getValueAt(9,1));

    return preferencias;
    }

    private ClienteDTO collectDataCliente() {

        ClienteDTO cliente = new ClienteDTO();
        cliente.setUsername(textFieldUsername.getText());
        cliente.setPassword(passwordFieldContrasenia.getText());
        cliente.setNombre(textFieldNombre.getText());
        cliente.setApellido(textFieldApellido.getText());
        cliente.setTelefono(formattedTextFieldTelefono.getText().replaceAll("[^0-9.]", ""));
        return cliente;

    }

    private void validarCampos(){

    }

    private Boolean validarUsername(){
        if(textFieldUsername.getText().length()<8 || textFieldUsername.getText().length()>25){
            labelErrorUsername.setText("Debe contener entre 8 y 25 caracteres");
            labelErrorUsername.setVisible(true);
            return false;
        }
        if (textFieldUsername.getText().contains(" ")){
            labelErrorUsername.setText("No debe contener espacios");
            labelErrorUsername.setVisible(true);
            return false;
        }
        if(!flagModificando && gestorClientes.existeCliente(textFieldUsername.getText())){
            labelErrorUsername.setText("El nombre de usuario ya existe");
            labelErrorUsername.setVisible(true);
            return false;
        }
        labelErrorUsername.setVisible(false);
        return true;
    }

    private Boolean validarContrasenia(){
        if(passwordFieldContrasenia.getText().length()<8 || passwordFieldContrasenia.getText().length()>25){
            labelErrorContrasenia.setText("Debe contener entre 8 y 25 caracteres");
            labelErrorContrasenia.setVisible(true);
            return false;
        }
        if (passwordFieldContrasenia.getText().contains(" ")){
            labelErrorContrasenia.setText("No debe contener espacios");
            labelErrorContrasenia.setVisible(true);
            return false;
        }
        labelErrorContrasenia.setVisible(false);
        return true;
    }

    private Boolean validarNombre(){
        if(textFieldNombre.getText().length()<1){
            labelErrorNombre.setText("Campo obligatorio");
            labelErrorNombre.setVisible(true);
            return false;
        }
        labelErrorNombre.setVisible(false);
        return true;
    }

    private Boolean validarApellido(){
        if(textFieldApellido.getText().length()<1){
            labelErrorApellido.setText("Campo obligatorio");
            labelErrorApellido.setVisible(true);
            return false;
        }
        labelErrorApellido.setVisible(false);
        return true;
    }

    private Boolean validarTelefono(){
        Pattern pattern = Pattern.compile(regexNumeroTelefonoValido);
        Matcher matcher = pattern.matcher(formattedTextFieldTelefono.getText());
        if(formattedTextFieldTelefono.getText().length()<1){
            labelErrorTelefono.setText("Campo obligatorio");
            labelErrorTelefono.setVisible(true);
            return false;
        }
        if(!matcher.matches()){
            labelErrorTelefono.setText("Numero de teléfono inválido");
            labelErrorTelefono.setVisible(true);
            return false;
        }
        labelErrorTelefono.setVisible(false);
        return true;
    }


    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private class DataModel extends DefaultTableModel {

        public DataModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == CHECK_COL) {
                return getValueAt(0, CHECK_COL).getClass();
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column == CHECK_COL;
        }
    }

    private class ControlPanel extends JPanel {

        public ControlPanel() {
            this.add(new JLabel("Selection:"));
            this.add(new JButton(new SelectionAction("Clear", false)));
            this.add(new JButton(new SelectionAction("Check", true)));
        }
    }

    private class SelectionAction extends AbstractAction {

        boolean value;

        public SelectionAction(String name, boolean value) {
            super(name);
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < dataModel.getRowCount(); i++) {
                if (selectionModel.isSelectedIndex(i)) {
                    dataModel.setValueAt(value, i, CHECK_COL);
                }
            }
        }
    }


}
