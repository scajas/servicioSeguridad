/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.CalculoHorasDocencia;
import ec.edu.epn.gestionDocente.entities.CargaAcademicaSae;

/**
 * @author EPN
 * 
 */
@Stateless
public class CalculoHorasDocenciaDAOImplement extends
		DaoGenericoImplement<CalculoHorasDocencia> implements CalculoHorasDocenciaDAO {

	
	@Override
	public Integer valCalculoDocencia(CargaAcademicaSae dto){
		Integer valor= 0;
		try {
			Query q = getEntityManager()
					.createQuery(
							"SELECT c.horasCalculo FROM CalculoHorasDocencia c WHERE c.nivel= ? AND c.regimen= ? ");

			
			//q.setParameter(1, dto.getNivel().toUpperCase());
			//q.setParameter(2, dto.getRegimen().toUpperCase());
			
			valor= (Integer) q.getSingleResult();
			
			return valor;
		} catch (Exception e) {
			return 0;
		}
	}
	
}
