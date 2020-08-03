/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.TipoContrato;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Administrador
 * 
 */
@Stateless
public class TipoContratoDAOImplement extends
		DaoGenericoImplement<TipoContrato> implements TipoContratoDAO {

	@Override
	public TipoContrato buscarTCXNombre(String contrato) {
		StringBuilder queryString = new StringBuilder(
				"SELECT contr FROM TipoContrato contr where contr.nombreTcont like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + contrato + "%");
		System.out.println("LISTA DE CONTRATOS POR NOMBRE...!!!!!!!!!!!!");
		return (TipoContrato) query.getSingleResult();
	}

	@Override
	public List<TipoContrato> listaTiposContratos() {
		StringBuilder queryString = new StringBuilder(
				"SELECT contr FROM TipoContrato contr where contr.idTcont in (2,3)");
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}
	
	@Override
	public List<TipoContrato> listaTiposContratosAdicional() {
		StringBuilder queryString = new StringBuilder(
				"SELECT contr FROM TipoContrato contr where contr.idTcont in (2,3, 10, 11, 12,9) order by contr.nombreTcont");
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoContrato> listaTiposContratosPreplanif() {
		StringBuilder queryString = new StringBuilder(
				"SELECT contr FROM TipoContrato contr where contr.idTcont in (2,3,13,14)");
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}
}
