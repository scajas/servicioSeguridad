package ec.edu.epn.deportivo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.deportivo.entities.Deporte;
import ec.edu.epn.deportivo.entities.DiasPlanificacion;
import ec.edu.epn.deportivo.entities.Diashora;
import ec.edu.epn.deportivo.entities.HoraPlanificacion;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface DiasHoraDAO extends DaoGenerico<Diashora> {

	List<DiasPlanificacion> findDiasxHora(HoraPlanificacion hora);


}
