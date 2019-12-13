package ec.edu.epn.laboratorioBJ.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.laboratorioBJ.entities.LaboratorioLab;
import ec.edu.epn.laboratorioBJ.entities.Tipocliente;

/**
 * Session Bean implementation class TipoClienteDAOImplement
 */
@Stateless
@LocalBean
public class TipoClienteDAOImplement extends DaoGenericoImplement<Tipocliente> implements  TipoClienteDAO {

    /**
     * Default constructor. 
     */
    public TipoClienteDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public List<Tipocliente> getLisTC() {

		StringBuilder queryString = new StringBuilder(
				"SELECT tc FROM Tipocliente tc ORDER BY tipoTcl ASC");
		Query query = getEntityManager().createQuery(queryString.toString());

		List<Tipocliente> resultados = query.getResultList();
		return resultados;
	}
	
}
