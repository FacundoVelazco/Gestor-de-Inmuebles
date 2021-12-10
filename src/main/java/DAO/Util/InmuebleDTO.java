package DAO.Util;

import Domain.Inmueble;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class InmuebleDTO {


    private Integer id;
    private String estado;
    private LocalDate fechaCarga;
    private Boolean propiedadDestacada;
    private String provincia;
    private String localidad;
    private String calle;
    private Integer numeroCalle;
    private Double longitud;
    private Double latitud;
    private String piso;
    private String departamento;
    private String barrio;
    private String tipoInmueble;
    private Float precio;
    private Float precioReserva;
    private String orientacion;
    private Double longitudFrente;
    private Double longitudFondo;
    private Double tamanioInmueble;
    private Boolean esPropiedadHorizontal;
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
    private ImageIcon fotoPrincipal;
    private String nombreArchivoFotoPrincipal;
    private List<ImageIcon> fotosInmueble;
    private List<String> nombresArchivosFotos;
    private String observaciones;
    private Long propietarioInmuebleID;

    public InmuebleDTO(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(LocalDate fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Boolean getPropiedadDestacada() {
        return propiedadDestacada;
    }

    public void setPropiedadDestacada(Boolean propiedadDestacada) {
        this.propiedadDestacada = propiedadDestacada;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(Integer numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
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

    public Boolean getEsPropiedadHorizontal() {
        return esPropiedadHorizontal;
    }

    public void setEsPropiedadHorizontal(Boolean esPropiedadHorizontal) {
        this.esPropiedadHorizontal = esPropiedadHorizontal;
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

    public ImageIcon getFotoPrincipal() {
        return fotoPrincipal;
    }

    public void setFotoPrincipal(ImageIcon fotoPrincipal) {
        this.fotoPrincipal = fotoPrincipal;
    }

    public String getNombreArchivoFotoPrincipal() {
        return nombreArchivoFotoPrincipal;
    }

    public void setNombreArchivoFotoPrincipal(String nombreArchivoFotoPrincipal) {
        this.nombreArchivoFotoPrincipal = nombreArchivoFotoPrincipal;
    }

    public List<ImageIcon> getFotosInmueble() {
        return fotosInmueble;
    }

    public void setFotosInmueble(List<ImageIcon> fotosInmueble) {
        this.fotosInmueble = fotosInmueble;
    }

    public List<String> getNombresArchivosFotos() {
        return nombresArchivosFotos;
    }

    public void setNombresArchivosFotos(List<String> nombresArchivosFotos) {
        this.nombresArchivosFotos = nombresArchivosFotos;
    }

    public Long getPropietarioInmuebleID() {
        return propietarioInmuebleID;
    }

    public void setPropietarioInmuebleID(Long propietarioInmuebleID) {
        this.propietarioInmuebleID = propietarioInmuebleID;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setPrecioReserva(Float precioReserva) {
        this.precioReserva = precioReserva;

    }

    public Float getPrecioReserva() {
        return precioReserva;
    }

}
