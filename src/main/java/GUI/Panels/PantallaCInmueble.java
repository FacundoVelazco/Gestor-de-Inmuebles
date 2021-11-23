package GUI.Panels;

import GUI.AutoCompletion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PantallaCInmueble {
    private JPanel panelPrincipal;
    private JLabel consultaInmuebleLabel;
    private JPanel panelDerecho;
    private JPanel panelIzquierdo;
    private JPanel panelProvincia;
    private JLabel provinciaLabel;
    private JComboBox provinciaCombo;
    private JPanel panelLocalidad;
    private JLabel localidadLabel;
    private JComboBox localidadCombo;
    private JPanel panelBarrio;
    private JPanel panelTipo;
    private JLabel barrioLabel;
    private JComboBox barrioCombo;
    private JLabel tipoLabel;
    private JComboBox tipoCombo;
    private JTextField dormitoriosTextField;
    private JTextField PrecioMaxTextField;
    private JLabel dormitoriosLabel;
    private JLabel precioMaxLabel;
    private JButton buscarButton;
    private JScrollPane inmueblesScrollPane;
    private JTable inmueblesTable;
    private TableRowSorter sorter;

    private DataModel dataModel = new DataModel(DATA, COLUMNS);
    private static final String[] COLUMNS = {"Provincia", "Localidad","Barrio","Tipo", "Dormitorios", "Precio"};
    private static final Object[][] DATA = {{"Santa fe", "Capital", "Barranquitas","Dpto","4","1 millon"}};



    public PantallaCInmueble() {

        //Configuración de la tabla
        inmueblesTable.setModel(new DataModel(DATA, COLUMNS));
        inmueblesTable.getTableHeader().setReorderingAllowed(false);
        inmueblesTable.getTableHeader().setResizingAllowed(false);
        inmueblesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<>(dataModel);
        inmueblesTable.setRowSorter(sorter);

        AutoCompletion.enable(provinciaCombo);
        AutoCompletion.enable(localidadCombo);
        AutoCompletion.enable(barrioCombo);
        AutoCompletion.enable(tipoCombo);
    }

    private void createUIComponents() {

        // TODO: place custom component creation code here
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private class DataModel extends DefaultTableModel {
        public DataModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    }
}


