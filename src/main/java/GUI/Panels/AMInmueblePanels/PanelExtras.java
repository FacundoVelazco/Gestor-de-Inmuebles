package GUI.Panels.AMInmueblePanels;

import DAO.Util.InmuebleDTO;

import javax.swing.*;

public class PanelExtras {
    private JPanel panelExtras;
    private JLabel tituloLabel;
    private JPanel panelTitulo;
    private JPanel panelIzquierda;
    private JPanel panelDerecha;
    private JCheckBox checkBoxCochera;
    private JCheckBox checkBoxPatio;
    private JCheckBox checkBoxPiscina;
    private JCheckBox checkBoxAguaCorriente;
    private JCheckBox checkBoxCloacas;
    private JCheckBox checkBoxGasNatural;
    private JCheckBox checkBoxAguaCaliente;
    private JCheckBox checkBoxTelefono;
    private JCheckBox checkBoxLavadero;
    private JCheckBox checkBoxPavimento;
    private InmuebleDTO inmuebleDTO;

    public PanelExtras() {
        //Creo el inmuebleDTO para el manejo de datos
        inmuebleDTO = new InmuebleDTO();
    }

    public JPanel getPanelExtras() {
        return panelExtras;
    }


    public InmuebleDTO obtenerDatos() {

        inmuebleDTO.setTieneCochera(checkBoxCochera.isSelected());
        inmuebleDTO.setTienePatio(checkBoxPatio.isSelected());
        inmuebleDTO.setTienePiscina(checkBoxPiscina.isSelected());
        inmuebleDTO.setTieneAguaCorriente(checkBoxAguaCorriente.isSelected());
        inmuebleDTO.setTieneCloacas(checkBoxCloacas.isSelected());
        inmuebleDTO.setTieneGasNatural(checkBoxGasNatural.isSelected());
        inmuebleDTO.setTieneAguaCaliente(checkBoxAguaCaliente.isSelected());
        inmuebleDTO.setTieneTelefono(checkBoxTelefono.isSelected());
        inmuebleDTO.setTieneLavadero(checkBoxLavadero.isSelected());
        inmuebleDTO.setTienePavimento(checkBoxPavimento.isSelected());

        return inmuebleDTO;
    }

    public void setDatos(InmuebleDTO idto) {
        checkBoxCochera.setSelected(idto.getTieneCochera());
        checkBoxPatio.setSelected(idto.getTienePatio());
        checkBoxPiscina.setSelected(idto.getTienePiscina());
        checkBoxAguaCorriente.setSelected(idto.getTieneAguaCorriente());
        checkBoxCloacas.setSelected(idto.getTieneCloacas());
        checkBoxGasNatural.setSelected(idto.getTieneGasNatural());
        checkBoxAguaCaliente.setSelected(idto.getTieneAguaCaliente());
        checkBoxTelefono.setSelected(idto.getTieneAguaCaliente());
        checkBoxLavadero.setSelected(idto.getTieneLavadero());
        checkBoxPavimento.setSelected(idto.getTienePavimento());
    }
}
