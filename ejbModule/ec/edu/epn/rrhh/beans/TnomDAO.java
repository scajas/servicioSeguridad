package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Tnomb;

@Local
public interface TnomDAO extends DaoGenerico<Tnomb>{

	Tnomb findTnomByID(String tnom);

	List<Tnomb> findTiposNombramiento();
	

}
