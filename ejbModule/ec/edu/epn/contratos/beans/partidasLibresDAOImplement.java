package ec.edu.epn.contratos.beans;
/**

 * 
 */
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.contratos.entities.PartidasLibre;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;



/**
 * @author Administrador
 * 
 */
@Stateless
public class partidasLibresDAOImplement extends
		DaoGenericoImplement<PartidasLibre> implements partidasLibresDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<PartidasLibre> buscarPartidaActiva() {
		StringBuilder queryString = new StringBuilder(
				"SELECT act FROM PartidasLibre act where act.estado =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, "Activa");

		System.out
				.println("LISTA DE PARIDAS PRESUPUESTARIAS ACTIVAS...!!!!!!!!!!!!: "
						+ query.getResultList().size());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PartidasLibre> buscarPartidaContrato(int idCont) {

		StringBuilder queryString = new StringBuilder(
				"SELECT p FROM PartidasLibre p where p.tipoContrato.idTcont =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idCont);

		System.out
				.println("LISTA DE PARTIDAS PRESUPUESTARIAS TIPO CONTRATO...!!!!!!!!!!!!: "
						+ query.getResultList().size());
		return query.getResultList();
	}
	


	@Override
	public void updatePartidaLibre(PartidasLibre part) {
		getEntityManager().merge(part);

	}

	@Override
	public List<PartidasLibre> buscaPartidaXTipoContarto(int idtipoContrato) {
		StringBuilder queryString = new StringBuilder(
				"SELECT act FROM PartidasLibre act where act.tipoContrato.idTcont =?1");
		Query query = getEntityManager().createQuery(queryString.toString());
		query.setParameter(1, idtipoContrato);

		System.out
				.println("LISTA DE PARIDAS PRESUPUESTARIAS ACTIVAS...!!!!!!!!!!!!: "
						+ query.getResultList().size());
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PartidasLibre> buscarReportePartidas(Integer idTipoContrato, String estado, String numeroPartida) {
		Query query = null;
		try {
				
			StringBuilder queryString = new StringBuilder(
					"SELECT act FROM PartidasLibre act WHERE act.numero LIKE ?1 AND act.estado LIKE ?2 AND (act.tipoContrato.idTcont= ?3 OR 0=?4)");
			query = getEntityManager().createQuery(queryString.toString());
			query.setParameter(1, numeroPartida);
			query.setParameter(2, estado);
			query.setParameter(3, idTipoContrato);
			query.setParameter(4, idTipoContrato);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return query.getResultList();
	}
}
