package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;

@Local
public interface MovimientosInventarioDAO extends DaoGenerico<Movimientosinventario> {

	List<Existencia> listarExistenciaById(int id);

	Existencia buscarExistenciaById(String id);

}
