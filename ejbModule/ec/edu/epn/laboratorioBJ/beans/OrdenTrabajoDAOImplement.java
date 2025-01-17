package ec.edu.epn.laboratorioBJ.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.edu.epn.facturacion.entities.EstadoFactura;
import ec.edu.epn.facturacion.entities.Factura;
import ec.edu.epn.facturacion.entities.TransferenciaInterna;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

import ec.edu.epn.laboratorioBJ.entities.Cliente;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Muestra;
import ec.edu.epn.laboratorioBJ.entities.OrdenTrabajo;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;
import ec.edu.epn.laboratorioBJ.entities.Proforma;
import ec.edu.epn.laboratorioBJ.entities.Servicio;
import ec.edu.epn.laboratorioBJ.entities.Tipordeninv;

/**
 * Session Bean implementation class OrdenTrabajoDAOImplement
 */
@Stateless
@LocalBean
public class OrdenTrabajoDAOImplement extends DaoGenericoImplement<OrdenTrabajo> implements OrdenTrabajoDAO {

	private String consulta;
	private EntityManager em;

	@Override
	public List<Detalleorden> filtrarLista(String fechaInicio, String fechaFin, String tipoOrden, String analista,
			String estado) {

		setConsulta(
				"SELECT DISTINCT (do) FROM Detalleorden do, OrdenTrabajo ot, Servicio s, UnidadLabo u, LaboratorioLab l "
						+ "WHERE do.ordenTrabajo.idOrden = ot.idOrden AND " + "do.idServicio = s.idServicio AND "
						+ "s.laboratorio.idLaboratorio = l.idLaboratorio AND " + "l.unidad.idUnidad = u.idUnidad AND "
						+ " do.ordenTrabajo.fechaCierre BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "' AND "
						+ "do.ordenTrabajo.tipoOt like '" + tipoOrden + "' AND do.estadoDot like '" + estado
						+ "' AND do.personal.nombresPe like '" + analista + "' ORDER BY do.idDetalleorden");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Detalleorden> resultados = query.getResultList();

		return resultados;

	}

	@Override
	public List<OrdenTrabajo> listarOTInternaByUnidadLab(String id, int idUser, OrdenTrabajo ordenTrabajo,
			Date fechaInicio, Date fechaFin) {

		if (fechaInicio == null) {
			setConsulta("SELECT o FROM OrdenTrabajo o WHERE o.idOrden like '%" + ordenTrabajo.getIdOrden() + "%' "
					+ "AND o.cliente.rucCl like '%" + ordenTrabajo.getCliente().getRucCl() + "%' "
					+ "AND o.cliente.nombreCl like '%" + ordenTrabajo.getCliente().getNombreCl() + "%' "
					+ "AND o.cliente.cedula like '%" + ordenTrabajo.getCliente().getCedula() + "%' "
					+ "AND o.idOrden like '" + id + "-OTI%' " + " ORDER BY o.idOrden");
		} else if (fechaFin == null) {
			setConsulta("SELECT o FROM OrdenTrabajo o WHERE o.idOrden like '%" + ordenTrabajo.getIdOrden() + "%' "
					+ "AND o.cliente.rucCl like '%" + ordenTrabajo.getCliente().getRucCl() + "%' "
					+ "AND o.cliente.nombreCl like '%" + ordenTrabajo.getCliente().getNombreCl() + "%' "
					+ "AND o.cliente.cedula like '%" + ordenTrabajo.getCliente().getCedula() + "%' "
					+ "AND o.idOrden like '" + id + "-OTI%' " + "AND o.fechaordenOt = '" + cambioFecha(fechaInicio)
					+ "'" + " ORDER BY o.idOrden");
		} else {
			setConsulta("SELECT o FROM OrdenTrabajo o WHERE o.idOrden like '%" + ordenTrabajo.getIdOrden() + "%' "
					+ "AND o.cliente.rucCl like '%" + ordenTrabajo.getCliente().getRucCl() + "%' "
					+ "AND o.cliente.cedula like '%" + ordenTrabajo.getCliente().getCedula() + "%' "
					+ "AND o.cliente.nombreCl like '%" + ordenTrabajo.getCliente().getNombreCl() + "%' "
					+ "AND o.idOrden like '" + id + "-OTI%' " + "AND o.fechaordenOt BETWEEN '"
					+ cambioFecha(fechaInicio) + "' AND '" + cambioFecha(fechaFin) + "' ORDER BY o.idOrden");
		}

		// System.out.println("idUnidad: " + id);
		// System.out.println("idUsuario: " + idUser);

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<OrdenTrabajo> resultados = query.getResultList();
		System.out.println("Estos son los resultados: " + resultados.size());
		return resultados;
	}

