package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Familiare;

@Stateless
public class FamiliaresDAOImplement extends DaoGenericoImplement<Familiare> implements FamiliaresDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Familiare> listaXCedulaEmp(String cedula) {
		Query q = getEntityManager().createQuery("Select f from Familiare f where f.emp.nced = ?1");
		q.setParameter(1, cedula);
		return q.getResultList();
	}

	@Override
	public int consultarIdFamiliar() {

		Query q = getEntityManager().createQuery("SELECT MAX(seg.idFamiliar)FROM Familiare seg");

		Integer idReq = null;
		try {
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
		return idReq;

	}
}
