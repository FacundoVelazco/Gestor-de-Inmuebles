package Domain;

import Domain.Util.Orientacion;
import Domain.Util.TipoInmueble;

import javax.persistence.*;

@Entity
@Table(name = "preferencia")
public class Preferencia {
    @Id
    @Column(name = "id_preferencia")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_inmueble")
    private TipoInmueble tipoInmueble;
    @Column(name = "monto_disponible")
    private Float montoDisponible;
    @Column(name = "orientacion")
    private Orientacion orientacion;
    @Column(name = "long_frente")
    private Double longitudFrente;
    @Column(name = "long_fondo")
    private Double longitudFondo;
    @Column(name = "tam_inmueble")
    private Double tamanioInmueble;
    @Column(name = "es_prop_horizontal")
    private Boolean propiedadHorizontal;
    @Column(name = "antiguedad")
    private Integer antiguedad;
    @Column(name = "cant_dormitorios")
    private Integer cantidadDormitorios;
    @Column(name = "cant_banios")
    private Integer cantidadBanios;
    @Column(name = "tiene_cochera")
    private Boolean tieneCochera;
    @Column(name = "tiene_patio")
    private Boolean tienePatio;
    @Column(name = "tiene_piscina")
    private Boolean tienePiscina;
    @Column(name = "tiene_agua_corriente")
    private Boolean tieneAguaCorriente;
    @Column(name = "tiene_cloacas")
    private Boolean tieneCloacas;
    @Column(name = "tiene_gas")
    private Boolean tieneGasNatural;
    @Column(name = "tiene_agua_caliente")
    private Boolean tieneAguaCaliente;
    @Column(name = "tiene_telefono")
    private Boolean tieneTelefono;
    @Column(name = "tiene_lavadero")
    private Boolean tieneLavadero;
    @Column(name = "tiene_pavimento")
    private Boolean tienePavimento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public Float getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(Float montoDisponible) {
        this.montoDisponible = montoDisponible;
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
}