	@Override
	public List<OrdenTrabajo> listarOTFacturaByUnidadLab(String id, int idUser, OrdenTrabajo ordenTrabajo,
			Date fechaInicio, Date fechaFin) {
		/**
		 * NOTA: El id de factura de OT es el idProforma que se trae desde la
		 * interfaz
		 */

		if (fechaInicio == null) {
			setConsulta("SELECT o FROM OrdenTrabajo o, Factura f WHERE o.idFactura = f.idFactura "
					+ "AND o.idOrden like '%" + ordenTrabajo.getIdOrden() + "%' " + "AND o.cliente.rucCl like '%"
					+ ordenTrabajo.getCliente().getRucCl() + "%' " + "AND o.cliente.nombreCl like '%"
					+ ordenTrabajo.getCliente().getNombreCl() + "%' " + "AND o.cliente.cedula like '%"
					+ ordenTrabajo.getCliente().getCedula() + "%' " + "AND f.idProforma like '%"
					+ ordenTrabajo.getIdFactura() + "%' " + "AND o.idOrden like '" + id + "%' "
					+ " ORDER BY o.idOrden");
		} else if (fechaFin == null) {
			setConsulta("SELECT o FROM OrdenTrabajo o, Factura f WHERE o.idFactura = f.idFactura "
					+ "AND o.idOrden like '%" + ordenTrabajo.getIdOrden() + "%' " + "AND o.cliente.rucCl like '%"
					+ ordenTrabajo.getCliente().getRucCl() + "%' " + "AND o.cliente.nombreCl like '%"
					+ ordenTrabajo.getCliente().getNombreCl() + "%' " + "AND o.cliente.cedula like '%"
					+ ordenTrabajo.getCliente().getCedula() + "%' " + "AND f.idProforma like '%"
					+ ordenTrabajo.getIdFactura() + "%' " + "AND o.idOrden like '" + id + "%' "
					+ "AND o.fechaordenOt = '" + cambioFecha(fechaInicio) + "'" + " ORDER BY o.idOrden");
		} else {
			setConsulta("SELECT o FROM OrdenTrabajo o, Factura f WHERE o.idFactura = f.idFactura "
					+ "AND o.idOrden like '%" + ordenTrabajo.getIdOrden() + "%' " + "AND o.cliente.rucCl like '%"
					+ ordenTrabajo.getCliente().getRucCl() + "%' " + "AND o.cliente.cedula like '%"
					+ ordenTrabajo.getCliente().getCedula() + "%' " + "AND o.cliente.nombreCl like '%"
					+ ordenTrabajo.getCliente().getNombreCl() + "%' " + "AND f.idProforma like '%"
					+ ordenTrabajo.getIdFactura() + "%' " + "AND o.idOrden like '" + id + "%' "
					+ "AND o.fechaordenOt BETWEEN '" + cambioFecha(fechaInicio) + "' AND '" + cambioFecha(fechaFin)
					+ "' ORDER BY o.idOrden");
		}

		// System.out.println("idUnidad: " + id);
		// System.out.println("idUsuario: " + idUser);

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<OrdenTrabajo> resultados = query.getResultList();
		System.out.println("Estos son los resultados: " + resultados.size());

		return resultados;
	}

