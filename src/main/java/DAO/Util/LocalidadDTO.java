package DAO.Util;

import Domain.Localidad;

import java.util.ArrayList;
import java.util.List;

public class LocalidadDTO {
    public Integer id;
    public String nombre;
    public Integer provinciaId;
    public List<BarrioDTO> barrios;
    public Class localidadClass = Localidad.class;

    public LocalidadDTO(Integer id, Class localidadClass) {
        this.id = id;
        this.localidadClass = localidadClass;
    }

    public LocalidadDTO(Integer id, String nombre, Integer provinciaId, Class localidadClass) {
        this.id = id;
        this.nombre = nombre;
        this.provinciaId = provinciaId;
        this.barrios = new ArrayList<>();
        this.localidadClass = localidadClass;
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

    public List<BarrioDTO> getBarrios() {
        return barrios;
    }

    public void setBarrios(List<BarrioDTO> barrios) {
        this.barrios = barrios;
    }

    public Class getLocalidadClass() {
        return localidadClass;
    }

    public void setLocalidadClass(Class localidadClass) {
        this.localidadClass = localidadClass;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
