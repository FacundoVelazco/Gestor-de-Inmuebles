package GUI.Panels;


import DAO.Util.ClienteDTO;
import DAO.Util.PreferenciaDTO;
import DAO.Util.VendedorDTO;
import Services.GestorClientes;
import Services.GestorGUI;
import Services.GestorVendedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PantallaCrearVendedor {
    private JPanel panelPrincipal;
    private JPanel panelTitulo;
    private JPanel panelCampos1;
    private JPanel panelCampos2;
    private JPanel panelBotones;
    private JLabel labelNombreUsuario;
    private JTextField textFieldNombreUsuario;
    private JLabel labelContraseña;
    private JPasswordField textFieldContraseña;
    private JLabel labelNombre;
    private JTextField textFieldNombre;
    private JLabel labelApellido;
    private JTextField textFieldApellido;
    private JLabel labelDNI;
    private JTextField textFieldDNI;
    private JLabel labelLegajo;
    private JTextField textFieldLegajo;
    private JButton cancelarButton;
    private JButton crearVendedorButton;
    private JLabel labelErrorUsuario;
    private JLabel labelErrorContraseña;
    private JLabel labelErrorNombre;
    private JLabel labelErrorApellido;
    private JLabel labelErrorDNI;
    private JLabel labelErrorLegajo;
    private VendedorDTO vendedorDTOModificar;

    GestorVendedor gestorVendedor = new GestorVendedor();

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public PantallaCrearVendedor(){
        vendedorDTOModificar = new VendedorDTO();

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorGUI.pop();
            }
        });
        crearVendedorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificacion()){
                    VendedorDTO vendedorDTO = collectDataVendedor();
                    gestorVendedor.guardarVendedor(vendedorDTO);
                    GestorGUI.pop();
                }
            }
        });
    }
    public PantallaCrearVendedor(VendedorDTO vendedorDTO){
        this();

        vendedorDTOModificar=vendedorDTO;

        crearVendedorButton.setText("Modificar Vendedor");
        textFieldNombreUsuario.setText(vendedorDTO.getUsername());
        textFieldNombre.setText(vendedorDTO.getNombre());
        textFieldApellido.setText(vendedorDTO.getApellido());
        textFieldDNI.setText(String.valueOf(vendedorDTO.getDni()));
        textFieldLegajo.setText(String.valueOf(vendedorDTO.getNroLegajo()));
        textFieldContraseña.setText(vendedorDTO.getPassword());

    }
    private VendedorDTO collectDataVendedor() {

        VendedorDTO vendedor = new VendedorDTO();
        vendedor.setUsername(textFieldNombreUsuario.getText());
        vendedor.setPassword(textFieldContraseña.getText());
        vendedor.setNombre(textFieldNombre.getText());
        vendedor.setApellido(textFieldApellido.getText());
        vendedor.setDni(Integer.valueOf(textFieldDNI.getText()));
        vendedor.setNroLegajo(Integer.valueOf(textFieldLegajo.getText()));

        vendedor.setId(vendedorDTOModificar.getId());
        return vendedor;

    }
    public boolean verificacion(){

        boolean bandera = true;

        if (textFieldNombreUsuario.getText().length() > 20 || textFieldNombreUsuario.getText().length() < 5){
            labelErrorUsuario.setVisible(true);
            bandera = false;
        }
        else labelErrorUsuario.setVisible(false);

        if ((textFieldContraseña.getText().length() < 6) || (textFieldContraseña.getText().length() > 25)){
            labelErrorContraseña.setVisible(true);
            bandera = false;
        }
        else labelErrorContraseña.setVisible(false);

        if (textFieldNombre.getText().length() > 30 || textFieldNombre.getText().length() < 3){
            labelErrorNombre.setVisible(true);
            bandera = false;
        }
        else labelErrorNombre.setVisible(false);

        if (textFieldApellido.getText().length() > 30 || textFieldApellido.getText().length() < 2){
            labelErrorApellido.setVisible(true);
            bandera = false;
        }
        else labelErrorApellido.setVisible(false);

        if (!(isInteger(textFieldDNI.getText())) || textFieldDNI.getText().length() < 7 || textFieldDNI.getText().length() > 9){
            labelErrorDNI.setVisible(true);
            bandera = false;
        }
        else labelErrorDNI.setVisible(false);

        if (!(isInteger(textFieldLegajo.getText())) || textFieldLegajo.getText().length() != 6){
            labelErrorLegajo.setVisible(true);
            bandera = false;
        }
        else labelErrorLegajo.setVisible(false);

        return bandera;
    }

    /*Método que retorna true si un string es un numero entero escrito como string*/
    public boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }





}
