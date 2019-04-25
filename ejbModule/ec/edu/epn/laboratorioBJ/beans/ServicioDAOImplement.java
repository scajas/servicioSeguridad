package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
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

	@Override
	public List<Servicio> listaServicioUnidad(Integer id) {
//		StringBuilder queryString = new StringBuilder(
//
//				"SELECT DISTINCT (b) FROM Servicio b, LaboratorioLab l, LaboratorioUsuario lu, Usuario usu, Unidad u"
//						+ " WHERE b.id_laboratorio = l.id_laboratorio AND l.id_laboratorio = lu.id_laboratorio AND lu.id_usuario = usu.id_usuario "
//						+ " AND u.id_unidad= ?1 ");
//
//		// new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");
		
		StringBuilder consulta = new StringBuilder();

		consulta.append(
				"SELECT DISTINCT (s) from Servicio s, LaboratorioLab l, LaboratorioUsuario lu, Usuario u"
						+ " where s.laboratorio.idLaboratorio = l.idLaboratorio and l.idLaboratorio = lu.id.idLaboratorio and lu.id.idUsuario = u.id "
						+ " and u.id_unidad = ?1 ");

		Query query = getEntityManager().createQuery(consulta.toString());
		query.setParameter(1, id);

		//List<Servicio> resultados = query.getResultList();
		return query.getResultList();
	}

	@Override
	public String maxIdServ(int id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT max(b.idServicio) FROM Servicio b where b.laboratorio.unidad.idUnidad = ?1 ");
		// new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		String idServ = (String) query.getSingleResult();
		return idServ;
	}

	@Override
	public List<Servicio> listaServicioXTipo(int id) {
		StringBuilder queryString = new StringBuilder("SELECT b FROM Servicio b where b.laboratorio.unidad.idUnidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Servicio> resultados = query.getResultList();
		return resultados;
	}
	
	@Override
	public List<LaboratorioLab> listaLaboratorioUnidad(int id) {
		StringBuilder queryString = new StringBuilder("SELECT b FROM LaboratorioLab b where b.unidad.idUnidad = ?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<LaboratorioLab> resultados = query.getResultList();
		return resultados;
	}

	/////
	@Override
	public List<Servicio> getparametrosTipoServicio(String tiposervicio) {

		StringBuilder queryString = new StringBuilder(
				"SELECT b FROM Servicio b where b.tiposervicio.nombreTs like '%" + tiposervicio + "%'");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Servicio> resultados = query.getResultList();
		return resultados;
	}

}
