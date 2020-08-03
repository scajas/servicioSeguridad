package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.DedicacionContratos;
import ec.edu.epn.contratos.entities.RelacionDedicacion;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface RelacionDedicacionDAO extends DaoGenerico<RelacionDedicacion> {

	List<DedicacionContratos> listaDedicacionXRelacionDependencia(int relDependencia);

}
