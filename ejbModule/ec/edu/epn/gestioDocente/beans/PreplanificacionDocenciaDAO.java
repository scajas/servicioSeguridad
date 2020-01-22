package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.PreplanificacionDocencia;
import ec.edu.epn.rrhh.DTO.DocenteDTO;


@Local
public interface PreplanificacionDocenciaDAO extends DaoGenerico<PreplanificacionDocencia> {

	Long countPreplanifXPeriodo(String nced, String nombre, Integer idPensum, String estado) throws Exception;

	PreplanificacionDocencia preplanifXPeriodo(String nced, String nombre, Integer idPensum, String estado)
			throws Exception;

	Long countPreplanifExiste(String nombre, Integer idPensum) throws Exception;

	List<DocenteDTO> listaDocPreplanifRevision(List<DocenteDTO> listaDocente, String estado, Integer idPensum);

	List<DocenteDTO> listaDocentePreplanifc(String nombre, Integer idPensum, List<DocenteDTO> listaDocente,
			String codDep);

	PreplanificacionDocencia findByPedido(Integer idPedido);

	

	
}
