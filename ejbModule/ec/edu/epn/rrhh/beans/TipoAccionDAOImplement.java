package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;
import ec.edu.epn.rrhh.movimientos.SubtipoAccion;
import ec.edu.epn.rrhh.movimientos.TipoAccion;

@Stateless
public class TipoAccionDAOImplement extends DaoGenericoImplement<TipoAccion> implements TipoAccionDAO {

	@Override
	public SubtipoAccion findSubTipoAccionPorNombre(String nombreSubTipoAccion) {

		StringBuilder queryString = new StringBuilder(
				"Select sta from SubtipoAccion " + "sta where sta.nombreSubaccion=?1)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreSubTipoAccion);

		SubtipoAccion resultado = (SubtipoAccion) query.getSingleResult();

		return resultado;
	}
	
	@Override
	public List<TipoAccion> findSubTipoAccionPorAccion(String nombreAccion) {

		StringBuilder queryString = new StringBuilder(
				"Select sta from TipoAccion " + "sta where sta.nombreAccion=?1)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreAccion);

		List<TipoAccion> resultado =  query.getResultList();

		return resultado;
	}

	@Override
	public int findIdSubTipoAccionPorNombre(String nombreSubTipoAccion) {
		StringBuilder queryString = new StringBuilder(
				"Select sta from SubtipoAccion " + "sta where sta.nombreSubaccion=?1)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreSubTipoAccion);
		SubtipoAccion resultado = null;
		try {
			resultado = (SubtipoAccion) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int idSubTipoAccion=-1;
		if (resultado != null) {
			idSubTipoAccion = resultado.getIdStpa();
		}

		return idSubTipoAccion;
	}

	@Override
	public List<TipoAccion> getAccionesFiltrables() {
		
		StringBuilder queryString = new StringBuilder(
				"Select sta from TipoAccion " + "sta where sta.esFiltrable is true)");
		Query query = getEntityManager().createQuery(queryString.toString());
		List<TipoAccion> resultado =  query.getResultList();
		return resultado;
	}

}
