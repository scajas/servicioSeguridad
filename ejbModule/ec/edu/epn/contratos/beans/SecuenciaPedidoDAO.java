package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Secuenciales;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface SecuenciaPedidoDAO extends DaoGenerico<Secuenciales> {
	
	List<Secuenciales> listxPensum(int idPensum);
	
	List<Secuenciales> listxFacultadPensum(String idFacultad,int idPensum);
	
	
	
	}
