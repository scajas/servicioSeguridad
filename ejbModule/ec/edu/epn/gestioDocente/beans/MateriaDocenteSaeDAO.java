package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.MateriaDocenteSae;


@Local
public interface MateriaDocenteSaeDAO extends DaoGenerico<MateriaDocenteSae> {

	List<MateriaDocenteSae> listMateriaDoc(String nced) throws Exception;

	

	
	
}
