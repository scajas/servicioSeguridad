package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.Materia;
import ec.edu.epn.contratos.entities.CargaAcademica;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;



public @Stateless
class MateriaServiceBean implements MateriaService {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materia> findMateriaByParams(String codMateria,
			String nomMateria, String carrera) {

		try {
			System.out.println("--> " + codMateria + " ,-" + nomMateria + "-"
					+ carrera);

			// "SELECT ma FROM Materia ma WHERE ma.cargaAcademica.idCarga is null ");
			// nombreMateria codMateria
			StringBuilder queryString = null;
			Query query = null;
			if (!codMateria.equals("")) {
				queryString = new StringBuilder(
						"SELECT ma FROM Materia ma where ma.codMateria like ?1 and ma.carreraMateria like ?2");
				query = getEntityManager().createQuery(queryString.toString());
				query.setParameter(1, "%" + codMateria + "%");
				query.setParameter(2, carrera);
				System.out.println("TAMAÑOOOOOOOOOOOOO: "
						+ query.getResultList().size());

			} else if (!nomMateria.equals("")) {
				queryString = new StringBuilder(
						"SELECT ma FROM Materia ma where ma.nombreMateria like ?1 and ma.carreraMateria like ?2");
				query = getEntityManager().createQuery(queryString.toString());
				query.setParameter(1, "%" + nomMateria + "%");
				query.setParameter(2, carrera);
				System.out.println("TAMAÑOOOOOOOOOOOOO: "
						+ query.getResultList().size());
			} else {
				if (codMateria.equals("") && nomMateria.equals("")
						&& !carrera.equals("")) {
					queryString = new StringBuilder(
							"SELECT ma FROM Materia ma where ma.carreraMateria like ?1");
					query = getEntityManager().createQuery(
							queryString.toString());
					query.setParameter(1, carrera);
					System.out.println("TAMAÑOOOOOOOOOOOOO: "
							+ query.getResultList().size());
				} else
					return null;
			}

			return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR EN findMateriaByParams");
			StringBuilder queryString = new StringBuilder(
					"SELECT ma FROM Materia ma");
			Query query = getEntityManager()
					.createQuery(queryString.toString());
			System.out.println("TAMAÑOOOOOOOOOOOOO: "
					+ query.getResultList().size());
			return query.getResultList();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materia> findAllMateria() {
		// TODO Auto-generated method stub
		Query query = getEntityManager().createQuery(
				"SELECT ma FROM Materia ma");
		return query.getResultList();
	}

	@Override
	public void guardarCargaAcademica(CargaAcademica cargaAcademica) {
		getEntityManager().persist(cargaAcademica);

	}

	@Override
	public void actualizarMateria(Materia materia) {
		// TODO Auto-generated method stub
		getEntityManager().merge(materia);

	}

	@Override
	public void eliminarCargaAcademica(CargaAcademica cargaAcademica) {
		// TODO Auto-generated method stub
		getEntityManager().remove(getEntityManager().merge(cargaAcademica));
	}

	public int consultarId() {
		System.out.println("Entra ConsultarID !!!!!!!!!!!");
		Query q = getEntityManager().createQuery(
				"SELECT MAX(car.idCarga)FROM CargaAcademica car");

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
		System.out.println("ID NEXT CargaAcadem !!!!!!!!!!!!" + idReq);
		return idReq;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CargaAcademica> listaCargaAcademcica() {
		StringBuilder queryString = null;
		Query query = null;

		queryString = new StringBuilder("SELECT ma FROM CargaAcademica ma ");
		query = getEntityManager().createQuery(queryString.toString());
		System.out.println("TAMAÑOOOOOOOOOOOOO: "
				+ query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<CargaAcademica> buscarCargaXPedido(Pedido pedido) {
		StringBuilder queryString = null;
		Query query = null;
		queryString = new StringBuilder(
				"SELECT ma FROM CargaAcademica ma where ma.pedido.idPedido = ?1");
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, pedido.getIdPedido());
		System.out.println("TAMAÑOOOOOOOOOOOOO CARGA ACADEMICA: "
				+ query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<CargaAcademica> buscarCarga(String codigo, int idPedido) {
		StringBuilder queryString = null;
		Query query = null;

		queryString = new StringBuilder(
				"SELECT ma FROM CargaAcademica ma where ma.codMatSAE = ?1 and ma.pedido.idPedido = ?2");
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, codigo);
		query.setParameter(2, idPedido);
		System.out.println("TAMAÑOOOOOOOOOOOOO: "
				+ query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public boolean verificarExistenciaMateriaEnPedido(String idcarrera,
			String idmateria, String paral, Pensum pensum) {
		StringBuilder queryString = null;
		Query query = null;
		boolean ver = false;
		queryString = new StringBuilder(
				"SELECT ma FROM CargaAcademica ma where ma.idcarrerasaew = ?1 and ma.codmatsaew = ?2 and ma.paralelo = ?3 and ma.pedido.pensum.idPensum = ?4 ");
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idcarrera);
		query.setParameter(2, idmateria);
		query.setParameter(3, paral);
		query.setParameter(4, pensum.getIdPensum());
		

		System.out.println("TAMAÑOOOOOOOOOOOOO: "
				+ query.getResultList().size());

		if (query.getResultList().size() > 0)
			return true;
		else
			return false;
	}
}
