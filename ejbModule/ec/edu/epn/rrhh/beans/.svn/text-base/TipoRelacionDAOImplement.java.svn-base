package ec.edu.epn.rrhh.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.TipoAccion;
import ec.edu.epn.rrhh.movimientos.TipoRelacion;

@Stateless
public class TipoRelacionDAOImplement extends DaoGenericoImplement<TipoRelacion> implements TipoRelacionDAO {

	public List<TipoRelacion> findTipoRelacionActivo() {
		
		Query q = getEntityManager().createQuery(
				"Select t from TipoRelacion t where t.descripcion='CONTRATO'");

		List<TipoRelacion> resultado = null;
		
		try{
			resultado = q.getResultList();
		}catch(NoResultException e){
			return resultado;
		}
		return resultado;
	}
	
	public List<TipoRelacion> findTipoRelacionConvenioActivo() {
		
		Query q = getEntityManager().createQuery(
				"Select t from TipoRelacion t where t.descripcion='CONVENIO'");

		List<TipoRelacion> resultado = null;
		
		try{
			resultado = q.getResultList();
		}catch(NoResultException e){
			return resultado;
		}
		return resultado;
	}

	

}
