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

    @Override
    public TipoUser getTipo() {
        return TipoUser.VENDEDOR;
    }
}
