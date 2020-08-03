package ec.edu.epn.rrhh.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Instruccion;
import ec.edu.epn.rrhh.entities.Partind;

@Local
public interface InstruccionDAO extends DaoGenerico<Instruccion> {

}
