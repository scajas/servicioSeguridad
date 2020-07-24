/**
 * 
 */
package ec.edu.epn.emergencia.beans;

import java.util.Date;
import javax.persistence.Query;
import java.util.List;
import javax.ejb.Stateless;
import ec.edu.epn.emergencia.entidades.AutorizacionEmergencia;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

@Stateless
public class AutorizacionEmergenciaDAOImplement extends DaoGenericoImplement<AutorizacionEmergencia> implements AutorizacionEmergenciaDAO
{
    public List<AutorizacionEmergencia> findAutorizaciones() {
        final Query q = this.getEntityManager().createQuery("Select dep from AutorizacionEmergencia dep ");
        return (List<AutorizacionEmergencia>)q.getResultList();
    }
    
    public List<AutorizacionEmergencia> findAutorizacionesXCedula(final String cedula) {
        final Query q = this.getEntityManager().createQuery("Select dep from AutorizacionEmergencia dep where dep.cedula = :cedula order by fechaDesde ASC");
        q.setParameter("cedula", (Object)cedula);
        return (List<AutorizacionEmergencia>)q.getResultList();
    }
    
    public List<AutorizacionEmergencia> findAutorizacionesXCedulaXFechaDesdexFechaHasta(String cedula, final Date fechaDesde, final Date fechaHasta) {
        final StringBuilder query = new StringBuilder("Select dep from AutorizacionEmergencia dep ");
        if (cedula != null && !cedula.equals("")) {
            cedula = String.valueOf(cedula) + "%";
            query.append("where dep.cedula like :cedula ");
        }
        if (fechaDesde != null) {
            if (cedula != null && !cedula.equals("")) {
                query.append("and ");
            }
            else {
                query.append("where ");
            }
            query.append("dep.fechaHasta >= :fechaDesde ");
        }
        if (fechaHasta != null) {
            if ((cedula != null && !cedula.equals("")) || fechaDesde != null) {
                query.append("and ");
            }
            else {
                query.append("where ");
            }
            query.append("dep.fechaDesde <= :fechaHasta ");
        }
        query.append("order by dep.fechaDesde ASC");
        final Query q = this.getEntityManager().createQuery(query.toString());
        if (cedula != null && !cedula.equals("")) {
            q.setParameter("cedula", (Object)cedula);
        }
        if (fechaHasta != null) {
            q.setParameter("fechaHasta", (Object)fechaHasta);
        }
        if (fechaDesde != null) {
            q.setParameter("fechaDesde", (Object)fechaDesde);
        }
        return (List<AutorizacionEmergencia>)q.getResultList();
    }
    
    
    public List<AutorizacionEmergencia> findAutorizacionesXCedulaXFechaDesdexFechaHastaxTipoEmp(String cedula, final Date fechaDesde, final Date fechaHasta, String tipoEmp) {
        final StringBuilder query = new StringBuilder("Select dep from AutorizacionEmergencia dep ");
        query.append("where dep.tipoPersona like :tipoEmp ");
        
        if (cedula != null && !cedula.equals("")) {
            cedula = String.valueOf(cedula) + "%";
            query.append("and dep.cedula like :cedula ");
        }
        if (fechaDesde != null) {
           
            query.append("and dep.fechaHasta >= :fechaDesde ");
        }
        if (fechaHasta != null) {
            
            query.append("and dep.fechaDesde <= :fechaHasta ");
        }
        query.append("order by dep.fechaDesde ASC");
        final Query q = this.getEntityManager().createQuery(query.toString());
        if (cedula != null && !cedula.equals("")) {
            q.setParameter("cedula", (Object)cedula);
        }
        if (fechaHasta != null) {
            q.setParameter("fechaHasta", (Object)fechaHasta);
        }
        if (fechaDesde != null) {
            q.setParameter("fechaDesde", (Object)fechaDesde);
        }
        q.setParameter("tipoEmp",tipoEmp);
        return (List<AutorizacionEmergencia>)q.getResultList();
    }
    
    public List<AutorizacionEmergencia> findAutorizacionesXExpiradoAutorizado(final Date fechaActual) {
        final StringBuilder query = new StringBuilder("Select dep from AutorizacionEmergencia dep where dep.fechaHasta < :fechaActual and dep.estado.idEstado = 1");
        final Query q = this.getEntityManager().createQuery(query.toString());
        q.setParameter("fechaActual", (Object)fechaActual);
        return (List<AutorizacionEmergencia>)q.getResultList();
    }
    
    public List<AutorizacionEmergencia> findAutorizacionesXEstadoCalendarizado(final Date fechaActual) {
        final StringBuilder query = new StringBuilder("Select dep from AutorizacionEmergencia dep where dep.fechaDesde < :fechaActual and dep.estado.idEstado = 6");
        final Query q = this.getEntityManager().createQuery(query.toString());
        q.setParameter("fechaActual", (Object)fechaActual);
        return (List<AutorizacionEmergencia>)q.getResultList();
    }
    
    public List<AutorizacionEmergencia> findAutorizacionesXEstadoPersona(final String estadoPorIngresar) {
        final StringBuilder query = new StringBuilder("Select dep from AutorizacionEmergencia dep where  dep.estadoPersona = :estadoPorIngresar");
        final Query q = this.getEntityManager().createQuery(query.toString());
        q.setParameter("estadoPorIngresar", (Object)estadoPorIngresar);
        return (List<AutorizacionEmergencia>)q.getResultList();
    }
    
    public Integer getMaxId() {
        final StringBuilder queryString = new StringBuilder("SELECT max(idAutorizacion) FROM AutorizacionEmergencia fam ");
        final Query query = this.getEntityManager().createQuery(queryString.toString());
        final Integer max = (Integer)query.getSingleResult();
        if (max == null) {
            return 0;
        }
        return max;
    }
}