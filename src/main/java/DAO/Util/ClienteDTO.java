package DAO.Util;

import Domain.Preferencia;

public class ClienteDTO {
    private Long id;
    private String username;
    private String nombre;
    private String apellido;
    private PreferenciaDTO preferencias;
    private String password;
    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ClienteDTO(Long id, String username, String nombre, String apellido) {

        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public ClienteDTO() {
    }

    public PreferenciaDTO getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(PreferenciaDTO preferencias) {
        this.preferencias = preferencias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
