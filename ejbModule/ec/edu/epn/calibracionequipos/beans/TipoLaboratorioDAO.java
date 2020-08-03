package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Tiposlaboratorio;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface TipoLaboratorioDAO extends DaoGenerico<Tiposlaboratorio> {
	int consultarId();

}
