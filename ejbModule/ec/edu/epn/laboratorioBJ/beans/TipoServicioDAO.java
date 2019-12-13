package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Tiposervicio;

@Local
public interface TipoServicioDAO extends DaoGenerico<Tiposervicio>{

	List<Tiposervicio> getListTS();

}
