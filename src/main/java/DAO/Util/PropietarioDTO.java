package DAO.Util;

import Domain.Util.TipoDNI;

import java.util.List;

public class PropietarioDTO {

    private Integer Id;
    private TipoDNI tipoDocumento;
    private String Dni;
    private String direccion;
    private List<InmuebleDTO> inmuebles;
    //private VendedorDTO vendedor;
    private String localidad;
    private String provincia;
    private String email;
    private String apellido;
    private String nombre;
    private String username;
    private String password;
    private Integer idLocalidad;
    private Integer idProvincia;
    private Integer idDireccion;
    private String calle;
    private Integer numeroDeCalle;
    private String barrio;

    public PropietarioDTO(){
    }

    public TipoDNI getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDNI tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoDNI getTipoDNI() {
        return tipoDocumento;
    }

    public void setTipoDNI(TipoDNI tipoDNI) {
        this.tipoDocumento = tipoDNI;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<InmuebleDTO> getInmuebles() { return inmuebles;}

    public void setInmuebles(List<InmuebleDTO> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumeroDeCalle() {
        return numeroDeCalle;
    }

    public void setNumeroDeCalle(Integer numeroDeCalle) {
        this.numeroDeCalle = numeroDeCalle;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Integer getId() {
        return Id;
    }
}
