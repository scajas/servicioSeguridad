package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.ActividadDocencia;
import ec.edu.epn.gestionDocente.entities.Carre;

@Local
public interface CarreDAO extends DaoGenerico<Carre> {

	List<Carre> buscarCarreraBYNivel(String nivel) throws Exception;

	Carre buscarCarreraBYID(String codCarre) throws Exception;

	

}
