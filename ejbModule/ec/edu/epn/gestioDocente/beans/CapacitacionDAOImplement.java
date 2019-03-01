package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Capacitacion;

/**
 * Session Bean implementation class CapacitacionDAOImplement
 */
@Stateless
@LocalBean
public class CapacitacionDAOImplement extends DaoGenericoImplement<Capacitacion> implements CapacitacionDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<Capacitacion> buscarCapacitacionesByParam(String cedula, String validarecategoriza,
			String validarevaloriza, String nombre, boolean ordenPeriodo) throws Exception {
		
		

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		List<String> capc = new ArrayList<String>();

		capc.add("ASISTE");
		capc.add("Asiste");
		capc.add("asiste");

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Capacitacion s where s.nced = ?1  and s.estado IN :list and s.tipo IN :dicta ");

		if (validarecategoriza != null) {
			queryString.append(" and s.validarecategorza = ?2 ");
		}

		if (validarevaloriza != null) {
			queryString.append(" and s.validarevalorazion = ?3 ");
		}

		if (nombre != null) {
			queryString.append(" and s.nombreCapac = ?4 ");
		}
		
		if(ordenPeriodo==true){
			queryString.append(" order by periodo.idPeriodo DESC ");
		}else{
			queryString.append(" order by fechaInicioCapac DESC ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);
		query.setParameter("dicta", capc);

		if (validarecategoriza != null) {
			query.setParameter(2, validarecategoriza);
		}

		if (validarevaloriza != null) {
			query.setParameter(3, validarevaloriza);
		}

		if (nombre != null) {
			query.setParameter(4, nombre);
		}
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Capacitacion> buscarCapacitacionesByParamDictadas(String cedula, String validarecategoriza,
			String validarevaloriza, String nombre, boolean ordenPeriodo) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		List<String> capc = new ArrayList<String>();

		capc.add("DICTA");
		capc.add("dicta");
		capc.add("Dicta");

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Capacitacion s where s.nced = ?1  and s.estado IN :list and s.tipo IN :dicta ");

		if (validarecategoriza != null) {
			queryString.append(" and s.validarecategorza = ?2 ");
		}

		if (validarevaloriza != null) {
			queryString.append(" and s.validarevalorazion = ?3 ");
		}

		if (nombre != null) {
			queryString.append(" and s.nombreCapac = ?4 ");
		}
		
		if(ordenPeriodo==true){
			queryString.append(" order by periodo.idPeriodo DESC");
		}else{
			queryString.append(" order by fechaInicioCapac DESC ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);
		query.setParameter("dicta", capc);

		if (validarecategoriza != null) {
			query.setParameter(2, validarecategoriza);
		}

		if (validarevaloriza != null) {
			query.setParameter(3, validarevaloriza);
		}

		if (nombre != null) {
			query.setParameter(4, nombre);
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Capacitacion> listaCapacitacionXCedula(String cedula) throws Exception {
		StringBuilder queryString = new StringBuilder("SELECT c FROM Capacitacion c where c.nced =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		return query.getResultList();
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override public List<Capacitacion>
	 * buscarCapacitacionesByValidacion(String cedula, List<String> tipo,
	 * List<String> validacion) throws Exception {
	 * 
	 * Query query = getEntityManager().createQuery(
	 * "SELECT c FROM Capacitacion c WHERE c.nced = ?1 AND c.tipo IN :listTipo AND c.validacion IN :listValidacion ORDER BY c.periodo.idPeriodo "
	 * ); query.setParameter(1, cedula.trim()); query.setParameter("listTipo",
	 * tipo); query.setParameter("listValidacion", validacion); return
	 * query.getResultList(); }
	 */

	@Override
	public int countCapacitacionXNombre(String cedula, String nombreCapacitacion, Capacitacion capacitacion)
			throws Exception {
		int valor = 0;
		String val = "N";
		StringBuilder queryString = new StringBuilder(
				"SELECT c FROM Capacitacion c WHERE c.nombreCapac=?1 AND c.nced=?2 AND c.estado!='D'");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreCapacitacion);
		query.setParameter(2, cedula);

		Capacitacion capacitacionSelect = null;

		try {
			query.getSingleResult();
			val = "S";
		} catch (NoResultException e) {
			val = "N";
		}

		if (val.equals("S")) {
			capacitacionSelect = (Capacitacion) query.getSingleResult();
		}

		if (capacitacionSelect != null) {
			if (capacitacion != null && capacitacionSelect.getIdCapac().equals(capacitacion.getIdCapac())) {
				valor = 0;
			} else {
				valor = 1;
			}

		} else {
			valor = 0;
		}

		return valor;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Capacitacion> buscarCapacitacionesByPeriodoTipo(String cedula, String idPeriodo, String tipo) throws Exception {
		

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");		

		StringBuilder queryString = new StringBuilder(
				"SELECT c FROM Capacitacion c WHERE c.nced = ?1 AND c.estado IN :list AND trim(upper(c.tipo)) like ?2   AND c.periodo.idPeriodo=?3 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);
		query.setParameter(2, "%" + tipo + "%");
		query.setParameter(3, idPeriodo);
		
		return query.getResultList();
	}

}
