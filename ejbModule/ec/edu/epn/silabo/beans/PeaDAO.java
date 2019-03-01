package ec.edu.epn.silabo.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.silabo.entities.Pea;

@Local
public interface PeaDAO extends DaoGenerico<Pea>{

	Pea consultarPea(String codMat, String paralelo, String materia);

}
