package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.calibracionequipos.entidades.Medidaspreventiva;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface MedidaPreventivaEquipoDAO extends DaoGenerico<Medidaspreventiva> {
	int consultarId();

	List<Medidaspreventiva> medidasPreventivasxEquipo(Equiposcalibracionequipo equipo);

}
