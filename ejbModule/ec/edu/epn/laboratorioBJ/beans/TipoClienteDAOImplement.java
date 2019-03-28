package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Tipocliente;

/**
 * Session Bean implementation class TipoClienteDAOImplement
 */
@Stateless
@LocalBean
public class TipoClienteDAOImplement extends DaoGenericoImplement<Tipocliente> implements  TipoClienteDAO {

    /**
     * Default constructor. 
     */
    public TipoClienteDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
