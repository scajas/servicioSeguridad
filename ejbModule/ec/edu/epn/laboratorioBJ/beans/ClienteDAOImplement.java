package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Cliente;

/**
 * Session Bean implementation class ClienteDAOImplement
 */
@Stateless
@LocalBean
public class ClienteDAOImplement extends DaoGenericoImplement<Cliente> implements ClienteDAO {

    /**
     * Default constructor. 
     */
    public ClienteDAOImplement() {
        // TODO Auto-generated constructor stub
    }
 
}
