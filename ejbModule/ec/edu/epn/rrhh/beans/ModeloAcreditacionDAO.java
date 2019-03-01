package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Evidencia;
import ec.edu.epn.rrhh.entities.ModeloAcreditacion;

@Local
public interface ModeloAcreditacionDAO extends DaoGenerico<ModeloAcreditacion> {

	List<ModeloAcreditacion> buscarpreguntasEvidencias(Integer idPerfilencargado, Integer idPerfilvalida,
			Integer idPerfilvarifica) throws Exception;

	List<Evidencia> buscarpreguntasEvidenciasValidadas(String path, String valida, String verifica,
			String enviadaA, Integer idPerfilencargado, Integer idPerfilvalida, Integer idPerfilvarifica,String codcarre, Integer idmodelo)
			throws Exception;

}
