/**
 * 
 */
package ec.edu.epn.catalogos.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.PreguntasEvaluacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.PreguntasEvaluacionDTO;


/**
 * @author Administrador
 * 
 */
@Stateless
public class PreguntasEvaluacionDAOImplement extends
		DaoGenericoImplement<PreguntasEvaluacion> implements PreguntasEvaluacionDAO {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PreguntasEvaluacionDTO> listPregEvaluacion(String tipo, String seleccion) throws Exception{
		List<PreguntasEvaluacion> listPreguntEval= new ArrayList<PreguntasEvaluacion>();
		List<PreguntasEvaluacionDTO> listPreguntEvalDTO= new ArrayList<PreguntasEvaluacionDTO>();
		List<String> opciones;
		
		
		Query q = getEntityManager().createQuery(
				"SELECT p FROM PreguntasEvaluacion p WHERE p.tipo = ? AND p.asignacion=? ORDER BY orden");
		
		q.setParameter(1, tipo);
		q.setParameter(2, seleccion);
		
		
		listPreguntEval= q.getResultList();		
		
		if(listPreguntEval!=null){
			for (PreguntasEvaluacion preg: listPreguntEval){
				PreguntasEvaluacionDTO dto= new PreguntasEvaluacionDTO();
				dto.setIdPreguntasEval(preg.getIdPreguntasEval());
				dto.setAsignacion(preg.getAsignacion());
				dto.setDetalle(preg.getDetalle());
				dto.setTipo(preg.getTipo());
				dto.setOrden(preg.getOrden());
				
				opciones = new ArrayList<String>();
				opciones.add("1");
				opciones.add("2");
				opciones.add("3");
				opciones.add("4");
				opciones.add("5");				
				
				dto.setOpciones(opciones);					
				listPreguntEvalDTO.add(dto);
			}
		}else{
			listPreguntEvalDTO=null;
		}
		
		return  listPreguntEvalDTO;
	}
	
	
	
	
	}
