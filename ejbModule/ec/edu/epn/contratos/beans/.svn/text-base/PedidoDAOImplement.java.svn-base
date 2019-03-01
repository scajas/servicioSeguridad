/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.beans.facultadDAO;
import ec.edu.epn.contratos.DTO.PedidosContratosDTO;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.mail.correoVO;

/**
 * @author Administrador
 * 
 */
@Stateless
public class PedidoDAOImplement extends DaoGenericoImplement<Pedido> implements PedidoDAO {

	private correoVO correo;

	@EJB
	private facultadDAO facultadI;

	/*
	 * @Schedule(second = "10", hour = "*", minute = "*") public void
	 * notificarPedidosAtrasados3Dias() throws Exception {
	 * 
	 * try {
	 * 
	 * System.out.println("CRONO ACTIVADO");
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(ped.idPedido) FROM Pedido ped");
		Integer idEstadoEspacio = null;

		try {
			idEstadoEspacio = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			idEstadoEspacio = null;
		}
		if (idEstadoEspacio == null) {
			idEstadoEspacio = 1;
		} else {
			++idEstadoEspacio;
		}
		return idEstadoEspacio;
	}

	@Override
	public Pedido buscarXCedula(String nced) {
		Query q = getEntityManager().createQuery("Select ped from Pedido ped where ped.emp.nced like ?1");
		q.setParameter(1, nced + "%");
		return (Pedido) q.getResultList();
	}

	@Override
	public List<Pedido> buscarListaXCedula(String cedula) {
		Query q = getEntityManager().createQuery("Select ped from Pedido ped where ped.nced like ?1");
		q.setParameter(1, cedula + "%");
		return q.getResultList();
	}

	@Override
	public List<Pedido> listapedidosNOaceptados() {
		Query q = getEntityManager().createQuery("Select ped from Pedido ped where ped.estado.idEstado in (4,5,7)");
		return q.getResultList();
	}

	@Override
	public List<Pedido> buscarPedidosXRevisarTitulos() {
		Query q = getEntityManager().createQuery("Select ped from Pedido ped where ped.checkTitulo like ?1");
		q.setParameter(1, "SI");
		return q.getResultList();
	}

	@Override
	public List<Pedido> listapedidosRegistrados(String idfcult) {
		Query q = getEntityManager().createQuery(
				"Select ped from Pedido ped where ped.estado.idEstado in (8,9)  and trim(ped.idFacultad) like ?0 AND ped.pensum.estado= 'V' ORDER BY ped.fechaPedido ASC");

		q.setParameter(0, "%" + idfcult + "%");
		return q.getResultList();
	}

	@Override
	public List<Pedido> listapedidosNOaceptadosrob(String idfacul) {
		Query q = getEntityManager().createQuery(
				"Select ped from Pedido ped where ped.estado.idEstado in (4,5,7) and ped.idFacultad like ?0 and ped.pensum.estado= 'V' ORDER BY ped.fechaPedido desc");

		q.setParameter(0, "%" + idfacul + "%");
		return q.getResultList();
	}

	@Override
	public List<Pedido> listapedidosRegistradosContrato() {
		Query q = getEntityManager().createQuery(
				"SELECT ped FROM Pedido ped WHERE (ped.estado.idEstado in (11,12) OR (ped.tipoContrato.idTcont IN (10, 11, 12) AND ped.estado.idEstado in (3,12))) AND ped.pensum.estado= 'V' ORDER BY ped.fechaPedido ASC ");

		return q.getResultList();
	}

	@Override
	public List<Pedido> listapedidosRegistradosContratoXParametros(String cedula, String nombres, Pensum pensum) {

		StringBuilder queryString = new StringBuilder(
				"select ped from Pedido ped where (ped.estado.idEstado in (11,12,14) OR (ped.tipoContrato.idTcont IN (10, 11, 12) AND ped.estado.idEstado in (3,12))) ");

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}

		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?3 ");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			queryString.append(" and ped.pensum.idPensum = ?4 ");
		}

		queryString.append("ORDER BY ped.fechaPedido desc");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(2, cedula);
		}

		if (nombres != null && !nombres.equals("")) {
			query.setParameter(3, "%" + nombres + "%");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			query.setParameter(4, pensum.getIdPensum());
		}

		return query.getResultList();
	}

	@Override
	public List<Pedido> listaPedidoReporte(String relacion, String doc, Date fechaI, Date fechaF, int estado,
			String tipoContrato, String titulo) {
		StringBuilder queryString = new StringBuilder("select p from Pedido p where p.observaciones like ?1");

		if (relacion != null && !relacion.equals("")) {
			System.out.println("RELACION:" + relacion);
			queryString.append(" and p.relacionActual = ?2");
		}

		if (doc != null && !doc.equals("")) {
			System.out.println("TIPO DOC:" + doc);
			if (doc.equals("cedula"))
				queryString.append(" and char_length(p.nced) = ?3");
			else
				queryString.append(" and char_length(p.nced) <> ?4");
		}
		if (estado != 0) {
			System.out.println("ESTADO:" + estado);
			queryString.append(" and p.estado.idEstado = ?5");
		}

		if (fechaI != null && fechaF != null) {
			System.out.println("FECHAS: " + fechaI + " - " + fechaF);
			queryString.append(" and p.fechaPedido between ?6 and ?7 ");
		}

		if (tipoContrato != null && !tipoContrato.equals("")) {
			System.out.println("TIPO DE CONTARTO: " + tipoContrato);
			queryString.append(" and p.tipoContrato.nombreTcont like ?8 ");
		}

		if (titulo != null && !titulo.equals("")) {
			System.out.println("Titulos:" + titulo);
			queryString.append(
					" and p.idPedido in (select td.pedido.idPedido from TitulosDocente td where td.nivelTitulo = ?9)");
		}

		queryString.append(" ORDER BY p.nombresDocente asc");

		System.out.println("CONSULTA: " + queryString.toString());

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "%");

		if (relacion != null && !relacion.equals("")) {
			query.setParameter(2, relacion);
		}
		if (doc != null && !doc.equals("")) {
			long dato = 10;
			if (doc.equals("cedula"))
				query.setParameter(3, dato);
			else
				query.setParameter(4, dato);
		}
		if (estado != 0) {
			query.setParameter(5, estado);
		}
		if (fechaI != null && fechaF != null) {
			query.setParameter(6, fechaI);
			query.setParameter(7, fechaF);
		}

		if (tipoContrato != null && !tipoContrato.equals("")) {
			query.setParameter(8, tipoContrato.toUpperCase());
		}

		if (titulo != null && !titulo.equals("")) {
			query.setParameter(9, titulo);
		}

		System.out.println("REPORTE PEDIDO POR PARAMETROS...!!!!!!!!!!!!: tamaño : " + query.getResultList().size());

		return query.getResultList();
	}

	@Override
	public List<Pedido> listapedidosNOaceptadosXParametros(String cedula, String nombres, Pensum pensum,
			String idFacultad) {
		String observ = "%";

		StringBuilder queryString = new StringBuilder(
				"select ped from Pedido ped where ped.observaciones like ?0 and  ped.estado.idEstado in (4,5,7) ");

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}

		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?3 ");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			queryString.append(" and ped.pensum.idPensum = ?4 ");
		} else {
			queryString.append("and ped.pensum.estado= 'V'");
		}

		if (idFacultad != null && !idFacultad.equals("")) {
			queryString.append(" and ped.idFacultad like ?5 ");
		}

		queryString.append("ORDER BY ped.fechaPedido desc");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + observ + "%");

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(2, cedula);
		}

		if (nombres != null && !nombres.equals("")) {
			query.setParameter(3, "%" + nombres + "%");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			query.setParameter(4, pensum.getIdPensum());
		}

		if (idFacultad != null && !idFacultad.equals("")) {
			query.setParameter(5, idFacultad);
		}

		return query.getResultList();
	}

	@Override
	public List<Pedido> listapedidosRegistradosXParametros(String cedula, String nombres, Pensum pensum,
			String idFacultad) {
		String observ = "%";

		StringBuilder queryString = new StringBuilder(
				"select ped from Pedido ped where ped.observaciones like ?0 and  ped.estado.idEstado in (8,9) ");

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}

		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?3 ");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			queryString.append(" and ped.pensum.idPensum = ?4 ");
		} else {
			queryString.append("and ped.pensum.estado= 'V'");
		}

		if (idFacultad != null && !idFacultad.equals("")) {
			queryString.append(" and ped.idFacultad like ?5 ");
		}

		queryString.append("ORDER BY ped.fechaPedido desc");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + observ + "%");

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(2, cedula);
		}

		if (nombres != null && !nombres.equals("")) {
			query.setParameter(3, "%" + nombres + "%");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			query.setParameter(4, pensum.getIdPensum());
		}

		if (idFacultad != null && !idFacultad.equals("")) {
			query.setParameter(5, idFacultad);
		}

		return query.getResultList();
	}

	@Override
	public List<Pedido> listapedidosXRegistrar(String idfcult) {
		Query q = getEntityManager().createQuery(
				"Select ped from Pedido ped where ped.estado.idEstado in (13)  and trim(ped.idFacultad) like ?0");

		q.setParameter(0, "%" + idfcult + "%");
		return q.getResultList();
	}

	@Override
	public List<Pedido> listapedidosXRegistrarCedula(String idfcult, String nced) {
		Query q = getEntityManager().createQuery(
				"Select ped from Pedido ped where ped.estado.idEstado in (13)  and trim(ped.idFacultad) like ?0 and ped.nced like ?1");

		q.setParameter(0, "%" + idfcult + "%");
		q.setParameter(1, nced + "%");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PedidosContratosDTO> buscarPedidosContratos(Integer idTipoContrato, Integer idPensum,
			Integer idEstadoPedido, String idFacultad, String relacionActual) {
		Query query = null;
		List<PedidosContratosDTO> listPedidosDTO = new ArrayList<PedidosContratosDTO>();
		try {

			StringBuilder queryString = new StringBuilder(
					"SELECT COALESCE(ped.nced, ' ') AS var1, COALESCE(ped.nombres_docente, ' ') AS var2, "
							+ "COALESCE(to_char(ped.fecha_pedido, 'yyyy-mm-dd'), ' ') AS var3, "
							+ "COALESCE(to_char(ped.fecha_inicio, 'yyyy-mm-dd'), ' ') AS var4, "
							+ "COALESCE(to_char(ped.fecha_fin, 'yyyy-mm-dd'), ' ') AS var5, "
							+ "fac.nom_facultad AS var6, tipc.nombre_tcont AS var7, "
							+ "est.nombre_estado AS var8, COALESCE(ped.idpedido, ' ') AS var9, ped.relacion_actual AS var10 "
							+ "FROM \"Contratos\".pedido ped, \"Catalogos\".facultad fac, "
							+ "\"Contratos\".tipo_contrato tipc, \"Contratos\".estado est "
							+ "WHERE ped.id_tcont= tipc.id_tcont " + "AND ped.id_estado= est.id_estado "
							+ "AND ped.id_facultad= fac.id_facultad " + "AND (ped.id_pensum=? OR 0=?) "
							+ "AND fac.id_facultad LIKE ? " + "AND (tipc.id_tcont=? OR 0=?) "
							+ "AND ped.relacion_actual LIKE ? " + "AND (est.id_estado = ? OR 0=?) "
							+ "ORDER BY ped.nombres_docente");
			query = getEntityManager().createNativeQuery(queryString.toString());
			query.setParameter(1, idPensum);
			query.setParameter(2, idPensum);
			query.setParameter(3, idFacultad);
			query.setParameter(4, idTipoContrato);
			query.setParameter(5, idTipoContrato);
			query.setParameter(6, relacionActual);
			query.setParameter(7, idEstadoPedido);
			query.setParameter(8, idEstadoPedido);

			List<?> listsPedidosContrato = query.getResultList();

			if (!listsPedidosContrato.isEmpty()) {
				for (Object list : listsPedidosContrato) {
					PedidosContratosDTO dto = new PedidosContratosDTO();
					Object[] fila = (Object[]) list;

					dto.setNumCedula(fila[0].toString());
					dto.setNombreDocente(fila[1].toString());
					dto.setFechaPedido(fila[2].toString());
					dto.setFechaInicioContrato(fila[3].toString());
					dto.setFechaFinContrato(fila[4].toString());
					dto.setFacultadDepartamento(fila[5].toString());
					dto.setTipoContrato(fila[6].toString());
					dto.setEstadoPedido(fila[7].toString());
					dto.setNroPedido(fila[8].toString());
					dto.setRelacionActual(fila[9].toString());

					listPedidosDTO.add(dto);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listPedidosDTO;
	}

	@Override
	public List<Pedido> listapedidosXRegistrarPensumVigente(String idfacutlad, Integer idPensum, String nced)
			throws Exception {
		String cedulaPedido = "";
		if (!nced.equals("")) {
			cedulaPedido = "AND ped.nced= ?2 ORDER BY ped.idPedido";
		} else {
			cedulaPedido = "ORDER BY ped.idPedido";
		}

		Query q = getEntityManager().createQuery(
				"Select ped from Pedido ped where ped.estado.idEstado in (13)  and trim(ped.idFacultad) like ?0 AND ped.pensum.idPensum=?1 "
						+ cedulaPedido);

		q.setParameter(0, "%" + idfacutlad + "%");
		q.setParameter(1, idPensum);

		if (!nced.equals("")) {
			q.setParameter(2, nced.trim());
		}

		return q.getResultList();
	}

	@Override
	public Long contPedidosXPensum(String nced, Integer idPensum) throws Exception {
		Query q = getEntityManager().createQuery(
				"SELECT COUNT(ped.idPedido) FROM Pedido ped WHERE ped.estado.idEstado != (13) AND trim(ped.nced) LIKE ?0 AND ped.pensum.idPensum=?1");

		q.setParameter(0, "%" + nced + "%");
		q.setParameter(1, idPensum);
		return (Long) q.setMaxResults(1).getSingleResult();
	}

	@Override
	public List<Pedido> listaPedidoAdendas(String idFacultad, int idPensum, String nombre, String cedula) {
		try {

			String consulta = "Select ped from Pedido ped where ped.idFacultad like ?1 and ped.pensum.idPensum=?2 and ped.tipoContrato.idTcont =2 and ped.dedicacion like ?3";
			String consulta1 = "Select ped from Pedido ped where ped.idFacultad like ?1 and ped.pensum.idPensum=?2 and ped.tipoContrato.idTcont = 3";
			StringBuilder build = new StringBuilder(consulta.toString());
			StringBuilder build1 = new StringBuilder(consulta1.toString());

			if (nombre != null && !nombre.equals("")) {
				build.append(" and ped.nombresDocente like ?4 ");
				build1.append(" and ped.nombresDocente like ?4 ");
			}

			if (cedula != null && !cedula.equals("")) {
				build.append(" and ped.nced like ?5 ");
				build1.append(" and ped.nced like ?5 ");
			}

			build.append(" ORDER BY ped.fechaPedido ASC");

			Query query = getEntityManager().createQuery(build.toString());
			Query query1 = getEntityManager().createQuery(build1.toString());

			if (nombre != null && !nombre.equals("")) {
				query.setParameter(4, "%" + nombre + "%");
				query1.setParameter(4, "%" + nombre + "%");
			}

			if (cedula != null && !cedula.equals("")) {
				query.setParameter(5, cedula);
				query1.setParameter(5, cedula);
			}

			query.setParameter(1, "%" + idFacultad + "%");
			query.setParameter(2, idPensum);
			query.setParameter(3, "%TIEMPO COMPLETO%");

			query1.setParameter(1, "%" + idFacultad + "%");
			query1.setParameter(2, idPensum);

			List<Pedido> list = query.getResultList();
			List<Pedido> list1 = query1.getResultList();

			list.addAll(list1);

			return list;

			/*
			 * 
			 * StringBuilder queryString = new StringBuilder(
			 * "Select ped from Pedido ped where (ped.idFacultad like ?1 and ped.pensum.idPensum=?2 and ped.tipoContrato.idTcont = ?3 and ped.dedicacion like ?4)  or (ped.pensum.idPensum=?7 and ped.tipoContrato.idTcont = 3 and ped.idFacultad like ?8)"
			 * );
			 * 
			 * if (nombre != null && !nombre.equals("")) {
			 * queryString.append(" and ped.nombresDocente like ?5 "); }
			 * 
			 * if (cedula != null && !cedula.equals("")) {
			 * queryString.append(" and ped.nced like ?6 "); }
			 * 
			 * queryString.append(" ORDER BY ped.fechaPedido ASC");
			 * 
			 * Query query =
			 * getEntityManager().createQuery(queryString.toString());
			 * 
			 * if (nombre != null && !nombre.equals("")) { query.setParameter(5,
			 * "%" + nombre + "%"); }
			 * 
			 * if (cedula != null && !cedula.equals("")) { query.setParameter(6,
			 * cedula); }
			 * 
			 * query.setParameter(1, "%" + idFacultad + "%");
			 * query.setParameter(2, idPensum); query.setParameter(3, 2);
			 * query.setParameter(4, "%TIEMPO COMPLETO%"); query.setParameter(7,
			 * idPensum); query.setParameter(8, "%" + idFacultad + "%");
			 */
			// return query.getResultList();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Pedido> listaPedidoAdendasSinRegistrar(String idFacultad, int idPensum, String nombre, String cedula) {
		try {

			StringBuilder queryString = new StringBuilder(
					"Select ped from Pedido ped where ped.idFacultad like ?1 AND ped.pensum.idPensum=?2 and ped.adenda like ?3 and ped.estado.idEstado = 13 ");

			if (nombre != null && !nombre.equals("")) {
				queryString.append(" and ped.nombresDocente like ?5 ");
			}

			if (cedula != null && !cedula.equals("")) {
				queryString.append(" and ped.nced like ?6 ");
			}

			queryString.append(" ORDER BY ped.fechaPedido ASC");

			Query query = getEntityManager().createQuery(queryString.toString());

			if (nombre != null && !nombre.equals("")) {
				query.setParameter(5, "%" + nombre + "%");
			}

			if (cedula != null && !cedula.equals("")) {
				query.setParameter(6, cedula);
			}

			query.setParameter(1, "%" + idFacultad + "%");
			query.setParameter(2, idPensum);
			query.setParameter(3, "%-AD%");

			return query.getResultList();

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Pedido> buscarListaXCedulaAyudante(String cedula, Integer idPensum) throws Exception {
		Query q = getEntityManager().createQuery(
				"Select ped from Pedido ped where ped.nced like ?1 AND ped.pensum.idPensum=?2 and ped.tipoContrato.idTcont = 9 and ped.estado.idEstado not in (13,12)");
		q.setParameter(1, cedula + "%");
		q.setParameter(2, idPensum);
		return q.getResultList();
	}

	@Override
	public List<Pedido> findPedidoAyudantesXRegistrarXParametros(String cedula, String nombres) {
		Query q = getEntityManager().createQuery(
				"Select ped from Pedido ped where ped.nombresDocente like ?0 and ped.nced = ?1 AND ped.pensum.estado = 'V' and ped.tipoContrato.idTcont = 9 and ped.estado.idEstado = 13");
		q.setParameter(0, "%" + nombres + "%");
		q.setParameter(1, cedula);

		return q.getResultList();
	}

	@Override
	public List<Pedido> findPedidoAyudantesXRegistrar(String idFacultad, String cedula, String nombres) {

		StringBuilder queryString = new StringBuilder(
				"Select ped from Pedido ped where ped.pensum.estado = 'V' and ped.tipoContrato.idTcont = 9 and ped.estado.idEstado = 13 ");

		if (idFacultad != null && !idFacultad.equals("")) {
			queryString.append(" and ped.idFacultad like ?1 ");
		}

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}

		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?3 ");
		}
		Query q = getEntityManager().createQuery(queryString.toString());
		
		
		if (idFacultad != null && !idFacultad.equals("")) {
			q.setParameter(1, "%" + idFacultad + "%");
		}

