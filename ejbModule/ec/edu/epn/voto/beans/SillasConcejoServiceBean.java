package ec.edu.epn.voto.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * Session Bean implementation class OrdenTrabajoServiceBean
 */
@Stateless
public class SillasConcejoServiceBean implements SillasConcejoService {
	@Resource(mappedName = "java:jboss/datasources/SeguridadEPNDS")
	DataSource ds;
	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public boolean ingresarImagen(String pathImagenSilla, int id_silla) {

		Connection con = null;
		PreparedStatement ps = null;

		System.out.println(pathImagenSilla + " " + id_silla);
		try {
			con = ds.getConnection();
			if (con != null) {
				File f = new File(pathImagenSilla);
				FileInputStream s = new FileInputStream(f);
				ps = con.prepareStatement("UPDATE \"Votoe\".sillas_concejo set imagen_silla=? WHERE id_silla=?");
				ps.setBinaryStream(1, s, (int) f.length());
				ps.setInt(2, id_silla);
				ps.executeUpdate();
				ps.close();
				s.close();
				con.close();
				return true;
			} else {
				System.out.println("Error en la conexion");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public byte[] obtenerImagen(int id_silla) throws SQLException, IOException {

		Connection con = null;
		PreparedStatement ps = null;
		byte[] i = null;
		try {
			con = ds.getConnection();
			if (con != null) {
				ps = con.prepareStatement("select imagen_silla from \"Votoe\".sillas_concejo  where id_silla=?");
				ps.setLong(1, id_silla);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					i = null;
					i = rs.getBytes("imagen_silla");
				}
				rs.close();
				ps.close();
				
				return i;
			} else {
				System.out.println("Error en la conexion");
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR EN obtenerImagen");
			return null;
		} finally {
			con.close();
		}
	}

}
