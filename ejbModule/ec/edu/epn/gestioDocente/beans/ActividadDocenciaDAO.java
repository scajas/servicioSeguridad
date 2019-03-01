package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadDocencia;

@Local
public interface ActividadDocenciaDAO extends DaoGenerico<ActividadDocencia>{

	List<ActividadDocencia> buscarActividadDocenciaBYParams(String cedula, String nivel,String materia,String idCarrera,
			String period, String paralelo) throws Exception;

	int countActividadDocXMateriaCarrera(String cedula, String materia, String codCarrera, String paralelo,
			String idPeriodo, ActividadDocencia actividadDocencia) throws Exception;

}
