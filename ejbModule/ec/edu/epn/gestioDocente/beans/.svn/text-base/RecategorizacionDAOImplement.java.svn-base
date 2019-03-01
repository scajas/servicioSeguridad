package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.CategoriasD;
import ec.edu.epn.gestionDocente.entities.Recategorizacion;

/**
 * Session Bean implementation class RecategorizacionDAOImplement
 */
@Stateless
@LocalBean
public class RecategorizacionDAOImplement extends DaoGenericoImplement<Recategorizacion>
		implements RecategorizacionDAO {

	@Override
	public CategoriasD buscarCategoriaSELECT(int idcategoria) throws Exception {
		StringBuilder queryString = new StringBuilder("SELECT s from CategoriasD s  where s.idCat = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idcategoria);
		return (CategoriasD) query.getSingleResult();
	}

	@Override
	public List<Recategorizacion> buscarRecExiste(String nced,

			String categoria, String proceso, String estado) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Recategorizacion s where s.nced = ?1 and s.categoria = ?2 and s.proceso = ?3 ");

		if (estado != null) {
			queryString.append("and s.estado = ?4");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nced);
		query.setParameter(2, categoria);
		query.setParameter(3, proceso);

		queryString.append("order by s.fechae");

		if (estado != null) {
			query.setParameter(4, estado);
		}

		return query.getResultList();
	}

	@Override
	public List<CategoriasD> buscarCategorias(Integer serie) throws Exception {
		StringBuilder queryString = new StringBuilder("SELECT s from CategoriasD s where s.serie = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, serie);
		return query.getResultList();
	}

	@Override
	public int maxCodRecategorizacion() {
		Query q = getEntityManager().createQuery("SELECT MAX(p.idRec) FROM Recategorizacion p");
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

}
