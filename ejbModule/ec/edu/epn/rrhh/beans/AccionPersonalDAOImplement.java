package ec.edu.epn.rrhh.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.AccionP;

@Stateless
public class AccionPersonalDAOImplement extends DaoGenericoImplement<AccionP> implements AccionPersonalDAO {
				
	@Override
    public Integer getMaxID() {
                   StringBuilder queryString = new StringBuilder("SELECT max(t.id.idAccionp) FROM AccionP t");
                   Query query = getEntityManager().createQuery(queryString.toString());
                   Integer max = (Integer) query.getSingleResult();
                   if(max==null){
                	   return 0;
                   }
                   return max;

    }
}
