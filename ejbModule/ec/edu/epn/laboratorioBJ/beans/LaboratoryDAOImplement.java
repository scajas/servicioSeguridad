package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.Muestra;
import ec.edu.epn.laboratorioBJ.entities.laboratory;

/**
 * Session Bean implementation class LaboratoryDAOImplement
 */
@Stateless
@LocalBean
public class LaboratoryDAOImplement extends DaoGenericoImplement<laboratory> implements LaboratoryDAO {

    /**
     * Default constructor. 
     */
    public LaboratoryDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public List<laboratory> ListarBodegaById(int id) {

		System.out.println("Id usuario: " + id);
		StringBuilder queryString = new StringBuilder(
				"SELECT DISTINCT (l) FROM laboratory l,  BodegaUsuario b WHERE l.idBodega = b.id.idBodega "
				+ "AND l.idUsuario = b.id.idUsuario "
				+ "AND l.idUsuario = " + id +" ORDER BY l.nombreBg");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<laboratory> resultados = query.getResultList();
		return resultados;
	}

}
