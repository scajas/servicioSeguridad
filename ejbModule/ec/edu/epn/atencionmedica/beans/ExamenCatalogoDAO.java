package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.ExamenCatalogo;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ExamenCatalogoDAO extends DaoGenerico<ExamenCatalogo> {

	List<ExamenCatalogo> listCatalogoExamenes(String examenes);
	

	
	
}
