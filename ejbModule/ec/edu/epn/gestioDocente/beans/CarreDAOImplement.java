package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Carre;

/**
 * Session Bean implementation class CarreDAOImplement
 */
@Stateless
@LocalBean
public class CarreDAOImplement extends DaoGenericoImplement<Carre>  implements CarreDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Carre> buscarCarreraBYNivel(String nivel) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Carre s where s.nivel = ?1   ");

		queryString.append(" order by s.carrera ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nivel.trim());
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Carre buscarCarreraBYID(String codCarre) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from Carre s where s.codCarre = ?1   ");

		queryString.append(" order by s.carrera ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, codCarre.trim());
		return (Carre) query.getSingleResult();
	}
   

}
