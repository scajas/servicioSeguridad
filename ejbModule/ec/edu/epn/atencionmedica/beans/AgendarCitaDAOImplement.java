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
import ec.edu.epn.atencionmedica.entities.Movimientoinventario;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;

/**
 * Session Bean implementation class AtencionMedicaConDespachoIMDAOImplement
 */
@Stateless
public class AgendarCitaDAOImplement extends DaoGenericoImplement<Agendarcita> implements AgendarCitaDAO {
	
	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;
	
	@Override
	public List<Agendarcita> consultarCitaMedico(String cedula, Date fecha) {
		List<Agendarcita> resultado = new ArrayList<Agendarcita>();
		StringBuilder queryString = new StringBuilder("SELECT " + "fam FROM Agendarcita fam where "
				+ "personal.identificacionPrs = :cedula and fecha =:fecha  ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter("cedula", cedula);
		query.setParameter("fecha", fecha);
		resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<Agendarcita> consultarCitaMedico(String cedula) {
		List<Agendarcita> resultado = new ArrayList<Agendarcita>();
		StringBuilder queryString = new StringBuilder("SELECT " + "fam FROM Agendarcita fam where "
				+ "personal.identificacionPrs = :cedula and fam.estado!='Cancelada' and fam.activo=='TRUE'");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter("cedula", cedula);
		resultado = query.getResultList();
		return null;
	}

	@Override
	public Integer getMaxId() {
		Integer resultado = 1;
		StringBuilder queryString = new StringBuilder("SELECT max(fam.id) FROM Agendarcita fam");
		Query query = getEntityManager().createQuery(queryString.toString());
		resultado = (Integer) query.getSingleResult();
		if(resultado==null)
			resultado = 1;
		return resultado;
	}
	


}
