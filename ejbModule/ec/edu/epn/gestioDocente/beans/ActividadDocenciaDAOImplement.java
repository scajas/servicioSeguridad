package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ActividadDocencia;

/**
 * Session Bean implementation class ActividadDocenciaDAOImplement
 */
@Stateless
@LocalBean
public class ActividadDocenciaDAOImplement extends DaoGenericoImplement<ActividadDocencia>
		implements ActividadDocenciaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadDocencia> buscarActividadDocenciaBYParams(String cedula, String nivel, String materia,
			String idCarrera, String period, String paralelo) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT s from ActividadDocencia s where s.nced = ?1  and s.estado IN :list ");

		if (nivel != null) {
			queryString.append(" and s.nivel = ?2 ");
		}

		if (materia != null) {
			queryString.append(" and s.materia = ?3 ");
		}

		if (idCarrera != null) {
			queryString.append(" and s.carr.codCarre = ?4 ");
		}

		if (period != null) {
			queryString.append(" and s.periodo.idPeriodo = ?5 ");
		}

		if (paralelo != null) {
			queryString.append(" and s.paralelo = ?6 ");
		}

		queryString.append(" order by s.periodo.idPeriodo ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

		if (nivel != null) {
			query.setParameter(2, nivel.trim());
		}

		if (materia != null) {
			query.setParameter(3, materia.trim());
		}

		if (idCarrera != null) {
			query.setParameter(4, idCarrera.trim());
		}

		if (period != null) {
			query.setParameter(5, period.trim());
		}

		if (paralelo != null) {
			query.setParameter(6, paralelo.trim());
		}

		return query.getResultList();
	}
	
	
	@Override
	public int countActividadDocXMateriaCarrera(String cedula, String materia, String codCarrera, String paralelo, String idPeriodo, ActividadDocencia actividadDocencia) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT a FROM ActividadDocencia a WHERE a.nced=?1 AND a.materia=?2 AND a.carr.codCarre=?3 AND a.periodo.idPeriodo=?4 AND a.paralelo=?5");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		query.setParameter(2, materia);
		query.setParameter(3, codCarrera);
		query.setParameter(4, idPeriodo);
		query.setParameter(5, paralelo);	
		
		ActividadDocencia actividadDocenciaSelect=null;		
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			actividadDocenciaSelect=(ActividadDocencia) query.getSingleResult();
		}				
		if(actividadDocenciaSelect!=null){
			if(actividadDocencia!=null && actividadDocenciaSelect.getIdDocencia().equals(actividadDocencia.getIdDocencia())){
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
