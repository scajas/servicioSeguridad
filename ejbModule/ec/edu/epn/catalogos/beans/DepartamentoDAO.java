package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.Departamento;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface DepartamentoDAO extends DaoGenerico<Departamento> {

	List<Departamento> findbyIdFacultad(String idFacultad);

	Departamento dept(Integer iddetp) throws Exception;

	List<Departamento> findbDept();
	
}
