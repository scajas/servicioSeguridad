package ec.edu.epn.deportivo.beans;

import javax.ejb.Local;

import ec.edu.epn.deportivo.entities.Deporte;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface DeporteDAO extends DaoGenerico<Deporte> {

}
