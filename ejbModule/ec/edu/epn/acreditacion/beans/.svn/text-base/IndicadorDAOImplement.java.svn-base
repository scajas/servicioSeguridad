package ec.edu.epn.acreditacion.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.DTO.IndicadorDetalleDTO;
import ec.edu.epn.acreditacion.DTO.SubCriterioDetalleDTO;
import ec.edu.epn.acreditacion.entities.Indicador;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class IndicadorDAOImplement
 */
@Stateless
@LocalBean
public class IndicadorDAOImplement extends DaoGenericoImplement<Indicador> implements IndicadorDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Indicador> listIndicadoresxIdSubCriterio(Integer idSubCriterio) throws Exception{
		
		Query q = getEntityManager().createQuery(
				"SELECT i FROM Indicador i WHERE i.subcriterio.idSubcr = ?1");
		q.setParameter(1, idSubCriterio);
		return q.getResultList();
		
	}
	
	
	@Override
	public List<IndicadorDetalleDTO> indicadorDTOxIdSubCriAndCriDetalle(Integer idCriterioDetalle, Integer idSubcriterio) {
		Query query = null;
		List<IndicadorDetalleDTO> listIndicadorDetalleDTO = new ArrayList<IndicadorDetalleDTO>();
		try {
				
			StringBuilder queryString = new StringBuilder(
					"SELECT id.id_indet, i.id_indi, sd.id_subcr_detalle, i.tipo, i.nom_indi, i.peso, id.resultado "+
							"FROM \"Acreditacion\".subcriterio_detalle sd, \"Acreditacion\".criterio_detalle cd, "+ 
							"\"Acreditacion\".subcriterio s, \"Acreditacion\".indicador i, \"Acreditacion\".indicador_detalle id "+
							"WHERE cd.id_criterio_detalle= sd.id_criterio_detalle "+
							"AND sd.id_subcr= s.id_subcr "+
							"AND s.id_subcr= i.id_subcr "+
							"AND i.id_indi= id.id_indi "+
							"AND id.id_subcr_detalle=sd.id_subcr_detalle "+
							"AND cd.id_criterio_detalle= ?"+
							"AND s.id_subcr=?");
			query = getEntityManager().createNativeQuery(queryString.toString());
			query.setParameter(1, idCriterioDetalle);
			query.setParameter(2, idSubcriterio);
			
			
			List<?> listsDTOIndicador = query.getResultList();
			
			if (!listsDTOIndicador.isEmpty()) {
				for (Object list : listsDTOIndicador) {
					IndicadorDetalleDTO dto = new IndicadorDetalleDTO();
					Object[] fila = (Object[]) list;				
					
					dto.setIdIndicadorDetalle(Integer.valueOf(fila[0].toString()));
					dto.setIdIndicador(Integer.valueOf(fila[1].toString()));
					dto.setIdSubCriterioDetalle(Integer.valueOf(fila[2].toString()));
					dto.setTipo(fila[3].toString());
					dto.setNombreIndicador(fila[4].toString());
					dto.setPeso(Double.valueOf(fila[5].toString()));
					dto.setCalificacion(Double.valueOf(fila[6].toString()));
					
					listIndicadorDetalleDTO.add(dto);
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listIndicadorDetalleDTO;
	}
	
	
	
	

}
