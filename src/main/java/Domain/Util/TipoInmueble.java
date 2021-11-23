package Domain.Util;

public enum TipoInmueble {

    LOCAL_OFICINA,
    CASA,
    DEPARTAMENTO,
    TERRENO,
    QUINTA,
    GALPON;

    @Override
    public String toString(){
        return name().substring(0,1) + name().substring(1).toLowerCase().replaceAll("_"," ") ;
    }


    //Para obtener el tipo segun la opcion seleccionada por el usuario
    public static TipoInmueble obtenerByString(String s){
        switch (s){
            case "Local-Oficina":
                return LOCAL_OFICINA;
            case "Casa":
                return CASA;
            case "Departamento":
                return DEPARTAMENTO;
            case "Terreno":
                return TERRENO;
            case "Quinta":
                return QUINTA;
        }
        return GALPON;
    }

    public static String obtenerStringParaComboBox(TipoInmueble t){
        switch (t){
            case LOCAL_OFICINA:
                return "Local-Oficina";
            case CASA:
                return "Casa";
            case DEPARTAMENTO:
                return "Departamento";
            case TERRENO:
                return "Terreno";
            case QUINTA:
                return "Quinta";
        }
        return "Galpón";
    }


}
