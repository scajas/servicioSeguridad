package ec.edu.epn.laboratorioBJ.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Cliente;
import ec.edu.epn.laboratorioBJ.entities.DetalleProforma;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Metodo;
import ec.edu.epn.laboratorioBJ.entities.Proforma;
import ec.edu.epn.laboratorioBJ.entities.Servicio;

@Local
public interface ProformaDAO extends DaoGenerico<Proforma> {

	List<Proforma> getparametrosCliente(String fechaInicio, String fechaFin, Integer tipoCliente, String estadoPro);
	List<Proforma> listaProformaByUnidadLab(String id, int idUser, Proforma proforma, Date fechaInicio, Date fechaFin );
	List<Cliente> listarClienteBY(Cliente cliente);
	List<Servicio> listarServiciosByLab(String id);
	List<Metodo> listarMetodosByIdServicio(String id);
	String maxIdProforma(String id, String fecha);
	List<DetalleProforma> listarDetalleProByIdPro(String id);
	Proforma buscarProformaById(String id);
	LaboratorioLab obtenerLaboratorioByUsr(int id,int uni);
	Metodo findMetodoById(String id);
	List<Proforma> listaAllProformas(String id, int idUser, Proforma proforma, Date fechaInicio, Date fechaFin);

}
