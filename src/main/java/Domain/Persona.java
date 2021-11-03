package Domain;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy= InheritanceType.JOINED)
public class Persona {
    @Id
    @Column(name = "id_persona")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
