package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Catalogo;
import ec.edu.epn.atencionmedica.entities.Catalogotipo;

@Local
public interface CatalogoDAO {

	public Catalogo obtenerCatalogo(String criterio);
	public List<Catalogo> obtenerListaTipoMovimientoInventario();
	public List<Catalogo> obtenerListaTipoInsumoMedico();
	public List<Catalogo> obtenerListaTipoPaciente();
	public List<Catalogo> obtenerListaTipoAtencionMedica();
	public List<Catalogo> obtenerListaTipoEspecialidad();
	public List<Catalogo> obtenerListaTipoMovimientoInventarioDespacho();
	public List<Catalogo> obtenerListaTipoEstadoMovimientoInventario();
	public List<Catalogo> obtenerListaTipoDisponibilidadPersonal();
	public List<Catalogo> obtenerListaTipoPersonalMedico();
	public List<Catalogo> obtenerListaTipoProcedimientos();

	/*Tipo de Insumos Médicos  */
	public boolean guardarTipoInsumoM(Catalogo catalog, String operacion);
	public Catalogotipo  obtenerCatalogoTipo(String criterio);
	public boolean eliminarTipoInsumoM(Catalogo catalog, String operacion);
	public List<Catalogo> obtenerListaTipoInsumoMed(String criterio);
	public boolean ActivarDesactivarTipoInsumoM(Catalogo catalog, String operacion);
	
	
	/*Tipo Presentacion de Insumos Médicos  */
	public List<Catalogo> obtenerListaTipoPresentacionIM(String criterio);
	public boolean guardarTipoPresentacionIM(Catalogo catalog, String operacion);
	public boolean eliminarTipoPresentacionIM(Catalogo catalog, String operacion);
	public List<Catalogo> obtenerListaTipoPresentacionInsumoMedico();
	List<Catalogo> obtenerListaTipoAtencionMedicaNuevo();
}
