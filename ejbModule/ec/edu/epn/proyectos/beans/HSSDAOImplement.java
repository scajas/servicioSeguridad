package ec.edu.epn.proyectos.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Periodo;
import ec.edu.epn.proyectos.entities.Hss;

/**
 * Session Bean implementation class HSSDAOImplement
 */
@Stateless
@LocalBean
public class HSSDAOImplement extends DaoGenericoImplement<Hss> implements HSSDAO {

	@Override
	public Hss findHSSBy(Integer idtipo, Integer idrol,Integer anio) {

		try {
			StringBuilder queryString = new StringBuilder(
					"select pr from Hss pr where pr.rol.idRolProy = ?1 and pr.tipoproyecto.idTipoProy = ?2 and pr.anio = ?3  ");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, idrol);
			query.setParameter(2, idtipo);
			query.setParameter(3, anio);
			return (Hss) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException n) {
			return null;
		}
	}

}
