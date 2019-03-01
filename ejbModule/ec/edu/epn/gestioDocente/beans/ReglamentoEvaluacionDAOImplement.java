package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.DTO.CatalogoActividadesDTO;
import ec.edu.epn.gestionDocente.entities.ReglamentoEvaluacion;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class ReglamentoEvaluacionDAOImplement extends DaoGenericoImplement<ReglamentoEvaluacion>
		implements ReglamentoEvaluacionDAO {

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoActividadesDTO> listReglamentoActvXTipo(Integer tipoActvEval) throws Exception {
		List<CatalogoActividadesDTO> listCatalogo= new ArrayList<CatalogoActividadesDTO>();
		List<ReglamentoEvaluacion> listReglamento= new ArrayList<ReglamentoEvaluacion>();
		Query q = getEntityManager()
				.createQuery(
						"SELECT r FROM ReglamentoEvaluacion r WHERE r.idTipoActvEval= ? ORDER BY idReglamentoEvaluacion");
		
		q.setParameter(1, tipoActvEval);
		
		listReglamento= q.getResultList();
		
		if(!listReglamento.isEmpty()){
			for(ReglamentoEvaluacion dto: listReglamento){
				CatalogoActividadesDTO catalogoActividadesDTO= new CatalogoActividadesDTO();
				catalogoActividadesDTO.setActividad(dto.getActividad());
				catalogoActividadesDTO.setAsignacionHoras(dto.getAsignacionHoras());
				catalogoActividadesDTO.setIdTipoActvEval(dto.getIdTipoActvEval());
				catalogoActividadesDTO.setIdReglamentoEvaluacion(dto.getIdReglamentoEvaluacion());
				catalogoActividadesDTO.setValor(0.0);
				catalogoActividadesDTO.setCumplimiento(100.00);
				catalogoActividadesDTO.setAsignar(false);				
				listCatalogo.add(catalogoActividadesDTO);
			}
		}
		
		return listCatalogo;
	}
}
