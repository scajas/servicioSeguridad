package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.Horario;
@Local
public interface HorarioDAO extends DaoGenerico<Horario>{
	public int maxHorario();
	public List<Horario> listaHorariosConincide(Horario hirario);

}
