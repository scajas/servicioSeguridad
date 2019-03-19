package ec.edu.epn.desarrollo.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.desarrollo.entities.EstadoReq;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface EsatdoReqDAO extends DaoGenerico<EstadoReq>{

	List<EstadoReq> consultarDetallesbyReq(Integer idreq);

	List<EstadoReq> consultarDetallesbyReqExiste(Integer idEstado, Integer idreq);

	List<EstadoReq> consultarDetallesbyReqFinal(Integer idEstado, Integer idreq);

}
