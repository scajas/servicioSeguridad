package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface PensumDAO extends DaoGenerico<Pensum> {
	int consultarId();

	Pensum obtenerPensumVigente();
	Pensum obtenerPensumXAnterior(int idPensumAnterior);

	List<Pensum> listaPensumOrdenAsc();

	List<Pensum> listaPensum(String orden);

	Pensum obtenerPensumById(Integer idpensum);

	List<Pensum> listaPensumXFechaActual(String tipoEvaluacion);

	List<Pensum> listaPensumVIPS(String orden);

	Pensum obtenerPensumSilaboTemporalRG(String estado);
	
	List<Pensum> listaPensumXFechaActualInvestigacion(String tipoInforme);

}
