package ec.edu.epn.contratos.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.DTO.PedidosContratosDTO;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface PedidoDAO extends DaoGenerico<Pedido> {

	int consultarId();

	Pedido buscarXCedula(String nced);

	List<Pedido> buscarListaXCedula(String cedula);

	List<Pedido> listapedidosNOaceptados();

	List<Pedido> listapedidosRegistradosContratoXParametros(String cedula, String nombres, Pensum pensum);

	List<Pedido> buscarPedidosXRevisarTitulos();

	List<Pedido> listapedidosRegistrados(String idfcult);

	List<Pedido> listapedidosXRegistrar(String idfcult);

	List<Pedido> listapedidosXRegistrarCedula(String idfcult, String nced);

	List<Pedido> listaPedidoReporte(String relacion, String doc, Date fechaI, Date fechaF, int estado,
			String tipoContrato, String nivel);

	List<Pedido> listapedidosRegistradosXParametros(String cedula, String nombres, Pensum pensum, String idfacultad);

	List<Pedido> listapedidosNOaceptadosXParametros(String cedula, String nombres, Pensum pensum, String idfacultad);

	List<Pedido> listapedidosRegistradosContrato();

	List<PedidosContratosDTO> buscarPedidosContratos(Integer idTipoContrato, Integer idPensum, Integer idEstadoPedido,
			String idFacultad, String relacionActual) throws Exception;

	List<Pedido> listapedidosNOaceptadosrob(String idfacul);

	List<Pedido> listapedidosXRegistrarPensumVigente(String idfacutlad, Integer idPensum, String nced) throws Exception;

	Long contPedidosXPensum(String nced, Integer idPensum) throws Exception;

	List<Pedido> listaPedidoAdendas(String idFacultad, int idPensum, String nombres, String cedula);

	List<Pedido> listaPedidoAdendasSinRegistrar(String idFacultad, int idPensum, String nombres, String cedula);

	List<Pedido> buscarListaXCedulaAyudante(String cedula, Integer idPedido) throws Exception;

	List<Pedido> findPedidoAyudantesXRegistrar(String idFacultad,String cedula, String nombres);

	List<Pedido> findPedidoAyudantesXRegistrarXParametros(String cedula, String nombres);

	List<Pedido> findPedidosSolicitadosXParametros(String cedula, String nombre, Pensum pensum);

	List<Pedido> findPedidosAutorizadosXParametros(String cedula, String nombre, Pensum pensum);

	List<Pedido> findPedidosVerificadosXParametros(String cedula, String nombre, Pensum pensum);

	List<Pedido> findPedidosAsigPartidaXParametros(String cedula, String nombres, Pensum pensum);

	List<Pedido> findPedidosByParam(String nombreDocente, String nced, int idEstado, Date fechaDesde, Date fechaHasta,
			String id_facultad, String pedfilDecano, Pensum p, String tipoPedido);

}
