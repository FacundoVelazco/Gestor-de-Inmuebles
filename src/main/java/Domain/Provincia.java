package Domain;

import DAO.Util.LocalidadDTO;
import DAO.Util.ProvinciaDTO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provincia")
public class Provincia {
    @Id
    @Column(name = "id_provincia")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "provincia",fetch = FetchType.LAZY)
    private List<Localidad> localidades;

    public Provincia() {
    }

    public Provincia(String nombre){
        this.nombre = nombre;
    }

    public Provincia(ProvinciaDTO provinciaDTO) {
        this.id = provinciaDTO.id;
        this.nombre = provinciaDTO.nombre;
        this.localidades = new ArrayList<>();
        for(LocalidadDTO localidadDTO: provinciaDTO.localidades){
            this.localidades.add(new Localidad(localidadDTO));
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

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    @Override
    public String toString() {
        return "Provincia{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
