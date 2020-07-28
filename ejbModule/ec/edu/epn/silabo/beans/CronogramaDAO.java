package ec.edu.epn.silabo.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;



import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.CronogramaDesarrollo;
import ec.edu.epn.silabo.entities.Silabo;

@Local
public interface CronogramaDAO extends DaoGenerico<CronogramaDesarrollo> {

	List<CronogramaDesarrollo> consultarCronograma(Integer idsilado);

	int maxIdActividades();

	int maxNumCrono(Silabo silabo);

	List<CronogramaDesarrollo> consultarCronogramaExiste(Integer idsilado, Date fecha);

	CronogramaDesarrollo consultarCronogramaById(Integer idcrono);

	int maxNumCronoIndice(Silabo silabo);

	List<CronogramaDesarrollo> consultarCronogramaUpdate(Integer idsilado);

	int maxNumCronoIndiceID(Integer idsilado);

	List<CronogramaDesarrollo> consultarCronogramaExisteHorarios(Integer idsilado, Date fecha, String hora1,
			String hora2);
	
	
	

}
