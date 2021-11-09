package Domain;

import Domain.Util.TipoDocumento;

public class Propietario {

    //TODO hacer propietario
    private String nombre;
    private String apellido;
    private TipoDocumento tipoDocumento;
    private Integer nroDocumento;
    private String calleNumero;
    private String localidad;
    private Enum provincia;
    private Integer nroTelefono;
    private String email;
    private String nombreUsr;
    private String contraseña;

    public Propietario(){ // completar

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(Integer nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        localidad = localidad;
    }

    public Enum getProvincia() {
        return provincia;
    }

    public void setProvincia(Enum provincia) {
        this.provincia = provincia;
    }

    public Integer getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(Integer nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsr() {
        return nombreUsr;
    }

    public void setNombreUsr(String nombreUsr) {
        this.nombreUsr = nombreUsr;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
