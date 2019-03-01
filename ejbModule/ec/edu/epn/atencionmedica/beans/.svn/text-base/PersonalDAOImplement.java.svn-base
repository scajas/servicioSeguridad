package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Catalogo;
import ec.edu.epn.atencionmedica.entities.Catalogotipo;
import ec.edu.epn.atencionmedica.entities.PersonalAtencion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

@Stateless(mappedName="PersonalDAOImplement")
public class PersonalDAOImplement extends DaoGenericoImplement<PersonalAtencion> implements PersonalDAO {
	
	//variables
	public Query query = null;
	public String q ="";
	public StringBuilder queryString = null;
	
	/*
	 * Obtiene los datos del personal por cedula o idPersonal
	 * @see ec.edu.epn.atencionmedica.beans.PersonalDAO#obtenerListaPersonal(java.lang.String)
	 */
	@Override
	public List<PersonalAtencion> obtenerListaPersonal(String criterio) {

		if (criterio.isEmpty() || criterio.equals("") || criterio.equals(" ") || criterio.equals("0") ){
			q = "SELECT prs FROM PersonalAtencion prs " +
					" order by prs.apellido1Prs, prs.apellido2Prs, nombre1Prs, nombre2Prs";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
		}
		try {				
			try {
				if (Integer.parseInt(criterio)>0 || Integer.parseInt(criterio) == 0){					
					q = "SELECT prs FROM PersonalAtencion prs WHERE prs.identificacionPrs LIKE ?0 " +
						" order by prs.apellido1Prs, prs.apellido2Prs, nombre1Prs, nombre2Prs";
					queryString = new StringBuilder(q);
					query = getEntityManager().createQuery(queryString.toString());
					query.setParameter(0, "%" + criterio + "%");
					//query.setParameter(1, Integer.parseInt(criterio));
					//query.setParameter(1, criterio);
				}
			} catch (Exception e) {				
				q = "SELECT prs FROM PersonalAtencion prs WHERE " +
					" prs.apellido1Prs LIKE ?2 " + 
                    " OR (prs.apellido1Prs||' '||prs.apellido2Prs||' '||prs.nombre1Prs||' '||prs.nombre2Prs) LIKE ?6 " +
					" order by prs.apellido1Prs, prs.apellido2Prs, nombre1Prs, nombre2Prs";
				queryString = new StringBuilder(q);
				query = getEntityManager().createQuery(queryString.toString());
				query.setParameter(2, "%" + criterio + "%");
				query.setParameter(6, "%" + criterio + "%");
			}
						
		} catch (Exception e) {
			
			System.out.println("---------------------------------ServiceBean------------ BUSCAR PERSONAL: QUERY: ERROR :(" );
			e.printStackTrace();
		}
		return query.getResultList();
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonalAtencion> obtenerListaPersonalReporte() {

		try {
			q = "SELECT prs FROM PersonalAtencion prs WHERE prs.estado='S'" +
					" order by prs.apellido1Prs, prs.apellido2Prs, nombre1Prs, nombre2Prs";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());		
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
		
	}
	
	@Override
	public boolean guardarPersonal(PersonalAtencion personal, String operacion) {
		if(operacion.equals("Ingresar")){
			getEntityManager().persist(personal);
			return true;
		}
		else if (operacion.equals("Actualizar")){			
			getEntityManager().merge(personal);
			return true;
		}
		else
			return false;	
					
	}
	
	@Override
	public boolean eliminarPersonal(PersonalAtencion personal, String operacion) {
		if (operacion.equals("Eliminar")){
			getEntityManager().remove(getEntityManager().merge(personal));
			return true;
		}
		else
			return false;
	}
	@Override
	public PersonalAtencion obtenerPersonal(String criterio) {
		if(criterio.trim().length() == 10)
		{
			query = getEntityManager().createQuery("SELECT prs FROM PersonalAtencion prs WHERE prs.identificacionPrs LIKE ?0");
			query.setParameter(0, "%" + criterio.trim() + "%" );
		}
		else
		{
			query = getEntityManager().createQuery("SELECT prs FROM PersonalAtencion prs WHERE prs.idPersonal = ?0");
			query.setParameter(0, Integer.parseInt(criterio));
		}
		
		PersonalAtencion aux = new PersonalAtencion();
		aux.setCatalogo1(new Catalogo());
		aux.setCatalogo2(new Catalogo());
		aux.getCatalogo1().setCatalogotipo(new Catalogotipo());
		aux.getCatalogo2().setCatalogotipo(new Catalogotipo());
		
		try {
			aux = (PersonalAtencion) query.getSingleResult();			
			
		} catch (NoResultException e) {
			System.out.println("==================OBJETO NO ENCONTRADA: =====" + criterio);
			aux = null;
		} catch (NonUniqueResultException e) {
			System.out.println("==================MAS DE UN OBJETO ENCONTRADO: =====" + criterio);			
		} catch (Exception e) {
			System.out.println("==================ERROR EN LA BÚSQUEDA: =====" + criterio);
			aux = null;
		}
		return aux;
			
	}
	
	

	

}
