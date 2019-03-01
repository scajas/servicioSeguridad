package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Premio;

/**
 * Session Bean implementation class PremioDAOImplement
 */
@Stateless
@LocalBean
public class PremioDAOImplement extends DaoGenericoImplement<Premio> implements PremioDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Premio> buscarPremio(String cedula, String nombre, Integer anio) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Premio s where s.nced = ?1  and s.estado IN :list");

		if (nombre != null) {
			queryString.append(" and s.nombrePremio = ?2");
		}

		if (anio != 0) {
			queryString.append(" and s.anioPremio = ?3");
		}

		queryString.append(" order  by s.anioPremio");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

		if (nombre != null) {
			query.setParameter(2, nombre.trim());

		}

		if (anio != 0) {
			query.setParameter(3, anio);
		}

		return query.getResultList();
	}
	
	
	@Override
	public int countPremioAdquiridoXNombre(String cedula, String nombrePremio, String institucion, Integer añoPremio, Premio premio) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT p FROM Premio p WHERE p.nombrePremio=?1 AND p.institucionPremio=?2 AND p.anioPremio=?3 AND p.nced=?4 AND p.estado!='D'");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombrePremio);
		query.setParameter(2, institucion);
		query.setParameter(3, añoPremio);
		query.setParameter(4, cedula);		
		
		Premio premioSelect=null;
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			premioSelect=(Premio) query.getSingleResult();
		}	
		
		if(premioSelect!=null){
			if(premio!=null && premioSelect.getIdPremios().equals(premio.getIdPremios())){
				valor=0;
			}else{
				valor=1;
			}
			
		}else{
			valor=0;
		}
					
		return valor;		
	}

}
