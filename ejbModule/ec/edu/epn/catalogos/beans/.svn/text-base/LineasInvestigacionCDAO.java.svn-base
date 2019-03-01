package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.LineasInvestigacion;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface LineasInvestigacionCDAO extends DaoGenerico<LineasInvestigacion>{

	List<LineasInvestigacion> findlinInvAntiguas(Integer iddept);

	List<LineasInvestigacion> findlinInv(Integer iddept);

	LineasInvestigacion finLininv(Integer idlininv) throws Exception;

}
