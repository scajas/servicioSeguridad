package ec.edu.epn.rrhh.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.DTO.EquipoDTO;
import ec.edu.epn.rrhh.entities.Equipo;

@Local
public interface EquipoDAO extends DaoGenerico<Equipo> {

	public List<EquipoDTO> listaEquiposAsignados(String idFacultad, String idLaboratorio, String numCedula,
			String nombreEmp, String tipoAsignacion, Date fechaInicio, Date fechaFin) throws Exception;

	public List<EquipoDTO> listaEquiposAsignadosGeneral(String numCedula, String nombreEmp, Integer idTipoEquipo,
			Date fechaInicio, Date fechaFin, String nroContrato) throws Exception;

}
