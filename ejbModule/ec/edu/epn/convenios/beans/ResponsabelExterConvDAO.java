package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.convenios.entities.ResponsableExtConv;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ResponsabelExterConvDAO extends DaoGenerico<ResponsableExtConv>{

	List<ResponsableExtConv> findrespExtRobertoSigna(String idconv, Integer signa);

	ResponsableExtConv findrespExtRobertoElimina(String idconv, Integer idresp, Integer signa);

}
