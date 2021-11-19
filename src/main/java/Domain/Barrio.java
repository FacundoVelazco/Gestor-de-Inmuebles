package Domain;

import DAO.Util.BarrioDTO;
import DAO.Util.LocalidadDTO;
import Services.GestorLocalidades;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Barrio(){

    }
    public Barrio(BarrioDTO barrioDTO){
        this.id = barrioDTO.id;
        this.nombre = barrioDTO.nombre;
        this.localidad = (new GestorLocalidades()).getLocalidad(barrioDTO.localidadId);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
