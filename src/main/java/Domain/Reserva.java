package Domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @Column(name = "id_reserva")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "fecha_creacion_reserva")
    private LocalDate fechaCreacionReserva;

    @Column(name = "fecha_fin_reserva")
    private LocalDate fechaFinReserva;

    @Column(name = "monto")
    private Float monto;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inmueble")
    private Inmueble inmueble;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_persona")
    private Cliente clienteReserva;

    public Reserva(){
        this.fechaCreacionReserva=LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaCreacionReserva() {
        return fechaCreacionReserva;
    }

    public void setFechaCreacionReserva(LocalDate fechaCreacionReserva) {
        this.fechaCreacionReserva = fechaCreacionReserva;
    }

    public LocalDate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(LocalDate fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Cliente getClienteReserva() {
        return clienteReserva;
    }

    public void setClienteReserva(Cliente clienteReserva) {
        this.clienteReserva = clienteReserva;
    }
}
