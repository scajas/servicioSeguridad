package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.CronogramaDesarrolloTemp;
import ec.edu.epn.silabo.entities.Silabo;

@Local
public interface CronogramaDesarrolloTempDAO extends DaoGenerico<CronogramaDesarrolloTemp>{

	int maxIdActividades();

	int maxNumCronoIndice(Silabo silabo);

	int maxNumCrono(Silabo silabo);

	List<CronogramaDesarrolloTemp> consultarCronograma(Integer idsilado);

	CronogramaDesarrolloTemp consultarCronogramaUpdate(Integer idsilado, Integer indice);

	List<CronogramaDesarrolloTemp> consultarCronogramaVacios();

}
