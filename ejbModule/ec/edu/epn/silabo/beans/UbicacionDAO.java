package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.UbicacionHorario;

@Local
public interface UbicacionDAO extends DaoGenerico<UbicacionHorario>{

	List<UbicacionHorario> consultarUbicacion(Integer idsilado);

	int maxIdHorario();

}
