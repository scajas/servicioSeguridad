package ec.edu.epn.rrhh.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.Docadjunto;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboralPK;

@Stateless
public class DocAdjuntoDAOImplement extends DaoGenericoImplement<Docadjunto> implements DocAdjuntoDAO {

	@Override
	public Integer getMaxID() {
		StringBuilder queryString = new StringBuilder("SELECT max(t.idDoc) FROM Docadjunto t");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null) {
			return 0;
		}
		return max;
	}

	@Override
	public Docadjunto getDocHist(Integer numhistoria) {
		Docadjunto doc = new Docadjunto();
		StringBuilder queryString = new StringBuilder(
				"SELECT t FROM Docadjunto " + "t where t.historiaLaboral.id.idHist =?1 "
						+ "order by t.idDoc desc ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, numhistoria);
        try{
        	doc = (Docadjunto) query.getResultList().get(0);	
        }catch(IndexOutOfBoundsException e){
        	return null;
        }
		
		return doc;
	}

	@Override
	public Docadjunto getDocHistbyId(HistoriaLaboralPK id) {
		Docadjunto doc = new Docadjunto();
		StringBuilder queryString = new StringBuilder("SELECT t FROM Docadjunto " + "t where t.historiaLaboral.id =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);
		try {
			doc = (Docadjunto) query.getResultList().get(0);
		} catch (IndexOutOfBoundsException ie) {
			return null;
		} 
		return doc;
	}

	@Override
	public List<Docadjunto> getListDocHistbyId(HistoriaLaboralPK id) {
		List<Docadjunto> ldoc = new ArrayList<Docadjunto>();
		StringBuilder queryString = new StringBuilder("SELECT t FROM Docadjunto " + "t where t.historiaLaboral.id =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, id);
		ldoc = query.getResultList();

		return ldoc;
	}

}
