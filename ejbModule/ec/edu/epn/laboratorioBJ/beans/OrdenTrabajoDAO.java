package ec.edu.epn.laboratorioBJ.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import ec.edu.epn.facturacion.entities.EstadoFactura;
import ec.edu.epn.facturacion.entities.Factura;
import ec.edu.epn.facturacion.entities.TransferenciaInterna;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Cliente;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Muestra;
import ec.edu.epn.laboratorioBJ.entities.OrdenTrabajo;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;
import ec.edu.epn.laboratorioBJ.entities.Proforma;
import ec.edu.epn.laboratorioBJ.entities.Servicio;

@Local
public interface OrdenTrabajoDAO extends DaoGenerico<OrdenTrabajo> {

	List<Detalleorden> filtrarLista(String fechaInicio, String fechaFin, String tipoOrden, String analista,
			String estado);

	List<PersonalLab> listaPersonalAnalista();

	List<LaboratorioLab> listaLaboratorioUnidad(int id);

	List<OrdenTrabajo> listarOTInternaByUnidadLab(String id, int idUser, OrdenTrabajo ordenTrabajo, Date fechaInicio,
			Date fechaFin);

	List<Detalleorden> listarDetalleOrdenById(String id);

	List<Servicio> listarServiciosByLab(String id);

	List<Metodo> listarMetodosByIdServicio(String id);

	String maxIdOTInterno(String id, String fecha);

	OrdenTrabajo buscarOTById(String id);

	LaboratorioLab obtenerLaboratorioByUsr(int id, int uni);

	Metodo findMetodoById(String id);

	List<Cliente> listarClienteBY(Cliente cliente);

	Muestra muestraDefault();

	List<Servicio> listarServiciosByLabType(int idUni, int idTipo);

	List<OrdenTrabajo> listarOTFacturaByUnidadLab(String id, int idUser, OrdenTrabajo ordenTrabajo, Date fechaInicio,
			Date fechaFin);

	List<Factura> listarFacturasPagadas(int idUni, int idUsuario);

	Cliente buscarClienteById(String id);

	Long getTotalRegistros();

	List<Factura> listarFacturasPagadas(int first, int pageSize, String sortField, boolean asc, int idUnidad,
			int idUsuario);

	List<Factura> listarFacturasPagadasFiltro(int first, int pageSize, String sortField, Map<String, Object> filters,
			boolean asc, int idUnidad, int idUsuario);

	int countFacturas(Map<String, Object> filters);

	List<Muestra> listarMuestraByFactura(String idFactura);

	EstadoFactura buscarEstadoFById(String id);

	List<Servicio> listarServiciosByPro(String idProforma);

	String maxIdOT(String id, String fecha);

	Factura buscarFacturaById(String id);

	List<OrdenTrabajo> listarOTTransByUnidadLab(String id, int idUser, OrdenTrabajo ordenTrabajo, Date fechaInicio,
			Date fechaFin);

	List<TransferenciaInterna> listarTransferenciasInternas();

	List<Muestra> listarMuestraByTI(String idTI);

	Proforma buscarProformaById(String id);

	String maxIdOTT(String id, String fecha);

	TransferenciaInterna buscarTransferenciaById(String id);

}
