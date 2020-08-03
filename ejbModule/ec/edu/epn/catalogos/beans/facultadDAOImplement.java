/**
 * 
 */
package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.FacultadCatalogos;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class facultadDAOImplement extends DaoGenericoImplement<FacultadCatalogos> implements facultadDAO {

	@Override
	public FacultadCatalogos buscaFacuXID(String id) {
		StringBuilder queryString = null;
		Query query = null;

		queryString = new StringBuilder("SELECT ma FROM FacultadCatalogos ma where ma.idFacultad =?1");
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);
		return (FacultadCatalogos) query.getSingleResult();
	}

	@Override
	public String buscaNombreFacuXID(String id) {
		StringBuilder queryString = null;
		Query query = null;

		queryString = new StringBuilder("SELECT ma.nomFacultad FROM FacultadCatalogos ma where ma.idFacultad =?1");
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		return (String) query.getSingleResult();
	}

	@Override
	public List<FacultadCatalogos> listaFacultades() {
		StringBuilder queryString = null;
		Query query = null;

		queryString = new StringBuilder("SELECT ma FROM FacultadCatalogos ma");
		query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}
}
