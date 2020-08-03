package ec.edu.epn.infraestructura.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.PreferenciaHorario;

@Local
public interface PreferenciaHorarioDAO extends DaoGenerico<PreferenciaHorario> {

	int consultarId();

}
