package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Familiare;

@Local
public interface FamiliaresDAO extends DaoGenerico<Familiare> {

	List<Familiare> listaXCedulaEmp(String cedula);

	int consultarIdFamiliar();
}
