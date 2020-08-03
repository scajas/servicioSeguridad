package ec.edu.epn.desarrollo.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.desarrollo.entities.Requerimiento;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class RequerimientoDAOImplement
 */
@Stateless
@LocalBean
public class RequerimientoDAOImplement extends DaoGenericoImplement<Requerimiento> implements RequerimientoDAO {

	@Override
	public List<Requerimiento> consultarRequerimientobyPro(Integer idProyecto) {
		StringBuilder querys = new StringBuilder(
				"SELECT e From Requerimiento e where e.proyecto.id = ?1 order by e.id DESC ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idProyecto);
		return query.getResultList();
	}

	@Override
	public List<Requerimiento> consultarRequerimientobyDes(String nced) {
		StringBuilder querys = new StringBuilder(
				"SELECT e From Requerimiento e where e.personal.nced = ?1 order by e.id ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);
		return query.getResultList();
	}
	
	@Override
	public List<Requerimiento> consultarRequerimientobyEstado(String estado) {
		StringBuilder querys = new StringBuilder(
				"SELECT e From Requerimiento e where e.idestado = ?1 order by e.id ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, estado);
		return query.getResultList();
	}

	@Override
	public List<Requerimiento> consultarRequerimientobyDesProy(String nced, Integer idproy) {
		StringBuilder querys = new StringBuilder(
				"SELECT e From Requerimiento e where e.personal.nced = ?1 and e.proyecto.id = ?2 order by e.id ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);
		query.setParameter(2, idproy);
		return query.getResultList();
	}

	@Override
	public int consultarNumeroSerial(int anio) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery("SELECT MAX(pr.idanio)FROM Requerimiento pr" + " where anio =?1  ");

		Integer idReq = null;
		q.setParameter(1, anio);

		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}
	
	
	@Override
	public List<Requerimiento> consultarRequerimientoReporte(Integer idProyecto, Integer idpersonal,Date fini, Date fhasta, String estado) {
		StringBuilder querys = new StringBuilder(
				"SELECT e From Requerimiento e where e.idestado like ?1  ");
		
		if(idProyecto != 0)
		{
			querys.append(" and e.proyecto.id = ?2 ");
			System.out.println("Se abre el idproyecto");
		}
		
		if(idpersonal != 0)
		{
			querys.append(" and  e.personal.id = ?3 "); 
			System.out.println("Se abre el personal");
		}
		
		if(fini != null && fhasta != null)
		{
			
			querys.append(" and  e.fleva BETWEEN  ?4 and  ?5 ");
			
		}
		
		if(estado != null )
		{
			
			querys.append(" and  e.idestado = ?6 ");
			
		}
		
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, "%");
		
		if(idProyecto != 0)
		{
			query.setParameter(2, idProyecto);
		}
		
		if(idpersonal != 0)
		{
			query.setParameter(3,idpersonal);
		}
		
		
		if(fini != null && fhasta != null)
		{
			
			query.setParameter(4,fini);
			query.setParameter(5,fhasta);
			
			
		}
		
		if(estado != null )
		{
			
			query.setParameter(6,estado);
			
		}
		return query.getResultList();
	}
}
