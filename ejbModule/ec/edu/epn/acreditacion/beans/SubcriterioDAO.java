package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.acreditacion.entities.Subcriterio;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface SubcriterioDAO extends DaoGenerico<Subcriterio>{

	List<Subcriterio> listSubCriterioxIdCriterio(Integer idCriterio) throws Exception;

	String detalleSubCriterio(Integer idSubcriterio);

}
