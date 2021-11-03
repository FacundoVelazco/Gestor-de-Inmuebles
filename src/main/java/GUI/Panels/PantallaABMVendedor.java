package GUI.Panels;

import GUI.GestorGUI;
import GUI.Pantalla;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaABMVendedor {

    private JPanel panelPrincipal;
    private JLabel titulo;
    private JTable tablaVendedores;
    private TableRowSorter sorter;
    private JButton botonEliminar;
    private JButton botonModificar;
    private JScrollPane scrollPane;
    private JPanel panelBusqueda;
    private JTextField textFieldBuscar;
    private JLabel textoBuscar;
    private JPanel panelTitulo;
    private JPanel panelControles;
    private JButton buttonLimpiar;
    private JButton buttonNuevoVendedor;

    private DataModel dataModel = new DataModel(DATA, COLUMNS);
    private static final String[] COLUMNS = {"Nombre", "Apellido","Nombre de usuario"};
    private static final Object[][] DATA = {
            {"Vendedor1", "ekisde", "v1ekisde"}, {"Agustín Ignacio", "García", "garagus_99"},
            {"Eira Micaela","Martínez","eira12"},{"Facundo Jesualdo","Velazco","elfacu"},
            {"Bruno","Agretti","bagretti"},{"Pablo","Leonarduzzi","pablisky95"},
            {"Elon","Musk","tesla"},
            {"Face","Book","meta"},};

    private class DataModel extends DefaultTableModel{
        public DataModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    }

    public PantallaABMVendedor() {

        //Configuración de la tabla
        tablaVendedores.setModel(new DataModel(DATA, COLUMNS));
        tablaVendedores.getTableHeader().setReorderingAllowed(false);
        tablaVendedores.getTableHeader().setResizingAllowed(false);
        tablaVendedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<>(dataModel);
        tablaVendedores.setRowSorter(sorter);

        buttonNuevoVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {GestorGUI.push(Pantalla.CREAR_VENDEDOR);
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog framePopUp = new JDialog(GestorGUI.getFrame());
                framePopUp.add(new PantallaModificarVendedorPopup().getPanelPrincipal());
                framePopUp.setLocationRelativeTo(null);
                framePopUp.setResizable(false);
                framePopUp.setSize(350,250);
                framePopUp.setVisible(true);

            }
        });

        textFieldBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(textFieldBuscar.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(textFieldBuscar.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(textFieldBuscar.getText());
            }

            public void search(String str) {
                tablaVendedores.clearSelection();
                botonesActivados(false);

                if (str.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
                }
            }
        });
        buttonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldBuscar.setText("");
            }
        });
        tablaVendedores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaVendedores.getSelectedRow()>-1 && e.getValueIsAdjusting()){
                    System.out.println("Vendedor seleccionado: " +
                            dataModel.getValueAt(tablaVendedores.convertRowIndexToModel(tablaVendedores.getSelectedRow()),0));
                    botonesActivados(true);
                }
            }
        });

    }

    /** Activa o desactiva los botones de Eliminar y Modificar */
    private void botonesActivados(Boolean b){
        botonEliminar.setEnabled(b);
        botonModificar.setEnabled(b);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

}
