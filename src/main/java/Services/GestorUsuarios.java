package Services;

import DAO.DAOBdUsuario;
import DAO.Util.CredencialesInexistentesException;
import Domain.Util.TipoUser;
import Domain.Util.Usuario;

public class GestorUsuarios {
    static Usuario usuarioLogueado;

    public Usuario getUsuario(String username, String password, TipoUser tipoUser) throws CredencialesInexistentesException {
        DAOBdUsuario daoBdUsuario = new DAOBdUsuario();
        return daoBdUsuario.getUser(username,password,tipoUser);
    }

    public static Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static void setUsuarioLogueado(Usuario usuarioLogueado) {
        GestorUsuarios.usuarioLogueado = usuarioLogueado;
    }
}