	@Override
	public List<OrdenTrabajo> listarOTTransByUnidadLab(String id, int idUser, OrdenTrabajo ordenTrabajo,
			Date fechaInicio, Date fechaFin) {

		if (fechaInicio == null) {
			setConsulta("SELECT o FROM OrdenTrabajo o WHERE " + "o.idOrden like '%" + ordenTrabajo.getIdOrden() + "%' "
					+ "AND o.cliente.rucCl like '%" + ordenTrabajo.getCliente().getRucCl() + "%' "
					+ "AND o.cliente.nombreCl like '%" + ordenTrabajo.getCliente().getNombreCl() + "%' "
					+ "AND o.cliente.cedula like '%" + ordenTrabajo.getCliente().getCedula() + "%' "
					+ "AND o.idTi like '%" + ordenTrabajo.getIdTi() + "%' " + "AND o.idOrden like '" + id + "%' "
					+ "AND o.tipoOt = 'Externa Transf.' " + " ORDER BY o.idOrden");
		} else if (fechaFin == null) {
			setConsulta("SELECT o FROM OrdenTrabajo o WHERE " + "o.idOrden like '%" + ordenTrabajo.getIdOrden() + "%' "
					+ "AND o.cliente.rucCl like '%" + ordenTrabajo.getCliente().getRucCl() + "%' "
					+ "AND o.cliente.nombreCl like '%" + ordenTrabajo.getCliente().getNombreCl() + "%' "
					+ "AND o.cliente.cedula like '%" + ordenTrabajo.getCliente().getCedula() + "%' "
					+ "AND o.idTi like '%" + ordenTrabajo.getIdTi() + "%' " + "AND o.idOrden like '" + id + "%' "
					+ "AND o.tipoOt = 'Externa Transf.' " + "AND o.fechaordenOt = '" + cambioFecha(fechaInicio) + "'"
					+ " ORDER BY o.idOrden");
		} else {
			setConsulta("SELECT o FROM OrdenTrabajo o WHERE  " + "o.idOrden like '%" + ordenTrabajo.getIdOrden() + "%' "
					+ "AND o.cliente.rucCl like '%" + ordenTrabajo.getCliente().getRucCl() + "%' "
					+ "AND o.cliente.cedula like '%" + ordenTrabajo.getCliente().getCedula() + "%' "
					+ "AND o.cliente.nombreCl like '%" + ordenTrabajo.getCliente().getNombreCl() + "%' "
					+ "AND o.idTi like '%" + ordenTrabajo.getIdTi() + "%' " + "AND o.idOrden like '" + id + "%' "
					+ "AND o.tipoOt = 'Externa Transf.' " + "AND o.fechaordenOt BETWEEN '" + cambioFecha(fechaInicio)
					+ "' AND '" + cambioFecha(fechaFin) + "' ORDER BY o.idOrden");
		}

		// System.out.println("idUnidad: " + id);
		// System.out.println("idUsuario: " + idUser);

		// System.out.println(getConsulta());

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<OrdenTrabajo> resultados = query.getResultList();
		System.out.println("Estos son los resultadoaaaas: " + resultados.size());

		return resultados;
	}

	@Override
	public List<Servicio> listarServiciosByLabType(int idUni, int idTipo) {

		setConsulta("SELECT s FROM Servicio s WHERE s.laboratorio.unidad.idUnidad = " + idUni
				+ " AND s.tiposervicio.idTiposerv = " + idTipo + "  ORDER BY s.idServicio");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Servicio> resultados = query.getResultList();
		System.out.println("Estos son los resultados de servicios: " + resultados.size());
		return resultados;
	}

	@Override
	public List<Servicio> listarServiciosByPro(String idProforma) {

		setConsulta("SELECT s FROM Servicio s, DetalleProforma d WHERE d.servicio.idServicio = s.idServicio "
				+ "AND d.proforma.idProforma = '" + idProforma + "' ORDER BY s.idServicio");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Servicio> resultados = query.getResultList();
		System.out.println("Estos son los resultados de servicios: " + resultados.size());
		return resultados;
	}

