package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;
import ec.edu.epn.laboratorioBJ.entities.Pureza;
import ec.edu.epn.laboratorioBJ.entities.Servicio;
import ec.edu.epn.laboratorioBJ.entities.UnidadLabo;

/**
 * Session Bean implementation class PersonalLabDAOImplement
 */
@Stateless
@LocalBean
public class PersonalLabDAOImplement extends DaoGenericoImplement<PersonalLab> implements PersonalLabDAO {

	/**
	 * Default constructor.
	 */
	public PersonalLabDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String maxIdPersonal(int id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT max(p.idPersonal) FROM PersonalLab p where p.idUnidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		String idPersonal = (String) query.getSingleResult();
		return idPersonal;
	}

	@Override
	public List<PersonalLab> listarPersonalById(int id) {

		System.out.println("idUnidad: " + id);
		StringBuilder queryString = new StringBuilder("SELECT p FROM PersonalLab p where p.idUnidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<PersonalLab> resultados = query.getResultList();
		return resultados;

	}

	@Override
	public List<PersonalLab> listarPersonalByServ(Servicio s, int id) {

		System.out.println("idUnidad: " + id);
		System.out.println("servicio lab: " + s.getLaboratorio().getIdLaboratorio());
		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM PersonalLab p, Usuario u, LaboratorioLab l, LaboratorioUsuario lu " + 
		"where p.idPersonal = u.idPersonal AND "
						+ "u.id = lu.id.idUsuario AND "
						+ "lu.id.idLaboratorio = l.idLaboratorio AND "
						+ "l.idLaboratorio = ?1 AND "
						+ "p.idUnidad = ?2 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, s.getLaboratorio().getIdLaboratorio());
		query.setParameter(2, id);
		
		List<PersonalLab> resultados = query.getResultList();
		return resultados;

	}

	public UnidadLabo buscarUnidadById(int id) {
		StringBuilder querys = new StringBuilder("SELECT u FROM UnidadLabo u where u.idUnidad = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			UnidadLabo unidadLabo = (UnidadLabo) query.getSingleResult();
			return unidadLabo;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

}
