package ec.edu.epn.rrhh.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.entities.Emp;
import ec.edu.epn.rrhh.movimientos.Designacion;
import ec.edu.epn.rrhh.movimientos.HistoriaLaboral;

@Stateless
public class HistoriaLaboralDAOImplement extends DaoGenericoImplement<HistoriaLaboral> implements HistoriaLaboralDAO {
	// HistoriaLaboralDAOImplement

	@Override
	public List<HistoriaLaboral> findHistoriaByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.emp.nced =?1 and fam.id.fechaI = "
						+ "(Select max(t.id.fechaI) " + "from HistoriaLaboral t where t.id.idHist=fam.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;

	}

	@Override
	public List<HistoriaLaboral> findHistoriasByEmpNoDuplicados(Emp emp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.emp.nced =?1 and fam.id.fechaI = "
						+ "(Select max(t.id.fechaI) from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
						+ "and t.id.idHist not in (select hist.id.idHist from HistoriaLaboral hist where "
						+ " (trim(hist.id.estado)= 'Duplicado' or trim(hist.id.estado) = 'Anulado' "
						+ "or trim(hist.id.estado) = 'Insubsistente') and hist.emp.nced = ?1))");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistoriaLaboral> findHistoriaByNoDoc(String nced) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM HistoriaLaboral fam where fam.nroDocumento =?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, nced);

		return query.getResultList();

	}

	@Override
	public List<HistoriaLaboral> findHistoriasSinContratoByEmp(Emp emp) {

		List<HistoriaLaboral> resultado = this.findHistoriaByEmp(emp);

		List<HistoriaLaboral> historiasSinAccionP = new ArrayList<>();
		for (HistoriaLaboral historia : resultado) {
			if (historia.getAccionP() == null) {
				historiasSinAccionP.add(historia);
			}
		}
		resultado.removeAll(historiasSinAccionP);
		return resultado;

	}

	@Override
	public List<HistoriaLaboral> findHistoriasAnuladasInsub(Emp emp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.emp.nced =?1 and fam.id.fechaI = "
						+ "(Select max(t.id.fechaI) " + "from HistoriaLaboral t where t.id.idHist=fam.id.idHist and"
						+ " (t.id.estado = 'Anulado' or t.id.estado = 'Insubsistente'))");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> findHistorias() {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.id.fechaI = " + "(Select max(t.id.fechaI) "
						+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());

		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;

	}

	@Override
	public List<HistoriaLaboral> findHistorias(Integer anio) {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "YEAR(fam.fechaRige)=:anio and fam.id.fechaI = "
						+ "(Select max(t.id.fechaI) " + "from HistoriaLaboral t where t.id.idHist=fam.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("anio", anio);
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;

	}

	@Override
	public List<HistoriaLaboral> findHistorias(Date inicio, Date ffinal, String nombreDependencia,
			String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado, String nombreDesignacion,
			Emp empleado, boolean isFullReport) {
		StringBuilder queryString = new StringBuilder("");
		Query query = null;
		queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " (fam.fechaRige BETWEEN :inicio and :final)  ");
		if (empleado != null) {
			String empleadoPredicate = " and fam.emp.nced = " + "\'" + empleado.getNced() + "\' ";
			queryString.append(empleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (nombreCargo.compareTo("Todos") != 0) {
			String cargoPredicate = " and fam.cargosm.nombreCargo =" + "\'" + nombreCargo + "\' ";
			queryString.append(cargoPredicate);
		}

		if (claseEmpleado.compareTo("Todos") != 0) {
			String claseEmpleadoPredicate = " and fam.emp.clasemp.descClase =" + "\'" + claseEmpleado + "\' ";
			queryString.append(claseEmpleadoPredicate);
		}

		if (nombreDesignacion.compareTo("Todas") != 0) {
			String designacionEmpleadoPredicate = " and fam.designacion.designacionCatalogo.nombre =" + "\'"
					+ nombreDesignacion + "\' ";
			queryString.append(designacionEmpleadoPredicate);
		}
		if (!isFullReport) {
			String filterMaxFechas = "and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
					+ "and t.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
					+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
					+ " trim(g.id.estado) = 'Insubsistente' ))) ";
			queryString.append(filterMaxFechas);
		} else {
			String filterMaxFechas = "and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist ) ";
			queryString.append(filterMaxFechas);
		}
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);

		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;

	}

	public List<HistoriaLaboral> findHistorias(Date inicio, Date ffinal) {
		StringBuilder queryString = new StringBuilder("");

		queryString = new StringBuilder("SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.id.fechaI = "
				+ "(Select max(t.id.fechaI) " + "from HistoriaLaboral t where t.id.idHist=fam.id.idHist)"
				+ " and fam.fechaRige BETWEEN :inicio and :final ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);

		List<HistoriaLaboral> resultado = query.getResultList();
		return resultado;

	}

	@Override
	public List<HistoriaLaboral> findHistoriasEjecucion() {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral hl "
				+ "where (hl.id.estado='Ejecucion' or hl.id.estado='Elaborado')"
				+ " and (hl.accionP.id.idAccionp IS NOT NULL " + " and hl.id.fechaI = "
				+ " (Select max(hist.id.fechaI) from HistoriaLaboral hist where " + " hist.id.idHist = hl.id.idHist))");

		Query query = getEntityManager().createQuery(queryString.toString());
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;

	}

	@Override
	public List<HistoriaLaboral> findHistoriaByIdhistoria(Integer historiaid) {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " fam.id.idHist =?");
		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, historiaid);
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> findHistoriaYear(Integer year) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM HistoriaLaboral fam where year(fam.id.fechaI) =?");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, year);
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;

	}

	@Override
	public HistoriaLaboral findCurrentHistoriaLaboralByEmp(Emp emp) {
		// Se debe buscar la historia laboral mas reciente y con estado
		// Finalizado para obtener la situación

		StringBuilder queryString = new StringBuilder(
				" Select hl from HistoriaLaboral hl where  hl.emp.nced =?1 and hl.fechaRige = "
						+ "(Select max(hist.fechaRige) from HistoriaLaboral hist where hist.emp.nced=?1 "
						+ " and hist.fechaRige<=?2 " + " and (trim(hist.id.estado) = 'Finalizado' or "
						+ " trim(hist.id.estado) = '\"Finalizado\"') and "
						+ " hist.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
						+ " where histo.emp.nced=?1 and (trim(histo.id.estado)= ?3 or" + " trim(histo.id.estado)=?4)"
						+ " or (histo.accionP.subtipoAccion.nombreSubaccion like ?5 or "
						+ " histo.accionP.subtipoAccion.nombreSubaccion like ?6 or "
						+ " histo.accionP.subtipoAccion.nombreSubaccion like ?7 or  "
						+ " histo.accionP.subtipoAccion.nombreSubaccion like ?8 or "
						+ " histo.accionP.subtipoAccion.nombreSubaccion like ?9 "
						+ " or histo.accionP.subtipoAccion.tipoAccion.idTpa = 13))) " + " and hl.id.idHist not in "
						+ " (Select histo.id.idHist from HistoriaLaboral histo "
						+ " where histo.emp.nced=?1 and (trim(histo.id.estado)= ?3 or" + " trim(histo.id.estado)=?4))"
						+ " order by hl.fechaRige desc ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		query.setParameter(2, new Date());
		query.setParameter(3, "Insubsistente");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "VACACI%");
		query.setParameter(6, "LICENCIA POR MATERINDAD%");
		query.setParameter(7, "LICENCIA POR PATERNIDAD%");
		query.setParameter(8, "LICENCIA POR ENFERMEDAD%");
		query.setParameter(9, "LICENCIA POR CUIDADO DEL RECIEN NACIDO%");

		HistoriaLaboral resultado = null;
		HistoriaLaboral ultimoContrato = null;
		HistoriaLaboral mostRecentNombramiento = this.getMostRecentCualquierNombramientoByEmp(emp);
		List<HistoriaLaboral> resultados = new ArrayList<HistoriaLaboral>();

		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Empleado sin accciones de personal");
		} catch (NonUniqueResultException e) {
			resultados = query.getResultList();
			resultado = resultados.get(0);
			for (int i = 1; i < resultados.size(); i++) {

				if (resultados.get(i).getId().getFechaI().after(resultados.get(i - 1).getId().getFechaI())) {
					resultado = resultados.get(i);
				}

			}
		} finally {
			ultimoContrato = this.findLastContByEmp(emp);
		}

		resultados.clear();
		resultados.add(resultado);
		resultados.add(ultimoContrato);
		resultados.add(mostRecentNombramiento);
		List<HistoriaLaboral> clearResults = new ArrayList<HistoriaLaboral>();
		for (HistoriaLaboral result : resultados) {
			if (result != null) {
				clearResults.add(result);
			}
		}
		for (int i = 0; i < clearResults.size(); i++) {
			if (i == 0) {
				resultado = clearResults.get(i);
			}
			if (clearResults.size() > 1) {
				try {
					if (clearResults.get(i + 1).getFechaRige().after(resultado.getFechaRige())) {
						resultado = clearResults.get(i + 1);
					}
				} catch (IndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		return resultado;
	}

	@Override
	public HistoriaLaboral findCurrentHistoriaLaboralByEstadoActivoEmp(Emp emp) {
		// Se debe buscar la historia laboral mas reciente y con estado
		// Finalizado para obtener la situación

		StringBuilder queryString = new StringBuilder(
				"Select hl from HistoriaLaboral  " + "hl where  hl.emp.nced =?1 and hl.fechaRige = "
						+ "(Select max(hist.fechaRige) from HistoriaLaboral hist where hist.emp.nced=?1 "
						+ "and hist.accionP.subtipoAccion.tipoAccion.idTpa != 13 " + "and hist.fechaRige<=?2 "
						+ "and (hist.id.estado = 'Finalizado' or hist.id.estado = '\"Finalizado\"') and "
						+ "hist.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
						+ "where histo.emp.nced=?1 and (histo.id.estado= ?3 or histo.id.estado=?4) ))");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(3, "Insubsistente");
		query.setParameter(1, emp.getNced());
		query.setParameter(4, "Anulado");
		query.setParameter(2, new Date());
		HistoriaLaboral resultado = null;
		List<HistoriaLaboral> resultados = query.getResultList();
		try {

			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {

			return resultado;
		} catch (NonUniqueResultException e) {
			resultado = resultados.get(0);
			for (int i = 1; i < resultados.size(); i++) {
				if (resultados.get(i).getId().getFechaI().getDate() > resultados.get(i - 1).getId().getFechaI()
						.getDate())
					resultado = resultados.get(i);
			}

		}

		if (this.isEmpleadoConNombramiento(emp)) {
			return resultado;
		} else {
			HistoriaLaboral ultimoContrato = this.findLastContByEmpActivo(emp);
			if (ultimoContrato != null) {
				return ultimoContrato;
			} else {
				return resultado;
			}

		}

	}

	@Override
	public Integer getMaxID() {
		StringBuilder queryString = new StringBuilder("SELECT max(t.id.idHist) FROM HistoriaLaboral t");
		Query query = getEntityManager().createQuery(queryString.toString());
		Integer max = (Integer) query.getSingleResult();
		if (max == null)
			return 0;
		else
			return max;
	}

	@Override
	public Integer findHistoriaNumberBySubtipo(String subtipoAccion) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM HistoriaLaboral fam where  fam.accionP.subtipoAccion.nombreSubaccion like '%"
						+ subtipoAccion + "'" + "and fam.id.fechaI = " + "(Select max(t.id.fechaI) "
						+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado.size();

	}

	@Override
	public boolean findVacacionActivaByEmpleado(Emp emp, Date fechaActual) {

		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral "
				+ "hl where hl.emp.nced =?1 and ?2 between hl.fechaRige and hl.fechaFin"
				+ " and hl.accionP.subtipoAccion.nombreSubaccion = ?3");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, fechaActual);
		query.setParameter(3, "VACACIONES");
		List<HistoriaLaboral> resultados = null;
		try {
			resultados = query.getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		if (resultados.size() > 0) {
			for (HistoriaLaboral hl : resultados) {
				if (hl.getId().getEstado().compareTo("Anulado") == 0
						|| hl.getId().getEstado().compareTo("Insubsistente") == 0) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean findVacacionActivaByEmpleado(Emp emp, Date fechaActual, Date fechaFin) {

		StringBuilder queryString = new StringBuilder("Select count(hl) from HistoriaLaboral " 
				+ " hl where hl.emp.nced =?1 "
				+ " and (hl.id.estado = 'Legalizado' or hl.id.estado = 'Finalizado') "
				+ " and hl.accionP.subtipoAccion.nombreSubaccion = ?2 and "
				+ " ((?3 between hl.fechaRige and hl.fechaFin) "
				+ " or (?4 between hl.fechaRige and hl.fechaFin)) and "
				+ " hl.id.idHist not in (select histo.id.idHist from HistoriaLaboral histo "
				+ " where (histo.id.estado = 'Anulado' or histo.id.estado = 'Insubsistente') and"
				+ " histo.emp.nced = ?1 and "
				+ " histo.accionP.subtipoAccion.tipoAccion.nombreAccion = ?2 ) ");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "VACACIONES");
		query.setParameter(3, fechaActual);
		query.setParameter(4, fechaFin);
		
		long count = (long) query.getSingleResult();
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean empleadoHasSubrogacionActivaEnFecha(Emp emp, Date fechaActual) {
		StringBuilder queryString = new StringBuilder(
				"SELECT fam from HistoriaLaboral fam" + " where fam.emp.nced= ?1 and fam.id.estado is not ?2 "
						+ "and fam.designacion.tipoDesignacion = ?3 and fam.designacion.estado = ?4 "
						+ "and fam.fechaFin is null ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Ejecucion");
		query.setParameter(3, "SUBROGACION");
		query.setParameter(4, "Ejecucion");
		// query.setParameter(5, fechaActual);
		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No se hallaron resultados");
			return false;

		}
		StringBuilder queryStringTwo = new StringBuilder(
				"Select hl from HistoriaLaboral " + " hl where hl.id.idHist=?1");
		Query queryTwo = getEntityManager().createQuery(queryStringTwo.toString());
		queryTwo.setParameter(1, resultado.getId().getIdHist());
		List<HistoriaLaboral> resultados = queryTwo.getResultList();
		for (HistoriaLaboral hl : resultados) {
			if (hl.getId().getEstado().compareTo("Anulado") == 0
					|| hl.getId().getEstado().compareTo("Insubsistente") == 0) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public List<HistoriaLaboral> getAllDesignacionesActivas(){
		StringBuilder queryString = new StringBuilder("Select hist from " 
				+ " HistoriaLaboral hist where "
				+ " hist.designacion is not null and hist.designacion.estado = 'Ejecucion' "
				+ " and hist.id.estado = 'Finalizado' "
				+ " and hist.id.idHist not in (select fam.id.idHist from HistoriaLaboral fam "
				+ " where (fam.id.estado = 'Anulado' or fam.id.estado = 'Insubsistente')) ");	
		Query query = getEntityManager().createQuery(queryString.toString());
		List<HistoriaLaboral> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public boolean empleadoHasAnyDesignacionActivaOnFecha(Emp emp, Date fechaRige, Date fechaFin) {
		StringBuilder queryString = new StringBuilder("Select count(hist) from " 
				+ "HistoriaLaboral hist where "
				+ "hist.emp.nced=?1 and hist.id.estado=?2 and (hist.accionP.subtipoAccion.idStpa= ?3"
				+ " or hist.accionP.subtipoAccion.tipoAccion.idTpa = ?7) "
				+ "and hist.fechaFin is null and hist.designacion.estado = ?6 "
				+ "and "
				+ " ((?4 between hist.fechaRige and hist.fechaPrevistaFin) "
				+ " or (?5 between hist.fechaRige and hist.fechaPrevistaFin)) and "
				+ " hist.id.idHist not in (select fam.id.idHist from HistoriaLaboral fam "
				+ " where (fam.id.estado = 'Anulado' or fam.id.estado = 'Insubsistente') and"
				+ " fam.emp.nced = ?1 and (fam.accionP.subtipoAccion.idStpa = ?3 "
				+ " or hist.accionP.subtipoAccion.tipoAccion.idTpa = ?7)) ");
		
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Finalizado");
		query.setParameter(3, 6);
		query.setParameter(4, fechaRige);
		query.setParameter(5, fechaFin);
		query.setParameter(6, "Ejecucion");
		query.setParameter(7, 14);
		long count = (long) query.getSingleResult();
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public HistoriaLaboral findLastHistoriaDesignacionByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where hl.id.fechaI ="
				+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where "
				+ "hist.emp.nced=?1 and hist.designacion.estado=?2 and " + "hist.accionP.subtipoAccion.idStpa=?3)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Ejecucion");
		query.setParameter(3, 7);
		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Se capturó la excepción");
		}
		return resultado;
	}

	@Override
	public HistoriaLaboral findCountOfHistoriaDesignacionByDependenciaDesignacion(String nombreDependencia,
			String nombreDesignacion, int idTipoAccionPersonal, String tipoDesignacion) {
		String nombreAccionDePersonal = "";
		if (idTipoAccionPersonal == 7) {
			nombreAccionDePersonal = "DESIGNACION";
		}
		if (idTipoAccionPersonal == 355) {
			nombreAccionDePersonal = "SUBROGACION";
		}

		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral hl " + "where "
				+ "hl.designacion.dependencia.nomDep=?1 "
				+ " and (hl.designacion.estado=?2 or hl.designacion.estado = 'Legalizando') and "
				+ " TRIM(hl.accionP.subtipoAccion.nombreSubaccion) = ?3 "
				+ " and hl.designacion.designacionCatalogo.nombre=?4" + " and hl.designacion.tipoDesignacion =?5 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, nombreDependencia);
		query.setParameter(2, "Ejecucion");
		query.setParameter(3, nombreAccionDePersonal);
		query.setParameter(4, nombreDesignacion.trim());
		query.setParameter(5, tipoDesignacion);
		HistoriaLaboral resultado;

		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
			return resultado;
		} catch (NoResultException e) {
			System.out.println("La designación está libre");
			return null;
		} catch (NonUniqueResultException e) {
			return (HistoriaLaboral) query.getResultList().get(0);
		}
	}

	@Override
	public boolean empleadoHasNombramientosSinFinalizar(Emp emp) {

		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.emp.nced =?1   " + "and fam.id.fechaI="
						+ "(Select max(t.id.fechaI) " + "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
						+ "and t.accionP.subtipoAccion.nombreSubaccion like ?2 " + "and t.id.estado = ?3 "
						+ "and t.id.idHist not in "
						+ "(Select histo.id.idHist from HistoriaLaboral histo where (histo.id.estado = ?4 "
						+ " or histo.id.estado = ?5 or histo.id.estado = ?6 or histo.id.estado = ?7)))");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		query.setParameter(2, "%NOMBRAMIENTO%");
		query.setParameter(3, "Ejecucion");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");
		query.setParameter(6, "\"Finalizado\"");
		query.setParameter(7, "Finalizado");
		List<HistoriaLaboral> resultados = query.getResultList();
		if (resultados.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean empleadoHasNombramientosFinalizar(Emp emp) {

		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.emp.nced =?1   " + "and fam.id.fechaI="
						+ "(Select max(t.id.fechaI) " + "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
						+ "and t.accionP.subtipoAccion.nombreSubaccion like ?2 " + "and t.id.estado = ?3 "
						+ "and t.id.idHist not in "
						+ "(Select histo.id.idHist from HistoriaLaboral histo where (histo.id.estado = ?4 "
						+ " or histo.id.estado = ?5 or histo.id.estado = ?6 or histo.id.estado = ?7)))");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		query.setParameter(2, "%NOMBRAMIENTO%");
		query.setParameter(3, "Ejecucion");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");
		query.setParameter(6, "\"Finalizado\"");
		query.setParameter(7, "Finalizado");
		List<HistoriaLaboral> resultados = query.getResultList();
		if (resultados.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean isEmpleadoOnNombramientoProvisional(Emp emp) {
		HistoriaLaboral recentNombramientoProvisional = this.getMostRecentNombramientoProvisionalByEmp(emp);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date parsed = null;
		try {
			parsed = format.parse("4900/01/31");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (recentNombramientoProvisional != null) {
			if (recentNombramientoProvisional.getFechaFin() == null || 
					recentNombramientoProvisional.getFechaFin().compareTo(parsed)==0) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	@Override
	public boolean isEmpleadoOnDesignacionActiva(Emp emp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.emp.nced =?1 and fam.id.estado='Finalizado'  "
						+ "and fam.accionP.subtipoAccion.nombreSubaccion=?2 " + "and fam.id.fechaI="
						+ "(Select max(t.id.fechaI) " + "from HistoriaLaboral t where t.id.idHist=fam.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		query.setParameter(2, "DESIGNACION");
		List<HistoriaLaboral> resultados = query.getResultList();
		for (HistoriaLaboral resultado : resultados) {
			if (resultado.getDesignacion().getEstado().compareTo("Ejecucion") == 0) {
				return true;
			}

		}

		return false;
	}

	@Override
	public List<HistoriaLaboral> getDesignacionesEmpleadoOnFecha(Emp emp, Date fechaActual) {
		StringBuilder queryString = new StringBuilder("SELECT " + "fam FROM HistoriaLaboral fam where "
				+ "fam.emp.nced =?1 and (fam.id.estado='Finalizado' " + "or fam.id.estado= '\"Finalizado\"') "
				+ " and (fam.designacion.tipoDesignacion=?2 or " + " fam.designacion.tipoDesignacion=?3 or "
				+ "fam.designacion.tipoDesignacion=?4) " + "and fam.id.fechaI=" + "(Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist) and fam.fechaRige<:fechaActual "
				+ "and fam.fechaFin>:fechaActual");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		query.setParameter(2, "DESIGNACION");
		query.setParameter(3, "SUBROGACION");
		query.setParameter(4, "ENCARGO");
		query.setParameter("fechaActual", fechaActual);
		List<HistoriaLaboral> resultados = query.getResultList();
		if (resultados.isEmpty()) {
			return null;
		} else {
			return resultados;
		}
	}

	@Override
	public boolean findCambioAdministrativoActivoByEmpleado(Emp emp, Date fechaRige) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'CAMBIO ADMINISTRATIVO' ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return false;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'CAMBIO ADMINISTRATIVO' "
					+ " and fam.id.estado is not ?2 and fam.fechaFin is null "
					+ " and ?3 between fam.fechaRige and fam.fechaPrevistaFin ");

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, "Ejecucion");
			query.setParameter(3, fechaRige);

			List<HistoriaLaboral> licencias = query.getResultList();
			if (licencias.isEmpty()) {
				return false;
			} else {
				boolean hasLicenciaActiva = false;
				for (HistoriaLaboral licencia : licencias) {

					if (licencia.getId().getEstado().compareTo("Insubsistente") == 0
							|| licencia.getId().getEstado().compareTo("Anulado") == 0) {
						return false;
					} else {
						hasLicenciaActiva = true;
					}
				}
				return hasLicenciaActiva;
			}
		}
	}

	@Override
	public boolean findLicenciaActivaByEmpleado(Emp emp, Date fechaRige) {

		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%' ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return false;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%' "
					+ " and fam.id.estado is not ?2 and fam.fechaFin is null "
					+ " and ?3 between fam.fechaRige and fam.fechaPrevistaFin ");

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, "Ejecucion");
			query.setParameter(3, fechaRige);

			List<HistoriaLaboral> licencias = query.getResultList();
			if (licencias.isEmpty()) {
				return false;
			} else {
				boolean hasLicenciaActiva = false;
				for (HistoriaLaboral licencia : licencias) {

					if (licencia.getId().getEstado().compareTo("Insubsistente") == 0
							|| licencia.getId().getEstado().compareTo("Anulado") == 0
							|| licencia.getAccionP().getSubtipoAccion().getNombreSubaccion()
									.compareTo("LICENCIA POR CUIDADO DEL RECIEN NACIDO") == 0) {
						hasLicenciaActiva = false;
					} else {
						hasLicenciaActiva = true;
					}
				}
				return hasLicenciaActiva;
			}
		}

	}

	@Override
	public boolean isEmpleadoOnComisionActiva(Emp emp, Date fechaRige) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'COMISION DE SERVICIOS%' ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return false;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'COMISION DE SERVICIOS%' "
					+ " and fam.id.estado is not ?2 and fam.fechaFin is null "
					+ " and ?3 between fam.fechaRige and fam.fechaPrevistaFin ");

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, "Ejecucion");
			query.setParameter(3, fechaRige);

			List<HistoriaLaboral> comisionDeServicios = query.getResultList();
			if (comisionDeServicios.isEmpty()) {
				return false;
			} else {
				boolean hasComisionActiva = false;
				for (HistoriaLaboral comisionServicio : comisionDeServicios) {

					if (comisionServicio.getId().getEstado().compareTo("Insubsistente") == 0
							|| comisionServicio.getId().getEstado().compareTo("Anulado") == 0) {
						return false;
					} else {
						hasComisionActiva = true;
					}
				}
				return hasComisionActiva;
			}
		}

	}

	@Override
	public HistoriaLaboral getTipoRelacionNombramientoByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where hl.id.fechaI ="
				+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where "
				+ " hist.emp.nced=?1 and (hist.tipoRelacion.nombreTr = ?2 "
				+ " or hist.tipoRelacion.nombreTr = ?3 or hist.tipoRelacion.nombreTr=?4)) and "
				+ "hl.emp.nced=?1 and (hl.tipoRelacion.nombreTr = ?2 "
				+ " or hl.tipoRelacion.nombreTr = ?3 or hl.tipoRelacion.nombreTr=?4)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "NOMBRAMIENTO");
		query.setParameter(3, "NOMBRAMIENTO ACCIDENTAL");
		query.setParameter(4, "NOMBRAMIENTO REGULAR");

		HistoriaLaboral resultado = null;
		List<HistoriaLaboral> resultados = query.getResultList();
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			return resultados.get(0);
		}

		return resultado;
	}

	@Override
	public boolean isEmpleadoConNombramiento(Emp emp) {

		HistoriaLaboral nombramientoMasReciente = this.getMostRecentCualquierNombramientoByEmp(emp);
		HistoriaLaboral nombramientoTipoRelacion = this.getTipoRelacionNombramientoByEmp(emp);
		boolean hasNombramientoReciente = false;
		boolean hasNombramientoTipoRelacion = false;
		if (nombramientoMasReciente == null && nombramientoTipoRelacion == null) {
			return false;
		} else {
			Date parsed;
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				parsed = format.parse("4900/01/31");
			} catch (ParseException pe) {
				throw new IllegalArgumentException(pe);
			}
			if (nombramientoMasReciente != null) {
				if (nombramientoMasReciente.getFechaFin() != null) {
					if (nombramientoMasReciente.getFechaFin().before(parsed)) {
						hasNombramientoReciente = false;
					}
				} else {
					hasNombramientoReciente = true;
				}
			}
			if (nombramientoTipoRelacion != null) {
				if (nombramientoTipoRelacion.getFechaFin() != null) {
					if (nombramientoTipoRelacion.getFechaFin().before(parsed)) {
						hasNombramientoTipoRelacion = false;
					}
				} else {
					hasNombramientoTipoRelacion = true;
				}
			}

			if (hasNombramientoTipoRelacion || hasNombramientoReciente) {
				return true;
			} else {
				StringBuilder queryString = new StringBuilder(
						"Select hl " + "from HistoriaLaboral " + "hl where hl.id.idHist = ?1");
				Query query = getEntityManager().createQuery(queryString.toString());
				if (nombramientoMasReciente != null) {
					query.setParameter(1, nombramientoMasReciente.getId().getIdHist());
					List<HistoriaLaboral> resultados = query.getResultList();

					for (HistoriaLaboral historia : resultados) {
						if (historia.getId().getEstado().compareTo("Insubsistente") == 0
								|| historia.getId().getEstado().compareTo("Anulado") == 0) {
							hasNombramientoReciente = false;
						}
					}
					hasNombramientoReciente = true;
				}

				StringBuilder queryString2 = new StringBuilder(
						"Select hl " + "from HistoriaLaboral " + "hl where hl.id.idHist = ?1");
				query = getEntityManager().createQuery(queryString2.toString());
				if (nombramientoTipoRelacion != null) {
					query.setParameter(1, nombramientoTipoRelacion.getId().getIdHist());
					List<HistoriaLaboral> resultados2 = query.getResultList();

					for (HistoriaLaboral historia : resultados2) {
						if (historia.getId().getEstado().compareTo("Insubsistente") == 0
								|| historia.getId().getEstado().compareTo("Anulado") == 0) {
							hasNombramientoTipoRelacion = false;
						}
					}
					hasNombramientoTipoRelacion = true;
				}

				if (hasNombramientoTipoRelacion || hasNombramientoReciente) {
					return true;
				} else {
					return false;
				}
			}

		}

	}

	@Override
	public Boolean isHistoriaElaborado() {
		StringBuilder queryString = new StringBuilder("SELECT " + "count(fam) FROM HistoriaLaboral fam where "
				+ "fam.id.estado ='Ejecucion' and fam.id.fechaI = " + "(Select max(t.id.fechaI) "
				+ "from HistoriaLaboral" + " t where t.id.idHist=fam.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());
		long resultado = (long) query.getSingleResult();
		if (resultado > 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean findAnioSabaticoActivoByEmpleado(Emp emp, Date fechaActual) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral "
				+ "hl where hl.emp.nced =?1 and ?2 between hl.fechaRige and hl.fechaFin"
				+ " and (hl.accionP.subtipoAccion.nombreSubaccion = ?3"
				+ " or hl.accionP.subtipoAccion.nombreSubaccion = ?4)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, fechaActual);
		query.setParameter(3, "PERIODO SABATICO");
		query.setParameter(4, "ANIO SABATICO");
		List<HistoriaLaboral> resultados = null;
		try {
			resultados = query.getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		if (resultados.size() > 0) {
			for (HistoriaLaboral hl : resultados) {
				if (hl.getId().getEstado().compareTo("Anulado") == 0
						|| hl.getId().getEstado().compareTo("Insubsistente") == 0) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}

	}

	@Override
	public HistoriaLaboral getMostRecentNombramientoProvisionalByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral hl where hl.emp.nced=?1"
				+ " and hl.id.estado=?3 and hl.accionP.subtipoAccion.nombreSubaccion like ?2 and hl.id.fechaI ="
				+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where "
				+ "hist.emp.nced=?1 and hist.accionP.subtipoAccion.nombreSubaccion like ?2 " + "and hist.id.estado=?3 "
				+ "and hist.id.idHist not in "
				+ "(Select histo.id.idHist from HistoriaLaboral histo where (histo.id.estado = ?4 "
				+ " or histo.id.estado = ?5)))");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "NOMBRAMIENTO PROVISIONAL%");
		query.setParameter(3, "Finalizado");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");

		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No tiene nombramiento provisional el empleado");
		}

		return resultado;
	}

	@Override
	public HistoriaLaboral getMostRecentNombramientoByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where hl.id.fechaI ="
				+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where "
				+ " hist.emp.nced=?1 and TRIM(hist.accionP.subtipoAccion.nombreSubaccion) like ?2"
				+ " and hist.id.estado=?3 "
				+ " and hist.accionP is not null and hist.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ " where histo.emp.nced=?1 and (histo.id.estado= ?4 or histo.id.estado=?5) order by hist.fechaRige desc))"
				+ " and hl.emp.nced = ?1 and TRIM(hl.accionP.subtipoAccion.nombreSubaccion) like ?2 and "
				+ " (hl.fechaFin = '4900/01/31' or hl.fechaFin is null) ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "NOMBRAMIENTO%");
		query.setParameter(3, "Finalizado");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");

		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Se capturó la excepción");
		} catch (NonUniqueResultException e) {
			System.out.println("Hay mas de un nombramiento activo, tomando el más actual");
			List<HistoriaLaboral> resultados = query.getResultList();
			return resultados.get(0);
		}

		return resultado;
	}

	public HistoriaLaboral getMostRecentNombramientoFinalizadoByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where hl.id.fechaI ="
				+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where "
				+ " hist.emp.nced=?1 and TRIM(hist.accionP.subtipoAccion.nombreSubaccion) like ?2"
				+ " and hist.id.estado=?3 "
				+ " and hist.accionP is not null and hist.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ " where histo.emp.nced=?1 and (histo.id.estado= ?4 or histo.id.estado=?5) order by hist.fechaRige desc))"
				+ " and hl.emp.nced = ?1 and TRIM(hl.accionP.subtipoAccion.nombreSubaccion) like ?2 "
				+ " and hl.fechaFin is not null ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "NOMBRAMIENTO%");
		query.setParameter(3, "Finalizado");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");

		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Se capturó la excepción");
		} catch (NonUniqueResultException e) {
			System.out.println("Hay mas de un nombramiento activo, tomando el más actual");
			List<HistoriaLaboral> resultados = query.getResultList();
			return resultados.get(0);
		}

		return resultado;
	}

	private HistoriaLaboral getMostRecentCualquierNombramientoByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + " hl where hl.fechaRige ="
				+ "(Select max(hist.fechaRige) from HistoriaLaboral hist where "
				+ " hist.emp.nced=?1 and TRIM(hist.accionP.subtipoAccion.nombreSubaccion) like ?2 "
				+ " and hist.id.estado=?3 "
				+ " and hist.accionP is not null and hist.id.idHist not in (Select histo.id.idHist "
				+ " from HistoriaLaboral histo "
				+ " where histo.emp.nced=?1 and (histo.id.estado= ?4 or histo.id.estado=?5)"
				+ " and histo.accionP.subtipoAccion.nombreSubaccion like ?2 ))"
				+ " and hl.emp.nced = ?1 and TRIM(hl.accionP.subtipoAccion.nombreSubaccion) like ?2 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "NOMBRAMIENTO%");
		query.setParameter(3, "Finalizado");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");

		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Se capturó la excepción");
		} catch (NonUniqueResultException e) {
			System.out.println("Hay mas de un nombramiento activo, tomando el más actual");
			List<HistoriaLaboral> resultados = query.getResultList();
			return resultados.get(0);
		}

		return resultado;
	}

	@Override
	public boolean hasNombramientoActivoByEmpleado(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where hl.id.fechaI ="
				+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where "
				+ "hist.emp.nced=?1 and hist.accionP.subtipoAccion.tipoAccion.nombreAccion like ?2" + ")"
				+ "and hl.emp.nced= ?1 and hl.accionP.subtipoAccion.nombreSubaccion.tipoAccion.nombreAccion like ?2"
				+ " and hl.id.estado=?3 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "NOMBRAMIENTO%");
		query.setParameter(3, "Finalizado");

		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {

			return false;
		}
		Date parsed;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			parsed = format.parse("4900/01/31");
		} catch (ParseException pe) {
			throw new IllegalArgumentException(pe);
		}
		if (resultado.getFechaFin() != null) {
			if (resultado.getFechaFin().before(parsed)) {
				return false;
			}
		} else {
			return true;
		}

		StringBuilder queryStringTwo = new StringBuilder(
				"Select hl from HistoriaLaboral hl " + " where hl.id.idHist = ?1");

		Query queryTwo = getEntityManager().createQuery(queryStringTwo.toString());
		queryTwo.setParameter(1, resultado.getId().getIdHist());

		List<HistoriaLaboral> resultados = queryTwo.getResultList();
		for (HistoriaLaboral historia : resultados) {
			if (historia.getId().getEstado().compareTo("Insubsistente") == 0
					|| historia.getId().getEstado().compareTo("Anulado") == 0) {
				return false;
			}

		}
		return true;

	}

	@Override
	public boolean isAccionPorFinalizar(String nombreAccion, Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " 
				+ "hl where hl.id.fechaI ="
				+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where " 
				+ "hist.emp.nced=?1"
				+ " and hist.accionP.subtipoAccion.tipoAccion.nombreAccion like ?2" 
				+ " and hist.id.estado=?3)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, nombreAccion + "%");
		if (nombreAccion.compareTo("VACACIONES") != 0) {
			query.setParameter(3, "Ejecucion");
		} else {
			query.setParameter(3, "Elaborado");
		}

		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Se capturó la excepción");
			return false;
		}
		StringBuilder queryStringTwo = new StringBuilder(
				"Select hl from HistoriaLaboral hl " + " where hl.id.idHist = ?1");

		Query queryTwo = getEntityManager().createQuery(queryStringTwo.toString());
		queryTwo.setParameter(1, resultado.getId().getIdHist());

		List<HistoriaLaboral> resultados = queryTwo.getResultList();
		for (HistoriaLaboral historia : resultados) {
			if (historia.getId().getEstado().compareTo("Insubsistente") == 0
					|| historia.getId().getEstado().compareTo("Anulado") == 0
					|| historia.getId().getEstado().compareTo("Finalizado") == 0) {
				return false;
			}

		}
		return true;
	}

	@Override
	public boolean isAnyAccionPorFinalizar(Emp emp) {
		StringBuilder queryString = new StringBuilder("SELECT " + "fam FROM HistoriaLaboral fam where "
				+ "fam.id.estado ='Ejecucion' and fam.emp.nced=?1 and fam.id.fechaI = " + "(Select max(t.id.fechaI) "
				+ "from HistoriaLaboral" + " t where t.id.idHist=fam.id.idHist and t.emp.nced=?1 " + ""
				+ "and t.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ "where histo.emp.nced=?1 and (histo.id.estado= ?2 or histo.id.estado=?3)))");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Anulado");
		query.setParameter(3, "Insubsistente");
		List<HistoriaLaboral> resultado = query.getResultList();
		if (!resultado.isEmpty())
			return true;
		else
			return false;

	}

	@Override
	public boolean findAnioSabaticoActivoByEmpleado(Emp emp, Date fechaRige, Date fechaFin) {
		StringBuilder queryString = new StringBuilder("Select count(hl) from HistoriaLaboral "
				+ " hl where hl.emp.nced =?1 and hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?2 "
				+ " and hl.id.estado = ?3 "
				+ " and hl.fechaFin is null " 
				+ " and ((?4 between hl.fechaRige and hl.fechaPrevistaFin) or"
				+ " (?5 between hl.fechaRige and hl.fechaPrevistaFin)) "
				+ " and "
				+ " hl.id.idHist not in (select histo.id.idHist from HistoriaLaboral histo "
				+ " where (histo.id.estado = 'Anulado' or histo.id.estado = 'Insubsistente') and "
				+ " histo.emp.nced = ?1 and "
				+ " histo.accionP.subtipoAccion.tipoAccion.nombreAccion = ?2)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "ANIO SABATICO");
		query.setParameter(3, "Finalizado");
		query.setParameter(4, fechaRige);
		query.setParameter(5, fechaFin);
		long count = (long) query.getSingleResult();
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean findLicenciaActivaByEmpleado(Emp emp, Date fechaRige, Date fechaFin) {

		StringBuilder queryRefactored = new StringBuilder("SELECT count(fam) from HistoriaLaboral fam "
				+ " where fam.emp.nced = ?1 and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%' "
				+ " and ((?2 between fam.fechaRige and fam.fechaPrevistaFin ) or"
				+ " (?3 <= fam.fechaPrevistaFin)) "
				+ " and fam.fechaFin is null and "
				+ "(trim(fam.id.estado) = 'Legalizado' or (fam.id.estado) ='Finalizado') "
				+ " and fam.id.idHist not in (Select hl.id.idHist from HistoriaLaboral hl "
				+ " where hl.accionP.subtipoAccion.nombreSubaccion = 'LICENCIA POR CUIDADO DEL RECIEN NACIDO' "
				+ " and hl.emp.nced = ?1) and "
				+ " fam.id.idHist not in (select histo.id.idHist from HistoriaLaboral histo "
				+ " where (histo.id.estado = 'Anulado' or histo.id.estado = 'Insubsistente') and "
				+ " histo.emp.nced = ?1 and "
				+ " histo.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%') ");

		Query firstQuery = getEntityManager().createQuery(queryRefactored.toString());
		firstQuery.setParameter(1, emp.getNced());
		firstQuery.setParameter(2, fechaRige);
		firstQuery.setParameter(3, fechaFin);

		long conteo = (long) firstQuery.getSingleResult();
		if (conteo == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isEmpleadoOnComisionActiva(Emp emp, Date fechaRige, Date fechaFin) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'COMISION DE SERVICIOS%' ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return false;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'COMISION DE SERVICIOS%' "
					+ "and (?2 between fam.fechaRige and fam.fechaPrevistaFin  or ?3 "
					+ "between fam.fechaRige and fam.fechaPrevistaFin) and fam.fechaFin is null and "
					+ "fam.id.estado is not ?4");
			//

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, fechaRige);
			query.setParameter(3, fechaFin);
			query.setParameter(4, "Ejecucion");
			List<HistoriaLaboral> comisiones = query.getResultList();
			if (comisiones.isEmpty()) {
				return false;
			} else {
				boolean hasComisionActiva = false;
				for (HistoriaLaboral comision : comisiones) {

					if (comision.getId().getEstado().compareTo("Insubsistente") == 0
							|| comision.getId().getEstado().compareTo("Anulado") == 0) {
						return false;
					} else {
						hasComisionActiva = true;
					}
				}
				return hasComisionActiva;
			}
		}
	}

	@Override
	public Integer getMaxNroDocumentoByYear(Integer year) {
		// Calcula el numero de documento basandose en el último número de la
		// última historia
		// laboral que también sea una acción de personal (Excluye contratos)
		StringBuilder queryString = new StringBuilder("SELECT fam FROM HistoriaLaboral " + " fam where fam.id.idHist="
				+ "(Select max(hist.id.idHist) from HistoriaLaboral hist " + " "
				+ " where year(hist.id.fechaI) =?1 and hist.id.fechaI<  ?2 "
				+ "and hist.accionP.id.idAccionp IS NOT NULL and hist.id.idHist not in (Select hl.id.idHist from HistoriaLaboral "
				+ "hl " + "where hl.id.estado='Registrado'" + "))" + "" + "  ");

		Query query = getEntityManager().createQuery(queryString.toString());
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		query.setParameter(1, year);
		query.setParameter(2, dt);

		List<HistoriaLaboral> resultado = query.getResultList();
		if (resultado.size() <= 0) {
			return 1;
		} else {

			for (HistoriaLaboral hl : resultado) {
				if (hl.getNroDocumento() != null) {
					String[] tokensNroDocumento = hl.getNroDocumento().split("-");
					int nroDocumento = Integer.parseInt(tokensNroDocumento[0]);
					nroDocumento++;
					return nroDocumento;
				}
			}
			return 1;

		}
	}

	@Override
	public boolean findEncargoActivoByEmpleado(Emp emp, Date fechaActual, Date fechaFin) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where hl.id.fechaI ="
				+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where "
				+ "hist.emp.nced=?1 and hist.id.estado=?2 and " + "hist.accionP.subtipoAccion.idStpa=?3 "
				+ " and ((?4 between hl.fechaRige and hl.fechaPrevistaFin) "
				+ " or (?5 between hl.fechaRige and hl.fechaPrevistaFin) and"
				+ " hl.fechaFin is null and hl.id.estado is not ?6))");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Finalizado");
		query.setParameter(3, 14);
		query.setParameter(4, fechaActual);
		query.setParameter(5, fechaFin);
		query.setParameter(6, "Ejecucion");
		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No se hallaron resultados");
			return false;

		}
		StringBuilder queryStringTwo = new StringBuilder(
				"Select hl from HistoriaLaboral " + " hl where hl.id.idHist=?1");
		Query queryTwo = getEntityManager().createQuery(queryStringTwo.toString());
		queryTwo.setParameter(1, resultado.getId().getIdHist());
		List<HistoriaLaboral> resultados = queryTwo.getResultList();
		for (HistoriaLaboral hl : resultados) {
			if (hl.getId().getEstado().compareTo("Anulado") == 0
					|| hl.getId().getEstado().compareTo("Insubsistente") == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean findEncargoActivoByEmpleado(Emp emp, Date fechaActual) {

		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " 
				+ "hl where hl.id.fechaI ="
				+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where "
				+ "hist.emp.nced=?1 and hist.id.estado=?2 and " + "hist.accionP.subtipoAccion.idStpa=?3"
				+ " and ?4 between hist.fechaRige and hist.fechaFin)");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Finalizado");
		query.setParameter(3, 27);
		query.setParameter(4, fechaActual);
		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No se hallaron resultados");
			return false;

		}
		StringBuilder queryStringTwo = new StringBuilder(
				"Select hl from HistoriaLaboral " + " hl where hl.id.idHist=?1");
		Query queryTwo = getEntityManager().createQuery(queryStringTwo.toString());
		queryTwo.setParameter(1, resultado.getId().getIdHist());
		List<HistoriaLaboral> resultados = queryTwo.getResultList();
		for (HistoriaLaboral hl : resultados) {
			if (hl.getId().getEstado().compareTo("Anulado") == 0
					|| hl.getId().getEstado().compareTo("Insubsistente") == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public long findCountAccionesNoLicenciaFinalizables(Emp emp) {
		long count = 0;
		StringBuilder queryString = new StringBuilder(
				"" + "SELECT count(t) from HistoriaLaboral t where t.id.fechaI in "
						+ "(SELECT max(fam.id.fechaI) FROM HistoriaLaboral fam where " + " fam.emp.nced = ?1 "
						+ "and (fam.accionP.subtipoAccion.nombreSubaccion like ?2 "
						+ "or fam.accionP.subtipoAccion.nombreSubaccion like ?3 "
						+ "or fam.accionP.subtipoAccion.nombreSubaccion like ?4 "
						+ "or fam.accionP.subtipoAccion.nombreSubaccion like ?5 )"
						+ "and (fam.id.estado <> ?6 and fam.id.estado <> ?7 and fam.id.estado <> ?8) "
						+ "and (fam.designacion.estado <> ?9 and fam.designacion.estado <> ?10"
						+ " and fam.designacion.estado <> ?10) and t.emp.nced = ?1" + " group by fam.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		query.setParameter(2, "DESIGNACION%");
		query.setParameter(3, "ENCARGO%");
		query.setParameter(4, "SUBROGACION%");
		query.setParameter(5, "POSESION%");
		query.setParameter(6, "Anulado");
		query.setParameter(7, "Insubsistente");
		query.setParameter(8, "Ejecucion");
		query.setParameter(9, "Terminado");
		query.setParameter(10, "Finalizando");

		count = (long) query.getSingleResult();

		return count;
	}

	@Override
	public List<HistoriaLaboral> findAccionesNoLicenciaFinalizables(Emp emp) {
		StringBuilder queryString = new StringBuilder("" + " SELECT t from HistoriaLaboral t where t.id.fechaI in ( "
				+ " SELECT max(fam.id.fechaI) FROM HistoriaLaboral fam where "
				+ " fam.emp.nced = ?1 and (fam.accionP.subtipoAccion.nombreSubaccion like ?2 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion like ?3 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion like ?4 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion like ?5 )"
				+ "and (fam.id.estado <> ?6 and fam.id.estado <> ?7 and fam.id.estado <> ?8) "
				+ "and (fam.designacion.estado <> ?9 and fam.designacion.estado <> ?10"
				+ " and fam.designacion.estado <> ?11) " + " and t.emp.nced = ?1 group by fam.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		query.setParameter(2, "DESIGNACION%");
		query.setParameter(3, "ENCARGO%");
		query.setParameter(4, "SUBROGACION%");
		query.setParameter(5, "POSESION%");
		query.setParameter(6, "Anulado");
		query.setParameter(7, "Insubsistente");
		query.setParameter(8, "Ejecucion");
		query.setParameter(9, "Terminado");
		query.setParameter(10, "Anulado");
		query.setParameter(11, "Finalizando");
		List<HistoriaLaboral> resultados = query.getResultList();

		StringBuilder queryString2 = new StringBuilder("SELECT " + "fam FROM HistoriaLaboral fam where "
				+ " fam.emp.nced = ?1 " + "and fam.accionP.subtipoAccion.nombreSubaccion like ?2 "
				+ " and fam.fechaFin is null " + "and fam.id.estado =?3");
		query = getEntityManager().createQuery(queryString2.toString());

		query.setParameter(1, emp.getNced());
		query.setParameter(2, "CAMBIO ADMINISTRATIVO%");
		query.setParameter(3, "Finalizado");

		resultados.addAll(query.getResultList());

		return resultados;

	}

	@Override
	public HistoriaLaboral findHistoriaByNroDocumentoEmpYEstado(Emp emp, String nroDocumento, String estado) {
		StringBuilder queryString;
		boolean isFinalizado = false;
		if (estado.compareTo("Finalizado") == 0 || estado.compareTo("Legalizado")==0 
				|| estado.compareTo("Legalizada")==0 || estado.compareTo("Registrado")==0) {
			queryString = new StringBuilder("Select hist from HistoriaLaboral hist "
					+ "where hist.emp.nced= ?1 and trim(hist.nroDocumento) = ?2 and "
					+ "hist.id.fechaI in (Select max(histo.id.fechaI) from HistoriaLaboral histo "
					+ " where histo.emp.nced=?1 and trim(histo.nroDocumento)=?2"
					+ " and hist.id.idHist=histo.id.idHist and"
					+ " (trim(histo.id.estado)=?3 or trim(histo.id.estado)='Registrado' or trim(histo.id.estado)='Legalizado' or trim(histo.id.estado)='Legalizada' "
					+ "or trim(histo.id.estado) = 'Elaborado')) "
					+ "and hist.id.idHist not in (Select i.id.idHist from HistoriaLaboral i where (i.id.estado = 'Anulado' or i.id.estado='Duplicado') and i.emp.nced=?1)"
					+ "order by hist.id.fechaI desc ");
			isFinalizado=true;
		} else {
			queryString = new StringBuilder(" Select hist from HistoriaLaboral hist "
					+ " where hist.emp.nced= ?1 and trim(hist.nroDocumento) = ?2 and "
					+ " hist.id.fechaI in (Select max(histo.id.fechaI) from HistoriaLaboral histo "
					+ " where histo.emp.nced=?1 and trim(histo.nroDocumento)=?2"
					+ " and hist.id.idHist=histo.id.idHist and"
					+ " (trim(histo.id.estado)= 'Ejecucion' or trim(histo.id.estado)='Elaborado' or trim(histo.id.estado)='Elaborada' )) "
					+ " and hist.id.idHist not in (Select i.id.idHist from HistoriaLaboral i where (i.id.estado = 'Anulado' or i.id.estado='Duplicado') and i.emp.nced=?1)"
					+ " order by hist.id.fechaI desc ");
		}

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, nroDocumento.trim());
		if(isFinalizado){
			query.setParameter(3, estado);
		}
		
		HistoriaLaboral resultado = null;

		try {

			resultado = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			// e.printStackTrace();
			System.out.println("No estado: " + estado);
		} catch (NonUniqueResultException e) {
			List<HistoriaLaboral> resultados = query.getResultList();
			System.out.println("Multiples resultados");
			return resultados.get(0);

		}

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getAnyDesignacionActivaByEmpFinalizacion(Emp emp, String nroDocumentoAFinalizar) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and ( hl.designacion.estado = ?2  or hl.designacion.estado = 'Finalizando' )"
				+ "and hl.id.estado = ?3 "
				+ "and hl.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ "where histo.emp.nced=?1 and (histo.id.estado= ?4 or histo.id.estado=?5))"
				+ "and hl.nroDocumento not like ?6 and (hl.accionP.subtipoAccion.nombreSubaccion like ?7 "
				+ " or hl.accionP.subtipoAccion.nombreSubaccion like ?8 "
				+ " or hl.accionP.subtipoAccion.nombreSubaccion like ?9 "
				+ " or hl.accionP.subtipoAccion.nombreSubaccion like ?10) ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Ejecucion");
		query.setParameter(3, "Finalizado");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");
		query.setParameter(6, "%" + nroDocumentoAFinalizar + "%");
		query.setParameter(7, "DESIGNACION%");
		query.setParameter(8, "POSESION%");
		query.setParameter(9, "SUBROGACION%");
		query.setParameter(10, "ENCARGO%");
		List<HistoriaLaboral> resultados = query.getResultList();
		List<HistoriaLaboral> resultadosSinDuplicados = new ArrayList<>();
		Designacion designacionAnterior = new Designacion();
		for (HistoriaLaboral historia : resultados) {
			if (!historia.getDesignacion().equals(designacionAnterior)) {
				resultadosSinDuplicados.add(historia);
			}
			designacionAnterior = historia.getDesignacion();
		}

		return resultadosSinDuplicados;
	}

	@Override
	public List<HistoriaLaboral> getDesignacionesActivasByEmpFinalizacion(Emp emp, String nroDocumentoAFinalizar) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and ( hl.designacion.estado = ?2  or hl.designacion.estado = 'Finalizando' )"
				+ "and hl.id.estado = ?3 "
				+ "and hl.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ "where histo.emp.nced=?1 and (histo.id.estado= ?4 or histo.id.estado=?5))"
				+ "and hl.nroDocumento not like ?6 and (hl.accionP.subtipoAccion.nombreSubaccion like ?7 "
				+ " or hl.accionP.subtipoAccion.nombreSubaccion like ?8)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Ejecucion");
		query.setParameter(3, "Finalizado");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");
		query.setParameter(6, "%" + nroDocumentoAFinalizar + "%");
		query.setParameter(7, "DESIGNACION%");
		query.setParameter(8, "POSESION%");
		List<HistoriaLaboral> resultados = query.getResultList();
		List<HistoriaLaboral> resultadosSinDuplicados = new ArrayList<>();
		Designacion designacionAnterior = new Designacion();
		for (HistoriaLaboral historia : resultados) {
			if (!historia.getDesignacion().equals(designacionAnterior)) {
				resultadosSinDuplicados.add(historia);
			}
			designacionAnterior = historia.getDesignacion();
		}

		return resultadosSinDuplicados;
	}

	@Override
	public boolean empleadoHasAnyTipoDesginacionActiva(String tipoDesignacion, Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral hl where hl.emp.nced = ?1 "
				+ "and hl.designacion.estado = ?2 " + "and hl.designacion.tipoDesignacion = ?3 ");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Ejecucion");
		query.setParameter(3, tipoDesignacion);

		List<HistoriaLaboral> resultados;

		resultados = query.getResultList();
		if (resultados.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean empleadoHasAnyLicenciaActiva(Emp emp, String tipoDeLicencia) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like ?2 ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		firstQuery.setParameter(2, "LICENCIA%");
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return false;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and fam.accionP.subtipoAccion.nombreSubaccion like ?2 "
					+ "and fam.fechaFin is NULL and (fam.id.estado is ?3 or fam.id.estado = 'Legalizado' or fam.id.estado = 'Legalizada') "
					+ "and fam.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
					+ "where histo.emp.nced=?1 and (histo.id.estado= ?4 or histo.id.estado=?5) "
					+ "and  histo.accionP.subtipoAccion.nombreSubaccion like ?2) "
					+ "and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%' "
					+ "and fam.fechaRige >= '01/01/2014'");

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, tipoDeLicencia);
			query.setParameter(3, "Finalizado");
			query.setParameter(4, "Anulado");
			query.setParameter(5, "Insubsistente");

			List<HistoriaLaboral> licencias = query.getResultList();

			if (licencias.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}
	}

	@Override
	public boolean empleadoHasAnyLicenciaActiva(Emp emp) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%' ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return false;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like ?2 "
					+ "and  fam.fechaFin is NULL and (fam.id.estado = ?3 or fam.id.estado = ?4 ) "
					+ "and fam.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
					+ "where histo.id.estado= ?5 or histo.id.estado=?6)");

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, "LICENCIA");
			query.setParameter(3, "Legalizado");
			query.setParameter(4, "Legalizada");
			query.setParameter(5, "Anulado");
			query.setParameter(6, "Insubsistente");
			List<HistoriaLaboral> licencias = query.getResultList();
			if (licencias.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}
	}
	// Get Licencias Activas

	@Override
	public List<HistoriaLaboral> getLicenciasActivasByEmpleado(Emp emp) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and (fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%' "
				+ " or fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'PERMISO')");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return firstResult;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and ("
					+ " fam.accionP.subtipoAccion.nombreSubaccion like ?2 or"
					+ " fam.accionP.subtipoAccion.nombreSubaccion like 'ESTUDIOS REGULARES' or "
					+ " fam.accionP.subtipoAccion.nombreSubaccion like 'CUIDADO DE FAMILIARES CON DISCAPACIDADES SEVERAS O ENFERMEDADES CATASTROFICAS') "
					+ " and fam.fechaFin is NULL and (fam.id.estado is ?3 or fam.id.estado is 'Legalizada' or "
					+ " fam.id.estado is 'Finalizado') " + "and fam.fechaRige >= '01/01/2014' "
					+ " and fam.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
					+ " where histo.emp.nced=?1 " + " and (histo.id.estado= ?4 or histo.id.estado=?5) "
					+ " and  histo.accionP.subtipoAccion.nombreSubaccion like ?2"
					+ " and histo.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%')"
					+ " and fam.id.idHist not in (Select hist.id.idHist from HistoriaLaboral hist "
					+ " where hist.emp.nced =?1 and numeroDocAFinalizar is not null "
					+ " and (hist.accionP.subtipoAccion.nombreSubaccion like 'FINALIZACION DE LICENCIA%'"
					+ " or hist.accionP.subtipoAccion.nombreSubaccion like 'REINTEGRO%'))");

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, "LICENCIA%");
			query.setParameter(3, "Legalizado");
			query.setParameter(4, "Anulado");
			query.setParameter(5, "Insubsistente");
			List<HistoriaLaboral> licencia = null;

			licencia = query.getResultList();

			return licencia;
		}

	}

	public long getCountLicenciasVencidas() {
		Date currentDate = new Date();
		StringBuilder queryString = new StringBuilder("SELECT count(fam) from HistoriaLaboral fam where "
				+ "fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?1 "
				+ "and fam.accionP.subtipoAccion.nombreSubaccion like ?2 "
				+ "and fam.fechaFin is NULL and (fam.id.estado is ?3 or fam.id.estado is 'Legalizada' or "
				+ " fam.id.estado is 'Finalizado' ) " + "and fam.fechaRige >= '01/01/2014' "
				+ "and fam.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ "where (histo.id.estado= ?4 or histo.id.estado=?5) "
				+ " and  histo.accionP.subtipoAccion.nombreSubaccion like ?2"
				+ " and histo.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%' "
				+ " )and fam.fechaPrevistaFin <= ?6 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "LICENCIA");
		query.setParameter(2, "LICENCIA%");
		query.setParameter(3, "Legalizado");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");
		query.setParameter(6, currentDate);

		long count = (long) query.getSingleResult();

		return count;
	}

	public List<HistoriaLaboral> getAllLicenciasVencidas() {

		Date currentDate = new Date();
		StringBuilder queryString = new StringBuilder(
				"SELECT fam from HistoriaLaboral fam where (fam.accionP.subtipoAccion.tipoAccion.nombreAccion like ?1 "
						+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'PERMISO' )"
						+ "and fam.fechaFin is NULL and (fam.id.estado is ?3 or fam.id.estado is 'Legalizada' or "
						+ " fam.id.estado is 'Finalizado' ) " + "and fam.fechaRige >= '01/01/2014' "
						+ "and fam.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
						+ "where (histo.id.estado= ?4 or histo.id.estado=?5) "
						+ " and (histo.accionP.subtipoAccion.tipoAccion.nombreAccion like 'LICENCIA%' "
						+ " or histo.accionP.subtipoAccion.tipoAccion.nombreAccion like 'PERMISO') "
						+ " and fam.fechaPrevistaFin <= ?6 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "LICENCIA");
		query.setParameter(2, "LICENCIA%");
		query.setParameter(3, "Legalizado");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");
		query.setParameter(6, currentDate);
		List<HistoriaLaboral> licencia = null;

		licencia = query.getResultList();

		return licencia;

	}

	@Override
	public boolean isAccionInsubsistida(Emp emp, String numeroDocumentoAccion) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and " + "fam.nroDocumento =?2 and fam.id.estado= ?3");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		firstQuery.setParameter(2, numeroDocumentoAccion);
		firstQuery.setParameter(3, "INSUBSISTENTE");
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public HistoriaLaboral getLicenciaPorEstudiosActivaByEmpleado(Emp emp) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and (fam.accionP.subtipoAccion.nombreSubaccion "
				+ "like 'LICENCIA CON REMUNERACION%') ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return null;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and fam.accionP.subtipoAccion.nombreSubaccion  like 'LICENCIA CON REMUNERACION%' "
					+ "and  fam.fechaFin is NULL and (fam.id.estado = ?2 or fam.id.estado = 'Legalizado' or fam.id.estado ='Legalizada') "
					+ " and fam.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
					+ "where histo.emp.nced=?1 and (histo.id.estado= ?3 or histo.id.estado=?4)"
					+ "and histo.accionP.subtipoAccion.nombreSubaccion like 'LICENCIA CON REMUNERACION%')");
			//

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, "Finalizado");
			query.setParameter(3, "Anulado");
			query.setParameter(4, "Insubsistente");
			HistoriaLaboral licencia = null;
			try {
				licencia = (HistoriaLaboral) query.getSingleResult();
			} catch (NoResultException e) {
				System.out.println("El empleado no tiene licencias por estudios activas");
				return null;

			} catch (NonUniqueResultException e) {
				e.printStackTrace();
				return null;
			}
			return licencia;
		}
	}

	@Override
	public HistoriaLaboral getAnioPeriodoSabaticoActivoByEmpleado(Emp emp) {

		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and fam.accionP.subtipoAccion.tipoAccion.nombreAccion " + "like '%SABATICO' ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return null;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and fam.accionP.subtipoAccion.tipoAccion.nombreAccion like '%SABATICO' "
					+ "and  fam.fechaFin is NULL and fam.id.estado = ?2"
					+ " and fam.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
					+ "where histo.emp.nced=?1 and (histo.id.estado= ?3 or histo.id.estado=?4))");
			//

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, "Finalizado");
			query.setParameter(3, "Anulado");
			query.setParameter(4, "Insubsistente");
			HistoriaLaboral licencia = null;
			try {
				licencia = (HistoriaLaboral) query.getSingleResult();
			} catch (NoResultException e) {
				System.out.println("El empleado no posee periodos sabáticos activos");
				return null;

			} catch (NonUniqueResultException e) {
				e.printStackTrace();
				return null;
			}
			return licencia;
		}
	}

	@Override
	public HistoriaLaboral findHistoriaByIdDesignacion(int idDesignacion) {

		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.designacion.idDesignacion = ?1 and fam.id.estado = ?2 "
				+ "and fam.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ "where histo.id.estado= ?3 or histo.id.estado=?4) order by fam.fechaRige ASC ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, idDesignacion);
		firstQuery.setParameter(2, "Finalizado");
		firstQuery.setParameter(3, "Anulado");
		firstQuery.setParameter(4, "Insubsistente");

		HistoriaLaboral resultado = null;
		try {
			resultado = (HistoriaLaboral) firstQuery.getSingleResult();
		} catch (NoResultException e) {
			return resultado;
		} catch (NonUniqueResultException e) {
			/*
			 * En caso de tener más de una historia con designacion activa se
			 * obtiene la más antigua a través de esta función de ordenamiento
			 */
			List<HistoriaLaboral> resultados = firstQuery.getResultList();
			System.out.println("Hay más de una historia con designación, tomando la más antigua....");
			return resultados.get(0);
		}
		return resultado;
	}

	@Override
	public HistoriaLaboral findHistoriaDesignacionByDependenciaYTipo(String dependencia, String facultad,
			String tipoDeDesignacion, String dignidad, String estadoDesignacion) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.dependencia.nomDep like ?1 " + "and fam.dependencia.dependencia.nomDep like ?2 "
				+ "and fam.designacion.tipoDesignacion = ?3 " + "and fam.designacion.designacionCatalogo.nombre =?4 "
				+ "and fam.designacion.estado = ?5" + " and fam.id.estado = ?6");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, dependencia);
		firstQuery.setParameter(2, facultad);
		firstQuery.setParameter(3, tipoDeDesignacion);
		firstQuery.setParameter(4, dignidad);
		firstQuery.setParameter(5, estadoDesignacion);
		firstQuery.setParameter(6, "Finalizado");

		HistoriaLaboral resultado = null;
		List<HistoriaLaboral> resultados = firstQuery.getResultList();

		try {
			resultado = (HistoriaLaboral) firstQuery.getSingleResult();
		} catch (NoResultException e) {
			return resultado;
		} catch (NonUniqueResultException e) {
			return resultados.get(0);
		}
		return resultado;
	}

	@Override
	public HistoriaLaboral getComisionEstadiaActivaByEmpleado(Emp emp) {
		StringBuilder queryFirst = new StringBuilder("SELECT fam from HistoriaLaboral fam where "
				+ "fam.emp.nced=?1 and (fam.accionP.subtipoAccion.tipoAccion.nombreAccion "
				+ "like 'COMISION DE SERVICIOS%'"
				+ " or fam.accionP.subtipoAccion.tipoAccion.nombreAccion  like 'COMISIÓN DE SERVICIOS%') ");

		Query firstQuery = getEntityManager().createQuery(queryFirst.toString());

		firstQuery.setParameter(1, emp.getNced());
		List<HistoriaLaboral> firstResult = firstQuery.getResultList();
		if (firstResult.isEmpty()) {
			return null;
		} else {
			StringBuilder queryString = new StringBuilder("SELECT fam from HistoriaLaboral fam where fam.emp.nced=?1 "
					+ "and (fam.accionP.subtipoAccion.tipoAccion.nombreAccion like 'COMISION DE SERVICIOS%' "
					+ " or fam.accionP.subtipoAccion.tipoAccion.nombreAccion  like 'COMISIÓN DE SERVICIOS%' ) "
					+ "and  fam.fechaFin is NULL and fam.id.estado = ?2  "
					+ "and fam.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
					+ "where histo.emp.nced=?1 and (histo.id.estado= ?3 or histo.id.estado=?4))");

			Query query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, emp.getNced());
			query.setParameter(2, "Finalizado");
			query.setParameter(3, "Anulado");
			query.setParameter(4, "Insubsistente");
			HistoriaLaboral comision = null;
			try {
				comision = (HistoriaLaboral) query.getSingleResult();
			} catch (NoResultException e) {
				System.out.println("El empleado no tiene comisiones activas");
				return null;
			} catch (NonUniqueResultException e) {
				List<HistoriaLaboral> comisiones = query.getResultList();
				return comisiones.get(0);
			}
			return comision;
		}
	}

	@Override
	public List<HistoriaLaboral> findNombrameintosByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder(
				"Select hl from HistoriaLaboral " + "hl where  " + " hl.emp.nced=?1 and (hl.tipoRelacion.nombreTr = ?2 "
						+ " or hl.tipoRelacion.nombreTr = ?3 or hl.tipoRelacion.nombreTr=?4) and hl.id.fechaI ="
						+ "(Select max(hist.id.fechaI) from HistoriaLaboral hist where " + "hist.emp.nced=?1 "
						+ " and hist.id.estado='Finalizado')");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "NOMBRAMIENTO");
		query.setParameter(3, "NOMBRAMIENTO ACCIDENTAL");
		query.setParameter(4, "NOMBRAMIENTO REGULAR");

		return query.getResultList();
	}

	@Override
	public boolean isEmpleadoOnMultipleDesignacion(Emp emp) {

		StringBuilder queryString = new StringBuilder(
				"Select hl from HistoriaLaboral " + "hl where  " + " hl.emp.nced=?1 and hl.designacion.estado = ?2 "
						+ "and hl.id.estado = ?3 and hl.accionP.subtipoAccion.nombreSubaccion = ?4)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Ejecucion");
		query.setParameter(3, "Finalizado");
		query.setParameter(4, "DESIGNACION");

		List<HistoriaLaboral> resultados = query.getResultList();
		List<Designacion> designaciones = new ArrayList<>();
		Designacion lastDesignacion = new Designacion();
		for (HistoriaLaboral resultado : resultados) {
			if (!lastDesignacion.equals(resultado.getDesignacion())) {
				designaciones.add(resultado.getDesignacion());
			}
			lastDesignacion = resultado.getDesignacion();
		}
		// Limpiar duplicados
		// designaciones = new ArrayList<>(new HashSet<>(designaciones));
		if (designaciones.size() > 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<HistoriaLaboral> getDesignacionesMultiplesByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and hl.designacion.estado = ?2  " + "and hl.id.estado = ?3 "
				+ "and hl.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ "where histo.emp.nced=?1 and (histo.id.estado= ?4 or histo.id.estado=?5)"
				+ "and  histo.accionP.subtipoAccion.nombreSubaccion = ?6)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "Ejecucion");
		query.setParameter(3, "Finalizado");
		query.setParameter(4, "Anulado");
		query.setParameter(5, "Insubsistente");
		query.setParameter(6, "DESIGNACION");
		List<HistoriaLaboral> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public List<HistoriaLaboral> findContByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.emp.nced =?1 and fam.id.fechaI = "
						+ "(Select max(t.id.fechaI) " + "from HistoriaLaboral t where t.id.idHist=fam.id.idHist)"
						+ "and fam.accionP is null order by fam.fechaRige desc");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public HistoriaLaboral findLastContByEmpActivo(Emp emp) {
		HistoriaLaboral ultimoContrato = null;
		StringBuilder queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + "fam.emp.nced = :cedula and fam.id.fechaI = "
						+ "(Select max(t.id.fechaI) " + "from HistoriaLaboral t where t.id.idHist=fam.id.idHist)"
						+ "and accionP is null and fecha_ini is null and fam.id.idHist not in"
						+ "(Select f.id.idHist from HistoriaLaboral f where (f.id.estado = 'Anulado' or f.id.estado = 'Duplicado') and "
						+ " f.emp.nced = :cedula)" + "  order by fam.fechaRige desc");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter("cedula", emp.getNced());
		List<HistoriaLaboral> resultado = query.getResultList();
		/*
		 * Revisar aqui el estado actual
		 */
		for (HistoriaLaboral ultimo : resultado) {
			if (ultimo.getId().getEstado() != "Anulado" && ultimo.getFechaRige() != null) {
				ultimoContrato = ultimo;
				break;
			}
		}

		return ultimoContrato;
	}

	@Override
	public HistoriaLaboral findLastContByEmp(Emp emp) {
		HistoriaLaboral ultimoContrato = null;
		StringBuilder queryString = new StringBuilder(
				"SELECT fam FROM HistoriaLaboral fam where fam.emp.nced = :cedula "
						+ "and fam.fechaRige = (Select max(t.fechaRige) from HistoriaLaboral t where "
						+ "t.accionP is null and t.id.idHist not in "
						+ "(Select f.id.idHist from HistoriaLaboral f where (f.id.estado = 'Anulado' "
						+ "or f.id.estado = 'Duplicado'))and t.emp.nced =:cedula) " + "order by fam.id.fechaI desc ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter("cedula", emp.getNced());
		try {
			ultimoContrato = (HistoriaLaboral) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Empleado sin contratos registrados");
		} catch (NonUniqueResultException e1) {
			ultimoContrato = (HistoriaLaboral) query.getResultList().get(0);
		}
		return ultimoContrato;

	}

	public HistoriaLaboral findHistoriaActualizacionByEmp(Emp emp) {
		StringBuilder queryString = new StringBuilder("SELECT " + "fam FROM HistoriaLaboral fam where "
				+ "fam.emp.nced =?1 and fam.accionP.subtipoAccion.nombreSubaccion = 'ACTUALIZACION'");
		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(1, emp.getNced());
		HistoriaLaboral historia = null;
		try {
			historia = (HistoriaLaboral) query.getSingleResult();
		} catch (NonUniqueResultException e) {
			e.printStackTrace();
			return (HistoriaLaboral) query.getResultList().get(0);
		} catch (NoResultException e1) {
			e1.printStackTrace();
			return historia;
		}
		return historia;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasQueAfectanAsistencia(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and (hl.accionP.subtipoAccion.nombreSubaccion = ?2 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?3 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?4 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?5 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?6 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?7 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?8 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?9 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?10 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?11 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?12 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?13 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?14 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?15 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?16) " + "and hl.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=hl.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "LICENCIA POR ENFERMEDAD");
		query.setParameter(3, "LICENCIA POR MATERNIDAD");
		query.setParameter(4, "LICENCIA POR ADOPCION");
		query.setParameter(5, "ENFERMEDAD");
		query.setParameter(6, "LICENCIA POR ENFERMEDAD DEGENERATIVA HIJOS");
		query.setParameter(7, "LICENCIA POR CALAMIDAD DOMESTICA");
		query.setParameter(8, "LICENCIA POR MATRIMONIO-UNION DE HECHO");
		query.setParameter(9, "LICENCIA POR PATERNIDAD");
		query.setParameter(10, "ESTADIA EN INSTITUCION EXTERNA");
		query.setParameter(11, "PERMISO INSTITUCIONAL");
		query.setParameter(12, "ESTUDIOS REGULARES");
		query.setParameter(13, "VACACIONES");
		query.setParameter(14, "CUIDADO DE FAMILIARES CON DISCAPACIDADES SEVERAS O ENFERMEDADES CATASTROFICAS");
		query.setParameter(15, "LICENCIA POR CUIDADO DEL RECIEN NACIDO");
		query.setParameter(16, "LICENCIA POR ESTUDIOS DE POSGRADO");

		List<HistoriaLaboral> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasQueAfectanCargoRmu(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and (hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?2 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?3 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?4 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?5 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion  = ?6 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?7 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?8 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?9 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?10 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?11 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?12 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?13 )"
				+ "and hl.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=hl.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "REVALORIZACION");
		query.setParameter(3, "RECATEGORIZACION");
		query.setParameter(4, "NOMBRAMIENTO");
		query.setParameter(5, "CAMBIO DE DEDICACION");
		query.setParameter(6, "CESACION");
		query.setParameter(7, "RECLASIFICACION");
		query.setParameter(8, "NOMBRAMIENTO PROVISIONAL");
		query.setParameter(9, "SUPRESION DE PUESTO");
		query.setParameter(10, "UBICACION");
		query.setParameter(11, "ADSCRIPCION A DEPARTAMENTO");
		query.setParameter(12, "FINALIZACION DE NOMBRAMIENTO PROVISIONAL");
		query.setParameter(13, "CAMBIO REGIMEN");

		List<HistoriaLaboral> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasQueAfectanDesignacion(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and ( TRIM(hl.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?2 "
				+ "or TRIM(hl.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?3 "
				+ "or TRIM(hl.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?4 "
				+ "or TRIM(hl.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?5 "
				+ "or TRIM(hl.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?6 "
				+ "or TRIM(hl.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?7 ) "
				+ "and hl.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=hl.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "SUBROGACION");
		query.setParameter(3, "DESIGNACION");
		query.setParameter(4, "ENCARGO");
		query.setParameter(5, "FINALIZACION NO LICENCIA");
		query.setParameter(6, "POSESION");
		query.setParameter(7, "LIBRE NOMBRAMIENTO Y REMOCIÓN");

		List<HistoriaLaboral> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasLicenciasComSabatico(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and (hl.accionP.subtipoAccion.nombreSubaccion = ?2 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?3 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?4 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?5 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?6 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?7 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?8 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?9 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?10 "
				+ "or hl.accionP.subtipoAccion.nombreSubaccion = ?11 " + ")"
				+ "and hl.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=hl.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "LICENCIA CON REMUNERACION");
		query.setParameter(3, "ANIO SABATICO");
		query.setParameter(4, "PERIODO SABATICO");
		query.setParameter(5, "ASISTENCIA A CURSO DE CAPACITACION");
		query.setParameter(6, "ESTUDIOS REGULARES");
		query.setParameter(7, "LICENCIA POR CALAMIDAD DOMESTICA");
		query.setParameter(8, "LICENCIA POR MATRIMONIO-UNION DE HECHO");
		query.setParameter(9, "LICENCIA POR PATERNIDAD");
		query.setParameter(10, "REINTEGRO");
		query.setParameter(11, "LICENCIA POR ESTUDIOS DE POSGRADO");

		List<HistoriaLaboral> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasSanciones(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?2 "
				+ "and hl.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=hl.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "SANCION");

		List<HistoriaLaboral> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public List<HistoriaLaboral> getActualizacionesFinalizaciones(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and (hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?2 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?3 "
				+ "or hl.accionP.subtipoAccion.tipoAccion.nombreAccion = ?4 )"
				+ "and hl.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=hl.id.idHist)");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());
		query.setParameter(2, "INSUBSISTENCIA");
		query.setParameter(3, "FINALIZACION LICENCIA");
		query.setParameter(4, "ACTUALIZACION");

		List<HistoriaLaboral> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public List<HistoriaLaboral> getAccionesMigradas(Emp emp) {
		StringBuilder queryString = new StringBuilder("Select hl from HistoriaLaboral " + "hl where  "
				+ " hl.emp.nced=?1 and hl.accionP.subtipoAccion.tipoAccion.idTpa >= 261 "
				+ "and hl.id.fechaI = (Select max(t.id.fechaI) "
				+ "from HistoriaLaboral t where t.id.idHist=hl.id.idHist) order by hl.fechaRige asc ");

		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, emp.getNced());

		List<HistoriaLaboral> resultados = query.getResultList();

		return resultados;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasQueAfectanAsistenciaReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado, boolean isFullReport) {
		Query query = null;
		StringBuilder queryString = new StringBuilder("");
		String queryFilter = " and (fam.accionP.subtipoAccion.nombreSubaccion = 'LICENCIA POR ENFERMEDAD' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'LICENCIA POR MATERNIDAD' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'LICENCIA POR ADOPCION' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'ENFERMEDAD' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'LICENCIA POR ENFERMEDAD DEGENERATIVA HIJOS' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'LICENCIA POR CALAMIDAD DOMESTICA' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'LICENCIA POR MATRIMONIO-UNION DE HECHO' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'LICENCIA POR PATERNIDAD' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'ESTADIA EN INSTITUCION EXTERNA' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'PERMISO INSTITUCIONAL' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'ESTUDIOS REGULARES' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'VACACIONES' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'CUIDADO DE FAMILIARES CON DISCAPACIDADES SEVERAS O ENFERMEDADES CATASTROFICAS' "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = 'LICENCIA POR CUIDADO DEL RECIEN NACIDO')";
		queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " fam.fechaRige BETWEEN :inicio and :final ");
		if (empleado != null) {
			String empleadoPredicate = " and fam.emp.nced = " + "\'" + empleado.getNced() + "\' ";
			queryString.append(empleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (nombreCargo.compareTo("Todos") != 0) {
			String cargoPredicate = " and fam.cargosm.nombreCargo =" + "\'" + nombreCargo + "\' ";
			queryString.append(cargoPredicate);
		}

		if (claseEmpleado.compareTo("Todos") != 0) {
			String claseEmpleadoPredicate = " and fam.emp.clasemp.descClase =" + "\'" + claseEmpleado + "\' ";
			queryString.append(claseEmpleadoPredicate);
		}
		if (nombreDesignacion.compareTo("Todas") != 0) {
			String designacionEmpleadoPredicate = " and fam.designacion.designacionCatalogo.nombre =" + "\'"
					+ nombreDesignacion + "\' ";
			queryString.append(designacionEmpleadoPredicate);
		}
		queryString.append(queryFilter);
		if (!isFullReport) {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
					+ "and t.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
					+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
					+ " trim(g.id.estado) = 'Insubsistente' ))) ";
			queryString.append(filterMaxFechas);
		} else {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist ) ";
			queryString.append(filterMaxFechas);
		}

		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasQueAfectanCargoRmuReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado, boolean isFullReport) {
		StringBuilder queryString = new StringBuilder("");
		String queryFilter = " and ( fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?2 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?3 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?4 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?5 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion  = ?6 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?7 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?8 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?9 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?10 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?11 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?12 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?13 )";

		queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " fam.fechaRige BETWEEN :inicio and :final ");
		Query query = null;
		if (empleado != null) {
			String empleadoPredicate = " and fam.emp.nced = " + "\'" + empleado.getNced() + "\' ";
			queryString.append(empleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}

		if (nombreCargo.compareTo("Todos") != 0) {
			String cargoPredicate = " and fam.cargosm.nombreCargo =" + "\'" + nombreCargo + "\' ";
			queryString.append(cargoPredicate);
		}

		if (claseEmpleado.compareTo("Todos") != 0) {
			String claseEmpleadoPredicate = " and fam.emp.clasemp.descClase =" + "\'" + claseEmpleado + "\' ";
			queryString.append(claseEmpleadoPredicate);
		}
		if (nombreDesignacion.compareTo("Todas") != 0) {
			String designacionEmpleadoPredicate = " and fam.designacion.designacionCatalogo.nombre =" + "\'"
					+ nombreDesignacion + "\' ";
			queryString.append(designacionEmpleadoPredicate);
		}
		queryString.append(queryFilter);
		if (!isFullReport) {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
					+ "and t.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
					+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
					+ " trim(g.id.estado) = 'Insubsistente' ))) ";
			queryString.append(filterMaxFechas);
		} else {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist ) ";
			queryString.append(filterMaxFechas);
		}
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);
		query.setParameter(2, "REVALORIZACION");
		query.setParameter(3, "RECATEGORIZACION");
		query.setParameter(4, "NOMBRAMIENTO");
		query.setParameter(5, "CAMBIO DE DEDICACION");
		query.setParameter(6, "CESACION");
		query.setParameter(7, "RECLASIFICACION");
		query.setParameter(8, "NOMBRAMIENTO PROVISIONAL");
		query.setParameter(9, "SUPRESION DE PUESTO");
		query.setParameter(10, "UBICACION");
		query.setParameter(11, "ADSCRIPCION A DEPARTAMENTO");
		query.setParameter(12, "FINALIZACION DE NOMBRAMIENTO PROVISIONAL");
		query.setParameter(13, "CAMBIO REGIMEN");

		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasQueAfectanDesignacionReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado, boolean isFullReport) {
		StringBuilder queryString = new StringBuilder("");
		String queryFilter = " and ( TRIM(fam.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?2 "
				+ "or TRIM(fam.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?3  "
				+ "or TRIM(fam.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?4 "
				+ "or TRIM(fam.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?5 "
				+ "or TRIM(fam.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?6 "
				+ "or TRIM(fam.accionP.subtipoAccion.tipoAccion.nombreAccion) = ?7 )";

		Query query = null;
		queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " fam.fechaRige BETWEEN :inicio and :final ");
		if (empleado != null) {
			String empleadoPredicate = " and fam.emp.nced = " + "\'" + empleado.getNced() + "\' ";
			queryString.append(empleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (nombreCargo.compareTo("Todos") != 0) {
			String cargoPredicate = " and fam.cargosm.nombreCargo =" + "\'" + nombreCargo + "\' ";
			queryString.append(cargoPredicate);
		}

		if (claseEmpleado.compareTo("Todos") != 0) {
			String claseEmpleadoPredicate = " and fam.emp.clasemp.descClase =" + "\'" + claseEmpleado + "\' ";
			queryString.append(claseEmpleadoPredicate);
		}

		if (nombreDesignacion.compareTo("Todas") != 0) {
			String designacionEmpleadoPredicate = " and fam.designacion.designacionCatalogo.nombre =" + "\'"
					+ nombreDesignacion + "\' ";
			queryString.append(designacionEmpleadoPredicate);
		}
		queryString.append(queryFilter);
		if (!isFullReport) {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
					+ "and t.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
					+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
					+ " trim(g.id.estado) = 'Insubsistente' ))) ";
			queryString.append(filterMaxFechas);
		} else {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist ) ";
			queryString.append(filterMaxFechas);
		}
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);
		query.setParameter(2, "SUBROGACION");
		query.setParameter(3, "DESIGNACION");
		query.setParameter(4, "ENCARGO");
		query.setParameter(5, "FINALIZACION NO LICENCIA");
		query.setParameter(6, "POSESION");
		query.setParameter(7, "LIBRE NOMBRAMIENTO Y REMOCIÓN");

		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasLicenciasComSabaticoReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado, boolean isFullReport) {
		StringBuilder queryString = new StringBuilder("");
		String queryFilter = " and (fam.accionP.subtipoAccion.nombreSubaccion = ?2 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = ?3 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = ?4 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = ?5 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = ?6 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = ?7 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = ?8 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = ?9 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = ?10 "
				+ "or fam.accionP.subtipoAccion.nombreSubaccion = ?11 )";

		Query query = null;
		queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " fam.fechaRige BETWEEN :inicio and :final ");
		if (empleado != null) {
			String empleadoPredicate = " and fam.emp.nced = " + "\'" + empleado.getNced() + "\' ";
			queryString.append(empleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (nombreCargo.compareTo("Todos") != 0) {
			String cargoPredicate = " and fam.cargosm.nombreCargo =" + "\'" + nombreCargo + "\' ";
			queryString.append(cargoPredicate);
		}

		if (claseEmpleado.compareTo("Todos") != 0) {
			String claseEmpleadoPredicate = " and fam.emp.clasemp.descClase =" + "\'" + claseEmpleado + "\' ";
			queryString.append(claseEmpleadoPredicate);
		}

		if (nombreDesignacion.compareTo("Todas") != 0) {
			String designacionEmpleadoPredicate = " and fam.designacion.designacionCatalogo.nombre =" + "\'"
					+ nombreDesignacion + "\' ";
			queryString.append(designacionEmpleadoPredicate);
		}
		queryString.append(queryFilter);
		if (!isFullReport) {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
					+ "and t.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
					+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
					+ " trim(g.id.estado) = 'Insubsistente' ))) ";
			queryString.append(filterMaxFechas);
		} else {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist ) ";
			queryString.append(filterMaxFechas);
		}
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);
		query.setParameter(2, "LICENCIA CON REMUNERACION");
		query.setParameter(3, "ANIO SABATICO");
		query.setParameter(4, "PERIODO SABATICO");
		query.setParameter(5, "ASISTENCIA A CURSO DE CAPACITACION");
		query.setParameter(6, "ESTUDIOS REGULARES");
		query.setParameter(7, "LICENCIA POR CALAMIDAD DOMESTICA");
		query.setParameter(8, "LICENCIA POR MATRIMONIO-UNION DE HECHO");
		query.setParameter(9, "LICENCIA POR PATERNIDAD");
		query.setParameter(10, "REINTEGRO");
		query.setParameter(11, "LICENCIA POR ESTUDIOS DE POSGRADO");

		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getHistoriasSancionesReporte(Date inicio, Date ffinal, String nombreDependencia,
			String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado, String nombreDesignacion,
			Emp empleado, boolean isFullReport) {
		StringBuilder queryString = new StringBuilder("");
		String queryFilter = " and  fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?2 ";

		Query query = null;
		queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " fam.fechaRige BETWEEN :inicio and :final ");
		if (empleado != null) {
			String empleadoPredicate = " and fam.emp.nced = " + "\'" + empleado.getNced() + "\' ";
			queryString.append(empleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (nombreCargo.compareTo("Todos") != 0) {
			String cargoPredicate = " and fam.cargosm.nombreCargo =" + "\'" + nombreCargo + "\' ";
			queryString.append(cargoPredicate);
		}

		if (claseEmpleado.compareTo("Todos") != 0) {
			String claseEmpleadoPredicate = " and fam.emp.clasemp.descClase =" + "\'" + claseEmpleado + "\' ";
			queryString.append(claseEmpleadoPredicate);
		}

		if (nombreDesignacion.compareTo("Todas") != 0) {
			String designacionEmpleadoPredicate = " and fam.designacion.designacionCatalogo.nombre =" + "\'"
					+ nombreDesignacion + "\' ";
			queryString.append(designacionEmpleadoPredicate);
		}
		queryString.append(queryFilter);
		if (!isFullReport) {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
					+ "and t.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
					+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
					+ " trim(g.id.estado) = 'Insubsistente' ))) ";
			queryString.append(filterMaxFechas);
		} else {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist ) ";
			queryString.append(filterMaxFechas);
		}
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);
		query.setParameter(2, "SANCION");
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getContratosReporte(Date inicio, Date ffinal, String nombreDependencia,
			String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado, String nombreDesignacion,
			Emp empleado, boolean isFullReport) {
		StringBuilder queryString = new StringBuilder("");
		String queryFilter = " and  fam.accionP is null ";

		Query query = null;
		queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " fam.fechaRige BETWEEN :inicio and :final ");
		if (empleado != null) {
			String empleadoPredicate = " and fam.emp.nced = " + "\'" + empleado.getNced() + "\' ";
			queryString.append(empleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (nombreCargo.compareTo("Todos") != 0) {
			String cargoPredicate = " and fam.cargosm.nombreCargo =" + "\'" + nombreCargo + "\' ";
			queryString.append(cargoPredicate);
		}

		if (claseEmpleado.compareTo("Todos") != 0) {
			String claseEmpleadoPredicate = " and fam.emp.clasemp.descClase =" + "\'" + claseEmpleado + "\' ";
			queryString.append(claseEmpleadoPredicate);
		}

		if (nombreDesignacion.compareTo("Todas") != 0) {
			String designacionEmpleadoPredicate = " and fam.designacion.designacionCatalogo.nombre =" + "\'"
					+ nombreDesignacion + "\' ";
			queryString.append(designacionEmpleadoPredicate);
		}
		queryString.append(queryFilter);
		if (!isFullReport) {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
					+ "and t.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
					+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
					+ " trim(g.id.estado) = 'Insubsistente' ))) order by fam.fechaRige desc ";
			queryString.append(filterMaxFechas);
		} else {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist ) order by fam.fechaRige desc";
			queryString.append(filterMaxFechas);
		}
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);

		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;

	}

	@Override
	public List<HistoriaLaboral> getActualizacionesFinalizacionesReporte(Date inicio, Date ffinal,
			String nombreDependencia, String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado,
			String nombreDesignacion, Emp empleado, boolean isFullReport) {
		StringBuilder queryString = new StringBuilder("");

		String queryFilter = " and ( fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?2 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?3 "
				+ "or fam.accionP.subtipoAccion.tipoAccion.nombreAccion = ?4 )";

		Query query = null;
		queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " fam.fechaRige BETWEEN :inicio and :final ");
		if (empleado != null) {
			String empleadoPredicate = " and fam.emp.nced = " + "\'" + empleado.getNced() + "\' ";
			queryString.append(empleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (nombreCargo.compareTo("Todos") != 0) {
			String cargoPredicate = " and fam.cargosm.nombreCargo =" + "\'" + nombreCargo + "\' ";
			queryString.append(cargoPredicate);
		}

		if (claseEmpleado.compareTo("Todos") != 0) {
			String claseEmpleadoPredicate = " and fam.emp.clasemp.descClase =" + "\'" + claseEmpleado + "\' ";
			queryString.append(claseEmpleadoPredicate);
		}

		if (nombreDesignacion.compareTo("Todas") != 0) {
			String designacionEmpleadoPredicate = " and fam.designacion.designacionCatalogo.nombre =" + "\'"
					+ nombreDesignacion + "\' ";
			queryString.append(designacionEmpleadoPredicate);
		}
		queryString.append(queryFilter);
		if (!isFullReport) {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
					+ "and t.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
					+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
					+ " trim(g.id.estado) = 'Insubsistente' ))) ";
			queryString.append(filterMaxFechas);
		} else {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist ) ";
			queryString.append(filterMaxFechas);
		}
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);
		query.setParameter(2, "INSUBSISTENCIA");
		query.setParameter(3, "FINALIZACION LICENCIA");
		query.setParameter(4, "ACTUALIZACION");

		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getAccionesMigradasReporte(Date inicio, Date ffinal, String nombreDependencia,
			String nombreDependenciaDesignacion, String nombreCargo, String claseEmpleado, String nombreDesignacion,
			Emp empleado, boolean isFullReport) {
		StringBuilder queryString = new StringBuilder("");
		String queryFilter = " and  fam.accionP.subtipoAccion.tipoAccion.idTpa >= 261 ";

		Query query = null;
		queryString = new StringBuilder(
				"SELECT " + "fam FROM HistoriaLaboral fam where " + " fam.fechaRige BETWEEN :inicio and :final ");
		if (empleado != null) {
			String empleadoPredicate = " and fam.emp.nced = " + "\'" + empleado.getNced() + "\' ";
			queryString.append(empleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (nombreCargo.compareTo("Todos") != 0) {
			String cargoPredicate = " and fam.cargosm.nombreCargo =" + "\'" + nombreCargo + "\' ";
			queryString.append(cargoPredicate);
		}

		if (claseEmpleado.compareTo("Todos") != 0) {
			String claseEmpleadoPredicate = " and fam.emp.clasemp.descClase =" + "\'" + claseEmpleado + "\' ";
			queryString.append(claseEmpleadoPredicate);
		}

		if (nombreDesignacion.compareTo("Todas") != 0) {
			String designacionEmpleadoPredicate = " and fam.designacion.designacionCatalogo.nombre =" + "\'"
					+ nombreDesignacion + "\' ";
			queryString.append(designacionEmpleadoPredicate);
		}
		queryString.append(queryFilter);
		if (!isFullReport) {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist "
					+ "and t.id.idHist not in (Select g.id.idHist FROM HistoriaLaboral g where "
					+ " (trim(g.id.estado) = 'Duplicado' or trim(g.id.estado) = 'Anulado' or "
					+ " trim(g.id.estado) = 'Insubsistente' ))) ";
			queryString.append(filterMaxFechas);
		} else {
			String filterMaxFechas = " and fam.id.fechaI = (Select max(t.id.fechaI) "
					+ "from HistoriaLaboral t where t.id.idHist=fam.id.idHist ) ";
			queryString.append(filterMaxFechas);
		}
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("inicio", inicio);
		query.setParameter("final", ffinal);
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getReportePorEmpleadosGeneral(Date fechaDesde, Date fechaHasta,
			String codEstadoEmpleado, String codTipoRelacionEmpleado, String codClaseEmpleado, String nombreDependencia,
			String nombreDependenciaDesignacion) {

		StringBuilder queryString = new StringBuilder("select fam from HistoriaLaboral fam where "
				+ " fam.id.fechaI in (" + " Select max(hist.id.fechaI) from HistoriaLaboral hist where  "
				+ "(hist.id.estado = 'Finalizado' or hist.id.estado = '\"Finalizado\"' or "
				+ "hist.id.estado = 'Legalizado' or hist.id.estado = 'Legalizada') and "
				+ "hist.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ "where (histo.id.estado= ?1 or histo.id.estado=?2)) "
				+ "and hist.fechaRige between :fechaDesde and :fechaHasta "
				+ "group by hist.emp.nced  ) and fam.fechaRige between :fechaDesde and :fechaHasta" + "");

		Query query = null;

		if (codEstadoEmpleado.compareTo("Todos") != 0) {
			String codEstadoPredicate = " and fam.emp.estemp.codEst =" + "\'" + codEstadoEmpleado + "\' ";
			queryString.append(codEstadoPredicate);
		}
		if (codTipoRelacionEmpleado.compareTo("Todos") != 0) {
			String codRelacionEmpleadoPredicate = " and fam.tipoRelacion.idTr =" + "\'" + codTipoRelacionEmpleado
					+ "\' ";
			queryString.append(codRelacionEmpleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (codClaseEmpleado.compareTo("Todos") != 0) {
			String codClaseEmpleadoPredicate = " and fam.emp.clasemp.codClase =" + "\'" + codClaseEmpleado + "\' ";
			queryString.append(codClaseEmpleadoPredicate);
		}

		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		query.setParameter(1, "Anulado");
		query.setParameter(2, "Insubsistente");
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getReportePorEmpleadosContratos(Date fechaDesde, Date fechaHasta,
			String codEstadoEmpleado, String codTipoRelacionEmpleado, String codClaseEmpleado, String nombreDependencia,
			String nombreDependenciaDesignacion) {
		StringBuilder queryString = new StringBuilder("select fam from HistoriaLaboral fam where "
				+ " fam.id.fechaI in (" + " Select max(hist.id.fechaI) from HistoriaLaboral hist "
				+ " where hist.accionP is null " + " and hist.fechaRige between :fechaDesde and :fechaHasta "
				+ " group by hist.emp.nced  ) and fam.fechaRige between :fechaDesde and :fechaHasta");

		Query query = null;

		if (codEstadoEmpleado.compareTo("Todos") != 0) {
			String codEstadoPredicate = " and fam.emp.estemp.codEst =" + "\'" + codEstadoEmpleado + "\' ";
			queryString.append(codEstadoPredicate);
		}
		if (codTipoRelacionEmpleado.compareTo("Todos") != 0) {
			String codRelacionEmpleadoPredicate = " and fam.tipoRelacion.idTr =" + "\'" + codTipoRelacionEmpleado
					+ "\' ";
			queryString.append(codRelacionEmpleadoPredicate);
		}
		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}
		if (nombreDependenciaDesignacion.compareTo("Todas") != 0) {
			String dependenciaDesignacionPredicate = " and (fam.designacion.dependencia.nomDep =" + "\'"
					+ nombreDependenciaDesignacion + "\' " + " or fam.designacion.dependencia.dependencia.nomDep = "
					+ " \' " + nombreDependenciaDesignacion + "\')";
			queryString.append(dependenciaDesignacionPredicate);
		}
		if (codClaseEmpleado.compareTo("Todos") != 0) {
			String codClaseEmpleadoPredicate = " and fam.emp.clasemp.codClase =" + "\'" + codClaseEmpleado + "\' ";
			queryString.append(codClaseEmpleadoPredicate);
		}

		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter("fechaDesde", fechaDesde);
		query.setParameter("fechaHasta", fechaHasta);
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

	@Override
	public List<HistoriaLaboral> getLicenciasVencidasPorMes(String nombreDependencia, String mes, String anio) {

		StringBuilder queryString = new StringBuilder("select fam from HistoriaLaboral fam where "
				+ " fam.id.fechaI in (" + " Select max(hist.id.fechaI) from HistoriaLaboral hist where  "
				+ "(hist.id.estado = 'Finalizado' or hist.id.estado = '\"Finalizado\"' or "
				+ "hist.id.estado = 'Legalizado' or hist.id.estado = 'Legalizada') and "
				+ "hist.id.idHist not in (Select histo.id.idHist from HistoriaLaboral histo "
				+ "where (histo.id.estado= ?1 or histo.id.estado=?2)) " + "and month(hist.fechaPrevistaFin) =" + mes
				+ " and year(hist.fechaPrevistaFin) =" + anio + " group by hist.emp.nced )"
				+ "and fam.accionP.subtipoAccion.tipoAccion.nombreAccion = " + "'LICENCIA'");

		Query query = null;

		if (nombreDependencia.compareTo("Todas") != 0) {
			String dependenciaPredicate = " and ( fam.dependencia.nomDep = " + "\'" + nombreDependencia + "\' "
					+ "or fam.dependencia.dependencia.nomDep =  " + "\'" + nombreDependencia + "\') ";
			queryString.append(dependenciaPredicate);
		}

		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "Anulado");
		query.setParameter(2, "Insubsistente");
		List<HistoriaLaboral> resultado = query.getResultList();

		return resultado;
	}

}
