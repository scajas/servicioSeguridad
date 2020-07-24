package ec.edu.epn.emergencia.beans;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import ec.edu.epn.emergencia.entidades.AsistenciaEmergencia;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.emergencia.entidades.Guardia;
import ec.edu.epn.emergencia.entidades.HorarioEmergencia;
import ec.edu.epn.emergencia.entidades.Pregunta;
import ec.edu.epn.emergencia.entidades.SolicitudAutorizacion;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Ecivil;



@Remote
public interface SolicitudAutorizacionDAO extends DaoGenerico<SolicitudAutorizacion> {

	public List<SolicitudAutorizacion> findSolicitudes();

	public Integer getMaxId();
	
	public List<SolicitudAutorizacion> findSolicitudesxPersonaAutoriza(String cedula);

	public List<SolicitudAutorizacion> findSolicitudesxMedico();

	public List<SolicitudAutorizacion> findSolicitudesxTalento();

	public List<SolicitudAutorizacion> findSolicitudesxCedula(String cedula);

}
