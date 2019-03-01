/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.LugarEspacio;
import ec.edu.epn.infraestructura.entities.TipoInfraestructura;

/**
 * @author Administrador
 * 
 */
@Stateless
public class EdificioDAOImplement extends DaoGenericoImplement<EdificioInfra> implements EdificioDAO {

	@Override
	public int maxEdifico() {
		Query q = getEntityManager().createQuery("SELECT MAX(edi.idEdificio) FROM EdificioInfra edi");
		Integer idEdificio = null;

		try {
			idEdificio = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idEdificio = null;
		}
		if (idEdificio == null) {
			idEdificio = 1;
		} else {
			++idEdificio;
		}
		return idEdificio;
	}

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(edif.idEdificio)FROM EdificioInfra edif");
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

	@Override
	public List<EdificioInfra> listarEdificio() {
		StringBuilder queryString = new StringBuilder("SELECT edif FROM EdificioInfra edif");
		Query query = getEntityManager().createQuery(queryString.toString());

		return query.getResultList();
	}

	@Override
	public List<EdificioInfra> buscarEdificio(int edif) {
		StringBuilder queryString = new StringBuilder("SELECT edif FROM EdificioInfra edif where edif.idEdificio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, edif);

		return query.getResultList();
	}

	@Override
	public List<EdificioInfra> buscarEdificioXNombre(String nombreEdificio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT edif FROM EdificioInfra edif where edif.nomEdificio like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + nombreEdificio + "%");

		return query.getResultList();
	}

	@Override
	public List<EdificioInfra> buscarEdificioXCodigo(String codEdificio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT edif FROM EdificioInfra edif where edif.codigoEdificio like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + codEdificio + "%");

		return query.getResultList();
	}

	@Override
	public List<LugarEspacio> buscarEdificioXLugarEspacio(EdificioInfra edificio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT edif FROM LugarEspacio edif where edif.edificio.idEdificio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, edificio.getIdEdificio());

		return query.getResultList();
	}

	@Override
	public List<EdificioInfra> buscarEdificioXTipoInfra(TipoInfraestructura tipoInfra) {
		StringBuilder queryString = new StringBuilder(
				"SELECT edif FROM EdificioInfra edif where edif.tipoInfraestructura.idTipoinfra like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, tipoInfra.getIdTipoinfra());

		return query.getResultList();
	}

}
