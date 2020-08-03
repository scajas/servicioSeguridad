package ec.edu.epn.acreditacion.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.DTO.SubCriterioDetalleDTO;
import ec.edu.epn.acreditacion.entities.SubcriterioDetalle;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class CriterioDAOImplement
 */
@Stateless
@LocalBean
public class SubCriterioDetalleDAOImplement extends DaoGenericoImplement<SubcriterioDetalle> implements SubCriterioDetalleDAO {

	@Override
	public List<SubCriterioDetalleDTO> criterioxIdCriterioCarrera(Integer idCriterioDetalle, Integer idSubCriterioDetalle) {
		Query query = null;
		List<SubCriterioDetalleDTO> subCriterioDetalleDTO = new ArrayList<SubCriterioDetalleDTO>();
		try {
				
			StringBuilder queryString = new StringBuilder(
					"SELECT sd.id_subcr_detalle, s.id_subcr, cd.id_criterio_detalle, s.nom_subcr, s.peso, sd.calificacion_detalle "+
						"FROM \"Acreditacion\".subcriterio_detalle sd, \"Acreditacion\".criterio_detalle cd, \"Acreditacion\".subcriterio s "+
						"WHERE cd.id_criterio_detalle= sd.id_criterio_detalle "+
						"AND sd.id_subcr= s.id_subcr "+
						"AND cd.id_criterio_detalle=? "+
						"AND (sd.id_subcr_detalle= ? OR ?=0)");
			query = getEntityManager().createNativeQuery(queryString.toString());
			query.setParameter(1, idCriterioDetalle);
			query.setParameter(2, idSubCriterioDetalle);
			query.setParameter(3, idSubCriterioDetalle);
			
			
			List<?> listsDTOCriterio = query.getResultList();
			
			if (!listsDTOCriterio.isEmpty()) {
				for (Object list : listsDTOCriterio) {
					SubCriterioDetalleDTO dto = new SubCriterioDetalleDTO();
					Object[] fila = (Object[]) list;		
					
					dto.setIdSubCriterioDetalle(Integer.valueOf(fila[0].toString()));
					dto.setIdSubCriterio(Integer.valueOf(fila[1].toString()));
					dto.setIdCriterioDetalle(Integer.valueOf(fila[2].toString()));
					dto.setNombreSubCriterio(fila[3].toString());
					dto.setPeso(fila[4]==null?0.0:Double.valueOf(fila[4].toString()));					
					dto.setCalificacion(Double.valueOf(fila[5].toString()));
					
					subCriterioDetalleDTO.add(dto);
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return subCriterioDetalleDTO;
	}

}
