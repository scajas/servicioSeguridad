package ec.edu.epn.convenios.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.convenios.entities.Convenio;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ConvenioDAO extends DaoGenerico<Convenio>{

	List<Convenio> consultaconvenioFechas(Date fechaDesde, Date fechaHasta, int idorg);

	List<Convenio> consultaconveniobyparams(String codigo, String titulo, String Objeto, int idAplicacion,
			int idAutoridad, String estado, String vigencia, int idDepartamento, String localidad, int idtipo,
			Date fechaDesde, Date fechaHasta, int idorganizacion, String tesis, String pasantias, String investigacion,
			String sprofesionales, String varios, String tipo);

	List<Convenio> consultaconvenioFechas1(Date fechaDesde, Date fechaHasta);

	List<Convenio> consultaconvenioAntesde(Date fecha);

}
