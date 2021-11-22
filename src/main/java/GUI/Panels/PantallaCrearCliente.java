package GUI.Panels;

import DAO.Util.ClienteDTO;
import DAO.Util.PreferenciaDTO;
import Domain.Localidad;
import Domain.Util.TipoInmueble;
import GUI.AutoCompletion;
import Services.GestorClientes;
import Services.GestorGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

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

    private static final int CHECK_COL = 1;

    //TODO Datos de ejemplo
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

    public PantallaCrearCliente() {

        GestorClientes gestorClientes = new GestorClientes();

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
        for(TipoInmueble tipo : TipoInmueble.values()){
            comboBoxTipo.addItem(tipo);
        }

        //init de combo box localidades
        comboBoxLocalidad.addItem("Santa Fe");

        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
        buttonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDTO clienteDTO = collectDataCliente();
                PreferenciaDTO preferenciaDTO = collectDataPreferencias();
                clienteDTO.setPreferencias(preferenciaDTO);

                gestorClientes.guardarCliente(clienteDTO);
                GestorGUI.pop();
            }
        });
    }

    private PreferenciaDTO collectDataPreferencias() {
    PreferenciaDTO preferencias = new PreferenciaDTO();
    preferencias.setTipoInmueble((TipoInmueble) comboBoxTipo.getSelectedItem());
    preferencias.setLocalidad(comboBoxLocalidad.getSelectedItem().toString());
    preferencias.setMontoDisponible(Float.parseFloat(formattedTextFieldMonto.getText()));
    preferencias.setBarrio(labelNombreBarrio.getText());

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
        cliente.setPassword(passwordFieldContrasenia.getPassword().toString());
        cliente.setNombre(textFieldNombre.getText());
        cliente.setApellido(textFieldApellido.getText());
        return cliente;

    }

    private void validarCampos(){

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
