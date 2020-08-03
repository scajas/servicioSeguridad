package ec.edu.epn.rrhh.beans;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;
import ec.edu.epn.rrhh.movimientos.Nominacion;

@Stateless
public class NominacionDAOImplement extends DaoGenericoImplement<Nominacion> implements NominacionDAO {

	@Override
	public List<Nominacion> findHistoriaByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM Nominacion fam where " + "fam.emp.nced =?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		List<Nominacion> resultado = query.getResultList();

		return resultado;

	}

	@Override
	public long getMaxNominacion() {
		StringBuilder queryString = new StringBuilder(
				"SELECT COUNT(d) FROM Nominacion d");// TODO Auto-generated method stub
		Query query = getEntityManager().createQuery(queryString.toString());
		return (long)query.getSingleResult();
	}
	
}
