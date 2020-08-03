package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.PiliticasDesarrollo;

@Local
public interface PoliticasDAO extends DaoGenerico<PiliticasDesarrollo>{

	int maxId();

	List<PiliticasDesarrollo> consultarPoliticas(Integer idsilado);

}
