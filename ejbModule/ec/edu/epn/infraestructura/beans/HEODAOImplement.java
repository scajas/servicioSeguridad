/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.HorarioEspacioOcupante;

/**
 * @author Administrador
 * 
 */
@Stateless
public class HEODAOImplement extends
		DaoGenericoImplement<HorarioEspacioOcupante> implements HEODAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(heo.idHeo) FROM HorarioEspacioOcupante heo");
		Integer idReq = null;
		try {
			idReq = Integer.valueOf(q.setMaxResults(1).getSingleResult()
					.toString().trim());
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}

		return idReq;

	}

	@Override
	public List<HorarioEspacioOcupante> listarHEO() {
		StringBuilder queryString = new StringBuilder(
				"SELECT heo FROM HorarioEspacioOcupante heo");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacioOcupante> buscarHEO(int heo) {
		StringBuilder queryString = new StringBuilder(
				"SELECT heo FROM HorarioEspacioOcupante heo where heo.idHeo=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, heo);

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacioOcupante> buscarHEOXOcupante(String nombreOcupante) {
		StringBuilder queryString = new StringBuilder(
				"SELECT heo FROM HorarioEspacioOcupante heo where heo.ocupante.nombreOcupante like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + nombreOcupante + "%");

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacioOcupante> buscarHEOXIDOcupante(int idOcupante) {
		StringBuilder queryString = new StringBuilder(
				"SELECT heo FROM HorarioEspacioOcupante heo where heo.ocupante.idOcupante = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idOcupante);

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacioOcupante> buscarHEOXEspacio(int idHEO) {
		StringBuilder queryString = new StringBuilder(
				"SELECT heo FROM HorarioEspacioOcupante heo where heo.horarioEspacio.espacio.idEspacio = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idHEO);

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacioOcupante> reporteHEO(String carrera, String piso) {

		StringBuilder queryString = null;
		Query query = null;
		if (!carrera.equals("") && !piso.equals("")) {
			queryString = new StringBuilder(
					"SELECT heo FROM HorarioEspacioOcupante heo where heo.horarioEspacio.espacio.lugarEspacio.piso.edificio.nomEdificio like ?1 and heo.horarioEspacio.espacio.lugarEspacio.piso.nomPiso like ?2");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "%" + carrera + "%");
			query.setParameter(2, "%" + piso + "%");

		} else if (!carrera.equals("") && piso.equals("")) {
			queryString = new StringBuilder(
					"SELECT heo FROM HorarioEspacioOcupante heo where heo.horarioEspacio.espacio.lugarEspacio.piso.edificio.nomEdificio like ?1 ");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "%" + carrera + "%");

		} else if (carrera.equals("") && !piso.equals("")) {
			queryString = new StringBuilder(
					"SELECT heo FROM HorarioEspacioOcupante heo where heo.horarioEspacio.espacio.lugarEspacio.piso.nomPiso like ?1");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "%" + piso + "%");

		} else {
			queryString = new StringBuilder(
					"SELECT heo FROM HorarioEspacioOcupante heo ");
			query = getEntityManager().createQuery(queryString.toString());

		}
		return query.getResultList();
	}

	@Override
	public List<HorarioEspacioOcupante> listarHEO_Ocupados() {
		StringBuilder queryString = new StringBuilder(
				"SELECT heo FROM HorarioEspacioOcupante heo where heo.horarioEspacio.estadoEspacio.idEstadoEspacio like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, 1);

		return query.getResultList();
	}

}
