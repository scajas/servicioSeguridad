package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.AreaConocDocente;
import ec.edu.epn.gestionDocente.entities.Capacitacion;

/**
 * Session Bean implementation class AreaConocimientoDocenteDAOImplement
 */
@Stateless
@LocalBean
public class AreaConocimientoDocenteDAOImplement extends DaoGenericoImplement<AreaConocDocente>
		implements AreaConocimientoDocenteDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<AreaConocDocente> buscarArearByParams(String cedula, String idarea) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT s from AreaConocDocente s where s.nced = ?1  and s.estado IN :list ");

		if (idarea != null) {
			queryString.append(" and s.areaConocimiento.idAreaCon = ?2 ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

		if (idarea != null) {
			query.setParameter(2, idarea);
		}

		return query.getResultList();
	}
	
	
	@Override
	public int countAreaConocDocenteXIdArea(String cedula, String idAreaConocimiento, AreaConocDocente areaConocDocente) throws Exception{
		int valor=0;
		String val="N";
		StringBuilder queryString = new StringBuilder("SELECT a FROM AreaConocDocente a WHERE a.areaConocimiento.idAreaCon=?1 AND a.nced=?2 AND a.estado!='D'");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idAreaConocimiento);
		query.setParameter(2, cedula);
		
		//Capacitacion capacitacionSelect=null;
		AreaConocDocente areaConocDocenteSelect=null;
			
		try {
			query.getSingleResult();
			val="S";
		} catch (NoResultException e) {
			val="N";
		}
		
		if(val.equals("S")){
			areaConocDocenteSelect=(AreaConocDocente) query.getSingleResult();
		}
		
		
		if(areaConocDocenteSelect!=null){
			if(areaConocDocente!=null && areaConocDocenteSelect.getIdAreaConocDoc().equals(areaConocDocente.getIdAreaConocDoc())){
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
