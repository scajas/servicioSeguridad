package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.desarrollo.entities.ReqPersona;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface ReqPersonaDAO extends DaoGenerico<ReqPersona>{

	List<ReqPersona> consultarDetallesbyReq(Integer idreq);

	List<ReqPersona> consultarDetallesbyDev(String nced);

	List<ReqPersona> consultarReqAsignadosByEstado(String estado);

}
