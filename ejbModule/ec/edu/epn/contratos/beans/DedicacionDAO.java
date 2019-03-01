package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.DedicacionContratos;
import ec.edu.epn.generic.DAO.DaoGenerico;


@Local
public interface DedicacionDAO extends DaoGenerico<DedicacionContratos> {
	
	List<DedicacionContratos> lisDedicacionxNombre(String nombre);

}
