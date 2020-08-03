/**
 * 
 */
package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.Departamento;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * @author Administrador
 * 
 */
@Stateless
public class DepartamentoDAOImplement extends DaoGenericoImplement<Departamento> implements DepartamentoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findbyIdFacultad(String idFacultad) {
		StringBuilder queryString = new StringBuilder(
				"SELECT dep FROM DepartamentoCatalogo dep where dep.facultad.idFacultad = ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idFacultad);
		return query.getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> findbDept() {
		StringBuilder queryString = new StringBuilder(
				"SELECT dep FROM DepartamentoCatalogo dep order by dep.nomDepart");
		Query query = getEntityManager().createQuery(queryString.toString());
		
		return query.getResultList();
	}
	
	
	@Override
	public Departamento dept(Integer iddetp) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select dep from DepartamentoCatalogo dep WHERE dep.idDepart = ?1");
		qUsuario.setParameter(1, iddetp);
		return (Departamento) qUsuario.getSingleResult();
	}


}
