package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActAcademica;


@Local
public interface ActAcademicaDAO extends DaoGenerico<ActAcademica> {

	List<ActAcademica> listActAcademTipo(Integer idPlanAcad, Integer idTipo);

	List<ActAcademica> listActAcademXPlanificacion(Integer idPlanAcad);

	
}
