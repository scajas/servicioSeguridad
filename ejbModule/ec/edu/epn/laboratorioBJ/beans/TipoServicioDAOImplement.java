package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Tiposervicio;

/**
 * Session Bean implementation class TipoServicioDAOImplement
 */
@Stateless
@LocalBean
public class TipoServicioDAOImplement extends DaoGenericoImplement<Tiposervicio> implements TipoServicioDAO {

    /**
     * Default constructor. 
     */
    public TipoServicioDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
    

}
