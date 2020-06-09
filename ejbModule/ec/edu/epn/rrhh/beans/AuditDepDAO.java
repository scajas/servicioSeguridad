package ec.edu.epn.rrhh.beans;


import javax.ejb.Remote;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.rrhh.movimientos.AuditDep;

@Remote
public interface AuditDepDAO extends DaoGenerico<AuditDep>{

	public Integer getMaxId();
}
