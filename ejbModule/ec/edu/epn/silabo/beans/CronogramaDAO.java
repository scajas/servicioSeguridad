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
	
	
	

}
