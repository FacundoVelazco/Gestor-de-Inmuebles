package DAO.Util;

import Domain.Localidad;

import java.util.ArrayList;
import java.util.List;

public class LocalidadDTO {
    public Integer id;
    public String nombre;
    public String nombreProvincia;

    public LocalidadDTO(Integer id, String nombre,String provinciaNombre) {
        this.id = id;
        this.nombre = nombre;
        this.nombreProvincia = provinciaNombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
