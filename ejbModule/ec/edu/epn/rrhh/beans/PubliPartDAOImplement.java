package ec.edu.epn.rrhh.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.PubliPart;

@Stateless
public class PubliPartDAOImplement extends DaoGenericoImplement<PubliPart> implements PubliPartDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<PubliPart> listaOtrasPublicacionesXCedula(String cedula) {
		StringBuilder queryString = new StringBuilder("SELECT pp FROM PubliPart pp where pp.emp.nced =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, cedula);
		return query.getResultList();
	}

	@Override
	public boolean validarPublicaciones(String actividad, String cedula, Date fechaInicio) {

		boolean validar = false;
		StringBuilder queryString = new StringBuilder(
				"SELECT pp FROM PubliPart pp where pp.emp.nced =?1 and pp.actividad = ?2 ");
		if (fechaInicio != null)
			queryString.append(" and pp.fechaIni = ?3");
		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, cedula);
		query.setParameter(2, actividad);

		if (fechaInicio != null)
			query.setParameter(3, fechaInicio);

		if (query.getResultList().size() > 0)
			validar = true;
		else
			validar = false;

		return validar;
	}

}
