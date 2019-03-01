package ec.edu.epn.contratos.beans;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Estado;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface EstadoDAO extends DaoGenerico<Estado> {
}
