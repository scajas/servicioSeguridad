package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.acreditacion.DTO.EvidenciaDetalleDTO;
import ec.edu.epn.acreditacion.entities.EvidenciaDetalle;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface EvidenciaDetalleDAO extends DaoGenerico<EvidenciaDetalle>{

	EvidenciaDetalle findEvidenciaBYCarrea(String cod_carrera, Integer idmodelo);

	int maxEvidencia();

	List<EvidenciaDetalle> findAllEvidenciaBYCarrea(String cod_carrera, Integer idmodelo);

	Long countEvidDetXPensumXCarrera(String idCarrera, Integer idPensum, Integer idEvidencia);

	List<EvidenciaDetalleDTO> listEvDetalleXPensumXCarrera(String codIndicador, Integer idPensum, String codCarrera);

}
