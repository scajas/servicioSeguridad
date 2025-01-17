package ec.edu.epn.proyectos.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.contratos.beans.PensumDAO;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.CierrePeriodo;

/**
 * Session Bean implementation class CierrePeriodoDAOImplement
 */
@Stateless
@LocalBean
public class CierrePeriodoDAOImplement extends DaoGenericoImplement<CierrePeriodo> implements CierrePeriodoDAO {

	@EJB(lookup = "java:global/ServiciosSeguridadEPN/PensumDAOImplement!ec.edu.epn.contratos.beans.PensumDAO")
	private PensumDAO pensumDAO;

	@Override
	public List<CierrePeriodo> consultarCierreProyecto(Integer idproy, Integer idpensun, String tipo) {

		StringBuilder querys = new StringBuilder("SELECT e From CierrePeriodo e where e.proyecto.idProy = ?1  ");

		if (idpensun != 0) {
			querys.append(" and e.idPensum = ?2 ");

		}

		if (tipo != null) {
			querys.append(" and e.tipo = ?3 ");

		}

		querys.append(" and  e.idPensum > 17  order by e.meses DESC");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, idproy);

		if (idpensun != 0) {
			query.setParameter(2, idpensun);

		}

		if (tipo != null) {
			query.setParameter(3, tipo);

		}
		return query.getResultList();

	}

	@Override
	public CierrePeriodo consultarCierreProyectoPensum(Integer idproy, Integer idpensun, String tipo, String cerrado) {

		try {

			StringBuilder querys = new StringBuilder(
					"SELECT e From CierrePeriodo e where e.proyecto.idProy = ?1 and e.cerrado = ?2  ");

			if (idpensun != 0) {
				querys.append(" and e.idPensum = ?3 ");

			}

			if (tipo != null) {
				querys.append(" and e.tipo = ?4 ");

			}

			querys.append(" order by e.meses DESC");

			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, idproy);
			query.setParameter(2, cerrado);

			if (idpensun != 0) {
				query.setParameter(3, idpensun);

			}

			if (tipo != null) {
				query.setParameter(4, tipo);

			}
			return (CierrePeriodo) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

		catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<CierrePeriodo> consultarCierreProyectoDept(String estado, String coddep) {

		List<CierrePeriodo> cierres = new ArrayList<CierrePeriodo>();
		List<CierrePeriodo> listCierre = new ArrayList<CierrePeriodo>();

		StringBuilder querys = new StringBuilder(
				"SELECT e From CierrePeriodo e where e.cerrado = ?1 and e.proyecto.coddep  = ?2 ");
		querys.append(" order by e.meses DESC");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, estado);
		query.setParameter(2, coddep);

		cierres = query.getResultList();

		if (!cierres.isEmpty()) {
			for (CierrePeriodo dto : cierres) {
				dto.setPensum(pensumDAO.obtenerPensumById(dto.getIdPensum()));

				listCierre.add(dto);
			}
		}

		return listCierre;

	}

	@Override
	public List<CierrePeriodo> consultarCierres() {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CierrePeriodo e where e.cerrado = 'S' order by e.meses desc ");

		Query query = getEntityManager().createQuery(querys.toString());

		return query.getResultList();

	}

	@Override
	public List<CierrePeriodo> consultarCierresVIPS(Integer idtipo) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CierrePeriodo e where e.cerrado = 'S' and e.path IS NOT NULL and e.proyecto.tipoProyecto.idTipoProy = ?0 and e.revisado = 'N' order by e.meses desc ");

		Query query = getEntityManager().createQuery(querys.toString());

		query.setParameter(0, idtipo);

		return query.getResultList();

	}

	@Override
	public CierrePeriodo consultarCierreProyectoPensumIngresadas(Integer idproy, Integer idpensun, String tipo,
			String cerrado) {

		try {

			StringBuilder querys = new StringBuilder("SELECT e From CierrePeriodo e where e.proyecto.idProy = ?1   ");

			if (idpensun != 0) {
				querys.append(" and e.idPensum = ?3 ");

			}

			if (tipo != null) {
				querys.append(" and e.tipo = ?4 ");

			}

			querys.append(" order by e.meses DESC");

			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, idproy);

			if (idpensun != 0) {
				query.setParameter(3, idpensun);

			}

			if (tipo != null) {
				query.setParameter(4, tipo);

			}
			return (CierrePeriodo) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

		catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<CierrePeriodo> consultarCierreProyectoDeptEstados(String coddep) {

		List<CierrePeriodo> cierres = new ArrayList<CierrePeriodo>();
		List<CierrePeriodo> listCierre = new ArrayList<CierrePeriodo>();

		StringBuilder querys = new StringBuilder(
				"SELECT e From CierrePeriodo e where e.proyecto.coddep  = ?1 and e.idPensum > 17 ");
		querys.append(" order by e.meses DESC");

		Query query = getEntityManager().createQuery(querys.toString());

		query.setParameter(1, coddep);

		cierres = query.getResultList();

		if (!cierres.isEmpty()) {
			for (CierrePeriodo dto : cierres) {
				dto.setPensum(pensumDAO.obtenerPensumById(dto.getIdPensum()));

				listCierre.add(dto);
			}
		}

		return listCierre;

	}

	@Override
	public List<CierrePeriodo> consultarCierresReporte() {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CierrePeriodo e where e.idPensum > 17 order by e.meses desc ");

		Query query = getEntityManager().createQuery(querys.toString());

		return query.getResultList();

	}

	@Override
	public List<CierrePeriodo> consultarCierreRevisados(String revisado) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From CierrePeriodo e where e.revisado = ?1 order by e.meses desc ");

		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, revisado);

		return query.getResultList();

	}
	
	
	@Override
	public Double consultarMaxReporte(Integer id_proy, String tipo){ //Paciente //numerohclPac
		Query q = getEntityManager().createQuery("select max(e.avance) from CierrePeriodo e where e.tipo = ?1 and e.proyecto.idProy = ?2 ");
		Double numero = null;
		try {
			
			q.setParameter(1, tipo);
			q.setParameter(2, id_proy);
			numero =(Double) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			numero = null;
		}
		if (numero==null)
			numero = 0.00;
		
		return numero;
	}
	
	@Override
	public CierrePeriodo consultarMaxCierre(Integer idproy) {

		try {

			StringBuilder querys = new StringBuilder("SELECT e From CierrePeriodo e where e.proyecto.idProy = ?1 and e.tipo = 'R' and e.idPensum = (select max(c.idPensum) from CierrePeriodo c where c.proyecto.idProy = e.proyecto.idProy and c.tipo = 'R')  ");
			Query query = getEntityManager().createQuery(querys.toString());
			query.setParameter(1, idproy);

			
			return (CierrePeriodo) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

		catch (NonUniqueResultException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}
	
	
	

}
