package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.TesisCalificada;

@Local
public interface TesisCalificadaDAO extends DaoGenerico<TesisCalificada>{

	List<TesisCalificada> buscarTesisCalificadaBYParams(String cedula, String nombre) throws Exception;

	int countTesisCalificadasXPeriodo(String idPeriodo, String nombreTesis, TesisCalificada tesisCalificada)
			throws Exception;

}
