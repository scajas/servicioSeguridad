package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.PartidaGeneral;

@Stateless
public class PartidaGeneralDAOImplement extends DaoGenericoImplement<PartidaGeneral> implements PartidaGeneralDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<PartidaGeneral> getAllPartidasGenerales() {
		StringBuilder queryString = new StringBuilder("Select pg from PartidaGeneral pg");
		Query query = getEntityManager().createQuery(queryString.toString());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PartidaGeneral> getPartidasGeneralesActivas() {
		StringBuilder queryString = new StringBuilder("Select pg from PartidaGeneral pg where pg.estado =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "ACTIVO");

		return query.getResultList();
	}
	
	
	@Override
	public int getMaxIDPartidasGenerales() {
		StringBuilder queryString = new StringBuilder("Select max(pg.idPartidaGeneral) from PartidaGeneral pg ");
		Query query = getEntityManager().createQuery(queryString.toString());
		
		return (int) query.getSingleResult();
	}

}
