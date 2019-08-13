package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.CargaAcademicaPreplanif;


@Local
public interface CargaAcademicaPreplanifDAO extends DaoGenerico<CargaAcademicaPreplanif> {

	List<CargaAcademicaPreplanif> findCargaAcadByIdPreplanif(int idPreplanificacion);

	Double sumValorAsignaturas(Integer idPreplanificacion);

	Long countAsignXPreplanif(Integer idPreplanificacion) throws Exception;

	

	
}
