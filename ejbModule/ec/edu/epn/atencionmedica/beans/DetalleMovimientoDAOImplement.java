package ec.edu.epn.atencionmedica.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Detallemovimiento;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class DetalleMovimientoDAOImplement
 */
@Stateless
public class DetalleMovimientoDAOImplement extends DaoGenericoImplement<Detallemovimiento> implements DetalleMovimientoDAO{
	
	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;

	@Override
	public List<Detallemovimiento> obtenerListaDetalleMovimientos(String criterio) {
		List<Detallemovimiento> listaDetalleMovimientoEncontrados = null;
		
		Detallemovimiento d = new Detallemovimiento();
		d.getMovimientoinventario().getAtencionmedica().getIdAtencionmed();


		if(!criterio.isEmpty() && !criterio.equals("") && !criterio.equals(" ") && !criterio.equals("0")) {			
			
			q = "SELECT ins FROM Detallemovimiento ins "
					+ " WHERE ins.movimientoinventario.atencionmedica.idAtencionmed = ?0 ";
			q = q + " order by ins.insumomedico.nombreIsm ";

			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, Integer.parseInt(criterio.trim()));			

			listaDetalleMovimientoEncontrados = query.getResultList();
		}
		
		return listaDetalleMovimientoEncontrados;
	}

	@Override
	public Detallemovimiento obtenerDetallemovimiento(String criterio) {
		Detallemovimiento i = null;
		
		if (!criterio.isEmpty() && !criterio.equals("") && !criterio.equals(" ") && !criterio.equals("0")) { // criterio=			

			q = "SELECT ins FROM Detallemovimiento ins "
					+ " WHERE ins.idInsumomed = ?0 ";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, Integer.parseInt(criterio));

			try {
				i = (Detallemovimiento) query.getSingleResult();
				
			} catch (Exception e) {
				i = null;				
			}
		}

		return i;
	}

	@Override
	public Integer obtenerCantidadComprometidaInsumo(String criterio) {		
		List<Detallemovimiento> li = new ArrayList<Detallemovimiento>();
		Detallemovimiento i = new Detallemovimiento();
		
		int cantidad = 0;
		
		if (!criterio.isEmpty() && !criterio.equals("") && !criterio.equals(" ") && !criterio.equals("0")) {
			
			q = "SELECT d FROM Detallemovimiento d, Movimientoinventario m "
					+ " WHERE d.movimientoinventario.idMovimientoinv = m.idMovimientoinv "
					+ " AND to_char(m.fechahoraMov,'YYYY-MM-DD') = to_char(now(),'YYYY-MM-DD') "
					+ " AND m.catalogotipoestadomov.idCatalogo = 27 "
					//+ " AND m.catalogotipomovinventario.idCatalogo sea igual a 25 y 26 " //verificar si es importante en inventario
					+ " AND d.insumomedico.idInsumomed = ?0";
			
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, Integer.parseInt(criterio));
			
			
			try {
				i = (Detallemovimiento)query.getSingleResult();
				System.out.println("==================UN RESULADO: =====" + criterio);
				cantidad = i.getCantidadDet();
			} catch (NoResultException e) {
				System.out.println("==================CERO COINCIDENCIAS: =====" + criterio);
				cantidad = 0;
			} catch (NonUniqueResultException e) {
				System.out.println("==================VARIAS COINCIDENCIAS: =====" + criterio);
				li = query.getResultList();
				
				Iterator<Detallemovimiento> it = li.iterator();
				while (it.hasNext()) {
					cantidad += it.next().getCantidadDet();
				}
			} catch (Exception e) {
				System.out.println("==================ERROR EN LA BUSQUEDA: =====" + criterio);
				cantidad = 0;
			}
			return cantidad;
		}
		else
			return 0;
	}

}
