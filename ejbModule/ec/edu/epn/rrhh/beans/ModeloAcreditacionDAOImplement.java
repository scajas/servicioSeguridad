package ec.edu.epn.rrhh.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import ec.edu.epn.generic.DAO.DaoGenericoImplement;
import ec.edu.epn.gestionDocente.entities.Carre;
import ec.edu.epn.rrhh.entities.Evidencia;
import ec.edu.epn.rrhh.entities.ModeloAcreditacion;

/**
 * Session Bean implementation class ModeloAcreditacionDAOImplement
 */
@Stateless
@LocalBean
public class ModeloAcreditacionDAOImplement extends DaoGenericoImplement<ModeloAcreditacion>
		implements ModeloAcreditacionDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ModeloAcreditacion> buscarpreguntasEvidencias(Integer idPerfilencargado, Integer idPerfilvalida,
			Integer idPerfilvarifica) throws Exception {

		StringBuilder queryString = new StringBuilder("SELECT s from ModeloAcreditacion s where    ");

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
	public List<Evidencia> buscarpreguntasEvidenciasValidadas(String path, String valida, String verifica,
			String enviadaA, Integer idPerfilencargado, Integer idPerfilvalida, Integer idPerfilvarifica,String codcarre, Integer idmodelo)
			throws Exception {

		StringBuilder queryString = new StringBuilder(
				"SELECT e from  Evidencia e where    ");

		
		if (codcarre != null) {
			queryString.append(" e.carrera.codCarre = ?0 ");

		}
		
		
		if (idmodelo != 0) {
			queryString.append(" and e.modeloAcreditacion.id = ?1 ");

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
			queryString.append(" and e.modeloAcreditacion.idPerfilEncargado = ?5 ");

		}

		if (idPerfilvalida != 0) {
			queryString.append(" and e.modeloAcreditacion.idPefilValidaFirma = ?6 ");

		}

		if (idPerfilvarifica != 0) {
			queryString.append(" and e.modeloAcreditacion.idPerfilVerifica = ?7 ");

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

}
