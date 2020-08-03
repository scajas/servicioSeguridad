package ec.edu.epn.emergencia.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import ec.edu.epn.emergencia.entidades.AsistenciaEmergencia;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Ecivil;



@Remote
public interface AsistenciaEmergenciaDAO extends DaoGenerico<AsistenciaEmergencia> {

	List<AsistenciaEmergencia> findAsistencia();
	
	List<AsistenciaEmergencia> getAsistenciasByDate(Date fechaDesde, Date fechaHasta, String nced, char tipoPersona);
	
	List<Object[]> getAforoByDate(Date[] aforoDateHours);

}
