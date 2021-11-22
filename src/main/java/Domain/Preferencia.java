package Domain;

import Domain.Util.Orientacion;
import Domain.Util.TipoInmueble;

import javax.persistence.*;

@Entity
@Table(name = "preferencia")
public class Preferencia {
    @Id
    @Column(name = "id_preferencia")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_inmueble")
    private TipoInmueble tipoInmueble;
    @Column(name = "monto_disponible")
    private Float montoDisponible;
    @Column(name = "orientacion")
    private Orientacion orientacion;
    @Column(name = "long_frente")
    private Double longitudFrente;
    @Column(name = "long_fondo")
    private Double longitudFondo;
    @Column(name = "tam_inmueble")
    private Double tamanioInmueble;
    @Column(name = "es_prop_horizontal")
    private Boolean propiedadHorizontal;
    @Column(name = "antiguedad")
    private Integer antiguedad;
    @Column(name = "cant_dormitorios")
    private Integer cantidadDormitorios;
    @Column(name = "cant_banios")
    private Integer cantidadBanios;
    @Column(name = "tiene_cochera")
    private Boolean tieneCochera;
    @Column(name = "tiene_patio")
    private Boolean tienePatio;
    @Column(name = "tiene_piscina")
    private Boolean tienePiscina;
    @Column(name = "tiene_agua_corriente")
    private Boolean tieneAguaCorriente;
    @Column(name = "tiene_cloacas")
    private Boolean tieneCloacas;
    @Column(name = "tiene_gas")
    private Boolean tieneGasNatural;
    @Column(name = "tiene_agua_caliente")
    private Boolean tieneAguaCaliente;
    @Column(name = "tiene_telefono")
    private Boolean tieneTelefono;
    @Column(name = "tiene_lavadero")
    private Boolean tieneLavadero;
    @Column(name = "tiene_pavimento")
    private Boolean tienePavimento;
}
