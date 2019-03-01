package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Gestioncompra;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface GestionCompraDAO extends DaoGenerico<Gestioncompra> {
	int consultarId();

}
