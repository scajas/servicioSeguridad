package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.calibracionequipos.entidades.Incidentesasociado;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface IncidentesAsociadosEquiposDAO extends DaoGenerico<Incidentesasociado> {
	int consultarId();

	List<Incidentesasociado> incidentesxEquipo(Equiposcalibracionequipo equipo);

}
