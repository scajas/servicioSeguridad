package ec.edu.epn.laboratorioBJ.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Detallemetodo;
import ec.edu.epn.laboratorioBJ.entities.Ordeninventario;
import ec.edu.epn.laboratorioBJ.entities.SaldoExistencia;

/**
 * Session Bean implementation class SaldoExistenciaDAOImplement
 */
@Stateless
@LocalBean
public class SaldoExistenciaDAOImplement extends DaoGenericoImplement<SaldoExistencia> implements SaldoExistenciaDAO {

	/**
	 * Default constructor.
	 */
	public SaldoExistenciaDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	public List<SaldoExistencia> listaSaldoExistenciaAnioActual() {
		String fecha = obtenerFecha();

		String[] parts = fecha.split("-");

		String anio = parts[0];
		String m = parts[1];

		StringBuilder queryString = new StringBuilder(
				"SELECT s FROM SaldoExistencia s where s.id.anio = " + anio + " AND s.id.mes = " + m );
		
		Query query = getEntityManager().createQuery(queryString.toString());

		List<SaldoExistencia> resultados = query.getResultList();
		return resultados;
	}

	public String obtenerFecha() {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String date = sdf.format(calendar.getTime());

		String[] parts = date.split("-");

		String dia = parts[2];

		if (dia.equals("31")) {
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
			 System.out.println("Fecha de hoy restada un dia: " +
			 sdf.format(calendar.getTime()));

			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
			System.out.println("Fecha de hoy restado el mes: " + sdf.format(calendar.getTime()));

		} else {
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
			 System.out.println(
			 "Fecha de hoy restado el mes sin tomar en cuenta el diass: " +
			 sdf.format(calendar.getTime()));
		}
	 System.out.println("Fecha restada: " +
		 sdf.format(calendar.getTime()));
	

		String fecha = sdf.format(calendar.getTime());

		return fecha;

	}

}
