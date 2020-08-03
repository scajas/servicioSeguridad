package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.TituloFormacionAcademica;

@Local
public interface TitulosFormacionAcademicaDAO extends DaoGenerico<TituloFormacionAcademica> {

	List<TituloFormacionAcademica> buscarTutlosRegSDenescytRevalorizarec(String cedula, String regSenescyt,
			String validarecategoriza, String validarevaloriza, String nombre, boolean ordenAño) throws Exception;

	int countTituloFormAcadXNombre(String cedula, String nombreTitulo, TituloFormacionAcademica titulo)
			throws Exception;

	List<TituloFormacionAcademica> finsAllTitulos() throws Exception;

	TituloFormacionAcademica buscarTulosporID(String id) throws Exception;
	
	List<String> obtenercedulasparaactualizar() throws Exception;
	List<TituloFormacionAcademica> titulosxcedula(String nced) throws Exception;

}
