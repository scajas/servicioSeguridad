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
import ec.edu.epn.atencionmedica.entities.HorarioMedico;
import ec.edu.epn.atencionmedica.entities.Movimientoinventario;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;

/**
 * Session Bean implementation class AtencionMedicaConDespachoIMDAOImplement
 */
@Stateless
public class HorarioMedicoDAOImplement extends DaoGenericoImplement<HorarioMedico> implements HorarioMedicoDAO {
	
	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;
	

	

	@Override
	public HorarioMedico consultarHorarioMedico(Integer cedula) {
		List<HorarioMedico> resultado = new ArrayList<HorarioMedico>();
		StringBuilder queryString = new StringBuilder("SELECT " + "fam FROM HorarioMedico fam where "
				+ "fam.personal.idPersonal = :cedula order by fam.id desc");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter("cedula", cedula);
		resultado = query.getResultList();
		if(resultado!=null && !resultado.isEmpty()){
			return resultado.get(0);
		}
		else
			return null;
	}

	@Override
	public Integer getMaxId() {
		Integer resultado = 1;
		StringBuilder queryString = new StringBuilder("SELECT max(fam.id) FROM HorarioMedico fam");
		Query query = getEntityManager().createQuery(queryString.toString());
		resultado = (Integer) query.getSingleResult();
		if(resultado==null)
			resultado = 0;
		return resultado;
	}
	


}
