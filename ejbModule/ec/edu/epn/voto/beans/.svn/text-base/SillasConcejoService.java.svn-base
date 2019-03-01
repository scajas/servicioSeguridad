package ec.edu.epn.voto.beans;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.Local;

@Local
public interface SillasConcejoService {

	boolean ingresarImagen(String pathImagenSilla, int id_silla);
	byte[] obtenerImagen(int id_silla) throws SQLException, IOException;

}
