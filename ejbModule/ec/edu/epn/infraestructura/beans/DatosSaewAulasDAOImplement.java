/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.DatosSaewAula;

/**
 * @author Administrador
 * 
 */
@Stateless
public class DatosSaewAulasDAOImplement extends
		DaoGenericoImplement<DatosSaewAula> implements DatosSaewAulasDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(dat.idDatosSaewaulas)FROM DatosSaewAula dat");
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

	@Override
	public List<DatosSaewAula> listadeFacultades(int codfacu) {
		StringBuilder queryString = new StringBuilder(
				"SELECT dl FROM DatosSaewAula dl where dl.idCarrera = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, codfacu);
		return query.getResultList();
	}

	@Override
	public List<DatosSaewAula> listaDatosAulas(int codcarrera,
			String codmateria, String paralelo) {

		StringBuilder queryString = new StringBuilder(
				"SELECT dl FROM DatosSaewAula dl where dl.idCarrera = ?1 and dl.idMateria = ?2 and dl.idCursoParalelo = ?3");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, codcarrera);
		query.setParameter(2, codmateria);
		query.setParameter(3, paralelo);
		System.out.println("TAMÑAO LISTA: " + query.getResultList().size());
		return query.getResultList();
	}

}
