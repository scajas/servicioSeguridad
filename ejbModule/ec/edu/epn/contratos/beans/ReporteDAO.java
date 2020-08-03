package ec.edu.epn.contratos.beans;

import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.contratos.DTO.DetalleDocenteAdminstrativoDTO;
import ec.edu.epn.contratos.DTO.DetallesReporteDocenteDTO;



@Local
public interface ReporteDAO {

	List<DetallesReporteDocenteDTO> reporteDocenteAnioFiscal(Integer identificador01, Integer identificador02,
			Integer identificador03, String var01, String var02, String var03, String var04, String var05, String var06)
			throws Exception;

	List<DetalleDocenteAdminstrativoDTO> reporteDocenteAdminsitrativo(Integer identificador01, Integer identificador02,
			Integer identificador03, String var01, String var02, String var03, String var04, String var05, String var06)
			throws Exception;
	
	
	
}
