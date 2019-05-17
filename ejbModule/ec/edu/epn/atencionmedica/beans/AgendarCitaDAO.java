package ec.edu.epn.atencionmedica.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Agendarcita;
import ec.edu.epn.atencionmedica.entities.Atencionmedica;
import ec.edu.epn.atencionmedica.entities.Movimientoinventario;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;

@Local
public interface AgendarCitaDAO extends DaoGenerico<Agendarcita>{
	
	public List<Agendarcita> consultarCitaMedico(String identificacion);

	public List<Agendarcita> consultarCitaMedico(String identificacion, Date fecha);

	public Integer getMaxId();

}
