package ec.edu.epn.atencionmedica.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import ec.edu.epn.atencionmedica.entities.Catalogo;
import ec.edu.epn.atencionmedica.entities.Catalogotipo;
import ec.edu.epn.atencionmedica.entities.Paciente;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

@Stateless(mappedName="PacienteDAOImplement")
public class PacienteDAOImplement extends DaoGenericoImplement<Paciente> implements PacienteDAO {
	
	//variables
	public Query query = null;
	public String q ="";
	public StringBuilder queryString = null;
	
	@Override
	public List<Paciente> obtenerListaPacientes(String criterio) {

		if (criterio.isEmpty() || criterio.equals("") || criterio.equals(" ") || criterio.equals("0") ){
			q = "SELECT pac FROM Paciente pac " +
					" order by pac.apellido1Pac, pac.apellido2Pac, nombre1Pac, nombre2Pac";
			queryString = new StringBuilder(q);
			query = getEntityManager().createQuery(queryString.toString());
			
		}
		else {
			try {				
				try {
					if (criterio.length()>0 || Integer.parseInt(criterio) == 0){						
						q = "SELECT pac FROM Paciente pac WHERE pac.identificacionPac LIKE ?0 " +
							" OR pac.numerohclPac = ?1 " +
							" order by pac.apellido1Pac, pac.apellido2Pac, nombre1Pac, nombre2Pac" ;
						queryString = new StringBuilder(q);
						query = getEntityManager().createQuery(queryString.toString());
						query.setParameter(0, "%" + criterio + "%");
						query.setParameter(1, Integer.parseInt(criterio));
					}
				} catch (Exception e) {
					
					q = "SELECT pac FROM Paciente pac WHERE " +
						"pac.identificacionPac LIKE ?0 " +	
						" OR  pac.apellido1Pac LIKE ?1 " + 						
						" OR (pac.apellido1Pac||' '||pac.apellido2Pac||' '||pac.nombre1Pac||' '||pac.nombre2Pac) LIKE ?2 " +
						" order by pac.apellido1Pac, pac.apellido2Pac, nombre1Pac, nombre2Pac ";
					queryString = new StringBuilder(q);
					query = getEntityManager().createQuery(queryString.toString());
					query.setParameter(0, "%" + criterio + "%");
					query.setParameter(1, "%" + criterio + "%");
					query.setParameter(2, "%" + criterio + "%");
				}
								
			} catch (Exception e) {
				// TODO Auto-generated catch block			
				e.printStackTrace();
			}
			
			
		}
		return query.getResultList();
	}
	@Override
	public Paciente obtenerPaciente(String criterio) {
		
		query = getEntityManager()
				.createQuery(
						"SELECT pac FROM Paciente pac WHERE pac.identificacionPac LIKE ?0");
		query.setParameter(0, "%" + Integer.parseInt(criterio.trim()) + "%");

		Paciente aux = new Paciente();
		aux.setCatalogo(new Catalogo());		
		aux.getCatalogo().setCatalogotipo(new Catalogotipo());
		Paciente obj = new Paciente();
		obj.setCatalogo(new Catalogo());
		obj.getCatalogo().setCatalogotipo(new Catalogotipo());
		
		try {
			aux = (Paciente) query.getSingleResult();			
			obj=aux;			
			
		} catch (NoResultException e) {
			System.out.println("==================IDENTIFICACION NO ENCONTRADA: =====" + criterio);
			//e.printStackTrace();
			obj = null;
		} catch (NonUniqueResultException e) {
			System.out.println("==================MAS DE UNA IDENTIFICACION ENCONTRADA: =====" + criterio);
			//e.printStackTrace();
			obj = aux;
		} catch (Exception e) {
			System.out.println("==================ERROR EN LA BÚSQUEDA: =====" + criterio);
			//e.printStackTrace();
			obj = null;
		}
		return obj;
	}
	@Override
	public boolean guardarPaciente(Paciente paciente, String operacion) {
		if (operacion.equals("Ingresar")){
			paciente.setNumerohclPac(generarId("Paciente","numerohclPac"));					
			getEntityManager().persist(paciente);
			return true;
		}
		else if (operacion.equals("Actualizar")){			
			getEntityManager().merge(paciente);
			return true;
		}
		else
			return false;
	}
	@Override
	public boolean eliminarPaciente(Paciente paciente, String operacion) {
		try {
			if (operacion.equals("Eliminar")){
				Paciente o = getEntityManager().find(Paciente.class, paciente.getIdPaciente());
				if (o!=null)
				{
					getEntityManager().remove(o);
					return true;
				}
				else
				{
					return false; 
				}
			} 
			else
				return false;
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}

	

}
