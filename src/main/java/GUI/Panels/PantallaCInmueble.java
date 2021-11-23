package GUI.Panels;

import DAO.Util.BarrioDTO;
import DAO.Util.InmuebleDTO;
import DAO.Util.LocalidadDTO;
import DAO.Util.ProvinciaDTO;
import Domain.Provincia;
import Domain.Util.TipoInmueble;
import GUI.AutoCompletion;
import Services.GestorBarrio;
import Services.GestorInmuebles;
import Services.GestorLocalidades;
import Services.GestorProvincias;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class PantallaCInmueble {
    private JPanel panelPrincipal;
    private JLabel consultaInmuebleLabel;
    private JPanel panelDerecho;
    private JPanel panelIzquierdo;
    private JPanel panelProvincia;
    private JLabel provinciaLabel;
    private JComboBox<ProvinciaDTO> provinciaCombo;
    private JPanel panelLocalidad;
    private JLabel localidadLabel;
    private JComboBox<LocalidadDTO> localidadCombo;
    private JPanel panelBarrio;
    private JPanel panelTipo;
    private JLabel barrioLabel;
    private JComboBox<BarrioDTO> barrioCombo;
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
    private static final Object[][] DATA = {};



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

        provinciaCombo.addItemListener(new ItemListenerProvincia());
        localidadCombo.addItemListener(new ItemListenerLocalidad());

        GestorProvincias gestorProvincias = new GestorProvincias();
        provinciaCombo.addItem(null);
        for (ProvinciaDTO provinciaDTO: gestorProvincias.listarProvinciaDTO()){provinciaCombo.addItem(provinciaDTO);}

        tipoCombo.addItem(TipoInmueble.LOCAL_OFICINA);tipoCombo.addItem(TipoInmueble.CASA);
        tipoCombo.addItem(TipoInmueble.DEPARTAMENTO);tipoCombo.addItem(TipoInmueble.GALPON);
        tipoCombo.addItem(TipoInmueble.QUINTA);tipoCombo.addItem(TipoInmueble.TERRENO);

        buscarButton.addActionListener(new ActionListenerBotonAceptar());
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
            return false;
        }
    }
    private class ItemListenerProvincia implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(provinciaCombo.getSelectedItem() != null){
                localidadCombo.removeAllItems();
                GestorLocalidades gestorLocalidades = new GestorLocalidades();
                List<LocalidadDTO> localidadesDTO = gestorLocalidades.listarLocalidadesDTO((ProvinciaDTO) provinciaCombo.getSelectedItem());
                localidadCombo.addItem(null);
                for(LocalidadDTO localidadDTO: localidadesDTO){localidadCombo.addItem(localidadDTO);}
                getPanelPrincipal().revalidate();
            }
        }
    }
    private class ItemListenerLocalidad implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(localidadCombo.getSelectedItem() != null){
                barrioCombo.removeAllItems();
                GestorBarrio gestorBarrio = new GestorBarrio();
                List<BarrioDTO> barriosDTO = gestorBarrio.listarBarriosDTO((LocalidadDTO) localidadCombo.getSelectedItem());
                barrioCombo.addItem(null);
                for(BarrioDTO barrioDTO: barriosDTO){barrioCombo.addItem(barrioDTO);}
                getPanelPrincipal().revalidate();
            }
        }
    }
    private class ActionListenerBotonAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GestorInmuebles gestorInmuebles = new GestorInmuebles();
            List<InmuebleDTO> inmueblesDTO = gestorInmuebles.buscarInmueble((ProvinciaDTO) provinciaCombo.getSelectedItem(),(LocalidadDTO) localidadCombo.getSelectedItem(),(BarrioDTO) barrioCombo.getSelectedItem(),(TipoInmueble) tipoCombo.getSelectedItem(),dormitoriosTextField.getText(),PrecioMaxTextField.getText());
            //TODO cargar la info a la tabla
        }
    }
}


