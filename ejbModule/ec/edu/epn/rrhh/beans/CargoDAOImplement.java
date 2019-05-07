
package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;

import ec.edu.epn.rrhh.movimientos.Cargosm;


@Stateless
public class CargoDAOImplement extends DaoGenericoImplement<Cargosm> implements CargoDAO {
	
	@Override
	public List<Cargosm> findCargosActivos() {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam where fam.estado ='activo'");
		Query query = getEntityManager().createQuery(queryString.toString());
		List<Cargosm> resultado = query.getResultList();
		return resultado;	
	}
	
	@Override
	public List<Cargosm> findCargos() {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam where fam.estado is not null ");
		Query query = getEntityManager().createQuery(queryString.toString());
		List<Cargosm> resultado = query.getResultList();
		return resultado;	
	}
	
	@Override
	public List<Cargosm> findCargosAll() {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam");
		Query query = getEntityManager().createQuery(queryString.toString());
		List<Cargosm> resultado = query.getResultList();
		return resultado;	
	}
	
	@Override
	public Integer getMaxId() {
		StringBuilder queryString = new StringBuilder(
				"SELECT max(idCargo) FROM Cargosm fam ");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null)
			return 0;
		else
			return max;
	}
	
	@Override
	public List<Cargosm> findCargosActivosbyGrupo(String grupo) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam where fam.estado ='activo' and fam.grupo =:nombregrupo" );
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("nombregrupo", grupo);
		List<Cargosm> resultado = query.getResultList();
		return resultado;	
	}
	
	@Override
	public List<Cargosm> findCargosbyId(Integer id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam where fam.idCargo =?");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);
		List<Cargosm> resultado = query.getResultList();
		
		return resultado;
	}

	@Override
	public Cargosm findCargoById(Integer id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam where fam.idCargo =?1");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);
		Cargosm resultado = (Cargosm) query.getSingleResult();
		
		return resultado;
	}

	@Override
	public List<Cargosm> findCargosByDedicacionAndCargo(String nivelGrado, String grupo) {
	
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam where fam.estado ='activo'"
				+ "and fam.grupo = ?1 and fam.nombreCargo like ?2");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, grupo);
		query.setParameter(2, "%"+nivelGrado);
		
		List<Cargosm> resultado = query.getResultList();
		
		return resultado;
	}

	@Override
	public List<Cargosm> findCargosByDedicacion(String dedicacion) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam where fam.estado ='activo'"
				+ "and fam.grupo = ?1 and fam.dedicacion = ?2");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "DOCENTE");
		query.setParameter(2, dedicacion);
		
		List<Cargosm> resultado = query.getResultList();
		
		return resultado;
	}

	@Override
	public List<Cargosm> findCargosByGrupo(String grupo) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam where fam.estado ='activo'"
				+ "and fam.grupo = ?1 ");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, grupo);
	
		
		List<Cargosm> resultado = query.getResultList();
		
		return resultado;
	}
	
	
	@Override
	public List<Cargosm> findCargosActivosMigrados() {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Cargosm fam where fam.estado ='activo' or fam.estado = 'migrado' or fam.estado = 'inactivo'");
		Query query = getEntityManager().createQuery(queryString.toString());
		List<Cargosm> resultado = query.getResultList();
		return resultado;	
	}
	
	
}
