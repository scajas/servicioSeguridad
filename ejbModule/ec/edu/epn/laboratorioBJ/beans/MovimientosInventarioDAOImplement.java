package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Hidratacion;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.SaldoExistencia;

/**
 * Session Bean implementation class MovimientosInventarioDAOImplements
 */
@Stateless
@LocalBean
public class MovimientosInventarioDAOImplement extends DaoGenericoImplement<Movimientosinventario>
		implements MovimientosInventarioDAO {

	/**
	 * Default constructor.
	 */
	public MovimientosInventarioDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Existencia> listarExistenciaById(int id) {

		System.out.println("idUnidad: " + id);
		StringBuilder queryString = new StringBuilder("SELECT e FROM Existencia e where e.idUnidad = ?1 ORDER BY e.producto.nombrePr ASC ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<Existencia> resultados = query.getResultList();
		return resultados;

	}
	
	@Override
	public Existencia buscarExistenciaById(String id) {
		
		StringBuilder querys = new StringBuilder("SELECT e FROM Existencia e where e.idExistencia = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, id);
		query.setMaxResults(1); //fsaf

		try {
			Existencia existencia = (Existencia) query.getSingleResult();
			return existencia;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}
	
	@Override
	public SaldoExistencia validarSaldoExistencia(String fecha) {
		
		String[] parts = fecha.split("-");
		
		String anio = parts[0];
		String mes = parts[1];
		
		System.out.println("Este es el año: " + anio + " y este es el mes: " + mes);
		
		StringBuilder querys = new StringBuilder("SELECT s FROM SaldoExistencia s where s.Id.mes like '%" + mes + "%'");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setMaxResults(1);

		try {
			SaldoExistencia saldoExistencia = (SaldoExistencia) query.getSingleResult();
			
			return saldoExistencia;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}
	

}
