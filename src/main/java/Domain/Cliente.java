package Domain;


import Domain.Util.TipoUser;
import Domain.Util.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente implements Usuario {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    @Column(name = "username")
    protected String username;

    @Column(name = "password")
    protected String password; //TODO implementar hash

    @Column(name = "nombre")
    protected String nombre;

    @Column(name = "apellido")
    protected String apellido;

    @Column(name = "telefono")
    protected String telefono;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_preferencia")
    private Preferencia preferencia;

    @Override
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


    public Integer getId() {
        return id;
    }

    @Override
    public TipoUser getTipo() {
        return TipoUser.CLIENTE;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }
}
