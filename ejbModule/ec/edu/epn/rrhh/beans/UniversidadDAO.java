package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Universidad;

@Remote
public interface UniversidadDAO extends DaoGenerico<Universidad>{

	List<Universidad> findUniversidadesByPais(String idPais) throws Exception;

}