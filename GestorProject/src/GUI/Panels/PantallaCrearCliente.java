package GUI.Panels;

import GUI.GestorGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JFormattedTextField formattedTextField2;

    private static final int CHECK_COL = 1;

    //TODO Datos de ejemplo
    private static final Object[][] DATA = {
            {"Salida a la calle", Boolean.TRUE}, {"Patio trasero", Boolean.FALSE},
            {"Patio delantero", Boolean.TRUE}, {"Quincho", Boolean.FALSE},
            {"Sótano", Boolean.TRUE}, {"Ático", Boolean.FALSE},
            {"Garaje", Boolean.TRUE}, {"Piscina", Boolean.FALSE},
            {"Luz eléctrica", Boolean.TRUE}, {"Agua y cloaca", Boolean.FALSE},
            {"Piso de madera", Boolean.TRUE}, {"Piso cerámico", Boolean.FALSE},
            {"Piso alfombrado", Boolean.TRUE}, {"Piso de madera flotante", Boolean.FALSE},
            {"Tejado a dos aguas", Boolean.TRUE}, {"Tejado a 4 aguas", Boolean.FALSE},
            {"Techo de loza", Boolean.TRUE}, {"Frente amplio", Boolean.FALSE},
            {"Ladrillo visto", Boolean.TRUE}, {"Portón", Boolean.FALSE}};

    private static final String[] COLUMNS = {"Característica", "Presente"};
    private DataModel dataModel = new DataModel(DATA, COLUMNS);
    private DefaultListSelectionModel selectionModel;
    private JTable tablaCaracteristicas = new JTable(dataModel);
    private JScrollPane scrollPaneCaracteristicas;

    public PantallaCrearCliente() {

        tablaCaracteristicas = new JTable(dataModel);
        scrollPaneCaracteristicas.setViewportView(tablaCaracteristicas);
        tablaCaracteristicas.setPreferredScrollableViewportSize(new Dimension(150, 175));
        tablaCaracteristicas.getColumnModel().getColumn(CHECK_COL).setMaxWidth(60);
        tablaCaracteristicas.getTableHeader().setResizingAllowed(false);
        selectionModel = (DefaultListSelectionModel) tablaCaracteristicas.getSelectionModel();

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
