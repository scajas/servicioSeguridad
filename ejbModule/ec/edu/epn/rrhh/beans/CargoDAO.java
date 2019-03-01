package ec.edu.epn.rrhh.beans;



import java.util.List;

import javax.ejb.Remote;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.AccionP;
import ec.edu.epn.rrhh.movimientos.Cargosm;
import ec.edu.epn.rrhh.movimientos.Dependencia;

@Remote
public interface CargoDAO extends DaoGenerico<Cargosm> {
	
	List<Cargosm> findCargosbyId(Integer id);
	public Cargosm findCargoById(Integer id);
	List<Cargosm> findCargosActivos();
	List<Cargosm> findCargosByDedicacionAndCargo(String nivelGrado, String grupo);
	List<Cargosm> findCargosByDedicacion(String dedicacion);
	List<Cargosm> findCargosByGrupo(String grupo);
	public List<Cargosm> findCargosActivosbyGrupo(String grupo);
	List<Cargosm> findCargos();
	Integer getMaxId();

	

}
