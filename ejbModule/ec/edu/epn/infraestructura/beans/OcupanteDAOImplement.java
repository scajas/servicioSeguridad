package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.HorarioEspacioOcupante;
import ec.edu.epn.infraestructura.entities.Ocupante;

@Stateless
public class OcupanteDAOImplement extends DaoGenericoImplement<Ocupante>
		implements OcupanteDAO {

	@Override
	public int maxOcupante() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(o.idOcupante) FROM Ocupante o");
		Integer idOcupante = null;

		try {
			idOcupante = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idOcupante = null;
		}
		if (idOcupante == null) {
			idOcupante = 1;
		} else {
			++idOcupante;
		}
		return idOcupante;
	}

	@Override
	public Ocupante buscarEnEspacio(int idEspacio) {

		StringBuilder queryString = new StringBuilder(
				"SELECT ocup FROM Ocupante ocup where ocup.espacio.idEspacio = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idEspacio);

		return (Ocupante) query.getSingleResult();
	}

	@Override
	public List<HorarioEspacioOcupante> buscarOcupanteXEspacio(String nombre,
			String apellido, String cedula) {
		Query query = null;
		StringBuilder queryString = null;
		// INICIO 03.11.2014 solo se muestra los horarioEspacio con estado
		// Ocupado.
		if (nombre.equals("") && apellido.equals("") && cedula.equals("")) {
			queryString = new StringBuilder(
					"SELECT ocup FROM HorarioEspacioOcupante ocup where ocup.horarioEspacio.estadoEspacio.idEstadoEspacio like (1)");
			query = getEntityManager().createQuery(queryString.toString());
			// FIN 03.11.2014 solo se muestra los horarioEspacio con estado
			// Ocupado.
		} else {
			queryString = new StringBuilder(
					"SELECT ocup FROM HorarioEspacioOcupante ocup where ocup.ocupante.nombreOcupante like ?1 and ocup.ocupante.apellidoOcupante like ?2 and ocup.ocupante.cedulaOcupante like ?3 and ocup.horarioEspacio.estadoEspacio.idEstadoEspacio like (1)");
			query = getEntityManager().createQuery(queryString.toString());
			if (nombre.equals("")) {
				nombre = "%";

				query.setParameter(1, nombre);
			} else
				query.setParameter(1, "%" + nombre + "%");
			if (apellido.equals("")) {
				apellido = "%";

				query.setParameter(2, apellido);

			} else
				query.setParameter(2, "%" + apellido + "%");
			if (cedula.equals("")) {
				cedula = "%";

				query.setParameter(3, cedula);
			} else
				query.setParameter(3, cedula + "%");

		}

		return query.getResultList();
	}
}
