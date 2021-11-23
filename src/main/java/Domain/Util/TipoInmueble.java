package Domain.Util;

public enum TipoInmueble {
    OFICINA_O_LOCAL,
    CASA,
    DEPARTAMENTO,
    TERRENO,
    QUINTA,
    GALPON;

    @Override
    public String toString(){
        return name().substring(0,1) + name().substring(1).toLowerCase().replaceAll("_"," ") ;
    }
}
