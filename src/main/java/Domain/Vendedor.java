package Domain;

import Domain.Util.TipoUser;
import Domain.Util.Usuario;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendedor")
public class Vendedor implements Usuario {
    @Id
    @Column( name = "id_vendedor" )
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    protected String password;

    @Column(name = "dni")
    private Integer dni;

    @Column(name = "tipo_dni")
    private String tipoDni;

    @Column(name = "nro_legajo")
    private Integer nroLegajo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @OneToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;

    @OneToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;



//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "vendedor")
//    private List<Propietario> propietarios;

    @Override
    public String getUsername() {
        return username;
    }

    public Integer getDni() {
        return dni;
    }

    public String getTipoDni() {
        return tipoDni;
    }

    public Integer getNroLegajo() {
        return nroLegajo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setTipoDni(String tipoDni) {
        this.tipoDni = tipoDni;
    }

    public void setNroLegajo(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
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

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public TipoUser getTipo() {
        return TipoUser.VENDEDOR;

    }
}
