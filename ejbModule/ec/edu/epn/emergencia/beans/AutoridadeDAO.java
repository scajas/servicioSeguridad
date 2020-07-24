package ec.edu.epn.emergencia.beans;

import java.util.Date;
import java.util.List;


import javax.ejb.Remote;

import ec.edu.epn.emergencia.entidades.Autoridade;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Remote
public interface AutoridadeDAO extends DaoGenerico<Autoridade> {

	public List<Autoridade> findAutorizaciones();

	public Autoridade findAutoridadxCedula(String identificacion);


}
