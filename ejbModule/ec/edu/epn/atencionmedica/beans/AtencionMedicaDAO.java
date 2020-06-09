package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Atencionmedica;

@Local
public interface AtencionMedicaDAO {

	public boolean guardarAtencion(Atencionmedica atencionmedica);
	public List<Atencionmedica> obtenerListaAtenciones(String criterio);
	
	/**
	 * Este metodo sirve para obtener la informacion completa de una atencion medica realizada 
	 * la busqueda se puede realizar de dos maneras: por idAtencionMedica o por atributos relevantes
	 * 
	 * POR ID:
	 * arroja la informacion completa de la atencion medica.
	 * 
	 * POR ATRIBUTOS:
	 * Indicando los parametros mas relevantes de la atencion: idTipoAtencion, idMedico, idPaciente, idTopografia
	 * se obtiene la atencion medica deseada para continuar con otras operaciones
	 * y asi evitar el cruce de informacion en sesiones simultaneas al guardar los movimientos de inventario. 
	 * Este mismo recurso se aplica al guardar los Detalles de movimiento de inventario.
	 * 
	 * @param atencion
	 * @return Atenicionmedica
	 */
	public Atencionmedica obtenerAtencionMedica(Atencionmedica atencion);
	
	public Integer countMovientos(Integer idAtencion) throws Exception;
		
	public Atencionmedica obtenerAtencionMedicaPorPaciente(Integer idAtencion, Integer idPaciente);
	
	public Atencionmedica obtenerUltimaAtencionMedicaPorPaciente(Integer idPaciente);
	
	public List<Atencionmedica> obtenerListaProcedimientos(String criterio);
	Atencionmedica obtenerAtencionMedicaPaciente(Integer idPaciente);
	List<Atencionmedica> obtenerListaAtencionesXMovimientos(String criterio);
		
}
