package Domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "provincia")
public class Provincia {
    @Id
    @Column(name = "id_provincia")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "provincia",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private ArrayList<Localidad> localidades;
}
