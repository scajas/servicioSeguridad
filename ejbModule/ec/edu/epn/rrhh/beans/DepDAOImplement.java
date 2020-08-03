/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Dep;

/**
 * @author Administrador
 * 
 */
@Stateless
public class DepDAOImplement extends DaoGenericoImplement<Dep> implements DepDAO {

	@Override
	public Dep findDepbyCodigo(String cod_dep) throws NoResultException, Exception {

		Dep dep = new Dep();
		try {

			Query q = super.getEntityManager().createQuery("Select dep from Dep dep where dep.codDep = ?1 ");
			q.setParameter(1, cod_dep);

			dep = (Dep) q.getSingleResult();
		} catch (NoResultException e) {

			dep = null;
			throw new NoResultException("No se encontró departamentos por la facultad buscada");
		}

		catch (NonUniqueResultException e) {

			dep = null;
			throw new NonUniqueResultException("Varios departamento con el mismo codigo");
		}

		catch (Exception e) {
			dep = null;
			e.printStackTrace();
			throw new Exception("Error al buscar los departamentos");
		}

		return dep;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Dep> listDepartamentos(String nombre) throws Exception {
		Query query = super.getEntityManager().createNamedQuery("Dep.findDepOrder");
		query.setParameter("nombre", nombre);
		return query.getResultList();

	}

	@Override
	public Dep findCodDepByIdFacultad(Integer idFacultad) throws Exception {
		Query q = getEntityManager().createQuery("Select dep from Dep dep where dep.idFacultad = ?1 ");
		q.setParameter(1, idFacultad);
		return (Dep) q.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Dep> findAllDep() throws Exception {
		Query query = super.getEntityManager().createNamedQuery("Dep.findAll");

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> listaDepXFacultad() {
		StringBuilder queryString = new StringBuilder(
				"SELECT e from Dep e where (e.nomDep LIKE 'DEPARTAMENTO%' OR e.nomDep LIKE '%INSTITUTO GEOFISICO%')");
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Lista los departamentos por el id de facultad
	 * 
	 * @param idFacultad
	 *            - Integer con el id de la facultad a listar
	 * @return lista de departamentos por el id de facultad buscado
	 * @throws NoResultException
	 *             - Excepcion lanzada cuando no se encuentra la entidad
	 * @throws Exception
	 *             - Excepcion general
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> listaDepXfacultad(Integer idFacultad) throws NoResultException, Exception {
		List<Dep> retorno = null;
		try {
			StringBuilder queryFacultad = new StringBuilder();
			Dep dep = new Dep();
			dep.setCodDep("-99");
			if (!idFacultad.equals(Integer.valueOf("-99"))) {
				queryFacultad.append(" SELECT dep from Dep dep where dep.idFacultad = :idFacultad ");
				Query queryFac = getEntityManager().createQuery(queryFacultad.toString());
				queryFac.setParameter("idFacultad", idFacultad);
				dep = (Dep) queryFac.getSingleResult();
			}

			StringBuilder queryString = new StringBuilder();
			queryString.append(" SELECT dep from Dep dep ");
			if (!dep.getCodDep().equals("-99")) {
				queryString.append(" where dep.codDep like :idDep");
				queryString.append(" and dep.codDep <> :idDepNotIn");
				queryString.append(" and dep.tipoDep = :tipoDep");
			}

			Query query = getEntityManager().createQuery(queryString.toString());
			if (!dep.getCodDep().equals("-99")) {
				query.setParameter("idDep", "%" + dep.getCodDep() + "%");
				query.setParameter("idDepNotIn", dep.getCodDep());
				query.setParameter("tipoDep", "DEP");

			}
			retorno = query.getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("No se encontró departamentos por la facultad buscada");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar los departamentos");
		}
		return retorno;
	}

	/**
	 * Lista las facultades
	 * 
	 * @return lista de facultades
	 * @throws NoResultException
	 *             - Excepcion lanzada cuando no se encuentra la entidad
	 * @throws Exception
	 *             - Excepcion general
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> listarFacultades() throws NoResultException, Exception {
		List<Dep> retorno = null;
		try {
			StringBuilder queryFacultad = new StringBuilder();
			queryFacultad.append(" SELECT dep from Dep dep ");
			queryFacultad.append(" where dep.idFacultad is not null");
			queryFacultad.append(" and dep.tipoDep = 'FAC'");
			Query query = getEntityManager().createQuery(queryFacultad.toString());
			retorno = query.getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("No se encontró facultades");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar las facultades");
		}
		return retorno;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Dep> findDepByFacultad(String coddep) throws Exception {
		List<Dep> retorno = null;
		try {
			StringBuilder queryFacultad = new StringBuilder();
			queryFacultad.append(" SELECT dep from Dep dep ");
			queryFacultad.append(" where dep.codDep like ?1 ");
			queryFacultad.append(" and dep.tipoDep = 'DEP'");
			Query query = getEntityManager().createQuery(queryFacultad.toString());

			query.setParameter(1, "%" + coddep + "%");
			retorno = query.getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("No se encontró departamentos");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar los departamentos");
		}
		return retorno;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dep> departamentos() {

		StringBuilder queryString = new StringBuilder(
				"SELECT conv FROM Dep conv where conv.tipoDep = 'DEP'  ORDER BY conv.nomDep ");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();

	}

}
