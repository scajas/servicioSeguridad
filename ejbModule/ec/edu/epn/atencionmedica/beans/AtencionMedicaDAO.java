package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.entities.Atencionmedica;
import ec.edu.epn.atencionmedica.entities.Movimientoinventario;

@Local
public interface AtencionMedicaDAO {

	public boolean guardarAtencion(Atencionmedica atencionmedica);
	public List<Atencionmedica> obtenerListaAtenciones(String criterio);
	
	/**
	 * Este m�todo sirve para obtener la informaci�n completa de una atenci�n m�dica realizada 
	 * la b�squeda se puede realizar de dos maneras: por idAtencionMedica o por atributos relevantes
	 * 
	 * POR ID:
	 * arroja la informaci�n completa de la atencion medica.
	 * 
	 * POR ATRIBUTOS:
	 * Indicando los par�metros m�s relevantes de la atenci�n: idTipoAtencion, idMedico, idPaciente, idTopografia
	 * se obtiene la atenci�n medica deseada para continuar con otras operaciones
	 * y as� evitar el cruce de informaci�n en sesiones simultaneas al guardar los movimientos de inventario. 
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
		
}
