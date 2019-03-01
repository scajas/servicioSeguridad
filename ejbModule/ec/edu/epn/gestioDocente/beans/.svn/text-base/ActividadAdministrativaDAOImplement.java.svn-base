package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActividadAdministrativa;

/**
 * Session Bean implementation class ActividadAdministrativaDAOImplement
 */
@Stateless
@LocalBean
public class ActividadAdministrativaDAOImplement extends DaoGenericoImplement<ActividadAdministrativa>
		implements ActividadAdministrativaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadAdministrativa> buscarActividadAdministrativaBYParams(String cedula, String cargo,
			String idperiodo, String tipo) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT s from ActividadAdministrativa s WHERE s.nced = ?1  AND s.estado IN :list ");

		if (cargo != null) {
			queryString.append(" AND s.cargo = ?2");
		}

		if (idperiodo != null) {
			queryString.append(" AND s.periodo.idPeriodo = ?5");
		}
		
		if(tipo!=null){
			queryString.append(" AND s.tipo = ?6");
		}

		queryString.append(" ORDER BY s.periodo.idPeriodo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

		if (cargo != null) {
			query.setParameter(2, cargo);
		}

		if (idperiodo != null) {
			query.setParameter(5, idperiodo.trim());
		}
		
		if(tipo!=null){
			query.setParameter(6, tipo);
		}

		return query.getResultList();
	}
	
	
	@Override
	public int countActAdministrativaXCedCargo(String cedula, String cargo, String idPeriodo, ActividadAdministrativa actividadAdministrativa) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT a FROM ActividadAdministrativa a WHERE a.nced=?1 AND a.cargo=?2 AND a.periodo.idPeriodo=?3");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		query.setParameter(2, cargo);
		query.setParameter(3, idPeriodo);			
		
		ActividadAdministrativa actividadAdministrativaSelect=null;		
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			actividadAdministrativaSelect=(ActividadAdministrativa) query.getSingleResult();
		}				
		if(actividadAdministrativaSelect!=null){
			if(actividadAdministrativa!=null && actividadAdministrativaSelect.getIdActAdm().equals(actividadAdministrativa.getIdActAdm())){
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
