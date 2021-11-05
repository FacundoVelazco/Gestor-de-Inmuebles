package Domain;

import Domain.Util.EstadoInmueble;
import Domain.Util.Orientacion;
import Domain.Util.TipoInmueble;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inmueble")
public class Inmueble {
    @Id
    @Column(name = "id_inmueble")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoInmueble estado;
    @Column(name = "fecha_carga")
    private LocalDate fechaCarga;
    @Column(name = "destacada")
    private Boolean propiedadDestacada;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_inmueble")
    private TipoInmueble tipoInmueble;
    @Column(name = "precio")
    private Float precio;
    @Enumerated(EnumType.STRING)
    @Column(name = "orientacion")
    private Orientacion orientacion;
    @Column(name = "longitud_frente")
    private Double longitudFrente;
    @Column(name = "longitud_fondo")
    private Double longitudFondo;
    @Column(name = "tamanio_inmueble")
    private Double tamanioInmueble;
    @Column(name = "es_horizontal")
    private Boolean esPropiedadHorizontal;
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
    @Column(name = "tiene_gas_natural")
    private Boolean tieneGasNatural;
    @Column(name = "tiene_agua_caliente")
    private Boolean tieneAguaCaliente;
    @Column(name = "tiene_telefono")
    private Boolean tieneTelefono;
    @Column(name = "tiene_lavadero")
    private Boolean tieneLavadero;
    @Column(name = "tiene_pavimento")
    private Boolean tienePavimento;

    private Imagen fotoPrincipal;
    private List<Imagen> fotosInmueble = new ArrayList<>();
    @Column(name = "observaciones")
    private String observaciones;

    private Propietario propietarioInmueble;

    public Inmueble(Propietario pI) {
        this.estado = EstadoInmueble.ALTA;
        this.provincia = "Santa Fe";
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

    public Imagen getFotoPrincipal() {
        return fotoPrincipal;
    }

    public void setFotoPrincipal(Imagen fotoPrincipal) {
        this.fotoPrincipal = fotoPrincipal;
    }

    public List<Imagen> getFotosInmueble() {
        return fotosInmueble;
    }

    public void setFotosInmueble(List<Imagen> fotosInmueble) {
        this.fotosInmueble = fotosInmueble;
    }

    public Propietario getPropietarioInmueble() {
        return propietarioInmueble;
    }

    public void setPropietarioInmueble(Propietario propietarioInmueble) {
        this.propietarioInmueble = propietarioInmueble;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
