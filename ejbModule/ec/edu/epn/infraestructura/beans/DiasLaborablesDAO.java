package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.Diaslaborable;



@Local
public interface DiasLaborablesDAO extends DaoGenerico<Diaslaborable> {

	int consultarId();

	List<Diaslaborable> listarDiasLabora();

	List<Diaslaborable> listarDLXDias(String dl);
}
