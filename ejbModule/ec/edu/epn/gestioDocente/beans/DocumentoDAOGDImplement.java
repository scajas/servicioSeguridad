package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.DocumentoGD;

/**
 * Session Bean implementation class DocumentoDAOGDImplement
 */
@Stateless
@LocalBean
public class DocumentoDAOGDImplement extends DaoGenericoImplement<DocumentoGD> implements DocumentoDAOGD {

	@Override
	public List<DocumentoGD> buscarDocumentoExiste(Integer idPublic, Integer idEstado) throws Exception {

		StringBuilder queryString = new StringBuilder("SELECT s from DocumentoGD s where s.idevidencia = ?1 ");

		if (idEstado != 0) {
			queryString.append(" and s.tipodocumento.idtipo =?2 ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idPublic);

		if (idEstado != 0) {
			query.setParameter(2, idEstado);
		}

		return query.getResultList();
	}
	
	@Override
	public int maxIdDocumento() {

		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.iddocumento) FROM DocumentoGD p");
		Integer idPagosV = null;

		try {
			idPagosV = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPagosV = null;
		}
		if (idPagosV == null) {
			idPagosV = 1;
		} else {
			++idPagosV;
		}
		return idPagosV;
	}

}
