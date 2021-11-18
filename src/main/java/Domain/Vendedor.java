package Domain;

import Domain.Util.TipoDNI;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendedor")
@PrimaryKeyJoinColumn(name="id_persona")
public class Vendedor extends Persona{
    @Column(name = "dni")
    private Integer dni;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_dni")
    private TipoDNI tipoDni;
    @Column(name = "nro_legajo")
    private Integer nroLegajo;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "vendedor")
    private List<Propietario> propietarios;
    @ManyToOne()
    @JoinColumn(name = "id_persona_admin")
    private Admin admin;

}
