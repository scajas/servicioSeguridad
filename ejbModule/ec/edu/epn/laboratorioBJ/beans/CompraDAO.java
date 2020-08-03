package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Compra;
import ec.edu.epn.laboratorioBJ.entities.Movimientosinventario;
import ec.edu.epn.laboratorioBJ.entities.Ordeninventario;

@Local
public interface CompraDAO extends DaoGenerico<Compra> {

	List<Compra> getParametrosCompra(String fechaInicio, String fechaFin, int idUnidad);

	List<Compra> getListCompras(String id);

	String maxIdOrdenI(int id, String fecha);


	List<Movimientosinventario> listaMovInv(String id);

	Ordeninventario ordenInvByCompra(String id);


}

