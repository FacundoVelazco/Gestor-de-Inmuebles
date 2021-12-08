package Domain;


import javax.persistence.*;

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
    @Column(name = "latitud")
    private Double latitud;
    @Column(name = "longitud")
    private Double longitud;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "piso")
    private String piso;  //TODO tal vez usar optional
    @Column(name = "departamento")
    private String departamento;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "direccion",fetch = FetchType.EAGER)
    private Inmueble inmueble;

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


    public void setId(Integer id) {this.id = id;}

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {

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

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
}
