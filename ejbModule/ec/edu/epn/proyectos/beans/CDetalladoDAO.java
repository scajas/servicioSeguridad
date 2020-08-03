package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Cdetallado;

@Local
public interface CDetalladoDAO extends DaoGenerico<Cdetallado> {

	List<Cdetallado> consultarCEspecificos(Integer idcamplio);

	Cdetallado consultarCespecifico(String nombre);

}
