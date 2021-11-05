package Domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name="id_persona")
public class Cliente extends Persona {

//    private Preferencia preferencia;
}
