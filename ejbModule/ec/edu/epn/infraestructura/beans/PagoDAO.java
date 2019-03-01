package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.Pago;

@Local
public interface PagoDAO extends DaoGenerico<Pago> {
	public int consultarId();

	List<Pago> listaPagos();
	
	

}
