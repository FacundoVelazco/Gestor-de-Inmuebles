package Domain;

import DAO.Util.LocalidadDTO;

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
    @Column(name = "id_provincia")
    private String provincia;

    public Localidad(String nombre) {
        this.nombre = nombre;
    }

    public Localidad(LocalidadDTO localidadDTO){
        this.id = localidadDTO.id;
        this.nombre = localidadDTO.nombre;
        this.provincia = "SANTA FE";
    }
    public Integer getId() {
        return this.id;
    }

    public Localidad() {
        provincia = "SANTA FE";
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

}
