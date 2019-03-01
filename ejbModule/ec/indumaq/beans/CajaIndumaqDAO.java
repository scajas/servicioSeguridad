package ec.indumaq.beans;

import javax.ejb.Local;

import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.indumaq.entidades.CajaIndumaq;

@Local
public interface CajaIndumaqDAO extends DaoGenerico<CajaIndumaq> {

	CajaIndumaq consultarSecuencialCaja(int idUsuario);
}
