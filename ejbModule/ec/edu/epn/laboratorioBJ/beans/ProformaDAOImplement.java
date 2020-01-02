package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Proforma;

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
	public List<Proforma> getparametrosCliente(String fechaInicio, String fechaFin, Integer tipoCliente,
			String estadoPro) {
		if (tipoCliente == 0) {
			setConsulta("SELECT p FROM Proforma p, Cliente c, Tipocliente tc, Usuario u, UnidadLabo uni "
					+ "WHERE p.cliente.idCliente = c.idCliente " + "AND c.tipocliente.idTipocliente=tc.idTipocliente "
					+ "AND p.idUsuario = u.id " + "AND u.id_unidad = uni.idUnidad " + "AND p.estadoPo like '%"
					+ estadoPro + "%' AND p.fecha BETWEEN '" + fechaInicio + "' " + "AND '" + fechaFin
					+ "' ORDER BY p.idProforma ASC");
		} else if (estadoPro.equals(null)) {
			setConsulta("SELECT p FROM Proforma p, Cliente c, Tipocliente tc, Usuario u, UnidadLabo uni  "
					+ "WHERE p.cliente.idCliente = c.idCliente " + "AND c.tipocliente.idTipocliente= tc.idTipocliente "
					+ "AND p.idUsuario = u.id " + "AND u.id_unidad = uni.idUnidad "
					+ "AND p.cliente.tipocliente.idTipocliente like '%" + tipoCliente + "%' " + "AND p.fecha BETWEEN '"
					+ fechaInicio + "' AND '" + fechaFin + "' ORDER BY p.idProforma ASC");
		} else {

			setConsulta("SELECT p FROM Proforma p, Cliente c, Tipocliente tc, Usuario u, UnidadLabo uni  "
					+ "WHERE p.cliente.idCliente = c.idCliente " + "AND c.tipocliente.idTipocliente= tc.idTipocliente "
					+ "AND p.idUsuario = u.id " + "AND u.id_unidad = uni.idUnidad "
					+ "AND p.cliente.tipocliente.idTipocliente like '%" + tipoCliente + "%' " + "AND p.estadoPo like '%"
					+ estadoPro + "%' " + "AND p.fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin
					+ "' ORDER BY p.idProforma ASC");
		}

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Proforma> resultados = query.getResultList();
		System.out.println("Resultados Obtenidos: " + resultados.size());

		return resultados;

	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

}
