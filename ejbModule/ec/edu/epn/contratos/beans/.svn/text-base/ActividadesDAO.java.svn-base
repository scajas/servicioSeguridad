package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Actividades;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface ActividadesDAO extends
		DaoGenerico<Actividades> {
	int consultarId();

	List<Actividades> buscarActividadXParametrosCarreraNombre(String parametro,
			String nombre);

	List<Actividades> findActividadesByParams(int nced);

	List<Actividades> buscarActividadSINPedido();

	List<Actividades> buscarActividadXPedido(Pedido pedido);
	
	long numHorasActividadesRmu(int idPed);
	List<Actividades> findActividByParam(Pedido pedido);

	

	

}
