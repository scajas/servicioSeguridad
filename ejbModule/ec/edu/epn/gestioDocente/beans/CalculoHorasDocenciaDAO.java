package ec.edu.epn.gestioDocente.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.CalculoHorasDocencia;
import ec.edu.epn.gestionDocente.entities.CargaAcademicaSae;


@Local
public interface CalculoHorasDocenciaDAO extends DaoGenerico<CalculoHorasDocencia> {

	Integer valCalculoDocencia(CargaAcademicaSae dto);
	

	
	
}
