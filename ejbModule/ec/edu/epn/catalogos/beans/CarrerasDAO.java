package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.Carrera;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface CarrerasDAO extends DaoGenerico<Carrera> {
	int consultarId();

	Carrera buscarCarreraBYID(String codCarre) throws Exception;

	List<Carrera> listCarreraUsuario(Integer idUsuario) throws Exception;

}
