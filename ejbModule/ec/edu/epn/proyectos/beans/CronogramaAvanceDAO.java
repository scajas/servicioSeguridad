package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Cronogramaavance;

@Local
public interface CronogramaAvanceDAO extends DaoGenerico<Cronogramaavance> {

	List<Cronogramaavance> findAvanceByCronograma(Integer idcronograma, String tipo);

	List<Cronogramaavance> findAvanceByCronogramaExiste(Integer idcronograma, String tipo, Integer idpensum);

	List<Cronogramaavance> findAvanceByCronogramaReporte(Integer idcronograma, String tipo, Integer idpensum);

	Long countCronoAvanceXidObjProy(Integer idCronograma);

}
