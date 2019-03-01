package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.convenios.entities.ActividadeConvenio;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ActividadConvDAO extends DaoGenerico<ActividadeConvenio>{

	List<ActividadeConvenio> findact(int serial);

}
