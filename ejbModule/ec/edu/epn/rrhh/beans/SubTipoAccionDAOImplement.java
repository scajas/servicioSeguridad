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
				"Select sta from SubtipoAccion " + "sta where TRIM(sta.nombreSubaccion) like ?1) ");
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
	public List<SubtipoAccion> findSubTipoAccionPorAccion(String nombreAccion) {

		StringBuilder queryString = new StringBuilder(
				"Select sta from SubtipoAccion " + "sta where sta.tipoAccion.nombreAccion like ?1)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreAccion);

		List<SubtipoAccion> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public int findIdSubTipoAccionPorNombre(String nombreSubTipoAccion) {
		StringBuilder queryString = new StringBuilder(
				"Select sta from SubtipoAccion " + "sta where sta.nombreSubaccion like ?1)");
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
		StringBuilder queryString = new StringBuilder("Select sta from SubtipoAccion " + "sta where sta.idStpa=:id)");
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
			e.printStackTrace();
			resultado = (SubtipoAccion) query.getResultList().get(0);
		}

		return resultado;
	}
}
