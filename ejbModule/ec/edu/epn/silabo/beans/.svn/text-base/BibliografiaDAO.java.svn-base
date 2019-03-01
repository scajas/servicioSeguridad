package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.Bibliografia;

@Local
public interface BibliografiaDAO extends DaoGenerico<Bibliografia>{

	List<Bibliografia> consultarBilbiografia(Integer idsilado, String tipo);

	int maxIdBibliografia();

	List<Bibliografia> consultarBilbiografiaExiste(Integer idsilado, String tipo, String titulo);

}
