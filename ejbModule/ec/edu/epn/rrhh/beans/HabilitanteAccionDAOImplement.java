package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.movimientos.Dependencia;
import ec.edu.epn.rrhh.movimientos.Designacion;
import ec.edu.epn.rrhh.movimientos.HabilitanteAccion;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;

@Stateless
public class HabilitanteAccionDAOImplement extends DaoGenericoImplement<HabilitanteAccion>
		implements HabilitanteAccionDAO {

	@Override
	public List<HabilitanteAccion> findAllHabilitantesAccion() {
		StringBuilder queryString = new StringBuilder("SELECT fam FROM HabilitanteAccion fam ");

		Query query = getEntityManager().createQuery(queryString.toString());

		List<HabilitanteAccion> resultados = query.getResultList();

		return resultados;
	}

}
