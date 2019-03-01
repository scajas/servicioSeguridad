package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Infoactividad;

/**
 * Session Bean implementation class InfoactividadDAOImplement
 */
@Stateless
@LocalBean
public class InfoactividadDAOImplement extends DaoGenericoImplement<Infoactividad> implements InfoactividadDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Infoactividad> consultarinformes(String cedula, String proceso,
			String categoria, Integer idrecategorizacion) {

		StringBuilder queryString = new StringBuilder(
				"select  inf from Infoactividad inf  where inf.nced = ?0  and inf.proceso =?1 and inf.categoria = ?2 ");

		if (idrecategorizacion != 0) {
			queryString.append(" and inf.idrecategoriza = ?3 ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, cedula);
		query.setParameter(1, proceso);
		query.setParameter(2, categoria);

		if (idrecategorizacion != 0) {
			query.setParameter(3, idrecategorizacion);
		}

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	@Override
	public int maxInfor() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.id) FROM Infoactividad p");
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
