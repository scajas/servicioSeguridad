package ec.edu.epn.conexion.SQLServer;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ec.edu.epn.acreditacion.reportes.dto.CargaAcademicaDistributivoDTO;
import ec.edu.epn.acreditacion.reportes.dto.DistributivoAcademicoDTO;
import ec.edu.epn.acreditacion.reportes.dto.E111DTO;
import ec.edu.epn.acreditacion.reportes.dto.E112ADTO;
import ec.edu.epn.acreditacion.reportes.dto.E112BDTO;
import ec.edu.epn.acreditacion.reportes.dto.E112BXFactorRendimientoDTO;
import ec.edu.epn.acreditacion.reportes.dto.E112CDTO;
import ec.edu.epn.acreditacion.reportes.dto.E142DTO;
import ec.edu.epn.acreditacion.reportes.dto.E142XTipoBecaDTO;
import ec.edu.epn.acreditacion.reportes.dto.E21ADTO;
import ec.edu.epn.acreditacion.reportes.dto.PeriodosSAEWDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteChartDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteDistributivoAcademicoDTO;
import ec.edu.epn.atencionmedica.dto.EstudianteMedicoDTO;

//import com.google.common.collect.SetMultimap;

import ec.edu.epn.catalogos.DTO.CarreraDTO;
import ec.edu.epn.catalogos.entities.Carrera;
import ec.edu.epn.catalogos.entities.FacultadCatalogos;
import ec.edu.epn.catalogos.entities.Materia;
import ec.edu.epn.contratos.DTO.DatosSaew;
import ec.edu.epn.contratos.DTO.DatosSaewHorariosFechas;
import ec.edu.epn.contratos.DTO.DatosSaewModulares;
import ec.edu.epn.contratos.entities.CargaAcademica;
import ec.edu.epn.contratos.entities.Pedido;
import ec.edu.epn.contratos.entities.Pensum;
import ec.edu.epn.contratos.entities.TitulosDocente;
import ec.edu.epn.gestionDocente.DTO.ActividadDocenciaDTO;
import ec.edu.epn.gestionDocente.DTO.CargaPlanificacionDTO;
import ec.edu.epn.gestionDocente.DTO.HorarioDTO;
import ec.edu.epn.gestionDocente.DTO.TesisDirigidasDTO;
import ec.edu.epn.gestionDocente.DTO.TesisDocenteDTO;
import ec.edu.epn.rrhh.DTO.DocenteDTO;
import ec.edu.epn.silabo.dto.CordinacionDTO;

public class procedimientosAlmacenados {

	private Pensum pensumVigente;

	public procedimientosAlmacenados() {
	}

	public procedimientosAlmacenados(Pensum pensumVigente) {
		try {
			this.pensumVigente = pensumVigente;

		} catch (Exception e) {

		}
	}

	public List<FacultadCatalogos> obtenerFacultades() {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saefacultad (?)}");

			// pa_saefacultad L
			cst.setString(1, "L");
			result = cst.executeQuery();
			List<FacultadCatalogos> listaFacu = new ArrayList<>();
			while (result.next()) {
				FacultadCatalogos facultad = new FacultadCatalogos();
				facultad.setNomFacultad(result.getString(1));
				facultad.setNomDecano(result.getString(2));
				listaFacu.add(facultad);
			}

			result.close();

