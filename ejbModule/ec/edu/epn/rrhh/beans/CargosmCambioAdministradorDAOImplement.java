package ec.edu.epn.rrhh.beans;

import javax.ejb.Stateless;
import javax.persistence.Query;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.CargosmCambioAdministrador;

@Stateless
public class CargosmCambioAdministradorDAOImplement extends DaoGenericoImplement<CargosmCambioAdministrador> implements CargosmCambioAdministradorDAO{

	@Override
	public Integer getMaxID() {
		  StringBuilder queryString = new StringBuilder("SELECT max(t.id) FROM CargosmCambioAdministrador t");
          Query query = getEntityManager().createQuery(queryString.toString());
          Integer max = (Integer) query.getSingleResult();
          if(max==null){
       	   return 0;
          }
          return max;
	}
	


}
