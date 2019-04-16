package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.ProductoLab;
import ec.edu.epn.laboratorioBJ.entities.SaldoExistencia;

@Local
public interface ExistenciasDAO extends DaoGenerico<Existencia> {

	SaldoExistencia findSaldoById(String id);

	List<ProductoLab> filtrarLista(String dato);

	String maxIdServ(int id);

	List<Movimientosinventario> listarMovimientoById(String idExistencia);

	List<Existencia> listarExistenciaById(int id);

}
