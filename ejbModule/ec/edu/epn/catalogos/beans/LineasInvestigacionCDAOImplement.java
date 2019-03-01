package ec.edu.epn.catalogos.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.catalogos.entities.LineasInvestigacion;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class LineasInvestigacionCDAOImplement
 */
@Stateless
@LocalBean
public class LineasInvestigacionCDAOImplement  extends DaoGenericoImplement<LineasInvestigacion> implements LineasInvestigacionCDAO {

	@Override
	public List<LineasInvestigacion> findlinInvAntiguas(Integer iddept) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select linv from LineasInvestigacion linv where linv.departamento.idDepart = ?1  order by linv.nomLinin ");
		qUsuario.setParameter(1, iddept);

		return qUsuario.getResultList();

	}
	
	
	@Override
	public List<LineasInvestigacion> findlinInv(Integer iddept) {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select linv from LineasInvestigacion linv where linv.departamento.idDepart = ?1  and linv.estLinea = ?2   order by linv.nomLinin ");
		qUsuario.setParameter(1, iddept);
		qUsuario.setParameter(2, "A");
		return qUsuario.getResultList();

	}
	
	
	@Override
	public LineasInvestigacion finLininv(Integer idlininv) throws Exception {
		Query qUsuario = getEntityManager()
				.createQuery(
						"select linv from LineasInvestigacion linv where linv.idLinin = ?1");
		qUsuario.setParameter(1, idlininv);
		return (LineasInvestigacion) qUsuario.getSingleResult();

	}


}
