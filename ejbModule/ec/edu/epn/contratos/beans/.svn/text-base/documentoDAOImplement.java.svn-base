/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Documento;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Administrador
 * 
 */
@Stateless
public class documentoDAOImplement extends DaoGenericoImplement<Documento>
		implements documentoDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(doc.idDocuemnto) FROM Documento doc");
		Integer idReq = null;
		try {
			idReq = (Integer) q.setMaxResults(1).getSingleResult();
		} catch (Exception e) {

			e.printStackTrace();
			idReq = null;

		}
		if (idReq == null) {
			idReq = 1;

		} else {
			++idReq;

		}
		System.out.println("IDDDDDDDDDD" + idReq);
		return idReq;

	}

	@Override
	public List<Documento> listaDocumentosXIDPed(Pedido pedido) {
		String charsnolike1 = "p7m";
		String charsnolike2 = "Firmado";
		Query q = getEntityManager()
				.createQuery(
						"Select doc from Documento doc where doc.ped.idPedido = ?1 and doc.pathDocumento not like ?2 and doc.pathDocumento not like ?3 order by doc.nombreDocumento asc");
		q.setParameter(1, pedido.getIdPedido());
		q.setParameter(2, "%" + charsnolike1 + "%");
		q.setParameter(3, "%" + charsnolike2 + "%");
		System.out.println("Documentos seleccionados!!!!!!!!!!!"
				+ q.getResultList().size());
		return q.getResultList();
	}

	@Override
	public Documento documentoFirmado(Pedido pedido) {
		String extFirma = ".pdf.p7m";
		Query q = getEntityManager()
				.createQuery(
						"Select doc from Documento doc where doc.ped.idPedido = ?1 and doc.pathDocumento like ?2");
		q.setParameter(1, pedido.getIdPedido());
		q.setParameter(2, "%" + extFirma);
		System.out.println("Documento firmado seleccionados!!!!!!!!!!!");
		return (Documento) q.getSingleResult();
	}

	@Override
	public Documento listaDocumentosFirmadoXIDPed(Pedido pedido) {
		String extFirma = "[Firmado]";
		Query q = getEntityManager()
				.createQuery(
						"Select doc from Documento doc where doc.ped.idPedido = ?1 and doc.pathDocumento like ?2");
		q.setParameter(1, pedido.getIdPedido());
		q.setParameter(2, "%" + extFirma + "%");
		System.out
				.println("Documento firmado seleccionados!!!!!!!!!!! TAMAÑO: "
						+ q.getResultList().size());
		return (Documento) q.getSingleResult();
	}

	@Override
	public List<Documento> listaDocumentosAEliminar(int idPedido,
			String pathDocumentoDoc, String nombredoc) {

		Query q = getEntityManager()
				.createQuery(
						"Select doc from Documento doc where doc.ped.idPedido = ?1 and doc.pathDocumento like ?2 and doc.nombreDocumento like ?3");
		q.setParameter(1, idPedido);
		q.setParameter(2, pathDocumentoDoc);
		q.setParameter(3, nombredoc);
		System.out
				.println("Documento a eliminar seleccionados!!!!!!!!!!! TAMAÑO: "
						+ q.getResultList().size());
		return q.getResultList();
	}

	@Override
	public List<Documento> listaDocumentosPedidoAFirmar(String pedido) {

		Query q = getEntityManager()
				.createQuery(
						"Select doc from Documento doc where doc.nombreDocumento = ?1 and doc.pathDocumento like ?2 ");
		q.setParameter(1, "Pedido");
		q.setParameter(2, "%" + pedido + "%");
		System.out
				.println("Documentos pedido para firmar seleccionados!!!!!!!!!!!"
						+ q.getResultList().size());
		return q.getResultList();
	}

	@Override
	public List<Documento> listaDocumentosPedidoAFirmados(String pedido) {

		Query q = getEntityManager()
				.createQuery(
						"Select doc from Documento doc where doc.nombreDocumento = ?1 and doc.pathDocumento like ?2 ");
		q.setParameter(1, "Pedido Firmado");
		q.setParameter(2, "%" + pedido + "%");
		System.out
				.println("Documentos pedido para firmar seleccionados!!!!!!!!!!!"
						+ q.getResultList().size());
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> documentosXIDPed(Pedido pedido) {		
		Query q = getEntityManager()
				.createQuery(
						"Select doc from Documento doc where doc.ped.idPedido = ?1 order by doc.nombreDocumento asc");
		q.setParameter(1, pedido.getIdPedido());
		return q.getResultList();
	}

}
