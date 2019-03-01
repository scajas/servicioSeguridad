package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Partida;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Local
public interface PartidasDAO extends DaoGenerico<Partida> {
	int consultarId();

	List<Partida> consultarPartidasxPedido(Pedido pedido);
}