			sql.closeConnection();
			return listaFacu;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<Carrera> obtenerCarreras(String facultad) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecarrera (?,?)}");

			// pa_saecarrera L,'INGENIERIA DE SISTEMAS'
			cst.setString(1, "L");
			cst.setString(2, facultad);
			result = cst.executeQuery();
			List<Carrera> listaCarrear = new ArrayList<Carrera>();
			while (result.next()) {
				Carrera carrera = new Carrera();
				carrera.setIdCarrera(result.getString(1));
				carrera.setNomCarrera(result.getString(2));
				listaCarrear.add(carrera);
			}

			result.close();

			sql.closeConnection();
			return listaCarrear;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/***
	 * PROCEDIMIENTOS ACREDITACION CRITERIO: E. ESTUDIANTES ACREDITACION
	 ***/
	/*** E1. SUBCRITERIO: GESTION ACADEMICA ***/
	/*****************************************************************/
	/*** E1.1 INDICADOR: TUTORIAS ***/
	/**
	 * EVIDENCIA: 1. Planificación y asignación de actividades de tutoría a los
	 * profesores con actividades de docencia en la carrera.
	 **/
	public List<E111DTO> E111(FacultadCatalogos facultad, Carrera carrera, Pensum pensum) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// pa_saeestcarrtut_acreditacion 'LIE11','INGENIERIA DE
			// SISTEMAS','07','','',2017,1,'','','','1'
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saeestcarrtut_acreditacion (?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LIE11");

			if (facultad == null)
				cst.setString(2, "");
			else
				cst.setString(2, facultad.getNomFacultad());
			if (carrera == null)
				cst.setString(3, "");
			else
				cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "1");

			result = cst.executeQuery();
			List<E111DTO> list = new ArrayList<>();
			while (result.next()) {
				/**
				 * Código,Estudiante,CedulaEstudiante,FechaNacimientoEstud,
				 * CelularEstudiante,EmailPersonalEstudiante,EmailEPNEstudiante,
				 * MateriasPerdidas,ultimopermatri,facultadultmatri,Practicas,
				 * promedio,tipoTitulacion,Graduado,CredAcum,IRA,CódigoTutor,
				 * Tutor
				 **/
				E111DTO obj = new E111DTO();
				obj.setCodigo(result.getString(1));
				obj.setEstudiante(result.getString(2));
				obj.setCedulaEstudiante(result.getString(3));
				obj.setFechaNacimientoEstud(result.getString(4));
				obj.setCelularEstudiante(result.getString(5));
				obj.setEmailPersonalEstudiante(result.getString(6));
				obj.setEmailEPNEstudiante(result.getString(7));
				obj.setMateriasPerdidas(result.getString(8));
				obj.setUltimopermatri(result.getString(9));
				obj.setCarreraultmatri(result.getString(10));
				obj.setFacultadultmatri(result.getString(11));
				obj.setPracticas(result.getString(12));
				obj.setPromedio(result.getString(13));
				obj.setTipoTitulacion(result.getString(14));
				obj.setGraduado(result.getString(15));
				obj.setCredAcum(result.getString(16));
				obj.setIRA(result.getString(17));
				obj.setCodigoTutor(result.getString(18));
				obj.setTutor(result.getString(19));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/** total de tutorias x profesor **/

	public List<E111DTO> E111TotalxProfesor(FacultadCatalogos facultad, Carrera carrera, Pensum pensum) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// pa_saeestcarrtut_acreditacion
			// 'CTEP','','','','',2017,2,'','','',''

			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saeestcarrtut_acreditacion (?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "CTEP");

			if (facultad == null)
				cst.setString(2, "");
			else
				cst.setString(2, facultad.getNomFacultad());
			if (carrera == null)
				cst.setString(3, "");
			else
				cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "");

			result = cst.executeQuery();
			List<E111DTO> list = new ArrayList<>();
			while (result.next()) {
				/**
				 * Código,Estudiante,CedulaEstudiante,FechaNacimientoEstud,
				 * CelularEstudiante,EmailPersonalEstudiante,EmailEPNEstudiante,
				 * MateriasPerdidas,ultimopermatri,facultadultmatri,Practicas,
				 * promedio,tipoTitulacion,Graduado,CredAcum,IRA,CódigoTutor,
				 * Tutor
				 **/
				E111DTO obj = new E111DTO();

				obj.setCodigoTutor(result.getString(1));
				obj.setTutor(result.getString(2));
				obj.setPromedio(result.getString(3));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/**
	 * EVIDENCIA: 2. 1. Listado de Asistencia y No Asistencia a Tutorías.
	 **/
	public List<E112ADTO> E112A(FacultadCatalogos facultad, Carrera carrera) {

		conexionSQL sql = new conexionSQL();
		java.sql.ResultSet result = null;
		try {

			sql.getConnection();

			/**
			 * Sentencia: pa_saeestcarrtut_acreditacion
			 * 'LIE11','','','','',2017,2,'','','','2'
			 **/
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saeestcarrtut_acreditacion (?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LIE11");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "2");

			result = cst.executeQuery();
			List<E112ADTO> list = new ArrayList<>();
			while (result.next()) {
				/**
				 * Retorna: codcar, IdentificacionTut,Tutor,CodigoEstud,
				 * EstudianteIdentif,Estudiante,FechaNacEstud,CelularEstud,
				 * EmailEstudiante,EmailEstudEPN,CredAcum,MateriasPerdidas,
				 * promedio,IRA, PracticasPre,tipoTitulacion,Graduado,
				 * Facultad,Carrera,RegFactor,Factor,Observacion
				 **/
				E112ADTO obj = new E112ADTO();

				obj.setCodcar(result.getString(1));
				obj.setIdentificacionTut(result.getString(2));
				obj.setTutor(result.getString(3));
				obj.setCodigoEstud(result.getString(4));
				obj.setEstudianteIdentif(result.getString(5));
				obj.setEstudiante(result.getString(6));
				obj.setFechaNacEstud(result.getString(7));
				obj.setCelularEstud(result.getString(8));
				obj.setEmailEstudiante(result.getString(9));
				obj.setEmailEstudEPN(result.getString(10));
				obj.setCredAcum(result.getString(11));
				obj.setMateriasPerdidas(result.getString(12));
				obj.setPromedio(result.getString(13));
				obj.setIRA(result.getString(14));
				obj.setPracticasPre(result.getString(15));
				obj.setTipoTitulacion(result.getString(16));
				obj.setGraduado(result.getString(17));
				obj.setFacultad(result.getString(18));
				obj.setCarrera(result.getString(19));
				obj.setRegFactor(result.getString(20));
				obj.setFactor(result.getString(21));
				obj.setObservacion(result.getString(22));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/**
	 * EVIDENCIA: 2. 2. Listado de Asistencia y No Asistencia a Tutorías
	 **/

	public List<E112BDTO> E112B(FacultadCatalogos facultad, Carrera carrera, Pensum pensum) {

		conexionSQL sql = new conexionSQL();
		java.sql.ResultSet result = null;
		try {
			this.pensumVigente = pensum;

			sql.getConnection();

			/**
			 * pa_saeestcarrtut_acreditacion 'LIE11','INGENIERIA DE
			 * SISTEMAS','07','','',2017,1,'','','','3'
			 * 
			 **/
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saeestcarrtut_acreditacion (?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LIE11");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "3");

			result = cst.executeQuery();
			List<E112BDTO> list = new ArrayList<>();
			while (result.next()) {
				/**
				 * Retorna: codcar, IdentificacionTut,Tutor,CodigoEstud,
				 * EstudianteIdentif,Estudiante,FechaNacEstud,CelularEstud,
				 * EmailEstudiante,EmailEstudEPN,CredAcum,MateriasPerdidas,
				 * promedio,IRA, PracticasPre,tipoTitulacion,Graduado,
				 * Facultad,Carrera,RegFactor,Factor,Observacion
				 **/
				E112BDTO obj = new E112BDTO();

				obj.setCarrera(result.getString(2));
				obj.setFacultad(result.getString(3));
				obj.setIdentificacionTutor(result.getString(4));
				obj.setTutor(result.getString(5));

				obj.setCodEstudiante(result.getString(6));
				obj.setEstudiante(result.getString(7));

				obj.setTutorisEstudiantes(result.getString(8));
				obj.setTutoriasRealizadas(result.getString(9));
				obj.setTutoriasNoRealizadas(result.getString(10));
				obj.setTutoriasRegistradasConFactor(result.getString(11));
				obj.setTutoriasregistrasSinFactor(result.getString(12));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/** totales y porcentajes E112B **/

	public List<E112BDTO> E112BTotalesPorcentajes(FacultadCatalogos facultad, Carrera carrera, Pensum pensum) {

		conexionSQL sql = new conexionSQL();
		java.sql.ResultSet result = null;
		try {
			this.pensumVigente = pensum;

			sql.getConnection();

			/**
			 * pa_saeestcarrtut_acreditacion 'LIE11','INGENIERIA DE
			 * SISTEMAS','07','','',2017,2,'','','','3T'
			 * 
			 * 
			 **/
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saeestcarrtut_acreditacion (?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LIE11");
			cst.setString(2, facultad.getNomFacultad());
			cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "3T");

			result = cst.executeQuery();
			List<E112BDTO> list = new ArrayList<>();
			while (result.next()) {

				E112BDTO obj = new E112BDTO();

				obj.setIdentificacionTutor(result.getString(1));
				obj.setTutor(result.getString(2));

				obj.setTutorisEstudiantes(result.getString(3));
				obj.setTutoriasRealizadas(result.getString(4));
				obj.setTutoriasPorcentaje(result.getString(5));
				obj.setTotalEstudiantesSinTutoria(result.getString(6));
				obj.setSinTutoriaPorcentaje(result.getString(7));
				obj.setTotalEstudiantesSinCita(result.getString(8));
				obj.setTotalEstudiantesNoAsistenTutoria(result.getString(9));
				obj.setCitasVigentes(result.getString(10));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/** totales x factor de rendimiento **/

	public List<E112BXFactorRendimientoDTO> E112BTotalesxTipoFactorRendimiento(FacultadCatalogos facultad,
			Carrera carrera, Pensum pensum) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {
			this.pensumVigente = pensum;

			sql.getConnection();

			/**
			 * pa_saeestcarrtut_acreditacion 'LIE11','INGENIERIA DE
			 * SISTEMAS','07','','',2017,2,'','','','3T1'
			 * 
			 * 
			 * 
			 **/
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saeestcarrtut_acreditacion (?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LIE11");
			cst.setString(2, facultad.getNomFacultad());
			cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "3T1");

			result = cst.executeQuery();
			List<E112BXFactorRendimientoDTO> list = new ArrayList<>();
			while (result.next()) {

				E112BXFactorRendimientoDTO obj = new E112BXFactorRendimientoDTO();

				obj.setFacultad(result.getString(1));
				obj.setCarrera(result.getString(2));
				obj.setOtros(result.getString(3));
				obj.setDeportes(result.getString(4));
				obj.setIdiomas(result.getString(5));
				obj.setMusica(result.getString(6));
				obj.setTeatro(result.getString(7));
				obj.setEscolar(result.getString(8));
				obj.setAdminTiempo(result.getString(9));
				obj.setContenidoCurso(result.getString(10));
				obj.setDiscapacidad(result.getString(11));
				obj.setEntendimientoContenido(result.getString(12));
				obj.setFaltaInteresMateria(result.getString(13));
				obj.setMetodologiaEnsenianza(result.getString(14));
				obj.setPreparacionPruebasExamenes(result.getString(15));
				obj.setProblemasAlimenticios(result.getString(16));
				obj.setProblemasEconomicos(result.getString(17));
				obj.setProblemasFamiliares(result.getString(18));
				obj.setProblemasMedicos(result.getString(19));
				obj.setProblemasPsicologicos(result.getString(20));
				obj.setProblemasSociales(result.getString(21));
				obj.setRedaccionDocumentos(result.getString(22));
				obj.setTutoriaSinFactor(result.getString(23));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/**
	 * EVIDENCIA: 2. 2. Lista de estudiantes que no asisten a tutorias.
	 **/
	public List<E112CDTO> E112C() {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// pa_saeestcarrtut_acreditacion
			// 'LIE11','','','','',2017,2,'','','','4'
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saeestcarrtut_acreditacion (?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LIE11");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "4");

			result = cst.executeQuery();
			List<E112CDTO> list = new ArrayList<>();
			while (result.next()) {

				E112CDTO obj = new E112CDTO();

				obj.setEstudiante(result.getString(1));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/***
	 * E1.2 INDICADOR: Indicador: Actividades Complementarias (Q) – No hay
	 * reportes asociados que se puedan generar.
	 ***/

	/***
	 * E1.3 INDICADOR: E1.3 Indicador: Actividades vinculadas con la
	 * colectividad (Q).
	 ***/
	/**
	 * EVIDENCIA: 1. Sistema o registro para la coordinación, control,
	 * seguimiento y evaluación de actividades de vinculación .
	 **/

	/**
	 * EVIDENCIA: 2. 2. Convenios Documento firmado por las partes para el
	 * desarrollo de las actividades de vinculación. .Reporte de los convenios
	 * suscritos por la EPN, los vigentes con filtros de fechas.
	 **/

	// EN BASE DE SII CONVENIOS
	/***
	 * E1.4 INDICADOR: E1.4 Indicador: Bienestar Estudiantil (Q)
	 ***/
	/**
	 * EVIDENCIA: 2. Listado de estudiantes beneficiarios de algún tipo de beca
	 * o ayuda socioeconómica, o servicios de bienestar estudiantil. .Tipo de
	 * Beca/Ayuda Económica. Información Estudiantes Becados.
	 **/

	public List<E142DTO> E142(FacultadCatalogos facultad, Carrera carrera, Pensum pensum) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			this.pensumVigente = pensum;

			// pa_saebeca_acreditacion 'LG' ,'',
			// '','','%','',null,'2017','2','','C',null,'','','','',''
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saebeca_acreditacion (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LG");
			cst.setString(2, facultad.getNomFacultad());
			cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, "");
			cst.setString(5, "%");
			cst.setString(6, "");
			cst.setString(7, null);
			cst.setString(8, this.pensumVigente.getAñoPensum());
			cst.setString(9, this.pensumVigente.getNumeroPensum());
			cst.setString(10, "");
			cst.setString(11, "C");
			cst.setString(12, null);
			cst.setString(13, "");
			cst.setString(14, "");
			cst.setString(15, "");
			cst.setString(16, "");
			cst.setString(17, "");

			result = cst.executeQuery();
			List<E142DTO> list = new ArrayList<>();
			int x = 0;
			while (result.next()) {
				/**
				 * Código,Estudiante,CedulaEstudiante,FechaNacimientoEstud,
				 * CelularEstudiante,EmailPersonalEstudiante,EmailEPNEstudiante,
				 * MateriasPerdidas,ultimopermatri,facultadultmatri,Practicas,
				 * promedio,tipoTitulacion,Graduado,CredAcum,IRA,CódigoTutor,
				 * Tutor
				 **/
				x++;
				E142DTO obj = new E142DTO();
				obj.setNro(Integer.toString(x));
				obj.setPeriodoAcademico(result.getString(1));
				obj.setSemestre(result.getString(2));
				obj.setCodigo(result.getString(3));
				obj.setCedula(result.getString(4));
				obj.setEstudiante(result.getString(5));
				obj.setSexo(result.getString(6));
				obj.setBeca(result.getString(7));
				obj.setTipoBeca(result.getString(8));
				obj.setValor(result.getString(9));
				obj.setFacultad(result.getString(10));
				obj.setCarrera(result.getString(11));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<E142XTipoBecaDTO> E142XTipoBeca(FacultadCatalogos facultad, Carrera carrera, Pensum pensum) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			this.pensumVigente = pensum;

			// pa_saebeca'LT' ,'',
			// '','','%','',null,'2017','2','','',null,'','','','','','','x'
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saebeca (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LT");
			cst.setString(2, facultad.getNomFacultad());
			cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, "");
			cst.setString(5, "%");
			cst.setString(6, "");
			cst.setString(7, null);
			cst.setString(8, this.pensumVigente.getAñoPensum());
			cst.setString(9, this.pensumVigente.getNumeroPensum());
			cst.setString(10, "");
			cst.setString(11, "");
			cst.setString(12, null);
			cst.setString(13, "");
			cst.setString(14, "");
			cst.setString(15, "");
			cst.setString(16, "");
			cst.setString(17, "");
			cst.setString(18, "");
			cst.setString(19, "x");

			result = cst.executeQuery();
			List<E142XTipoBecaDTO> list = new ArrayList<>();

			while (result.next()) {
				/**
				 * Código,Estudiante,CedulaEstudiante,FechaNacimientoEstud,
				 * CelularEstudiante,EmailPersonalEstudiante,EmailEPNEstudiante,
				 * MateriasPerdidas,ultimopermatri,facultadultmatri,Practicas,
				 * promedio,tipoTitulacion,Graduado,CredAcum,IRA,CódigoTutor,
				 * Tutor
				 **/

				E142XTipoBecaDTO obj = new E142XTipoBecaDTO();
				obj.setBeca(result.getString(1));
				obj.setTipoBeca(result.getString(2));
				obj.setPorcentajeValor(result.getString(3));
				obj.setSolicitudes(result.getString(4));
				obj.setNoCumpleReglamento(result.getString(5));
				obj.setCoNCOntrato(result.getString(6));
				obj.setMasculino(result.getString(7));
				obj.setFemenino(result.getString(8));
				obj.setRenuncia(result.getString(9));
				obj.setAnulado(result.getString(10));
				obj.setFaltan(result.getString(11));
				obj.setSinMatricula(result.getString(12));
				obj.setValorSol(result.getString(13));
				obj.setValorCont(result.getString(14));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/***
	 * E1.5 INDICADOR: Participación en la Acreditación (Q) - No hay reportes
	 * asociados que se puedan generar.
	 * 
	 ***/

	/***
	 * E2. SUBCRITERIO: EFICIENCIA • E2.1 Indicador: Tasa de Retención (C)
	 ***/

	public List<E21ADTO> E21A(FacultadCatalogos facultad, Carrera carrera, Pensum pensum) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			this.pensumVigente = pensum;

			// pa_saematrin
			// 'LC','','','','',2017,2,2017,2,null,'N','',2017,2,2017,2

			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saematrin (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LC");
			cst.setString(2, facultad.getNomFacultad());
			cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, this.pensumVigente.getAñoPensum());
			cst.setString(9, this.pensumVigente.getNumeroPensum());
			cst.setString(10, null);
			cst.setString(11, "N");
			cst.setString(12, "");
			cst.setString(13, this.pensumVigente.getAñoPensum());
			cst.setString(14, this.pensumVigente.getNumeroPensum());
			cst.setString(15, this.pensumVigente.getAñoPensum());
			cst.setString(16, this.pensumVigente.getNumeroPensum());

			result = cst.executeQuery();
			List<E21ADTO> list = new ArrayList<>();

			while (result.next()) {

				E21ADTO obj = new E21ADTO();
				obj.setCedula(result.getString(1));
				obj.setEstudiante(result.getString(2));
				obj.setSexo(result.getString(3));
				obj.setCodigo(result.getString(4));
				obj.setFacultad(result.getString(5));
				obj.setCarrera(result.getString(6));
				obj.setPeriodoInicio(result.getString(7));
				obj.setPeriodoMatricula(result.getString(8));
				obj.setGraduado(result.getString(9));
				obj.setSemestre(pensum.getMeses());

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<E21ADTO> E21B(FacultadCatalogos facultad, Carrera carrera, Pensum pensum) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			this.pensumVigente = pensum;

			//
			// pa_saematrin 'LC','','','','',2017,2,2017,2,null

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saematrin (?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LC");
			cst.setString(2, facultad.getNomFacultad());
			cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, this.pensumVigente.getAñoPensum());
			cst.setString(9, this.pensumVigente.getNumeroPensum());
			cst.setString(10, null);

			result = cst.executeQuery();
			List<E21ADTO> list = new ArrayList<>();

			while (result.next()) {

				E21ADTO obj = new E21ADTO();
				obj.setCedula(result.getString(1));
				obj.setEstudiante(result.getString(2));
				obj.setSexo(result.getString(3));
				obj.setCodigo(result.getString(4));
				obj.setFacultad(result.getString(5));
				obj.setCarrera(result.getString(6));
				obj.setPeriodoInicio(result.getString(7));
				obj.setPeriodoMatricula(result.getString(8));
				obj.setGraduado(result.getString(9));
				obj.setSemestre(pensum.getMeses());

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/***
	 * E2. SUBCRITERIO: EFICIENCIA • E2.2 Indicador: Tasa de Titulación (C)
	 ***/

	public List<E21ADTO> E221(FacultadCatalogos facultad, Carrera carrera, Pensum pensum) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			this.pensumVigente = pensum;

			// pa_saematrin 'LC','INGENIERIA EN
			// SISTEMAS','07','','',2013,2,2017,2, null

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saematrin (?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LC");
			cst.setString(2, facultad.getNomFacultad());
			cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, this.pensumVigente.getAñoPensum());
			cst.setString(7, this.pensumVigente.getNumeroPensum());
			cst.setString(8, this.pensumVigente.getAñoPensum());
			cst.setString(9, this.pensumVigente.getNumeroPensum());
			cst.setString(10, null);

			result = cst.executeQuery();
			List<E21ADTO> list = new ArrayList<>();

			while (result.next()) {

				E21ADTO obj = new E21ADTO();
				obj.setCedula(result.getString(1));
				obj.setEstudiante(result.getString(2));
				obj.setSexo(result.getString(3));
				obj.setCodigo(result.getString(4));
				obj.setFacultad(result.getString(5));
				obj.setCarrera(result.getString(6));
				obj.setPeriodoInicio(result.getString(7));
				obj.setPeriodoMatricula(result.getString(8));
				obj.setGraduado(result.getString(9));
				obj.setSemestre(pensum.getMeses());

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<PeriodosSAEWDTO> periodosSAEW() {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// pa_saeperiodonl 'L'

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeperiodon (?)}");

			cst.setString(1, "L");

			result = cst.executeQuery();
			List<PeriodosSAEWDTO> list = new ArrayList<>();

			while (result.next()) {

				PeriodosSAEWDTO obj = new PeriodosSAEWDTO();
				obj.setPeriodo(result.getString(3));
				obj.setAnioMat(result.getString(2));
				obj.setSemMat(result.getString(1));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<E21ADTO> E222(FacultadCatalogos facultad, Carrera carrera, PeriodosSAEWDTO perIngresoD,
			PeriodosSAEWDTO perIngresoA, PeriodosSAEWDTO perGradoD, PeriodosSAEWDTO perGradoA) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// pa_graduadosvia 'LA','INGENIERIA DE
			// SISTEMAS','07','2017','2','2010','2','2017','2','2016','2','',''

			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_graduadosvia (?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LA");
			cst.setString(2, facultad.getNomFacultad());
			cst.setString(3, carrera.getIdCarrera());
			cst.setString(4, perIngresoD.getAnioMat());
			cst.setString(5, perIngresoD.getSemMat());
			cst.setString(6, perIngresoA.getAnioMat());
			cst.setString(7, perIngresoA.getSemMat());
			cst.setString(8, perGradoD.getAnioMat());
			cst.setString(9, perGradoD.getSemMat());
			cst.setString(10, perGradoA.getSemMat());
			cst.setString(11, perGradoD.getSemMat());
			cst.setString(12, "");
			cst.setString(13, "");

			result = cst.executeQuery();
			List<E21ADTO> list = new ArrayList<>();

			while (result.next()) {

				E21ADTO obj = new E21ADTO();
				obj.setCedula(result.getString(1));
				obj.setEstudiante(result.getString(2));
				obj.setSexo(result.getString(3));
				obj.setCodigo(result.getString(4));
				obj.setFacultad(result.getString(5));
				obj.setCarrera(result.getString(6));
				obj.setPeriodoInicio(result.getString(7));
				obj.setPeriodoMatricula(result.getString(8));
				obj.setGraduado(result.getString(9));
				obj.setTotalPeriodos(result.getString(10));
				obj.setTotalPeriodosInactivos(result.getString(11));

				list.add(obj);
			}
			result.close();
			sql.closeConnection();
			return list;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	/*************************************************************************************/
	public static void main(String[] args) {

		procedimientosAlmacenados sp = new procedimientosAlmacenados();
		// pa_contsilabo 'CF','07','','','','',2017,1

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_contsilabo (?,?,?,?,?,?,?,?)}");

			cst.setString(1, "CF");
			cst.setString(2, "07");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setString(7, "2017");
			cst.setString(8, "1");

			result = cst.executeQuery();
			int x = 1;
			while (result.next()) {

				System.out.println("Datos" + result.getString(x));
				x++;

			}
			result.close();
			sql.closeConnection();

		} catch (Exception e) {

		} finally {
			sql.closeConnection();
		}
	}

	public List<CargaAcademica> obtenerCargaAcademica(String cedula, Pensum p) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontparalca (?,?,?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, cedula);
			cst.setString(3, "");
			cst.setString(4, "");

			cst.setString(5, p.getAñoPensum());
			cst.setString(6, p.getNumeroPensum());

			result = cst.executeQuery();
			List<CargaAcademica> listaCarga = new ArrayList<CargaAcademica>();
			while (result.next()) {

				CargaAcademica carga = new CargaAcademica();

				Pedido pedido = new Pedido();
				carga.setCodmatsaew(result.getString(1));
				carga.setNommatsaew(result.getString(2));
				carga.setParalelo(result.getString(3));
				carga.setNumHorasSemana(Integer.parseInt(result.getString(4)));
				carga.setNumHorasModulo(result.getInt((5)));
				// usado para especificar el aula y el nuemro de sesiones
				// describe el aula

				// usado para las fechas de inicio y fin modulares
				// describe la fecha inicio
				pedido.setObservacionautorizacion(result.getString(15));
				// describe la fecha fin
				pedido.setObservaciones(result.getString(16));
				carga.setPedido(pedido);
				carga.setNomcarrerasaew(result.getString(17));
				listaCarga.add(carga);
			}
			result.close();
			sql.closeConnection();
			return listaCarga;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}

	}

	public List<HorarioDTO> obtenerCargaAcademicaExtendida(String cedula) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontparalca (?,?,?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, cedula);
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());

			result = cst.executeQuery();
			List<HorarioDTO> listaHorario = new ArrayList<HorarioDTO>();
			while (result.next()) {

				HorarioDTO horario = new HorarioDTO();
				horario.setCodmateria(result.getString(1));
				horario.setMateria(result.getString(2));
				horario.setParalelo(result.getString(3));
				horario.setHorasSemana(result.getString(4));
				horario.setHorasModulo(result.getString(5));
				horario.setAula(result.getString(6));

				horario.setLunes(result.getString(9));
				horario.setMartes(result.getString(10));
				horario.setMiercoles(result.getString(11));
				horario.setJueves(result.getString(12));
				horario.setViernes(result.getString(13));
				horario.setSabado(result.getString(14));
				horario.setFechaInicial(result.getString(15));
				horario.setFechaFinal(result.getString(16));
				horario.setCarrera(result.getString(17));
				horario.setMarcaModular(result.getString(21));

				if (horario.getIdHora() == null)
					horario.setIdHora("");
				if (horario.getCodmateria() == null)
					horario.setCodmateria("");
				if (horario.getMateria() == null)
					horario.setMateria("");
				if (horario.getParalelo() == null)
					horario.setParalelo("");
				if (horario.getHorasSemana() == null)
					horario.setHorasSemana("");
				if (horario.getHorasModulo() == null)
					horario.setHorasModulo("");
				if (horario.getAula() == null)
					horario.setAula("");
				if (horario.getLunes() == null)
					horario.setLunes("");
				if (horario.getMartes() == null)
					horario.setMartes("");
				if (horario.getMiercoles() == null)
					horario.setMiercoles("");
				if (horario.getJueves() == null)
					horario.setJueves("");
				if (horario.getViernes() == null)
					horario.setViernes("");
				if (horario.getSabado() == null)
					horario.setSabado("");
				if (horario.getFechaInicial() == null)
					horario.setFechaInicial("");
				if (horario.getFechaFinal() == null)
					horario.setFechaFinal("");
				if (horario.getMarcaModular() == null)
					horario.setMarcaModular("");

				listaHorario.add(horario);
			}

			result.close();
			sql.closeConnection();
			return listaHorario;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}

	}

	public List<TesisDirigidasDTO> obtenerTesisDirigida(String cedula) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontesis (?,?)}");

			cst.setString(1, "TT");
			cst.setString(2, cedula);

			result = cst.executeQuery();
			List<TesisDirigidasDTO> listaTesis = new ArrayList<TesisDirigidasDTO>();
			while (result.next()) {

				TesisDirigidasDTO tesis = new TesisDirigidasDTO();
				tesis.setTemaTesis(result.getString(1));
				tesis.setAreaTesis(result.getString(2));
				tesis.setLineaInvest(result.getString(3));
				tesis.setDepartamentoTesis(result.getString(4));
				tesis.setFechaVencimiento(result.getString(5));

				listaTesis.add(tesis);

			}
			result.close();
			sql.closeConnection();
			return listaTesis;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}

	}

	public List<Carrera> obtenerCarreras(int nivel) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatcarrera (?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "L");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setInt(4, nivel);

			// Ejecuta el procedimiento almacenado
			result = cst.executeQuery();
			List<Carrera> listaCarrear = new ArrayList<Carrera>();
			while (result.next()) {
				Carrera carrera = new Carrera();
				carrera.setIdCarrera(result.getString(1));
				carrera.setNomCarrera(result.getString(2));
				listaCarrear.add(carrera);
			}
			result.close();

			sql.closeConnection();
			return listaCarrear;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}

	}

	public List<String> pa_saecontprofeLD() {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontprofe (?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "LD");

			// Ejecuta el procedimiento almacenado

			result = cst.executeQuery();
			List<String> listaCedulas = new ArrayList<String>();
			while (result.next()) {
				String cedula = "";
				cedula = result.getString(1);
				listaCedulas.add(cedula);
			}
			result.close();
			sql.closeConnection();
			return listaCedulas;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<String> pa_saecontprofeD(String cedula) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontprofe (?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "D");
			cst.setString(2, cedula);

			// Ejecuta el procedimiento almacenado

			result = cst.executeQuery();
			List<String> lista = new ArrayList<String>();
			while (result.next()) {
				lista.add(result.getString(1));
			}
			result.close();
			sql.closeConnection();
			return lista;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<String> pa_saedatparalISP(String opcion, String codCarrera, String codMateria, String paral,
			String cedula, String user) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saedatparalI (?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			/**
			 * pa_saedatparalI
			 * SP,'142','msa430','GR1',2017,1,'','','BE913159','','','','saei'
			 */

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, opcion);
			cst.setString(2, codCarrera);
			cst.setString(3, codMateria);
			cst.setString(4, paral);
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());
			cst.setString(7, "");
			cst.setString(8, "");
			cst.setString(9, cedula);

			cst.setString(10, "");
			cst.setString(11, "");
			cst.setString(12, "");
			cst.setString(13, user);

			// Ejecuta el procedimiento almacenado
			// cst.execute();

			result = cst.executeQuery();
			List<String> lista = new ArrayList<String>();
			while (result.next()) {
				lista.add(result.getString(1));
			}

			System.out.println("MWENSAJE: " + lista);
			result.close();
			sql.closeConnection();
			return lista;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<Materia> obtenerMateriasLaboratorio(String codCarrera, String codMateria, String nomMateria,
			String nomCarrera) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparal (?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "TD");
			cst.setString(2, codCarrera);
			cst.setString(3, codMateria);
			cst.setString(4, "%" + nomMateria + "%");
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());
			result = cst.executeQuery();
			List<Materia> listaMateria = new ArrayList<Materia>();

			while (result.next()) {
				Materia materia = new Materia();
				materia.setCodMateria(result.getString(1));
				materia.setNombreMateria(result.getString(2));
				materia.setCarreraMateria(result.getString(3));
				listaMateria.add(materia);
			}
			result.close();

			sql.closeConnection();
			return listaMateria;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<Materia> obtenerMateriasSNNA(String codCarrera, String codMateria, String nomMateria,
			String nomCarrera) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparal (?,?,?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "TD");
			cst.setString(2, codCarrera);
			cst.setString(3, codMateria);
			cst.setString(4, "%" + nomMateria + "%");
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());
			cst.setString(7, "");
			cst.setString(8, "x");

			result = cst.executeQuery();
			List<Materia> listaMateria = new ArrayList<Materia>();
			while (result.next()) {
				Materia materia = new Materia();
				materia.setCodMateria(result.getString(1));
				materia.setNombreMateria(result.getString(2));
				materia.setCarreraMateria(result.getString(3));

				listaMateria.add(materia);
			}
			result.close();

			sql.closeConnection();
			return listaMateria;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<Materia> obtenerMaterias(String codCarrera, String codMateria, String nomMateria, String nomCarrera) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparal (?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "M");
			cst.setString(2, codCarrera);
			cst.setString(3, codMateria);
			cst.setString(4, nomMateria);
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());

			// Ejecuta el procedimiento almacenado

			result = cst.executeQuery();
			List<Materia> listaMateria = new ArrayList<Materia>();
			while (result.next()) {
				Materia materia = new Materia();
				materia.setCodMateria(result.getString(1));
				materia.setNombreMateria(result.getString(2));
				materia.setCarreraMateria(result.getString(3));

				listaMateria.add(materia);

			}
			result.close();
			sql.closeConnection();
			return listaMateria;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<Materia> obtenerMateriasConvenio(String codCarrera, String codMateria, String nomMateria,
			String nomCarrera) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparal (?,?,?,?,?,?)}");

			cst.setString(1, "A");
			cst.setString(2, codCarrera);
			cst.setString(3, codMateria);
			cst.setString(4, nomMateria);
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());
			result = cst.executeQuery();

			List<Materia> listaMateria = new ArrayList<Materia>();
			while (result.next()) {

				Materia materia = new Materia();
				materia.setCodMateria(result.getString(1));
				materia.setNombreMateria(result.getString(2));
				materia.setCarreraMateria(result.getString(3));

				listaMateria.add(materia);
			}
			result.close();
			sql.closeConnection();
			return listaMateria;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public String verificarDatosParaConvenios(String opcion, String cedula, String codmateria) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();

		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado pa_saedatcontratoest
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatcontratoest (?,?,?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, opcion);
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, cedula);
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setString(7, "");
			cst.setString(8, codmateria);

			// Ejecuta el procedimiento almacenado
			result = cst.executeQuery();
			String respuesta = "";
			while (result.next()) {
				respuesta = result.getString(4);
			}

			result.close();
			sql.closeConnection();
			return respuesta;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<CargaAcademica> obtenerCarga(String codCarrera, String codMat) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();

		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparal (?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "P");
			cst.setString(2, codCarrera);
			cst.setString(3, codMat);
			cst.setString(4, "");
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());

			// Ejecuta el procedimiento almacenado
			result = cst.executeQuery();
			List<CargaAcademica> listacarga = new ArrayList<CargaAcademica>();
			while (result.next()) {
				CargaAcademica carga = new CargaAcademica();
				carga.setNumHorasModulo(result.getInt(5));
				carga.setNumHorasSemana(result.getInt(3));
				carga.setParalelo(result.getString(4));
				carga.setNomcarrerasaew(result.getString(6));
				listacarga.add(carga);

			}
			result.close();
			sql.closeConnection();
			return listacarga;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public void consultarPedidosInsertSAE(Pedido pedido) {
		/** INGRESO SAEW PROFESORES */
		conexionSQL sql = new conexionSQL();
		try {

			SimpleDateFormat fom = new SimpleDateFormat("dd/MM/yyyy");
			sql.getConnection();
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saecontprofe (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, "I");
			cst.setString(2, pedido.getNced());
			cst.setString(3, pedido.getNombresDocente());
			cst.setString(4, fom.format(pedido.getFechaNacimiento()));
			cst.setString(5, pedido.getEstadoCivil().substring(0, 1));
			cst.setString(6, pedido.getTelefonoDocente());
			cst.setString(7, pedido.getEmailDocente());
			cst.setString(8, "");
			cst.setString(9, fom.format(new Date()));
			cst.setString(10, pedido.getRelacionActual().trim().toUpperCase());

			if (pedido.getDedicacion().equals("TIEMPO COMPLETO"))
				cst.setString(11, "T.COMPLETO");
			else if (pedido.getDedicacion().equals("TIEMPO PARCIAL"))
				cst.setString(11, "T.PARCIAL");
			/** SE AGREGA ESTA OPCION MEDIO T. 01-03-2017 */
			else if (pedido.getDedicacion().equals("MEDIO TIEMPO"))
				cst.setString(11, "MEDIO T.");
			else
				cst.setString(11, "CONTRATO");

			cst.setString(12, pedido.getUsuario().getNombreUsuario());
			cst.setString(13, "CONTRATO");
			cst.setString(14, "ACTIVO");
			cst.setString(15, pedido.getSexo().substring(0, 1));
			cst.setString(16, pedido.getCodDep());

			cst.executeUpdate();
			sql.closeConnection();

		} catch (Exception e) {

		} finally {
			sql.closeConnection();
		}
	}

	public void consultarPedidosTituloInsertSAE(List<TitulosDocente> docenteTitulos) {
		SimpleDateFormat fom = new SimpleDateFormat("dd/MM/yy");
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();
			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontitulo (?,?,?,?,?,?,?)}");

			for (TitulosDocente titulos : docenteTitulos) {

				java.util.Date today = new java.util.Date();
				java.sql.Date dateNow = new java.sql.Date(titulos.getFechaRegistro().getTime());
				// Parametro 1 del procedimiento almacenado
				cst.setString(1, "I");
				cst.setString(2, titulos.getCedulaDocente());
				cst.setString(3, titulos.getTituloDocente());
				cst.setString(4, titulos.getRegistroSecescDocente());
				cst.setString(5, fom.format(titulos.getFechaRegistro()));
				cst.setString(6, titulos.getUniversidad());
				cst.setString(7, titulos.getPedido().getUsuario().getNombreUsuario());
				// Ejecuta el procedimiento almacenado
				cst.executeUpdate();
			}
			sql.closeConnection();

		} catch (Exception e) {

		} finally {
			sql.closeConnection();
		}
	}

	public List<CargaAcademica> pa_chequeacruce(String codCarrera, String codMat) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();

		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_chequeacruce (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "P");
			cst.setString(2, codCarrera);
			cst.setString(3, codMat);
			cst.setString(4, "");
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());

			// Ejecuta el procedimiento almacenado
			result = cst.executeQuery();

			List<CargaAcademica> listacarga = new ArrayList<CargaAcademica>();
			while (result.next()) {
				CargaAcademica carga = new CargaAcademica();
				carga.setNumHorasModulo(result.getInt(5));
				carga.setNumHorasSemana(result.getInt(3));
				carga.setParalelo(result.getString(4));
				listacarga.add(carga);

			}
			result.close();

			sql.closeConnection();
			return listacarga;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public String pa_saedatchequeacruce(String tipo, String codCarrera, String cedula, String codMat, String paral,
			String horario1, String horario2, String codEdificio, String codAula, String fecha1, String fecha2) {
		java.sql.ResultSet result = null;
		String mensajeSaew = "";
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			String j = "pa_saedatchequeacruce 'P','07','1716247257','SIC412','GR1','        10  ','        12  ','2014','2'";
			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saedatchequeacruce (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, tipo);
			cst.setString(2, codCarrera);
			cst.setString(3, cedula);
			cst.setString(4, codMat);
			cst.setString(5, paral);
			cst.setString(6, horario1);
			cst.setString(7, horario2);
			cst.setString(8, pensumVigente.getAñoPensum());
			cst.setString(9, pensumVigente.getNumeroPensum());
			cst.setString(10, "");
			cst.setString(11, "");
			cst.setString(12, "");
			cst.setString(13, codEdificio);
			cst.setString(14, codAula);
			cst.setString(15, fecha1);
			cst.setString(16, fecha2);

			result = cst.executeQuery();

			while (result.next()) {
				mensajeSaew = result.getString(1);
			}
			result.close();
			sql.closeConnection();
			return mensajeSaew;

		} catch (Exception e) {

			sql.closeConnection();
			return mensajeSaew;
		} finally {
			sql.closeConnection();
		}
	}

	public List<DatosSaew> pa_saedatparalINuevo(String opcion, String codCarrera, String codMat, String paral) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();

		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparalI (?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			/**
			 * C PARA LOS DATOS GENERALES, LAS MATERIAS S PARA LOS DATOS DE
			 * HORARIOS FECHAS
			 */

			cst.setString(1, opcion);
			cst.setString(2, codCarrera);
			cst.setString(3, codMat);
			cst.setString(4, paral);
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());
			result = cst.executeQuery();

			List<DatosSaew> listaDatosSaew = new ArrayList<DatosSaew>();
			while (result.next()) {
				DatosSaew datos = new DatosSaew();

				// DATOS GENERALES
				datos.setCodMateria(result.getString(1));
				datos.setNomMateria(result.getString(2));
				datos.setParalelo(result.getString(3));
				datos.setCupo(result.getString(6));
				datos.setCodPRF(result.getString(7));
				datos.setNomProfesor(result.getString(8));
				datos.setHoras(result.getString(9));
				datos.setNroSesiones(result.getString(10));

				// Primera sesion
				datos.setCodEdificio(result.getString(4));
				datos.setCodAula(result.getString(5));
				datos.setLunes1(result.getString(11));
				datos.setLunes2(result.getString(12));
				datos.setMartes1(result.getString(13));
				datos.setMartes2(result.getString(14));
				datos.setMiercoles1(result.getString(15));
				datos.setMiercoles2(result.getString(16));
				datos.setJueves1(result.getString(17));
				datos.setJueves2(result.getString(18));
				datos.setViernes1(result.getString(19));
				datos.setViernes2(result.getString(20));
				datos.setSabado1(result.getString(21));
				datos.setSabado2(result.getString(22));

				// Segunda sesion
				datos.setCodEdificio1(result.getString(39));
				datos.setCodAula1(result.getString(40));
				datos.setLunes12(result.getString(23));
				datos.setLunes22(result.getString(24));
				datos.setMartes12(result.getString(25));
				datos.setMartes22(result.getString(26));
				datos.setMiercoles12(result.getString(27));
				datos.setMiercoles22(result.getString(28));
				datos.setJueves12(result.getString(29));
				datos.setJueves22(result.getString(30));
				datos.setViernes12(result.getString(31));
				datos.setViernes22(result.getString(32));
				datos.setSabado12(result.getString(33));
				datos.setSabado22(result.getString(34));

				// Fechas, horas fechas y horas
				datos.setFechaInicio(result.getString(35));
				datos.setFechaFin(result.getString(36));
				datos.setHorarioFechas(result.getString(37));
				datos.setHoras12(result.getString(38));

				// Tercera Sesion
				datos.setCodEdificio2(result.getString(41));
				datos.setCodAula2(result.getString(42));
				datos.setLunes13(result.getString(43));
				datos.setLunes23(result.getString(44));
				datos.setMartes13(result.getString(45));
				datos.setMartes23(result.getString(46));
				datos.setMiercoles13(result.getString(47));
				datos.setMiercoles23(result.getString(48));
				datos.setJueves13(result.getString(49));
				datos.setJueves23(result.getString(50));
				datos.setViernes13(result.getString(51));
				datos.setViernes23(result.getString(52));
				datos.setSabado13(result.getString(53));
				datos.setSabado23(result.getString(54));

				// Indice contrato y nivel
				datos.setIndiceContrato(result.getString(55));
				datos.setNivel(result.getString(56));
				datos.setSimultano(result.getString(57));

				// AÑADO LOS DATOS
				listaDatosSaew.add(datos);
			}

			result.close();

			sql.closeConnection();
			return listaDatosSaew;
		} catch (Exception e) {
			sql.closeConnection();
			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<String> pa_saedatparalI(String codCarrera, String codMat, String paral) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();

		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparalI (?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "C");
			cst.setString(2, codCarrera);
			cst.setString(3, codMat);
			cst.setString(4, paral);
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());

			// Ejecuta el procedimiento almacenado
			result = cst.executeQuery();

			List<String> listacarga = new ArrayList<String>();
			while (result.next()) {
				listacarga.add(result.getString(1));
				listacarga.add(result.getString(2));
				listacarga.add(result.getString(3));
				listacarga.add(result.getString(4));
				listacarga.add(result.getString(5));
				listacarga.add(result.getString(6));
				listacarga.add(result.getString(7));
				listacarga.add(result.getString(8));
				listacarga.add(result.getString(9));
				listacarga.add(result.getString(10));

				// Primera sesion
				listacarga.add(result.getString(11));
				listacarga.add(result.getString(12));
				listacarga.add(result.getString(13));
				listacarga.add(result.getString(14));
				listacarga.add(result.getString(15));
				listacarga.add(result.getString(16));
				listacarga.add(result.getString(17));
				listacarga.add(result.getString(18));
				listacarga.add(result.getString(19));
				listacarga.add(result.getString(20));
				listacarga.add(result.getString(21));
				listacarga.add(result.getString(22));

				// Segunda sesion
				listacarga.add(result.getString(23));
				listacarga.add(result.getString(24));
				listacarga.add(result.getString(25));
				listacarga.add(result.getString(26));
				listacarga.add(result.getString(27));
				listacarga.add(result.getString(28));
				listacarga.add(result.getString(29));
				listacarga.add(result.getString(30));
				listacarga.add(result.getString(31));
				listacarga.add(result.getString(32));
				listacarga.add(result.getString(33));
				listacarga.add(result.getString(34));
				listacarga.add(result.getString(35));
				listacarga.add(result.getString(36));
				listacarga.add(result.getString(37));

				listacarga.add(result.getString(38));

				// Tercera Sesion

				listacarga.add(result.getString(43));
				listacarga.add(result.getString(44));
				listacarga.add(result.getString(45));
				listacarga.add(result.getString(46));
				listacarga.add(result.getString(47));
				listacarga.add(result.getString(48));
				listacarga.add(result.getString(49));
				listacarga.add(result.getString(50));
				listacarga.add(result.getString(51));
				listacarga.add(result.getString(52));
				listacarga.add(result.getString(53));
				listacarga.add(result.getString(53));
				listacarga.add(result.getString(56));
				listacarga.add(result.getString(55));
				listacarga.add(result.getString(57));

			}
			result.close();

			sql.closeConnection();
			return listacarga;
		} catch (Exception e) {
			sql.closeConnection();
			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public List<DatosSaew> pa_saedatparalIS(String codCarrera, String codMat, String paral) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();

		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparalI (?,?,?,?,?,?)}");
			cst.setString(1, "S");
			cst.setString(2, codCarrera);
			cst.setString(3, codMat);
			cst.setString(4, paral);
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());

			result = cst.executeQuery();

			List<DatosSaew> listaDatosSaew = new ArrayList<DatosSaew>();
			while (result.next()) {
				DatosSaew datos = new DatosSaew();
				datos.setCodMateria(result.getString(1));
				datos.setNomMateria(result.getString(2));
				datos.setParalelo(result.getString(3));
				datos.setCodEdificio(result.getString(4));
				datos.setCodAula(result.getString(5));
				datos.setCupo(result.getString(6));
				datos.setCodPRF(result.getString(7));
				datos.setNomProfesor(result.getString(8));
				datos.setHoras(result.getString(9));
				datos.setNroSesiones(result.getString(10));

				// Primera sesion
				datos.setLunes1(result.getString(11));
				datos.setLunes2(result.getString(12));
				datos.setMartes1(result.getString(13));
				datos.setMartes2(result.getString(14));
				datos.setMiercoles1(result.getString(15));
				datos.setMiercoles2(result.getString(16));
				datos.setJueves1(result.getString(17));
				datos.setJueves2(result.getString(18));
				datos.setViernes1(result.getString(19));
				datos.setViernes2(result.getString(20));
				datos.setSabado1(result.getString(21));
				datos.setSabado2(result.getString(22));

				// Segunda sesion
				datos.setLunes12(result.getString(23));
				datos.setLunes22(result.getString(24));
				datos.setMartes12(result.getString(25));
				datos.setMartes22(result.getString(26));
				datos.setMiercoles12(result.getString(27));
				datos.setMiercoles22(result.getString(28));
				datos.setJueves12(result.getString(29));
				datos.setJueves22(result.getString(30));
				datos.setViernes12(result.getString(31));
				datos.setViernes22(result.getString(32));
				datos.setSabado12(result.getString(33));
				datos.setSabado22(result.getString(34));

				// Fechas, horas fechas y horas
				datos.setFechaInicio(result.getString(35));
				datos.setFechaFin(result.getString(36));
				datos.setHorarioFechas(result.getString(37));
				datos.setHoras12(result.getString(38));

				// Tercera Sesion
				datos.setLunes13(result.getString(39));
				datos.setLunes23(result.getString(40));
				datos.setMartes13(result.getString(41));
				datos.setMartes23(result.getString(42));
				datos.setMiercoles13(result.getString(43));
				datos.setMiercoles23(result.getString(44));
				datos.setJueves13(result.getString(45));
				datos.setJueves23(result.getString(46));
				datos.setViernes13(result.getString(47));
				datos.setViernes23(result.getString(48));
				datos.setSabado13(result.getString(49));
				datos.setSabado23(result.getString(50));

				// Indice contrato y nivel
				datos.setIndiceContrato(result.getString(51));
				datos.setNivel(result.getString(52));

				listaDatosSaew.add(datos);
			}

			result.close();

			sql.closeConnection();
			return listaDatosSaew;
		} catch (Exception e) {
			sql.closeConnection();
			return null;
		}

		finally {
			sql.closeConnection();
		}
	}

	public List<DatosSaewHorariosFechas> pa_saedatparalIFS(String codCarrera, String codMat, String paral,
			String cedula) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();

		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparalI (?,?,?,?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "FS");
			cst.setString(2, codCarrera);
			cst.setString(3, codMat);
			cst.setString(4, paral);
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());
			cst.setString(7, "");
			cst.setString(8, "");
			cst.setString(9, cedula);

			// Ejecuta el procedimiento almacenado
			result = cst.executeQuery();
			List<DatosSaewHorariosFechas> listaDatosSaew = new ArrayList<DatosSaewHorariosFechas>();

			while (result.next()) {
				DatosSaewHorariosFechas datos = new DatosSaewHorariosFechas();
				datos.setCodCar(result.getString(1));
				datos.setCodMat(result.getString(2));
				datos.setParalelo(result.getString(3));
				datos.setHora1(result.getString(4));
				datos.setHora2(result.getString(5));
				datos.setFecha(result.getString(6));
				listaDatosSaew.add(datos);

			}
			result.close();
			sql.closeConnection();
			return listaDatosSaew;
		} catch (Exception e) {
			sql.closeConnection();
			return null;
		} finally {
			sql.closeConnection();
		}
	}

	public String pa_saedatparalI(String codCarrera, String codMat, String paral, String cedula, String user,
			String cedulaSimultaneo, Pedido pedido) {

		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		String mensajeSaew = "";
		try {

			sql.getConnection();
			SimpleDateFormat fom = new SimpleDateFormat("dd/MM/yyyy");

			System.out.println("DATOS: " + pedido.getFechaFin());
			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saedatparalI (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			/**
			 * pa_saedatparalI
			 * U,'142','msa430','GR1',2017,1,'','','9900000010','','','','saei',
			 * '','','','',1,'BE913159','','PROFESOR A TIEMPO
			 * COMPLETO','CONTRATO OCASIONAL'
			 */

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "U");
			cst.setString(2, codCarrera);
			cst.setString(3, codMat);
			cst.setString(4, paral);
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());
			cst.setString(7, "");
			cst.setString(8, "");
			cst.setString(9, cedula);

			cst.setString(10, "");
			cst.setString(11, "");
			cst.setString(12, "");
			cst.setString(13, user);
			cst.setString(14, "");
			cst.setString(15, "");
			cst.setString(16, "");
			cst.setString(17, "");
			cst.setInt(18, 1);
			cst.setString(19, cedulaSimultaneo);
			cst.setString(20, pedido.getFechaFin() == null ? "" : fom.format(pedido.getFechaFin()));
			cst.setString(21, pedido.getRelacionActual().toUpperCase().trim());

			cst.setString(22, pedido.getContrato());

			// cst.executeUpdate();
			result = cst.executeQuery();
			while (result.next()) {
				mensajeSaew = result.getString(1);
			}
			result.close();
			sql.closeConnection();
			return mensajeSaew;
		} catch (SQLException e) {
			sql.closeConnection();
			return e.getMessage();
		} finally {
			sql.closeConnection();
		}
	}

	public List<List<String>> pa_saedathorarf(String codCarrera, String codMat, String paral) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedathorarf (?,?,?,?,?,?)}");

			String j = "--pa_saedathorarf L,'07','SIC623','gr1',2014,2";

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "L");
			cst.setString(2, codCarrera);
			cst.setString(3, codMat);
			cst.setString(4, paral);
			cst.setString(5, pensumVigente.getAñoPensum());
			cst.setString(6, pensumVigente.getNumeroPensum());

			// Ejecuta el procedimiento almacenado
			result = cst.executeQuery();

			List<List<String>> listaFechas = new ArrayList<List<String>>();
			while (result.next()) {
				List<String> listaDatos = new ArrayList<String>();
				String f2 = result.getString(6).substring(8, 10) + "/" + result.getString(6).substring(5, 7) + "/"
						+ result.getString(6).substring(0, 4);

				listaDatos.add(result.getString(4));
				listaDatos.add(result.getString(5));
				listaDatos.add(f2);
				listaFechas.add(listaDatos);
			}

			result.close();
			sql.closeConnection();
			return listaFechas;
		} catch (Exception e) {
			sql.closeConnection();

			return null;
		} finally {
			sql.closeConnection();
		}
	}

	// RobertoPorcedures

	public String pa_saehoraradic(CargaAcademica carga) {

		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();
			// Llamada al procedimiento almacenado
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saehoraradic (?,?,?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "I");
			cst.setString(2, "");
			cst.setString(3, carga.getIdCarreraSaew().trim());
			cst.setString(4, carga.getCodmatsaew().trim());
			cst.setString(5, carga.getParalelo().trim());
			cst.setString(6, carga.getPedido().getNced());
			cst.setString(7, carga.getPedido().getPensum().getAñoPensum());
			cst.setString(8, carga.getPedido().getPensum().getNumeroPensum());

			cst.executeUpdate();
			sql.closeConnection();
			return "Se registro las horas adicionales";
		} catch (Exception e) {
			sql.closeConnection();
			return " No se ha nada en el saew";
		} finally {
			sql.closeConnection();
		}
	}

	public String pa_saehorasp(CargaAcademica carga) {
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();
			// Llamada al procedimiento almacenado

			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saehorasp (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "UA");
			cst.setString(2, "");
			cst.setString(3, carga.getIdCarreraSaew().trim());
			cst.setString(4, carga.getCodmatsaew().trim());
			cst.setString(5, carga.getParalelo().trim());
			cst.setString(6, carga.getPedido().getNced());
			cst.setString(7, "");
			cst.setString(8, "");
			cst.setString(9, carga.getPedido().getPensum().getAñoPensum());
			cst.setString(10, carga.getPedido().getPensum().getNumeroPensum());
			cst.setString(11, "");
			cst.setString(12, carga.getPedido().getTipoContrato().getNombreTcont().trim());
			cst.setString(13, carga.getPedido().getCategoria().getNombreCat().trim());
			cst.setDouble(14, carga.getPedido().getRmu());
			cst.setString(15, carga.getPedido().getUsuario().getNombreUsuario());
			cst.setString(16, "X");
			cst.setString(17, "");
			cst.setString(18, "");
			cst.setString(19, "X");

			cst.executeUpdate();
			sql.closeConnection();
			return "Se registro las saeHorasP";
		} catch (Exception e) {
			sql.closeConnection();
			return " No se ha nada en el saew";
		} finally {
			sql.closeConnection();
		}
	}

	public String pa_saehoraspcon(CargaAcademica carga) {

		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();
			// Llamada al procedimiento almacenado

			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saehoraspcon (?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			// Parametro 1 del procedimiento almacenado
			cst.setString(1, "U");
			cst.setString(2, "");
			cst.setString(3, carga.getIdCarreraSaew().trim());
			cst.setString(4, carga.getCodmatsaew().trim());
			cst.setString(5, carga.getParalelo().trim());
			cst.setString(6, carga.getPedido().getNced());
			cst.setString(7, carga.getPedido().getTipoContrato().getNombreTcont().trim());
			cst.setString(8, carga.getPedido().getCategoria().getNombreCat().trim());
			cst.setDouble(9, carga.getPedido().getRmu());
			cst.setString(10, carga.getPedido().getContrato());
			cst.setString(11, carga.getPedido().getPensum().getAñoPensum());
			cst.setString(12, carga.getPedido().getPensum().getNumeroPensum());
			cst.setString(13, carga.getPedido().getUsuario().getNombreUsuario());

			cst.executeUpdate();
			sql.closeConnection();
			return "Se registro las pa_saehoraspcon";
		} catch (Exception e) {
			sql.closeConnection();
			return " No se ha nada en el saew";
		} finally {
			sql.closeConnection();
		}
	}

	public String verificarMateriasAEliminar(List<CargaAcademica> carga) {

		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado pa_saedatcontratoest
			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatparalI (?,?,?,?,?,?,?,?,?)}");
			String respuesta = "";
			for (CargaAcademica c : carga) {
				// Parametro 1 del procedimiento almacenado
				java.sql.ResultSet result = null;
				respuesta = "";
				cst.setString(1, "M");
				cst.setString(2, "");
				cst.setString(3, c.getCodmatsaew());
				cst.setString(4, "");
				cst.setString(5, c.getPedido().getPensum().getAñoPensum());
				cst.setString(6, c.getPedido().getPensum().getNumeroPensum());
				cst.setString(7, "");
				cst.setString(8, "");
				cst.setString(9, c.getPedido().getNced());

				// Ejecuta el procedimiento almacenado
				result = cst.executeQuery();

				while (result.next()) {
					respuesta = result.getString(1);
				}
				result.close();

				if (respuesta.equals("SI")) {
					respuesta = "No se puede eliminar el Pedido. Se tiene información asociada en SAEW para la materia: "
							+ c.getCodmatsaew();
					break;
				}
			}

			sql.closeConnection();
			return respuesta;
		} catch (Exception e) {
			sql.closeConnection();
			return "";
		} finally {
			sql.closeConnection();
		}
	}

	public List<CargaPlanificacionDTO> obtenerCargaAcademicaPlanificacion(String cedula, String añoPensum,
			String numeroPensum) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontparalca (?,?,?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, cedula);
			cst.setString(3, "");
			cst.setString(4, "");

			cst.setString(5, añoPensum);
			cst.setString(6, numeroPensum);

			result = cst.executeQuery();
			List<CargaPlanificacionDTO> listaCargaPlanif = new ArrayList<CargaPlanificacionDTO>();
			while (result.next()) {
				CargaPlanificacionDTO carga = new CargaPlanificacionDTO();
				carga.setCodMateriaSAE(result.getString(1));
				carga.setNomMateriaSAE(result.getString(2));
				carga.setNomParaleloSAE(result.getString(3));
				carga.setHorasTotalSemanaSAE(Integer.parseInt(result.getString(4) == null ? "0" : result.getString(4)));
				carga.setHorasModuloSAE(Integer.parseInt(result.getString(5) == null ? "0" : result.getString(5)));
				carga.setNomCarreraSAE(result.getString(17));
				carga.setNumAlumnosSAE(Integer.parseInt(result.getString(19)));

				if (result.getString(20) == null || result.getString(20).equals("null")
						|| result.getString(20).equals("")) {
					carga.setCapacidadAlumnosSAE(0);
				} else {
					carga.setCapacidadAlumnosSAE(Integer.parseInt(result.getString(20)));
				}
				listaCargaPlanif.add(carga);
			}
			result.close();
			sql.closeConnection();
			return listaCargaPlanif;
		} catch (Exception e) {
			sql.closeConnection();
			return null;
		} finally {
			sql.closeConnection();
		}

	}

	/** SE OBTIENE TODAS LAS CARRERAS EN LA EPN */
	public List<CarreraDTO> obtenerCarrerasFacultad(int nivel) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatcarrera (?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setInt(4, nivel);

			result = cst.executeQuery();
			List<CarreraDTO> listaCarrear = new ArrayList<CarreraDTO>();
			while (result.next()) {
				CarreraDTO carrera = new CarreraDTO();
				carrera.setIdCarrera(result.getString(1));
				carrera.setNombCarrera(result.getString(2));
				carrera.setNombFacultad(result.getString(3));

				switch (carrera.getNombFacultad()) {
				case "CIENCIAS":
					carrera.setIdFacultad(1);
					break;
				case "CIENCIAS ADMINISTRATIVAS":
					carrera.setIdFacultad(2);
					break;
				case "DOCTORADOS":
					carrera.setIdFacultad(21);
					break;
				case "GEOLOGIA Y PETROLEOS":
					carrera.setIdFacultad(3);
					break;
				case "INGENIERIA":
					carrera.setIdFacultad(4);
					break;
				case "INGENIERIA CIVIL":
					carrera.setIdFacultad(4);
					break;
				case "INGENIERIA DE SISTEMAS":
					carrera.setIdFacultad(5);
					break;
				case "INGENIERIA ELECTRICA Y ELECTRONICA":
					carrera.setIdFacultad(6);
					break;
				case "INGENIERIA MECANICA":
					carrera.setIdFacultad(7);
					break;
				case "INGENIERIA QUIMICA Y AGROINDUSTRIA":
					carrera.setIdFacultad(8);
					break;
				case "NIVELACION":
					carrera.setIdFacultad(19);
					break;
				case "SOCIALES":
					carrera.setIdFacultad(17);
					break;
				case "TECNOLOGICA":
					carrera.setIdFacultad(9);
					break;
				case "IDIOMAS":
					carrera.setIdFacultad(20);
					break;
				case "ADMISIONES":
					carrera.setIdFacultad(16);
					break;
				case "N/E":
					carrera.setIdFacultad(16);
					break;
				case "SIN FACULTAD":
					carrera.setIdFacultad(16);
					break;
				}
				listaCarrear.add(carrera);
			}
			result.close();

			sql.closeConnection();
			return listaCarrear;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}

	}

	/** SE OBTIENE EL DOCUMENTO DE IDENTIDAD DE LOS DOCENTES POR CARRERA */
	public List<DocenteDTO> obtenerNumCedDocenteCarrera(String idCarrera, Pensum p) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontparalca (?,?,?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");

			cst.setString(5, p.getAñoPensum());
			cst.setString(6, p.getNumeroPensum());
			cst.setString(7, idCarrera);

			result = cst.executeQuery();
			List<DocenteDTO> listaNumDocente = new ArrayList<DocenteDTO>();
			while (result.next()) {

				DocenteDTO numDocente = new DocenteDTO();
				numDocente.setnCed(result.getString(21));
				listaNumDocente.add(numDocente);
			}
			result.close();
			sql.closeConnection();
			return listaNumDocente;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}

	}

	public String pa_saesilaboprf(String codcar, String codprf, String codmat, Integer anomat, Integer semmat,
			String paralo, Integer horas, String fecha, Integer hora1, Integer hora2, String tema, String capitulo,
			String usuario, String opcion) {

		conexionSQL sql = new conexionSQL();

		try {

			sql.getConnection();
			// Llamada al procedimiento almacenado

			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saesilaboprf (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			// Parametro 1 del procedimiento almacenado

			cst.setString(1, opcion);
			cst.setString(2, codcar);
			cst.setString(3, codprf);
			cst.setString(4, codmat);
			cst.setString(5, paralo);
			cst.setString(6, tema);
			cst.setString(7, capitulo);
			cst.setInt(8, anomat);
			cst.setInt(9, semmat);
			cst.setInt(10, horas);
			cst.setInt(11, hora1);
			cst.setInt(12, hora2);
			cst.setString(13, fecha);
			cst.setString(14, usuario);
			cst.executeUpdate();
			sql.closeConnection();
			return "S";
		} catch (Exception e) {
			sql.closeConnection();
			return "N";
		} finally {
			sql.closeConnection();
		}
	}

	public List<MateriaDTO> pa_contsilabo(String codcar, String codprf, String codmat, Integer anomat, Integer semmat,
			String paralo) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();
			// Llamada al procedimiento almacenado

			CallableStatement cst = sql.getConection().prepareCall("{call pa_contsilabo (?,?,?,?,?,?,?,?)}");
			// Parametro 1 del procedimiento almacenado

			cst.setString(1, "L");
			cst.setString(2, codcar);
			cst.setString(3, codprf);
			cst.setString(4, "");
			cst.setString(5, codmat);
			cst.setString(6, paralo);
			cst.setInt(7, anomat);
			cst.setInt(8, semmat);
			result = cst.executeQuery();
			List<MateriaDTO> listaMaterias = new ArrayList<MateriaDTO>();
			while (result.next()) {

				MateriaDTO materia = new MateriaDTO();
				materia.setCodmat(result.getString(1));
				materia.setMateria(result.getString(2));
				materia.setParalelo(result.getString(3));
				materia.setHoras(result.getString(4));
				materia.setAula(result.getString(5));
				materia.setUbicacion(result.getString(6));
				materia.setFuncion(result.getString(7));
				materia.setEst(result.getString(8));
				materia.setNroSesiones(result.getString(9));
				materia.setLunes(result.getString(10));
				materia.setMartes(result.getString(11));
				materia.setMiercoles(result.getString(12));
				materia.setJueves(result.getString(13));
				materia.setViernes(result.getString(14));
				materia.setSabado(result.getString(15));
				materia.sethSimul(result.getString(16));
				materia.setFechaI(result.getString(17));
				materia.setFechaF(result.getString(18));
				materia.setHorarioF(result.getString(19));
				materia.setCodcar(result.getString(20));
				materia.setCarrera(result.getString(21));
				materia.setFacultad(result.getString(22));
				listaMaterias.add(materia);
			}
			result.close();
			sql.closeConnection();
			return listaMaterias;
		} catch (Exception e) {

			return null;
		} finally {
			sql.closeConnection();
		}

	}

	public String fechaPasoMateria(String opcion, String codcarre, String cedula, String codmar, String paralelo,
			Integer anomat, Integer semmat) {
		conexionSQL sql = new conexionSQL();
		try {

			java.sql.ResultSet result = null;
			String mensajeSaew = "";

			sql.getConnection();
			// Llamada al procedimiento almacenado

			CallableStatement cst = sql.getConection().prepareCall("{call pa_contsilabo (?,?,?,?,?,?,?,?)}");
			// Parametro 1 del procedimiento almacenado

			cst.setString(1, opcion);
			cst.setString(2, codcarre);
			cst.setString(3, cedula);
			cst.setString(4, "");
			cst.setString(5, codmar);
			cst.setString(6, paralelo);
			cst.setInt(7, anomat);
			cst.setInt(8, semmat);

			result = cst.executeQuery();

			while (result.next()) {
				mensajeSaew = result.getString(1);

				System.out.println("Fecha" + mensajeSaew);
			}
			result.close();
			sql.closeConnection();
			return mensajeSaew;
		} catch (Exception e) {

			return "";

		} finally {
			sql.closeConnection();
		}
	}

	/**********************************************************************
	 * DEVUELVE TODAS LAS ACTIVIDADES DE DOCENCIA DE TODOS LOS PERIODOS POR
	 * NUMERO DE CEDULA DEL DOCENTE Y NIVEL (POSGRADO, PREGRADO)
	 ****************************************/
	@SuppressWarnings("finally")
	public List<ActividadDocenciaDTO> spActividadDocenciaPensum(String nced, String nivel) {
		List<ActividadDocenciaDTO> listActividad = new ArrayList<ActividadDocenciaDTO>();
		conexionSQL sql = new conexionSQL();
		try {
			java.sql.ResultSet result = null;

			sql.getConnection();
			// LLAMADA AL SP

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeparalp (?,?,?,?)}");

			// PARAMETROS
			cst.setString(1, "L");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, nced);

			result = cst.executeQuery();
			while (result.next()) {

				ActividadDocenciaDTO actividad = new ActividadDocenciaDTO();
				if (result.getString(8).equals(nivel)) {
					actividad.setCodigoMateria(result.getString(4));
					actividad.setMateria(result.getString(5));
					actividad.setParalelo(result.getString(6));
					actividad.setNumHoras(Integer.valueOf(result.getString(7) == null ? "0" : result.getString(7)));
					actividad.setNivel(result.getString(8));
					actividad.setNumEstudiantes(Integer.valueOf(result.getString(9)));
					actividad.setCarrera(result.getString(10));
					actividad.setFacultad(result.getString(11));
					actividad.setPeriodo(result.getString(2) + "-" + (result.getString(3).equals("A") ? 1
							: (result.getString(3).equals("B") ? 2 : result.getString(3))));
					listActividad.add(actividad);
				}

			}

			sql.closeConnection();
		} catch (Exception e) {
			sql.closeConnection();
			listActividad = new ArrayList<ActividadDocenciaDTO>();

		}

		finally {
			sql.closeConnection();
			return listActividad;

		}

	}

	/**********************************************************************
	 * DEVUELVE TODAS LAS ACTIVIDADES DE DOCENCIA DE TODOS LOS PERIODOS POR
	 * NUMERO DE CEDULA DEL DOCENTE Y NIVEL (POSGRADO, PREGRADO)
	 ****************************************/
	@SuppressWarnings("finally")
	public List<TesisDocenteDTO> spTesisDocenciaPensum(String nced, String tipo) {
		List<TesisDocenteDTO> listTesisDocente = new ArrayList<TesisDocenteDTO>();
		conexionSQL sql = new conexionSQL();
		try {
			java.sql.ResultSet result = null;

			sql.getConnection();
			// LLAMADA AL SP

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saetesisprofdepar (?,?,?,?,?,?,?,?,?,?)}");

			// PARAMETROS
			cst.setString(1, "H");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setString(7, "");
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, nced);

			result = cst.executeQuery();
			while (result.next()) {

				TesisDocenteDTO tesis = new TesisDocenteDTO();
				if (result.getString(3).contains(tipo)) {
					tesis.setNroTesis(result.getString(1));
					tesis.setTema(result.getString(2));
					tesis.setTipoTesis(result.getString(3));
					tesis.setEstudiante(result.getString(4));
					tesis.setFechaGradoOral(result.getString(5));
					tesis.setPeriodo(result.getString(6) + "-" + result.getString(7));
					tesis.setCarrera(result.getString(8));
					tesis.setFacultad(result.getString(9));
					listTesisDocente.add(tesis);
				}

			}

			sql.closeConnection();
		} catch (Exception e) {
			sql.closeConnection();
			listTesisDocente = new ArrayList<TesisDocenteDTO>();

		} finally {
			sql.closeConnection();
			return listTesisDocente;

		}
	}

	/**********************************************************************
	 * DEVUELVE TODAS LAS ACTIVIDADES DE DOCENCIA DE TODOS LOS PERIODOS POR
	 * NUMERO DE CEDULA DEL DOCENTE Y NIVEL (POSGRADO, PREGRADO) DE LOS ULTIMOS
	 * 5 AÑOS
	 ****************************************/
	@SuppressWarnings("finally")
	public List<ActividadDocenciaDTO> spActividadDocenciaSAEW(String nced, Integer año) {
		List<ActividadDocenciaDTO> listActividad = new ArrayList<ActividadDocenciaDTO>();
		conexionSQL sql = new conexionSQL();
		try {
			java.sql.ResultSet result = null;

			sql.getConnection();
			Calendar c = Calendar.getInstance();
			Integer anio = c.get(Calendar.YEAR) - año;
			// LLAMADA AL SP

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeparalp (?,?,?,?)}");

			// PARAMETROS
			cst.setString(1, "L");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, nced);

			result = cst.executeQuery();
			while (result.next()) {
				if (result.getInt(2) > anio) {
					ActividadDocenciaDTO actividad = new ActividadDocenciaDTO();
					actividad.setCodigoMateria(result.getString(4));
					actividad.setMateria(result.getString(5));
					actividad.setParalelo(result.getString(6));
					actividad.setNumHoras(Integer.valueOf(result.getString(7)));
					actividad.setNivel(result.getString(8));
					actividad.setNumEstudiantes(Integer.valueOf(result.getString(9)));
					actividad.setCarrera(result.getString(10));
					actividad.setFacultad(result.getString(11));
					actividad.setPeriodo(result.getString(2) + "-" + (result.getString(3).equals("A") ? 1
							: (result.getString(3).equals("B") ? 2 : result.getString(3))));
					listActividad.add(actividad);
				}

			}

			sql.closeConnection();
		} catch (Exception e) {
			sql.closeConnection();
			listActividad = new ArrayList<ActividadDocenciaDTO>();

		} finally {
			sql.closeConnection();
			return listActividad;

		}
	}

	// public static void main(String[] args) {
	// // TODO code application logic here
	// java.sql.ResultSet result = null;
	// try {
	// conexionSQL sql = new conexionSQL();
	// sql.getConnection();
	//
	// CallableStatement cst = sql.getConection().prepareCall("{call
	// pa_contsilabo (?,?,?,?,?,?,?,?)}");
	//
	// cst.setString(1, "CF");
	// cst.setString(2, "07");
	// cst.setString(3, "");
	// cst.setString(4, "");
	// cst.setString(5, "");
	// cst.setString(6, "");
	// cst.setString(7, "2017");
	// cst.setString(8, "1");
	//
	// result = cst.executeQuery();
	// int x = 1;
	// while (result.next()) {
	//
	// System.out.println("Datos" + result.getString(x));
	// x++;
	//
	// }
	// result.close();
	// sql.closeConnection();
	//
	// } catch (Exception e) {
	//
	//
	// }
	// }

	/////////////////////// procedimientoa almacenados sara cruz
	/////////////////////// ////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public List<ReporteDistributivoAcademicoDTO> obtenerCargaDistributivoOK(Pensum pensum, Carrera carr,
			FacultadCatalogos facultad) {
		conexionSQL sql = new conexionSQL();
		java.sql.ResultSet result = null;
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeparal (?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LX");

			if (facultad == null) {
				cst.setString(2, "");
			} else {
				cst.setString(2, facultad.getNomFacultad().trim());
			}

			if (carr == null) {
				cst.setString(3, "");
			} else {
				cst.setString(3, carr.getIdCarrera().trim());
			}

			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			// cst.setString(7, "2017");
			// cst.setString(8, "1");
			cst.setString(7, pensum.getAñoPensum());
			cst.setString(8, pensum.getNumeroPensum());

			result = cst.executeQuery();
			List<ReporteDistributivoAcademicoDTO> listaDistr = new ArrayList<ReporteDistributivoAcademicoDTO>();
			while (result.next()) {

				ReporteDistributivoAcademicoDTO dis = new ReporteDistributivoAcademicoDTO();
				dis.setMateria(result.getString(2));
				dis.setParalelo(result.getString(5));
				dis.setHoras(result.getInt(4));
				dis.setCodProf(result.getString(8));
				dis.setNomProf(result.getString(9));
				dis.setNumEstud(result.getInt(12));
				dis.setCarrera(result.getString(29));
				dis.setFacultad(result.getString(30));
				listaDistr.add(dis);
			}
			result.close();
			sql.closeConnection();
			return listaDistr;
		} catch (Exception e) {
			sql.closeConnection();

			return null;
		}

		finally {
			sql.closeConnection();

		}

	}

	public List<CargaPlanificacionDTO> obtenerHeteroCargaAcademica(String cedula, String añoPensum,
			String numeroPensum) {
		conexionSQL sql = new conexionSQL();
		java.sql.ResultSet result = null;
		try {

			sql.getConnection();

			/* pa_saeevaluaer 'L','','','','1756943757','','',2017,1 */

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeevaluaer (?,?,?,?,?,?,?,?,?)}");

			if (Integer.parseInt(añoPensum) == 2017 && Integer.parseInt(numeroPensum) == 2) {
				cst.setString(1, "LV");
			} else if (Integer.parseInt(añoPensum) >= 2018) {
				cst.setString(1, "LV");
			} else {
				cst.setString(1, "L");
			}

			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, cedula);
			cst.setString(6, "");
			cst.setString(7, "");
			cst.setString(8, añoPensum);
			cst.setString(9, numeroPensum);

			result = cst.executeQuery();
			List<CargaPlanificacionDTO> listaCargaPlanif = new ArrayList<CargaPlanificacionDTO>();
			while (result.next()) {
				CargaPlanificacionDTO carga = new CargaPlanificacionDTO();
				carga.setCodMateriaSAE(result.getString(3));
				carga.setNomMateriaSAE(result.getString(4).trim());
				carga.setNomParaleloSAE(result.getString(5));
				carga.setValHetero(Double.parseDouble(result.getString(8) == null ? "0.0" : result.getString(8)));
				carga.setAula(result.getString(16) == null ? "" : result.getString(16).replace("/", ""));

				listaCargaPlanif.add(carga);
			}
			result.close();
			sql.closeConnection();
			return listaCargaPlanif;
		} catch (Exception e) {
			sql.closeConnection();
			return null;
		} finally {
			sql.closeConnection();

		}

	}

	// public static void main(String[] args) {
	// // TODO code application logic here
	// java.sql.ResultSet result = null;
	// try {
	// conexionSQL sql = new conexionSQL();
	// sql.getConnection();
	//
	// CallableStatement cst = sql.getConection().prepareCall("{call
	// pa_contsilabo (?,?,?,?,?,?,?,?)}");
	//
	// cst.setString(1, "CF");
	// cst.setString(2, "07");
	// cst.setString(3, "");
	// cst.setString(4, "");
	// cst.setString(5, "");
	// cst.setString(6, "");
	// cst.setString(7, "2017");
	// cst.setString(8, "1");
	//
	// result = cst.executeQuery();
	// int x = 1;
	// while (result.next()) {
	//
	// System.out.println("Datos" + result.getString(x));
	// x++;
	//
	// }
	// result.close();
	// sql.closeConnection();
	//
	// } catch (Exception e) {
	//
	//
	// }
	// }

	public List<ReporteDistributivoAcademicoDTO> obtenerCargaPorCarrera(Pensum pensum, Carrera carr,
			FacultadCatalogos facultad) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeparal (?,?,?,?,?,?,?,?)}");

			cst.setString(1, "PC");

			if (facultad == null) {
				cst.setString(2, "");
			} else {
				cst.setString(2, facultad.getNomFacultad().trim());
			}

			if (carr == null) {
				cst.setString(3, "");
			} else {
				cst.setString(3, carr.getIdCarrera().trim());
			}

			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			// cst.setString(7, "2017");
			// cst.setString(8, "1");
			cst.setString(7, pensum.getAñoPensum());
			cst.setString(8, pensum.getNumeroPensum());

			result = cst.executeQuery();
			List<ReporteDistributivoAcademicoDTO> listaDistr = new ArrayList<ReporteDistributivoAcademicoDTO>();
			while (result.next()) {

				ReporteDistributivoAcademicoDTO dis = new ReporteDistributivoAcademicoDTO();
				dis.setNced(result.getString(1));
				dis.setNombres(result.getString(2));
				dis.setCarrera(result.getString(3));
				dis.setFacultad(result.getString(4));
				listaDistr.add(dis);
			}
			result.close();
			sql.closeConnection();
			return listaDistr;
		} catch (Exception e) {
			sql.closeConnection();

			return null;
		} finally {
			sql.closeConnection();

		}

	}

	public List<CargaAcademicaDistributivoDTO> obtenerCargaDistributivo() {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeparal (?,?,?,?,?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setString(7, "2017");
			cst.setString(8, "1");

			result = cst.executeQuery();
			List<CargaAcademicaDistributivoDTO> listaDistr = new ArrayList<CargaAcademicaDistributivoDTO>();
			while (result.next()) {

				CargaAcademicaDistributivoDTO dis = new CargaAcademicaDistributivoDTO();

				dis.setNomMateriaSaew(result.getString(2));
				dis.setParaleloSaew(result.getString(5));
				dis.setCodProfSaew(result.getString(8));
				dis.setNomProfSaew(result.getString(9));
				dis.setCarreraSaew(result.getString(29));
				dis.setFacultadSaew(result.getString(30));

				listaDistr.add(dis);
			}
			result.close();
			sql.closeConnection();
			return listaDistr;
		} catch (Exception e) {
			sql.closeConnection();

			return null;
		} finally {
			sql.closeConnection();

		}

	}

	public List<DistributivoAcademicoDTO> obtenerDistributivo1() {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeparalca (?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setString(7, "");
			cst.setString(8, "2017");
			cst.setString(9, "1");

			result = cst.executeQuery();
			List<DistributivoAcademicoDTO> listaDistr = new ArrayList<DistributivoAcademicoDTO>();
			while (result.next()) {

				DistributivoAcademicoDTO dis = new DistributivoAcademicoDTO();
				dis.setCodProf(result.getString(1));
				dis.setNomProf(result.getString(2));
				dis.setDedicacion(result.getString(3));
				// 4
				dis.setMateria(result.getString(5));
				dis.setParalelo(result.getString(6));
				// 7 modo
				dis.setHoras(result.getInt(8));
				// 9 horasFecha
				// 10 aula
				// 11 cupo
				dis.setNumEstud(result.getInt(12));
				// 13 sesiones
				// 14
				// 15 lunes
				// 16 martes
				// 17 miercoles
				// 18 jueves
				// 19 viernes
				// 20 sabado
				dis.setTipoContrat(result.getString(21));
				// 22 hsimul
				// 23 fechaI
				// 24 cod carrera
				dis.setCarrera(result.getString(25));
				dis.setFacultad(result.getString(26));

				listaDistr.add(dis);
			}
			result.close();
			sql.closeConnection();
			return listaDistr;
		} catch (Exception e) {
			sql.closeConnection();
			return null;
		} finally {
			sql.closeConnection();

		}

	}

	public List<ReporteDistributivoAcademicoDTO> obtenerEstudiantesMatriculados(Pensum pensum, Carrera carre) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeestcarr  (?,?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LA");
			cst.setString(2, "");

			if (carre == null) {
				cst.setString(3, "");
			} else {
				cst.setString(3, carre.getIdCarrera().trim());
			}
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setString(7, pensum.getAñoPensum());
			cst.setString(8, pensum.getNumeroPensum());
			cst.setInt(9, Integer.parseInt(pensum.getAñoPensum()));
			cst.setInt(10, Integer.parseInt(pensum.getNumeroPensum()));
			cst.setString(11, null);
			cst.setString(12, "X");

			result = cst.executeQuery();
			List<ReporteDistributivoAcademicoDTO> listaDistr = new ArrayList<ReporteDistributivoAcademicoDTO>();
			while (result.next()) {

				ReporteDistributivoAcademicoDTO dis = new ReporteDistributivoAcademicoDTO();
				dis.setNced(result.getString(1));
				dis.setNombres(result.getString(2));
				dis.setCargo(result.getString(3));
				dis.setCodProf(result.getString(4));
				dis.setFacultad(result.getString(5));
				dis.setCarrera(result.getString(6));
				dis.setMateria(result.getString(7));
				dis.setPeriodo(result.getString(8));
				listaDistr.add(dis);
			}
			result.close();
			sql.closeConnection();
			return listaDistr;
		} catch (Exception e) {
			sql.closeConnection();

			return null;
		} finally {
			sql.closeConnection();

		}

	}

	public ReporteChartDTO obtenerEstudiantesTutorias(Integer año, Integer numero, String cedula) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saetutoria (?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "LT");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setInt(6, año);
			cst.setInt(7, numero);
			cst.setString(8, cedula);
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "");
			cst.setString(12, "");
			cst.setString(13, "P");

			result = cst.executeQuery();

			ReporteChartDTO listaDistr = new ReporteChartDTO();
			while (result.next()) {

				if (result.getString(1).contains("TOTAL")) {

					if (numero == 1) {
						listaDistr.setPeriodo(año.toString() + "A");
					} else {
						listaDistr.setPeriodo(año.toString() + "B");
					}
					Integer Total = result.getInt(5);
					listaDistr.setTotal(Total.doubleValue());
				}
			}
			result.close();
			sql.closeConnection();
			return listaDistr;
		} catch (Exception e) {
			sql.closeConnection();

			return null;
		}

		finally {
			sql.closeConnection();

		}

	}

	public ReporteChartDTO obtenerTesisDirigidas(Integer año, Integer numero, String cedula) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_tesisxest (?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, año.toString());
			cst.setString(5, numero.toString());
			cst.setString(6, año.toString());
			cst.setString(7, numero.toString());
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, cedula);

			result = cst.executeQuery();

			ReporteChartDTO listaDistr = new ReporteChartDTO();

			if (result.next()) {

				while (result.next()) {

					if (result.getString(2).contains("TOTAL")) {

						if (numero == 1) {
							listaDistr.setPeriodo(año.toString() + "A");
						} else {
							listaDistr.setPeriodo(año.toString() + "B");
						}
						Integer Total = result.getInt(3);
						listaDistr.setTotal(Total.doubleValue());
					}
				}
			} else {
				if (numero == 1) {
					listaDistr.setPeriodo(año.toString() + "A");
				} else {
					listaDistr.setPeriodo(año.toString() + "B");
				}
				listaDistr.setTotal(0.00);
			}
			result.close();
			sql.closeConnection();
			return listaDistr;
		} catch (Exception e) {
			sql.closeConnection();

			return null;
		} finally {
			sql.closeConnection();

		}

	}

	public List<ReporteChartDTO> obtenerMateriasDocente(Integer año, Integer numero, String cedula) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saecontparalca (?,?,?,?,?,?)}");

			cst.setString(1, "LT");
			cst.setString(2, cedula);
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setInt(5, año);
			cst.setInt(6, numero);

			result = cst.executeQuery();

			List<ReporteChartDTO> listaDistr = new ArrayList<ReporteChartDTO>();
			while (result.next()) {

				ReporteChartDTO report = new ReporteChartDTO();

				report.setNivel(result.getString(2));
				Integer valor = result.getInt(1);
				report.setTotal(valor.doubleValue());

				if (numero == 1) {
					report.setPeriodo(año.toString() + "A");
				} else {
					report.setPeriodo(año.toString() + "B");
				}

				listaDistr.add(report);

			}
			result.close();
			sql.closeConnection();
			return listaDistr;
		} catch (

		Exception e) {
			sql.closeConnection();

			return null;
		} finally {
			sql.closeConnection();

		}
	}

	/**********************************************************************
	 * DEVUELVE TODAS LAS ACTIVIDADES DE DOCENCIA DE TODOS LOS PERIODOS POR
	 * NUMERO DE CEDULA DEL DOCENTE Y NIVEL (POSGRADO, PREGRADO)
	 ****************************************/
	@SuppressWarnings("finally")
	public List<TesisDocenteDTO> spTesisProyectos(String nced, String tipo) {
		List<TesisDocenteDTO> listTesisDocente = new ArrayList<TesisDocenteDTO>();
		conexionSQL sql = new conexionSQL();
		try {
			java.sql.ResultSet result = null;

			sql.getConnection();
			// LLAMADA AL SP

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saetesisprofdepar (?,?,?,?,?,?,?,?,?,?)}");

			// PARAMETROS
			cst.setString(1, "H");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setString(7, "");
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, nced);

			result = cst.executeQuery();
			while (result.next()) {

				TesisDocenteDTO tesis = new TesisDocenteDTO();
				if (result.getString(3).contains(tipo)) {

				} else {
					tesis.setNroTesis(result.getString(1));
					tesis.setTema(result.getString(2));
					tesis.setTipoTesis(result.getString(3));
					tesis.setEstudiante(result.getString(4));
					tesis.setFechaGradoOral(result.getString(5));
					tesis.setPeriodo(result.getString(6) + "-" + result.getString(7));
					tesis.setCarrera(result.getString(8));
					tesis.setFacultad(result.getString(10));
					listTesisDocente.add(tesis);
				}

			}

			sql.closeConnection();
		} catch (Exception e) {

			sql.closeConnection();

			listTesisDocente = new ArrayList<TesisDocenteDTO>();

		}

		finally {
			sql.closeConnection();
			return listTesisDocente;

		}

	}

	@SuppressWarnings("finally")
	public List<CordinacionDTO> spCoordinacionUsuario(String nced) {
		List<CordinacionDTO> listCordinacion = new ArrayList<CordinacionDTO>();
		conexionSQL sql = new conexionSQL();
		try {
			java.sql.ResultSet result = null;

			sql.getConnection();
			// LLAMADA AL SP

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeparam (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			// PARAMETROS
			cst.setString(1, "P");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setString(7, "");
			cst.setString(8, "");
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "");
			cst.setString(12, "");
			cst.setString(13, "");
			cst.setString(14, nced);

			result = cst.executeQuery();
			while (result.next()) {

				CordinacionDTO cprd = new CordinacionDTO();

				cprd.setCodcar(result.getString(1));
				cprd.setCarrera(result.getString(2));
				cprd.setCargo(result.getString(3));
				cprd.setCedula(result.getString(4));

				listCordinacion.add(cprd);

			}

			sql.closeConnection();
		} catch (Exception e) {
			listCordinacion = new ArrayList<CordinacionDTO>();
			sql.closeConnection();

		}

		finally {
			sql.closeConnection();
			return listCordinacion;

		}
	}

	public List<MateriaDTO> obtenerMateriasPEA(Pensum pensum, String codcar, String nced) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeparal (?,?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "L");

			cst.setString(2, "");

			cst.setString(3, codcar);

			cst.setString(4, "");
			cst.setString(5, "");
			cst.setString(6, "");
			cst.setInt(7, Integer.parseInt(pensum.getAñoPensum()));
			cst.setInt(8, Integer.parseInt(pensum.getNumeroPensum()));
			cst.setString(9, "");
			cst.setString(10, "");
			cst.setString(11, "");
			cst.setString(12, nced.trim());

			result = cst.executeQuery();
			List<MateriaDTO> listaDistr = new ArrayList<MateriaDTO>();
			while (result.next()) {

				MateriaDTO dis = new MateriaDTO();

				dis.setCodmat(result.getString(1));
				dis.setMateria(result.getString(2));
				dis.setParalelo(result.getString(3));
				dis.setHoras(result.getString(4));
				dis.setAula(result.getString(5));
				dis.setCodcar(codcar);
				listaDistr.add(dis);
			}
			result.close();
			sql.closeConnection();
			return listaDistr;
		} catch (Exception e) {
			sql.closeConnection();

			return null;
		} finally {
			sql.closeConnection();

		}

	}

	public Double obtenerHetero2017A(String cedula) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			/* pa_saeevaluaer 'L','','','','1756943757','','',2017,1 */

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saeevaluaer (?,?,?,?,?,?,?,?,?)}");
			// pa_saeevaluaer 'CA','','','','0802548578'

			cst.setString(1, "CA");
			cst.setString(2, "");
			cst.setString(3, "");
			cst.setString(4, "");
			cst.setString(5, cedula);
			cst.setString(6, "");
			cst.setString(7, "");
			cst.setString(8, "");
			cst.setString(9, "");

			result = cst.executeQuery();
			List<CargaPlanificacionDTO> listaCargaPlanif = new ArrayList<CargaPlanificacionDTO>();
			while (result.next()) {
				CargaPlanificacionDTO carga = new CargaPlanificacionDTO();
				carga.setValHetero(Double.parseDouble(result.getString(5) == null ? "0.0" : result.getString(5)));
				listaCargaPlanif.add(carga);
			}
			result.close();
			sql.closeConnection();
			return listaCargaPlanif.get(0).getValHetero();
		} catch (Exception e) {
			sql.closeConnection();
			return null;

		} finally {
			sql.closeConnection();

		}

	}

	// Metodo para sacar datos de materias horarios fechas
	public List<DatosSaewModulares> pa_saehorarf(String codCarrera, String codMat, String paral) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();

		Integer val = null;
		System.out.println("POSIBLE VALOR NULO PARA ENTERO: " + val);
		try {

			sql.getConnection();

			// Llamada al procedimiento almacenado
			// pa_saehorarf
			// L,'','142','MSA380','GR1','',null,null,null,'','',null,null,2018,2
			// pa_saehorarf L,'','142','MSA380','GR1','',0,0,0,'','',0,0,2018,2

			CallableStatement cst = sql.getConection()
					.prepareCall("{call pa_saehorarf (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cst.setString(1, "L");
			cst.setString(2, "");
			cst.setString(3, codCarrera);
			cst.setString(4, codMat);
			cst.setString(5, paral);
			cst.setString(6, "");
			cst.setNull(7, Types.INTEGER);
			cst.setNull(8, Types.INTEGER);
			cst.setNull(9, Types.INTEGER);
			cst.setString(10, "");
			cst.setString(11, "");
			cst.setNull(12, Types.INTEGER);
			cst.setNull(13, Types.INTEGER);
			cst.setString(14, pensumVigente.getAñoPensum());
			cst.setString(15, pensumVigente.getNumeroPensum());

			result = cst.executeQuery();

			List<DatosSaewModulares> listaDatosSaew = new ArrayList<DatosSaewModulares>();
			while (result.next()) {
				DatosSaewModulares datos = new DatosSaewModulares();

				datos.setFecha(result.getString(1));
				datos.setNroSesion(result.getInt(2));
				datos.setDe(result.getInt(3));
				datos.setA(result.getInt(4));
				datos.setSubTotal(result.getInt(5));

				listaDatosSaew.add(datos);
			}

			result.close();

			sql.closeConnection();
			return listaDatosSaew;
		} catch (Exception e) {
			sql.closeConnection();
			return null;
		} finally {
			sql.closeConnection();

		}
	}

	public List<EstudianteMedicoDTO> datosEstudiantesSAEW(String cedula, String nombre) {
		java.sql.ResultSet result = null;
		conexionSQL sql = new conexionSQL();
		try {

			sql.getConnection();

			// pa_saedatEstMed '', ''

			CallableStatement cst = sql.getConection().prepareCall("{call pa_saedatEstMed (?,?)}");

			cst.setString(1, cedula);
			cst.setString(2, nombre);

			result = cst.executeQuery();
			List<EstudianteMedicoDTO> listaEstudSaew = new ArrayList<EstudianteMedicoDTO>();
			while (result.next()) {
				EstudianteMedicoDTO estudiante = new EstudianteMedicoDTO();
				estudiante.setCedula(result.getString(2));
				estudiante.setNombre(result.getString(3));
				estudiante.setFechaNacimiento(result.getString(10));
				estudiante.setNacionalidad(result.getString(11));
				estudiante.setGenero(result.getString(12));
				listaEstudSaew.add(estudiante);
			}
			result.close();
			sql.closeConnection();
			return listaEstudSaew;
		} catch (Exception e) {
			sql.closeConnection();
			return null;
		} finally {
			sql.closeConnection();

		}

	}

}