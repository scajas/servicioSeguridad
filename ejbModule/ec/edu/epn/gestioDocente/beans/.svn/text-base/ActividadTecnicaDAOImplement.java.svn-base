package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActividadTecnica;

/**
 * Session Bean implementation class ActividadTecnicaDAOImplement
 */
@Stateless
@LocalBean
public class ActividadTecnicaDAOImplement extends DaoGenericoImplement<ActividadTecnica> implements ActividadTecnicaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadTecnica> buscarActividadTecnicaBYParams(String cedula, String cargo,
			String idperiodo) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT s from ActividadTecnica s where s.nced = ?1  and s.estado IN :list ");

		if (cargo != null) {
			queryString.append(" and s.nombreAdm = ?2 ");
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
	public int countActvTecnicaXCedNombre(String cedula, String nombreAdm, String idPeriodo, ActividadTecnica actividadTecnica) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT a FROM ActividadTecnica a WHERE a.nced=?1 AND a.nombreAdm=?2 AND a.periodo.idPeriodo=?3");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		query.setParameter(2, nombreAdm);
		query.setParameter(3, idPeriodo);			
		
		ActividadTecnica actividadTecnicaSelect=null;		
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			actividadTecnicaSelect=(ActividadTecnica) query.getSingleResult();
		}				
		if(actividadTecnicaSelect!=null){
			if(actividadTecnica!=null && actividadTecnicaSelect.getIdActividTecadm().equals(actividadTecnica.getIdActividTecadm())){
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
	public List<ActividadTecnica> buscarActividadTecnicaBYParamsTipo(String cedula, String tipo,
			String idperiodo) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT a from ActividadTecnica a WHERE a.nced = ?1  and a.estado IN :list ");

		if (tipo != null) {
			queryString.append(" and a.tipo = ?2 ");
		}

		if (idperiodo != null) {
			queryString.append(" and a.periodo.idPeriodo = ?3 ");
		}

		queryString.append(" ORDER BY a.periodo.idPeriodo ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

		if (tipo != null) {
			query.setParameter(2, tipo);
		}

		if (idperiodo != null) {
			query.setParameter(3, idperiodo.trim());
		}

		return query.getResultList();
	}

}
