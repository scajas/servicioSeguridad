package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.acreditacion.entities.Evidencia;
import ec.edu.epn.acreditacion.entities.EvidenciaDetalle;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface EvidenciaADAO extends DaoGenerico<Evidencia>{

	List<Evidencia> buscarpreguntasEvidencias(Integer idPerfilencargado, Integer idPerfilvalida,
			Integer idPerfilvarifica) throws Exception;

	List<EvidenciaDetalle> buscarpreguntasEvidenciasValidadas(String path, String valida, String verifica,
			String enviadaA, Integer idPerfilencargado, Integer idPerfilvalida, Integer idPerfilvarifica,
			String codcarre, Integer idmodelo) throws Exception;
	

	List<Evidencia> listEvidenciasXSubCriterio(Integer idSubCriterio, String conIndicador) throws Exception;

}
