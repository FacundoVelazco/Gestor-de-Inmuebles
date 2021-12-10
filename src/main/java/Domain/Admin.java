package Domain;

import Domain.Util.TipoUser;
import Domain.Util.Usuario;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin implements Usuario {
    @Id
    @Column(name = "id_admin")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    protected String username;

    @Column(name = "password")
    protected String password; //TODO implementar

    @Column(name = "nombre")
    protected String nombre;

    @Column(name = "apellido")
    protected String apellido;

    @Column(name = "telefono")
    protected String telefono;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "admin")
//    private List<Vendedor> vendedores;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public TipoUser getTipo() {
        return TipoUser.ADMIN;
    }
}
