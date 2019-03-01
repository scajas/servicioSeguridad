package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.TesisDirigida;

/**
 * Session Bean implementation class TasisDirigidasDAOImplement
 */
@Stateless
@LocalBean
public class TesisDirigidasDAOImplement extends DaoGenericoImplement<TesisDirigida> implements TesisDirigidasDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<TesisDirigida> buscarTesisDirigidaBYParams(String cedula, String nombre) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT s from TesisDirigida s where s.nced = ?1  and s.estado IN :list ");

		
		if(nombre != null)
		{
			queryString.append(" and s.temaTesisD = ?2 ");
		}
		
		queryString.append(" order by s.periodo.idPeriodo ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);
		
		
		if(nombre != null)
		{
			query.setParameter(2, nombre.trim());
		}


		return query.getResultList();
	}
	
	
	

	@Override
	public int countTesisDirigidasXPeriodo(String idPeriodo, String nombreTesis, TesisDirigida tesisDirigida) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT t FROM TesisDirigida t WHERE t.periodo.idPeriodo=?1 AND t.temaTesisD=?2");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idPeriodo);	
		query.setParameter(2, nombreTesis);
		
		TesisDirigida tesisDirigidaSelect=null;
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			tesisDirigidaSelect=(TesisDirigida) query.getSingleResult();
		}				
		if(tesisDirigidaSelect!=null){
			if(tesisDirigida!=null && tesisDirigidaSelect.getIdTesisD().equals(tesisDirigida.getIdTesisD())){
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
