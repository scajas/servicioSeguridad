package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Tesissaew;

@Local
public interface TesisSaewDAO extends DaoGenerico<Tesissaew>{

	List<Tesissaew> buscarTesisSaew(String cedula, String categoria, String proceso, Integer tesis) throws Exception;

}
