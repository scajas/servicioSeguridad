package ec.edu.epn.rrhh.beans;



import java.util.List;

import javax.ejb.Remote;
import javax.persistence.NoResultException;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.Dependencia;

@Remote
public interface DependenciaDAO extends DaoGenerico<Dependencia> {

	List<Dependencia> findDependenciaActivaByTipoEmpleado(String tipoEmpleado);

	List<Dependencia> findDependenciaId(String codDependencia);

	List<Dependencia> listarFacultades() throws NoResultException, Exception;

	List<Dependencia> listaDepXfacultad(Integer idFacultad) throws NoResultException, Exception;
	
	List<Dependencia> getDependenciasAdministrables();
	
	//Nuevos métodos
	String getMaxIdDependencia();    
	
	Dependencia getDependenciaByNombre(String nombreDependencia);

	List<Dependencia> getDependencias();

	List<Dependencia> getDependenciasAll();

	List<Dependencia> findDependenciaAcademica();

	List<Dependencia> findDependenciaActivaByTipoEmpleadoMigrado(String tipoEmpleado);

	List<Dependencia> listaDepXFacultad();

	

}

