package ec.edu.epn.gestioDocente.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.HorasPeriodoAcademicoDTO;
import ec.edu.epn.gestionDocente.entities.RecorridoHrsExigiblesEval;;

/**
 * Session Bean implementation class RecorridoHrsExigiblesEvalDAOImplement
 */
@Stateless
@LocalBean
public class RecorridoHrsExigiblesEvalDAOImplement extends DaoGenericoImplement<RecorridoHrsExigiblesEval>
		implements RecorridoHrsExigiblesEvalDAO {
	
	
	
	@Override
	public int countRecorridoExigPorPensum(Integer idEvaluacion) {		
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT count(r) FROM RecorridoHrsExigiblesEval r WHERE r.idEvalAcad = ? ");

			
			q.setParameter(1, idEvaluacion);
			Long val= (Long) q.getSingleResult();
			
			return val.intValue();
			
			
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public RecorridoHrsExigiblesEval maxRecHrsExigiblesEval(Integer idEvaluacion) {		
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT max(r) FROM RecorridoHrsExigiblesEval r WHERE r.idEvalAcad = ? ");

			
			q.setParameter(1, idEvaluacion);
			return (RecorridoHrsExigiblesEval) q.getSingleResult();
			
			
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public HorasPeriodoAcademicoDTO llenarHorasPeriodoXEval(RecorridoHrsExigiblesEval recorrido){
		HorasPeriodoAcademicoDTO dto = new HorasPeriodoAcademicoDTO();
		try {
			
			dto.setDedicacion(recorrido.getDedicacion());
			dto.setDiasDescanso(recorrido.getDiasDescanso().intValue());
			dto.setDiasLaborables(recorrido.getDiasLaborables().intValue());
			dto.setDiasPermiso(recorrido.getDiasPermiso().intValue());
			dto.setDiasVacacion(recorrido.getDiasVacacion().intValue());
			dto.setFechaInicioPeriodo(recorrido.getFechaInicio());
			dto.setFechaFinPeriodo(recorrido.getFechaFin());
			dto.setHorasDedicacion(recorrido.getHorasDedicacion().intValue());
			dto.setHorasPeriodoAcademico(recorrido.getHorasExigibles());
			dto.setHorasPermiso(recorrido.getHorasPermiso());
			dto.setHorasVacacion(recorrido.getHorasVacacion());
			dto.setPromedioHorasDiaria(recorrido.getPromedioHoras());
			dto.setTipo(recorrido.getTipo());

			if(dto.getDedicacion().trim().equals("TP")){
				dto.setDedicacionTP(true);
			}else{
				dto.setDedicacionTP(false);
			}
			
			dto.setDiasLabDesc(dto.getDiasLaborables() - dto.getDiasDescanso());
						
			return dto;			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@Override
	public List<RecorridoHrsExigiblesEval>  listRecHrsExigiblesEval(Integer idEvaluacion) {		
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT r FROM RecorridoHrsExigiblesEval r WHERE r.idEvalAcad = ? ORDER BY r.idRecorridoHrsExigiblesEval DESC ");

			
			q.setParameter(1, idEvaluacion);
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	
		
}
