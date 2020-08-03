package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Actividades;
import ec.edu.epn.contratos.entities.CargaAcademica;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



public @Stateless
class CargaAcademicaDAOImplement extends DaoGenericoImplement<CargaAcademica>
implements CargaAcademicaDAO {



	@SuppressWarnings("unchecked")
	@Override
	public List<CargaAcademica> findCargaAcadByParams(int nced) {
		System.out.println("Carga");
		StringBuilder queryString = new StringBuilder(
				"SELECT c FROM CargaAcademica c WHERE c.pedido.idPedido =?0 ORDER BY c.idCarga");

		if (nced == 0) {
			return null;
		}

		Query query = getEntityManager().createQuery(queryString.toString());

		if (nced != 0) {
			query.setParameter(0, nced);
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CargaAcademica> findCargaAcadRmu(int idPed) {
		System.out.println("Carga RMU");

		StringBuilder queryString = new StringBuilder(
				"SELECT SUM(c.numHorasSemana) FROM CargaAcademica c WHERE c.pedido.idPedido =?0 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		if (idPed != 0) {
			query.setParameter(0, idPed);
		}

		return query.getResultList();
	}

	@Override
	public long numHorasRmu(int idPed) {
		System.out.println("Carga RMU");

		StringBuilder queryString = new StringBuilder(
				"SELECT SUM(c.numHorasSemana) FROM CargaAcademica c WHERE c.pedido.idPedido =?0 ");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (idPed != 0) {
			query.setParameter(0, idPed);
		}

		return (Long) query.getSingleResult();

	}

}
