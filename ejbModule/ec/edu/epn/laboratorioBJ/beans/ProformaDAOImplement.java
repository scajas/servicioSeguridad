package ec.edu.epn.laboratorioBJ.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Cliente;
import ec.edu.epn.laboratorioBJ.entities.DetalleProforma;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Ordeninventario;
import ec.edu.epn.laboratorioBJ.entities.Proforma;
import ec.edu.epn.laboratorioBJ.entities.Pureza;
import ec.edu.epn.laboratorioBJ.entities.Servicio;

/**
 * Session Bean implementation class ProformaDAOImplement
 */
@Stateless
@LocalBean
public class ProformaDAOImplement extends DaoGenericoImplement<Proforma> implements ProformaDAO {

	private String consulta;

	/**
	 * Default constructor.
	 */
	public ProformaDAOImplement() {

	}

	@Override
	public List<Proforma> getparametrosCliente(String fechaInicio, String fechaFin, String tipoCliente,
			String estadoPro) {

			setConsulta("SELECT p FROM Proforma p, Cliente c, Tipocliente tc, Usuario u, UnidadLabo uni  "
					+ "WHERE p.cliente.idCliente = c.idCliente " + "AND c.tipocliente.idTipocliente = tc.idTipocliente "
					+ "AND p.idUsuario = u.id " + "AND u.id_unidad = uni.idUnidad "
					+ "AND p.cliente.tipocliente.tipoTcl like '" + tipoCliente + "' " + "AND p.estadoPo like '"
					+ estadoPro + "' " + "AND p.fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "' "
					+ " ORDER BY p.idProforma");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Proforma> resultados = query.getResultList();
		return resultados;

	}

	@Override
	public List<Proforma> listaProformaByUnidadLab(String id, int idUser, Proforma proforma, Date fechaInicio,
			Date fechaFin) {

		if (fechaInicio == null) {
			setConsulta("SELECT p FROM Proforma p WHERE p.idProforma like '%" + proforma.getIdProforma() + "%' "
					+ "AND p.estadoPo like '%" + proforma.getEstadoPo() + "%' " + "AND p.cliente.rucCl like '%"
					+ proforma.getCliente().getRucCl() + "%' " + "AND p.cliente.nombreCl like '%"
					+ proforma.getCliente().getNombreCl() + "%' " + "AND p.idProforma like '%" + id + "%' "
					+ " ORDER BY p.idProforma");
		} else if (fechaFin == null) {
			setConsulta("SELECT p FROM Proforma p WHERE p.idProforma like '%" + "DC" + "%' " + "AND p.estadoPo like '%"
					+ proforma.getEstadoPo() + "%' " + "AND p.cliente.rucCl like '%" + proforma.getCliente().getRucCl()
					+ "%' " + "AND p.cliente.nombreCl like '%" + proforma.getCliente().getNombreCl() + "%' "
					+ "AND p.idProforma like '%" + id + "%' " + "AND p.fecha = '" + cambioFecha(fechaInicio) + "'"
					+ " ORDER BY p.idProforma");
		} else {
			setConsulta("SELECT p FROM Proforma p WHERE p.idProforma like '%" + proforma.getIdProforma() + "%' "
					+ "AND p.estadoPo like '%" + proforma.getEstadoPo() + "%' " + "AND p.cliente.rucCl like '%"
					+ proforma.getCliente().getRucCl() + "%' " + "AND p.cliente.nombreCl like '%"
					+ proforma.getCliente().getNombreCl() + "%' " + "AND p.idProforma like '%" + id + "%' "
					+ "AND p.fecha BETWEEN '" + cambioFecha(fechaInicio) + "' AND '" + cambioFecha(fechaFin)
					+ "' ORDER BY p.idProforma");
		}

		// System.out.println("idUnidad: " + id);
		// System.out.println("idUsuario: " + idUser);

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Proforma> resultados = query.getResultList();
		System.out.println("Estos son los resultados: " + resultados.size());
		return resultados;
	}

	@Override
	public List<Proforma> listaAllProformas(String id, int idUser, Proforma proforma, Date fechaInicio, Date fechaFin) {

		if (fechaInicio == null) {
			setConsulta("SELECT p FROM Proforma p WHERE p.idProforma like '%" + proforma.getIdProforma() + "%' "
					+ "AND p.estadoPo like '%" + proforma.getEstadoPo() + "%' " + "AND p.cliente.rucCl like '%"
					+ proforma.getCliente().getRucCl() + "%' " + "AND p.cliente.nombreCl like '%"
					+ proforma.getCliente().getNombreCl() + "%' " + " ORDER BY p.idProforma");
		} else if (fechaFin == null) {
			setConsulta("SELECT p FROM Proforma p WHERE p.idProforma like '%" + proforma.getIdProforma() + "%' "
					+ "AND p.estadoPo like '%" + proforma.getEstadoPo() + "%' " + "AND p.cliente.rucCl like '%"
					+ proforma.getCliente().getRucCl() + "%' " + "AND p.cliente.nombreCl like '%"
					+ proforma.getCliente().getNombreCl() + "%' " + "AND p.fecha = '" + cambioFecha(fechaInicio) + "'"
					+ " ORDER BY p.idProforma");
		} else {
			setConsulta("SELECT p FROM Proforma p WHERE p.idProforma like '%" + proforma.getIdProforma() + "%' "
					+ "AND p.estadoPo like '%" + proforma.getEstadoPo() + "%' " + "AND p.cliente.rucCl like '%"
					+ proforma.getCliente().getRucCl() + "%' " + "AND p.cliente.nombreCl like '%"
					+ proforma.getCliente().getNombreCl() + "%' " + "AND p.fecha BETWEEN '" + cambioFecha(fechaInicio)
					+ "' AND '" + cambioFecha(fechaFin) + "' ORDER BY p.idProforma");
		}

		// System.out.println("idUnidad: " + id);
		// System.out.println("idUsuario: " + idUser);

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Proforma> resultados = query.getResultList();
		System.out.println(
				"Estos son los resultados de todas las proformas: " + resultados.size() + "adc: " + getConsulta());
		return resultados;
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
	public List<DetalleProforma> listarDetalleProByIdPro(String id) {

		setConsulta("SELECT d FROM DetalleProforma d where d.proforma.idProforma = '" + id
				+ "' ORDER BY d.servicio.nombreS DESC");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<DetalleProforma> resultados = query.getResultList();
		System.out.println("Estos son los resultados: " + resultados.size());
		return resultados;
	}

	@Override
	public List<Servicio> listarServiciosByLab(String id) {

		setConsulta("SELECT s FROM Servicio s WHERE s.laboratorio.unidad.idUnidad = " + id + " ORDER BY s.idServicio");

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
	public String maxIdProforma(String id, String fecha) {
		String[] parts = fecha.split("-");

		String anio = parts[0];
		System.out.println("Este es el año: " + anio);

		StringBuilder queryString = new StringBuilder(
				"SELECT max(p.idProforma) FROM Proforma p where p.idProforma like '" + id
						+ "-%' AND p.idProforma like '%" + anio + "%'");
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

	/* Manejo de fechas */
	public String cambioFecha(Date fecha) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String fechaFinal = format.format(fecha);

		return fechaFinal;
	}

	@Override
	public DetalleProforma getServicio(String id) {
		StringBuilder querys = new StringBuilder("SELECT d FROM DetalleProforma d where d.proforma.idProforma = '" + id
				+ "' ORDER BY d.servicio.nombreS DESC");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			DetalleProforma detallePro = (DetalleProforma) query.getSingleResult();
			return detallePro;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

}


