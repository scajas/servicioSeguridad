package ec.edu.epn.laboratorioBJ.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Cliente;
import ec.edu.epn.laboratorioBJ.entities.Detalleorden;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Muestra;
import ec.edu.epn.laboratorioBJ.entities.OrdenTrabajo;
import ec.edu.epn.laboratorioBJ.entities.PersonalLab;
import ec.edu.epn.laboratorioBJ.entities.Servicio;

@Local
public interface OrdenTrabajoDAO extends DaoGenerico<OrdenTrabajo> {

	List<Detalleorden> filtrarLista(String fechaInicio, String fechaFin, String tipo, String estado, String laboratorio,String personal);

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
	
	
}
