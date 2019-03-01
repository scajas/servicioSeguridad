package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.Laboratorio;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Emp;

/**
 * Session Bean implementation class LaboratorioCDAOImplement
 */
@Stateless
@LocalBean
public class LaboratorioCDAOImplement extends DaoGenericoImplement<Laboratorio> implements LaboratorioCDAO {

	/**
	 * Default constructor.
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Laboratorio> findLaboByDepartamento(String coddep, String tipo, String v1, String v2, String v3) {

		StringBuilder queryString = new StringBuilder(
				"SELECT d FROM LaboratorioCatalogo d where  d.nombreUsuario like ?0  ");

		if (coddep != null) {
			queryString.append(" and d.departamento.codDep like ?1 ");
		}

		if (tipo != null) {
			queryString.append(" and d.tipo = ?2 ");
		}

		if (v1 != null) {
			queryString.append(" and d.docencia = ?3 ");
		}
		if (v2 != null) {
			queryString.append(" and d.servicios = ?4 ");
		}
		if (v3 != null) {
			queryString.append(" and d.investigacion = ?5 ");
		}
		queryString.append(" order by d.nombreL ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, "%");

		if (coddep != null) {
			query.setParameter(1, "%" + coddep + "%");
		}

		if (tipo != null) {
			query.setParameter(2, tipo);
		}

		if (v1 != null) {
			query.setParameter(3, v1);
		}
		if (v2 != null) {
			query.setParameter(4, v2);
		}
		if (v3 != null) {
			query.setParameter(5, v3);
		}
		return query.getResultList();
	}

}
