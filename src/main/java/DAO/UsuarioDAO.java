package DAO;

import DAO.Util.CredencialesInexistentesException;
import Domain.Util.TipoUser;
import Domain.Util.Usuario;

public interface UsuarioDAO {
    public Boolean matchesUsuario(String username, String password);
    public Usuario getUser(String username, String password, TipoUser tipoUsuario) throws CredencialesInexistentesException;
}
