package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.DocumentacionContratacionDocente;
import ec.edu.epn.contratos.entities.GestionDocumentacionSolicitada;
import ec.edu.epn.generic.DAO.DaoGenerico;


@Local
public interface GestionDocumentacionDAO extends DaoGenerico<GestionDocumentacionSolicitada> {

	List<DocumentacionContratacionDocente> listaDocumentacionXRelacionDedicacionrRenovacionNO(int relDependencia, int dedicacion,String renovacion);
	List<DocumentacionContratacionDocente> listaDocXNombresRelacionDedicacionrRenovacionNO(String relDependencia, String dedicacion,String renovacion);
	
	List<GestionDocumentacionSolicitada> listaDocsGestionxParametros(int idRelacion, int idDedicacion,
			String renovacion, int idDocumento);

}
