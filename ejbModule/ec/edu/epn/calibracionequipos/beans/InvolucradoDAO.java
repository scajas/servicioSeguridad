package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Involucrado;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface InvolucradoDAO extends DaoGenerico<Involucrado> {
	int consultarId();

}
