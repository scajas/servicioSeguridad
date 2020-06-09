package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.ProductoLab;
import ec.edu.epn.laboratorioBJ.entities.Servicio;
import ec.edu.epn.laboratorioBJ.entities.Tiposervicio;

/**
 * Session Bean implementation class ServicioDAOImplement
 */
@Stateless
@LocalBean
public class ServicioDAOImplement extends DaoGenericoImplement<Servicio> implements ServicioDAO {

	/**
	 * Default constructor.
	 */
	public ServicioDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	private String consulta;

	@Override
	public List<Servicio> listaServicioUnidad(int id) {

		StringBuilder queryString = new StringBuilder(
				"SELECT s FROM Servicio s where s.laboratorio.unidad.idUnidad = " + id + " AND s.estadoServicio like 'ACTIVO' ORDER BY s.nombreS ASC");
		Query query = getEntityManager().createQuery(queryString.toString());
		List<Servicio> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public String maxIdServ(int id) {

		StringBuilder queryString = new StringBuilder(
				"SELECT max(b.idServicio) FROM Servicio b where b.laboratorio.unidad.idUnidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);
		String idServ = (String) query.getSingleResult();

		return idServ;
	}

	@Override
	public List<Servicio> listaServicioXTipo(int id) {

		StringBuilder queryString = new StringBuilder(
				"SELECT s FROM Servicio s where s.laboratorio.unidad.idUnidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);
		List<Servicio> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public List<LaboratorioLab> listaLaboratorioUnidad(int id) {

		StringBuilder queryString = new StringBuilder("SELECT l FROM LaboratorioLab l where l.unidad.idUnidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);
		List<LaboratorioLab> resultados = query.getResultList();

		return resultados;
	}

	/////
	@Override
	public List<Servicio> getparametrosTipoServicio(String tiposervicio, int idUnidad) {

			setConsulta("SELECT DISTINCT (s) FROM Servicio s, LaboratorioLab l, Tiposervicio ts, UnidadLabo u "
					+ "WHERE s.laboratorio.idLaboratorio = l.idLaboratorio AND "
					+ "s.tiposervicio.idTiposerv = ts.idTiposerv AND "
					+ "s.laboratorio.unidad.idUnidad = u.idUnidad AND " + "u.idUnidad = " + idUnidad
					+ " AND s.tiposervicio.nombreTs like '" + tiposervicio + "' ORDER BY s.nombreS");

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());
		List<Servicio> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public List<Servicio> listaServicioById(int id) {

		StringBuilder queryString = new StringBuilder("SELECT s FROM Servicio s where s.idServicio = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);
		List<Servicio> resultados = query.getResultList();

		return resultados;

	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
}

