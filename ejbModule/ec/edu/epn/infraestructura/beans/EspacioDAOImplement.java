/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.Espacio;
import ec.edu.epn.infraestructura.entities.TipoEspacio;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EspacioDAOImplement extends DaoGenericoImplement<Espacio>
		implements EspacioDAO {

	@Override
	public int maxEspacio() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(esp.idEspacio) FROM Espacio esp");
		Integer idEspacio = null;

		try {
			idEspacio = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idEspacio = null;
		}
		if (idEspacio == null) {
			idEspacio = 1;
		} else {
			++idEspacio;
		}
		return idEspacio;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Espacio> buscarEspacioXTipo(String tipoEspacio) {

		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM Espacio espacio where espacio.tipoEspacio.nomTipoEspacio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, tipoEspacio);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Espacio> buscarEspacioXEstado(String estadoEspacio) {

		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM Espacio espacio where espacio.estadoEspacio.estadoEspacio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, estadoEspacio);

		return query.getResultList();

	}

	@Override
	public List<Espacio> buscarEspacioXCosto(double costoEspacio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM Espacio espacio where espacio.lugarEspacio.costoDiarioEsp=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, costoEspacio);

		return query.getResultList();
	}

	@Override
	public List<Espacio> buscarEspacioXCapacidad(int capacidadEspacio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM Espacio espacio where espacio.lugarEspacio.capacidad=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, capacidadEspacio);

		return query.getResultList();
	}

	@Override
	public List<Espacio> buscarEspacioXEdificio(String edificioEspacio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM Espacio espacio where espacio.lugarEspacio.piso.edificio.nomEdificio like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + edificioEspacio + "%");

		return query.getResultList();
	}

	@Override
	public List<Espacio> buscarEspacioXPiso(int idpiso) {
		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM Espacio espacio where espacio.lugarEspacio.piso.idPiso=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idpiso);

		return query.getResultList();
	}

	@Override
	public List<Espacio> reporteEspacios(String parametro) {
		StringBuilder queryString = null;
		Query query = null;
		if (parametro != null)
			if (parametro.equals("evento")) {
				queryString = new StringBuilder(
						"SELECT espacio FROM Espacio espacio where espacio.idEspacio IN (select eve.espacio.idEspacio from EventoEspacio eve)");
				query = getEntityManager().createQuery(queryString.toString());

			} else if (parametro.equals("ocupante")) {
				queryString = new StringBuilder(
						"SELECT espacio FROM Espacio espacio where espacio.idEspacio IN (select heo.horarioEspacio.espacio.idEspacio from HorarioEspacioOcupante heo)");
				query = getEntityManager().createQuery(queryString.toString());

			} else if (parametro.equals("")) {
				queryString = new StringBuilder(
						"SELECT espacio FROM Espacio espacio");
				query = getEntityManager().createQuery(queryString.toString());

			} else {
				queryString = new StringBuilder(
						"SELECT espacio FROM Espacio espacio");
				query = getEntityManager().createQuery(queryString.toString());
			}

		return query.getResultList();
	}

	@Override
	public List<Espacio> busquedaxparametros(TipoEspacio tipoespacio,
			EdificioInfra edificio, int capacidad, double costo) {

		Query query = null;
		StringBuilder queryString = null;

		queryString = new StringBuilder(
				"SELECT espacio FROM Espacio espacio where espacio.nomEspacio like ?1");
		// 25/10/2014 modifica busqueda.
		if (tipoespacio != null) {

			queryString
					.append(" and espacio.tipoEspacio.idTipoEspacio like ?2 ");
		}

		if (edificio != null && edificio.getNomEdificio() != null) {

			queryString
					.append(" and espacio.lugarEspacio.piso.edificio.nomEdificio like ?3 ");
		}

		if (capacidad != 0) {
			queryString.append(" and espacio.lugarEspacio.capacidad like ?4 ");
		}

		if (costo != 0) {
			queryString
					.append(" and espacio.lugarEspacio.costoDiarioEsp like ?5 ");
		}

		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%");

		if (tipoespacio != null) {

			query.setParameter(2, tipoespacio.getIdTipoEspacio());
		}
		if (edificio != null && edificio.getNomEdificio() != null) {

			query.setParameter(3, "%" + edificio.getNomEdificio() + "%");
		}

		if (capacidad != 0) {
			query.setParameter(4, capacidad);
		}

		if (costo != 0) {
			query.setParameter(5, costo);
		}

		return query.getResultList();
	}

	// 19/10/2014 evito borar tipos de espacio si estan siendo ocupados en
	// espacios Ocupados
	@Override
	public List<Espacio> buscarEspacioXTipoEpacio(TipoEspacio tipoEspacio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM Espacio espacio where espacio.tipoEspacio.idTipoEspacio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, tipoEspacio.getIdTipoEspacio());

		return query.getResultList();
	}

}
