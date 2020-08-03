package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Tipoplan;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface TipoPlanDAO extends DaoGenerico<Tipoplan> {
	int consultarId();

}
