package ec.edu.epn.gestioDocente.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.DescansoObligatorio;

@Local
public interface DescansoObligatorioDAO extends DaoGenerico<DescansoObligatorio>{

	int diasDescansoObligatorio(Date fechaIncio, Date fechaFin);

	List<DescansoObligatorio> listDescansoObligatorio(Date fechaIncio, Date fechaFin);

	
}
