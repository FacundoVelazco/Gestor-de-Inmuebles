package GUI.Panels;

import Domain.Util.TipoInmueble;
import GUI.AutoCompletion;
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
    private JTextField textField1;
    private JLabel textoContrasena;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JTextField textField3;
    private JFormattedTextField formattedTextField1;
    private JButton buttonCrear;
    private JButton buttonCancelar;
    private JPanel panelPrincipal;
    private JPanel panelTituloPreferencias;
    private JLabel textoIntereses;
    private JPanel panelPreferencias1;
    private JPanel panelPreferencias2;
    private JComboBox comboBoxTipo;
    private JComboBox comboBoxLocalidad;
    private JFormattedTextField formattedTextField2;

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
                GestorGUI.pop();
            }
        });
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
