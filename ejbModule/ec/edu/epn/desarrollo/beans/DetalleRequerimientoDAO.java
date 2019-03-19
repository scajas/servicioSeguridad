package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.desarrollo.entities.DetalleRequerimiento;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface DetalleRequerimientoDAO extends DaoGenerico<DetalleRequerimiento> {

	List<DetalleRequerimiento> consultarDetallesbyReq(Integer idreq);

}
