package ec.edu.epn.catalogos.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.MaterialesRubrosEspacio;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class EmpleadosServiceBean
 */
@Stateless
public class MaterialRubrosEspaciosDAOImplement extends
		DaoGenericoImplement<MaterialesRubrosEspacio> implements
		MaterialesRubrosEspaciosDAO {

	@Override
	public int consultarID() {

		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.idMateriales)FROM MaterialesRubrosEspacio seg");

		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}
		return idReq;

	}

}
