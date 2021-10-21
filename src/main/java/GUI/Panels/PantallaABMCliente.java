package GUI.Panels;

import GUI.GestorGUI;
import GUI.Pantalla;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaABMCliente {

    private JPanel panelPrincipal;
    private JLabel titulo;
    private JTable tablaClientes;
    private JButton botonEliminar;
    private JButton botonModificar;
    private JButton botonNuevoCliente;
    private JScrollPane scrollPane;
    private JPanel panelBusqueda;
    private JTextField textFieldNombre;
    private JLabel textoUsuario;
    private JLabel labelNombreApellido;
    private JTextField textFieldNombreApellido;
    private JButton buttonBuscar;
    private JPanel panelTitulo;
    private JPanel panelControles;

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

    public PantallaABMCliente() {

        //Configuración de la tabla
        tablaClientes.setModel(new DataModel(DATA, COLUMNS));
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.getTableHeader().setResizingAllowed(false);
        tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        botonNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.push(Pantalla.CREAR_CLIENTE);
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


}
