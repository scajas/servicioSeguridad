package ec.edu.epn.publik.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.seguridad.vo.Perfil;



@Local
public interface PerfilDAO extends DaoGenerico<Perfil> {

	Perfil buscarPerfilPorNombre(String nombre);

	Perfil buscarbyID(Long id);
		

}
