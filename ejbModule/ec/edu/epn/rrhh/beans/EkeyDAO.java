package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Ekey;

@Local
public interface EkeyDAO extends DaoGenerico<Ekey>{

	List<Ekey> findekeyByCodigo(String codigo);

	String consultarcoordenada(String letra, Integer numero);

}