	@Override
	public List<Factura> listarFacturasPagadas(int idUnidad, int idUsuario) {

		StringBuilder consulta = new StringBuilder();

		consulta.append(
				"SELECT DISTINCT (f) FROM Factura f, Detallefactura d, Servicio s,LaboratorioLab l, LaboratorioUsuario lu,Usuario u, EstadoFactura e"
						+ " WHERE f.idFactura = d.idFactura " + "AND f.idEstadoFactura = e.idEstadoFactura "
						+ "AND d.idServicio = s.idServicio " + "AND s.laboratorio.idLaboratorio = l.idLaboratorio "
						+ "AND l.idLaboratorio = lu.id.idLaboratorio " + "AND lu.id.idUsuario = u.id "
						+ "AND lu.id.idUsuario = 1692 " + "AND  u.id_unidad = 1 " + "AND e.idEstadoFactura = '2' "
						+ "ORDER BY f.idFactura DESC");

		Query q = super.getEntityManager().createQuery(consulta.toString());
		// q.setParameter(0, idUsuario); // 1692
		// q.setParameter(1, idUnidad);

		return q.getResultList();

	}

	@Override
	public List<Muestra> listarMuestraByFactura(String idFactura) {

		setConsulta("SELECT m FROM Muestra m WHERE m.idFactura = '" + idFactura + "'");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Muestra> resultados = query.getResultList();
		System.out.println("Estos son los resultados muestra: " + resultados.size());
		return resultados;

	}

	@Override
	public List<Muestra> listarMuestraByTI(String idTI) {

		setConsulta("SELECT m FROM Muestra m WHERE m.idTi = '" + idTI + "'");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Muestra> resultados = query.getResultList();
		System.out.println("Estos son los resultados muestra: " + resultados.size());
		return resultados;

	}

	@Override
	public List<TransferenciaInterna> listarTransferenciasInternas() {

		setConsulta("SELECT t FROM TransferenciaInterna t");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<TransferenciaInterna> resultados = query.getResultList();
		System.out.println("Estos son los resultados muestra: " + resultados.size());
		return resultados;

	}

	@Override
	public List<Factura> listarFacturasPagadas(int first, int pageSize, String sortField, boolean asc, int idUnidad,
			int idUsuario) {

		EntityManager em = getEntityManager();

		Session s = em.unwrap(Session.class);

		Criteria f = s.createCriteria(Factura.class, "f");
		// f.createAlias("", alias)
		f.add(Restrictions.eq("f.idEstadoFactura", "2"));

		f.setFirstResult(first);
		f.setMaxResults(pageSize);

		if (sortField != null) {
			if (asc) {
				f.addOrder(Order.asc(sortField));
			} else {
				f.addOrder(Order.asc(sortField));
			}
		}

		return f.list();

	}

	@Override
	public List<Factura> listarFacturasPagadasFiltro(int first, int pageSize, String sortField,
			Map<String, Object> filters, boolean asc, int idUnidad, int idUsuario) {

		String sql = "from " + Factura.class.getName() + " f";

		// String emailFilter = (String) filters.get("email");
		// String lastNameFilter = (String) filters.get("last");
		// String firstNameFilter = (String) filters.get("first");
		//
		// if (emailFilter != null) {
		// sql += " and user.email like :email ";
		// }
		//
		// if (lastNameFilter != null) {
		// sql += " and user.last like :lastName ";
		// }
		//
		// if (firstNameFilter != null) {
		// sql += " and user.first like :firstName ";
		// }

		if (sortField != null) {
			sql += " order by " + sortField + " " + (asc ? "ASC" : "DESC");
		}

		TypedQuery<Factura> query = em.createQuery(sql, Factura.class).setFirstResult(first).setMaxResults(pageSize);

		System.out.println("dsasd: " + query.getResultList().size() + " and " + sql);

		List<Factura> facturas = query.getResultList();

		return facturas;

	}

	@Override
	public int countFacturas(Map<String, Object> filters) {

		String sql = "select count(f) from " + Factura.class.getName() + " f";

		TypedQuery<Long> query = em.createQuery(sql, Long.class);

		return query.getSingleResult().intValue();
	}

	@Override
	public Long getTotalRegistros() {
		EntityManager em = getEntityManager();

		Session s = em.unwrap(Session.class);

		Criteria c = s.createCriteria(Factura.class);

		c.setProjection(Projections.rowCount());

		return (Long) c.uniqueResult();

	}

