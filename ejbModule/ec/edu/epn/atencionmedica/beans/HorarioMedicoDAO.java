package ec.edu.epn.atencionmedica.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Agendarcita;
import ec.edu.epn.atencionmedica.entities.HorarioMedico;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface HorarioMedicoDAO extends DaoGenerico<HorarioMedico>{
	
	public HorarioMedico consultarHorarioMedico(Integer identificacion);

	;

	public Integer getMaxId();

}
