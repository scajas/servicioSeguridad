package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.ExpProfesExt;

/**
 * Session Bean implementation class ExperienciaProfesionalExternaDAOImplement
 */
@Stateless
@LocalBean
public class ExperienciaProfesionalExternaDAOImplement extends DaoGenericoImplement<ExpProfesExt> implements ExperienciaProfesionalExternaDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpProfesExt> buscarExperienciaProfExterna(
			String cedula, String validarecategoriza, String validarevaloriza, String tipo) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder("SELECT s from ExpProfesExt s where s.nced = ?1  and s.estado IN :list ");
		
		if(validarecategoriza != null){
			queryString.append(" and s.validarecategorza = ?2 ");
		}		
	
		if(validarevaloriza != null){
			queryString.append(" and s.validarevalorazion = ?3 ");
		}
		
		if(tipo != null){
			if(tipo.trim().equals("D")){
				queryString.append(" and s.tipo = ?4 ");
			}else{
				queryString.append(" and (s.tipo = ?4 OR s.tipo NOT IN ('D') OR s.tipo=null )");
			}			
		}else{
			queryString.append(" and (s.tipo NOT IN ('D') OR s.tipo=null) ");
		}
		
		queryString.append(" order by s.fechaInicioTrabajo ");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);
		
		if(validarecategoriza != null){
			query.setParameter(2, validarecategoriza);
		}		
	
		if(validarevaloriza != null){
			query.setParameter(3, validarevaloriza);
		}
		
		if(tipo != null){
			query.setParameter(4, tipo);
		}
		
		return query.getResultList();
	}
    
   /* @SuppressWarnings("unchecked")
    @Override
	public List<ExpProfesExt> listExperienciaProfExtXCed(String cedula, List<String> validaciones) throws Exception{
    	Query query = getEntityManager().createQuery("SELECT e FROM ExpProfesExt e WHERE e.nced=?1 AND e.validacion IN :listValidacion ORDER BY e.idExpProf ");
		query.setParameter(1, cedula.trim());		
		query.setParameter("listValidacion", validaciones);
		return query.getResultList();
    }*/
	@Override
	public List<ExpProfesExt> listExperienciaProfRecategoriza(String cedula) {
				StringBuilder queryString = new StringBuilder(
				"SELECT s from ExpProfesExt s where s.nced = ?1  and s.validacion in ('A','P') and s.docente in ('D','E') and s.estado in ('U','I')");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		return query.getResultList();
	}
   

}
