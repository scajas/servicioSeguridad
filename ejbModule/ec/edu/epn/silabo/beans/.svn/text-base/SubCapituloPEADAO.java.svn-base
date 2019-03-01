package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.SubcapituloPea;

@Local
public interface SubCapituloPEADAO extends DaoGenerico<SubcapituloPea>{

	List<SubcapituloPea> consultarSubCapitulosExiste(Integer idpea, String num, Integer idcapitulo);

	List<SubcapituloPea> consultarSubcapitlosdeCapítulo(Integer idcapitulo);

	void eliminar(Integer idsubcapitulo);

}
