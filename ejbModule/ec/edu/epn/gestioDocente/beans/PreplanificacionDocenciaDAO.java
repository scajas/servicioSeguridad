package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.PreplanificacionDocencia;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.rrhh.movimientos.Dependencia;

@Local
public interface PreplanificacionDocenciaDAO extends DaoGenerico<PreplanificacionDocencia> {
	
	
	PreplanificacionDocencia findByPedido(Integer idPedido);

	Long countPreplanifExiste(String nombre, Integer idPensum) throws Exception;

	List<DocenteDTO> listaDocPreplanifRevision(List<DocenteDTO> listaDocente, String estado, Integer idPensum, String dep);

	List<DocenteDTO> listaDocentePreplanifc(String nombre, Integer idPensum, List<DocenteDTO> listaDocente,
			String codDep);

	PreplanificacionDocencia preplanifXPeriodo(String nced, String nombre, Integer idPensum, String estado, String dep)
			throws Exception;
	
	
	List<PreplanificacionDocencia> listaDocentePreplanifc(Integer idPensum, Integer idFacultad);



	Dependencia dependenciaByNombre(String nombreDependencia);



	Long countPreplanifXPeriodo(String nced, String nombre, Integer idPensum, String estado, String dep)
			throws Exception;

	Pedido findPedidoPreplanif(String nced, Integer idPensum, Integer idEstado);



	

	

}
