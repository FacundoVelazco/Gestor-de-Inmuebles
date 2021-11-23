package DAO.Util;

import Domain.Admin;
import Domain.Propietario;
import Domain.Util.TipoDNI;

import javax.persistence.*;
import java.util.List;

public class VendedorDTO {

    private Integer id;
    private Integer dni;
    private Integer nroLegajo;
    private List<PropietarioDTO> propietarios;
    private Admin admin;
    private String nombre;
    private String apellido;
    private String password;
    private String username;
    private String localidad;
    private Integer idLocalidad;
    private String provincia;
    private Integer idProvincia;
    private String calle;
    private Integer numeroDeCalle;
    private Integer idDireccion;

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

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumeroDeCalle() {
        return numeroDeCalle;
    }

    public void setNumeroDeCalle(Integer numeroDeCalle) {
        this.numeroDeCalle = numeroDeCalle;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Integer getId() {
        return id;
    }
}
