package ec.edu.epn.acreditacion.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.acreditacion.entities.Evidencia;
import ec.edu.epn.acreditacion.entities.EvidenciaDetalle;
import ec.edu.epn.generic.DAO.DaoGenericoImplement;

/**
 * Session Bean implementation class EvidenciaADAOImplement
 */
@Stateless
@LocalBean
public class EvidenciaADAOImplement extends DaoGenericoImplement<Evidencia> implements EvidenciaADAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Evidencia> buscarpreguntasEvidencias(Integer idPerfilencargado, Integer idPerfilvalida,
			Integer idPerfilvarifica) throws Exception {

		StringBuilder queryString = new StringBuilder("SELECT s from EvidenciaCatalogo s where    ");

		if (idPerfilencargado != 0) {
			queryString.append(" s.idPerfilEncargado = ?0 ");

		}

		if (idPerfilvalida != 0) {
			queryString.append(" s.idPefilValidaFirma = ?1 ");

		}

		if (idPerfilvarifica != 0) {
			queryString.append(" s.idPerfilVerifica = ?2 ");

		}

		queryString.append(" order by s.id ");

		Query query = getEntityManager().createQuery(queryString.toString());

		if (idPerfilencargado != 0) {
			query.setParameter(0, idPerfilencargado);

		}

		if (idPerfilvalida != 0) {
			query.setParameter(1, idPerfilvalida);

		}

		if (idPerfilvarifica != 0) {
			query.setParameter(2, idPerfilvarifica);

		}

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EvidenciaDetalle> buscarpreguntasEvidenciasValidadas(String path, String valida, String verifica,
			String enviadaA, Integer idPerfilencargado, Integer idPerfilvalida, Integer idPerfilvarifica,String codcarre, Integer idmodelo)
			throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT e from  EvidenciaDetalle e where    ");

		
		if (codcarre != null) {
			queryString.append(" e.idCarrera = ?0 ");

		}
		
		
		if (idmodelo != 0) {
			queryString.append(" and e.evidencia.id = ?1 ");

		}
		
		if (path != null) {
			queryString.append(" and e.path is not null ");

		}

		if (valida != null) {
			queryString.append(" and e.responsableValida = ?2 ");

		}

		if (verifica != null) {
			queryString.append("and  e.responsableVerifica = ?3 ");

		}

		if (enviadaA != null) {
			queryString.append("and  e.enviadaAlfresco = ?4 ");

		}

		if (idPerfilencargado != 0) {
			queryString.append(" and e.evidencia.idPerfilEncargado = ?5 ");

		}

		if (idPerfilvalida != 0) {
			queryString.append(" and e.evidencia.idPefilValidaFirma = ?6 ");

		}

		if (idPerfilvarifica != 0) {
			queryString.append(" and e.evidencia.idPerfilVerifica = ?7 ");

		}
		
		
		
		

		Query query = getEntityManager().createQuery(queryString.toString());

		if (codcarre != null) {
			query.setParameter(0, codcarre);

		}

		if (idmodelo != 0) {
			query.setParameter(1, idmodelo);

		}

		
		if (path != null) {
			System.out.println("Si busca si no tiene path");

		}

		if (valida != null) {
			query.setParameter(2, valida);

		}

		if (verifica != null) {
			query.setParameter(3, verifica);

		}

		if (enviadaA != null) {
			query.setParameter(4, enviadaA);

		}

		if (idPerfilencargado != 0) {
			query.setParameter(5, idPerfilencargado);

		}

		if (idPerfilvalida != 0) {
			query.setParameter(6, idPerfilvalida);

		}

		if (idPerfilvarifica != 0) {
			query.setParameter(7, idPerfilvarifica);

		}
		
		

		return query.getResultList();
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Evidencia> listEvidenciasXSubCriterio(Integer idSubCriterio, String conIndicador)throws Exception {
		
		
		StringBuilder queryString = new StringBuilder(
											"SELECT e FROM EvidenciaCatalogo e, Indicador i WHERE e.subcriterio.idSubcr = i.subcriterio.idSubcr ");		
				
		if(idSubCriterio!=0){
			queryString.append(" AND e.subcriterio.idSubcr= ?0 ");
		}
		
		if (conIndicador != null) {
			queryString.append(" AND e.codEvid like CONCAT(?1, '%') ");

		}
		
		
		Query query = getEntityManager().createQuery(queryString.toString());
		
		if(idSubCriterio!=0){
			query.setParameter(0, idSubCriterio);
		}
		
		if (conIndicador != null) {
			query.setParameter(1, conIndicador);

		}		
		
		return query.getResultList();
	}

}
