package ec.edu.epn.silabo.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.PermisosSaew;

@Local
public interface PermisosSaewDAO extends DaoGenerico<PermisosSaew>{

	List<PermisosSaew> consultarPermisosSAEW(String carrera, String anio, String semestre);

	int maxId();

	PermisosSaew consultarPermiso(Date fecha,String codcarre);

	

}
