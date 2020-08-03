package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Pais;

@Remote
public interface PaisDAO extends DaoGenerico<Pais>{

	List<Pais> findAllPaises() throws Exception;

	Pais findAllPaisesByNombre(String nombrePais) throws Exception;

}