package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.ResultadosPea;

@Local
public interface ResultadoPeaDAO extends DaoGenerico<ResultadosPea> {

	List<ResultadosPea> consultarResultados(Integer idPea);

}
