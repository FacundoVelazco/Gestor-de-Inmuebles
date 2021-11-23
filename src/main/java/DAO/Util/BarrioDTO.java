package DAO.Util;

import Domain.Barrio;

public class BarrioDTO {
    public Integer id;
    public String nombre;
    public Integer localidadId;
    public Class barrioClass = Barrio.class;

    public BarrioDTO(Integer id, String nombre, Integer localidadId, Class barrioClass) {
        this.id = id;
        this.nombre = nombre;
        this.localidadId = localidadId;
        this.barrioClass = barrioClass;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
