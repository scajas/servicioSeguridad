package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.RiesgosLaborale;
import ec.edu.epn.rrhh.movimientos.SubtipoAccion;

@Stateless
public class RiesgosLaboraleDAOImplement extends DaoGenericoImplement<RiesgosLaborale> implements RiesgosLaboraleDAO {

	@Override
	public Integer getMaxId() {
		StringBuilder queryString = new StringBuilder("SELECT max(t.idRiesgo) FROM RiesgosLaborale t");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null)
			return 0;
		else
			return max;
	
	}
	
	@Override
	public List<RiesgosLaborale> findRiesgoxEmp(String cedula) {
		
		StringBuilder queryString = new StringBuilder(
				"Select sta from RiesgosLaborale " + "sta where sta.emp.nced = :cedula)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("cedula", cedula);

		List<RiesgosLaborale> resultado = query.getResultList();

		return resultado;
	}
				

}
