package ec.edu.epn.publik.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.publik.entities.PerfilUsuario;

/**
 * Session Bean implementation class PerfilUsuarioDAOImplement
 */
@Stateless
@LocalBean
public class PerfilUsuarioDAOImplement extends DaoGenericoImplement<PerfilUsuario> implements PerfilUsuarioDAO {

    /**
     * Default constructor. 
     */
    public PerfilUsuarioDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
