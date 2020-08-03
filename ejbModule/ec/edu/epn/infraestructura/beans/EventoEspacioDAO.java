package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.Espacio;
import ec.edu.epn.infraestructura.entities.EstadoEvento;
import ec.edu.epn.infraestructura.entities.Evento;
import ec.edu.epn.infraestructura.entities.EventoEspacio;
import ec.edu.epn.infraestructura.entities.ResponsableInfra;
import ec.edu.epn.infraestructura.entities.TipoEvento;

@Local
public interface EventoEspacioDAO extends DaoGenerico<EventoEspacio> {
	public int consultarId();

	EventoEspacio buscarXIDS(Evento ev, Espacio esp);

	List<EventoEspacio> buscarXIDEVENTO(Evento ev);

	List<EventoEspacio> buscarxparametros(Evento evento,
			ResponsableInfra responsable, EstadoEvento estadoEvento,
			TipoEvento tipoEvento);

	List<EventoEspacio> buscarxidEspacio(Espacio esp);

}
