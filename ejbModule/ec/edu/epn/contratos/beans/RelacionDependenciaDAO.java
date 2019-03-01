package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.RelacionActual;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface RelacionDependenciaDAO extends DaoGenerico<RelacionActual> {

	List<RelacionActual> listaRelacionActualxNombre(String nombre);

	List<RelacionActual> listaRelacionActualxTipoContrato(int tipoCont);

}
