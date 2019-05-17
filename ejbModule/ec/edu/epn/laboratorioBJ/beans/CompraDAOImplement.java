package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Compra;

/**
 * Session Bean implementation class CompraDAOImplement
 */
@Stateless
@LocalBean
public class CompraDAOImplement extends DaoGenericoImplement<Compra> implements CompraDAO {

	private String consulta;

	/**
	 * Default constructor.
	 */
	public CompraDAOImplement() {

	}

	@Override
	public List<Compra> getParametrosCompra(String fechaInicio, String fechaFin) {

		setConsulta("SELECT c FROM Compra c, ProveedorLab pv "
				+ "WHERE c.proveedor.idProveedor = pv.idProveedor "
				+ "AND c.fechaCo BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'");

		System.out.println("FECHA DESDE: " + fechaInicio + " HASTA: " + fechaFin);
		System.out.println("Consulta: " + getConsulta());

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Compra> resultados = query.getResultList();
		return resultados;

	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

}
