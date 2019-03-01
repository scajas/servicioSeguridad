package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Topografiacie;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class TopografiacieServiceBean
 */
@Stateless
public class TopografiacieDAOImplement extends DaoGenericoImplement<Topografiacie> implements TopografiacieDAO {
	
	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;

	
	public List<Topografiacie> obtenerListaTopografias(String criterio, String busquedaPor) {
		if (criterio.isEmpty() || criterio.equals("") || criterio.equals(" ")
				|| criterio.equals("0")) { // criterio= "", busquedaPor=GRUPO o
											// SUBSITIO
			
			q = "SELECT top FROM Topografiacie top ";
			if (busquedaPor.equals("GRUPO"))
				q = q + " WHERE top.idTopografia < 2038 ";
			else if (busquedaPor.equals("SUBSITIO"))
				q = q + " WHERE top.idTopografia > 2037 ";
			q = q + " order by top.codigoTop ";

			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
		} //busqueda por=AGRUPADO. Cuando ya se seleccionó un grupo, salen los subsitios
		else if (!criterio.isEmpty() && busquedaPor.equals("AGRUPADO")) { 
			
			q = "SELECT top FROM Topografiacie top "
					+ " WHERE top.topografiacie.idTopografia = ?1 "
					+ " order by top.codigoTop ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, Integer.parseInt(criterio));
		} //busquedaPor=SUBSITIO. Cuando se ingresa el subsitio para buscar
		else if (!criterio.isEmpty() && busquedaPor.equals("SUBSITIO")) { 
			
			q = "SELECT top FROM Topografiacie top "
					+ " WHERE top.nombreTop like ?0 "
					+ " AND top.idTopografia > 2037 "
					+ " order by top.codigoTop ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, "%" + criterio.trim() + "%");
		} //busquedaPor=GRUPO. Cuando se ingresa el grupo para buscar 
		else if (!criterio.isEmpty() && busquedaPor.equals("GRUPO")) { 
			
			q = "SELECT top FROM Topografiacie top "
					+ " WHERE top.nombreTop like ?0 "
					+ " AND top.idTopografia < 2038 "
					+ " order by top.codigoTop ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, "%" + criterio.trim() + "%");
		}

		return query.getResultList();
	}

	
	public Topografiacie obtenerTopografiaGrupo(String criterio) {
		//Busca por grupo o subsitio
		if (!criterio.isEmpty() && !criterio.equals("") && !criterio.equals(" ") && !criterio.equals("0")) {
			
			q = "SELECT top FROM Topografiacie top "
					+ " WHERE top.idTopografia = ?0 ";

			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, Integer.parseInt(criterio));
		}
		
		Topografiacie t = new Topografiacie();
		t.setTopografiacie(new Topografiacie());
		t = (Topografiacie) query.getSingleResult();

		return t;
	}


	@Override
	public Topografiacie obtenerTopografiaDiag(Integer idDiagDef) {
		
			
		q = "SELECT top FROM Topografiacie top "
				+ " WHERE top.idTopografia = ?0 ";

		queryString = new StringBuilder(q);
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, idDiagDef);
		
		
		Topografiacie t = new Topografiacie();
		t.setTopografiacie(new Topografiacie());
		t = (Topografiacie) query.getSingleResult();

		return t;
	}
	
	

}
