package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Documentacionasociada;
import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface DocumentacionEquipoDAO extends DaoGenerico<Documentacionasociada> {
	int consultarId();

	List<Documentacionasociada> documentacionxEquipo(Equiposcalibracionequipo equipo);

}
