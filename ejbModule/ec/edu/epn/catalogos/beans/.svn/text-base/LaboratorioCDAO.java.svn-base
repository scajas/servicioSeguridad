package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.catalogos.entities.Laboratorio;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface LaboratorioCDAO extends DaoGenerico<Laboratorio>{

	List<Laboratorio> findLaboByDepartamento(String coddep, String tipo,String v1,String v2,String v3);

}
