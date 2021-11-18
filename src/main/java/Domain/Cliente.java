package Domain;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name="id_persona")
public class Cliente extends Persona {
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_preferencia")
    private Preferencia preferencia;
}
