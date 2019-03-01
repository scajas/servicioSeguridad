package ec.edu.epn.infraestructura.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.entities.Emp;

@Local
public interface EmpleadosDAO extends DaoGenerico<Emp> {

	List<Emp> listaEmpleadoXCedula(String cedula);

}
