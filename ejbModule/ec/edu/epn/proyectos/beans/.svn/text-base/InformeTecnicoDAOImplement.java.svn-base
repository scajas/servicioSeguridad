package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.InformeTecnico;
import ec.edu.epn.proyectos.entities.RecursohPr;

/**
 * Session Bean implementation class InformeTecnicoDAOImplement
 */
@Stateless
@LocalBean
public class InformeTecnicoDAOImplement extends DaoGenericoImplement<InformeTecnico> implements InformeTecnicoDAO {

    /**
     * Default constructor. 
     */
    public InformeTecnicoDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public List<InformeTecnico> findInformebyProy(Integer idproy) {
		Query qUsuario = getEntityManager().createQuery(
				"select rec from InformeTecnico rec where rec.proyecto.idProy = ?1  order by rec.id");
		qUsuario.setParameter(1, idproy);
		return qUsuario.getResultList();

	}

}
