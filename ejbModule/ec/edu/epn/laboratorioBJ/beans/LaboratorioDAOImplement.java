package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;

@Stateless
@LocalBean
public class LaboratorioDAOImplement extends DaoGenericoImplement<LaboratorioLab> implements LaboratorioDAO {

	public LaboratorioDAOImplement() {

	}

	@Override
	public List<LaboratorioLab> listaLaboratorioUnidad(int id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT l FROM LaboratorioLab l where id_unidad=?1 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<LaboratorioLab> resultados = query.getResultList();
		return resultados;
	}

}
