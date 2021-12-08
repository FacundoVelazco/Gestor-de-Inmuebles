package Domain;

import Domain.Util.EstadoInmueble;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "datosInmueble")
    //Se utiliza nombre "Preferencias" teniendo en cuenta que esto proviene de las preferencias que puede filtrar un cliente
    private Preferencia caracteristicasInmueble;

    @Column(name = "precio")
    private Float precio;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_imagen_principal")
    private Imagen fotoPrincipal;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inmuebleAsociado", fetch = FetchType.LAZY)
    private List<Imagen> fotosInmueble = new ArrayList<>();
    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_persona")
    private Propietario propietarioInmueble;

    public Inmueble() {
        this.estado = EstadoInmueble.ALTA;
        this.propiedadDestacada = false;
        this.fechaCarga = LocalDate.now();
    }

    public Integer getId() {
        return id;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Preferencia getCaracteristicasInmueble() {
        return caracteristicasInmueble;
    }

    public void setCaracteristicasInmueble(Preferencia caracteristicasInmueble) {
        this.caracteristicasInmueble = caracteristicasInmueble;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Propietario getPropietarioInmueble() {
        return propietarioInmueble;
    }

    public void setPropietarioInmueble(Propietario propietarioInmueble) {
        this.propietarioInmueble = propietarioInmueble;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
