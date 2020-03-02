package ec.edu.epn.laboratorioBJ.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import ec.edu.epn.facturacion.entities.Factura;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Bodega;
import ec.edu.epn.laboratorioBJ.entities.Cliente;
import ec.edu.epn.laboratorioBJ.entities.DetalleProforma;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Muestra;
import ec.edu.epn.laboratorioBJ.entities.OrdenTrabajo;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;
import ec.edu.epn.laboratorioBJ.entities.Proforma;
import ec.edu.epn.laboratorioBJ.entities.Servicio;
import ec.edu.epn.laboratorioBJ.entities.laboratory;

/**
 * Session Bean implementation class OrdenTrabajoDAOImplement
 */
@Stateless
@LocalBean
public class OrdenTrabajoDAOImplement extends DaoGenericoImplement<OrdenTrabajo> implements OrdenTrabajoDAO {

	private String consulta;
	private EntityManager em;

	@Override
	public List<Detalleorden> filtrarLista(String fechaInicio, String fechaFin, String tipo, String estado,
			String laboratorio, String personal) {

		if (personal.equals("")) {
			setConsulta("SELECT o FROM Detalleorden o WHERE o.ordenTrabajo.estadoOt like '%" + estado
					+ "%' AND o.ordenTrabajo.fechaordenOt BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'");

		} else if (estado.equals("")) {
			setConsulta("SELECT o FROM Detalleorden o WHERE o.personal.nombresPe like '%" + personal
					+ "%' AND o.ordenTrabajo.fechaordenOt BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'");

		} else {
			setConsulta("SELECT o FROM Detalleorden o WHERE o.personal.nombresPe like '%" + personal
					+ "%' AND o.ordenTrabajo.estadoOt like '%" + estado + "%' AND o.ordenTrabajo.fechaordenOt BETWEEN '"
					+ fechaInicio + "' AND '" + fechaFin + "'");
		}

		System.out.println("FECHA DESDE: " + fechaInicio + "HASTA: " + fechaFin);
		System.out.println("Consulta: " + getConsulta());

		System.out.println(personal);

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Detalleorden> resultados = query.getResultList();

		return resultados;
		/*
		 * Query q = super.getEntityManager().
		 * createQuery("Select orden_trabajo from OrdenTrabajo orden_trabajo Where orden_trabajo.idOrden like ?1"
		 * ); q.setParameter(1, idOrden + "%");
		 * 
		 * return q.getResultList();
		 */

	}

	public void listarOTInterna() {

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
			setConsulta("SELECT o FROM OrdenTrabajo o WHERE o.idFactura = f.idFactura " + "AND o.idOrden like '%"
					+ ordenTrabajo.getIdOrden() + "%' " + "AND o.cliente.rucCl like '%"
					+ ordenTrabajo.getCliente().getRucCl() + "%' " + "AND o.cliente.nombreCl like '%"
					+ ordenTrabajo.getCliente().getNombreCl() + "%' " + "AND o.cliente.cedula like '%"
					+ ordenTrabajo.getCliente().getCedula() + "%' " + "AND f.idProforma like '%"
					+ ordenTrabajo.getIdFactura() + "%' " + "AND o.idOrden like '" + id + "%' "
					+ "AND o.fechaordenOt = '" + cambioFecha(fechaInicio) + "'" + " ORDER BY o.idOrden");
		} else {
			setConsulta("SELECT o FROM OrdenTrabajo o WHERE o.idFactura = f.idFactura " + "AND o.idOrden like '%"
					+ ordenTrabajo.getIdOrden() + "%' " + "AND o.cliente.rucCl like '%"
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
	public List<Factura> listarFacturasPagadas(int idUnidad, int idUsuario) {

		StringBuilder consulta = new StringBuilder();

		consulta.append(
				"SELECT DISTINCT (f) from Factura f, Proforma p, DetalleProforma d, Servicio s,LaboratorioLab l, LaboratorioUsuario lu,Usuario u"
						+ " where f.idProforma = p.idProforma and p.idProforma = d.proforma.idProforma and d.servicio.idServicio = s.idServicio and s.laboratorio.idLaboratorio = l.idLaboratorio and l.idLaboratorio = lu.id.idLaboratorio and lu.id.idUsuario = u.id "
						+ " and lu.id.idUsuario = ?0 and  u.id_unidad = ?1 and f.idEstadoFactura = '2' order by f.idFactura desc");

		Query q = super.getEntityManager().createQuery(consulta.toString());
		q.setParameter(0, idUsuario);
		q.setParameter(1, idUnidad);

		return q.getResultList();

	}

	@Override
	public List<Factura> listarFacturasPagadas(int first, int pageSize, String sortField, boolean asc, int idUnidad,
			int idUsuario) {

		EntityManager em = getEntityManager();

		Session s = em.unwrap(Session.class);

		Criteria c = s.createCriteria(Factura.class);

		c.setFirstResult(first);
		c.setMaxResults(pageSize);

		if (sortField != null) {
			if (asc) {
				c.addOrder(Order.asc(sortField));
			} else {
				c.addOrder(Order.asc(sortField));
			}
		}

		return c.list();

	}

	@Override
	public List<Factura> listarFacturasPagadasFiltro(int first, int pageSize, String sortField,
			Map<String, Object> filters, boolean asc, int idUnidad, int idUsuario) {
		
		
		String sql = "from " + Factura.class.getName() + " f";

//		String emailFilter = (String) filters.get("email");
//		String lastNameFilter = (String) filters.get("last");
//		String firstNameFilter = (String) filters.get("first");
//
//		if (emailFilter != null) {
//			sql += " and user.email like :email ";
//		}
//
//		if (lastNameFilter != null) {
//			sql += " and user.last like :lastName ";
//		}
//
//		if (firstNameFilter != null) {
//			sql += " and user.first like :firstName ";
//		}

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

        String sql = "select count(f) from "
                + Factura.class.getName() +
                " f";

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

		setConsulta("SELECT d FROM Detalleorden d where d.ordenTrabajo.idOrden = '" + id + "'");

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
		System.out.println("Este es el año: " + anio);

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
