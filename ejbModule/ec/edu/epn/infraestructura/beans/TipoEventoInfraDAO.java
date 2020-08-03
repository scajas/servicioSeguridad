package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.TipoEvento;
@Local
public interface TipoEventoInfraDAO extends DaoGenerico<TipoEvento>{

	int consultarId();

	List<TipoEvento> listarTipoEventor();

	List<TipoEvento> buscarTEvento(int tevento);

	List<TipoEvento> buscarTEventoXNombre(String tevento);
}
