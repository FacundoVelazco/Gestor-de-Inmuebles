package Domain;

import Domain.Util.TipoDNI;
import Domain.Util.TipoUser;
import Domain.Util.Usuario;


import javax.persistence.*;

import java.util.ArrayList;

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
    private String dni;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "propietarioInmueble")
    private List<Inmueble> inmuebles;
    @OneToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "email")
    private String email;

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
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
