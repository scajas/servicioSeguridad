package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Periodo;

@Local
public interface PeriodoDAO extends DaoGenerico<Periodo> {

	List<Periodo> finsAllPeriodos() throws Exception;

	List<Periodo> findPeriodos();

	Periodo findPeriodos(String idPeriodo);

	Periodo findPeriodoByPensum(Integer idpensum);


}
