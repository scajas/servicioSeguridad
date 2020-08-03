package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.TitulosDocente;
import ec.edu.epn.generic.DAO.DaoGenerico;


@Local
public interface titulosDocenteDAO extends DaoGenerico<TitulosDocente> {
	int consultarId();

	List<TitulosDocente> buscarTitulosXPedido(String cedula);

	List<TitulosDocente> buscarTitulosXPedido(Pedido pedido);

	List<TitulosDocente> buscaTituloFecMaxCuartoNivel(String cedula);

}
