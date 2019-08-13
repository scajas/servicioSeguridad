/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.beans.PensumDAO;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.EstadoEvaluacion;
import ec.edu.epn.gestionDocente.entities.PreplanificacionDocencia;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.rrhh.beans.DependenciaDAO;
import ec.edu.epn.rrhh.movimientos.Dependencia;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PreplanificacionDocenciaDAOImplement extends
		DaoGenericoImplement<PreplanificacionDocencia> implements PreplanificacionDocenciaDAO {
	
	
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/DependenciaDAOImplement!ec.edu.epn.rrhh.beans.DependenciaDAO")
	private DependenciaDAO dependenciaDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PensumDAOImplement!ec.edu.epn.contratos.beans.PensumDAO")
	private PensumDAO pensumDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/EstadoEvaluacionDAOImplement!ec.edu.epn.gestioDocente.beans.EstadoEvaluacionDAO")
	private EstadoEvaluacionDAO estadoEvaluacionDAO;

	
	@Override
	public Long countPreplanifXPeriodo(String nced, String nombre, Integer idPensum, String estado) throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(p) FROM PreplanificacionDocencia p WHERE (p.nced=? OR p.nombre like ?) AND p.idPensum= ? AND p.estado like ? ");

		
		q.setParameter(1, nced);
		q.setParameter(2, nombre);
		q.setParameter(3, idPensum);
		q.setParameter(4, estado);
		
		
		return (Long) q.getSingleResult();
	}
	
	
	@Override
	public PreplanificacionDocencia preplanifXPeriodo(String nced, String nombre, Integer idPensum, String estado) throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT p FROM PreplanificacionDocencia p WHERE (p.nced=? OR p.nombre like ?) AND p.idPensum= ? AND p.estado like ? ");

		
		q.setParameter(1, nced);
		q.setParameter(2, nombre);
		q.setParameter(3, idPensum);
		q.setParameter(4, estado);
		
		try {
			return  (PreplanificacionDocencia) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocenteDTO> listaDocentePreplanifc(String nombre, Integer idPensum, List<DocenteDTO> listaDocente, String codDep){
		
		List<PreplanificacionDocencia> listPreplanif= new ArrayList<PreplanificacionDocencia>();
		List<DocenteDTO>  listaDocenteDTO= new ArrayList<DocenteDTO>();
		Query q = getEntityManager()
				.createQuery(
						"SELECT p FROM PreplanificacionDocencia p WHERE  p.nombreAnterior like ? AND p.idPensum= ? AND p.codDep=? AND p.nced IS null ");

				
		q.setParameter(1, nombre);
		q.setParameter(2, idPensum);		
		q.setParameter(3, codDep);
		
		
		try {
			
			for(DocenteDTO doc: listaDocente){				
				if(doc.getnCed()!=null){
					PreplanificacionDocencia preplanif= preplanifXPeriodo(
							doc.getnCed() == null ? "" : doc.getnCed(), doc.getNombre(), idPensum, "%%");
					
					if(preplanif!=null){
						EstadoEvaluacion estadoEval= estadoEvaluacionDAO.estadoEvalXNombre(preplanif.getEstado());
						doc.setEstado(estadoEval.getDescripcion());
					}
				}
				
				listaDocenteDTO.add(doc);
				
			}
			
			listPreplanif=  q.getResultList();
			if(!listPreplanif.isEmpty()){
				for(PreplanificacionDocencia dto: listPreplanif){
					DocenteDTO docente= new DocenteDTO();
					docente.setNombre(dto.getNombreAnterior());
					
					Pensum pensum = new Pensum();
					pensum = pensumDAO.obtenerPensumById(idPensum);
					docente.setPeriodo(pensum == null ? "" : pensum.getMeses());
					docente.setIdPeriodo(pensum.getIdPensum().toString());
					
					Dependencia dep= new Dependencia();
					dep= (Dependencia) dependenciaDAO.getById(Dependencia.class, dto.getCodDep());
					docente.setNomDepartamento(dep==null?"":dep.getNomDep());
					docente.setExistePeriodo(true);
					
					EstadoEvaluacion estadoEval= estadoEvaluacionDAO.estadoEvalXNombre(dto.getEstado());
					docente.setEstado(estadoEval.getDescripcion());
					
					listaDocenteDTO.add(docente);
				}
			}
			
			return listaDocenteDTO;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	@Override
	public Long countPreplanifExiste(String nombre, Integer idPensum) throws Exception {
		
		Query q = getEntityManager()
				.createQuery(
						"SELECT count(p) FROM PreplanificacionDocencia p WHERE  p.nombre like ? AND p.idPensum= ? AND p.nced IS null ");

				
		q.setParameter(1, nombre.trim());
		q.setParameter(2, idPensum);
		
		
		
		return (Long) q.getSingleResult();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocenteDTO> listaDocPreplanifRevision(List<DocenteDTO> listaDocente, String estado, Integer idPensum){
		
		List<PreplanificacionDocencia> listPreplanif= new ArrayList<PreplanificacionDocencia>();
		List<DocenteDTO> listaDoc = new ArrayList<DocenteDTO>();
		Query q = getEntityManager()
				.createQuery(
						"SELECT p FROM PreplanificacionDocencia p WHERE p.estado != ? AND p.idPensum=? ");

		
		q.setParameter(1, estado);		
		q.setParameter(2, idPensum);
		
		
		try {
			listPreplanif=  q.getResultList();
			if(!listPreplanif.isEmpty()){
				for(PreplanificacionDocencia pre: listPreplanif){
					for(DocenteDTO dto: listaDocente){						
						if(pre.getNced()!=null && dto.getnCed()!=null && pre.getNced().trim().equals(dto.getnCed()) && pre.getIdPensum()== Integer.valueOf(dto.getIdPeriodo())){
							EstadoEvaluacion estadoEval= estadoEvaluacionDAO.estadoEvalXNombre(pre.getEstado());
							dto.setEstado(estadoEval.getDescripcion());
							listaDoc.add(dto);
						}else if(pre.getNombreAnterior()!=null && dto.getNombre()!=null && pre.getNombreAnterior().trim().equals(dto.getNombre()) && pre.getIdPensum()== Integer.valueOf(dto.getIdPeriodo())){
							EstadoEvaluacion estadoEval= estadoEvaluacionDAO.estadoEvalXNombre(pre.getEstado());
							dto.setEstado(estadoEval.getDescripcion());
							listaDoc.add(dto);
						}
					}
				}
			}
			
			return listaDoc;
		} catch (Exception e) {
			return null;
		}
		
	}
		
}
