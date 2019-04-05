package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Servicio;

/**
 * Session Bean implementation class ServicioDAOImplement
 */
@Stateless
@LocalBean
public class ServicioDAOImplement extends DaoGenericoImplement<Servicio> implements ServicioDAO {

    /**
     * Default constructor. 
     */
    public ServicioDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
  	public List<Servicio> listaServicioUnidad(int id) {
      	StringBuilder queryString = 
  			  new StringBuilder("SELECT b FROM Servicio b where b.laboratorio.unidad.idUnidad = ?1 ");
      		//  new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");
  		  Query query = getEntityManager().createQuery(queryString.toString());
  		  query.setParameter(1, id);
  		  
  		  List<Servicio> resultados = query.getResultList();
  		  return resultados; 
  	}
    
    @Override
  	public String maxIdServ(int id) {
      	StringBuilder queryString = 
  			  new StringBuilder("SELECT max(b.idServicio) FROM Servicio b where b.laboratorio.unidad.idUnidad = ?1 ");
      		//  new StringBuilder("SELECT b FROM Servicio b where id_Unidad = ?1 ");
  		  Query query = getEntityManager().createQuery(queryString.toString());
  		  query.setParameter(1, id);
  		  
  		 String idServ = (String) query.getSingleResult();
  		  return idServ; 
  	}

}