package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Caracteristica;

/**
 * Session Bean implementation class PosgiroDAOImplement
 */
@Stateless
@LocalBean
public class CaracteristicaDAOImplement extends DaoGenericoImplement<Caracteristica> implements CaracteristicaDAO {
	/**
     * Default constructor. 
	 * @return 
     */
	public CaracteristicaDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
