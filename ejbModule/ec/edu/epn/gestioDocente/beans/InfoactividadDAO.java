package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Infoactividad;

@Local
public interface InfoactividadDAO extends DaoGenerico<Infoactividad> {

	List<Infoactividad> consultarinformes(String cedula, String proceso, String categoria, Integer idrecategorizacion);

	int maxInfor();

}
