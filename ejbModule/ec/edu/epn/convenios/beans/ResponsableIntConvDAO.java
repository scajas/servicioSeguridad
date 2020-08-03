package ec.edu.epn.convenios.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.convenios.entities.ResponsableIntConv;
import ec.edu.epn.convenios.entities.ResponsablesInt;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ResponsableIntConvDAO extends DaoGenerico<ResponsableIntConv>{

	List<ResponsableIntConv> findrespIntRoberto(String idconv);

	ResponsablesInt findrespinternoSolo(int serial);

	List<ResponsablesInt> findrespInternoSelectExiet(String nced);

	ResponsableIntConv findrespintRobertoElimina(String idconv, Integer idresp);

}
