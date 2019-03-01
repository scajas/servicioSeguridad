package ec.edu.epn.contratos.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.contratos.entities.Actividades;
import ec.edu.epn.contratos.entities.CargaAcademica;
import ec.edu.epn.contratos.entities.Estado;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenerico;


@Remote
public interface PedidosAutorizacionDAO extends DaoGenerico<Pedido>{

	List<Pedido> findPedidosSolicitados();

	List<Pedido> findPedidosSolicitadosXParametros(String nombre,
			String cedula, Pensum pensum);

	List<Pedido> findPedidosAutorizados();
	
	List<Pedido> findPedidosAutorizadosXParametros(String cedula, String nombres, Pensum pensum);

	List<Pedido> findPedidosVerificadosXParametros(String cedula, String nombres,Pensum pensum);

	List<Pedido> findPedidosAsignadosPartidaXParametros(String cedula,
			String nombres, Pensum pensum);

	List<Pedido> findPedidosVerificados();

	List<Pedido> findPedidosAsignadosPartida();

	List<Pedido> findPedidosRevisados();

	void updateEstadoPedido(Pedido pedido);

	List<Actividades> findActividadesByParams(int idPedido);

	List<CargaAcademica> findCargaAcadByParams(int idPedido);

	List<Estado> findEstadoAutorizado();

	List<Estado> findEstadoRevisado();

	List<Estado> findEstadoVerificado();

	List<Estado> findAllEstados();
	
	List<Estado> findAEstadosXId(Integer idEstado) throws Exception;

	List<Estado> findAllEstadosBusquedas();

	List<Pedido> findPedidosByParam(String nombreDocente, String nced,
			int idEstado, Date fechaDesde, Date fechaHasta, String id_facultad,
			String pedfilDecano, Pensum p);
	
	public List<Pedido> findPedidosPeriodoActualXEstado(Integer idEstado) throws Exception;
}
