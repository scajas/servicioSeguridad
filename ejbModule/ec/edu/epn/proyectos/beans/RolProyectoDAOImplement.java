package ec.edu.epn.proyectos.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.RolProyecto;
import ec.edu.epn.proyectos.entities.RolProyectoP;

/**
 * Session Bean implementation class RolProyectoDAOImplement
 */
@Stateless
@LocalBean
public class RolProyectoDAOImplement extends DaoGenericoImplement<RolProyectoP> implements RolProyectoDAO {

	
	@Override
	public RolProyectoP finrolproy(Integer idRol) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select rol from RolProyectoP rol where rol.idRolProy = ?1");
		qUsuario.setParameter(1, idRol);
		return (RolProyectoP) qUsuario.getSingleResult();

	}
    

}
