package ec.edu.epn.convenios.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.convenios.entities.Convenio;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class ConvenioDAOImplement
 */
@Stateless
@LocalBean
public class ConvenioDAOImplement extends DaoGenericoImplement<Convenio> implements ConvenioDAO {

	@Override
	public List<Convenio> consultaconvenioFechas1(Date fechaDesde, Date fechaHasta) {

		try {

			String codConv = "%";
			System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

			StringBuilder queryString = new StringBuilder("select conv from Convenio conv where conv.idConv like ?0 ");


			if (fechaDesde != null & fechaHasta != null) {
				queryString.append(" and conv.finTentativo BETWEEN ?1 AND ?2 ");
			}

			queryString.append("ORDER BY conv.idConv ");

			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(0, "%" + codConv + "%");

			if (fechaDesde != null & fechaHasta != null) {
				query.setParameter(1, fechaDesde);
				query.setParameter(2, fechaHasta);

			}

			System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Convenio> consultaconvenioAntesde(Date fecha) {

		try {

			String codConv = "%";
			

			StringBuilder queryString = new StringBuilder("select conv from Convenio conv where conv.idConv like ?0 ");


			if (fecha != null ) {
				queryString.append(" and conv.fechaFirma > ?1  ");
			}

			queryString.append("ORDER BY conv.idConv ");

			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(0, "%" + codConv + "%");

			if (fecha != null ) {
				query.setParameter(1, fecha);
				

			}

		
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Convenio> consultaconvenioFechas(Date fechaDesde, Date fechaHasta, int idorg) {

		String codConv = "%";
		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"select conv from Convenio conv, ConvOrganizacion org   where conv.idConv like ?0 and org.convenio.idConv = conv.idConv  ");

		if (fechaDesde == null & fechaHasta == null) {
			// System.out.println("RETORNA NULL");
			return null;
		}

		if (fechaDesde != null & fechaHasta != null) {
			queryString.append(" and conv.finTentativo BETWEEN ?1 AND ?2 ");
		}

		if (idorg != 0) {
			queryString.append(" and org.organizacion.idOrganizacion = ?3 ");
		}

		queryString.append("ORDER BY conv.idConv ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + codConv + "%");

		if (fechaDesde != null & fechaHasta != null) {
			query.setParameter(1, fechaDesde);
			query.setParameter(2, fechaHasta);

		}

		if (idorg != 0) {
			query.setParameter(3, idorg);
		}

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Convenio> consultaconveniobyparams(String codigo, String titulo, String Objeto, int idAplicacion,
			int idAutoridad, String estado, String vigencia, int idDepartamento, String localidad, int idtipo,
			Date fechaDesde, Date fechaHasta, int idorganizacion, String tesis, String pasantias, String investigacion,
			String sprofesionales, String varios, String tipo) {

		System.out.println("Desde" + fechaDesde);
		System.out.println("Hasta" + fechaHasta);
		String observaciones = "%";
		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"select DISTINCT conv from Convenio conv, ConvOrganizacion org, Organizacion ga  where conv.observaciones like ?0  and org.convenio.idConv = conv.idConv and ga.idOrganizacion = org.organizacion.idOrganizacion ");

		if (codigo != null) {
			queryString.append(" and conv.idConv like ?1 ");
		}

		if (titulo != null) {
			queryString.append(" and conv.tituloC like ?2 ");
		}

		if (Objeto != null) {
			queryString.append(" and conv.objetivoC like ?3 ");
		}

		if (idAutoridad != 0) {
			queryString.append(" and conv.autoridad.idAutoridad = ?5 ");
		}

		if (estado != null) {
			queryString.append(" and conv.estado like ?6 ");
		}

		if (vigencia != null) {
			queryString.append(" and conv.vigenciaEstados = ?7 ");
		}

		if (idDepartamento != 0) {
			queryString.append(" and conv.unidad.idUnidad = ?8 ");
		}

		if (localidad != null) {
			queryString.append(" and conv.geograficoC = ?9 ");
		}

		if (idtipo != 0) {
			queryString.append(" and conv.tipoC.idTipoc = ?10 ");
		}

		if (fechaDesde != null & fechaHasta != null) {
			queryString.append(" and conv.fechaFirma BETWEEN ?11 AND ?12 ");
		}

		if (idorganizacion != 0) {
			queryString.append(" and  org.organizacion.idOrganizacion = ?13 ");
		}

		if (tesis != null) {
			queryString.append(" and conv.tesis like ?14 ");
		}

		if (pasantias != null) {
			queryString.append(" and conv.pasantias like ?15 ");
		}

		if (investigacion != null) {
			queryString.append(" and conv.investigacion like ?16 ");
		}

		if (sprofesionales != null) {
			queryString.append(" and conv.sprofesionales like ?17 ");
		}

		if (varios != null) {
			queryString.append(" and conv.varios like ?18 ");
		}

		if (tipo != null) {
			queryString.append(" and org.organizacion.tipo like ?19 ");
		}

		queryString.append("ORDER BY conv.idConv ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + observaciones + "%");

		if (codigo != null) {
			query.setParameter(1, "%" + codigo + "%");
		}

		if (titulo != null) {
			query.setParameter(2, "%" + titulo + "%");
		}

		if (Objeto != null) {
			query.setParameter(3, "%" + Objeto + "%");
		}

		if (idAutoridad != 0) {
			query.setParameter(5, idAutoridad);
		}

		if (estado != null) {
			query.setParameter(6, "%" + estado.trim() + "%");
		}

		if (vigencia != null) {
			query.setParameter(7, vigencia);
		}

		if (idDepartamento != 0) {
			query.setParameter(8, idDepartamento);
		}

		if (localidad != null) {
			query.setParameter(9, localidad);
		}

		if (idtipo != 0) {
			query.setParameter(10, idtipo);
		}

		if (fechaDesde != null & fechaHasta != null) {
			query.setParameter(11, fechaDesde);
			query.setParameter(12, fechaHasta);

		}

		if (idorganizacion != 0) {
			query.setParameter(13, idorganizacion);
		}

		if (tesis != null) {
			query.setParameter(14, "%" + tesis + "%");
		}

		if (pasantias != null) {
			query.setParameter(15, "%" + pasantias + "%");
		}

		if (investigacion != null) {
			query.setParameter(16, "%" + investigacion + "%");
		}

		if (sprofesionales != null) {
			query.setParameter(17, "%" + sprofesionales + "%");
		}

		if (varios != null) {
			query.setParameter(18, "%" + varios + "%");
		}

		if (tipo != null) {
			query.setParameter(19, "%" + tipo + "%");
		}

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}

}
