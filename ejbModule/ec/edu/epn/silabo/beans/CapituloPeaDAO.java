package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.Capitulo;
import ec.edu.epn.silabo.entities.CapituloPea;

@Local
public interface CapituloPeaDAO extends DaoGenerico<CapituloPea> {

	List<CapituloPea> consultarCapitulos(Integer idpea);

	List<CapituloPea> consultarCapitulosExiste(Integer idpea, Integer num);

}
