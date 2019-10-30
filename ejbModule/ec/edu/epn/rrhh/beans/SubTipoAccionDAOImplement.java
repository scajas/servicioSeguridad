package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;
import ec.edu.epn.rrhh.movimientos.SubtipoAccion;

@Stateless
public class SubTipoAccionDAOImplement extends DaoGenericoImplement<SubtipoAccion> implements SubTipoAccionDAO {

	@Override
	public SubtipoAccion findSubTipoAccionPorNombre(String nombreSubTipoAccion) {

		StringBuilder queryString = new StringBuilder(
				"Select sta from SubtipoAccion sta where TRIM(sta.nombreSubaccion) like ?1 "
						+ "order by sta.idStpa asc  ");
		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, nombreSubTipoAccion);
		List<SubtipoAccion> resultados;
		SubtipoAccion resultado;
		try{
			resultado = (SubtipoAccion) query.getSingleResult();
		}catch(NonUniqueResultException e){
			resultados = query.getResultList();
			return resultados.get(0);
		}

		return resultado;
	}
	
	@Override
	public List<SubtipoAccion> getAllSubtipoRectificaciones(){
		StringBuilder queryString = new StringBuilder(
				"Select sta from SubtipoAccion " + "sta where sta.nombreSubaccion like ?1)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "RECTIFICACION%");

		List<SubtipoAccion> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<SubtipoAccion> findSubTipoAccionPorAccion(String nombreAccion) {

		StringBuilder queryString = new StringBuilder(
				"  Select sta from SubtipoAccion sta where sta.tipoAccion.nombreAccion like ?1 "
				+ " and sta.idStpa not in (select stac.idStpa from SubtipoAccion stac where "
				+ " (stac.nombreSubaccion like 'RECTIFICACI%' or stac.idStpa in (47,416, 330, 331, 332,333,329"
				+ ", 336,376,337,338))) ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreAccion);

		List<SubtipoAccion> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public int findIdSubTipoAccionPorNombre(String nombreSubTipoAccion) {
		StringBuilder queryString = new StringBuilder(
				"Select sta from SubtipoAccion " + "sta where sta.nombreSubaccion like ?1 "
				+ "and sta.idStpa not in (select stac.idStpa from SubtipoAccion stac where "  
				+ "stac.nombreSubaccion like 'RECTIFICACI%')");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreSubTipoAccion);
		SubtipoAccion resultado = null;
		try {
			resultado = (SubtipoAccion) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int idSubTipoAccion = -1;
		if (resultado != null) {
			idSubTipoAccion = resultado.getIdStpa();
		}

		return idSubTipoAccion;
	}

	@Override
	public SubtipoAccion findSubtipoByID(Integer stpId) {
		StringBuilder queryString = new StringBuilder("Select sta from SubtipoAccion " + "sta where sta.idStpa=:id ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("id", stpId);
		SubtipoAccion resultado = null;
		try {
			resultado = (SubtipoAccion) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public SubtipoAccion  findSubTipoAccionPorNombreYTipo(String nombreSubTipoAccion, String tipoAccion) {
		StringBuilder queryString = new StringBuilder("Select sta from SubtipoAccion "
				+ "sta where sta.nombreSubaccion like ?1" + " and sta.tipoAccion.nombreAccion = ?2");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreSubTipoAccion);
		query.setParameter(2, tipoAccion);
		
		SubtipoAccion resultado = null; 
		try{
			resultado = (SubtipoAccion) query.getSingleResult();
		}catch (NonUniqueResultException e){
			resultado = (SubtipoAccion) query.getResultList().get(0);
		}

		return resultado;
	}

	@Override
	public List<SubtipoAccion> findAccionesAdministrablesPlantilla() {
		StringBuilder queryString = new StringBuilder(
				"Select sta from SubtipoAccion " 
		      + "sta where (sta.idStpa between 1 and 100) or "
		      + " sta.idStpa = 269 or sta.idStpa = 278 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		List<SubtipoAccion> resultado = query.getResultList();
		return resultado;
	}

	@Override
	public List<SubtipoAccion> getAllAccionesSinRegistro() {
		StringBuilder queryString = new StringBuilder(
				"Select sta from SubtipoAccion " 
		      + "sta where sta.tipoAccion.idTpa in (413,414,415,416)");
		Query query = getEntityManager().createQuery(queryString.toString());
		List<SubtipoAccion> resultado = query.getResultList();
		return resultado;
	}




}
