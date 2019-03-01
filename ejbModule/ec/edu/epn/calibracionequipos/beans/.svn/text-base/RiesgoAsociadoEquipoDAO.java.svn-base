package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Equiposcalibracionequipo;
import ec.edu.epn.calibracionequipos.entidades.Riesgosasociado;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface RiesgoAsociadoEquipoDAO extends DaoGenerico<Riesgosasociado> {
	int consultarId();

	List<Riesgosasociado> riesgosxEquipo(Equiposcalibracionequipo equipo);

}
