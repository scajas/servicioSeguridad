package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Incidentesaccidente;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface IncidentesAccidentesDAO extends DaoGenerico<Incidentesaccidente> {
	int consultarId();

}
