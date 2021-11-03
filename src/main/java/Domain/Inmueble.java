package Domain;

import Domain.Util.EstadoInmueble;
import Domain.Util.Orientacion;
import Domain.Util.TipoInmueble;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.List;

public class Inmueble {

    private Integer id;
    private EstadoInmueble estado;
    private LocalDate fechaCarga;
    private Boolean propiedadDestacada;
    private Direccion direccion;
    private TipoInmueble tipoInmueble;
    private Float precio;
    private Orientacion orientacion;
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
    private BufferedImage fotoPrincipal;
    private List<BufferedImage> fotosInmueble;
    private Propietario propietarioInmueble;

    public Inmueble(Propietario pI) {
        this.estado = EstadoInmueble.ALTA;
        this.propietarioInmueble = pI;
        this.propiedadDestacada = false;
        this.fechaCarga = LocalDate.now();
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoInmueble getEstado() {
        return estado;
    }

    public void setEstado(EstadoInmueble estado) {
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

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
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

    public BufferedImage getFotoPrincipal() {
        return fotoPrincipal;
    }

    public void setFotoPrincipal(BufferedImage fotoPrincipal) {
        this.fotoPrincipal = fotoPrincipal;
    }

    public List<BufferedImage> getFotosInmueble() {
        return fotosInmueble;
    }

    public void setFotosInmueble(List<BufferedImage> fotosInmueble) {
        this.fotosInmueble = fotosInmueble;
    }

    public Propietario getPropietarioInmueble() {
        return propietarioInmueble;
    }

    public void setPropietarioInmueble(Propietario propietarioInmueble) {
        this.propietarioInmueble = propietarioInmueble;
    }
}
