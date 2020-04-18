package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.EliminacionServicio;

/**
 * Session Bean implementation class EliminacionServicioDAOImplement
 */
@Stateless
@LocalBean
public class EliminacionServicioDAOImplement extends DaoGenericoImplement<EliminacionServicio> implements EliminacionServicioDAO {

    /**
     * Default constructor. 
     */
    public EliminacionServicioDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
