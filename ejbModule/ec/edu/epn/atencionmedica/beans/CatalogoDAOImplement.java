package ec.edu.epn.atencionmedica.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Catalogo;
import ec.edu.epn.atencionmedica.entities.Catalogotipo;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

@Stateless(mappedName = "CatalogoDAOImplement")
public class CatalogoDAOImplement extends DaoGenericoImplement<Catalogo> implements CatalogoDAO {

	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;

	@Override
	public Catalogo obtenerCatalogo(String criterio) {
		Catalogo i = new Catalogo();
		i.setCatalogotipo(new Catalogotipo());

		if (!criterio.isEmpty() && !criterio.equals("") && !criterio.equals(" ") && !criterio.equals("0")) { // criterio=
			// ""
			String q = "SELECT c FROM Catalogo c " + " WHERE c.idCatalogo = ?0 ";
			StringBuilder queryString = new StringBuilder(q);
			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(0, Integer.parseInt(criterio));

			try {
				i = (Catalogo) query.getSingleResult();
			} catch (Exception e) {
				System.out.println("=============================CATALOGO: =====" + i);
			}
		}

		return i;
	}

	/**
	 * Método que devuelve la lista de Tipos de movimiento de inventario, sin
	 * los tipos de despacho.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoMovimientoInventario() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 5 and cat.descripcionCat not like '%DESPACHO%' and cat.activoCat = true";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Método que devuelve la lista de Tipos de insumo médico.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoInsumoMedico() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 4 and cat.activoCat = true order by cat.descripcionCat";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Método que devuelve la lista de Tipos de paciente.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoPaciente() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 1 and cat.activoCat = true";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Método que devuelve la lista de Tipos de atención médica.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoAtencionMedica() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 2 and cat.activoCat = true";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Método que devuelve la lista de Tipos de especialidad.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoEspecialidad() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 3 and cat.activoCat = true";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Método que devuelve la lista de Tipos de movimiento inventario de tipo
	 * despacho.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoMovimientoInventarioDespacho() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 5 and cat.descripcionCat like '%DESPACHO%' and cat.activoCat = true";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Método que devuelve la lista de Tipos de estado de movimientos de
	 * inventario.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoEstadoMovimientoInventario() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 6 and cat.activoCat = true";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Método que devuelve la lista de Tipos de disponibilidad del personal.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoDisponibilidadPersonal() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 7 and cat.activoCat = true";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Método que devuelve la lista de Tipos de estado de tipo de personal
	 * médico.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoPersonalMedico() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 8 and cat.activoCat = true";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	/**
	 * Método para realizar los inserts
	 * 
	 * @return void
	 */
	@Override
	public boolean guardarTipoInsumoM(Catalogo catalog, String operacion) {
		if (operacion.equals("Ingresar")) {
			catalog.setCatalogotipo(obtenerCatalogoTipo("4"));
			getEntityManager().persist(catalog);
			return true;
		} else if (operacion.equals("Actualizar")) {
			getEntityManager().merge(catalog);
			return true;
		} else
			return false;
	}

	/**
	 * Método que devuelve un Catalogo tipo buscado por idCatalogoTipo.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public Catalogotipo obtenerCatalogoTipo(String criterio) {
		Catalogotipo i = new Catalogotipo();

		if (!criterio.isEmpty() && !criterio.equals("") && !criterio.equals(" ") && !criterio.equals("0")) { // criterio=
			// ""

			System.out.println("---------------------------------ServiceBean------------ BUSCAR CATALOGO");

			String q = "SELECT ct FROM Catalogotipo ct " + " WHERE ct.idCatalogotipo = ?0 ";
			StringBuilder queryString = new StringBuilder(q);
			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(0, Integer.parseInt(criterio));

			try {
				i = (Catalogotipo) query.getSingleResult();
				System.out.println("=============================CATALOGO: =====" + i.getIdCatalogotipo() + " "
						+ i.getNombreCat());
			} catch (Exception e) {
				System.out.println("=============================CATALOGO: =====" + i);
			}
		}

		return i;
	}

	@Override
	public boolean eliminarTipoInsumoM(Catalogo catalog, String operacion) {
		if (operacion.equals("Eliminar")){
			getEntityManager().remove(getEntityManager().merge(catalog));
			return true;
		}
		else
			
		return false;
	}

	/**
	 * Método que devuelve la lista de Tipos de insumo médico. 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoInsumoMed(String criterio) {
		List<Catalogo> listaDeTipoInsumosEncontrados;
		Query query = null;
		String q = "";
		StringBuilder queryString = null;

		if (criterio.isEmpty() || criterio.equals("") || criterio.equals(" ")
				|| criterio.equals("0")) { // criterio= ""
			
			q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 4 "; 
			q = q + " order by cat.descripcionCat";

			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());

			listaDeTipoInsumosEncontrados = query.getResultList();
		} else { // criterio = xxx
			
			q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 4 "
					+ "AND cat.descripcionCat like ?0";
			
			q = q + " order by cat.descripcionCat";
			
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, "%" + criterio.trim() + "%");

			listaDeTipoInsumosEncontrados = query.getResultList();
		}

		return listaDeTipoInsumosEncontrados;
	}

	@Override
	public boolean ActivarDesactivarTipoInsumoM(Catalogo catalog, String operacion) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * 
	 * Médtodos para el Tipo de presentación de insumo médico
	 * */

	/**
	 * Método que devuelve la lista de Tipos de presentación de insumo médico. 
	 * @return Lista<Catalogo>
	 */

	@Override
	public List<Catalogo> obtenerListaTipoPresentacionIM(String criterio) {
		List<Catalogo> listaDeTipoPresentacionInsumosEncontrados;
		Query query = null;
		String q = "";
		StringBuilder queryString = null;

		if (criterio.isEmpty() || criterio.equals("") || criterio.equals(" ")
				|| criterio.equals("0")) { // criterio= ""

			q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 9 "; 
			q = q + " order by cat.descripcionCat";

			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());

			listaDeTipoPresentacionInsumosEncontrados = query.getResultList();
		} else { // criterio = xxx
			
			q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 9 "
					+ "AND cat.descripcionCat like ?0";
			
			q = q + " order by cat.descripcionCat";
			
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, "%" + criterio.trim() + "%");

			listaDeTipoPresentacionInsumosEncontrados = query.getResultList();
		}

		
		return listaDeTipoPresentacionInsumosEncontrados;
	}

	@Override
	public boolean guardarTipoPresentacionIM(Catalogo catalog, String operacion) {
		if (operacion.equals("Ingresar")){			
			
			catalog.setCatalogotipo(obtenerCatalogoTipo("9"));
			
			getEntityManager().persist(catalog);
			return true;
		}
		else if (operacion.equals("Actualizar")){			
			getEntityManager().merge(catalog);
			return true;
		}
		else
		return false;
	}

	@Override
	public boolean eliminarTipoPresentacionIM(Catalogo catalog, String operacion) {
		if (operacion.equals("Eliminar")){
			getEntityManager().remove(getEntityManager().merge(catalog));
			return true;
		}
		else
			
		return false;
	}

	/**
	 * Método que devuelve la lista de Tipos de presentación de insumo medico. 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Catalogo> obtenerListaTipoPresentacionInsumoMedico() {
		//TODO
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 9 and cat.activoCat = true order by cat.descripcionCat";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	@Override
	public List<Catalogo> obtenerListaTipoProcedimientos() {
		String q = "SELECT cat FROM Catalogo cat WHERE cat.catalogotipo = 10 and cat.activoCat = true ORDER BY cat.descripcionCat";
		StringBuilder queryString = new StringBuilder(q);
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

}
