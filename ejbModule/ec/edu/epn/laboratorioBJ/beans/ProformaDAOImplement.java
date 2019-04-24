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

		if (tipoCliente.equals(null)) {
			setConsulta("SELECT p FROM Proforma p WHERE p.estadoPo like '%" + estadoPro + "%' AND p.fecha BETWEEN '"
					+ fechaInicio + "' AND '" + fechaFin + "'");
		} else if (estadoPro.equals("")) {
			setConsulta("SELECT p FROM Proforma p WHERE p.cliente.tipocliente.idTipocliente like '%" + tipoCliente
					+ "%' AND p.fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'");
		} else {
			setConsulta("SELECT p FROM Proforma p WHERE p.cliente.tipocliente.idTipocliente like '%" + tipoCliente
					+ "%' AND p.estadoPo like '%" + estadoPro + "%' AND p.fecha BETWEEN '" + fechaInicio + "' AND '"
					+ fechaFin + "'");
		}

		System.out.println("FECHA DESDE: " + fechaInicio + " HASTA: " + fechaFin);
		System.out.println("Consulta: " + getConsulta());

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Proforma> resultados = query.getResultList();
		return resultados;

	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

}
