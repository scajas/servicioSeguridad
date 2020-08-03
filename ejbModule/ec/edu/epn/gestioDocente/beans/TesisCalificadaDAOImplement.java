package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.TesisCalificada;

/**
 * Session Bean implementation class TesisCalificadaDAOImplement
 */
@Stateless
@LocalBean
public class TesisCalificadaDAOImplement extends DaoGenericoImplement<TesisCalificada> implements TesisCalificadaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<TesisCalificada> buscarTesisCalificadaBYParams(String cedula, String nombre) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT s from TesisCalificada s where s.nced = ?1  and s.estado IN :list ");

		
		if(nombre != null)
		{
			queryString.append(" and s.temaTesisC = ?2 ");
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
	public int countTesisCalificadasXPeriodo(String idPeriodo, String nombreTesis, TesisCalificada tesisCalificada) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT t FROM TesisCalificada t WHERE t.periodo.idPeriodo=?1 AND t.temaTesisC=?2");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idPeriodo);	
		query.setParameter(2, nombreTesis);	
		
		TesisCalificada tesisCalificadaSelect=null;
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			tesisCalificadaSelect=(TesisCalificada) query.getSingleResult();
		}				
		if(tesisCalificadaSelect!=null){
			if(tesisCalificada!=null && tesisCalificadaSelect.getIdTesisC().equals(tesisCalificada.getIdTesisC())){
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
