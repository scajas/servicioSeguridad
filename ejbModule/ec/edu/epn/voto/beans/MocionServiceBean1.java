package ec.edu.epn.voto.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import ec.edu.epn.voto.entities.Asistencia;
import ec.edu.epn.voto.entities.Consejo;
import ec.edu.epn.voto.entities.MiembroVoto;
import ec.edu.epn.voto.entities.Mocion;
import ec.edu.epn.voto.entities.OrdenDia;
import ec.edu.epn.voto.entities.ParametroVoto;
import ec.edu.epn.voto.entities.PerfilConsejo;
import ec.edu.epn.voto.entities.RegVotacion;
import ec.edu.epn.voto.entities.Resolucion;
import ec.edu.epn.voto.entities.Votacion;

/**
 * Session Bean implementation class MocionServiceBean
 */
@Stateless
public class MocionServiceBean1 implements MocionService1 {

	@PersistenceContext(unitName = "ServiciosSeguridadEPN")
	protected EntityManager em;

	

	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<OrdenDia> findOrdenDia(Date fecha) {

		StringBuilder queryString = new StringBuilder(
				"SELECT od FROM OrdenDia od where od.fechaOrden = ?0 and od.tieneMocion = ?1 ");

		queryString.append("ORDER BY od.idOrden ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, fecha);
		query.setParameter(1, "S");

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	@Override
	public List<OrdenDia> findOrdenDiaByConsejo(Date fecha, int idconsejo) {

		StringBuilder queryString = new StringBuilder(
				"SELECT od FROM OrdenDia od where od.fechaOrden = ?0 and od.tieneMocion = ?1 and od.convocatoria.consejo.idConsejo = ?2 ");

		queryString.append("ORDER BY od.idOrden ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, fecha);
		query.setParameter(1, "S");
		query.setParameter(2, idconsejo);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	
	
	
	
	@Override
	public List<Mocion> findocion(Integer idOrden) {

		StringBuilder queryString = new StringBuilder(
				"SELECT moc FROM Mocion moc where moc.ordenDia.idOrden = ?0 ");

		queryString.append("ORDER BY moc.idMocion ");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idOrden);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	@Override
	public List<Votacion> findVotoS(Integer idmoion) {

		StringBuilder queryString = new StringBuilder(
				"SELECT vot FROM Votacion vot where vot.regVotación.mocion.idMocion = ?0 ");

		

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idmoion);
		

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	@Override
	public List<Votacion> findVoto(Integer idmoion, String cedula) {

		StringBuilder queryString = new StringBuilder(
				"SELECT vot FROM Votacion vot where vot.regVotación.mocion.idMocion = ?0 and vot.miembro.nced = ?1");

		

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idmoion);
		query.setParameter(1, cedula);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	@Override
	public Consejo Consejo( int idconsejo) {
		Query q = em.createQuery("Select con from Consejo con where con.idConsejo = ?0");
		
		q.setParameter(0, idconsejo);
		return (Consejo) q.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MiembroVoto> findMiembros(String cedula, String nombre, String apellido) {

		
		
		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"SELECT mi FROM MiembroVoto mi where mi.nced like ?0 ");

		if (nombre != null) {
			queryString.append(" AND mi.nombre like ?1 ");
		}

		if (apellido != null) {
			queryString.append(" AND mi.apellido like ?2 ");
		}
		
		

		queryString.append("ORDER BY mi.apellido ");

		Query query = getEntityManager().createQuery(queryString.toString());
		
			query.setParameter(0, "%"+cedula+"%");
		
		if (nombre != null) {
			query.setParameter(1, "%"+nombre+"%");
		}
		
		if (apellido != null) {
			query.setParameter(2, "%"+apellido+"%");
		}
		
		
		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MiembroVoto> findMiembrosConsejo(String cedula, String nombre, String apellido, int idconsejo) {

		
		
		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"SELECT mi FROM MiembroVoto mi where mi.nced like ?0 ");

		if (nombre != null) {
			queryString.append(" AND mi.nombre like ?1 ");
		}

		if (apellido != null) {
			queryString.append(" AND mi.apellido like ?2 ");
		}
		
		if (idconsejo != 0) {
			queryString.append(" AND mi.consejo.idConsejo = ?3 ");
		}
		
		

		queryString.append("ORDER BY mi.apellido ");

		Query query = getEntityManager().createQuery(queryString.toString());
		
			query.setParameter(0, "%"+cedula+"%");
		
		if (nombre != null) {
			query.setParameter(1, "%"+nombre+"%");
		}
		
		if (apellido != null) {
			query.setParameter(2, "%"+apellido+"%");
		}
		
		if (idconsejo != 0) {
			query.setParameter(3, idconsejo);
		}
		
		
		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public MiembroVoto findMiembro(String cedula) {

		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"SELECT mi FROM MiembroVoto mi where mi.nced = ?0 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		
			query.setParameter(0, cedula);
		
	
		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return (MiembroVoto) query.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public MiembroVoto findMiembroConsejo(String cedula , int idconsejo) {

		System.out.println("Entraaaaaaaaa la consulta de la busquedaaaaaaaaaa");

		StringBuilder queryString = new StringBuilder(
				"SELECT mi FROM MiembroVoto mi where mi.nced = ?0 and mi.consejo.idConsejo = ?1 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		
			query.setParameter(0, cedula); 
			query.setParameter(1, idconsejo);
		
	
		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return (MiembroVoto) query.getSingleResult();
	}
	
	
	
	@Override
	public int consultarIdMocion(){
		System.out.println("Entraaaaaaa ConsultarID");
		Query q= getEntityManager().createQuery("SELECT MAX(moc.idMocion)FROM Mocion moc");
		
		Integer idReq=null;
		try{
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq= (Integer)q.setMaxResults(1).getSingleResult();
				}catch(Exception e){
					
					e.printStackTrace();
					idReq = null;
					
				}if (idReq == null) {
					idReq = 1;
					
				} else {
					++idReq;
					
				}

				System.out.println("IDDDDDDDDDD"+idReq);
				return idReq;		
				
	}
	
	@Override
	public int consultarIdVoto(){
		System.out.println("Entraaaaaaa ConsultarID");
				
		Query q= getEntityManager().createQuery("SELECT MAX(vot.idVotacion)FROM Votacion vot");
		
		
		Integer idReq=null;
		try{
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq= (Integer)q.setMaxResults(1).getSingleResult();
				}catch(Exception e){
					
					e.printStackTrace();
					idReq = null;
					
				}if (idReq == null) {
					idReq = 1;
					
				} else {
					++idReq;
					
				}

				System.out.println("IDDDDDDDDDD"+idReq);
				return idReq;		
				
	}
	
	@Override
  	public void insertarMocion(Mocion moc)throws Exception{
  		getEntityManager().persist(moc);
  	}
	
	@Override
  	public void updateMOcion(Mocion moc)throws Exception{
  		getEntityManager().merge(moc);
  	}
	
	@Override
  	public void eliminarMocion(Mocion moc)throws Exception{
		getEntityManager().remove(getEntityManager().merge(moc)); 
  	}
	
	@Override
  	public void insertarVoto(Votacion vot)throws Exception{
  		getEntityManager().persist(vot);
  	}
	
	
	
	@Override
  	public void insertarregVot(RegVotacion reg)throws Exception{
  		getEntityManager().persist(reg);
  	}
	
	@Override
  	public void updateRegVot(RegVotacion reg)throws Exception{
  		getEntityManager().merge(reg);
  	}
	
	
	@Override
	public int consultarIdRegVot(){
		System.out.println("Entraaaaaaa ConsultarID");
				
		Query q= getEntityManager().createQuery("SELECT MAX(reg.idRegVot)FROM RegVotacion reg");
		
		
		Integer idReq=null;
		try{
			System.out.println("Entraaaaaaa tryyyyyyyyy");
			idReq= (Integer)q.setMaxResults(1).getSingleResult();
				}catch(Exception e){
					
					e.printStackTrace();
					idReq = null;
					
				}if (idReq == null) {
					idReq = 1;
					
				} else {
					++idReq;
					
				}

				System.out.println("IDDDDDDDDDD"+idReq);
				return idReq;		
				
	}
	
	
	@Override
	public RegVotacion findRegVotracion(Integer idMocion) {

		StringBuilder queryString = new StringBuilder(
				"SELECT reg FROM RegVotacion reg where reg.mocion.idMocion = ?0");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idMocion);
		

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return (RegVotacion) query.getSingleResult();
	}
	
	
	@Override
	public Resolucion findresolucionByMocion(Integer idMocion) {

		
		
		
		try{
		StringBuilder queryString = new StringBuilder(
				"SELECT reg FROM Resolucion reg where reg.mocion.idMocion = ?0");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idMocion);
		
		

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		
		Resolucion resol = (Resolucion) query.getSingleResult();
		System.out.println(resol.getResuelto());
		return resol;
		}
	     catch(NoResultException e) {
	        return null;
	    }
		
		
	}
	
	
	@Override
	public ParametroVoto findParametroConsejo(Integer idconsejo) {

		StringBuilder queryString = new StringBuilder(
				"SELECT par FROM ParametroVoto par where par.consejo.idConsejo = ?0");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idconsejo);
		

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return (ParametroVoto) query.getSingleResult();
	}
	
	
	@Override
	public PerfilConsejo findPerfilConsejo(Integer idperfil) {

		StringBuilder queryString = new StringBuilder(
				"SELECT par FROM PerfilConsejo par where par.idPerfil = ?0");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idperfil);
		

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return (PerfilConsejo) query.getSingleResult();
	}
	
	
	
	
	@Override
  	public void updateparam(ParametroVoto param)throws Exception{
  		getEntityManager().merge(param);
  	}
	
	
	@Override
  	public void insertResolucion(Resolucion resol)throws Exception{
  		getEntityManager().merge(resol);
  	}
	
	
	
	
	@Override
	public List<RegVotacion> findRegExiste(Integer idmoion) {

		StringBuilder queryString = new StringBuilder(
				"SELECT reg FROM RegVotacion reg where reg.mocion.idMocion = ?0");

		Query query = getEntityManager().createQuery(queryString.toString());

		query.setParameter(0, idmoion);

		System.out.println("Saleeeee de  la consulta de la busquedaaaaaaaaaa");
		return query.getResultList();
	}
	
	
	
	
	@Override
	public Double constarVotos(String voto, Integer idmocion){
		System.out.println("consultar");
		
		StringBuilder queryString = new StringBuilder(
				"SELECT SUM(vot.ponderado)FROM Votacion vot where vot.voto = ?0 and vot.regVotación.mocion.idMocion = ?1");

		Query query = getEntityManager().createQuery(queryString.toString());
		
			query.setParameter(0, voto);
			query.setParameter(1, idmocion);
		
		Double idReq=null;
		
			
			idReq= (Double)query.getSingleResult();
				
				return idReq;		
				
	}
	
	
	
	
	@Override
	public List<Votacion> verVotaciones(String voto, Integer idmocion){
		System.out.println("consultar");
		
		StringBuilder queryString = new StringBuilder(
				"SELECT vot FROM Votacion vot where vot.voto = ?0 and vot.regVotación.mocion.idMocion = ?1");

		Query query = getEntityManager().createQuery(queryString.toString());
		
			query.setParameter(0, voto);
			query.setParameter(1, idmocion);
		
		
			
				return query.getResultList();		
				
	}
	
	@Override
	public Long constarAsistentes(Date fechaActual, Integer Idconsejo, String estado){
		
		
		StringBuilder queryString = new StringBuilder(
				"SELECT COUNT(asis)FROM Asistencia asis where asis.sesion.fechaSesion = ?0 and asis.miembro.consejo.idConsejo = ?1 and asis.estado = ?2" );

		Query query = getEntityManager().createQuery(queryString.toString());
		
			query.setParameter(0, fechaActual);
			query.setParameter(1, Idconsejo);
			query.setParameter(2, estado);
			
		
		Long idReq=null;
		
			
			idReq= (Long)query.getSingleResult();
				
				return idReq;		
				
	}
	
	
	@Override
	public Long constarAsistentesVotacion(Date fechaActual, Integer Idconsejo, String estado){
		
		
		StringBuilder queryString = new StringBuilder(
				"SELECT COUNT(asis)FROM Asistencia asis where asis.sesion.fechaSesion = ?0 and asis.miembro.consejo.idConsejo = ?1 and asis.estado = ?2" +
				" and asis.miembro.votacion = ?3 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		
			query.setParameter(0, fechaActual);
			query.setParameter(1, Idconsejo);
			query.setParameter(2, estado);
			query.setParameter(3, "S");
			
		
		Long idReq=null;
		
			
			idReq= (Long)query.getSingleResult();
				
				return idReq;		
				
	}
	
	
	
	@Override
	public List<Asistencia> verAsistentes(Integer Idconsejo, String estado, Integer idsesion ){
		
		
		StringBuilder queryString = new StringBuilder(
				"SELECT asis FROM Asistencia asis where asis.sesion.idSesion = ?0 and asis.miembro.consejo.idConsejo = ?1 and asis.estado = ?2 ");

		Query query = getEntityManager().createQuery(queryString.toString());
		
			query.setParameter(0, idsesion);
			query.setParameter(1, Idconsejo);
			query.setParameter(2, estado);
			
		
		return query.getResultList();
				
	}
	
	
	

}
