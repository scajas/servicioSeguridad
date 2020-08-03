package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Caracteristicastecnica;
import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface CaracteristicasTecnicasDAO extends DaoGenerico<Caracteristicastecnica> {
	int consultarId();

	List<Caracteristicastecnica> buscarCarcateristicasxEquipo(Equiposcalibracionequipo equipo);
}
