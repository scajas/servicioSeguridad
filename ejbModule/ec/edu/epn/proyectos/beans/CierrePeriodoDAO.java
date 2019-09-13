package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.CierrePeriodo;

@Local
public interface CierrePeriodoDAO extends DaoGenerico<CierrePeriodo> {

	List<CierrePeriodo> consultarCierreProyecto(Integer idproy, Integer idpensun, String tipo);

	CierrePeriodo consultarCierreProyectoPensum(Integer idproy, Integer idpensun, String tipo, String cerrado);

	List<CierrePeriodo> consultarCierreProyectoDept(String estado, String dep);

	List<CierrePeriodo> consultarCierres();

	CierrePeriodo consultarCierreProyectoPensumIngresadas(Integer idproy, Integer idpensun, String tipo,
			String cerrado);

	List<CierrePeriodo> consultarCierresVIPS(Integer idtipo);

	List<CierrePeriodo> consultarCierreProyectoDeptEstados(String coddep);

	List<CierrePeriodo> consultarCierresReporte();

	List<CierrePeriodo> consultarCierreRevisados(String revisado);

	Double consultarMaxReporte(Integer id_proy, String tipo);

}
