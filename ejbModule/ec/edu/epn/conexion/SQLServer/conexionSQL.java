package ec.edu.epn.conexion.SQLServer;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;

import ec.edu.epn.catalogos.entities.Carrera;




public class conexionSQL {

	private java.sql.Connection conection = null;

	public java.sql.Connection getConection() {
		return conection;
	}

	public void setConection(java.sql.Connection conection) {
		this.conection = conection;
	}
	
	private String url = "jdbc:sqlserver://";		 
	

	/**PRDUCCION BD SAEW*/
//	private String serverName = "172.31.1.13";
//	private String portNumber = "1433";
//	private String databaseName = "SAE";
//	private String userName = "uappsae";
//	private String password = "**AX$$721Zi";
	

	/**PRUEBAS SAEW BD*/
	private String serverName = "172.31.4.118";
	 private String portNumber = "1433";	
	 private String databaseName = "SAEUNIFICADO";
	 private String userName = "sa";
	 private String password = "Lcddtp2014";

	// Constructor
	public conexionSQL() {
	}

	public String getConnectionUrl() {
		return url + serverName + ":" + portNumber + ";databaseName=" + databaseName;
	}

	public java.sql.Connection getConnection() {
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			conection = java.sql.DriverManager.getConnection(
					getConnectionUrl(), userName, password);
			if (conection != null)
				System.out.println("Connection Successful!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : "
					+ e.getMessage());
		}
		return conection;
	}

	/*
	 * Display the driver properties, database details
	 */

	public List<Carrera> displayDbProperties() {
		java.sql.DatabaseMetaData dm = null;
		java.sql.ResultSet result = null;

		try {
			conection = this.getConnection();
			if (conection != null) {
				dm = conection.getMetaData();			
				CallableStatement cst = conection.prepareCall("{call pa_saecarrera (?)}");
				// Parametro 1 del procedimiento almacenado
				cst.setString(1, "L");
				// Ejecuta el procedimiento almacenado
				// cst.execute();
				result = cst.executeQuery();
				List<Carrera> listaCarrear = new ArrayList<Carrera>();
				while (result.next()) {					
					Carrera carrera = new Carrera();
					carrera.setIdCarrera(result.getString(1));
					carrera.setNomCarrera(result.getString(2));
					listaCarrear.add(carrera);
				}
				return listaCarrear;
			} else {				
				dm = null;
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			dm = null;
			return null;
		}

	}

	public void closeConnection() {
		try {
			if (conection != null)
				conection.close();
			conection = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}