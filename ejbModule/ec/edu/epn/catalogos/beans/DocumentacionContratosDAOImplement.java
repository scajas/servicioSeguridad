/**
 * 
 */
package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.DocumentacionContratacionDocente;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Administrador
 * 
 */
@Stateless
public class DocumentacionContratosDAOImplement extends
		DaoGenericoImplement<DocumentacionContratacionDocente> implements
		DocumentacionContratosDAO {

	@Override
	public List<DocumentacionContratacionDocente> listaDocumentosXTipo(
			String idTipoDoc) {
		Query q = getEntityManager()
				.createQuery(
						"Select doc from DocumentacionContratacionDocente doc where doc.tipoDoc = ?1 ");
		q.setParameter(1, idTipoDoc);
		return q.getResultList();
	}

}
