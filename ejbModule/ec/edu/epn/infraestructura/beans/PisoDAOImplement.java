package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.LugarEspacio;
import ec.edu.epn.infraestructura.entities.PisoInfra;

@Stateless
public class PisoDAOImplement extends DaoGenericoImplement<PisoInfra> implements
		PisoDAO {

	@Override
	public int maxPiso() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(p.idPiso) FROM PisoInfra p");
		Integer idPiso = null;

		try {
			idPiso = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idPiso = null;
		}
		if (idPiso == null) {
			idPiso = 1;
		} else {
			++idPiso;
		}
		return idPiso;
	}
	
	@Override
	public List<LugarEspacio> listLugarEspacioxPiso(PisoInfra piso) {

			StringBuilder queryString = new StringBuilder("SELECT le FROM LugarEspacio le where le.piso.idPiso=?1");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, piso.getIdPiso());
			return query.getResultList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PisoInfra> buscarPisoXEdificio(int fkEdifico) {
		StringBuilder queryString = new StringBuilder(
				"SELECT piso FROM PisoInfra piso where piso.edificio.idEdificio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, fkEdifico);

		return query.getResultList();
	}

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(piso.idPiso)FROM PisoInfra piso");
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
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public List<PisoInfra> listarPisos() {
		StringBuilder queryString = new StringBuilder("SELECT pi FROM PisoInfra pi");
		Query query = getEntityManager().createQuery(queryString.toString());
		System.out.println("LISTA DE PISOS...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<PisoInfra> buscarPiso(int piso) {
		StringBuilder queryString = new StringBuilder(
				"SELECT piso FROM PisoInfra piso where piso.idPiso=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, piso);
		System.out.println("LISTA DE PISOS X ID...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<PisoInfra> buscarPisoXNombre(String nombrePiso, int idEdificio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT pis FROM PisoInfra pis where pis.nomPiso like ?1 and pis.edificio.idEdificio=?2");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + nombrePiso + "%");
		query.setParameter(2, idEdificio);
		System.out
				.println("LISTA DE PISOS X NOMBRE e ID DE EDIFICIO...!!!!!!!!!!!!: "
						+ query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<PisoInfra> buscarPisoXLugarEspacio(PisoInfra piso) {
		StringBuilder queryString = new StringBuilder(
				"SELECT piso FROM LugarEspacio piso where piso.piso.idPiso=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, piso);
		System.out
				.println("LISTA DE PISOS X ID EN LUGAR ESPACIO...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<PisoInfra> buscarLugarEspacioXEdificio(EdificioInfra edif) {
		StringBuilder queryString = new StringBuilder(
				"SELECT piso FROM PisoInfra piso where piso.edificio.idEdificio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, edif.getIdEdificio());
		System.out
				.println("LISTA DE LUGARES ESPACIO X ID EDIFICIO PARA LISTAR PISOS DE EDIFICIO...!!!!!!!!!!!!");
		return query.getResultList();
	}

	@Override
	public List<PisoInfra> listarPisosxEdificio(int idEdificio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT pis FROM PisoInfra pis where pis.edificio.idEdificio=?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idEdificio);
		System.out
				.println("LISTA DE PISOS X NOMBRE e ID DE EDIFICIO...!!!!!!!!!!!!: "
						+ query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public List<PisoInfra> buscarPisoXNombre(String nombrePiso) {
		StringBuilder queryString = new StringBuilder(
				"SELECT pis FROM PisoInfra pis where pis.nomPiso like ?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%" + nombrePiso + "%");
		System.out.println("LISTA DE PISOS X NOMBRE...!!!!!!!!!!!!: "
				+ query.getResultList().size());
		return query.getResultList();
	}

}
