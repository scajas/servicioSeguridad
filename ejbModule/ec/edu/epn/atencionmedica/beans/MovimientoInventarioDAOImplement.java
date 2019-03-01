package ec.edu.epn.atencionmedica.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Catalogo;
import ec.edu.epn.atencionmedica.entities.Insumomedico;
import ec.edu.epn.atencionmedica.entities.Movimientoinventario;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class MovimientoInventarioDAOImplement
 */
@Stateless
public class MovimientoInventarioDAOImplement extends DaoGenericoImplement<Movimientoinventario>
		implements MovimientoInventarioDAO {

	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;		

	@Override
	public boolean actualizarDespachoDeMovimiento(Movimientoinventario movimientoinventario) {
		boolean val = false;
		Movimientoinventario movAux = getEntityManager().find(Movimientoinventario.class,
				movimientoinventario.getIdMovimientoinv());

		try {
			// Movimiento....actualizar despacho de insumos médicos
			movimientoinventario.setCatalogotipoestadomov((Catalogo) getEntityManager().find(Catalogo.class, 28));
			movimientoinventario.setMotivoMov(movimientoinventario.getMotivoMov().trim() + " DESPACHADO POR "
					+ movimientoinventario.getPersonal().getApellido1Prs().trim() + " "
					+ (movimientoinventario.getPersonal().getNombre1Prs() == null ? "" : movimientoinventario.getPersonal().getNombre1Prs().trim()) + " CON FECHA " + new Date());
			movimientoinventario.setPersonal(movAux.getPersonal());
			getEntityManager().merge(movimientoinventario);

			// Detalles del Movimiento
			for (int j = 0; j < movimientoinventario.getDetallemovimientos().size(); j++) {

				int cantidadADescontar = movimientoinventario.getDetallemovimientos().get(j).getCantidadDet();
				int cantidadActual = movimientoinventario.getDetallemovimientos().get(j).getInsumomedico()
						.getCantidadactualIsm();
				int cantidadNueva = cantidadActual - cantidadADescontar;

				movimientoinventario.getDetallemovimientos().get(j).getInsumomedico()
						.setCantidadactualIsm(cantidadNueva);
				getEntityManager().merge(movimientoinventario.getDetallemovimientos().get(j).getInsumomedico());
			}

			val = true;
		} catch (Exception e) {
			System.out.println("----Service Bean ------------actualizar despacho de insumos médicos - ERROR");
			e.printStackTrace();
			val = false;
		}
		return val;
	}

	@Override
	public boolean guardarMovimientoInventario(Movimientoinventario movimimientoInventario) {
		boolean val = false;

		try {

			getEntityManager().persist(movimimientoInventario);

			Movimientoinventario mov = movimimientoInventario;

			for (int j = 0; j < movimimientoInventario.getDetallemovimientos().size(); j++) {
				movimimientoInventario.getDetallemovimientos().get(j).setMovimientoinventario(mov);
				getEntityManager().persist(movimimientoInventario.getDetallemovimientos().get(j));

				int cantidadADescontar = movimimientoInventario.getDetallemovimientos().get(j).getCantidadDet();
				int cantidadActual = movimimientoInventario.getDetallemovimientos().get(j).getInsumomedico()
						.getCantidadactualIsm();
				int cantidadNueva = 0;

				if (movimimientoInventario.getCatalogotipomovinventario().getOperacionCat().equals("INGRESO")) {
					cantidadNueva = cantidadActual + cantidadADescontar;
				} else {
					cantidadNueva = cantidadActual - cantidadADescontar;
				}

				movimimientoInventario.getDetallemovimientos().get(j).getInsumomedico()
						.setCantidadactualIsm(cantidadNueva);

				Insumomedico aux = getEntityManager().find(Insumomedico.class,
						movimimientoInventario.getDetallemovimientos().get(j).getInsumomedico().getIdInsumomed());

				aux.setCantidadactualIsm(cantidadNueva);
				getEntityManager().merge(aux);
				getEntityManager().flush();

			}

			getEntityManager().clear();
			getEntityManager().clear();

			val = true;
		} catch (Exception e1) {
			System.out.println("/************** ERRROR GUARDAR: MOVIMIENTO DE INVENTARIO ************/");
			try {
				getEntityManager().getTransaction().rollback();
			} catch (IllegalStateException | SecurityException ex) {
				// ex.printStackTrace();
				System.out.println("/************** ERRROR AL REVERTIR: MOVIMIENTO DE INVENTARIO ************/");
			}
			val = false;
		}
		return val;
	}

	/*
	 * Obtener movimiento de inventario
	 * @see ec.edu.epn.atencionmedica.beans.MovimientoInventarioDAO#obtenerMovimientoInventario(ec.edu.epn.atencionmedica.entities.Movimientoinventario)
	 */
	@Override
	public Movimientoinventario obtenerMovimientoInventario(Movimientoinventario movimiento) {
		List<Movimientoinventario> listaMovimientoInventarioEncontradas = new ArrayList<Movimientoinventario>();

		if (movimiento.getIdMovimientoinv() == 0 && movimiento.getCatalogotipoestadomov().getIdCatalogo() == 6
				&& movimiento.getPersonal().getIdPersonal() > 0
				&& movimiento.getCatalogotipomovinventario().getIdCatalogo() == 5) {			
			q = "SELECT c FROM Movimientoinventario c" + " WHERE c.catalogotipoestadomov.idCatalogo = ?0 "
					+ " AND c.personal.idPersonal = ?1 " + " AND c.catalogotipomovinventario.idCatalogo = ?2 "
					+ " order by c.idAtencionmed desc ";
			// Si hay inconsistencias ...agregar la fecha para que valide con la
			// actual
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, movimiento.getCatalogotipoestadomov().getIdCatalogo());
			query.setParameter(1, movimiento.getPersonal().getIdPersonal());
			query.setParameter(2, movimiento.getCatalogotipomovinventario().getIdCatalogo());
		

			listaMovimientoInventarioEncontradas = query.getResultList();
			
		} else if (movimiento.getIdMovimientoinv() != 0) {
			// obtener la atencion mèdica por id de atencion medica
		}
		return listaMovimientoInventarioEncontradas.get(0);
	}

	@Override
	public int liberarMovimientosDeDespacho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Movimientoinventario> obtenerListaDespachosPendientes() {
		List<Movimientoinventario> listaAtencionesEncontradas = new ArrayList<Movimientoinventario>();
				
		q = "SELECT distinct m from Movimientoinventario m "
				+ " WHERE m.catalogotipoestadomov.idCatalogo = 27 "
				+ " and (m.catalogotipomovinventario.idCatalogo = 25 or m.catalogotipomovinventario.idCatalogo = 26) "
				+ " and to_char(m.fechahoraMov,'YYYY-MM-DD') = to_char(now(),'YYYY-MM-DD') "
				+ " order by m asc ";
		
		queryString = new StringBuilder(q);
		query = getEntityManager().createQuery(queryString.toString());

		listaAtencionesEncontradas = query.getResultList();


		return listaAtencionesEncontradas;
	}

	@Override
	public List<Movimientoinventario> obtenerListaMovimientos(Date fechaInicial, Date fechaFinal) {
		List<Movimientoinventario> listaMovEncontradas = new ArrayList<Movimientoinventario>();
				
		q = "SELECT m from Movimientoinventario m "
				+ " WHERE m.catalogotipomovinventario.idCatalogo between 19 and 24 "
				+ " AND m.fechahoraMov between ?0 and ?1 "
				+ " order by  m.fechahoraMov desc ";
		
		queryString = new StringBuilder(q);
		query = getEntityManager().createQuery(queryString.toString());		
		query.setParameter(0, fechaInicial);
		query.setParameter(1, fechaFinal);

		listaMovEncontradas = query.getResultList();
		
		System.out.println("Encontrados: " + listaMovEncontradas.size());
		return listaMovEncontradas;
	}

	@Override
	public List<Movimientoinventario> obtenerListaMovimientosInventario(Integer idAtencionMedica) {
		List<Movimientoinventario> listaMovEncontradas = new ArrayList<Movimientoinventario>();
		
		q = "SELECT m from Movimientoinventario m "
				+ " WHERE m.atencionmedica.idAtencionmed =  ?0";
		
		queryString = new StringBuilder(q);
		query = getEntityManager().createQuery(queryString.toString());		
		query.setParameter(0, idAtencionMedica);		

		listaMovEncontradas = query.getResultList();
				
		return listaMovEncontradas;
	}



}
