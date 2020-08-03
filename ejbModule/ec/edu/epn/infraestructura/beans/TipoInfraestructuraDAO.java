package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.TipoInfraestructura;

@Local
public interface TipoInfraestructuraDAO extends
		DaoGenerico<TipoInfraestructura> {
	public int consultarID();
	

}
