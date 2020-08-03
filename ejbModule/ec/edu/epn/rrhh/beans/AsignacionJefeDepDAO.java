package ec.edu.epn.rrhh.beans;



import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.DTO.AsignacionJDepDTO;
import ec.edu.epn.rrhh.entities.AsignacionJefeDep;

@Remote
public interface AsignacionJefeDepDAO extends DaoGenerico<AsignacionJefeDep> {

	List<AsignacionJDepDTO> listaJefesDepXDependencia(String codDep, String estadoJD) throws Exception;

	AsignacionJefeDep asignacionVigenteXDEP(String codDep) throws Exception;
	
	

	

}
