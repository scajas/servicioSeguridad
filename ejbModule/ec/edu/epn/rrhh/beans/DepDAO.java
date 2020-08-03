package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NoResultException;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Dep;



@Local
public interface DepDAO extends DaoGenerico<Dep> {

	Dep findDepbyCodigo(String cod_dep) throws NoResultException,Exception;
	public List<Dep> listDepartamentos(String nombre) throws Exception;
	Dep findCodDepByIdFacultad(Integer idFacultad) throws Exception;
	List<Dep> findAllDep() throws Exception;
	
	List<Dep> listaDepXFacultad();
	List<Dep> listaDepXfacultad(Integer idFacultad) throws NoResultException, Exception;
	List<Dep> listarFacultades() throws NoResultException, Exception;
	List<Dep> findDepByFacultad(String coddep) throws Exception;
	List<Dep> departamentos();

}
