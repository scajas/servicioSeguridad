package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Tipoevento;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface TipoEventoDAO extends DaoGenerico<Tipoevento> {
	int consultarId();

}
