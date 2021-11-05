package GUI.Panels;


import GUI.Util.Pantalla;
import Services.GestorGUI;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PantallaABMPropietario {

    private JPanel panelPrincipal;
    private JLabel titulo;
    private JTable tablaClientes;
    private TableRowSorter sorter;
    private JButton botonEliminar;
    private JButton botonModificar;
    private JButton botonNuevoCliente;
    private JScrollPane scrollPane;
    private JPanel panelBusqueda;
    private JTextField textFieldBuscar;
    private JLabel textoBuscar;
    private JPanel panelTitulo;
    private JPanel panelControles;
    private JButton buttonLimpiar;
    private JTextField textFieldNombreUsuario;
    private JPasswordField passwordFieldContraseña;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;



    private DataModel dataModel = new DataModel(DATA, COLUMNS);
    private static final String[] COLUMNS = {"Nombre", "Apellido","Nombre de usuario"};
    private static final Object[][] DATA = {
            {"Pedro", "Picapiedras", "stoner123"}, {"Agustín Ignacio", "García", "garagus_99"},
            {"Eira Micaela","Martínez","eira12"},{"Facundo Jesualdo","Velazco","elfacu"},
            {"Bruno","Agretti","bagretti"},{"Pablo","Leonarduzzi","pablisky95"}};

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

    public PantallaABMPropietario() {

        //Configuración de la tabla
        tablaClientes.setModel(new DataModel(DATA, COLUMNS));
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.getTableHeader().setResizingAllowed(false);
        tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<>(dataModel);
        tablaClientes.setRowSorter(sorter);

        botonNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.CREAR_PROPIETARIO);
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
                tablaClientes.clearSelection();
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
        tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaClientes.getSelectedRow()>-1 && e.getValueIsAdjusting()){
                    System.out.println("Cliente seleccionado: " +
                            dataModel.getValueAt(tablaClientes.convertRowIndexToModel(tablaClientes.getSelectedRow()),0));
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
