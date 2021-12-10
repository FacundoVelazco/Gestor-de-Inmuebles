package Domain;

import Domain.Util.TipoDNI;
import Domain.Util.TipoUser;
import Domain.Util.Usuario;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "propietario")
public class Propietario implements Usuario {
    @Id
    @Column(name = "id_propietario")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    protected String username;

    @Column(name = "password")
    protected String password;

    @Column(name = "nombre")
    protected String nombre;

    @Column(name = "apellido")
    protected String apellido;

    @Column(name = "telefono")
    protected String telefono;

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

    @Override
    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public TipoUser getTipo() {
        return TipoUser.PROPIETARIO;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
