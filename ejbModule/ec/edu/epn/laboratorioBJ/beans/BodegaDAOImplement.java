package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Bodega;
import ec.edu.epn.rrhh.entities.Estudio;
import ec.edu.epn.rrhh.movimientos.Usuarioaccion;
import ec.edu.epn.seguridad.vo.Perfil;

/**
 * Session Bean implementation class BodegaDAOImplement
 */
@Stateless
@LocalBean
public class BodegaDAOImplement extends DaoGenericoImplement<Bodega> implements BodegaDAO {

    /**
     * Default constructor. 
     */
    public BodegaDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public List<Bodega> listaBodegaUnidad(int id) {
    	StringBuilder queryString = 
				  new StringBuilder("SELECT b FROM Bodega b where id_unidad = ?1 ");
		  Query query = getEntityManager().createQuery(queryString.toString());
		  query.setParameter(1, id);
		  
		  List<Bodega> resultados = query.getResultList();
		  return resultados; 
	}
}
