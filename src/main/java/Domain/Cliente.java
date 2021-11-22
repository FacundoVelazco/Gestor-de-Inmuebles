package Domain;

import Domain.Util.Orientacion;

import javax.persistence.*;

public class Cliente extends Persona {

    private Long id;

    protected String username;

    protected String password;

    protected String nombre;

    protected String apellido;

    protected String telefono;

    private Preferencias preferencia;
}
