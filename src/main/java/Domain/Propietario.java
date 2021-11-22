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

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_dni")
    private TipoDNI tipoDNI;
    @Column(name = "dni")
    private String Dni;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_direccion")
    private Direccion direccion; // En nuestra GUI no tenemos tantas opciones para agregar todos los atributos que estan en la clase Direccion
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "propietarioInmueble")
    private List<Inmueble> inmuebles;
    @OneToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
    @OneToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;
    @Column(name = "email")
    private String email;

    public Provincia getProvincia() {
        return provincia;
    }

    public Localidad getLocalidad() {
        return localidad;
    }


//    @ManyToOne()
//    @JoinColumn(name = "id_persona_vendedor")     VER el tema de Vendedor -> va a tener uno asociado?
//    private Vendedor vendedor;

    public Propietario(TipoDNI tipoDNI, String Dni, Direccion direccion){
            this.tipoDNI = tipoDNI;
            this.Dni = Dni;
            this.direccion = direccion;
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
}
