package ec.edu.epn.rrhh.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.NoResultException;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.DTO.ContDTO;
import ec.edu.epn.rrhh.entities.Cont;

@Local
public interface ContDAO extends DaoGenerico<Cont> {

	
	Cont findbyCedula(String cedula);

	Cont findContratobyCedula(String cedula);

	List<Cont> findContratosHisotiral(String cedula);

	Cont findContID(String idnom);

	void updatecONTRATO(String idnom, String path);

	Long countContPeriodo(String nCont) throws Exception;

	List<Cont> listarContratosXcedulaXidPensum(String cedula, Integer idPensum) throws NoResultException, Exception;

	List<ContDTO> listarContratosXcedulaXidPensumJdbc(String cedula, Integer idPensum) throws SQLException, Exception;

	List<Cont> findContratosHisotiral2012(String cedula);

	List<Cont> findbyPeriodo(Integer idperiodo);

	ArrayList<ContDTO> consultaContratosPeriodo(Integer idperiodo,String tcontrato);
	
}
