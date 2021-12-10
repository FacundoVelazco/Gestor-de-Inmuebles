package Domain;

import Domain.Util.TipoUser;
import Domain.Util.Usuario;
import javax.persistence.*;

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

    @Column(name = "nro_legajo")
    private Integer nroLegajo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Override
    public String getUsername() {
        return username;
    }

    public Integer getDni() {
        return dni;
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

    @Override
    public TipoUser getTipo() {
        return TipoUser.VENDEDOR;
    }
}
