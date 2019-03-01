package ec.edu.epn.convenios.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.convenios.entities.TipoC;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class TipoConvenioDAOImplement
 */
@Stateless
@LocalBean
public class TipoConvenioDAOImplement extends DaoGenericoImplement<TipoC> implements TipoConvenioDAO {

    

}
