package Domain;

import DAO.Util.BarrioDTO;
import DAO.Util.LocalidadDTO;
import Services.GestorProvincias;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
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
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "localidad",fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private List<Barrio> barrios;

    public Localidad() {
    }

    public Localidad(String nombre) {
        this.nombre = nombre;
    }
    public Localidad(LocalidadDTO localidadDTO){
        this.id = localidadDTO.id;
        this.nombre = localidadDTO.nombre;
        this.provincia = (new GestorProvincias().getProvincia(localidadDTO.provinciaId));
        this.barrios = new ArrayList<>();
        for(BarrioDTO barrioDTO: localidadDTO.barrios){
            this.barrios.add(new Barrio(barrioDTO));
        }
    }
    public Integer getId(){
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Barrio> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<Barrio> barrios) {
        this.barrios = barrios;
    }
}
