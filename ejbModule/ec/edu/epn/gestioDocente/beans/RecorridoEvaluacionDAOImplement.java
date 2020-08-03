package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import org.primefaces.event.ReorderEvent;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.RecorridoEvaluacionDTO;
import ec.edu.epn.gestionDocente.entities.EstadoEvaluacion;
import ec.edu.epn.gestionDocente.entities.RecorridoEvaluacion;
import ec.edu.epn.publik.beans.UsuarioService;
import ec.edu.epn.seguridad.vo.Usuario;

/**
 * Session Bean implementation class RecorridoEvaluacionDAOImplement
 */
@Stateless
@LocalBean
public class RecorridoEvaluacionDAOImplement extends DaoGenericoImplement<RecorridoEvaluacion>
		implements RecorridoEvaluacionDAO {
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/EstadoEvaluacionDAOImplement!ec.edu.epn.gestioDocente.beans.EstadoEvaluacionDAO")
	private EstadoEvaluacionDAO estadoEvalDAO;
	
	@EJB(lookup = "java:global/ServiciosSeguridadEPN/UsuarioServiceBean!ec.edu.epn.publik.beans.UsuarioService")
	private UsuarioService userDAO;
	
	@Override
	public RecorridoEvaluacion recorridoXEstado(Integer idEvaluacion, String estadoAnterior) throws Exception{
		Query q = getEntityManager().createQuery(
				"Select max(rec) from RecorridoEvaluacion rec where rec.idEvalAcad = ?1 and rec.estadoActual= ?2");
		q.setParameter(1, idEvaluacion );
		q.setParameter(2, estadoAnterior);
		return (RecorridoEvaluacion) q.getSingleResult();
	}
	
	
	@Override
	public List<RecorridoEvaluacionDTO> listaRecorridoXEval(Integer idEvaluacion){
		
		List<RecorridoEvaluacion> listRecorrido= new ArrayList<RecorridoEvaluacion>();
		List<RecorridoEvaluacionDTO> listRecorridoDTO = new ArrayList<RecorridoEvaluacionDTO>();
 		
		try {
			
			Query q = getEntityManager().createQuery(
					"Select rec from RecorridoEvaluacion rec where rec.idEvalAcad = ?1 ORDER BY idRecorridoEval ");
			q.setParameter(1, idEvaluacion );
			
			listRecorrido= q.getResultList();
			
			if(!listRecorrido.isEmpty()){
				for(RecorridoEvaluacion recorrido: listRecorrido){
					EstadoEvaluacion estadoAnterior= new EstadoEvaluacion();
					EstadoEvaluacion estadoActual= new EstadoEvaluacion();
					RecorridoEvaluacionDTO recorDTO=new RecorridoEvaluacionDTO();
					Usuario usuario= new Usuario();
					estadoAnterior= estadoEvalDAO.estadoEvalXNombre(recorrido.getEstadoAnterior());
					estadoActual= estadoEvalDAO.estadoEvalXNombre(recorrido.getEstadoActual());
					
					usuario= userDAO.consultaXidUsuario(Long.valueOf(recorrido.getEnviadoPor().toString()));
					
					if(usuario!=null){
						recorDTO.setNombreAutorizacion(usuario.getNombreUsuario());
					}
					
					recorDTO.setEstadoActual(estadoActual.getDescripcion());
					recorDTO.setEstadoAnterior(estadoAnterior.getDescripcion());
					recorDTO.setObservacion(recorrido.getObservacion());
					recorDTO.setFechaRecorrido(recorrido.getFechaEnvio());
					
					listRecorridoDTO.add(recorDTO);
					
					
				}
			}else{
				listRecorridoDTO= null;
			}
			
			return listRecorridoDTO;
		} catch (Exception e) {
			return null;
		}
	}
	
}
