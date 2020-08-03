package ec.edu.epn.desarrollo.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;

import ec.edu.epn.desarrollo.entities.Requerimiento;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.Resultado;

@Local
public interface RequerimientoDAO extends DaoGenerico<Requerimiento> {

	List<Requerimiento> consultarRequerimientobyPro(Integer idProyecto);

	int consultarNumeroSerial(int anio);

	List<Requerimiento> consultarRequerimientobyDes(String nced);

	List<Requerimiento> consultarRequerimientobyDesProy(String nced, Integer idproy);

	List<Requerimiento> consultarRequerimientoReporte(Integer idProyecto, Integer idpersonal,Date fini,Date fhasta, String estado);

	List<Requerimiento> consultarRequerimientobyEstado(String estado);
	
	

}
