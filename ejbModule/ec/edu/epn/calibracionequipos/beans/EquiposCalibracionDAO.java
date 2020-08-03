package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.calibracionequipos.entidades.Laboratorioscalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface EquiposCalibracionDAO extends DaoGenerico<Equiposcalibracionequipo> {
	int consultarId();

	List<Equiposcalibracionequipo> buscarEquipos(Laboratorioscalibracionequipo laboratorio,
			Equiposcalibracionequipo equipo);

	List<Equiposcalibracionequipo> buscarEquiposxLabo(Laboratorioscalibracionequipo laboratorio);

}
