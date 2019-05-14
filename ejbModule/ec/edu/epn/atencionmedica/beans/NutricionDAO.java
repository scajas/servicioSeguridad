package ec.edu.epn.atencionmedica.beans;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Nutricion;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface NutricionDAO extends DaoGenerico<Nutricion>{

	Nutricion nutricionXIdAsistencia(Integer idAsistenciaMedica);

	
}
