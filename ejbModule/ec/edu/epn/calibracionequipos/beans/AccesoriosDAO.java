package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Accesorio;
import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface AccesoriosDAO extends DaoGenerico<Accesorio> {
	int consultarId();

	List<Accesorio> accesoriosxEquipo(Equiposcalibracionequipo equipo);

}
