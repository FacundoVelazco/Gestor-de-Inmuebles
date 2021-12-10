package Domain;

import DAO.Util.PropietarioDTO;
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

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numeroDeCalle")
    private String numeroDeCalle;

    @ManyToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;

    @OneToMany
    @JoinColumn(name = "id_propietarios")
    private List<PropietarioDTO> propietarios;








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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroDeCalle() {
        return numeroDeCalle;
    }

    public void setNumeroDeCalle(String numeroDeCalle) {
        this.numeroDeCalle = numeroDeCalle;
    }

    @Override
    public TipoUser getTipo() {
        return TipoUser.VENDEDOR;

    }
}
