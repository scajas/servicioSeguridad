package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Responsable;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ResponsableDAO extends DaoGenerico<Responsable> {
	int consultarId();

	List<Responsable> buscarResponsable(Responsable responsable);

}
