package Services;

import DAO.Util.InmuebleDTO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GestorInmuebles {

    public GestorInmuebles() {
    }

    public Integer guardarInmueble(InmuebleDTO iDTO) {

        //TODO hacerXD
        return null;
    }

    public InmuebleDTO cargarInmueble(Integer id) {

        //TODO hacerXD
        return null;
    }

    public List<InmuebleDTO> listarInmuebles(Integer idPropietario) {

        //TODO hacerXD
        return null;
    }

    public List<InmuebleDTO> listarInmuebles(Integer idPropietario, Integer inicio, Integer fin) {
        //TODO RECORDAR QUITAR INMUEBLES DE PRUEBA
        ArrayList<InmuebleDTO> lista = new ArrayList<>();

        InmuebleDTO i1 = new InmuebleDTO();
        InmuebleDTO i2 = new InmuebleDTO();
        InmuebleDTO i3 = new InmuebleDTO();
        InmuebleDTO i4 = new InmuebleDTO();
        InmuebleDTO i5 = new InmuebleDTO();
        InmuebleDTO i6 = new InmuebleDTO();

        i1 = new InmuebleDTO();
        i1.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test1.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i1.setId(123);
        i1.setLocalidad("Sauce Viejo");
        i1.setCalle("Francia");
        i1.setNumeroCalle(123);

        i2 = new InmuebleDTO();
        i2.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test2.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i2.setId(15656);
        i2.setLocalidad("Sauce Nuevo");
        i2.setCalle("Italia");
        i2.setNumeroCalle(6969);

        i3 = new InmuebleDTO();
        i3.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test3.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i3.setId(1456);
        i3.setLocalidad("Sauce adsfafd");
        i3.setCalle("asfasdfasfasf");
        i3.setNumeroCalle(9784);

        i4 = new InmuebleDTO();
        i4.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test4.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i4.setId(123456);
        i4.setLocalidad("Basta de sauces porfa");
        i4.setCalle("Random");
        i4.setNumeroCalle(13213);

        i5 = new InmuebleDTO();
        i5.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test5.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i5.setId(78997);
        i5.setLocalidad("Rincon de tu casa");
        i5.setLongitud(64556.2);
        i5.setLatitud(4633.2556465);

        i6 = new InmuebleDTO();
        i6.setFotoPrincipal(new ImageIcon(new ImageIcon("src/main/java/Materials/test2.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING)));
        i6.setId(15656);
        i6.setLocalidad("Sauce Repetido");
        i6.setCalle("aliateaas");
        i6.setNumeroCalle(4566598);

        lista.add(i1);
        lista.add(i2);
        lista.add(i3);
        lista.add(i4);
        lista.add(i5);
        lista.add(i6);
        

        return lista;
    }

}
