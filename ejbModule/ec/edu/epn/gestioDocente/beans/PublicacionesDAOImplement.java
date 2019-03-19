package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Publicacione;

/**
 * Session Bean implementation class CapacitacionDAOImplement
 */
@Stateless
@LocalBean
public class PublicacionesDAOImplement extends DaoGenericoImplement<Publicacione> implements PublicacionesDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> listaPublicacionesXCedula(String cedula, String validarecategoriza,
			String validarevaloriza, String clase, String tipoPublicacion, String medio, String titulo, String idperiod,
			boolean ordenPeriodo) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder("SELECT DISTINCT(p) FROM Publicacione p, Emp e, "
				+ "EmpleadoPublica ep where p.idPublic = ep.pub.idPublic " + "and e.nced = ep.emp.nced "
				+ "and e.nced =?1 and  p.estado IN :list ");

		if (validarecategoriza != null) {
			queryString.append(" and p.validarecategorza = ?2 ");
		}

		if (validarevaloriza != null) {
			queryString.append(" and p.validarevalorazion = ?3 ");
		}

		if (clase != null) {
			queryString.append(" and p.clase = ?4 ");
		}

		if (tipoPublicacion != null) {
			queryString.append(" and p.tipoPublicacion.idTipoPublic = ?5 ");
		}

		if (medio != null) {
			queryString.append(" and p.medio = ?6 ");
		}

		if (titulo != null) {
			queryString.append(" and p.tituloPublic = ?7 ");
		}

		if (idperiod != null) {
			queryString.append(" and p.periodo2.idPeriodo = ?8 ");
		}

		if (ordenPeriodo == true) {
			queryString.append(" ORDER BY p.periodo2.idPeriodo DESC");
		} else {
			queryString.append(" ORDER BY p.fechaPublic ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		query.setParameter("list", ids);

		if (validarecategoriza != null) {
			query.setParameter(2, validarecategoriza);
		}

		if (validarevaloriza != null) {
			query.setParameter(3, validarevaloriza);
		}

		if (clase != null) {
			query.setParameter(4, clase);
		}

		if (tipoPublicacion != null) {
			query.setParameter(5, tipoPublicacion);
		}

		if (medio != null) {
			query.setParameter(6, medio);
		}

		if (titulo != null) {
			query.setParameter(7, titulo);
		}

		if (idperiod != null) {
			query.setParameter(8, idperiod);
		}
		return query.getResultList();
	}

	@Override
	public int countPublicacionXCedula(String cedula, String tituloPub, String medio, String idPeriodo,
			Publicacione publicaciones) throws Exception {
		int valor = 0;
		String val = "N";
		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM Publicacione p WHERE p.nced=?1 AND p.tituloPublic=?2 AND p.periodo2.idPeriodo=?3");

		if (medio != null) {
			queryString.append(" AND p.medio=?4");

		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		query.setParameter(2, tituloPub);
		query.setParameter(3, idPeriodo);

		if (medio != null) {
			query.setParameter(4, medio);
		}

		Publicacione publicacionesSelect = null;

		try {
			query.getSingleResult();
			val = "S";
		} catch (NoResultException e) {
			val = "N";
		}

		if (val.equals("S")) {
			publicacionesSelect = (Publicacione) query.getSingleResult();
		}
		if (publicacionesSelect != null) {
			if (publicaciones != null && publicacionesSelect.getIdPublic().equals(publicaciones.getIdPublic())) {
				valor = 0;
			} else {
				valor = 1;
			}
		} else {
			valor = 0;
		}

		return valor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionVIPS(String vips, String idtipoPub) {

		StringBuilder queryString = new StringBuilder("SELECT fam FROM Publicacione fam where fam.vips = ?0 ");

		if (idtipoPub != null) {
			queryString.append(" and fam.tipoPublicacion.idTipoPublic = ?1 ");

		}

		queryString.append("order by fam.fechaPublic ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, vips);

		if (idtipoPub != null) {
			query.setParameter(1, idtipoPub);

		}

		return query.getResultList();

	}

	@Override
	public int consultarNumeroSerial(int anio, String idtipo, String coddep) {
		System.out.println("Entraaaaaaa ConsultarID");
		Query q = getEntityManager().createQuery("SELECT MAX(pr.serial)FROM Publicacione pr"
				+ " where pr.anio =?1 and pr.departamento.codDep =?2 and pr.tipoPublicacion.idTipoPublic =?3 ");

		Integer idReq = null;
		q.setParameter(1, anio);
		q.setParameter(2, coddep);
		q.setParameter(3, idtipo);

		try {
			System.out.println("Entraaaaaaa tryyyyyyyyy");
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

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findCodigosSinRepetir(String idtipoPub, Integer año, String coddep, String autores,
			String calalog) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT DISTINCT(fam.codigo) FROM Publicacione fam where  fam.tituloPublic like ?0 and fam.estado IN :list and fam.codigo is not null  ");

		if (idtipoPub != null) {
			queryString.append(" and fam.tipoPublicacion.idTipoPublic = ?1 ");

		}

		if (año != 0) {
			queryString.append(" and fam.anio = ?2 ");

		}

		if (coddep != null) {
			queryString.append(" and fam.departamento.codDep = ?3 ");

		}

		if (autores != null) {
			queryString.append(" and fam.autores = ?4 ");

		}

		if (calalog != null) {
			queryString.append(" and fam.catalogo = ?5 ");

		}

		queryString.append(" and fam.vips = ?6");
		queryString.append("    order by fam.codigo");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%");

		query.setParameter("list", ids);

		if (idtipoPub != null) {
			query.setParameter(1, idtipoPub);

		}

		if (año != 0) {
			query.setParameter(2, año);

		}

		if (coddep != null) {
			query.setParameter(3, coddep);

		}

		if (autores != null) {
			query.setParameter(4, autores);

		}

		if (calalog != null) {
			query.setParameter(5, calalog);

		}

		query.setParameter(6, "S");

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> findPublicacionesReporte(String codigoPublicacion) {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM Publicacione fam where  fam.codigo = ?0 and fam.estado IN :list and fam.codigo is not null  ");

		queryString.append("  order by fam.codigo");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, codigoPublicacion);

		query.setParameter("list", ids);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> listPublicacionesTipo(String nced, List<String> tipo, String idPeriodo) throws Exception {

		List<String> ids = new ArrayList<String>();
		ids.add("A");
		ids.add("I");
		ids.add("U");

		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM Publicacione p WHERE p.nced=?0 AND p.periodo2.idPeriodo=?1 AND p.estado IN :list AND p.tipoPublicacion.idTipoPublic IN :tipo ORDER BY p.fechaPublic ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, nced);
		query.setParameter(1, idPeriodo);
		query.setParameter("list", ids);
		query.setParameter("tipo", tipo);

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> listaPublicacionesXProyectoAC(List<String> cedulas, String tipoPublic, Integer idpensum,
			Integer idproyecto, String titulo) {

		StringBuilder queryString = new StringBuilder("SELECT DISTINCT p FROM Publicacione p, Emp e, "
				+ " EmpleadoPublica ep where p.idPublic = ep.pub.idPublic " + " and e.nced = ep.emp.nced "
				+ " and e.nced IN:list  " );

		if (tipoPublic != null) {
			queryString.append(" and p.tipoPublicacion.idTipoPublic = ?2 ");
		}

		if (idpensum != 0) {
			queryString.append(" and p.idpensum = ?3 ");
		}

		if (idproyecto != 0) {
			queryString.append(" and p.idproy = ?4 ");
		}

		if (titulo != null) {
			queryString.append(" and p.tituloPublic = ?5 ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		
		
		query.setParameter("list", cedulas);

		if (tipoPublic != null) {
			query.setParameter(2, tipoPublic);
		}

		if (idpensum != 0) {
			query.setParameter(3, idpensum);
		}

		if (idproyecto != 0) {
			query.setParameter(4, idproyecto);
		}

		if (titulo != null) {
			query.setParameter(5, titulo);
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> listaPublicacionesXProyectoACReporte(String tipoPublic, Integer idpensum,
			Integer idproyecto) {

		StringBuilder queryString = new StringBuilder(
				"SELECT DISTINCT(p) FROM Publicacione p where p.tipoPublicacion.idTipoPublic = ?1 and p.idpensum = ?2 and p.idproy = ?3  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, tipoPublic);

		query.setParameter(2, idpensum);

		query.setParameter(3, idproyecto);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publicacione> listaPublicacionesXProyectoPonencia(List<String> cedulas, String tipoPublic, Integer idpensum,
			Integer idproyecto, String titulo) {

		StringBuilder queryString = new StringBuilder(
				"SELECT DISTINCT(p) FROM Publicacione p " + " where p.nced IN:list ");

		if (tipoPublic != null) {
			queryString.append(" and p.tipoPublicacion.idTipoPublic = ?2 ");
		}

		if (idpensum != 0) {
			queryString.append(" and p.idpensum = ?3 ");
		}

		if (idproyecto != 0) {
			queryString.append(" and p.idproy = ?4 ");
		}

		if (titulo != null) {
			queryString.append(" and p.tituloPublic = ?5 ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("list", cedulas);

		if (tipoPublic != null) {
			query.setParameter(2, tipoPublic);
		}

		if (idpensum != 0) {
			query.setParameter(3, idpensum);
		}

		if (idproyecto != 0) {
			query.setParameter(4, idproyecto);
		}

		if (titulo != null) {
			query.setParameter(5, titulo);
		}

		return query.getResultList();
	}

}
