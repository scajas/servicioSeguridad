package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.silabo.entities.Bibliografia;
import ec.edu.epn.silabo.entities.BibliografiaPea;

/**
 * Session Bean implementation class BibliografiaPEADAOImplement
 */
@Stateless
@LocalBean
public class BibliografiaPEADAOImplement extends DaoGenericoImplement<BibliografiaPea> implements BibliografiaPEADAO {

	@Override
	public List<BibliografiaPea> consultarBilbiografia(Integer idpea, String tipo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From BibliografiaPea e where e.pea.idPea = ?1  and e.tipob = ?2 order by e.idBibliografia");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idpea);
		query.setParameter(2, tipo.trim());

		return query.getResultList();

	}

	@Override
	public List<BibliografiaPea> consultarBilbiografiaExiste(Integer idpea, String tipo, String titulo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From BibliografiaPea e where e.pea.idPea = ?1  and e.tipob = ?2 and e.titulo = ?3 order by e.idBibliografia");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idpea);
		query.setParameter(2, tipo.trim());
		query.setParameter(3, titulo);

		return query.getResultList();

	}

}
