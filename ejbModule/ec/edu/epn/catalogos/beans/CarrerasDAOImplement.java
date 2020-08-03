/**
 * 
 */
package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;

import ec.edu.epn.catalogos.entities.Carrera;




/**
 * @author Administrador
 * 
 */
@Stateless
public class CarrerasDAOImplement extends DaoGenericoImplement<Carrera>
		implements CarrerasDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(act.idActividad) FROM Actividade act");
		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}		
		return idReq;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Carrera buscarCarreraBYID(String codCarre) throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT s from CarreraCatalogo s where s.idCarrera = ?1   ");

		queryString.append(" order by s.nomCarrera ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, codCarre.trim());
		return (Carrera) query.getSingleResult();
	}
	
	@Override
	public List<Carrera> listCarreraUsuario(Integer idUsuario) throws Exception{
		
		Query q = getEntityManager().createQuery(
				"SELECT c FROM ec.edu.epn.catalogos.entities.Carrera c, UsuarioCarrera uc WHERE c.idCarrera= uc.carrera.idCarrera AND uc.idUsuario = ?1");
		q.setParameter(1, idUsuario);
		return q.getResultList();
		
	}
}
