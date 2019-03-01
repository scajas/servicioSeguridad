package ec.edu.epn.infraestructura.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.TipoEspacio;
@Local
public interface TipoEspacioDAO extends DaoGenerico<TipoEspacio>{
	public int maxTipoEspacio();
	
}
