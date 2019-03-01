package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Insumomedico;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

@Stateless(mappedName = "InsumoMedicoDAOImplement")
public class InsumoMedicoDAOImplement extends DaoGenericoImplement<Insumomedico> implements InsumoMedicoDAO {

	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;

	/**
	 * M�todo que devuelve la lista de Objetos seg�n el criterio.
	 * 
	 * @return Lista<Catalogo>
	 */
	@Override
	public List<Insumomedico> obtenerListaInsumos(String criterio) {

		if (criterio.isEmpty() || criterio.equals("") || criterio.equals(" ") || criterio.equals("0")) { // criterio=
																											// ""

			q = "SELECT ins FROM Insumomedico ins WHERE ins.esodontIns = false";
			q = q + " order by ins.nombreIsm";

			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());

		} else { // criterio = xxx

			q = "SELECT ins FROM Insumomedico ins " + " WHERE ins.nombreIsm like ?0 AND ins.esodontIns = false";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, "%" + criterio.trim() + "%");

		}

		return query.getResultList();
	}

	/**
	 * M�todo que devuelve el Objeto seg�n el criterio.
	 * 
	 * @return Lista<Objeto>
	 */
	@Override
	public Insumomedico obtenerInsumomedico(String criterio) {
		Insumomedico i = null;

		if (!criterio.isEmpty() && !criterio.equals("") && !criterio.equals(" ") && !criterio.equals("0")) { // criterio=

			try {
				Integer.parseInt(criterio);
				q = "SELECT ins FROM Insumomedico ins " + " WHERE ins.idInsumomed = ?0 ";
				queryString = new StringBuilder(q);
				query = getEntityManager().createQuery(queryString.toString());
				query.setParameter(0, Integer.parseInt(criterio));

			} catch (NumberFormatException e1) {
				q = "SELECT ins FROM Insumomedico ins " + " WHERE ins.nombreIsm LIKE ?0 ";
				queryString = new StringBuilder(q);
				query = getEntityManager().createQuery(queryString.toString());
				query.setParameter(0, "%" + criterio.trim() + "%");
			}

			try {
				i = (Insumomedico) query.getSingleResult();
				System.out.println(
						"=============================INSUMO: =====" + i.getIdInsumomed() + " " + i.getNombreIsm());
			} catch (NoResultException e) {
				System.out.println("==================OBJETO NO ENCONTRADA: =====" + criterio);
				i = null;
			} catch (NonUniqueResultException e) {
				System.out.println("==================MAS DE UN OBJETO ENCONTRADO: =====" + criterio);
				i = (Insumomedico) query.getSingleResult();
			} catch (Exception e) {
				i = null;
				System.out.println("=============================INSUMO: =====" + i);
			}

		}

		return i;
	}

	/**
	 * M�todo para realizar los inserts
	 * 
	 * @return void
	 */
	@Override
	public boolean guardarInsumomedico(Insumomedico obj, String operacion) {
		if (operacion.equals("Ingresar")) {
			getEntityManager().persist(obj);
			return true;
		} else if (operacion.equals("Actualizar")) {
			getEntityManager().merge(obj);
			return true;
		} else
			return false;
	}

	/**
	 * M�todo para eliminar un registro
	 * 
	 * @return void
	 */
	@Override
	public boolean eliminarInsumomedico(Insumomedico obj, String operacion) {
		if (operacion.equals("Eliminar")) {
			getEntityManager().remove(getEntityManager().merge(obj));
			return true;
		} else
			return false;
	}

	@Override
	public List<Insumomedico> obtenerListaInsumosAsistenteM(String criterio) {
		if (criterio.isEmpty() || criterio.equals("") || criterio.equals(" ") || criterio.equals("0")) { // criterio=
			// ""

			q = "SELECT ins FROM Insumomedico ins WHERE ins.esodontIns = true";
			q = q + " order by ins.nombreIsm";

			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());

		} else { // criterio = xxx

			q = "SELECT ins FROM Insumomedico ins " + " WHERE ins.nombreIsm like ?0 AND ins.esodontIns = true";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(0, "%" + criterio.trim() + "%");

		}

		return query.getResultList();
	}

	@Override
	public Insumomedico obtenerInsumomedicoAsistente(String criterio) {
		Insumomedico i = null;

		if (!criterio.isEmpty() && !criterio.equals("") && !criterio.equals(" ") && !criterio.equals("0")) { // criterio=

			try {
				Integer.parseInt(criterio);
				q = "SELECT ins FROM Insumomedico ins " + " WHERE ins.idInsumomed = ?0 WHERE ins.esodontIns = true";
				queryString = new StringBuilder(q);
				query = getEntityManager().createQuery(queryString.toString());
				query.setParameter(0, Integer.parseInt(criterio));

			} catch (NumberFormatException e1) {
				q = "SELECT ins FROM Insumomedico ins " + " WHERE ins.nombreIsm LIKE ?0 AND ins.esodontIns = true";
				queryString = new StringBuilder(q);
				query = getEntityManager().createQuery(queryString.toString());
				query.setParameter(0, "%" + criterio.trim() + "%");
			}

			try {
				i = (Insumomedico) query.getSingleResult();
				System.out.println(
						"=============================INSUMO: =====" + i.getIdInsumomed() + " " + i.getNombreIsm());
			} catch (NoResultException e) {
				System.out.println("==================OBJETO NO ENCONTRADA: =====" + criterio);
				i = null;
			} catch (NonUniqueResultException e) {
				System.out.println("==================MAS DE UN OBJETO ENCONTRADO: =====" + criterio);
				i = (Insumomedico) query.getSingleResult();
			} catch (Exception e) {
				i = null;
				System.out.println("=============================INSUMO: =====" + i);
			}

		}

		return i;
	}

}
