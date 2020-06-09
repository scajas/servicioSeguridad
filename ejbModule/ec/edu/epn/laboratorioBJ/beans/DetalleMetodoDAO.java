package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Detallemetodo;
import ec.edu.epn.laboratorioBJ.entities.Existencia;
import ec.edu.epn.laboratorioBJ.entities.UnidadLabo;

@Local
public interface DetalleMetodoDAO extends DaoGenerico<Detallemetodo> {

	List<Existencia> listaExistencias(int id);

	Existencia buscarExistencias(String id);

	List<Detallemetodo> listaDetallesById(String id);


}
