package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.IdiomasDocente;

@Local
public interface IdiomaDocenteDAO extends DaoGenerico<IdiomasDocente>{

	List<IdiomasDocente> buscarIdiomasDocente(String cedula, String nombre);

	int countIdiomaXIdIdiomaCat(String cedula, String idIdiomaCat, IdiomasDocente idiomasDocente) throws Exception;

	int countIdiomaXCedula(String cedula, String idIdiomaCat) throws Exception;

}
