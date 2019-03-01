package ec.edu.epn.infraestructura.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.infraestructura.entities.Dias_Reserva;
import ec.edu.epn.infraestructura.entities.Evento;



@Local
public interface DiasReservaDAO extends DaoGenerico<Dias_Reserva> {
	public int maxDiasReserva();

	public List<Dias_Reserva> obtenerListaReservas(int idEspacio,
			Date fechaReservaI, Date fechaReservaF);
	public List<Dias_Reserva> listarDiasReserva(Evento evento);
	public List<Dias_Reserva> listarDiasReservaNoDetallados(Evento evento);
	public List<Dias_Reserva> listarDiasReservaActivos();


	public List<Dias_Reserva> obtenerListaReservasConfirmados();

	public List<Dias_Reserva> obtenerListaXEvento(int idEvento);

	public List<Dias_Reserva> obtenerXparametrosConfirmado(String cedulaResponsable,
			String nomTipoEvento, Date fecha);

}
