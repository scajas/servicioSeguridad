package ec.edu.epn.proyectos.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.proyectos.entities.Hss;

@Local
public interface HSSDAO extends DaoGenerico<Hss>{

	Hss findHSSBy(Integer idtipo, Integer idrol,Integer anio);

}
