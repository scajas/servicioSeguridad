package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Bodega;
import ec.edu.epn.seguridad.vo.Perfil;

@Local
public interface BodegaDAO extends DaoGenerico<Bodega>{

	List<Bodega> listaBodegaUnidad(int id);

	

}
