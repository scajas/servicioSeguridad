package ec.edu.epn.atencionmedica.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Atencionmedica;
import ec.edu.epn.atencionmedica.entities.Movimientoinventario;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class AtencionMedicaConDespachoIMDAOImplement
 */
@Stateless
public class AtencionMedicaConDespachoIMDAOImplement extends DaoGenericoImplement<Atencionmedica> implements AtencionMedicaConDespachoIMDAO {
	
	// variables
	public Query query = null;
	public String q = "";
	public StringBuilder queryString = null;

	@Override
	public boolean guardarAtencionMedicaConMovimientosInventario(Atencionmedica atencion) {
		boolean val= false;
		
		try {		
			
			getEntityManager().persist(atencion);
			System.out.println(atencion.getIdAtencionmed());			
			Atencionmedica at = atencion; 
			/*for( int i = 0 ; i < atencion.getMovimientoinventarios().size() ; i++ ){
				atencion.getMovimientoinventarios().get(i).setAtencionmedica(at);
				getEntityManager().persist(atencion.getMovimientoinventarios().get(i));								
				Movimientoinventario mov = atencion.getMovimientoinventarios().get(i);				
				for( int j = 0 ; j < atencion.getMovimientoinventarios().get(i).getDetallemovimientos().size() ; j++ ){
					atencion.getMovimientoinventarios().get(i).getDetallemovimientos().get(j).setMovimientoinventario(mov);
					getEntityManager().persist(atencion.getMovimientoinventarios().get(i).getDetallemovimientos().get(j));					
				}
				
			}	*/		
			
			getEntityManager().clear();
					
			val = true;
		} catch (Exception e1) {
			
			try {
				getEntityManager().getTransaction().rollback();
			} catch (IllegalStateException | SecurityException ex) {
				//ex.printStackTrace();
				System.out.println("/************** ERRROR AL REVERTIR: GUARDAR ATENCIÓN MÉDICA ************/");
			}
			val = false;
		}
		return val;
	}

	@Override
	public List<Movimientoinventario> obtenerListaDespachosPendientes() {
		List<Movimientoinventario> listaAtencionesEncontradas = new ArrayList<Movimientoinventario>();
				
		q = "SELECT distinct m from Movimientoinventario m "
				+ " WHERE m.catalogotipoestadomov.idCatalogo = 27 "
				+ " and (m.catalogotipomovinventario.idCatalogo = 25 or m.catalogotipomovinventario.idCatalogo = 26) "
				+ " and to_char(m.fechahoraMov,'YYYY-MM-DD') = to_char(now(),'YYYY-MM-DD') "
				+ " order by m asc ";
		
		queryString = new StringBuilder(q);
		query = getEntityManager().createQuery(queryString.toString());		

		listaAtencionesEncontradas = query.getResultList();


		return listaAtencionesEncontradas;
	}
	
	
	@Override
	public List<Movimientoinventario> obtenerListaDespachosPendientesXFecha(Date fechaInicio, Date fechaFinal) {
		List<Movimientoinventario> listaAtencionesEncontradas = new ArrayList<Movimientoinventario>();
		
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fechaFinal); 
	    calendar.add(Calendar.DAY_OF_YEAR, 1);  
	    fechaFinal= calendar.getTime();
				
		q = "SELECT distinct m from Movimientoinventario m "
				+ " WHERE m.catalogotipoestadomov.idCatalogo = 27 "
				+ " and (m.catalogotipomovinventario.idCatalogo = 25 or m.catalogotipomovinventario.idCatalogo = 26) "
				+ " and fechahoraMov BETWEEN  ?0 AND  ?1 "
				+ " order by m asc ";
		
		queryString = new StringBuilder(q);
		query = getEntityManager().createQuery(queryString.toString());	
		query.setParameter(0, new Timestamp(fechaInicio.getTime()));
		query.setParameter(1, new Timestamp(fechaFinal.getTime()));

		listaAtencionesEncontradas = query.getResultList();


		return listaAtencionesEncontradas;
	}

	@Override
	public boolean guardarAtencionMedicaConMovimientosInventarioLista(List<Movimientoinventario> listMovimentosInventario, Atencionmedica atencion) {
		boolean val= false;
		
		try {		
			
			
			getEntityManager().persist(atencion);
			for(Movimientoinventario m : listMovimentosInventario){
				m.setAtencionmedica(atencion);
				getEntityManager().persist(m);	
				Movimientoinventario mov = m;
				for( int j = 0 ; j < mov.getDetallemovimientos().size() ; j++ ){
					m.getDetallemovimientos().get(j).setMovimientoinventario(mov);
					getEntityManager().persist(m.getDetallemovimientos().get(j));
				}
			}
			
			//getEntityManager().clear();
					
			val = true;
		} catch (Exception e1) {
			
			try {
				getEntityManager().getTransaction().rollback();
			} catch (IllegalStateException | SecurityException ex) {
				//ex.printStackTrace();
				System.out.println("/************** ERRROR AL REVERTIR: GUARDAR ATENCIÓN MÉDICA ************/");
			}
			val = false;
		}
		return val;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movimientoinventario> obtenerListaDespachosEjecutados(Integer idMedico, Date fechaDesde, Date fechaHasta) throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
		
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fechaHasta); 
	    calendar.add(Calendar.DAY_OF_YEAR, 1);  
	    fechaHasta= calendar.getTime();
		
		q = "SELECT distinct m from Movimientoinventario m "
				+ " WHERE m.catalogotipoestadomov.idCatalogo = 28 "
				+ " AND (m.catalogotipomovinventario.idCatalogo = 25 or m.catalogotipomovinventario.idCatalogo = 26) "
				+ " AND m.fechahoraMov BETWEEN ?0 AND ?1 ";
		
		
		if(idMedico!=0){
			q= q + " AND m.personal.idPersonal = ?2  ORDER BY m ASC ";
		}else{
			q= q + " ORDER BY m ASC ";
		}
				
		
		queryString = new StringBuilder(q);
		query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(0, new Timestamp(fechaDesde.getTime()));
		query.setParameter(1, new Timestamp(fechaHasta.getTime()));		
		
		if(idMedico!=0){
			query.setParameter(2, idMedico);
		}
		
		
		
		

		return query.getResultList();
		
	}


}
