package ec.edu.epn.silabo.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.Autorizacionretraso;

@Local
public interface AutorizacionretrasoDAO extends DaoGenerico<Autorizacionretraso>{

	Autorizacionretraso consultarAutorizacion(String nced, String codMat, Integer idPensum, String paralelo,
			String codcarrera, String año);

	int maxIdAutorizacion();

}
