package ec.edu.epn.rrhh.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.Docadjunto;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboralPK;
import ec.edu.epn.rrhh.movimientos.HlaboralCambioAdministrador;

@Stateless
public class HlaboralCambioAdministradorDAOImplement extends DaoGenericoImplement<HlaboralCambioAdministrador> implements HlaboralCambioAdministradorDAO{

	@Override
	public Integer getMaxID() {
		  StringBuilder queryString = new StringBuilder("SELECT max(t.id) FROM HlaboralCambioAdministrador t");
          Query query = getEntityManager().createQuery(queryString.toString());
          Integer max = (Integer) query.getSingleResult();
          if(max==null){
       	   return 0;
          }
          return max;
	}
	


}
