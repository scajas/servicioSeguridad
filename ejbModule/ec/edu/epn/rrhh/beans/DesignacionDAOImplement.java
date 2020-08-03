package ec.edu.epn.rrhh.beans;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.movimientos.Designacion;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;

@Stateless
public class DesignacionDAOImplement extends DaoGenericoImplement<Designacion> implements DesignacionDAO {

	@Override
	public Integer getMaxID() {
		StringBuilder queryString = new StringBuilder("SELECT max(t.idDesignacion) FROM Designacion t");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null) {
			return 0;
		}
		return max;
	}

	@Override
	public Designacion findDesignacionByTipoAndEstado(String dignidad, String estado, String tipoDesignacion) {
		
		StringBuilder queryString = new StringBuilder
				("SELECT desi from Designacion desi where "
						+ " desi.designacionCatalogo.nombre =?1 "
						+ " and desi.estado = ?2   "
						+ " and desi.tipoDesignacion = ?3 order by "
						+ " desi.fechaInicio desc ");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, dignidad);
		query.setParameter(2, estado);
		query.setParameter(3, tipoDesignacion);
		Designacion resultado=null;
		try{
			resultado = (Designacion) query.getSingleResult();
		}catch (NoResultException e){
			return resultado;
		}catch (NonUniqueResultException e){
			System.out.println("Más de un "+ tipoDesignacion +" activo ....");
			return (Designacion) query.getResultList().get(0);
		}
			
		return resultado;
	}

	

}
