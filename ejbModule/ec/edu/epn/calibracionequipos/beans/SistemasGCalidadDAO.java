package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Sistemasgestioncalidad;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface SistemasGCalidadDAO extends DaoGenerico<Sistemasgestioncalidad> {
	int consultarId();

}
