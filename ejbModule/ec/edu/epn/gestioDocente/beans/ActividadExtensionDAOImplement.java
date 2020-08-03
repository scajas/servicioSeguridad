package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActividadExtension;

/**
 * Session Bean implementation class ActividadExtensionDAOImplement
 */
@Stateless
@LocalBean
public class ActividadExtensionDAOImplement extends DaoGenericoImplement<ActividadExtension> implements ActividadExtensionDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadExtension> buscarActividadExtensionBYParams(String cedula, String cargo,
			String idperiodo) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT s from ActividadExtension s where s.nced = ?1  and s.estado IN :list ");

		if (cargo != null) {
			queryString.append(" and s.nombreAct = ?2 ");
		}

		if (idperiodo != null) {
			queryString.append(" and s.periodo.idPeriodo = ?5 ");
		}

		queryString.append(" order by s.periodo.idPeriodo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

		if (cargo != null) {
			query.setParameter(2, cargo);
		}

		if (idperiodo != null) {
			query.setParameter(5, idperiodo.trim());
		}

		return query.getResultList();
	}

	@Override
	public int countActvExtensionXCedNombre(String cedula, String nombreActv, String idPeriodo, ActividadExtension actividadExtension) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT a FROM ActividadExtension a WHERE a.nced=?1 AND a.nombreAct=?2 AND a.periodo.idPeriodo=?3");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		query.setParameter(2, nombreActv);		
		query.setParameter(3, idPeriodo);
			
		ActividadExtension actividadExtensionSelect=null;
				
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			actividadExtensionSelect=(ActividadExtension) query.getSingleResult();
		}				
		if(actividadExtensionSelect!=null){
			if(actividadExtension!=null && actividadExtensionSelect.getIdActividExtens().equals(actividadExtension.getIdActividExtens())){
				valor=0;
			}else{
				valor=1;
			}			
		}else{
			valor=0;
		}
					
		return valor;		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadExtension> buscarActividadExtensionBYTipo(String cedula, String cargo, String idperiodo, String tipo) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT a from ActividadExtension a WHERE a.nced = ?1 AND a.estado IN :list ");

		if (cargo != null) {
			queryString.append(" AND a.nombreAct = ?2");
		}

		if (idperiodo != null) {
			queryString.append(" AND a.periodo.idPeriodo = ?3");
		}
		
		if (tipo != null) {
			queryString.append(" AND a.tipo = ?4");
		}

		queryString.append(" ORDER BY a.periodo.idPeriodo ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

		if (cargo != null) {
			query.setParameter(2, cargo);
		}

		if (idperiodo != null) {
			query.setParameter(3, idperiodo.trim());
		}
		
		if (tipo != null) {
			query.setParameter(4, tipo);
		}

		return query.getResultList();
	}

}
