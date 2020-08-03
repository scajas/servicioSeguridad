package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActividadProyecto;

/**
 * Session Bean implementation class ActividadProyectoDAOImplement
 */
@Stateless
@LocalBean
public class ActividadProyectoDAOImplement extends DaoGenericoImplement<ActividadProyecto>
		implements ActividadProyectoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadProyecto> findActividadProyecto(String nced, String validarecategoriza,
			String validarevaloriza, String cierre, String nombrepr, String idperiodo, String rol) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM ActividadProyecto fam where fam.nced = ?0 and fam.estado IN :list and fam.periodo.idPeriodo NOT IN ('2012-1','2012-2','2012-4','2013-1','2013-2','2014-1','2014-2','2015-1','2015-2','2016-1','2016-2','2017-0','2017-1','2017-2','2018-1') ");

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		if (validarecategoriza != null) {
			queryString.append(" and fam.validarecategorza = ?1");
		}

		if (validarevaloriza != null) {
			queryString.append(" and fam.validarevalorazion = ?2");
		}

		if (cierre != null) {
			queryString.append(" and fam.cierre = ?3");
		}

		if (nombrepr != null) {
			queryString.append(" and fam.nomProyecto = ?4");
		}

		if (idperiodo != null) {
			queryString.append(" and fam.periodo.idPeriodo = ?5");
		}

		if (rol != null) {
			queryString.append(" and fam.rolProyecto = ?6");
		}

		queryString.append(" order by fam.periodo.periodo DESC");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced.trim());
		query.setParameter("list", ids);

		if (validarecategoriza != null) {
			query.setParameter(1, validarecategoriza);
		}

		if (validarevaloriza != null) {
			query.setParameter(2, validarevaloriza);
		}

		if (cierre != null) {
			query.setParameter(3, cierre);
		}

		if (nombrepr != null) {
			query.setParameter(4, nombrepr);
		}

		if (idperiodo != null) {
			query.setParameter(5, idperiodo);
		}

		if (rol != null) {
			query.setParameter(6, rol);
		}

		return query.getResultList();

	}
	
	
	@Override
	public int countActProyInvXCed(String cedula, String nombreProyecto, String rol, String idPeriodo, ActividadProyecto actividadProyecto) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT a FROM ActividadProyecto a WHERE a.nced=?1 AND a.nomProyecto=?2 AND a.periodo.idPeriodo=?3 AND a.rolProyecto=?4");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		query.setParameter(2, nombreProyecto);		
		query.setParameter(3, idPeriodo);
		query.setParameter(4, rol);	
				
		ActividadProyecto actividadProyectoSelect=null;
		
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			actividadProyectoSelect=(ActividadProyecto) query.getSingleResult();
		}				
		if(actividadProyectoSelect!=null){
			if(actividadProyecto!=null && actividadProyectoSelect.getIdActividProy().equals(actividadProyecto.getIdActividProy())){
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
