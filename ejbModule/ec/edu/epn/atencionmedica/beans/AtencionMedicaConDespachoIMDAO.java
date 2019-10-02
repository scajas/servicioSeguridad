package ec.edu.epn.atencionmedica.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Atencionmedica;
import ec.edu.epn.atencionmedica.entities.Movimientoinventario;

@Local
public interface AtencionMedicaConDespachoIMDAO {
	
	public boolean guardarAtencionMedicaConMovimientosInventario(Atencionmedica atencion);

	public List<Movimientoinventario> obtenerListaDespachosPendientes();
	
	public boolean guardarAtencionMedicaConMovimientosInventarioLista(List<Movimientoinventario> listMovimentosInventario, Atencionmedica atencion);

	List<Movimientoinventario> obtenerListaDespachosEjecutados(Integer idMedico, Date fechaDesde, Date fechaHasta)
			throws Exception;

	List<Movimientoinventario> obtenerListaDespachosPendientesXFecha(Date fechaInicio, Date fechaFinal);

}
