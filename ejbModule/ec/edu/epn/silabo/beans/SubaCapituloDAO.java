package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.Subcapitulo;

@Local
public interface SubaCapituloDAO extends DaoGenerico<Subcapitulo>{

	int maxIdSubCapitulo();

	List<Subcapitulo> consultarSubCapitulos(Integer idsilado);

	Subcapitulo consultarIdSubcapitulo(Integer idsubcapitulo);

	List<Subcapitulo> consultarSubCapitulosExiste(Integer idsilado, String num, Integer idcapitulo);

	List<Subcapitulo> consultarSubcapitlosdeCapitulo(Integer idcapitulo);

	void eliminar(Integer idsubcapitulo);

}
