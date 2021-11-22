package Domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "localidad")
public class Localidad {
    @Id
    @Column(name = "id_localidad")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;
    @Column(name = "barrio")
    private String barrio;

}
