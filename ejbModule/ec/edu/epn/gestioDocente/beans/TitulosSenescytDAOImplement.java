package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Nosenescyt;
import ec.edu.epn.gestionDocente.entities.TitulosSenescyt;

/**
 * Session Bean implementation class NivelDAOImplement
 */
@Stateless
@LocalBean
public class TitulosSenescytDAOImplement extends DaoGenericoImplement<TitulosSenescyt> implements TitulosSenescytDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<TitulosSenescyt> findTitulosSenescyt(String cedula, String regSenescyt) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM TitulosSenescyt fam where fam.cedula = ?0 and fam.registroSenescyt = ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, cedula);
		query.setParameter(1, regSenescyt);
		return query.getResultList();

	}

	@Override
	public int consultarIdtitulo() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery("SELECT MAX(seg.id)FROM TitulosSenescyt seg");

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

	@Override
	public int consultarIdNosenescyt() {

		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery("SELECT MAX(seg.id)FROM Nosenescyt seg");

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

	@Override
	public void insernosenescyt(Nosenescyt snc) {

		getEntityManager().persist(snc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TitulosSenescyt> TitulosSenescyt(String cedula) {
		StringBuilder queryString = new StringBuilder("SELECT fam FROM TitulosSenescyt fam where fam.cedula = ?0  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, cedula);

		return query.getResultList();

	}

}
