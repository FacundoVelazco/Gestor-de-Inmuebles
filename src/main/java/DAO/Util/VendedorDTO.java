package DAO.Util;

import Domain.Admin;
import Domain.Propietario;
import Domain.Util.TipoDNI;

import javax.persistence.*;
import java.util.List;

public class VendedorDTO {

    private Integer dni;
    private Integer nroLegajo;
    private List<PropietarioDTO> propietarios;
    private Admin admin;


    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public List<PropietarioDTO> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<PropietarioDTO> propietarios) {
        this.propietarios = propietarios;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
