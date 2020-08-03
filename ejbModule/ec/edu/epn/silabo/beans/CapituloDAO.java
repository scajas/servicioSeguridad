package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.Capitulo;

@Local
public interface CapituloDAO  extends DaoGenerico<Capitulo>{

	List<Capitulo> consultarCapitulos(Integer idsilado);

	int maxIdCapitulo();

	List<Capitulo> consultarCapitulosExiste(Integer idsilado, Integer num);

}
