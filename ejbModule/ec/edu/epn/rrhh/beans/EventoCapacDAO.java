package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Eventocapac;

@Local
public interface EventoCapacDAO extends DaoGenerico<Eventocapac> {
	
	int consultarId();
	
	public List<Eventocapac> listaCapacitacionXCedula(String cedula);

}
