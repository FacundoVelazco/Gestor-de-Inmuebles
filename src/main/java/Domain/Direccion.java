package Domain;


import javax.persistence.*;
import java.awt.*;
@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @Column(name = "id_direccion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "calle")
    private String calle;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "ubicacion_x")
    private Integer ubicacionX;
    @Column(name = "ubicacion_y")
    private Integer ubicacionY;
    @ManyToOne
    @JoinColumn(name = "id_barrio")
    private Barrio barrio;
    @Column(name = "piso")
    private String piso;  //TODO tal vez usar optional
    @Column(name = "departamento")
    private String departamento;


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public Integer getId() {
        return id;
    }

    public Integer getUbicacionX() {
        return ubicacionX;
    }

    public void setUbicacionX(Integer ubicacionX) {
        this.ubicacionX = ubicacionX;
    }

    public Integer getUbicacionY() {
        return ubicacionY;
    }

    public void setUbicacionY(Integer ubicacionY) {
        this.ubicacionY = ubicacionY;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {

        this.barrio = barrio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
