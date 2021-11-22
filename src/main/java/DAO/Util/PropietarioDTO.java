package DAO.Util;

import Domain.Direccion;
import Domain.Inmueble;
import Domain.Util.TipoDNI;
import Domain.Vendedor;

import javax.persistence.*;
import java.util.List;

public class PropietarioDTO {


    private TipoDNI tipoDNI;
    private String Dni;
    private Direccion direccion;
    private List<InmuebleDTO> inmuebles;
    private VendedorDTO vendedor;

    public PropietarioDTO(){
    }

    public TipoDNI getTipoDNI() {
        return tipoDNI;
    }

    public void setTipoDNI(TipoDNI tipoDNI) {
        this.tipoDNI = tipoDNI;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<InmuebleDTO> getInmuebles() { return inmuebles;}

    public void setInmuebles(List<InmuebleDTO> inmuebles) {
        this.inmuebles = inmuebles;
    }

}
