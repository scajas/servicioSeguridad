package ec.edu.epn.rrhh.beans;


import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.NominacionCatalogo;

@Remote
public interface NominacionCatalogoDAO extends DaoGenerico<NominacionCatalogo> {

	public List<NominacionCatalogo> findActive();

	
}
