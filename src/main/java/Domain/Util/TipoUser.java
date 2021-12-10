package Domain.Util;

public enum TipoUser {
    ADMIN,
    CLIENTE,
    VENDEDOR,
    PROPIETARIO;

    public static TipoUser obtenerByString(String s){
        switch (s){
            case "Administrador":
                return ADMIN;
            case "Cliente":
                return CLIENTE;
            case "Vendedor":
                return VENDEDOR;
            case "Propietario":
                return PROPIETARIO;
        }
        return null;
    }

    public static String obtenerStringParaComboBox(TipoUser t){
        switch (t){
            case ADMIN:
                return "Administrador";
            case CLIENTE:
                return "Cliente";
            case VENDEDOR:
                return "Vendedor";
            case PROPIETARIO:
                return "Propietario";
        }
        return null;
    }

}
