package Domain;

import Domain.Util.TipoDNI;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;

@Entity
@Table(name = "propietario")
@PrimaryKeyJoinColumn(name="id_persona")
public class Propietario extends Persona{

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
    @ManyToOne()
    @JoinColumn(name = "id_persona_vendedor")
    private Vendedor vendedor;

    public Propietario(Vendedor v,TipoDNI tipoDNI, String Dni, Direccion direccion, List<Inmueble> inmuebles){ // Se le tiene que pasar como parametro una lista con todos los Inmuebles?
            this.tipoDNI = tipoDNI;
            this.Dni = Dni;
            this.direccion = direccion;
            this.inmuebles = inmuebles;
            this.vendedor = v; // el Vendedor lo podria tener guardada la GUI al iniciar sesion?
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
}
