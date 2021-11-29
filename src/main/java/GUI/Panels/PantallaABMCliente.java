package GUI.Panels;

import DAO.Util.ClienteDTO;
import Services.GestorClientes;
import Services.GestorGUI;
import GUI.Util.Pantalla;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PantallaABMCliente {

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

    private DefaultTableModel dataModel = new DefaultTableModel(COLUMNS,0);
    private static final String[] COLUMNS = {"Nombre de usuario","Nombre", "Apellido"};

    public PantallaABMCliente() {

        //Configuración de la tabla
        tablaClientes.setModel(dataModel);
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.getTableHeader().setResizingAllowed(false);
        tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<>(dataModel);
        tablaClientes.setRowSorter(sorter);

        //Carga de datos en tabla
        GestorClientes gestorClientes =  new GestorClientes();
        for (ClienteDTO c : gestorClientes.listarClientes()){
            ((DefaultTableModel) tablaClientes.getModel()).insertRow(0,new Object[]{c.getUsername(),c.getNombre(),c.getApellido(),c.getId()});
        }


        botonNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.CREAR_CLIENTE);
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
                    //TODO debug sysout
                    System.out.println("Cliente seleccionado: " +
                            dataModel.getValueAt(tablaClientes.convertRowIndexToModel(tablaClientes.getSelectedRow()),0));
                    botonesActivados(true);
                }
            }
        });
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO hacer dialogo de confirmacion generico
                Integer confirmacion = JOptionPane.showConfirmDialog(new JFrame(),"¿Está seguro que desea eliminar el cliente?","Eliminar cliente",JOptionPane.YES_NO_OPTION);
                if(confirmacion==JOptionPane.YES_OPTION){
                    String username = dataModel.getValueAt(tablaClientes.convertRowIndexToModel(tablaClientes.getSelectedRow()),0).toString();
                    gestorClientes.borrarClienteByUsername(username);
                    botonesActivados(false);
                    GestorGUI.refreshCurrent(); //TODO esto es lo correcto? intenta hacer un pop de la pantalla actual cuando ya se encuentra en el tope
                }
            }
        });
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDTO cliente = gestorClientes.getClienteByUsername(
                        dataModel.getValueAt(tablaClientes.convertRowIndexToModel(tablaClientes.getSelectedRow()),0).toString());
                GestorGUI.pushModificar(Pantalla.CREAR_CLIENTE,cliente);
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
