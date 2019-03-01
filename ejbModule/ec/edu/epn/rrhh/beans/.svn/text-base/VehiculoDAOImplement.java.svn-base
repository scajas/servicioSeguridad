package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Vehiculo;

@Stateless
public class VehiculoDAOImplement extends DaoGenericoImplement<Vehiculo> implements VehiculoDAO {

	@Override
	public int consultarIdVehiculo() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery("SELECT MAX(seg.id)FROM Vehiculo seg");

		Integer idReq = null;
		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findVehiculo(String nced, String placa) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Vehiculo fam where fam.emp.nced = ?0 and fam.placa = ?1  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, placa.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findVehiculo1(String nced) {
		StringBuilder queryString = new StringBuilder("SELECT fam FROM Vehiculo fam where fam.emp.nced = ?0   ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findVehiculo2(String nced) {
		StringBuilder queryString = new StringBuilder("SELECT fam FROM Vehiculo fam where fam.cedulaext = ?0   ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findVehiculo3(String nced, String placa) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Vehiculo fam where fam.cedulaext = ?0 and fam.placa = ?1  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter(1, placa.trim());

		return query.getResultList();

	}
}
