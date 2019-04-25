package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Compra;

@Local
public interface CompraDAO extends DaoGenerico<Compra> {

	List<Compra> getParametrosCompra(String fechaInicio, String fechaFin);

}
