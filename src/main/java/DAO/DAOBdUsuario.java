package DAO;

import DAO.Util.Conexion;
import DAO.Util.CredencialesInexistentesException;
import Domain.Util.TipoUser;
import Domain.Util.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class DAOBdUsuario implements UsuarioDAO {
    private EntityManager manager;


    public DAOBdUsuario() {
        manager = Conexion.emf.createEntityManager();

    }

    @Override
    public Boolean matchesUsuario(String username, String password) {
        return null;
    }

    @Override
    public Usuario getUser(String username, String password, TipoUser tipoUser) throws CredencialesInexistentesException {

        Usuario usuario=null;

        try{
            switch (tipoUser){
                case ADMIN:
                    usuario = (Usuario) manager.createQuery("From Admin as a Where a.username = :usernameAdmin And a.password = :passwordAdmin")
                            .setParameter("usernameAdmin",username).setParameter("passwordAdmin",password).getSingleResult();
                    break;
                case CLIENTE:
                    usuario = (Usuario) manager.createQuery("From Cliente as a Where a.username = :usernameCliente And a.password = :passwordCliente")
                            .setParameter("usernameCliente",username).setParameter("passwordCliente",password).getSingleResult();
                    break;
                case VENDEDOR:
                    usuario = (Usuario) manager.createQuery("From Vendedor as a Where a.username = :usernameVendedor And a.password = :passwordVendedor")
                            .setParameter("usernameVendedor",username).setParameter("passwordVendedor",password).getSingleResult();
                    break;
                case PROPIETARIO:
                    usuario = (Usuario) manager.createQuery("From Propietario as a Where a.username = :usernamePropietario And a.password = :passwordPropietario")
                            .setParameter("usernamePropietario",username).setParameter("passwordPropietario",password).getSingleResult();
                    break;
            }
        }catch (NoResultException nre){
            throw new CredencialesInexistentesException("El nombre de usuario y/o contraseña son incorrectos");
        }

        manager.close();
        return usuario;
    }
}
