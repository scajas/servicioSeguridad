/**
 * 
 */
package ec.edu.epn.gestioDocente.beans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Actividad_PlanHorario;
import ec.edu.epn.gestionDocente.entities.PlanTrabajo;


/**
 * @author Administrador
 * 
 */
@Stateless
public class PlanTrabajoDAOImplement extends DaoGenericoImplement<PlanTrabajo> implements PlanTrabajoDAO {
	
	@Override
	public int consultarId() {
		Query q = getEntityManager().createQuery("SELECT MAX(act.idPlan) FROM PlanTrabajo act");
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
	public PlanTrabajo buuscarXNced(String cedula, int id_pensum) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT plan FROM PlanTrabajo plan where plan.nced like ?1 and plan.estado = ?2 and plan.pensum.idPensum = ?3");
			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, "%" + cedula + "%");
			query.setParameter(2, "GUARDADO");
			query.setParameter(3, id_pensum);			
			return (PlanTrabajo) query.getSingleResult();
		} catch (Exception e) {			
			return null;
		}
	}

	@Override
	public PlanTrabajo buuscarPlanTrabajoEnviado(String cedula, Pensum p) {
		try {
			StringBuilder queryString = new StringBuilder(
					"SELECT plan FROM PlanTrabajo plan where plan.nced like ?1  and plan.pensum.idPensum = ?3");
			Query query = getEntityManager()
					.createQuery(queryString.toString());
			query.setParameter(1, "%" + cedula + "%");
			query.setParameter(3, p.getIdPensum());			
			return (PlanTrabajo) query.getSingleResult();
		} catch (Exception e) {			
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanTrabajo> buscarPlanesXCedulaNombre(String cedula,
			String nombre, String apellido, Pensum pensum) {

		String estado = "A";
		StringBuilder queryString = new StringBuilder(
				"SELECT plan FROM PlanTrabajo plan where plan.estado like ?1");

		if (cedula != null && !cedula.equals(""))
			queryString.append(" and plan.nced like ?2 ");

		if (nombre != null && !nombre.equals(""))
			queryString.append(" and plan.nombreDocente like ?3 ");

		if (apellido != null && !apellido.equals(""))
			queryString.append(" and plan.apellidoDocente like ?4");

		if (pensum != null)
			queryString.append(" and plan.pensum.idPensum like ?5");

		queryString.append(" order by plan.apellidoDocente asc");		

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, "%" + estado + "%");
		if (cedula != null && !cedula.equals(""))
			query.setParameter(2, "%" + cedula + "%");
		if (nombre != null && !nombre.equals("")) {
			query.setParameter(3, "%" + nombre + "%");
		}

		if (apellido != null && !apellido.equals("")) {
			query.setParameter(4, "%" + apellido + "%");
		}

		if (pensum != null)
			query.setParameter(5, pensum.getIdPensum());

		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanTrabajo> listaCargos() {
		StringBuilder queryString = new StringBuilder("SELECT plan FROM PlanTrabajo plan where plan.cargo not in ('')");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<PlanTrabajo> lista = new ArrayList<PlanTrabajo>();
		lista = query.getResultList();

		StringBuilder queryString1 = new StringBuilder("SELECT plan FROM PlanTrabajo plan where plan.cargoCon not in ('')");
		Query query1 = getEntityManager().createQuery(queryString1.toString());

		List<PlanTrabajo> lista1 = new ArrayList<PlanTrabajo>();
		lista1 = query1.getResultList();

		for (PlanTrabajo plan : lista1) {
			PlanTrabajo p = new PlanTrabajo();
			p = plan;
			p.setCargo(plan.getCargoCon());
			lista.add(p);
		}

		return lista;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanTrabajo> buscarPlanesAvanzados(PlanTrabajo plan,
			String horario) {

		if (horario != null && !horario.equals("")) {

			List<Actividad_PlanHorario> listaActHorario = new ArrayList<Actividad_PlanHorario>();
			String[] horas = horario.split("-");
			int h1 = Integer.parseInt(horas[0]);
			int h2 = Integer.parseInt(horas[1]);
			List<Integer> listaenteros = new ArrayList<Integer>();
			for (int x = h1; x < h2; x++) {
				StringBuilder queryString1 = new StringBuilder("SELECT plan FROM Actividad_PlanHorario  plan where plan.horarioPlanhorario like ?1");
				Query query1 = getEntityManager().createQuery(queryString1.toString());
				String hora = h1 + "-" + (h1 + 1);
				query1.setParameter(1, "%" + hora + "%");
				listaActHorario.addAll(query1.getResultList());
				for (Actividad_PlanHorario act : listaActHorario) {
					if (!act.getLunesPlanhorario().equals("S/A")
							|| !act.getMartesPlanhorario().equals("S/A")
							|| !act.getMiercolesPlanhorario().equals("S/A")
							|| !act.getJuevesPlanhorario().equals("S/A")
							|| !act.getViernesPlanhorario().equals("S/A"))
						listaenteros.add(act.getPlanTrabajo().getIdPlan());
				}
				Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
				linkedHashSet.addAll(listaenteros);
				listaenteros.clear();
				listaenteros.addAll(linkedHashSet);
				
			}

			List<PlanTrabajo> listaPlan = new ArrayList<PlanTrabajo>();

			for (Integer i : listaenteros) {
				StringBuilder queryString = new StringBuilder("SELECT plan FROM PlanTrabajo plan where plan.idPlan = ?1");
				Query query = getEntityManager().createQuery(queryString.toString());
				query.setParameter(1, i);
				listaPlan.addAll(query.getResultList());

			}

			String estado = "A";
			StringBuilder queryString = new StringBuilder("SELECT plan FROM PlanTrabajo plan where plan.estado like ?1");

			if (plan.getDedicaTc() != null && !plan.getDedicaTc().equals(""))
				queryString.append(" and plan.dedicaTc like ?2 ");

			if (plan.getTrabajaOu() != null && !plan.getTrabajaOu().equals(""))
				queryString.append(" and plan.trabajaOu like ?3 ");

			if (plan.getEmpresaPropia() != null && !plan.getEmpresaPropia().equals(""))
				queryString.append(" and plan.empresaPropia like ?4");

			if (plan.getInstruAcademia() != null && !plan.getInstruAcademia().equals(""))
				queryString.append(" and plan.instruAcademia like ?5");

			if (plan.getInstruSeminario() != null && !plan.getInstruSeminario().equals(""))
				queryString.append(" and plan.instruSeminario like ?6");

			/* cargoContrato */
			if (plan.getCargo() != null && !plan.getCargo().equals(""))
				queryString.append(" and plan.cargo like ?7");
			
			if (plan.getCargoCon() != null && !plan.getCargoCon().equals(""))
				queryString.append(" and plan.cargoCon like ?8");

			queryString.append(" order by plan.apellidoDocente asc");
			
			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(1, "%" + estado + "%");
			if (plan.getDedicaTc() != null && !plan.getDedicaTc().equals(""))
				query.setParameter(2, "%" + plan.getDedicaTc() + "%");
			
			if (plan.getTrabajaOu() != null && !plan.getTrabajaOu().equals(""))
				query.setParameter(3, "%" + plan.getTrabajaOu() + "%");
			
			if (plan.getEmpresaPropia() != null && !plan.getEmpresaPropia().equals(""))
				query.setParameter(4, "%" + plan.getEmpresaPropia() + "%");
			
			if (plan.getInstruAcademia() != null && !plan.getInstruAcademia().equals(""))
				query.setParameter(5, "%" + plan.getInstruAcademia() + "%");
			
			if (plan.getInstruSeminario() != null && !plan.getInstruSeminario().equals(""))
				query.setParameter(6, "%" + plan.getInstruSeminario() + "%");

			if (plan.getCargo() != null && !plan.getCargo().equals(""))
				query.setParameter(7, "%" + plan.getCargo() + "%");
			
			if (plan.getCargoCon() != null && !plan.getCargoCon().equals(""))
				query.setParameter(8, "%" + plan.getCargoCon() + "%");

			List<PlanTrabajo> lista = new ArrayList<PlanTrabajo>();
			lista = query.getResultList();

			List<PlanTrabajo> listafinal = new ArrayList<PlanTrabajo>();
			for (PlanTrabajo p : lista) {
				for (PlanTrabajo p1 : listaPlan) {
					if (p.getIdPlan() == p1.getIdPlan())
						listafinal.add(p);
				}
			}
			return listafinal;
			
		} else {
			String estado = "A";
			StringBuilder queryString = new StringBuilder(
					"SELECT plan FROM PlanTrabajo plan where plan.estado like ?1");

			if (plan.getDedicaTc() != null && !plan.getDedicaTc().equals(""))
				queryString.append(" and plan.dedicaTc like ?2 ");

			if (plan.getTrabajaOu() != null && !plan.getTrabajaOu().equals(""))
				queryString.append(" and plan.trabajaOu like ?3 ");

			if (plan.getEmpresaPropia() != null && !plan.getEmpresaPropia().equals(""))
				queryString.append(" and plan.empresaPropia like ?4");

			if (plan.getInstruAcademia() != null && !plan.getInstruAcademia().equals(""))
				queryString.append(" and plan.instruAcademia like ?5");

			if (plan.getInstruSeminario() != null && !plan.getInstruSeminario().equals(""))
				queryString.append(" and plan.instruSeminario like ?6");

			/* cargoContrato */
			if (plan.getCargo() != null && !plan.getCargo().equals(""))
				queryString.append(" and plan.cargo like ?7");
			
			if (plan.getCargoCon() != null && !plan.getCargoCon().equals(""))
				queryString.append(" and plan.cargoCon like ?8");

			queryString.append(" order by plan.apellidoDocente asc");			

			Query query = getEntityManager().createQuery(queryString.toString());

			query.setParameter(1, "%" + estado + "%");
			if (plan.getDedicaTc() != null && !plan.getDedicaTc().equals(""))
				query.setParameter(2, "%" + plan.getDedicaTc() + "%");
			
			if (plan.getTrabajaOu() != null && !plan.getTrabajaOu().equals(""))
				query.setParameter(3, "%" + plan.getTrabajaOu() + "%");
			
			if (plan.getEmpresaPropia() != null && !plan.getEmpresaPropia().equals(""))
				query.setParameter(4, "%" + plan.getEmpresaPropia() + "%");
			
			if (plan.getInstruAcademia() != null && !plan.getInstruAcademia().equals(""))
				query.setParameter(5, "%" + plan.getInstruAcademia() + "%");
			
			if (plan.getInstruSeminario() != null && !plan.getInstruSeminario().equals(""))
				query.setParameter(6, "%" + plan.getInstruSeminario() + "%");

			if (plan.getCargo() != null && !plan.getCargo().equals(""))
				query.setParameter(7, "%" + plan.getCargo() + "%");
			
			if (plan.getCargoCon() != null && !plan.getCargoCon().equals(""))
				query.setParameter(8, "%" + plan.getCargoCon() + "%");
			
			return query.getResultList();
		}
	}
}
