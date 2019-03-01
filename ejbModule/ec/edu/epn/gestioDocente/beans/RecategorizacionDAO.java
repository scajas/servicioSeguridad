package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.CategoriasD;
import ec.edu.epn.gestionDocente.entities.Recategorizacion;

@Local
public interface RecategorizacionDAO extends DaoGenerico<Recategorizacion> {

	CategoriasD buscarCategoriaSELECT(int idcategoria) throws Exception;

	List<Recategorizacion> buscarRecExiste(String nced, String categoria, String proceso, String estado) throws Exception;

	List<CategoriasD> buscarCategorias(Integer serie) throws Exception;

	int maxCodRecategorizacion();

	
	
	

}
