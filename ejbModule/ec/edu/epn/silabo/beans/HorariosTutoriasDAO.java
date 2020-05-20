package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.HorariosTutoria;

@Local
public interface HorariosTutoriasDAO extends DaoGenerico<HorariosTutoria>{

	List<HorariosTutoria> consultarHorariosTutorias(Integer idsilado);

}
