package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Condicionesespecialesuso;
import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface CondicionesUsoDAO extends DaoGenerico<Condicionesespecialesuso> {
	int consultarId();

	List<Condicionesespecialesuso> buscarCondicionesUsoxEquipo(Equiposcalibracionequipo equipo);

}
