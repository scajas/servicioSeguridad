package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.beans.PaisDAO;
import ec.edu.epn.gestionDocente.entities.Pais;

@Stateless
public class PaisAPDAOImplement extends DaoGenericoImplement<Pais> implements PaisDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Pais> findAllPaises() throws Exception {
		
		Query query = getEntityManager().createNamedQuery("Pais.findAll");
		return query.getResultList();

	}	
	
	@Override
	public Pais findAllPaisesByNombre(String nombrePais) throws Exception {
		Query query = getEntityManager().createNamedQuery("Pais.findNombre");
		query.setParameter("nombre", nombrePais.toUpperCase());
		return (Pais) query.getSingleResult();

	}

	
	
	
	
}
