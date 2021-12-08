package Domain;

import Domain.Util.TipoDNI;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietario")
@PrimaryKeyJoinColumn(name="id_persona")
public class Propietario extends Persona{

    @Id
    @Column(name = "id_propietario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_dni")
    private TipoDNI tipoDNI;
    @Column(name = "dni")
    private String Dni;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "propietarioInmueble")
    private List<Inmueble> inmuebles;
    @OneToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "email")
    private String email;
    @ManyToOne()
    @JoinColumn(name = "id_persona_vendedor")
    private Vendedor vendedor;

    public String getProvincia() {
        return provincia;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public Propietario(){
            this.inmuebles = new ArrayList<Inmueble>();
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

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }


    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
