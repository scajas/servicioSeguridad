package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.entities.Documento;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.generic.DAO.DaoGenerico;



@Local
public interface documentoDAO extends
		DaoGenerico<Documento> {
	int consultarId();

	List<Documento> listaDocumentosXIDPed(Pedido pedido);

	List<Documento> listaDocumentosPedidoAFirmar(String pedido);

	List<Documento> listaDocumentosAEliminar(int idPedido, String pathDoc,
			String nombredoc);

	Documento listaDocumentosFirmadoXIDPed(Pedido pedido);

	Documento documentoFirmado(Pedido pedido);

	List<Documento> listaDocumentosPedidoAFirmados(String pedido);
	
	List<Documento> documentosXIDPed(Pedido pedido);

}
