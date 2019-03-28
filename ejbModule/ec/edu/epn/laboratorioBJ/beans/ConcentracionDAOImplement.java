package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Concentracion;

@Stateless
@LocalBean

public class ConcentracionDAOImplement extends DaoGenericoImplement<Concentracion> implements ConcentracionDAO {
	    
    public ConcentracionDAOImplement() {
        // TODO Auto-generated constructor stub
    }

}
