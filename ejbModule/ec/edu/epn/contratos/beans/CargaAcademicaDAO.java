package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.contratos.entities.Actividades;
import ec.edu.epn.contratos.entities.CargaAcademica;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Remote
public interface CargaAcademicaDAO extends
DaoGenerico<CargaAcademica>{

	List<CargaAcademica> findCargaAcadByParams(int nced);

	List<CargaAcademica> findCargaAcadRmu(int idPed);

	long numHorasRmu(int idPed);

}
