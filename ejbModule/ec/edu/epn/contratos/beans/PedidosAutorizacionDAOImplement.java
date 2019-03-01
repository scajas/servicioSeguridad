package ec.edu.epn.contratos.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Actividades;
import ec.edu.epn.contratos.entities.CargaAcademica;
import ec.edu.epn.contratos.entities.Estado;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;


@Stateless
public class PedidosAutorizacionDAOImplement extends DaoGenericoImplement<Pedido> implements
PedidosAutorizacionDAO {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findPedidosSolicitados() {
		Query query = getEntityManager()
				.createQuery(
						"SELECT ped FROM Pedido ped where ped.estado.idEstado = 1 ORDER BY ped.fechaPedido ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findPedidosRevisados() {
		Query query = getEntityManager()
				.createQuery(
						"SELECT ped FROM Pedido ped where ped.estado.idEstado = 6 ORDER BY ped.fechaPedido ");
		return query.getResultList();
	}

	@Override
	public void updateEstadoPedido(Pedido pedido) {
		getEntityManager().merge(pedido);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actividades> findActividadesByParams(int idPedido) {

		StringBuilder queryString = new StringBuilder(
				"SELECT act FROM Actividade act WHERE act.pedido.idPedido =?0 ORDER BY act.idActividad ");

		if (idPedido == 0) {
			return null;
		}

		Query query = getEntityManager().createQuery(queryString.toString());

		if (idPedido != 0) {
			query.setParameter(0, idPedido);
		}

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CargaAcademica> findCargaAcadByParams(int idPedido) {
		StringBuilder queryString = new StringBuilder(
				"SELECT ca FROM CargaAcademica ca WHERE ca.pedido.idPedido =?0 ORDER BY ca.idCarga ");

		if (idPedido == 0) {
			return null;
		}

		Query query = getEntityManager().createQuery(queryString.toString());

		if (idPedido != 0) {
			query.setParameter(0, idPedido);
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findEstadoAutorizado() {
		Query query = getEntityManager().createQuery(
				"SELECT e FROM Estado e WHERE e.idEstado in (1, 2, 4) ");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findEstadoVerificado() {
		Query query = getEntityManager().createQuery(
				"SELECT e FROM Estado e WHERE e.idEstado in (3, 5) ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findPedidosAutorizados() {
		Query query = getEntityManager()
				.createQuery(
						"SELECT ped FROM Pedido ped where ped.estado.idEstado = 2 AND ped.pensum.estado= 'V' ORDER BY ped.fechaPedido ASC");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findEstadoRevisado() {
		Query query = getEntityManager().createQuery(
				"SELECT e FROM Estado e WHERE e.idEstado in (1,2,4) ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findPedidosVerificados() {
		Query query = getEntityManager()
				.createQuery(
						"SELECT ped FROM Pedido ped where ped.estado.idEstado = 3 ORDER BY ped.fechaPedido ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findAllEstados() {
		Query q = em.createQuery("Select est from Estado est");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findAEstadosXId(Integer idEstado) {
		Query q = em.createQuery("Select est from Estado est WHERE est.idEstado= ?0");
		q.setParameter(0, idEstado);
		return q.getResultList();
	}
	

	@Override
	public List<Estado> findAllEstadosBusquedas() {
		Query q = em
				.createQuery("Select est from Estado est where est.idEstado in (2,6,4,7,10,11,12)");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findPedidosByParam(String nombreDocente, String nced,
			int idEstado, Date fechaDesde, Date fechaHasta, String id_facultad,
			String perfilDecano, Pensum pensum) {

		String observ = "%";

		StringBuilder queryString = new StringBuilder(
				"select ped from Pedido ped where ped.observaciones like ?0 ");

		if (nombreDocente != null && !nombreDocente.equals("")) {
			queryString.append(" and ped.nombresDocente like ?1 ");
		}

		if (idEstado != 0) {
			queryString.append(" and ped.estado.idEstado like ?2 ");
		}

		if (fechaDesde != null & fechaHasta != null) {
			queryString.append(" and ped.fechaPedido BETWEEN ?3 AND ?4 ");
		}

		if (!perfilDecano.equals("Revisor 1 Talento Humano")
				&& !perfilDecano.equals("Revisor 2 Talento Humano")
				&& !perfilDecano.equals("Supervisor Talento Humano"))
			if (!id_facultad.equals("")) {
				queryString
						.append(" and ped.usuario.facultad.idFacultad = ?5 ");
			}

		if (pensum != null && pensum.getAñoPensum() != null) {
			queryString.append(" and ped.pensum.idPensum = ?6 ");
		}

		if (nced != null && !nced.equals("")) {
			queryString.append(" and ped.nced like ?7 ");
		}

		queryString.append("ORDER BY ped.fechaPedido asc");

		System.out.println("CONSULTA : " + queryString.toString());

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + observ + "%");

		if (nombreDocente != null && !nombreDocente.equals("")) {
			query.setParameter(1, "%" + nombreDocente + "%");
		}

		if (idEstado != 0) {
			query.setParameter(2, idEstado);
		}

		if (fechaDesde != null & fechaHasta != null) {
			query.setParameter(3, fechaDesde);
			query.setParameter(4, fechaHasta);

		}

		if (!perfilDecano.equals("Revisor 1 Talento Humano")
				&& !perfilDecano.equals("Revisor 2 Talento Humano")
				&& !perfilDecano.equals("Supervisor Talento Humano"))
			if (!id_facultad.equals("")) {
				query.setParameter(5, id_facultad);
			}

		if (pensum != null && pensum.getAñoPensum() != null) {
			query.setParameter(6, pensum.getIdPensum());
		}

		if (nced != null && !nced.equals("")) {
			query.setParameter(7, nced);
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findPedidosAsignadosPartida() {
		Query query = getEntityManager()
				.createQuery(
						"SELECT ped FROM Pedido ped where ped.estado.idEstado = 10 ORDER BY ped.fechaPedido ");
		return query.getResultList();
	}

	@Override
	public List<Pedido> findPedidosSolicitadosXParametros(String nombre,
			String cedula, Pensum pensum) {
		String observ = "%";

		System.out.println("NOMBRE DEL docente: " + nombre);

		StringBuilder queryString = new StringBuilder(
				"select ped from Pedido ped where ped.observaciones like ?0 and ped.estado.idEstado = 1");

		if (nombre != null && !nombre.equals("")) {
			System.out.println("entro al if de nombres append: " + nombre);
			queryString.append(" and ped.nombresDocente like ?1 ");
		}

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			queryString.append(" and ped.pensum.idPensum = ?3 ");
		}

		queryString.append("ORDER BY ped.fechaPedido ASC");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + observ + "%");

		if (nombre != null && !nombre.equals("")) {
			System.out.println("entro al if de nombres set parameters. "
					+ nombre);
			query.setParameter(1, "%" + nombre + "%");
		}

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(2, cedula);
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			query.setParameter(3, pensum.getIdPensum());
		}

		System.out.println("TAMAÑO DE LA BUSQUEDA: "
				+ query.getResultList().size());

		return query.getResultList();
	}

	@Override
	public List<Pedido> findPedidosAutorizadosXParametros(String cedula, String nombres, Pensum pensum) {
		String observ = "%";

		StringBuilder queryString = new StringBuilder(
				"select ped from Pedido ped where ped.observaciones like ?0 and  ped.estado.idEstado = 2");

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?1 ");
		}

		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?2 ");
		}
		
		if (pensum != null && pensum.getAñoPensum() != null) {
			queryString.append(" and ped.pensum.idPensum = ?3 ");
		}

		queryString.append("ORDER BY ped.fechaPedido ASC");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + observ + "%");

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(1, cedula);
		}
		if (nombres != null && !nombres.equals("")) {
			query.setParameter(2, "%" + nombres + "%");
		}
		
		if (pensum != null && pensum.getAñoPensum() != null) {
			query.setParameter(3, pensum.getIdPensum());
		}

		return query.getResultList();
	}

	@Override
	public List<Pedido> findPedidosVerificadosXParametros(String cedula,
			String nombres, Pensum pensum) {
		String observ = "%";

		StringBuilder queryString = new StringBuilder(
				"select ped from Pedido ped where ped.observaciones like ?0 and  ped.estado.idEstado = 3 and ped.tipoContrato.idTcont NOT IN (10, 11, 12) ");

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}
		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?3 ");
		}
		if (pensum != null && pensum.getIdPensum() != 0) {
			queryString.append(" and ped.pensum.idPensum = ?4 ");
		}

		queryString.append("ORDER BY ped.fechaPedido ASC");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + observ + "%");

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(2, cedula);
		}
		if (nombres != null && !nombres.equals("")) {
			query.setParameter(3, "%" + nombres + "%");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			query.setParameter(4, pensum.getIdPensum());
		}

		return query.getResultList();
	}

	@Override
	public List<Pedido> findPedidosAsignadosPartidaXParametros(String cedula,
			String nombres, Pensum pensum) {
		String observ = "%";

		StringBuilder queryString = new StringBuilder(
				"select ped from Pedido ped where ped.observaciones like ?0 and  ped.estado.idEstado = 10 ");

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}

		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?3 ");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			queryString.append(" and ped.pensum.idPensum = ?4 ");
		}

		queryString.append("ORDER BY ped.fechaPedido ASC");

		System.out.println("CONSULTA PEDIDO: " + queryString);

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + observ + "%");

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(2, cedula);
		}

		if (nombres != null && !nombres.equals("")) {
			query.setParameter(3, "%" + nombres + "%");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			query.setParameter(4, pensum.getIdPensum());
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findPedidosPeriodoActualXEstado(Integer idEstado) {
		Query query = getEntityManager()
				.createQuery(
						"SELECT ped FROM Pedido ped WHERE ped.estado.idEstado = ? AND ped.pensum.estado= 'V' AND ped.tipoContrato.idTcont NOT IN (10, 11, 12) ORDER BY ped.fechaPedido ASC");
		query.setParameter(1, idEstado);
		return query.getResultList();

	}

}
