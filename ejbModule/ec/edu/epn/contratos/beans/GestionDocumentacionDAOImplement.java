/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.DocumentacionContratacionDocente;
import ec.edu.epn.contratos.entities.GestionDocumentacionSolicitada;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class GestionDocumentacionDAOImplement extends DaoGenericoImplement<GestionDocumentacionSolicitada>
		implements GestionDocumentacionDAO {

	@Override
	public List<DocumentacionContratacionDocente> listaDocumentacionXRelacionDedicacionrRenovacionNO(int relDependencia,
			int dedicacion, String renovacion) {
		Query q = getEntityManager().createQuery(
				"Select ges from GestionDocumentacionSolicitada ges   where ges.relacionActual.idRelacion =?1 and ges.dedicacion.idDedicacion = ?2 and ges.activo = 'SI' and ges.renovacion = ?3");

		q.setParameter(1, relDependencia);
		q.setParameter(2, dedicacion);
		q.setParameter(3, renovacion);
		return q.getResultList();
	}

	@Override
	public List<DocumentacionContratacionDocente> listaDocXNombresRelacionDedicacionrRenovacionNO(String relDependencia,
			String dedicacion, String renovacion) {
		Query q = getEntityManager().createQuery(
				"Select ges.documentacion from GestionDocumentacionSolicitada ges   where ges.relacionActual.relacionDependencia =?1 and ges.dedicacion.dedicacion = ?2 and ges.activo = 'SI' and ges.renovacion = ?3");

		q.setParameter(1, relDependencia);
		q.setParameter(2, dedicacion);
		q.setParameter(3, renovacion);

		return q.getResultList();
	}

	@Override
	public List<GestionDocumentacionSolicitada> listaDocsGestionxParametros(int idRelacion, int idDedicacion,
			String renovacion, int idDocumento) {
		try {

			StringBuilder query = new StringBuilder(
					"Select ges from GestionDocumentacionSolicitada ges where ges.activo in ('SI','NO')");

			if (idRelacion != 0)
				query.append(" and ges.relacionActual.idRelacion =?1 ");
			if (idDedicacion != 0)
				query.append(" and ges.dedicacion.idDedicacion = ?2 ");
			if (!renovacion.equals(""))
				query.append(" and ges.renovacion = ?3");
			if (idDocumento != 0)
				query.append(" and ges.documentacion.idDocumentacionContratacionDocente =?4 ");

			Query q = getEntityManager().createQuery(query.toString());

			if (idRelacion != 0)
				q.setParameter(1, idRelacion);
			if (idDedicacion != 0)
				q.setParameter(2, idDedicacion);
			if (!renovacion.equals(""))
				q.setParameter(3, renovacion);
			if (idDocumento != 0)
				q.setParameter(4, idDocumento);

			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
