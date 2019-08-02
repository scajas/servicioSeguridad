package ec.edu.epn.atencionmedica.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Agendarcita;
import ec.edu.epn.atencionmedica.entities.Atencionmedica;
import ec.edu.epn.atencionmedica.entities.Mensaje;
import ec.edu.epn.atencionmedica.entities.Movimientoinventario;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;

/**
 * Session Bean implementation class AtencionMedicaConDespachoIMDAOImplement
 */
@Stateless
public class MensajesDAOImplement extends DaoGenericoImplement<Mensaje> implements MensajesDAO {
	
	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;
	

	@Override
	public List<Mensaje> consultarMensajeActivoTipo(String tipo) {
		List<Mensaje> resultado = new ArrayList<Mensaje>();
		StringBuilder queryString = new StringBuilder("SELECT " + "fam FROM Mensaje fam where "
				+ "tipo = :tipomensaje and estado = 'activo'  ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter("tipomensaje", tipo);
		resultado = query.getResultList();

		return resultado;
	}

}
