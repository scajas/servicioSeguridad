package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.AreaConocDocente;

@Local
public interface AreaConocimientoDocenteDAO extends DaoGenerico<AreaConocDocente>{

	List<AreaConocDocente> buscarArearByParams(String cedula, String idarea) throws Exception;

	int countAreaConocDocenteXIdArea(String cedula, String idAreaConocimiento, AreaConocDocente areaConocDocente)
			throws Exception;

}
