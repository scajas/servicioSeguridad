package ec.edu.epn.emergencia.beans;

import java.util.List;


import javax.ejb.Remote;

import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Remote
public interface AutorizacionEmergenciaDAO extends DaoGenerico<AutorizacionEmergencia> {

	public List<AutorizacionEmergencia> findAutorizaciones();

	public Integer getMaxId();

	public List<AutorizacionEmergencia> findAutorizacionesXCedula(String cedula);

}
