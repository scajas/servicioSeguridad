package ec.edu.epn.calibracionequipos.beans;

import javax.ejb.Local;

import ec.edu.epn.calibracionequipos.entidades.Cercalacrasignado;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface CertificacionesCalidadDAO extends DaoGenerico<Cercalacrasignado> {
	int consultarId();

}
