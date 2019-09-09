package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.CalculoHorasExigible;


@Local
public interface CalculoHorasExigibleDAO extends DaoGenerico<CalculoHorasExigible> {

	CalculoHorasExigible calculoHorasXPensum(Integer idPensum) throws Exception;


	
}
