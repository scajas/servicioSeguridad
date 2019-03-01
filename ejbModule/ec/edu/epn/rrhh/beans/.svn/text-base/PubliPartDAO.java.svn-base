package ec.edu.epn.rrhh.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.PubliPart;

@Local
public interface PubliPartDAO extends DaoGenerico<PubliPart> {

	public List<PubliPart> listaOtrasPublicacionesXCedula(String cedula);

	boolean validarPublicaciones(String actividad, String cedula, Date fechaInicio);

}
