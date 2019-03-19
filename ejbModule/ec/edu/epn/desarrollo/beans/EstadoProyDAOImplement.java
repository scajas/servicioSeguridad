package ec.edu.epn.desarrollo.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.desarrollo.entities.EstadoD;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class EstadoProyDAOImplement
 */
@Stateless
@LocalBean
public class EstadoProyDAOImplement  extends DaoGenericoImplement<EstadoD> implements EstadoProyDAO {

    
}
