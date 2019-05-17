package ec.edu.epn.atencionmedica.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ec.edu.epn.atencionmedica.dto.CertificadoMedicoDto;
import ec.edu.epn.atencionmedica.entities.Reporte2;

@Local
public interface ConsultaReportesDAO {
	public List<Reporte2> obtenerData(int reporte, Date fechaInicio, Date fechaCorte);
	
	public List<CertificadoMedicoDto> obtenerDatosCertificadoMedico(Integer idAtencionMedica);
	
	public List<CertificadoMedicoDto> obtenerDatosPedidoExamen(Integer idAtencionMedica);
	
	public List<CertificadoMedicoDto> obtenerDatosPedidoEcografia(Integer idAtencionMedica);

}
