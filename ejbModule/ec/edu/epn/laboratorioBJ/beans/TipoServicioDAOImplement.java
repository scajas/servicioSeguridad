package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Tiposervicio;

/**
 * Session Bean implementation class TipoServicioDAOImplement
 */
@Stateless
@LocalBean
public class TipoServicioDAOImplement extends DaoGenericoImplement<Tiposervicio> implements TipoServicioDAO {

	/**
	 * Default constructor.
	 */
	public TipoServicioDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Tiposervicio> getListTS() {

		StringBuilder queryString = new StringBuilder("SELECT ts FROM Tiposervicio ts ORDER BY nombreTs ASC");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Tiposervicio> resultados = query.getResultList();
		return resultados;
	}

}
