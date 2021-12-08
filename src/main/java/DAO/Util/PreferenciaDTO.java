package DAO.Util;

import Domain.Util.Orientacion;
import Domain.Util.TipoInmueble;

import javax.persistence.Column;

public class PreferenciaDTO {
    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public Float getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(Float montoDisponible) {
        this.montoDisponible = montoDisponible;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public Double getLongitudFrente() {
        return longitudFrente;
    }

    public void setLongitudFrente(Double longitudFrente) {
        this.longitudFrente = longitudFrente;
    }

    public Double getLongitudFondo() {
        return longitudFondo;
    }

    public void setLongitudFondo(Double longitudFondo) {
        this.longitudFondo = longitudFondo;
    }

    public Double getTamanioInmueble() {
        return tamanioInmueble;
    }

    public void setTamanioInmueble(Double tamanioInmueble) {
        this.tamanioInmueble = tamanioInmueble;
    }

    public Boolean getPropiedadHorizontal() {
        return propiedadHorizontal;
    }

    public void setPropiedadHorizontal(Boolean propiedadHorizontal) {
        this.propiedadHorizontal = propiedadHorizontal;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Integer getCantidadDormitorios() {
        return cantidadDormitorios;
    }

    public void setCantidadDormitorios(Integer cantidadDormitorios) {
        this.cantidadDormitorios = cantidadDormitorios;
    }

    public Integer getCantidadBanios() {
        return cantidadBanios;
    }

    public void setCantidadBanios(Integer cantidadBanios) {
        this.cantidadBanios = cantidadBanios;
    }

    public Boolean getTieneCochera() {
        return tieneCochera;
    }

    public void setTieneCochera(Boolean tieneCochera) {
        this.tieneCochera = tieneCochera;
    }

    public Boolean getTienePatio() {
        return tienePatio;
    }

    public void setTienePatio(Boolean tienePatio) {
        this.tienePatio = tienePatio;
    }

    public Boolean getTienePiscina() {
        return tienePiscina;
    }

    public void setTienePiscina(Boolean tienePiscina) {
        this.tienePiscina = tienePiscina;
    }

    public Boolean getTieneAguaCorriente() {
        return tieneAguaCorriente;
    }

    public void setTieneAguaCorriente(Boolean tieneAguaCorriente) {
        this.tieneAguaCorriente = tieneAguaCorriente;
    }

    public Boolean getTieneCloacas() {
        return tieneCloacas;
    }

    public void setTieneCloacas(Boolean tieneCloacas) {
        this.tieneCloacas = tieneCloacas;
    }

    public Boolean getTieneGasNatural() {
        return tieneGasNatural;
    }

    public void setTieneGasNatural(Boolean tieneGasNatural) {
        this.tieneGasNatural = tieneGasNatural;
    }

    public Boolean getTieneAguaCaliente() {
        return tieneAguaCaliente;
    }

    public void setTieneAguaCaliente(Boolean tieneAguaCaliente) {
        this.tieneAguaCaliente = tieneAguaCaliente;
    }

    public Boolean getTieneTelefono() {
        return tieneTelefono;
    }

    public void setTieneTelefono(Boolean tieneTelefono) {
        this.tieneTelefono = tieneTelefono;
    }

    public Boolean getTieneLavadero() {
        return tieneLavadero;
    }

    public void setTieneLavadero(Boolean tieneLavadero) {
        this.tieneLavadero = tieneLavadero;
    }

    public Boolean getTienePavimento() {
        return tienePavimento;
    }

    public void setTienePavimento(Boolean tienePavimento) {
        this.tienePavimento = tienePavimento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    private String localidad;
    private String barrio;
    private String tipoInmueble;
    private Float montoDisponible;
    private String orientacion;
    private Double longitudFrente;
    private Double longitudFondo;
    private Double tamanioInmueble;
    private Boolean propiedadHorizontal;
    private Integer antiguedad;
    private Integer cantidadDormitorios;
    private Integer cantidadBanios;
    private Boolean tieneCochera;
    private Boolean tienePatio;
    private Boolean tienePiscina;
    private Boolean tieneAguaCorriente;
    private Boolean tieneCloacas;
    private Boolean tieneGasNatural;
    private Boolean tieneAguaCaliente;
    private Boolean tieneTelefono;
    private Boolean tieneLavadero;
    private Boolean tienePavimento;

}
