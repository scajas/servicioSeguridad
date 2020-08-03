package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Tipoinvolucrado;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface TipoInvolucradoDAO extends DaoGenerico<Tipoinvolucrado> {
	int consultarId();

}
