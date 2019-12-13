package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.facturacion.entities.EstadoFactura;
import ec.edu.epn.facturacion.entities.Factura;
import ec.edu.epn.facturacion.entities.TransferenciaInterna;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Muestra;

@Stateless
@LocalBean
public class MuestraDAOImplement extends DaoGenericoImplement<Muestra> implements MuestraDAO {

	/**
	 * Default constructor.
	 */
	public MuestraDAOImplement() {

	}

	@Override
	public List<Factura> getListaFacturas(Integer idUsuario, Integer idUnidad) {

		StringBuilder consulta = new StringBuilder();

		consulta.append(
				"SELECT DISTINCT (f) from Factura f, Proforma p, DetalleProforma d, Servicio s,LaboratorioLab l, LaboratorioUsuario lu,Usuario u"
						+ " where f.idProforma = p.idProforma and p.idProforma = d.proforma.idProforma and d.servicio.idServicio = s.idServicio and s.laboratorio.idLaboratorio = l.idLaboratorio and l.idLaboratorio = lu.id.idLaboratorio and lu.id.idUsuario = u.id "
						+ " and lu.id.idUsuario = ?0 and  u.id_unidad = ?1 and f.idEstadoFactura = '2' order by f.idFactura desc  ");

		Query q = super.getEntityManager().createQuery(consulta.toString());
		q.setParameter(0, idUsuario);
		q.setParameter(1, idUnidad);

		return q.getResultList();
	}

	@Override
	public List<TransferenciaInterna> getListaTransferencia(Integer idUsuario, Integer idUnidad) {

		StringBuilder consulta = new StringBuilder();

		consulta.append(
				"SELECT DISTINCT (t) FROM TransferenciaInterna t, Proforma p, DetalleProforma d, Servicio s,LaboratorioLab l, LaboratorioUsuario lu,Usuario u"
						+ " where t.idProforma = p.idProforma and p.idProforma = d.proforma.idProforma and d.servicio.idServicio = s.idServicio and s.laboratorio.idLaboratorio = l.idLaboratorio and l.idLaboratorio = lu.id.idLaboratorio and lu.id.idUsuario = u.id "
						+ "and lu.id.idUsuario = ?0 and  u.id_unidad = ?1 and t.estadoTi= 'ACEPTADA' order by t.idTi desc ");

		Query q = super.getEntityManager().createQuery(consulta.toString());
		q.setParameter(0, idUsuario);
		q.setParameter(1, idUnidad);

		return q.getResultList();
	}

	@Override
	public EstadoFactura findMetodoById(String idEstadoFactura) {
		StringBuilder querys = new StringBuilder("SELECT e FROM EstadoFactura e where e.idEstadoFactura = ?0");
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(0, idEstadoFactura);
		query.setMaxResults(1);

		try {
			EstadoFactura estadoFactura = (EstadoFactura) query.getSingleResult();
			return estadoFactura;
		} catch (NoResultException nre) {
			return null;
		} catch (NonUniqueResultException nure) {
			return null;
		}

	}

	@Override
	public List<Muestra> ListaMFById(String id) {

		System.out.println("idUnidad: " + id);
		StringBuilder queryString = new StringBuilder(
				"SELECT m FROM Muestra m where m.idMuestra like '%" + id + "%' ORDER BY idMuestra");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Muestra> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public List<Muestra> ListaMTById(String id) {

		System.out.println("idUnidad: " + id);
		StringBuilder queryString = new StringBuilder(
				"SELECT DISTINCT (m) FROM Muestra m, TransferenciaInterna ti"
				+ " WHERE m.idTi = ti.idTi AND m.idMuestra like '%" + id
						+ "%' ORDER BY m.idMuestra");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Muestra> resultados = query.getResultList();
		return resultados;
		
	}

}
