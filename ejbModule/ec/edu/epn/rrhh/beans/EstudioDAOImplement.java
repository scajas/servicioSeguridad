/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Estudio;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EstudioDAOImplement extends DaoGenericoImplement<Estudio> implements EstudioDAO {

	@Override
	public int consultarIdEstudios() {

		Query q = getEntityManager().createQuery("SELECT MAX(seg.idestudios)FROM Estudio seg");

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudio> listaEstudioXcedula(String cedula) {
		Query q = getEntityManager().createQuery("Select est from Estudio est where est.emp.nced like ?1");
		q.setParameter(1, cedula + "%");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudio> findEstudiosByParams(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT est FROM Estudio est WHERE est.nced =?0 ORDER BY est.idestudios");

		if (nced == "") {
			return null;
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		if (nced != "") {
			query.setParameter(0, nced);
		}

		return query.getResultList();
	}

	@Override
	public boolean validarEstudios(String titulo, String cedula, String nivel, String institucion) {
		boolean verificar = false;
		Query q = getEntityManager().createQuery(
				"select e from Estudio e where  e.titulo = ?1 and   e.emp.nced = ?2 and   e.nivelestudios = ?3 and  e.institucion = ?4 ");
		q.setParameter(1, titulo);
		q.setParameter(2, cedula);
		q.setParameter(3, nivel);
		q.setParameter(4, institucion);

		if (q.getResultList().isEmpty())
			verificar = false;
		else
			verificar = true;

		return verificar;
	}
}
