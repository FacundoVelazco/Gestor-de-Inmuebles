package Domain.Util;

public enum TipoDNI {
    DNI,
    PASAPORTE,
    LIBRETA_CIVICA;

    //Para obtener el tipo segun la opcion seleccionada por el usuario
    public static TipoDNI obtenerByString(String s){
        if (s==null){
            return null;
        }
        switch (s){
            case "DNI":
                return DNI;
            case "Pasaporte":
                return PASAPORTE;
            case "Libreta cívica":
                return LIBRETA_CIVICA;
            default:
                return DNI;
        }
    }

    public static String obtenerStringParaComboBox(TipoDNI t){
        if(t==null){
            return "Cualquiera";
        }
        switch (t){
            case DNI:
                return "DNI";
            case PASAPORTE:
                return "Pasaporte";
            case LIBRETA_CIVICA:
                return "Libreta cívica";
            default:
                return null;
        }
    }
}
