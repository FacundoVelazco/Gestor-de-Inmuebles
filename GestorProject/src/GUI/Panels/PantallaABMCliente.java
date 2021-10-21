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



    public PantallaABMCliente() {

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
