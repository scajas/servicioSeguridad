package ec.edu.epn.calibracionequipos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Actividadespersonalcalificado;
import ec.edu.epn.calibracionequipos.entidades.Personalcalificado;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ActividadesPersonalCalificadoDAO extends DaoGenerico<Actividadespersonalcalificado> {
	int consultarId();
	
	List<Actividadespersonalcalificado> buscarActividadesXPesonal(Personalcalificado personal);

}
