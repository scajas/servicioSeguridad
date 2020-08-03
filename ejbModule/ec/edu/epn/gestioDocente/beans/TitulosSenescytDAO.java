package ec.edu.epn.gestioDocente.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.gestionDocente.entities.Nosenescyt;
import ec.edu.epn.gestionDocente.entities.TitulosSenescyt;

@Local
public interface TitulosSenescytDAO extends DaoGenerico<TitulosSenescyt> {
	List<TitulosSenescyt> findTitulosSenescyt(String cedula, String regSenescyt);

	int consultarIdtitulo();

	int consultarIdNosenescyt();

	void insernosenescyt(Nosenescyt snc);

	List<TitulosSenescyt> TitulosSenescyt(String cedula);
}
