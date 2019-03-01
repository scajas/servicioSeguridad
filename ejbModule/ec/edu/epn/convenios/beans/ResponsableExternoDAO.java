package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.convenios.entities.ResponsableExt;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ResponsableExternoDAO extends DaoGenerico<ResponsableExt>{

	ResponsableExt findrespExternosSolo(int serial);

	List<ResponsableExt> findRespExte(String nombre, String cargo, String titulo);

}
