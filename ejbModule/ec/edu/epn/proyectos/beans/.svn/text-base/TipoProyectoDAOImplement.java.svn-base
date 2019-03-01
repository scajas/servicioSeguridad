package ec.edu.epn.proyectos.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.proyectos.entities.TipoProyectoP;

/**
 * Session Bean implementation class TipoProyectoDAOImplement
 */
@Stateless
@LocalBean
public class TipoProyectoDAOImplement extends DaoGenericoImplement<TipoProyectoP> implements TipoProyectoDAO {

	@Override
	public TipoProyectoP buscarTipoProy(Integer idProy) throws Exception {
		Query qUsuario = getEntityManager().createQuery(
				"select tp from TipoProyectoP tp WHERE tp.idTipoProy = ?1");
		qUsuario.setParameter(1, idProy);
		return (TipoProyectoP) qUsuario.getSingleResult();
	}
}
