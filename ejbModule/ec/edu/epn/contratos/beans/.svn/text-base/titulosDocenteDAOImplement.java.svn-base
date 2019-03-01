/**
 * 
 */
package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.TitulosDocente;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;


/**
 * @author Administrador
 * 
 */
@Stateless
public class titulosDocenteDAOImplement extends
		DaoGenericoImplement<TitulosDocente> implements titulosDocenteDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery(
				"SELECT MAX(td.id_tituloDocente) FROM TitulosDocente td");
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
	public List<TitulosDocente> buscarTitulosXPedido(String cedula) {
		Query query = getEntityManager().createQuery(
				"SELECT td FROM TitulosDocente td where td.cedulaDocente =?1");
		query.setParameter(1, cedula);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TitulosDocente> buscaTituloFecMaxCuartoNivel(String cedula) {
		Query query = getEntityManager().createQuery(
				"SELECT td FROM TitulosDocente td  where td.cedulaDocente =?1 "
						+ " and td.nivelTitulo = ?2 ");
		String nivelTitulo = "Títulos de Cuarto Nivel";
		query.setParameter(1, cedula);
		query.setParameter(2, nivelTitulo);

		return query.getResultList();
	}

	@Override
	public List<TitulosDocente> buscarTitulosXPedido(Pedido pedido) {
		Query query = getEntityManager()
				.createQuery(
						"SELECT td FROM TitulosDocente td where td.pedido.idPedido =?1");
		query.setParameter(1, pedido.getIdPedido());
		return query.getResultList();
	}
}
