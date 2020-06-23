package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Detallemetodo;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Servicio;
import ec.edu.epn.laboratorioBJ.entities.TipoJustificacion;

@Local
public interface DetalleOrdenDAO extends DaoGenerico<Detalleorden> {

	Metodo findMetodoById(String id);

	Servicio findServicioById(String id);

	List<Detalleorden> listTAbyId(String id);

	List<Detalleorden> listarDetalleOrdenByUsuario(int id, String idUnidad);

	List<Detallemetodo> listarDetalleMetodoById(String id);

	List<TipoJustificacion> listarTipoJustificacion();

	TipoJustificacion findTipoJustificacionById(String id);

	List<Detalleorden> listarDetalleOrdenByUsuarioNoActivo(int id, String idUnidad);

}
