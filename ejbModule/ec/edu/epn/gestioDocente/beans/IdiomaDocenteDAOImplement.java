package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.IdiomasDocente;

/**
 * Session Bean implementation class IdiomaDocenteDAOImplement
 */
@Stateless
@LocalBean
public class IdiomaDocenteDAOImplement extends DaoGenericoImplement<IdiomasDocente> implements IdiomaDocenteDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<IdiomasDocente> buscarIdiomasDocente(String cedula, String nombre) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT i FROM IdiomasDocente i WHERE i.nced = ?1 AND i.estado IN :list");

		if (nombre != null) {
			queryString.append(" AND i.idioma.idIdioma = ?2");

		}
		
		queryString.append(" ORDER BY i.idioma.nombreIdioma");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

		if (nombre != null) {
			query.setParameter(2, nombre.trim());

		}

		return query.getResultList();
	}
	
	
	
	@Override
	public int countIdiomaXIdIdiomaCat(String cedula, String idIdiomaCat, IdiomasDocente idiomasDocente) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT i FROM IdiomasDocente i WHERE i.idioma.idIdioma=?1 AND i.nced=?2 AND i.estado!='D'");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idIdiomaCat);
		query.setParameter(2, cedula);		
		
		IdiomasDocente idiomasDocenteSelect=null;
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			idiomasDocenteSelect=(IdiomasDocente) query.getSingleResult();
		}
		
		
		if(idiomasDocenteSelect!=null){
			if(idiomasDocente!=null && idiomasDocenteSelect.getIdIdiomasDocente().equals(idiomasDocente.getIdIdiomasDocente())){
				valor=0;
			}else{
				valor=1;
			}
			
		}else{
			valor=0;
		}
					
		return valor;		
	}
	
	
	
	
	@Override
	public int countIdiomaXCedula(String cedula, String idIdiomaCat) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT i FROM IdiomasDocente i WHERE i.idioma.idIdioma=?1 AND i.nced=?2 AND i.estado!='D'");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idIdiomaCat);
		query.setParameter(2, cedula);		
		
		IdiomasDocente idiomasDocenteSelect=null;
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
			valor= 0;
		}
		
		if(val.equals("S")){
			idiomasDocenteSelect=(IdiomasDocente) query.getSingleResult();
		}else{
			idiomasDocenteSelect= null;
		}
		
		
		if(idiomasDocenteSelect!=null){			
			valor=1;
			
			
		}else{
			valor=0;
		}
					
		return valor;		
	}

}
