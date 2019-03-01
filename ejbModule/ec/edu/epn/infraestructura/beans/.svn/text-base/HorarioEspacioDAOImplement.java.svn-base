/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.Espacio;
import ec.edu.epn.infraestructura.entities.EstadoEspacio;
import ec.edu.epn.infraestructura.entities.Horario;
import ec.edu.epn.infraestructura.entities.HorarioEspacio;

/**
 * @author Administrador
 * 
 */
@Stateless
public class HorarioEspacioDAOImplement extends
		DaoGenericoImplement<HorarioEspacio> implements HorarioEspacioDAO {

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(he.idHorarioEspacio)FROM HorarioEspacio he");
		Integer idReq = null;
		try {
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

		return idReq;

	}

	@Override
	public List<HorarioEspacio> listarHE() {
		StringBuilder queryString = new StringBuilder(
				"SELECT he FROM HorarioEspacio he");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacio> listarHEOcupados() {
		StringBuilder queryString = new StringBuilder(
				"SELECT he FROM HorarioEspacio he where he.estadoEspacio.idEstadoEspacio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, 1);

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacio> buscarHE(int he) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Horario> buscarHorarioXIDEspacio(Espacio espacio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT he FROM HorarioEspacio he");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<HorarioEspacio> listaHorario = query.getResultList();

		List<Horario> horarios = new ArrayList<Horario>();
		for (HorarioEspacio he : listaHorario) {
			horarios.add(he.getHorario());
		}

		return horarios;
	}

	@Override
	public List<HorarioEspacio> buscarHorarioEspacioXIDEspacio(Espacio espacio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT he FROM HorarioEspacio he where he.espacio.idEspacio = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, espacio.getIdEspacio());

		return query.getResultList();
	}

	// Metodos para eventos Busqueda deespacios para reservacion
	@SuppressWarnings("unchecked")
	@Override
	public List<HorarioEspacio> buscarEspacioXTipo(String tipoEspacio) {

		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM HorarioEspacio espacio where espacio.espacio.tipoEspacio.nomTipoEspacio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, tipoEspacio);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HorarioEspacio> buscarEspacioXEstado(String estadoEspacio) {

		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM HorarioEspacio espacio where espacio.estadoEspacio.estadoEspacio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, estadoEspacio);

		return query.getResultList();

	}

	@Override
	public List<HorarioEspacio> buscarEspacioXCosto(double costoEspacio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM HorarioEspacio espacio where espacio.espacio.lugarEspacio.costoDiarioEsp=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, costoEspacio);

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacio> buscarEspacioXCapacidad(int capacidadEspacio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM HorarioEspacio espacio where espacio.espacio.lugarEspacio.capacidad=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, capacidadEspacio);

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacio> buscarEspacioXEdificio(String edificioEspacio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM HorarioEspacio espacio where espacio.espacio.lugarEspacio.piso.edificio.nomEdificio like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + edificioEspacio + "%");

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacio> buscarEspacioXPiso(int idpiso) {
		StringBuilder queryString = new StringBuilder(
				"SELECT espacio FROM HorarioEspacio espacio where espacio.espacio.lugarEspacio.piso.idPiso=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idpiso);

		return query.getResultList();
	}

	// 19/10/2014 Implementacion de metodo para controlar Delete de Estados
	// Espacios Utilizados.
	@Override
	public List<HorarioEspacio> buscarHorarioEspacioXEstadoEspacio(
			EstadoEspacio estadoEspacio) {

		StringBuilder queryString = new StringBuilder(
				"SELECT he FROM HorarioEspacio he where he.estadoEspacio.idEstadoEspacio = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, estadoEspacio.getIdEstadoEspacio());

		return query.getResultList();
	}

	@Override
	public List<HorarioEspacio> listarHELibres() {
		StringBuilder queryString = new StringBuilder(
				"SELECT he FROM HorarioEspacio he where he.estadoEspacio.idEstadoEspacio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, 2);

		return query.getResultList();
	}

}
