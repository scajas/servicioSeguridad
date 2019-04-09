package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Existencia;

/**
 * Session Bean implementation class ExistenciaDAOImplement
 */
@Stateless
@LocalBean
public class ExistenciaDAOImplement extends DaoGenericoImplement<Existencia> implements ExistenciaDAO {

    /**
     * Default constructor. 
     */
    public ExistenciaDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
