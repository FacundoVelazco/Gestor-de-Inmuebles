package Domain;

import Domain.Util.TipoDNI;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendedor")
@PrimaryKeyJoinColumn(name="id_persona")
public class Vendedor extends Persona{
    @Column(name = "dni")
    private Integer dni;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_dni")
    private TipoDNI tipoDni;
    @Column(name = "nro_legajo")
    private Integer nroLegajo;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "vendedor")
    private List<Propietario> propietarios;
    @ManyToOne()
    @JoinColumn(name = "id_persona_admin")
    private Admin admin;

    public Vendedor(){
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public TipoDNI getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(TipoDNI tipoDni) {
        this.tipoDni = tipoDni;
    }

    public Integer getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }



}
