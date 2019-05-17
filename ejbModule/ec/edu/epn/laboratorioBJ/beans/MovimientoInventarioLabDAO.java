package ec.edu.epn.laboratorioBJ.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;

@Local
public interface MovimientoInventarioLabDAO extends DaoGenerico<Movimientosinventario> {

	Existencia buscarExistenciaById(String id);

}
