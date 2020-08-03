package ec.edu.epn.acreditacion.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.reportes.dto.DocenteDistributivoDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteCapacitacionEjecutadaDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteDistribucionHorariaDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteDistributivoAcademicoDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteLibrosCapitulosDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReportePonenciasDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteProdCientificaDTO;
import ec.edu.epn.acreditacion.reportes.dto.TotalDTO;


@Stateless
public class ReporteDocenteDistributivoDAOImplement implements ReporteDocenteDistributivoDAO {

	public ReporteDocenteDistributivoDAOImplement() {

	}

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	// public List<DocenteDistributivoDTO> reporteDocenteDistributivoDTO(String
	// var01, Integer identificador01) {
	public List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDTO(String var01, Integer identificador01) {

		ReporteDistributivoAcademicoDTO dto = new ReporteDistributivoAcademicoDTO();
		List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDTO = new ArrayList<ReporteDistributivoAcademicoDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reportedistribacademico(?,?)");
			query.setParameter(1, var01 );
			query.setParameter(2, identificador01);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteDistributivoAcademicoDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setPeriodo(fila[3] == null ? "" : fila[3].toString());
					dto.setTipo(fila[4] == null ? "" : fila[4].toString());
					dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
					dto.setCargo(fila[6] == null ? "" : fila[6].toString());
					// dto.setFechaIni(fila[7]==null?"":fila[7].toString());
					// dto.setFechaFin(fila[8]==null?"":fila[8].toString());
					dto.setPais(fila[9] == null ? "" : fila[9].toString());
					dto.setUniversidad(fila[10] == null ? "" : fila[10].toString());
					dto.setNombreNivel(fila[11] == null ? "" : fila[11].toString());
					dto.setNivelTitulo(fila[12] == null ? "" : fila[12].toString());
					dto.setTitulo(fila[13] == null ? "" : fila[13].toString());
					dto.setAreaCon(fila[14] == null ? "" : fila[14].toString());
					dto.setRegSenes(fila[15] == null ? "" : fila[15].toString());
					dto.setFechaReg(fila[16] == null ? "" : fila[16].toString());
					reporteDocenteDistributivoDTO.add(dto);
				}
			}
		}
		return reporteDocenteDistributivoDTO;
	}
	
	
	@Override
	// public List<DocenteDistributivoDTO> reporteDocenteDistributivoDTO(String
	// var01, Integer identificador01) {
	public List<ReporteDistributivoAcademicoDTO> reporteTitulosDTO(String var01) {

		ReporteDistributivoAcademicoDTO dto = new ReporteDistributivoAcademicoDTO();
		List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDTO = new ArrayList<ReporteDistributivoAcademicoDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reporteTitulos(?)");
			query.setParameter(1, var01 );
			
			

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteDistributivoAcademicoDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setPeriodo(fila[3] == null ? "" : fila[3].toString());
					dto.setTipo(fila[4] == null ? "" : fila[4].toString());
					dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
					dto.setCargo(fila[6] == null ? "" : fila[6].toString());
					dto.setPais(fila[9] == null ? "" : fila[9].toString());
					dto.setUniversidad(fila[10] == null ? "" : fila[10].toString());
					dto.setNombreNivel(fila[11] == null ? "" : fila[11].toString());
					dto.setNivelTitulo(fila[12] == null ? "" : fila[12].toString());
					dto.setTitulo(fila[13] == null ? "" : fila[13].toString());
					dto.setAreaCon(fila[14] == null ? "" : fila[14].toString());
					dto.setRegSenes(fila[15] == null ? "" : fila[15].toString());
					dto.setFechaReg(fila[16] == null ? "" : fila[16].toString());
					reporteDocenteDistributivoDTO.add(dto);
				}
			}
		}
		return reporteDocenteDistributivoDTO;
	}
	

	public List<DocenteDistributivoDTO> reporteDocenteDistributivoDTO1(String var01, Integer identificador01) {

		DocenteDistributivoDTO dto = new DocenteDistributivoDTO();
		List<DocenteDistributivoDTO> reporteDocenteDistributivoDTO = new ArrayList<DocenteDistributivoDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reportedistribacademico(?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new DocenteDistributivoDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setPeriodo(fila[3] == null ? "" : fila[3].toString());
					dto.setTipo(fila[4] == null ? "" : fila[4].toString());
					dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
					dto.setCargo(fila[6] == null ? "" : fila[6].toString());
					// dto.setFechaIni(fila[7]==null?"":fila[7].toString());
					// dto.setFechaFin(fila[8]==null?"":fila[8].toString());
					dto.setPais(fila[9] == null ? "" : fila[9].toString());
					dto.setUniversidad(fila[10] == null ? "" : fila[10].toString());
					dto.setNombreNivel(fila[11] == null ? "" : fila[11].toString());
					dto.setNivelTitulo(fila[12] == null ? "" : fila[12].toString());
					dto.setTitulo(fila[13] == null ? "" : fila[13].toString());
					dto.setAreaCon(fila[14] == null ? "" : fila[14].toString());
					dto.setRegSenes(fila[15] == null ? "" : fila[15].toString());
					dto.setFechaReg(fila[16] == null ? "" : fila[16].toString());
					reporteDocenteDistributivoDTO.add(dto);
				}
			}
		}
		return reporteDocenteDistributivoDTO;
	}

	@Override
	public List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDedicacion(String var01,
			Integer identificador01) {
		ReporteDistributivoAcademicoDTO dto = new ReporteDistributivoAcademicoDTO();
		List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDedicacion = new ArrayList<ReporteDistributivoAcademicoDTO>();
		String reportSource = "SP";
		Query query = null;
		if ("SP".equals(reportSource)) {
			query = getEntityManager()
					.createNativeQuery("SELECT * FROM \"Rrhh\".reportedistribacademicototaldedic(?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);
			List<?> listsDocentes = query.getResultList();
			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteDistributivoAcademicoDTO();
					dto.setDedicacion(fila[0] == null ? "" : fila[0].toString());
					dto.setTotal(fila[1] == null ? "" : fila[1].toString());

					reporteDocenteDistributivoDedicacion.add(dto);
				}
			}
		}
		return reporteDocenteDistributivoDedicacion;
	}

	@Override
	public List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoNivelTitulo(String var01,
			Integer identificador01) {
		ReporteDistributivoAcademicoDTO dto = new ReporteDistributivoAcademicoDTO();
		List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDedicacion = new ArrayList<ReporteDistributivoAcademicoDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager()
					.createNativeQuery("SELECT * FROM \"Rrhh\".reportedistribacademicototalniveltitulo(?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteDistributivoAcademicoDTO();
					dto.setNivelTitulo(fila[0] == null ? "" : fila[0].toString());
					dto.setTotal(fila[1] == null ? "" : fila[1].toString());

					reporteDocenteDistributivoDedicacion.add(dto);
				}
			}
		}
		return reporteDocenteDistributivoDedicacion;
	}

	@Override
	public List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDepartamento(String var01,
			Integer identificador01) {
		ReporteDistributivoAcademicoDTO dto = new ReporteDistributivoAcademicoDTO();
		List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDedicacion = new ArrayList<ReporteDistributivoAcademicoDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reportedistribacademicototaldep(?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteDistributivoAcademicoDTO();
					dto.setDepartamento(fila[0] == null ? "" : fila[0].toString());
					dto.setTotal(fila[1] == null ? "" : fila[1].toString());

					reporteDocenteDistributivoDedicacion.add(dto);
				}
			}
		}
		return reporteDocenteDistributivoDedicacion;
	}

	@Override
	public List<ReporteCapacitacionEjecutadaDTO> reporteCapacitacionEjecutadaDTO(String var01, Integer identificador01,
			String var02) {
		ReporteCapacitacionEjecutadaDTO dto = new ReporteCapacitacionEjecutadaDTO();
		List<ReporteCapacitacionEjecutadaDTO> reporteDocenteCapacitacion = new ArrayList<ReporteCapacitacionEjecutadaDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reporte_docente_capacitacion(?,?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);
			query.setParameter(3, "%" + var02 + "%");

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteCapacitacionEjecutadaDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setTipo(fila[3] == null ? "" : fila[3].toString());
					dto.setDedicacion(fila[4] == null ? "" : fila[4].toString());
					dto.setCargo(fila[5] == null ? "" : fila[5].toString());
					dto.setIdPeriodo(fila[6] == null ? "" : fila[6].toString());
					dto.setPensum(fila[7] == null ? "" : fila[7].toString());
					dto.setNombCapac(fila[8] == null ? "" : fila[8].toString());
					dto.setLugar(fila[9] == null ? "" : fila[9].toString());
					dto.setPais(fila[10] == null ? "" : fila[10].toString());
					dto.setHoras(fila[11] == null ? "" : fila[11].toString());
					dto.setCategoria(fila[12] == null ? "" : fila[12].toString());

					reporteDocenteCapacitacion.add(dto);
				}
			}
		}
		return reporteDocenteCapacitacion;
	}

	@Override
	public List<ReporteDistributivoAcademicoDTO> reporteTitularidadDTO(String var01) {
		ReporteDistributivoAcademicoDTO dto = new ReporteDistributivoAcademicoDTO();
		List<ReporteDistributivoAcademicoDTO> reporteDocenteTitularidad = new ArrayList<ReporteDistributivoAcademicoDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reporteTitularidad(?)");
			query.setParameter(1, "%" + var01 + "%");
			// query.setParameter(2, identificador01);
			// query.setParameter(3, "%" + var02 + "%");

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteDistributivoAcademicoDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setPeriodo(fila[3] == null ? "" : fila[3].toString());
					dto.setTipo(fila[4] == null ? "" : fila[4].toString());
					dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
					dto.setCargo(fila[6] == null ? "" : fila[6].toString());
					// fECHAS
					dto.setDescTipo(fila[9] == null ? "" : fila[9].toString());

					reporteDocenteTitularidad.add(dto);
				}
			}
		}
		return reporteDocenteTitularidad;
	}

	@Override
	public List<ReporteDistribucionHorariaDTO> reporteDistribucionHorariaDTO(String var01, Integer identificador01) {
		ReporteDistribucionHorariaDTO dto = new ReporteDistribucionHorariaDTO();
		List<ReporteDistribucionHorariaDTO> reporteDocenteTitularidad = new ArrayList<ReporteDistribucionHorariaDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reporte_distribucion_horaria(?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteDistribucionHorariaDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setPeriodo(fila[3] == null ? "" : fila[3].toString());
					dto.setTipo(fila[4] == null ? "" : fila[4].toString());
					dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
					dto.setHorasClase(fila[6] == null ? "" : fila[6].toString());
					dto.setHorasTutoria(fila[7] == null ? "" : fila[7].toString());
					dto.setHorasGestion(fila[8] == null ? "" : fila[8].toString());
					dto.setHorasInvestig(fila[9] == null ? "" : fila[9].toString());
					dto.setHorasVincul(fila[10] == null ? "" : fila[10].toString());

					reporteDocenteTitularidad.add(dto);
				}
			}
		}
		return reporteDocenteTitularidad;
	}

	@Override
	public List<ReporteProdCientificaDTO> reporteProdCientificAcademicaDTO(String var01, Integer identificador01,
			Date var02, Date var03) {

		System.out.println("reporteProdCientificAcademicaDTO");
		ReporteProdCientificaDTO dto = new ReporteProdCientificaDTO();
		List<ReporteProdCientificaDTO> reporteProdCientificAcademica = new ArrayList<ReporteProdCientificaDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager()
					.createNativeQuery("SELECT * FROM \"Rrhh\".reporte_produccion_acade_cientifica(?,?,?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);
			query.setParameter(3, var02);
			query.setParameter(4, var03);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteProdCientificaDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setPensum(fila[3] == null ? "" : fila[3].toString());
					dto.setRelacion(fila[4] == null ? "" : fila[4].toString());
					dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
					dto.setTituloPub(fila[6] == null ? "" : fila[6].toString());
					dto.setMedioRevista(fila[7] == null ? "" : fila[7].toString());
					dto.setCatalogo(fila[8] == null ? "" : fila[8].toString());
					dto.setAutores(fila[9] == null ? "" : fila[9].toString());
					dto.setSjr(fila[10] == null ? "" : fila[10].toString());
					dto.setFechaPub(fila[11] == null ? "" : fila[11].toString());
					dto.setEditorial(fila[12] == null ? "" : fila[12].toString());
					dto.setPaginas(fila[13] == null ? "" : fila[13].toString());
					dto.setHorasDedic(fila[14] == null ? "" : fila[14].toString());
					dto.setHorasInv(fila[15] == null ? "" : fila[15].toString());

					reporteProdCientificAcademica.add(dto);
				}
			}
		}
		System.out.println("Listaaa:  ... " + reporteProdCientificAcademica.size());
		return reporteProdCientificAcademica;

	}

	@Override
	public List<ReporteProdCientificaDTO> reporteProdCRegionalDTO(String var01, Integer identificador01, Date var02,
			Date var03) {
		ReporteProdCientificaDTO dto = new ReporteProdCientificaDTO();
		List<ReporteProdCientificaDTO> reporteProdCientificAcademica = new ArrayList<ReporteProdCientificaDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reporte_produccion_regional(?,?,?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);
			query.setParameter(3, var02);
			query.setParameter(4, var03);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteProdCientificaDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setPensum(fila[3] == null ? "" : fila[3].toString());
					dto.setRelacion(fila[4] == null ? "" : fila[4].toString());
					dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
					dto.setTituloPub(fila[6] == null ? "" : fila[6].toString());
					dto.setMedioRevista(fila[7] == null ? "" : fila[7].toString());
					dto.setCatalogo(fila[8] == null ? "" : fila[8].toString());
					dto.setAutores(fila[9] == null ? "" : fila[9].toString());
					dto.setSjr(fila[10] == null ? "" : fila[10].toString());
					dto.setFechaPub(fila[11] == null ? "" : fila[11].toString());
					dto.setEditorial(fila[12] == null ? "" : fila[12].toString());
					dto.setPaginas(fila[13] == null ? "" : fila[13].toString());
					dto.setHorasDedic(fila[14] == null ? "" : fila[14].toString());
					dto.setHorasInv(fila[15] == null ? "" : fila[15].toString());

					reporteProdCientificAcademica.add(dto);
				}
			}
		}
		return reporteProdCientificAcademica;
	}

	@Override
	public List<ReporteLibrosCapitulosDTO> reporteLibrosCapitulosDTO(String var01, Integer identificador01, Date var02,
			Date var03) {
		ReporteLibrosCapitulosDTO dto = new ReporteLibrosCapitulosDTO();
		List<ReporteLibrosCapitulosDTO> reporteLibrosCapitulos = new ArrayList<ReporteLibrosCapitulosDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reporte_libros_capitulos(?,?,?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);
			query.setParameter(3, var02);
			query.setParameter(4, var03);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReporteLibrosCapitulosDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setPensum(fila[3] == null ? "" : fila[3].toString());
					dto.setRelacion(fila[4] == null ? "" : fila[4].toString());
					dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
					dto.setTipoPub(fila[6] == null ? "" : fila[6].toString());
					dto.setTituloPub(fila[7] == null ? "" : fila[7].toString());
					dto.setMedio(fila[8] == null ? "" : fila[8].toString());
					dto.setIsbn(fila[9] == null ? "" : fila[9].toString());
					dto.setAutores(fila[10] == null ? "" : fila[10].toString());
					dto.setFechaPub(fila[11] == null ? "" : fila[11].toString());
					dto.setEditorial(fila[12] == null ? "" : fila[12].toString());
					dto.setHorasDedic(fila[13] == null ? "" : fila[13].toString());
					dto.setRevisionPares(fila[14] == null ? "" : fila[14].toString());

					reporteLibrosCapitulos.add(dto);
				}
			}
		}
		return reporteLibrosCapitulos;
	}

	@Override
	public List<ReportePonenciasDTO> reportePonenciasDTO(String var01, Integer identificador01, Date var02,
			Date var03) {
		ReportePonenciasDTO dto = new ReportePonenciasDTO();
		List<ReportePonenciasDTO> reportePonencias = new ArrayList<ReportePonenciasDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager().createNativeQuery("SELECT * FROM \"Rrhh\".reporte_ponencia(?,?,?,?)");
			query.setParameter(1, "%" + var01 + "%");
			query.setParameter(2, identificador01);
			query.setParameter(3, var02);
			query.setParameter(4, var03);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteDis : listsDocentes) {
					Object[] fila = (Object[]) listDocenteDis;
					dto = new ReportePonenciasDTO();
					dto.setNced(fila[0] == null ? "" : fila[0].toString());
					dto.setNombres(fila[1] == null ? "" : fila[1].toString());
					dto.setDepartamento(fila[2] == null ? "" : fila[2].toString());
					dto.setPensum(fila[3] == null ? "" : fila[3].toString());
					dto.setRelacion(fila[4] == null ? "" : fila[4].toString());
					dto.setDedicacion(fila[5] == null ? "" : fila[5].toString());
					dto.setTipoPub(fila[6] == null ? "" : fila[6].toString());
					dto.setTituloPub(fila[7] == null ? "" : fila[7].toString());
					dto.setMedio(fila[8] == null ? "" : fila[8].toString());
					dto.setAutores(fila[9] == null ? "" : fila[9].toString());
					dto.setFechaPub(fila[10] == null ? "" : fila[10].toString());
					dto.setHorasDedic(fila[11] == null ? "" : fila[11].toString());
					dto.setCiudad(fila[12] == null ? "" : fila[12].toString());

					reportePonencias.add(dto);
				}
			}
		}
		return reportePonencias;
	}

	@Override
	public List<TotalDTO> totalContratos(List<String> cedulas) {

		StringBuilder queryString = new StringBuilder(
				"SELECT count(t.descTcont), t.tcont,t.descTcont FROM Cont c, Tcont t where c.tcontBean.tcont = t.tcont and c.emp.nced IN:list group by t.tcont, t.descTcont ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter("list", cedulas);

		List<Object[]> rows = query.getResultList();
		List<TotalDTO> total = new ArrayList<TotalDTO>(rows.size());
		for (Object[] row : rows) {
			total.add(new TotalDTO((Long) row[0], (String) row[1], (String) row[2]));

		}
		return total;

	}

}
