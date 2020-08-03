package ec.edu.epn.rrhh.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.DocuContrato;
import ec.edu.epn.rrhh.movimientos.TipoAccion;
import ec.edu.epn.rrhh.movimientos.TipoRelacion;

@Stateless
public class DocuContratoDAOImplement extends DaoGenericoImplement<DocuContrato> implements DocuContratoDAO {

	public List<DocuContrato> findTipoDocuContrato() {
		
		Query q = getEntityManager().createQuery(
				"Select t from DocuContrato t where t.estado='ACTIVO' and t.descripcion='CONTRATO'");

		List<DocuContrato> resultado = null;
		
		try{
			resultado = q.getResultList();
		}catch(NoResultException e){
			return resultado;
		}
		return resultado;
	}

	

}
