package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Compra;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.Ordeninventario;

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
	public List<Compra> getParametrosCompra(String fechaInicio, String fechaFin, int idUnidad) {

		setConsulta(
				"SELECT DISTINCT (c) FROM Compra c, ProveedorLab pv, UnidadLabo u, Bodega b, Ordeninventario oi, Movimientosinventario mo, Existencia e "
						+ "WHERE c.unidad.idUnidad = u.idUnidad AND " 
						+ "b.idUnidad = u.idUnidad AND "
						+ "c.proveedor.idProveedor = pv.idProveedor AND " 
						+ "c.idCompra = oi.compra.idCompra AND "
						+ "oi.idOrdeninventario = mo.ordeninventario.idOrdeninventario AND "
						+ "mo.idExistencia = e.idExistencia AND " 
						+ "e.bodega.idBodega = b.idBodega AND "
						+ "c.unidad.idUnidad = " + idUnidad + " AND c.fechaCo BETWEEN '" + fechaInicio + "' AND '"
						+ fechaFin + "' ORDER BY c.idCompra");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Compra> resultados = query.getResultList();
		return resultados;

	}

	@Override
	public List<Compra> getListCompras(String id) {

		StringBuilder queryString = new StringBuilder(
				"SELECT c FROM Compra c where c.idCompra like '%" + id + "%' ORDER BY idCompra ASC");
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

	@Override
	public String maxIdOrdenI(int id, String fecha) {
		String[] parts = fecha.split("-");

		String anio = parts[0];
		System.out.println("Este es el anio: " + anio);

		StringBuilder queryString = new StringBuilder("SELECT max(c.idCompra) FROM Compra c where c.unidad.idUnidad = ?"
				+ "AND c.idCompra like '%" + anio + "%'");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		try {
			String idCompra = (String) query.getSingleResult();
			return idCompra;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}
	}

	@Override
	public List<Movimientosinventario> listaMovInv(String id) {

		System.out.println("ID que pasa" + id);
		StringBuilder queryString = new StringBuilder(
				"SELECT m FROM Movimientosinventario m WHERE m.ordeninventario.compra.idCompra = ?1  ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Movimientosinventario> resultados = query.getResultList();
		System.out.println("Resultados Obtenidos" + resultados.size());

		return resultados;

	}

	@Override
	public Ordeninventario ordenInvByCompra(String id) {

		StringBuilder querys = new StringBuilder("SELECT o FROM Ordeninventario o where o.compra.idCompra = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1);

		try {
			Ordeninventario ordenInv = (Ordeninventario) query.getSingleResult();

			return ordenInv;

		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

}
