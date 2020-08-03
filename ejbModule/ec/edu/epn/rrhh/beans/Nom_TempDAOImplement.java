/**
 * 
 */
package ec.edu.epn.rrhh.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.DTO.NombTempDTO;
import ec.edu.epn.rrhh.entities.NombTemp;

/**
 * @author Administrador
 * 
 */
@Stateless
public class Nom_TempDAOImplement extends DaoGenericoImplement<NombTemp> implements Nom_TempDAO {

	@Override
	public NombTemp findbyNced(String nced) {
		StringBuilder querys = new StringBuilder("SELECT e From NombTemp e where e.nced = ?1 limit 1 ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);
		
		return (NombTemp) query.getSingleResult();
	}
	
	
	@Override
	public NombTemp consultarNombramiento(String nced) {
		StringBuilder querys = new StringBuilder(
				"SELECT e From NombTemp e where e.nced = ?1 and  e.frigeNomb is not null order by e.frigeNomb desc");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);
		query.setMaxResults(1);

		try {
			NombTemp nom = (NombTemp) query.getSingleResult();
			return nom;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}
	
	@Override
	public List<NombTemp> consultarNombramientosHistoria(String nced) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From NombTemp e where e.nced = ?1 order by e.frigeNomb DESC ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);

		return query.getResultList();

	}
	
	
	@Override
	public List<NombTemp> consultarNombramientosHistoria2012(String nced) {

		StringBuilder querys = new StringBuilder(
				"SELECT e From NombTemp e where e.nced = ?1 and extract(year from e.ffinNomb)>=?2  order by e.frigeNomb DESC ");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, nced);
		query.setParameter(2, 2012);

		return query.getResultList();

	}
	
	@Override
	public int consultarIdnombramiento() {
		
		Query q = getEntityManager().createQuery(
				"SELECT MAX(seg.nroNomb)FROM NombTemp seg");

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
	public NombTemp findNombyID(Integer idnom) {

		Query q = getEntityManager().createQuery(
				" Select nom from NombTemp  nom where nom.nroNomb = ?1 ");
		q.setParameter(1, idnom);

		return (NombTemp) q.getSingleResult();

	}
	
	
	@Override
	public void updateNombramiento(Integer idnom, String path) {

		Query q = getEntityManager().createQuery(
				"UPDATE NombTemp SET path = ?1 where nroNomb = ?2 ");
		q.setParameter(2, idnom);
		q.setParameter(1, path);

		q.executeUpdate();

	}
	
	/**
	 * lista las entidades nombramientos por la cedula y por el id del pensum que se requiera
	 * @param cedula - string del numero de cedula a buscar
	 * @param idPensum - integer del id del pensum que se requiere
	 * @return Lista de nombramientos por los parametros enviados
	 * @throws NoResultException - Excepcion lanzada cuando no se encuentra la entidad
	 * @throws Exception - Excepcion general
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NombTemp> listarNombramientosXcedulaXidPensum(String cedula, Integer idPensum)throws NoResultException, Exception{

		List<NombTemp> retorno = null;
		try{
			StringBuilder stQuery= new StringBuilder();
			stQuery.append(" SELECT nomb FROM NombTemp nomb where nomb.nced = :cedula ");
			if(!idPensum.equals(Integer.valueOf("-99"))){
				stQuery.append(" AND nomb.pensum.idPensum = :idPensum ");
			}
			stQuery.append(" order by nomb.nroNomb ");
			Query q = getEntityManager().createQuery(stQuery.toString());
			if(!idPensum.equals(Integer.valueOf("-99"))){
				q.setParameter("idPensum", idPensum);	
			}
			q.setParameter("cedula", cedula);
			retorno = q.getResultList();
		} catch (NoResultException e) {
			throw new NoResultException("No se encontró los nombramientos para el docente y el período buscado");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al buscar los nombramientos");
		}
		return retorno;
	}
	
	/**
	 * lista las entidades nombramientos por la cedula y por el id del pensum que se requiera JDBC
	 * @param cedula - string del numero de cedula a buscar
	 * @param idPensum - integer del id del pensum que se requiere
	 * @return Lista de nombramientos por los parametros enviados
	 * @throws SQLException - Excepcion lanzada cuando no se encuentra la entidad
	 * @throws Exception - Excepcion general
	 */
	@Override
	public List<NombTempDTO> listarNombramientosXcedulaXidPensumJdbc(String cedula, Integer idPensum) throws SQLException, Exception{
		List<NombTempDTO> retorno= null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			StringBuilder sbSql = new StringBuilder();
			sbSql.append(" SELECT ");
			sbSql.append(" nomb.");sbSql.append("nro_nomb ");
			sbSql.append(" ,nomb.");sbSql.append("nced ");
			sbSql.append(" ,nomb.");sbSql.append("id_pensum ");
			sbSql.append(" ,nomb.");sbSql.append("path ");
			sbSql.append(" FROM ");sbSql.append(" \"Rrhh\".nomb_temp ");sbSql.append(" nomb ");
			sbSql.append(" WHERE ");sbSql.append(" nomb.");sbSql.append("nced ");sbSql.append(" = ?");
			if(!idPensum.equals(Integer.valueOf("-99"))){
				sbSql.append(" AND ");sbSql.append(" nomb.");sbSql.append("id_pensum ");sbSql.append(" = ?");
			}

			con = getDataSource().getConnection();
			pstmt = con.prepareStatement(sbSql.toString());
			pstmt.setString(1, cedula);
			if(!idPensum.equals(Integer.valueOf("-99"))){
				pstmt.setInt(2, idPensum);
			}
			System.out.println(sbSql.toString());
			rs = pstmt.executeQuery();
			retorno = new ArrayList<NombTempDTO>();
			while(rs.next()){
				retorno.add(transformarResultSetAdto(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Error al generar la consulta : (SQL) ");
		} catch (Exception e) {
			throw new Exception("Error inesperado, vuelva a intentarlo");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				}	
		}
		return  retorno;
	}
	
	
	/* ********************************************************************************* *
	 * ************************** METODOS DE TRANSFORMACION **************************** *
	 * ********************************************************************************* */
	
	
	/**
	 * Método privado que sirve para trasformar los datos del resulset a EntidadDto
	 * @param rs - rs parámetros de ingreso
	 * @return retorna el DTO seteado con los datos correctos
	 * @throws SQLException - SQLException Excepción de error en la consulta sql
	 */
	private NombTempDTO transformarResultSetAdto(ResultSet rs) throws SQLException{
		NombTempDTO retorno = new NombTempDTO();
		  retorno.setNroNomb(rs.getInt("nro_nomb"));
		  retorno.setNced(rs.getString("nced"));
		  retorno.setPensum(rs.getInt("id_pensum"));
		  retorno.setPath(rs.getString("path"));
		return retorno;
	} 
	
	
	
	/**OBTENER NOMBRAMIENTO POR MAX FECHA INICIO*/
	@Override
	public List<NombTempDTO> listarNombramientosXcedulaMaxFecha(String cedula) throws SQLException, Exception{
		List<NombTempDTO> retorno= null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			StringBuilder sbSql = new StringBuilder();
			sbSql.append(" SELECT ");
			sbSql.append(" MAX(nomb.nro_nomb) AS nro_nomb");
			sbSql.append(" ,nomb.");sbSql.append("nced ");
			sbSql.append(" ,nomb.");sbSql.append("id_pensum ");
			sbSql.append(" ,nomb.");sbSql.append("path, MAX(to_date(nomb.frige_nomb, 'yyyy-MM-dd')) ");
			sbSql.append(" FROM ");sbSql.append(" \"Rrhh\".nomb_temp ");sbSql.append(" nomb ");
			sbSql.append(" WHERE ");sbSql.append(" nomb.");sbSql.append("nced ");sbSql.append(" = ?");
			sbSql.append(" GROUP BY nced, path, id_pensum, frige_nomb  ORDER BY nomb.frige_nomb DESC LIMIT 1");
			

			con = getDataSource().getConnection();
			pstmt = con.prepareStatement(sbSql.toString());
			pstmt.setString(1, cedula);
			
			System.out.println(sbSql.toString());
			rs = pstmt.executeQuery();
			retorno = new ArrayList<NombTempDTO>();
			while(rs.next()){
				retorno.add(transformarResultSetAdto(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Error al generar la consulta : (SQL) ");
		} catch (Exception e) {
			throw new Exception("Error inesperado, vuelva a intentarlo");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				}	
		}
		return  retorno;
	}
	
	
	

}
