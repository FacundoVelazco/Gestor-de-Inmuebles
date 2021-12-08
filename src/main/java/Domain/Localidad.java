package Domain;

import DAO.Util.LocalidadDTO;
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
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "Barrios")
    private List<String> barrios;

    public Localidad(String nombre) {
        this.nombre = nombre;
    }

    public Localidad(LocalidadDTO localidadDTO){
        this.id = localidadDTO.id;
        this.nombre = localidadDTO.nombre;
        this.provincia = "SANTA FE";
    }


    public Localidad() {
        provincia = "SANTA FE";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public List<String> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<String> barrios) {
        this.barrios = barrios;
    }
}
