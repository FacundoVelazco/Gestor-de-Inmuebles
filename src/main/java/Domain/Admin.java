package Domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name="id_persona")
public class Admin extends Persona{
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "admin")
    private List<Vendedor> vendedores;
}
