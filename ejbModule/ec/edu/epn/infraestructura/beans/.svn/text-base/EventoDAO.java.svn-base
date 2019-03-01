/**
 * 
 */
package ec.edu.epn.infraestructura.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.EdificioInfra;
import ec.edu.epn.infraestructura.entities.Espacio;
import ec.edu.epn.infraestructura.entities.EstadoEspacio;
import ec.edu.epn.infraestructura.entities.EstadoEvento;
import ec.edu.epn.infraestructura.entities.Evento;
import ec.edu.epn.infraestructura.entities.EventoEspacio;
import ec.edu.epn.infraestructura.entities.PisoInfra;
import ec.edu.epn.infraestructura.entities.ResponsableInfra;
import ec.edu.epn.infraestructura.entities.TipoEspacio;
import ec.edu.epn.infraestructura.entities.TipoEvento;

/**
 * @author Administrador
 * 
 */
@Local
public interface EventoDAO extends DaoGenerico<Evento> {
	int consultarId();

	List<Evento> buscarxparametros(Evento evento, ResponsableInfra reponsable,
			TipoEvento tipoEvento, EstadoEvento estadoEvento);

	List<Evento> listarEvento();

	List<Evento> listarSoloEventos();

	List<Evento> listarEventoSINAlquiler();

	List<Evento> buscarEvento(int evento);

	List<Evento> buscarEventoXResponsable(String resp);

	List<Evento> buscarEventoXNombre(String evento);

	List<Evento> buscarEventoXTipo(String tipoEvento);

	List<Evento> buscarEventoXEstado(String estado);

	List<Evento> buscarEventoXEstadoNoConfirmado();

	List<Evento> buscarEventoXFechaInicio(Evento ev);

	List<Evento> buscarEventoXFechaFin(Evento ev);

	List<Evento> buscarEventoXFechaReserva(Evento ev);

	List<EventoEspacio> reporteEventoXFechas(Date fechaI, Date fechaF,
			TipoEvento tipoevento, ResponsableInfra responsable);

	boolean buscarEventoXFechas(Evento ev);

	List<Espacio> listaEspacios();

	List<TipoEspacio> listaTipoEspacio();

	List<EstadoEspacio> listaEstadoEspacio();

	List<EdificioInfra> listaEdificio();

	List<PisoInfra> listaPiso();

	Evento buscarEventoXFIFFNombre(Date fechaI, Date fechaF, String nombre);

	// Busqueda de eventos sin alquiler

	List<Evento> buscarEventoXNombreSA(String evento);

	List<Evento> buscarEventoXResponsableSA(String resp);

	List<Evento> buscarEventoXTipoSA(String tipoEvento);

	List<Evento> buscarEventoXEstadoSA(String estado);

	List<Evento> buscarEventoXFechaFinSA(Evento ev);

	List<Evento> buscarEventoXFechaInicioSA(Evento ev);
}
