package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Tipoproductoservicio;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface TipoProductoServicioProveedorDAO extends DaoGenerico<Tipoproductoservicio> {
	int consultarId();

}
