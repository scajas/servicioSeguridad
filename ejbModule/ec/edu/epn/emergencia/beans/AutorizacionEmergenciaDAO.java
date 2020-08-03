package ec.edu.epn.emergencia.beans;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.generic.DAO.DaoGenerico;

@Remote
public interface AutorizacionEmergenciaDAO extends DaoGenerico<AutorizacionEmergencia>
{
    public List<AutorizacionEmergencia> findAutorizaciones();
    
    public Integer getMaxId();
    
    public List<AutorizacionEmergencia> findAutorizacionesXCedula(final String p0);
    
    public List<AutorizacionEmergencia> findAutorizacionesXCedulaXFechaDesdexFechaHasta(final String p0, final Date p1, final Date p2);
    
    public List<AutorizacionEmergencia> findAutorizacionesXExpiradoAutorizado(final Date p0);
    
    public List<AutorizacionEmergencia> findAutorizacionesXEstadoCalendarizado(final Date p0);
    
    public List<AutorizacionEmergencia> findAutorizacionesXEstadoPersona(final String p0);
    
    public List<AutorizacionEmergencia> findAutorizacionesXCedulaXFechaDesdexFechaHastaxTipoEmp(String cedula, final Date fechaDesde, final Date fechaHasta, String tipoEmp);
}