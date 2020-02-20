package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Ordeninventario;

@Stateless
@LocalBean
public class LaboratorioDAOImplement extends DaoGenericoImplement<LaboratorioLab> implements LaboratorioDAO {

	public LaboratorioDAOImplement() {

	}

	@Override
	public List<LaboratorioLab> listaLaboratorioUnidad(Integer id) {
		StringBuilder queryString = new StringBuilder(
				"SELECT l FROM LaboratorioLab l where l.unidad.idUnidad =? 1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);

		List<LaboratorioLab> resultados = query.getResultList();
		return resultados;
	}
	
	
	@Override
	public List<LaboratorioLab> getListLabById(String id) {

		StringBuilder queryString = new StringBuilder(
				"SELECT l FROM LaboratorioLab l where l.unidad.codigoU like '%" + id + "%' ORDER BY nombreL");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<LaboratorioLab> resultados = query.getResultList();
		return resultados;
	}

}
