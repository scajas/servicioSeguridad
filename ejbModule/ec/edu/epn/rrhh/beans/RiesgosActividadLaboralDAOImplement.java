package ec.edu.epn.rrhh.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.RiesgoActividad;
import ec.edu.epn.rrhh.entities.RiesgosLaborale;
import ec.edu.epn.rrhh.movimientos.AccionP;

@Stateless
public class RiesgosActividadLaboralDAOImplement extends DaoGenericoImplement<RiesgoActividad> implements RiesgoActividadLaboralDAO {
			
	@Override
	public Integer getMaxId() {
		StringBuilder queryString = new StringBuilder("SELECT max(t.idActividad) FROM RiesgoActividad t");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null)
			return 0;
		else
			return max;
	
	}

}