		if (cedula != null && !cedula.equals("")) {
			q.setParameter(2, cedula);
		}

		if (nombres != null && !nombres.equals("")) {
			q.setParameter(3, "%" + nombres + "%");
		}

		return q.getResultList();
	}

	@Override
	public List<Pedido> findPedidosSolicitadosXParametros(String cedula, String nombre, Pensum pensum) {

		StringBuilder queryString = new StringBuilder("select ped from Pedido ped where ped.estado.idEstado = 1");

		if (nombre != null && !nombre.equals("")) {
			queryString.append(" and ped.nombresDocente like ?1 ");
		}

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			queryString.append(" and ped.pensum.idPensum = ?3 ");
		}

		queryString.append("ORDER BY ped.fechaPedido ASC");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (nombre != null && !nombre.equals("")) {
			query.setParameter(1, "%" + nombre + "%");
		}

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(2, cedula);
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			query.setParameter(3, pensum.getIdPensum());
		}

		return query.getResultList();
	}

	@Override
	public List<Pedido> findPedidosAutorizadosXParametros(String cedula, String nombres, Pensum pensum) {

		StringBuilder queryString = new StringBuilder("select ped from Pedido ped where ped.estado.idEstado = 2");

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?1 ");
		}

		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?2 ");
		}

		if (pensum != null && pensum.getAñoPensum() != null) {
			queryString.append(" and ped.pensum.idPensum = ?3 ");
		}

		queryString.append("ORDER BY ped.fechaPedido ASC");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(1, cedula);
		}
		if (nombres != null && !nombres.equals("")) {
			query.setParameter(2, "%" + nombres + "%");
		}

		if (pensum != null && pensum.getAñoPensum() != null) {
			query.setParameter(3, pensum.getIdPensum());
		}

		return query.getResultList();
	}

	@Override
	public List<Pedido> findPedidosVerificadosXParametros(String cedula, String nombres, Pensum pensum) {

		StringBuilder queryString = new StringBuilder("select ped from Pedido ped where ped.estado.idEstado = 3 ");

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}
		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?3 ");
		}
		if (pensum != null && pensum.getIdPensum() != 0) {
			queryString.append(" and ped.pensum.idPensum = ?4 ");
		}

		queryString.append("ORDER BY ped.fechaPedido ASC");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(2, cedula);
		}
		if (nombres != null && !nombres.equals("")) {
			query.setParameter(3, "%" + nombres + "%");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			query.setParameter(4, pensum.getIdPensum());
		}

		return query.getResultList();
	}

	@Override
	public List<Pedido> findPedidosAsigPartidaXParametros(String cedula, String nombres, Pensum pensum) {

		StringBuilder queryString = new StringBuilder("select ped from Pedido ped where  ped.estado.idEstado = 10 ");

		if (cedula != null && !cedula.equals("")) {
			queryString.append(" and ped.nced like ?2 ");
		}

		if (nombres != null && !nombres.equals("")) {
			queryString.append(" and ped.nombresDocente like ?3 ");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			queryString.append(" and ped.pensum.idPensum = ?4 ");
		}

		queryString.append("ORDER BY ped.fechaPedido ASC");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (cedula != null && !cedula.equals("")) {
			query.setParameter(2, cedula);
		}

		if (nombres != null && !nombres.equals("")) {
			query.setParameter(3, "%" + nombres + "%");
		}

		if (pensum != null && pensum.getIdPensum() != 0) {
			query.setParameter(4, pensum.getIdPensum());
		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findPedidosByParam(String nombreDocente, String nced, int idEstado, Date fechaDesde,
			Date fechaHasta, String id_facultad, String perfilDecano, Pensum pensum, String tipoPedido) {

		String observ = "%";

		StringBuilder queryString = new StringBuilder("select ped from Pedido ped where ped.observaciones like ?0 ");

		if (nombreDocente != null && !nombreDocente.equals("")) {
			queryString.append(" and ped.nombresDocente like ?1 ");
		}

		if (idEstado != 0) {
			queryString.append(" and ped.estado.idEstado like ?2 ");
		}

		if (fechaDesde != null & fechaHasta != null) {
			queryString.append(" and ped.fechaPedido BETWEEN ?3 AND ?4 ");
		}

		if (!perfilDecano.equals("Revisor 1 Talento Humano") && !perfilDecano.equals("Revisor 2 Talento Humano")
				&& !perfilDecano.equals("Supervisor Talento Humano")&& !perfilDecano.equals("Control Contratos"))
			if (!id_facultad.equals("")) {
				queryString.append(" and ped.usuario.facultad.idFacultad = ?5 ");
			}

		if (pensum != null && pensum.getAñoPensum() != null) {
			queryString.append(" and ped.pensum.idPensum = ?6 ");
		}

		if (nced != null && !nced.equals("")) {
			queryString.append(" and ped.nced like ?7 ");
		}

		if (tipoPedido != null && !tipoPedido.equals("")) {
			if (!tipoPedido.equals("ALL")) {
				if (tipoPedido.equals("A"))
					queryString.append(" and ped.adenda <> ?8 ");
				if (tipoPedido.equals("C"))
					queryString.append(" and ped.adenda = ?8 ");
			}
		}

		queryString.append("ORDER BY ped.nombresDocente ");

		System.out.println("CONSULTA : " + queryString.toString());

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, "%" + observ + "%");

		if (nombreDocente != null && !nombreDocente.equals("")) {
			query.setParameter(1, "%" + nombreDocente + "%");
		}

		if (idEstado != 0) {
			query.setParameter(2, idEstado);
		}

		if (fechaDesde != null & fechaHasta != null) {
			query.setParameter(3, fechaDesde);
			query.setParameter(4, fechaHasta);

		}

		if (!perfilDecano.equals("Revisor 1 Talento Humano") && !perfilDecano.equals("Revisor 2 Talento Humano")
				&& !perfilDecano.equals("Supervisor Talento Humano")&& !perfilDecano.equals("Control Contratos"))
			if (!id_facultad.equals("")) {
				query.setParameter(5, id_facultad);
			}

		if (pensum != null && pensum.getAñoPensum() != null) {
			query.setParameter(6, pensum.getIdPensum());
		}

		if (nced != null && !nced.equals("")) {
			query.setParameter(7, "%" + nced + "%");
		}

		if (tipoPedido != null && !tipoPedido.equals("")) {
			if (!tipoPedido.equals("ALL")) {
				if (tipoPedido.equals("A"))
					query.setParameter(8, "");
				if (tipoPedido.equals("C"))
					query.setParameter(8, "");
			}
		}

		return query.getResultList();
	}

}
