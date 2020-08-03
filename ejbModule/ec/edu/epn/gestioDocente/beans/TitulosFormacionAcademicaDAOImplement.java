package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Periodo;
import ec.edu.epn.gestionDocente.entities.TituloFormacionAcademica;

/**
 * Session Bean implementation class CapacitacionDAOImplement
 */
@Stateless
@LocalBean
public class TitulosFormacionAcademicaDAOImplement extends DaoGenericoImplement<TituloFormacionAcademica>
		implements TitulosFormacionAcademicaDAO {

	@Override
	public List<TituloFormacionAcademica> finsAllTitulos() throws Exception {

		Query query = getEntityManager().createNamedQuery("TituloFormacionAcademica.findAll");

		return query.getResultList();

	}

	public List<String> obtenercedulasparaactualizar() throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT DISTINCT(t.nced) from TituloFormacionAcademica t ");

		Query query = getEntityManager().createQuery(queryString.toString());
		

		try {
			return query.getResultList();
		} catch (Exception exception) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TituloFormacionAcademica> buscarTutlosRegSDenescytRevalorizarec(String cedula, String regSenescyt,
			String validarecategoriza, String validarevaloriza, String nombre, boolean ordenAño) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");
		StringBuilder queryString = new StringBuilder(
				"SELECT t from TituloFormacionAcademica t where t.nced = ?1  and t.estado IN :list");

		if (regSenescyt != null) {
			queryString.append(" AND t.regSenescyt IS NOT NULL");
		}

		if (validarecategoriza != null) {
			queryString.append(" AND t.validarecategorza = ?2");
		}

		if (validarevaloriza != null) {
			queryString.append(" AND t.validarevalorazion = ?3");
		}

		if (nombre != null) {
			queryString.append(" AND t.nombreTitulo = ?4");
		}

		if (ordenAño == true) {
			queryString.append(" ORDER BY t.año DESC");
		} else {
			queryString.append(" ORDER BY t.fecRegSenescyt DESC");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula.trim());
		query.setParameter("list", ids);

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
	public int countTituloFormAcadXNombre(String cedula, String nombreTitulo, TituloFormacionAcademica titulo)
			throws Exception {
		int valor = 0;
		String val = "N";
		StringBuilder queryString = new StringBuilder(
				"SELECT t FROM TituloFormacionAcademica t WHERE t.nombreTitulo=?1 AND t.nced=?2 AND t.estado!='D'");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreTitulo);
		query.setParameter(2, cedula);

		TituloFormacionAcademica tituloSeelect = null;

		try {
			query.getSingleResult();
			val = "S";
		} catch (NoResultException e) {
			val = "N";
		}

		if (val.equals("S")) {
			tituloSeelect = (TituloFormacionAcademica) query.getSingleResult();
		}

		if (tituloSeelect != null) {
			if (titulo != null && tituloSeelect.getIdTitulo().equals(titulo.getIdTitulo())) {
				valor = 0;
			} else {
				valor = 1;
			}

		} else {
			valor = 0;
		}

		return valor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TituloFormacionAcademica buscarTulosporID(String id) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT t from TituloFormacionAcademica t where t.idTitulo = ?1  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, Integer.parseInt(id));

		try {
			return (TituloFormacionAcademica) query.getSingleResult();
		} catch (Exception exception) {
			return null;
		}

	}

	@Override
	public List<TituloFormacionAcademica> titulosxcedula(String nced) throws Exception {
		StringBuilder queryString = new StringBuilder(
				"SELECT t from TituloFormacionAcademica t where t.nced like ?1  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%"+nced+"%");

		try {
			return query.getResultList();
		} catch (Exception exception) {
			return null;
		}
	}

}
