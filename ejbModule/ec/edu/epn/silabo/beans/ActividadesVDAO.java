package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.ActividadesVinculacion;

@Local
public interface ActividadesVDAO extends DaoGenerico<ActividadesVinculacion>{

	List<ActividadesVinculacion> consultarActividades(Integer idsilado);

	int maxIdActividades();

}
