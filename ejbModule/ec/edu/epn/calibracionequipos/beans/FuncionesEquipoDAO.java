package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.calibracionequipos.entidades.Funcionesequipo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface FuncionesEquipoDAO extends DaoGenerico<Funcionesequipo> {
	int consultarId();

	List<Funcionesequipo> funcionesxequipo(Equiposcalibracionequipo equipo);
}
