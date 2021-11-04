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
}
