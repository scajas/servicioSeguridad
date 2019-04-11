package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.facturacion.entities.EstadoFactura;
import ec.edu.epn.facturacion.entities.Factura;
import ec.edu.epn.facturacion.entities.TransferenciaInterna;
import ec.edu.epn.generic.DAO.DaoGenerico;
import ec.edu.epn.laboratorioBJ.entities.Muestra;

@Local
public interface MuestraDAO extends DaoGenerico<Muestra>{

	List<Factura> getListaFacturas(Integer idUsuario, Integer idUnidad);
	EstadoFactura findMetodoById(String idEstadoFactura);
	List<TransferenciaInterna> getListaTransferencia(Integer idUsuario, Integer idUnidad);
	
}
