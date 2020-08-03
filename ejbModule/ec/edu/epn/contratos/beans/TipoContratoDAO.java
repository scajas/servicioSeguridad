package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.TipoContrato;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface TipoContratoDAO extends DaoGenerico<TipoContrato> {
	TipoContrato buscarTCXNombre(String contrato);
	List<TipoContrato> listaTiposContratos();
	public List<TipoContrato> listaTiposContratosAdicional() throws Exception;
	List<TipoContrato> listaTiposContratosPreplanif();
}
