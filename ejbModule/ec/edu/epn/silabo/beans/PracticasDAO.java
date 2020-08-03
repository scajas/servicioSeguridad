package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.PracticasLaboratorio;

@Local
public interface PracticasDAO extends DaoGenerico<PracticasLaboratorio>{

	int maxIdPracticas();

	List<PracticasLaboratorio> consultarPracticas(Integer idsilado);

}
