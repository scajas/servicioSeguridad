package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Ecivil;



@Local
public interface EcivilDAO extends DaoGenerico<Ecivil> {

	List<Ecivil> findestadoCivil();

}
