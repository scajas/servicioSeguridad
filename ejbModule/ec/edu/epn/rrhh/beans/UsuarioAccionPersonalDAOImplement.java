package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.rrhh.movimientos.Usuarioaccion;

@Stateless
public class UsuarioAccionPersonalDAOImplement  extends DaoGenericoImplement<Usuarioaccion> implements UsuarioAccionPersonalDAO{

	@Override
	public List<Usuarioaccion> getPermisosAccionesByIdUsuario(Long idUsuario) {
		  StringBuilder queryString = 
				  new StringBuilder("SELECT user FROM Usuarioaccion user where"
				  		+ " user.id.idUsuario = ?1 ");
		  Query query = getEntityManager().createQuery(queryString.toString());
		  query.setParameter(1, idUsuario);
		  
		  List<Usuarioaccion> resultados = query.getResultList();
		  return resultados;  
		
	}

}
