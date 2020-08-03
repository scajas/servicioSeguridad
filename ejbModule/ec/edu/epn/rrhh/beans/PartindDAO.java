package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Partind;

@Local
public interface PartindDAO extends DaoGenerico<Partind> {

	
	Partind findbyCodPind(String codpind);

	List<Partind> findPartidas();
}
