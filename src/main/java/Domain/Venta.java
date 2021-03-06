package Domain;
import javax.persistence.*;

@Entity
@Table(name = "venta")
@PrimaryKeyJoinColumn(name="id_venta")
public class Venta {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}


