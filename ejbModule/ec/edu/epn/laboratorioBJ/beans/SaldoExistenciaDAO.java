package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.SaldoExistencia;

@Local
public interface SaldoExistenciaDAO extends DaoGenerico<SaldoExistencia>{

	List<SaldoExistencia> listaSaldoExistenciaAnioActual();

}
