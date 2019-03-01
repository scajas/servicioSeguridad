package ec.edu.epn.proyectos.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.DisciplinaProyecto;

/**
 * Session Bean implementation class DisciplinaPoryectoDAOImplement
 */
@Stateless
public class DisciplinaPoryectoDAOImplement extends DaoGenericoImplement<DisciplinaProyecto> implements DisciplinaPoryectoDAO {

    /**
     * Default constructor. 
     */
    public DisciplinaPoryectoDAOImplement() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public int consultarId() {

   		System.out.println("Entraaaaaaa ConsultarID");
   		Query q = getEntityManager().createQuery(
   				"SELECT MAX(seg.id)FROM DisciplinaProyecto seg");

   		Integer idReq = null;
   		try {
   			System.out.println("Entraaaaaaa tryyyyyyyyy");
   			idReq = (Integer) q.setMaxResults(1).getSingleResult();
   		} catch (Exception e) {

   			e.printStackTrace();
   			idReq = null;

   		}
   		if (idReq == null) {
   			idReq = 1;

   		} else {
   			++idReq;

   		}

   		System.out.println("IDDDDDDDDDD" + idReq);
   		return idReq;

   	}
    
    
    
    @Override
	public List<DisciplinaProyecto> consultardisExiste(Integer idproyecto, Integer iddisciplina) {

		StringBuilder querys = new StringBuilder("SELECT e From DisciplinaProyecto e where e.disciplina.id = ?1  and e.proyecto.idProy = ?2 order by e.disciplina.literal" );
		Query query = getEntityManager().createQuery(querys.toString());
		query.setParameter(1, iddisciplina);
		query.setParameter(2, idproyecto);
		return query.getResultList();
		
	}
    
    
    
    
    @Override
   	public List<DisciplinaProyecto> consultardisProyecto(Integer idproyecto) {

   		StringBuilder querys = new StringBuilder("SELECT e From DisciplinaProyecto e where  e.proyecto.idProy = ?1 order by e.disciplina.literal" );
   		Query query = getEntityManager().createQuery(querys.toString());
   		query.setParameter(1, idproyecto);
   		return query.getResultList();
   		
   	}
       
    
    
    
    
    
    
    
    
    
    
    

}
