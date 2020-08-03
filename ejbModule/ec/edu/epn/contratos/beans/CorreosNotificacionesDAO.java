package ec.edu.epn.contratos.beans;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.CorreosPedidosNotificacione;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface CorreosNotificacionesDAO extends
		DaoGenerico<CorreosPedidosNotificacione> {
	int consultarId();

}
