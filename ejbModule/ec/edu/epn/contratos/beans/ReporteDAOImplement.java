package ec.edu.epn.contratos.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.epn.contratos.DTO.DetalleDocenteAdminstrativoDTO;
import ec.edu.epn.contratos.DTO.DetallesReporteDocenteDTO;

/**
 * Session Bean implementation class ServiciosContratyosPAcadem
 */
@Stateless
public class ReporteDAOImplement implements ReporteDAO {

	private EntityManager em;

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<DetalleDocenteAdminstrativoDTO> reporteDocenteAdminsitrativo(Integer identificador01,
			Integer identificador02, Integer identificador03, String var01, String var02, String var03, String var04,
			String var05, String var06) throws Exception {

		DetalleDocenteAdminstrativoDTO dto = new DetalleDocenteAdminstrativoDTO();
		List<DetalleDocenteAdminstrativoDTO> reporteDetalleDocenteAdministraticoDTOs = new ArrayList<DetalleDocenteAdminstrativoDTO>();
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager()
					.createNativeQuery("SELECT * FROM \"Rrhh\".reporteDocenteAdministrativo(?,?,?,?,?,?,?,?,?);");
			query.setParameter(1, identificador01);
			query.setParameter(2, identificador02);
			query.setParameter(3, identificador03);
			query.setParameter(4, "%" + var01 + "%");
			query.setParameter(5, "%" + var02 + "%");
			query.setParameter(6, "%" + var03 + "%");
			query.setParameter(7, "%" + var04 + "%");
			query.setParameter(8, "%" + var05 + "%");
			query.setParameter(9, "%" + var06 + "%");

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteAnio : listsDocentes) {
					Object[] fila = (Object[]) listDocenteAnio;
					dto = new DetalleDocenteAdminstrativoDTO();
					dto.setCedula(fila[0] == null ? "" : fila[0].toString());
					dto.setNombre(fila[1] == null ? "" : fila[1].toString());
					dto.setApellido(fila[2] == null ? "" : fila[2].toString());
					dto.setCodNacimiento(fila[3] == null ? "" : fila[3].toString());
					dto.setGenero(fila[4] == null ? "" : fila[4].toString());
					dto.setEmail(fila[5] == null ? "" : fila[5].toString());
					dto.setDireccion(fila[6] == null ? "" : fila[6].toString());
					dto.setTipoRelacionLaboral(fila[7] == null ? "" : fila[7].toString());
					dto.setDedicacion(fila[8] == null ? "" : fila[8].toString());
					dto.setCargo(fila[9] == null ? "" : fila[9].toString());
					dto.setDepartamento(fila[10] == null ? "" : fila[10].toString());
					dto.setCodDepartamento(fila[11] == null ? "" : fila[11].toString());
					dto.setFacultad(fila[12] == null ? "" : fila[12].toString());
					dto.setNivel(fila[13] == null ? "" : fila[13].toString());
					reporteDetalleDocenteAdministraticoDTOs.add(dto);
				}
			}
		}
		return reporteDetalleDocenteAdministraticoDTOs;
	}

	@Override
	public List<DetallesReporteDocenteDTO> reporteDocenteAnioFiscal(Integer identificador01, Integer identificador02,
			Integer identificador03, String var01, String var02, String var03, String var04, String var05, String var06)
			throws Exception {

		DetallesReporteDocenteDTO dto = new DetallesReporteDocenteDTO();
		List<DetallesReporteDocenteDTO> reporteDetalleDocenteDTOs = new ArrayList<DetallesReporteDocenteDTO>();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String reportSource = "SP";

		Query query = null;

		if ("SP".equals(reportSource)) {

			query = getEntityManager()
					.createNativeQuery("SELECT * FROM \"GestionDocente\".reporte_docente_3(?,?,?,?,?,?,?,?,?);");
			query.setParameter(1, identificador01);
			query.setParameter(2, identificador02);
			query.setParameter(3, identificador03);
			query.setParameter(4, var01);
			query.setParameter(5, var02);
			query.setParameter(6, var03);
			query.setParameter(7, var04);
			query.setParameter(8, var05);
			query.setParameter(9, var06);

			List<?> listsDocentes = query.getResultList();

			if (!listsDocentes.isEmpty()) {
				for (Object listDocenteAnio : listsDocentes) {
					Object[] fila = (Object[]) listDocenteAnio;
					dto = new DetallesReporteDocenteDTO();
					dto.setCedula(fila[0].toString());
					dto.setPrimerApellido(fila[1].toString());
					dto.setSegundoApellido(fila[2].toString());
					dto.setNombres(fila[3].toString());
					dto.setGenero(fila[4].toString());
					dto.setNacionalidad(fila[5].toString());
					dto.setFechaNacimiento(fila[6].toString().equals("01/01/1900") ? "" : fila[6].toString());
					dto.setTipoDiscapacidad(fila[7].toString());
					dto.setCarneConadis(fila[8].toString());
					dto.setNumeroCarneConadis(fila[9].toString());
					dto.setPorcentajeDiscapacidad(fila[10].toString());
					dto.setEmailPersonal(fila[11].toString());

					String titulos = fila[12].toString();
					String[] listTitulos = titulos.split(",");
					dto.setNivelUltimoTTN(listTitulos[0].toString());
					dto.setUltimoTituloTN(listTitulos[1].toString());
					dto.setFechaUltimoTTN(
							listTitulos[2].toString().equals("01/01/1900") ? "" : listTitulos[2].toString());
					dto.setUniversidadUltimoTTN(listTitulos[3].toString());
					dto.setPaisUltimoTTN(listTitulos[4].toString());
					dto.setRegistroSenescytUltimoTTN(listTitulos[5].toString());
					dto.setFechaRegistroSenescytUltimoTTN(
							listTitulos[6].toString().equals("01/01/1900") ? "" : listTitulos[6].toString());
					dto.setSubAreaUltimoTTN(listTitulos[7].toString());
					dto.setNivelPenultimoTTN(listTitulos[8].toString());
					dto.setPenultimoTTN(listTitulos[9].toString());
					dto.setFechaPenultimoTTN(
							listTitulos[10].toString().equals("01/01/1900") ? "" : listTitulos[10].toString());
					dto.setUniversidadPenultimoTTN(listTitulos[11].toString());
					dto.setPaisPenultimoTTN(listTitulos[12].toString());
					dto.setRegistroSenescytPenultimoTTN(listTitulos[13].toString());
					dto.setFechaRegistroSenescytPenultimoTTN(
							listTitulos[14].toString().equals("01/01/1900") ? "" : listTitulos[14].toString());
					dto.setSubAreaPenultimoTTN(listTitulos[15].toString());
					dto.setNivelAntePenultimoTTN(listTitulos[16].toString());
					dto.setAntePenultimoTTN(listTitulos[17].toString());
					dto.setFechaAntePenultimoTTN(
							listTitulos[18].toString().equals("01/01/1900") ? "" : listTitulos[18].toString());
					dto.setUniversidadAntePenultimoTTN(listTitulos[19].toString());
					dto.setPaisAntePenultimoTTN(listTitulos[20].toString());
					dto.setRegistroSenescytAntePenultimoTTN(listTitulos[21].toString());
					dto.setFechaRegistroSenescytAntePenultimoTTN(
							listTitulos[22].toString().equals("01/01/1900") ? "" : listTitulos[22].toString());
					dto.setSubAreaAntePenultimoTTN(listTitulos[23].toString());
					dto.setNivelUltimoTCN(listTitulos[24].toString());
					dto.setUltimoTCN(listTitulos[25].toString());
					dto.setFechaUltimoTCN(
							listTitulos[26].toString().equals("01/01/1900") ? "" : listTitulos[26].toString());
					dto.setUniversidadUltimoTCN(listTitulos[27].toString());
					dto.setPaisUltimoTCN(listTitulos[28].toString());
					dto.setRegistroSenescytUltimoTCN(listTitulos[29].toString());
					dto.setFechaRegistroSenescytUltimoTCN(
							listTitulos[30].toString().equals("01/01/1900") ? "" : listTitulos[30].toString());
					dto.setSubAreaUltimoTCN(listTitulos[31].toString());
					dto.setNivelPenultimoTCN(listTitulos[32].toString());
					dto.setPenultimoTCN(listTitulos[33].toString());
					dto.setFechaPenultimoTCN(
							listTitulos[34].toString().equals("01/01/1900") ? "" : listTitulos[34].toString());
					dto.setUniversidadPenultimoTCN(listTitulos[35].toString());
					dto.setPaisPenultimoTCN(listTitulos[36].toString());
					dto.setRegistroSenescytPenultimoTCN(listTitulos[37].toString());
					dto.setFechaRegistroSenescytPenultimoTCN(
							listTitulos[38].toString().equals("01/01/1900") ? "" : listTitulos[38].toString());
					dto.setSubAreaPenultimoTCN(listTitulos[39].toString());
					dto.setNivelAntePenultimoTCN(listTitulos[40].toString());
					dto.setTituloAntePenultimoTCN(listTitulos[41].toString());
					dto.setFechaAntePenultimoTCN(
							listTitulos[42].toString().equals("01/01/1900") ? "" : listTitulos[42].toString());
					dto.setUniversidadAntePenultimoTCN(listTitulos[43].toString());
					dto.setPaisAntePenultimoTCN(listTitulos[44].toString());
					dto.setRegistroSenescytAntePenultimoTCN(listTitulos[45].toString());
					dto.setFechaRegistroSenescytAntePenultimoTCN(
							listTitulos[46].toString().equals("01/01/1900") ? "" : listTitulos[46].toString());
					dto.setSubAreaAntePenultimoTCN(listTitulos[47].toString());
					dto.setNumeroNombremientoContrato(fila[60].toString());
					dto.setFechaIngresoIES(fila[61].toString().equals("01/01/1900") ? "" : fila[61].toString());
					dto.setRelacionTrabajoIES(fila[62].toString());
					dto.setIngresoConcurso(fila[63].toString());
					dto.setCargoContratoNombramiento(fila[64].toString());
					dto.setFechaInicio(fila[65].toString().equals("01/01/1900") ? "" : fila[65].toString());
					dto.setFechaSalidaIES(fila[66].toString().equals("01/01/1900") ? "" : fila[65].toString());
					dto.setCategoriaPersonalAcademico(fila[67].toString());
					dto.setTiempoDedicacion(fila[68].toString());
					dto.setDepartamentoAcademico(fila[69].toString());
					dto.setFacultad(fila[70].toString());
					dto.setCargoAutoridad(fila[71].toString());
					dto.setFechaInicioCargoAutoridad(
							fila[72].toString().equals("01/01/1900") ? "" : fila[72].toString());
					dto.setFechaFinCargoAutoridad(fila[73].toString().equals("01/01/1900") ? "" : fila[73].toString());
					dto.setNumeroDocumentoCargoAutoridad(fila[74].toString());
					dto.setDocenciaTercerNivel(fila[75].toString());
					dto.setDocenciaCuartoNIvel(fila[76].toString());
					dto.setParticipaProyectoInvestigacion(fila[77].toString());
					dto.setRemuneracionMensual(fila[78].toString());
					dto.setIngresoAnual(fila[79].toString());
					dto.setRemuneracionHora(fila[80].toString());
					dto.setCursandoEstudios(fila[81].toString());
					dto.setFinanciamientoEstudiosPHD(fila[82].toString());
					dto.setPeriodoSabatico(fila[83].toString());
					dto.setFechaInicioSabatico(fila[84].toString().equals("01/01/1900") ? "" : fila[84].toString());
					dto.setFechaFinSabatico(fila[85].toString().equals("01/01/1900") ? "" : fila[85].toString());
					dto.setMovilidadIESExtrangeras(fila[86].toString());
					dto.setMovilidadIESNacionales(fila[87].toString());
					dto.setEmailInstitucional(fila[88].toString());
					dto.setObservacion(fila[89].toString());

					reporteDetalleDocenteDTOs.add(dto);

				}
			}

		}

		return reporteDetalleDocenteDTOs;

	}

}
