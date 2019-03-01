package ec.edu.epn.convenios.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.convenios.entities.EstadoC;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class EstadoConvenioDAOImplement
 */
@Stateless
@LocalBean
public class EstadoConvenioDAOImplement extends DaoGenericoImplement<EstadoC> implements EstadoConvenioDAO {

    /**
     * Default constructor. 
     */
    public EstadoConvenioDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
