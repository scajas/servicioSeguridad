package ec.edu.epn.silabo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.Cronosubcapitulo;

@Local
public interface CronosubcapituloDAO extends DaoGenerico<Cronosubcapitulo>{

	List<Cronosubcapitulo> findCronobyid(Integer idcrono);

	int maxId();

	List<Cronosubcapitulo> findCronobyidExiste(Integer idcrono, Integer idSubcapitulo);

	void boorar(Cronosubcapitulo crono);

}