	@Override
	public List<Cliente> listarClienteBY(Cliente cliente) {

		setConsulta("SELECT c FROM Cliente c WHERE UPPER (c.nombreCl) like  UPPER('" + cliente.getNombreCl()
				+ "%') AND  (c.rucCl like '" + cliente.getRucCl() + "%' " + "OR c.cedula like '" + cliente.getRucCl()
				+ "%')  ORDER BY c.idCliente");

		System.out.println("idCliente: " + cliente.getRucCl());
		System.out.println("Nombre: " + cliente.getNombreCl());

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Cliente> resultados = query.getResultList();
		System.out.println("Estos son los resultados: " + resultados.size());
		return resultados;
	}

	@Override
	public List<Detalleorden> listarDetalleOrdenById(String id) {

		setConsulta("SELECT d FROM Detalleorden d where d.ordenTrabajo.idOrden = '" + id
				+ "' ORDER BY d.muestra.idMuestra");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Detalleorden> resultados = query.getResultList();
		System.out.println("Estos son los resultados: " + resultados.size());
		return resultados;
	}

	@Override
	public List<Servicio> listarServiciosByLab(String id) {

		setConsulta("SELECT s FROM Servicio s WHERE s.laboratorio.unidad.idUnidad = 1  ORDER BY s.idServicio");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Servicio> resultados = query.getResultList();
		System.out.println("Estos son los resultados de servicios: " + resultados.size());
		return resultados;
	}

	@Override
	public List<Metodo> listarMetodosByIdServicio(String id) {

		setConsulta("SELECT m FROM Metodo m WHERE m.servicio.idServicio = '" + id + "' ORDER BY m.nombreMt");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Metodo> resultados = query.getResultList();
		System.out.println("Estos son los resultados de metodos: " + resultados.size());
		return resultados;
	}

