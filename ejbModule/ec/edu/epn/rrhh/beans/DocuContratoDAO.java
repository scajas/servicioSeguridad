package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.DocuContrato;
import ec.edu.epn.rrhh.movimientos.SubtipoAccion;
import ec.edu.epn.rrhh.movimientos.TipoAccion;
import ec.edu.epn.rrhh.movimientos.TipoRelacion;

@Remote
public interface DocuContratoDAO extends DaoGenerico<DocuContrato> {
	//Nuevo m�todo
	public List<DocuContrato> findTipoDocuContrato();
	
	


}
