package ec.indumaq.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.indumaq.entidades.ProductoIndumaq;

@Local
public interface ProductoIndumaqDAO extends DaoGenerico<ProductoIndumaq> {

}
