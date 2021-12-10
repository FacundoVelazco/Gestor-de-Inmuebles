package GUI.Panels;


import DAO.Util.ClienteDTO;
import DAO.Util.PropietarioDTO;
import GUI.Util.Pantalla;
import Services.GestorClientes;
import Services.GestorGUI;
import Services.GestorPropietario;

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
    private JTable tablaPropietarios;
    private TableRowSorter sorter;
    private JButton botonEliminar;
    private JButton botonModificar;
    private JButton botonNuevoPropietario;
    private JScrollPane scrollPane;
    private JPanel panelBusqueda;
    private JTextField textFieldBuscar;
    private JLabel textoBuscar;
    private JPanel panelTitulo;
    private JPanel panelControles;
    private JButton buttonLimpiar;
    private JButton volverButton;
    private JTextField textFieldNombreUsuario;
    private JPasswordField passwordFieldContraseña;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;



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

    public PantallaABMPropietario() {

        //Configuración de la tabla
        tablaPropietarios.setModel(dataModel);
        tablaPropietarios.getTableHeader().setReorderingAllowed(false);
        tablaPropietarios.getTableHeader().setResizingAllowed(false);
        tablaPropietarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<>(dataModel);
        tablaPropietarios.setRowSorter(sorter);

        //Carga de datos en tabla
        GestorPropietario gestorPropietarios =  new GestorPropietario();
        for (PropietarioDTO p : gestorPropietarios.listarPropietarios()){
            ((DefaultTableModel) tablaPropietarios.getModel()).insertRow(0,new Object[]{p.getUsername(),p.getNombre(),p.getApellido(),p.getId()});
        }

        botonNuevoPropietario.addActionListener(new ActionListener() {
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
                tablaPropietarios.clearSelection();
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
        tablaPropietarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaPropietarios.getSelectedRow()>-1 && e.getValueIsAdjusting()){
                    botonesActivados(true);
                }
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GestorGUI.popUpConfirmacion("Eliminar propietario","¿Está seguro que desea eliminar el propietario?")){
                    String username = dataModel.getValueAt(tablaPropietarios.convertRowIndexToModel(tablaPropietarios.getSelectedRow()),0).toString();
                    gestorPropietarios.borrarPropietarioByUsername(username);
                    botonesActivados(false);
                    GestorGUI.refreshCurrent();
                }
            }
        });
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PropietarioDTO propietario = gestorPropietarios.getPropietarioByUsername(
                        dataModel.getValueAt(tablaPropietarios.convertRowIndexToModel(tablaPropietarios.getSelectedRow()),0).toString());
                GestorGUI.pushModificar(Pantalla.CREAR_PROPIETARIO,propietario);
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
