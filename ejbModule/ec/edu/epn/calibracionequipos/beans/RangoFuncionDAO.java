package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Rangofuncionamiento;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface RangoFuncionDAO extends DaoGenerico<Rangofuncionamiento> {
	int consultarId();

}
