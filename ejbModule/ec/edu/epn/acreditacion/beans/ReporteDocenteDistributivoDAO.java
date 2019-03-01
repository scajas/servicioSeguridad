package ec.edu.epn.acreditacion.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import ec.edu.epn.acreditacion.reportes.dto.DocenteDistributivoDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteCapacitacionEjecutadaDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteDistribucionHorariaDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteDistributivoAcademicoDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteLibrosCapitulosDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReportePonenciasDTO;
import ec.edu.epn.acreditacion.reportes.dto.ReporteProdCientificaDTO;
import ec.edu.epn.acreditacion.reportes.dto.TotalDTO;
import ec.edu.epn.catalogos.entities.Carrera;

@Stateless(name = "ReporteDistribAcademicoDAO")
public interface ReporteDocenteDistributivoDAO {

	List<DocenteDistributivoDTO> reporteDocenteDistributivoDTO1(String var01, Integer identificador01);

	List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDTO(String var01, Integer identificador01);

	List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDedicacion(String var01, Integer identificador01);

	List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoNivelTitulo(String var01, Integer identificador01);

	List<ReporteDistributivoAcademicoDTO> reporteDocenteDistributivoDepartamento(String var01, Integer identificador01);

	// Capacitacion
	List<ReporteCapacitacionEjecutadaDTO> reporteCapacitacionEjecutadaDTO(String var01, Integer identificador01,
			String var02);

	// Titularidad
	List<ReporteDistributivoAcademicoDTO> reporteTitularidadDTO(String var01);

	// Distribucion Horaria
	List<ReporteDistribucionHorariaDTO> reporteDistribucionHorariaDTO(String var01, Integer identificador01);

	// Prod Academico Cientifica
	List<ReporteProdCientificaDTO> reporteProdCientificAcademicaDTO(String var01, Integer identificador01, Date var02,
			Date var03);

	// Prod Regional
	List<ReporteProdCientificaDTO> reporteProdCRegionalDTO(String var01, Integer identificador01, Date var02,
			Date var03);

	// Libros - Cap. Libros
	List<ReporteLibrosCapitulosDTO> reporteLibrosCapitulosDTO(String var01, Integer identificador01, Date var02,
			Date var03);

	// Ponencias
	List<ReportePonenciasDTO> reportePonenciasDTO(String var01, Integer identificador01, Date var02,
			Date var03);

	List<TotalDTO> totalContratos(List<String> cedulas);

	List<ReporteDistributivoAcademicoDTO> reporteTitulosDTO(String var01);

}
