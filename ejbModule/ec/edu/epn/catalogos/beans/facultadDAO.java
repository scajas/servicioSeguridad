package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.FacultadCatalogos;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface facultadDAO extends DaoGenerico<FacultadCatalogos> {

	FacultadCatalogos buscaFacuXID(String id);

	List<FacultadCatalogos> listaFacultades();

	public String buscaNombreFacuXID(String id) throws Exception;

}
