package GUI.Panels;

import DAO.Util.ClienteDTO;
import DAO.Util.VendedorDTO;
import GUI.*;
import GUI.Util.Pantalla;
import Services.GestorGUI;
import Services.GestorVendedor;


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
    private JButton volverButton;

    private DefaultTableModel dataModel = new DefaultTableModel(COLUMNS,0);
    private static final String[] COLUMNS = {"Nombre", "Apellido","Nombre de usuario"};

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
        tablaVendedores.setModel(dataModel);
        tablaVendedores.getTableHeader().setReorderingAllowed(false);
        tablaVendedores.getTableHeader().setResizingAllowed(false);
        tablaVendedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<>(dataModel);
        tablaVendedores.setRowSorter(sorter);

        // Carga de vendedores en la tabla
        GestorVendedor gestorVendedor = new GestorVendedor();
        for (VendedorDTO c : gestorVendedor.listarVendedores()){
            ((DefaultTableModel) tablaVendedores.getModel()).insertRow(0,new Object[]{c.getUsername(),c.getNombre(),c.getApellido(),c.getId()});
        }

        buttonNuevoVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.CREAR_VENDEDOR);
            }
        });

        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                    botonesActivados(true);
                }
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GestorGUI.popUpConfirmacion("Eliminar vendedor","¿Está seguro que desea eliminar el vendedor?")){
                    String username = dataModel.getValueAt(tablaVendedores.convertRowIndexToModel(tablaVendedores.getSelectedRow()),0).toString();
                    gestorVendedor.borrarVendedorByUsername(username);
                    botonesActivados(false);
                    GestorGUI.refreshCurrent();
                }
            }
        });
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendedorDTO vendedor = gestorVendedor.getVendedorByUsername(
                        dataModel.getValueAt(tablaVendedores.convertRowIndexToModel(tablaVendedores.getSelectedRow()),0).toString());
                GestorGUI.pushModificar(Pantalla.CREAR_CLIENTE,vendedor);
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
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
