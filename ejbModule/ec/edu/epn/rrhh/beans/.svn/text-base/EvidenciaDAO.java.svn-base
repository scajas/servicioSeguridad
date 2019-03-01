package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Evidencia;

@Local
public interface EvidenciaDAO extends DaoGenerico<Evidencia>{

	Evidencia findEvidenciaBYCarrea(String cod_carrera, Integer idmodelo);

	int maxEvidencia();

	List<Evidencia> findAllEvidenciaBYCarrea(String cod_carrera, Integer idmodelo);

}
