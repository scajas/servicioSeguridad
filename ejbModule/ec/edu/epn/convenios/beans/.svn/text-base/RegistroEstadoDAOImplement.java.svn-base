package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.convenios.entities.RegistroEstado;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class RegistroEstadoDAOImplement
 */
@Stateless
@LocalBean
public class RegistroEstadoDAOImplement extends DaoGenericoImplement<RegistroEstado> implements RegistroEstadoDAO {

	@Override
	public List<RegistroEstado> findregestados(int serial) {

		StringBuilder queryString = new StringBuilder(
				"SELECT res FROM RegistroEstado  res where res.convenio.serial = ?1 order by res.idRegest ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, serial);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}


}
