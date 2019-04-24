package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Bodega;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.OrdenTrabajo;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;
import ec.edu.epn.laboratorioBJ.entities.laboratory;

/**
 * Session Bean implementation class OrdenTrabajoDAOImplement
 */
@Stateless
@LocalBean
public class OrdenTrabajoDAOImplement extends DaoGenericoImplement<OrdenTrabajo> implements OrdenTrabajoDAO {

	private String consulta;

	@Override
	public List<Detalleorden> filtrarLista(String fechaInicio, String fechaFin, String tipo, String estado, String laboratorio,String personal) {

		if (personal.equals("")) {
			setConsulta("SELECT o FROM Detalleorden o WHERE o.ordenTrabajo.estadoOt like '%" + estado
					+ "%' AND o.ordenTrabajo.fechaordenOt BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'");

		} else if (estado.equals("")) {
			setConsulta("SELECT o FROM Detalleorden o WHERE o.personal.nombresPe like '%" + personal
					+ "%' AND o.ordenTrabajo.fechaordenOt BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'");

		} else {
			setConsulta("SELECT o FROM Detalleorden o WHERE o.personal.nombresPe like '%" + personal
					+ "%' AND o.ordenTrabajo.estadoOt like '%" + estado + "%' AND o.ordenTrabajo.fechaordenOt BETWEEN '"
					+ fechaInicio + "' AND '" + fechaFin + "'");
		}

		System.out.println("FECHA DESDE: " + fechaInicio + "HASTA: " + fechaFin);
		System.out.println("Consulta: " + getConsulta());

		System.out.println(personal);

		StringBuilder queryString = new StringBuilder(getConsulta());
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Detalleorden> resultados = query.getResultList();

		return resultados;
		/*
		 * Query q = super.getEntityManager().
		 * createQuery("Select orden_trabajo from OrdenTrabajo orden_trabajo Where orden_trabajo.idOrden like ?1"
		 * ); q.setParameter(1, idOrden + "%");
		 * 
		 * return q.getResultList();
		 */

	}

	public List<PersonalLab> listaPersonalAnalista() {
		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM PersonalLab p where p.cargospersonal.idCargo = '1' ");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<PersonalLab> resultados = query.getResultList();
		return resultados;
	}

	public List<LaboratorioLab> listaLaboratorioUnidad(int id) {
		StringBuilder queryString = new StringBuilder("SELECT l FROM LaboratorioLab l where l.unidad.idUnidad = ?0 ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, id);

		List<LaboratorioLab> resultados = query.getResultList();
		return resultados;
	}

	public OrdenTrabajoDAOImplement() {
		// TODO Auto-generated constructor stub
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

}
