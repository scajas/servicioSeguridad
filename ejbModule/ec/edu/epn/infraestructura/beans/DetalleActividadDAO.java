package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.Detalle_Actividad_Evento;
import ec.edu.epn.infraestructura.entities.Evento;

@Local
public interface DetalleActividadDAO extends
		DaoGenerico<Detalle_Actividad_Evento> {
	public int maxDetalleActividad();

	List<Detalle_Actividad_Evento> buscarDetalleXEvento(Evento evento);

}
