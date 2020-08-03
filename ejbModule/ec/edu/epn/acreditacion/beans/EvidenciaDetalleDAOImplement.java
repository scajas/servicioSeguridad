package ec.edu.epn.acreditacion.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.DTO.EvidenciaDetalleDTO;
import ec.edu.epn.acreditacion.DTO.SubCriterioDetalleDTO;
import ec.edu.epn.acreditacion.entities.EvidenciaDetalle;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Evidencia;

/**
 * Session Bean implementation class EvidenciaDetalleDAOImplement
 */
@Stateless
@LocalBean
public class EvidenciaDetalleDAOImplement extends DaoGenericoImplement<EvidenciaDetalle> implements EvidenciaDetalleDAO {

	
	@Override
	public EvidenciaDetalle findEvidenciaBYCarrea(String cod_carrera, Integer idmodelo) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM EvidenciaDetalle e where e.idCarrera = ?0 and e.evidencia.idEvid = ?1  order by e.idEvidet");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, cod_carrera);
		query.setParameter(1, idmodelo);
		query.setMaxResults(1);

		try {
			EvidenciaDetalle evi = (EvidenciaDetalle) query.getSingleResult();
			return evi;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public int maxEvidencia() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idEvidet) FROM EvidenciaDetalle p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

	@Override
	public List<EvidenciaDetalle> findAllEvidenciaBYCarrea(String cod_carrera, Integer idmodelo) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM EvidenciaDetalle e where e.idCarrera = ?0 and e.evidencia.idEvid = ?1  order by e.id ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, cod_carrera);
		query.setParameter(1, idmodelo);
		return query.getResultList();

	}
	
	
	@Override
	public Long countEvidDetXPensumXCarrera(String idCarrera, Integer idPensum, Integer idEvidencia) {
		StringBuilder querys = new StringBuilder(
				"SELECT count(e) FROM EvidenciaDetalle e WHERE e.idCarrera = ?0 AND e.evidencia.idEvid = ?1 AND e.idPensum=?2");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, idCarrera);
		query.setParameter(1, idEvidencia);
		query.setParameter(2, idPensum);
		
		return (Long) query.getSingleResult();

	}
	
	
	@Override
	public List<EvidenciaDetalleDTO> listEvDetalleXPensumXCarrera (String codIndicador, Integer idPensum, String codCarrera){		
		Query query = null;
		List<EvidenciaDetalleDTO> listDetEvidencia= new ArrayList<EvidenciaDetalleDTO>();
		
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT e.id_evid, et.id_evidet, et.id_carrera, et.id_pensum, e.nom_evid, e.descr_evid, et.calificacion, et.observ_evid, et.existencia "+
					"FROM \"Acreditacion\".evidencia e, \"Acreditacion\".evidencia_detalle et "+
					"WHERE e.id_evid= et.id_evid "+
					"AND e.cod_evid like CONCAT (? , '%') "+
					"AND et.id_pensum= ? "+
					"AND et.id_carrera=? ");
			query = getEntityManager().createNativeQuery(queryString.toString());
			query.setParameter(1, codIndicador);
			query.setParameter(2, idPensum);
			query.setParameter(3, codCarrera);
			
			
			List<?> listsDTOEvidDetalle = query.getResultList();
			
			if (!listsDTOEvidDetalle.isEmpty()) {
				for (Object list : listsDTOEvidDetalle) {
					EvidenciaDetalleDTO dto = new EvidenciaDetalleDTO();
					Object[] fila = (Object[]) list;
					
					dto.setIdEvidencia(Integer.valueOf(fila[0].toString()));
					dto.setIdEvidenciaDetalle(Integer.valueOf(fila[1].toString()));
					dto.setIdCarrera(fila[2].toString());
					dto.setIdPensum(Integer.valueOf(fila[3].toString()));
					dto.setNombreEvidencia(fila[4]==null?"":fila[4].toString());
					dto.setDescripcion(fila[5]==null?"":fila[5].toString());
					dto.setCalificacion(Double.valueOf(fila[6]==null?"0.0":fila[6].toString()));
					dto.setObservacion(fila[7]==null?"":fila[7].toString());
					dto.setExistencia(fila[8]==null?"":fila[8].toString());
					
					listDetEvidencia.add(dto);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listDetEvidencia;
		
		
	}
    

}
