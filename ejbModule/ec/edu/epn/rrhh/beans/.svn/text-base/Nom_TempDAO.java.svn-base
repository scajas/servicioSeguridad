package ec.edu.epn.rrhh.beans;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.NoResultException;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.DTO.NombTempDTO;
import ec.edu.epn.rrhh.entities.NombTemp;
import ec.edu.epn.rrhh.entities.Partind;

@Local
public interface Nom_TempDAO extends DaoGenerico<NombTemp> {

	NombTemp findbyNced(String nced);

	NombTemp consultarNombramiento(String nced);

	List<NombTemp> consultarNombramientosHistoria(String nced);

	int consultarIdnombramiento();

	NombTemp findNombyID(Integer idnom);

	void updateNombramiento(Integer idnom, String path);

	List<NombTemp> listarNombramientosXcedulaXidPensum(String cedula, Integer idPensum)
			throws NoResultException, Exception;

	List<NombTempDTO> listarNombramientosXcedulaXidPensumJdbc(String cedula, Integer idPensum)
			throws SQLException, Exception;

	List<NombTempDTO> listarNombramientosXcedulaMaxFecha(String cedula) throws SQLException, Exception;
	
	List<NombTemp> consultarNombramientosHistoria2012(String nced);

}
