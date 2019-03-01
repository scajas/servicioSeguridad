package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Auditoria;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface AuditoriaDAO extends DaoGenerico<Auditoria> {
	int consultarId();

}
