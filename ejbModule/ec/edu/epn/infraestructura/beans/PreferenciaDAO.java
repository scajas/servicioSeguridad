package ec.edu.epn.infraestructura.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.ValoresPreferencia;

@Local
public interface PreferenciaDAO extends DaoGenerico<ValoresPreferencia> {

	int consultarId();

}
