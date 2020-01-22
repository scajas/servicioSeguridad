package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenerico;

import ec.edu.epn.laboratorioBJ.entities.Detallemetodo;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.Ordeninventario;
import ec.edu.epn.laboratorioBJ.entities.UnidadLabo;

@Local
public interface OrdenInventarioDAO extends DaoGenerico<Ordeninventario> {

	List<Detallemetodo> listaDetalleMetodo(String id);

	List<Existencia> listaExistencia(String id);

	Metodo findMetodoById(String id);

	List<Ordeninventario> getListOI(Integer idUsuario, Integer idUnidad);

	List<Movimientosinventario> listaMovimientoI(String id);

	Existencia findExistenciaById(String id);

	List<Ordeninventario> listaOI(int id);

	List<Ordeninventario> getListOIById(String id);

	String maxIdOrdenI(int id, String fecha);

	UnidadLabo obtenerUnidad(int id);

	List<Ordeninventario> getListOTById(String id);

}
