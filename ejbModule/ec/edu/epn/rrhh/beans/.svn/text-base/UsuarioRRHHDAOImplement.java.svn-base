package ec.edu.epn.rrhh.beans;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.UsuarioRrhh;

@Stateless
public class UsuarioRRHHDAOImplement  extends DaoGenericoImplement<UsuarioRrhh> implements UsuarioRRHHDAO{

	@Override
	public UsuarioRrhh getUsuarioById(String idUsuario) {
 		StringBuilder queryString = new StringBuilder(
				"SELECT usr from UsuarioRrhh usr where usr.idUsuario = :usuario ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("usuario", Integer.valueOf(idUsuario));
		UsuarioRrhh resultado = null;
		try{
			resultado = (UsuarioRrhh) query.getSingleResult();
		}catch(NoResultException e){
			e.printStackTrace();
		}catch(NonUniqueResultException e){
			e.printStackTrace();
		}
		
		return resultado;

	}

}
