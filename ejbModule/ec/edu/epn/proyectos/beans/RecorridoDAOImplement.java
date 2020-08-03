package ec.edu.epn.proyectos.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.RecorridoCierre;

/**
 * Session Bean implementation class RecorridoDAOImplement
 */
@Stateless
@LocalBean
public class RecorridoDAOImplement extends DaoGenericoImplement<RecorridoCierre> implements RecorridoDAO {

    /**
     * Default constructor. 
     */
    public RecorridoDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
