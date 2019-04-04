package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.facturacion.entities.EstadoFactura;
import ec.edu.epn.facturacion.entities.Factura;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
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
		
		
		consulta.append("SELECT DISTINCT (f) from Factura f, Proforma p, DetalleProforma d, Servicio s,LaboratorioLab l, LaboratorioUsuario lu,Usuario u"
				+ " where f.idProforma = p.idProforma and p.idProforma = d.proforma.idProforma and d.servicio.idServicio = s.idServicio and s.laboratorio.idLaboratorio = l.idLaboratorio and l.idLaboratorio = lu.id.idLaboratorio and lu.id.idUsuario = u.id "
				+ " and lu.id.idUsuario = ?0 and  u.id_unidad = ?1 and f.idEstadoFactura = '2' order by f.idFactura desc  ");

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
}