	@Override
	public String maxIdOTInterno(String id, String fecha) {
		String[] parts = fecha.split("-");

		String anio = parts[0];
		System.out.println("Este es el a�o: " + anio);

		StringBuilder queryString = new StringBuilder("SELECT max(o.idOrden) FROM OrdenTrabajo o where o.idOrden like '"
				+ id + "-OTI%' AND o.idOrden like '%" + anio + "%'");
		// new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());

		try {
			String idOrdeninventario = (String) query.getSingleResult();
			return idOrdeninventario;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
	}

	@Override
	public String maxIdOT(String id, String fecha) {
		String[] parts = fecha.split("-");

		String anio = parts[0];
		System.out.println("Este es el a�o: " + anio);

		StringBuilder queryString = new StringBuilder("SELECT max(o.idOrden) FROM OrdenTrabajo o WHERE "
				+ "(o.tipoOt = 'Externa Transf.' OR o.tipoOt = 'Externa Factura') " + "AND o.idOrden like '%" + id
				+ "%' AND o.idOrden like '%" + anio + "%'");
		// new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());

		try {
			String idOrdeninventario = (String) query.getSingleResult();
			return idOrdeninventario;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
	}

	@Override
	public String maxIdOTT(String id, String fecha) {
		String[] parts = fecha.split("-");

		String anio = parts[0];
		System.out.println("Este es el a�o: " + anio);

		StringBuilder queryString = new StringBuilder("SELECT max(o.idOrden) FROM OrdenTrabajo o WHERE "
				+ "(o.tipoOt = 'Externa Transf.' OR o.tipoOt = 'Externa Factura') " + "AND o.idOrden like '%" + id
				+ "%' AND o.idOrden like '%" + anio + "%'");
		// new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");s
		Query query = getEntityManager().createQuery(queryString.toString());

		try {
			String idOrdeninventario = (String) query.getSingleResult();
			return idOrdeninventario;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
	}

	@Override
	public OrdenTrabajo buscarOTById(String id) {
		StringBuilder querys = new StringBuilder("SELECT o FROM OrdenTrabajo o where o.idOrden = '" + id + "'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			OrdenTrabajo ordenTrabajo = (OrdenTrabajo) query.getSingleResult();
			return ordenTrabajo;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Factura buscarFacturaById(String id) {
		StringBuilder querys = new StringBuilder("SELECT f FROM Factura f where f.idFactura = '" + id + "'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Factura factura = (Factura) query.getSingleResult();
			return factura;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public EstadoFactura buscarEstadoFById(String id) {
		StringBuilder querys = new StringBuilder(
				"SELECT e FROM EstadoFactura e where e.idEstadoFactura = '" + id + "'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			EstadoFactura estadoFactura = (EstadoFactura) query.getSingleResult();
			return estadoFactura;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Cliente buscarClienteById(String id) {
		StringBuilder querys = new StringBuilder("SELECT c FROM Cliente c where c.idCliente = " + id);
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Cliente cliente = (Cliente) query.getSingleResult();
			return cliente;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public TransferenciaInterna buscarTransferenciaById(String id) {
		StringBuilder querys = new StringBuilder("SELECT t FROM TransferenciaInterna t where t.idTi = '" + id + "'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			TransferenciaInterna transferenciaInterna = (TransferenciaInterna) query.getSingleResult();
			return transferenciaInterna;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Proforma buscarProformaById(String id) {
		StringBuilder querys = new StringBuilder("SELECT p FROM Proforma p where p.idProforma = '" + id + "'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Proforma proforma = (Proforma) query.getSingleResult();
			return proforma;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public LaboratorioLab obtenerLaboratorioByUsr(int id, int uni) {
		StringBuilder querys = new StringBuilder(
				"SELECT l FROM LaboratorioLab l, LaboratorioUsuario u where u.id.idUsuario = " + id
						+ " AND u.id.idLaboratorio = l.idLaboratorio AND l.unidad.idUnidad = " + uni);
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			LaboratorioLab laboratorio = (LaboratorioLab) query.getSingleResult();
			System.out.println("Este es lab que tras: " + laboratorio.getNombreL() + laboratorio.getUnidad());
			return laboratorio;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public Metodo findMetodoById(String id) {
		StringBuilder querys = new StringBuilder("SELECT m FROM Metodo m where m.idMetodo = '" + id + "'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Metodo metodo = (Metodo) query.getSingleResult();
			return metodo;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}
	
	@Override
	public Tipordeninv findTipoInvById(String id) {
		StringBuilder querys = new StringBuilder("SELECT t FROM Tipordeninv t where t.idTipordeninv = '" + id + "'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Tipordeninv tipordeninv = (Tipordeninv) query.getSingleResult();
			return tipordeninv;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}


	@Override
	public Muestra muestraDefault() {
		StringBuilder querys = new StringBuilder("SELECT m FROM Muestra m where m.idMuestra = 'M-Default'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			Muestra muestra = (Muestra) query.getSingleResult();
			return muestra;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	/* Manejo de fechas */
	public String cambioFecha(Date fecha) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String fechaFinal = format.format(fecha);

		return fechaFinal;
	}

	public List<PersonalLab> listaPersonalAnalista() {
		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM PersonalLab p where p.cargospersonal.idCargo = '1' ");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<PersonalLab> resultados = query.getResultList();
		return resultados;
	}

	public List<LaboratorioLab> listaLaboratorioUnidad(int id) {
		StringBuilder queryString = new StringBuilder("SELECT l FROM LaboratorioLab l where l.unidad.idUnidad = ?0 ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, id);

		List<LaboratorioLab> resultados = query.getResultList();
		return resultados;
	}

	public List<OrdenTrabajo> removerListaOTI(List<OrdenTrabajo> ordenTrabajos) {

		for (OrdenTrabajo o : ordenTrabajos) {
			if (separarId(o.getIdOrden()).equals("OTI")) {
				ordenTrabajos.remove(o);
			}
		}

		return ordenTrabajos;
	}

	public String separarId(String idTemp) {
		String[] partsId = idTemp.split("-");
		idTemp = partsId[1].substring(0, 3);
		return idTemp;
	}

	public OrdenTrabajoDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

}
