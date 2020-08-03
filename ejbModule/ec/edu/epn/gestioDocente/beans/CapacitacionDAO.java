package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Capacitacion;

@Local
public interface CapacitacionDAO extends DaoGenerico<Capacitacion>{

	List<Capacitacion> buscarCapacitacionesByParam(String cedula, String validarecategoriza, String validarevaloriza
			,String nombre, boolean ordenPeriodo) throws Exception;
	
	List<Capacitacion> listaCapacitacionXCedula(String cedula) throws Exception;

	//List<Capacitacion> buscarCapacitacionesByValidacion(String cedula, List<String> tipo, List<String> validacion) throws Exception;

	int countCapacitacionXNombre(String cedula, String nombreCapacitacion, Capacitacion capacitacion) throws Exception;

	List<Capacitacion> buscarCapacitacionesByParamDictadas(String cedula, String validarecategoriza,
			String validarevaloriza, String nombre, boolean ordenPeriodo) throws Exception;

	List<Capacitacion> buscarCapacitacionesByPeriodoTipo(String cedula, String idPeriodo, String tipo) throws Exception;
	
	
}
