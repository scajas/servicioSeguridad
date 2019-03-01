package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.DesignacionCatalogo;

@Stateless
public class DesignacionCatalogoDAOImplement extends DaoGenericoImplement<DesignacionCatalogo>
		implements DesignacionCatalogoDAO {

	@Override
	public List<DesignacionCatalogo> findAllDesignacionesActivas() {
		StringBuilder queryString = new StringBuilder("Select dc from DesignacionCatalogo " + "dc where dc.estado =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "activo");

		return query.getResultList();

	}

	@Override
	public List<DesignacionCatalogo> findDesignacionActivasByGrupo(String grupoDesignacion) {
		StringBuilder queryString = new StringBuilder(
				"Select dc from DesignacionCatalogo " + "dc where dc.estado =?1 and dc.grupoDesignacion = ?2");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "activo");
		query.setParameter(2, grupoDesignacion);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DesignacionCatalogo> findAllDesignaciones() {
		StringBuilder queryString = new StringBuilder(
				"Select dc from DesignacionCatalogo dc where dc.estado is not null");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public int getMaxIDDesignacionCatalogo() {
		StringBuilder queryString = new StringBuilder("Select max(dc.idCatalogo) from DesignacionCatalogo dc");
		Query query = getEntityManager().createQuery(queryString.toString());

		return (int) query.getSingleResult();
	}

}
