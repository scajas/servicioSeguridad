package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Objetivoavance;

@Local
public interface ObjetivoAvanceDAO extends DaoGenerico<Objetivoavance> {

	List<Objetivoavance> findAvanceByObjetivo(Integer idobjetivo, String tipo);

	List<Objetivoavance> findAvanceByObjetivoExiste(Integer idobjetivo, Integer idpensum, String tipo);

	List<Objetivoavance> findAvanceByObjetivoProyecto(Integer idobjetivo, String tipo, Integer idpensum);

	Double consultarMaximoReportado(Integer idproyecto, String tipo);

	Objetivoavance findAvanceByObjetivoProyectoAnterior(Integer idobjetivo, String tipo, Integer idpensum);

	boolean deleteObjJDBC(Objetivoavance tfa);

	Long countObjtvAvanceXidObjProy(Integer idObjetivoProyecto);

}
