package DAO.Util;

import Domain.Provincia;

import java.util.List;

public class ProvinciaDTO {
    public Integer id;
    public String nombre;
    public List<LocalidadDTO> localidades;
    public Class provinciaClass = Provincia.class;

    public ProvinciaDTO(Integer id, Class provinciaClass) {
        this.id = id;
        this.provinciaClass = provinciaClass;
    }
    public ProvinciaDTO(Integer id, String nombre,Class provinciaClass) {
        this.id = id;
        this.nombre = nombre;
        this.provinciaClass = provinciaClass;
    }
    public ProvinciaDTO(Integer id, String nombre, List<LocalidadDTO> localidades, Class provinciaClass) {
        this.id = id;
        this.nombre = nombre;
        this.localidades = localidades;
        this.provinciaClass = provinciaClass;
    }
}
