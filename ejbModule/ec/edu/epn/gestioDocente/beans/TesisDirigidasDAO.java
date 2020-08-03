package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.TesisDirigida;

@Local
public interface TesisDirigidasDAO extends DaoGenerico<TesisDirigida>{

	List<TesisDirigida> buscarTesisDirigidaBYParams(String cedula,String nombre) throws Exception;

	int countTesisDirigidasXPeriodo(String idPeriodo, String nombreTesis, TesisDirigida tesisDirigida) throws Exception;

}
