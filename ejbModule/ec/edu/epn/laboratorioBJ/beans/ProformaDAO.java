package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Proforma;

@Local
public interface ProformaDAO extends DaoGenerico<Proforma> {

	List<Proforma> getparametrosCliente(String fechaInicio, String fechaFin, String tipoCliente, String estadoPro);

}
