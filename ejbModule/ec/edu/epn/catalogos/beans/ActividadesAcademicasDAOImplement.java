/**
 * 
 */
package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.ActividadesAcademica;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.PlanifDocente;

/**
 * @author Administrador
 * 
 */
@Stateless
public class ActividadesAcademicasDAOImplement extends DaoGenericoImplement<ActividadesAcademica>
		implements ActividadesAcademicasDAO {
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(act.id_actividad) FROM ActividadesAcademica act");
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
		return idReq;

	}

	@Override
	public List<ActividadesAcademica> actividadesByTipo(String actividad) {
		Query query = getEntityManager().createNamedQuery("ActividadesAcademica.findByTipo");
		query.setParameter("tipoactividad", actividad);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadesAcademica> buscarActivdiadesDocentes(String docencia) {
		Query qUsuario = getEntityManager().createQuery(
				"select actdoc from ActividadesAcademica actdoc where actdoc.tipo = ? order by ordenActividad asc");
		qUsuario.setParameter(1, docencia);
		return qUsuario.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadesAcademica> buscarActivdiadesInvestigacion(String investigacion) {
		Query qUsuario = getEntityManager().createQuery(
				"select actdoc from ActividadesAcademica actdoc where actdoc.tipo = ? order by ordenActividad asc");
		qUsuario.setParameter(1, investigacion);
		return qUsuario.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadesAcademica> buscarActivdiadesGestion(String gestion) {
		Query qUsuario = getEntityManager().createQuery(
				"select actdoc from ActividadesAcademica actdoc where actdoc.tipo = ? order by ordenActividad asc");
		qUsuario.setParameter(1, gestion);
		return qUsuario.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadesAcademica> buscarActivdiadesActualizacion(String actualizacion) {
		Query qUsuario = getEntityManager().createQuery(
				"select actdoc from ActividadesAcademica actdoc where actdoc.tipo = ? order by ordenActividad asc");
		qUsuario.setParameter(1, actualizacion);
		return qUsuario.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanifDocente> verificarEvaluacionRegistrada(String cedula, String periodo) {
		Query consulta = getEntityManager().createQuery(
				"select pd from PlanifDocente pd where pd.nced = ? and pd.periodo.idPeriodo = ? order by pd.actividadAcademica.ordenActividad asc");
		consulta.setParameter(1, cedula);
		consulta.setParameter(2, periodo);
		return consulta.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanifDocente> verificarEvaluacionRegistradaXcedula(String cedula) {
		try {
			Query consulta = getEntityManager()
					.createQuery("select pd from PlanifDocente pd where pd.nced = ? order by pd.periodo.idPeriodo asc");
			consulta.setParameter(1, cedula);
			System.out.println("TAMAÑO CONSULTA:" + consulta.getResultList().size());
			return consulta.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
