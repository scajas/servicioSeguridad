package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.ProductoLab;

@Local
public interface ProductoLabDAO  extends DaoGenerico<ProductoLab> {

	List<ProductoLab> filtrarLista(String dato);

}
