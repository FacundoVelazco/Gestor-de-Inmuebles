package Domain.Util;

public enum Orientacion {
    NORTE, SUR, ESTE, OESTE, NORESTE, NOROESTE, SURESTE, SUROESTE;

    public static Orientacion obtenerByString(String s){
        switch (s){
            case "Norte":
                return NORTE;
            case "Sur":
                return SUR;
            case "Este":
                return ESTE;
            case "Oeste":
                return OESTE;
            case "Noreste":
                return NORESTE;
            case "Noroeste":
                return NOROESTE;
            case "Sureste":
                return SURESTE;
        }
        return SUROESTE;
    }

    public static String obtenerStringParaComboBox(Orientacion o){
        switch (o){
            case NORTE:
                return "Norte";
            case SUR:
                return "Sur";
            case ESTE:
                return "Este";
            case OESTE:
                return "Oeste";
            case NORESTE:
                return "Noreste";
            case NOROESTE:
                return "Noroeste";
            case SURESTE:
                return "Sureste";
        }
        return "Suroeste";
    }

}
