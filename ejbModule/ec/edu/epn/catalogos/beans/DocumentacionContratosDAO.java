package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.DocumentacionContratacionDocente;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface DocumentacionContratosDAO extends
		DaoGenerico<DocumentacionContratacionDocente> {

	List<DocumentacionContratacionDocente> listaDocumentosXTipo(String idTipoDoc);
}
