package Domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "barrio")
public class Barrio {
    @Id
    @Column(name = "id_barrio")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "barrio",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private ArrayList<Direccion> direcciones;
}
